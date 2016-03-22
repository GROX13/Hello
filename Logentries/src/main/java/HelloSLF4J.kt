import org.slf4j.LoggerFactory

object HelloSLF4J {

    private val log = LoggerFactory.getLogger("logentries")

    @JvmStatic fun main(args: Array<String>) {
        
        
        log.info("[{\"hello\": \"logger!\"}, {\"hello\": \"logger!\"}, {\"hello\": \"logger!\"}]")

        System.`in`.read()
    }

}
