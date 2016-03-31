package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;

class ParseHeader implements Parser {

	@SuppressWarnings("unchecked")
	public JSONObject parse(String log) {
		String[] data = log.split(" ");
		JSONObject jsonObject = new JSONObject();
		if (data.length == 7)
			jsonObject.put("cid", data[6].split(":")[1]);
		jsonObject.put("dateTime", data[0].concat(" ").concat(data[1]));
		jsonObject.put("level", data[3]);
		jsonObject.put("pId", data[4]);
		jsonObject.put("thread", data[5].substring(1, data[5].length() - 1));
		return jsonObject;
	}

}
