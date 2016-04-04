package me.giorgirokhadze.parser.twino

import me.giorgirokhadze.parser.Parser
import org.json.simple.JSONObject

internal class MessageObjectParser : Parser {

    override fun parse(line: String): JSONObject {
        val result = JSONObject()
        result.put("message", line)
        return result
    }

}
