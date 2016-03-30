package me.giorgirokhadze.parser;

import org.json.simple.JSONObject;

public interface Parser {

	JSONObject parse(String log);

}
