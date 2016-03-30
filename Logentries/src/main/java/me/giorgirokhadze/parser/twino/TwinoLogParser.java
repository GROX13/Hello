package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;

public class TwinoLogParser implements Parser {

	private static final Parser self = new TwinoLogParser();
	private final Parser headerParser;

	public static Parser instance() {
		return self;
	}

	private TwinoLogParser() {
		this.headerParser = new ParseHeader();
	}

	public JSONObject parse(String log) {
		return new ParseData(headerParser.parse(getHeader(log))).parse(getData(log));
	}

	private String getHeader(String log) {
		return log.split("---")[0];
	}

	private String getData(String log) {
		return log.split("---")[1];
	}

}

