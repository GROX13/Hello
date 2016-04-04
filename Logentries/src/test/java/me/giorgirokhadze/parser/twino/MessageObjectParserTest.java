package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class MessageObjectParserTest {

	private static Parser parser;

	@BeforeClass
	public static void initialize() {
		parser = new MessageObjectParser();
	}

	@Test
	public void parseTestCaseOne() {
		String message = "Client{id=517264} can apply result: HAS_RECENT_BLACKLISTED_APPLICATION";
		JSONObject expected = new JSONObject(), actual = parser.parse(message);
		expected.put("message", message);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseTwo() {
		String message = "received personalId: 41001011343 payment with identifier: 21408256";
		JSONObject expected = new JSONObject(), actual = parser.parse(message);
		expected.put("message", message);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseThree() {
		String message = "getting loan payment info for personalId: 11001015924";
		JSONObject expected = new JSONObject(), actual = parser.parse(message);
		expected.put("message", message);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFour() {
		String message = "Caching System Configuration record with name: activity-configuration";
		JSONObject expected = new JSONObject(), actual = parser.parse(message);
		expected.put("message", message);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFive() {
		String message = "New visitor from affiliate: google-cpc-non-brand";
		JSONObject expected = new JSONObject(), actual = parser.parse(message);
		expected.put("message", message);
		assertEquals(expected, actual);
	}

}
