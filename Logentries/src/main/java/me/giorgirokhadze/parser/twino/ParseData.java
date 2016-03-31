package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
class ParseData implements Parser {

	private final JSONObject parse;

	ParseData(JSONObject parse) {
		this.parse = parse;
	}

	@SuppressWarnings({"Since15", "ResultOfMethodCallIgnored", "ConfusingArgumentToVarargsMethod"})
	public JSONObject parse(String log) {
		this.parse.put("class", log.substring(0, log.indexOf(":")).replace(" ", ""));
		log = log.substring(log.indexOf(":") + 2);
		if (log.contains("[")) {
			String[] logLine = log.split(" ");
			this.parse.put("direction", logLine[0]);
			this.parse.put("time", logLine[logLine.length - 1]);
			logLine[0] = "";
			logLine[logLine.length - 1] = "";
			log = String.join("", logLine);			
			this.parse.put(log.substring(0, log.indexOf("[")), new NestedObjectParser().parse(log.substring(log.indexOf("["))));
		} else {
			this.parse.put("todo",new MessageObjectParser().parse(""));
		}
		return this.parse;
	}

}
