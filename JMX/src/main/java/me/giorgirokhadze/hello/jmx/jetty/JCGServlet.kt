package me.giorgirokhadze.hello.jmx.jetty

import java.io.IOException
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServlet


class JCGServlet : HttpServlet() {
	
    @Throws(ServletException::class, IOException::class)
    override fun service(req: ServletRequest, res: ServletResponse) {

        CounterSingleton.instance.increment()

        res.outputStream.print("Application Specific Servlet Response")

    }

}
