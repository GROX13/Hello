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
		log = log.substring(log.indexOf(":") + 2).replace(" ", "");

		if (log.contains("[")) {
			if (log.contains("--")) {
				parse.put("direction", log.substring(0, 3));
				if (log.charAt(log.length() - 1) == ']')
					parse.put(log.substring(3, log.indexOf("[")), new NestedObjectParser().parse(log.substring(log.indexOf("["))));
				else {
					parse.put("time", log.substring(log.lastIndexOf(']') + 1));
					parse.put(log.substring(3, log.indexOf("[")), new NestedObjectParser().parse(log.substring(log.indexOf("["), log.lastIndexOf("]") + 1)));
				}
			} else {
				if (!log.contains(":") || log.indexOf(":") > log.indexOf("[")) {
					parse.put(log.substring(0, log.indexOf("[")), new NestedObjectParser().parse(log.substring(log.indexOf("["))));
				} else {
					this.parse.put("data", new MessageObjectParser().parse(log));
				}
			}
		} else {
			this.parse.put("data", new MessageObjectParser().parse(log));
		}

		return this.parse;
	}

}
