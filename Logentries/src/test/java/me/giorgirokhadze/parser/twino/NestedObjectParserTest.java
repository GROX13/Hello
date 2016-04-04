package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("unchecked")
public class NestedObjectParserTest {

	private static Parser parser;

	@BeforeClass
	public static void initialize() {
		parser = new NestedObjectParser();
	}

	@Test
	public void parseTestCaseOne() {
		String data = "[clientId=435538,askedTerm=30 DAYS,askedAmount=1000,applicationType=WEB,when=2016-03-24T15:26:18.615,brokerPartnerName=<null>]";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("clientId", "435538");
		expected.put("askedTerm", "30 DAYS");
		expected.put("askedAmount", "1000");
		expected.put("applicationType", "WEB");
		expected.put("when", "2016-03-24T15:26:18.615");
		expected.put("brokerPartnerName", null);
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseTwo() {
		String data = "[application=LoanApplication{id=1209588},when=2016-03-24T15:26:18.615,oldState=CONFIRMED]";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("application", "LoanApplication{id=1209588}");
		expected.put("when", "2016-03-24T15:26:18.615");
		expected.put("oldState", "CONFIRMED");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseThree() {
		String data = "[application=LoanApplication{id=1209589}]";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("application", "LoanApplication{id=1209589}");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

	@Test
	public void parseTestCaseFour() {
		String data = "[providerName=personalIdBlacklist,personalId=01001011891,providerResponse=[provider: personalIdBlacklist, runSuccess: true, runEntryId: 1523805]]";
		JSONObject expected, actual;
		expected = new JSONObject();
		expected.put("providerName", "personalIdBlacklist");
		expected.put("personalId", "01001011891");
		expected.put("providerResponse", "[provider: personalIdBlacklist, runSuccess: true, runEntryId: 1523805]");
		actual = parser.parse(data);
		assertEquals(expected, actual);
	}

}
