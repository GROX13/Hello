package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class ParseDataTest {

	private static Parser parser;

	@Before
	public void prepare() {
		parser = new ParseData(new JSONObject());
	}

	@Test
	public void parseTestCaseOne() {

	}

}
