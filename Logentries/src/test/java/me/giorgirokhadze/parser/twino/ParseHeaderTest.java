package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class ParseHeaderTest {

	private static Parser parser;

	@BeforeClass
	public static void initialize() {
		parser = new ParseHeader();
	}

	@Test
	public void parseTestCaseOne() {
		String header = "2016-03-24 15:26:20.162  INFO 6543 [ApplicationScheduler_Worker-6]  ";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("dateTime", "2016-03-24 15:26:20.162");
		expected.put("level", "INFO");
		expected.put("thread", "ApplicationScheduler_Worker-6");
		expected.put("pid", "6543");

		actual = parser.parse(header);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseTwo() {
		String header = "2016-03-24 15:26:20.285  INFO 6543 [http-nio-8080-exec-45]   ";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("dateTime", "2016-03-24 15:26:20.285");
		expected.put("level", "INFO");
		expected.put("thread", "http-nio-8080-exec-45");
		expected.put("pid", "6543");

		actual = parser.parse(header);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseThree() {
		String header = "2016-03-24 15:26:21.677  INFO 6543 [http-nio-8080-exec-43] cid:106513";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("dateTime", "2016-03-24 15:26:21.677");
		expected.put("level", "INFO");
		expected.put("thread", "http-nio-8080-exec-43");
		expected.put("cid", "106513");
		expected.put("pid", "6543");

		actual = parser.parse(header);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFour() {
		String header = "2016-03-24 15:26:22.346  INFO 6543 [http-nio-8080-exec-43] cid:106513";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("dateTime", "2016-03-24 15:26:22.346");
		expected.put("level", "INFO");
		expected.put("thread", "http-nio-8080-exec-43");
		expected.put("pid", "6543");
		expected.put("cid", "106513");

		actual = parser.parse(header);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFive() {
		String header = "2016-03-24 15:26:35.453  INFO 6543 [http-nio-8080-exec-48]  ";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("dateTime", "2016-03-24 15:26:35.453");
		expected.put("level", "INFO");
		expected.put("thread", "http-nio-8080-exec-48");
		expected.put("pid", "6543");

		actual = parser.parse(header);
		assertEquals(expected, actual);
	}

}
