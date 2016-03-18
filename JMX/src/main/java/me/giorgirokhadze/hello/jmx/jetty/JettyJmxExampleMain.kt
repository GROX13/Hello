package me.giorgirokhadze.hello.jmx.jetty

import org.eclipse.jetty.jmx.MBeanContainer
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.util.log.Log
import org.eclipse.jetty.webapp.WebAppContext

import java.lang.management.ManagementFactory

object JettyJmxExampleMain {

    @Throws(Exception::class)
    @JvmStatic fun main(args: Array<String>) {
        // 1. Creating the server on port 8080
        val server = Server(8080)

        // 2. Creating the WebAppContext for the created content
        val ctx = WebAppContext()
        ctx.resourceBase = "src/main/webapp"
        server.handler = ctx

        // 3. CreatingManaged Managed Bean container
        val mbContainer = MBeanContainer(ManagementFactory.getPlatformMBeanServer())

        // 4. Adding Managed Bean container to the server as an Event Listener  and Bean
        server.addEventListener(mbContainer)
        server.addBean(mbContainer)
        server.addBean(JCGManagedObject());
        
        // 5. Adding Log
        server.addBean(Log.getLog())
        // 6. Starting the Server
        server.start()
        server.join()
    }
    
}


