import me.giorgirokhadze.parser.twino.TwinoLogParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	private static Logger logger = LoggerFactory.getLogger("logentries");

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(new File("/home/giorgi/IdeaProjects/Hello/Logentries/src/main/resources/Java-Log_2016-03-24_112609_2016-03-24_114609.log")))) {
			String line;
			int index = 0;
			while ((line = br.readLine()) != null) {
				line = line.substring(0, line.length() - 1);
				// line = line.replaceAll("[\u0000-\u001f]", "");
				logger.info(line);
				logger.info(TwinoLogParser.instance().parse(line).toJSONString());
				// TwinoLogParser.instance().parse(line).toJSONString();
				if (index == 12) {
					break;
				}
				index++;
			}

			//noinspection ResultOfMethodCallIgnored
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}