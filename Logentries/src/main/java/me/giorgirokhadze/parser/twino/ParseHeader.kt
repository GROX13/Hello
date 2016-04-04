package me.giorgirokhadze.parser.twino

import me.giorgirokhadze.parser.Parser
import org.json.simple.JSONObject

internal class ParseHeader : Parser {

    @SuppressWarnings("unchecked")
    override fun parse(line: String): JSONObject {
        val data = line.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val jsonObject = JSONObject()
        if (data.size == 7)
            jsonObject.put("cid", data[6].split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1])
        jsonObject.put("dateTime", data[0] + " " + data[1])
        jsonObject.put("level", data[3])
        jsonObject.put("pid", data[4])
        jsonObject.put("thread", data[5].substring(1, data[5].length - 1))
        return jsonObject
    }

}
