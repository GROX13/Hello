import me.giorgirokhadze.parser.twino.TwinoLogParser;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class Main {

	private static Logger logger = LoggerFactory.getLogger("logentries");

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("/home/giorgi/IdeaProjects/Hello/Logentries/src/main/resources/Java-Log_2016-03-24_112609_2016-03-24_114609.log")))) {
			String line;
			int index = 0;
			while ((line = br.readLine()) != null) {
				if (StringUtils.countMatches(line, "[") > 1 && line.contains("Event ")) {
					// process the line.

					logger.info(line);
					logger.info(TwinoLogParser.instance().parse(line).toJSONString());
					if (index == 10) {
						break;
					}
					index++;
				}
			}

			//noinspection ResultOfMethodCallIgnored
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}