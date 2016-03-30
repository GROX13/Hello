package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;

@SuppressWarnings("unchecked")
class ParseData implements Parser {

	private final JSONObject parse;

	ParseData(JSONObject parse) {
		this.parse = parse;
	}

	public JSONObject parse(String log) {
		this.parse.put("class", log.substring(log.indexOf(":")).replace(" ", ""));
		if (log.contains("[")) {
			
		} else {
			// TODO
		}
		return this.parse;
	}

}
