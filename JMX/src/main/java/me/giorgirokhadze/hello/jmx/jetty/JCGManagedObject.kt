package me.giorgirokhadze.hello.jmx.jetty

import org.eclipse.jetty.util.annotation.ManagedAttribute
import org.eclipse.jetty.util.annotation.ManagedObject
import org.eclipse.jetty.util.annotation.ManagedOperation

@ManagedObject("jcgManagedObject")
class JCGManagedObject {

    @Suppress("unused")
    @ManagedAttribute
    fun getCount(): Int {
        return CounterSingleton.instance.counter;
    }

    @Suppress("unused")
    @ManagedOperation
    fun reset() {
        CounterSingleton.instance.reset();
    }

}