import org.json.simple.JSONObject
import org.slf4j.LoggerFactory

object HelloSLF4J {

    private val log = LoggerFactory.getLogger("logentries")

    @JvmStatic fun main(args: Array<String>) {
        
        var obj = JSONObject()
        var curr = JSONObject()
        var next = JSONObject()
        
        val validJson =
                """ 
                {
                  "volume": "blaring",
                  "current": {
                               "band": "rednex",
                               "song": "cotton eye joe",
                               "members":[ 
                                         {"firstname":"Kent","lastname":"Olander"}, 
                                         {"firstname":"Urban","lastname":"Landgren"}, 
                                         {"firstname":"Jonas","lastname":"Lundstrom"}, 
                                         {"firstname":"Tor","lastname":"Nilsson"}
                               ]
                              }, 
                  "next": {
                           "band":"the dubliners",
                           "song":"finnegan's wake",
                           "members":[ 
                                     {"firstname":"Ronnie","lastname":"Drew"}, 
                                     {"firstname":"Luke","lastname":"Kelly"}, 
                                     {"firstname":"Ciaran","lastname":"Bourke"}, 
                                     {"firstname":"Barney","lastname":"McKenna"}
                           ]
                          }
                }
                """
        
        
        
        obj.put("volume", "blaring")
        
        curr.put("band", "rednex")
        curr.put("song", "cotton eye joe")
        
        next.put("band","the dubliners")
        next.put("song","finnegan's wake")
        
        obj.put("current", curr)
        obj.put("next", next)
        log.info(obj.toJSONString())

        System.`in`.read()
    }

}
