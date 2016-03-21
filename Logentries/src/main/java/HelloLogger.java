import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import java.io.IOException;

public class HelloLogger {
	private static Logger log = LogManager.getRootLogger();

	public static void main(String[] args) {
		log.debug("Debugging Message");
		log.info("Informational message");
		log.warn("Warning Message");
		try {
			System.out.println(new StringBuilder("Entered value: ").append(System.in.read()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
