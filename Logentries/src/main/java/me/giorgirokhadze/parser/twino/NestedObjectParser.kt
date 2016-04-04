package me.giorgirokhadze.parser.twino

import me.giorgirokhadze.parser.Parser
import org.json.simple.JSONObject

internal class NestedObjectParser : Parser {

    override fun parse(line: String): JSONObject {
        @Suppress("NAME_SHADOWING")
        var line = line
        val result = JSONObject()
        if (line.length > 0) {
            line = line.substring(1, line.length - 1)
            while (line.length > 0) {
                val key = line.substring(0, line.indexOf('='))
                val value: String
                if (line[line.indexOf('=') + 1] == '[') {
                    value = line.substring(line.indexOf('=') + 1, line.indexOf(']') + 1)
                    line = line.substring(line.indexOf(']') + 1)
                } else {
                    value = if (line.indexOf(',') < 0) line.substring(line.indexOf('=') + 1, line.length) else line.substring(line.indexOf('=') + 1, line.indexOf(','))
                    line = if (line.indexOf(',') == -1) "" else line.substring(line.indexOf(',') + 1)
                }
                //noinspection unchecked
                result.put(key, if (value == "<null>") null else value)

            }
        }
        return result
    }

}
