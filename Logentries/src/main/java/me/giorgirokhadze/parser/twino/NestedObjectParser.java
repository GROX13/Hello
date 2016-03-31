package me.giorgirokhadze.parser.twino;

import me.giorgirokhadze.parser.Parser;
import org.json.simple.JSONObject;

class NestedObjectParser implements Parser {

	@SuppressWarnings("unchecked")
	public JSONObject parse(String log) {
		JSONObject res = new JSONObject();
		log = log.substring(1, log.length() - 1);
		if (log.length() > 0) {
			String[] split = log.split(",");
			for (String entry : split) {
				String[] temp = entry.split("=");
				String val = null;
				if (!temp[1].equals("<null>"))
					val = temp[1];
				res.put(temp[0], val);
			}
		}
		return res;
	}

}
