import org.slf4j.LoggerFactory

object HelloSLF4J {

    private val log = LoggerFactory.getLogger("logentries")

    @JvmStatic fun main(args: Array<String>) {

        val validJson =
                """ 
                {
                  "version": "2",
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
                           "band": "the dubliners",
                           "song": "finnegan's wake",
                           "members":[ 
                                     {"firstname":"Ronnie","lastname":"Drew"}, 
                                     {"firstname":"Luke","lastname":"Kelly"}, 
                                     {"firstname":"Ciaran","lastname":"Bourke"}, 
                                     {"firstname":"Barney","lastname":"McKenna"}
                           ]
                          }
                }
                """

        log.info(validJson)

        System.`in`.read()
    }

}
