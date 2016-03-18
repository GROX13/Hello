package me.giorgirokhadze.hello.jmx.jetty

class CounterSingleton private constructor() {

    var counter: Int = 0
        private set

    init {
        counter = 0
    }

    @Synchronized fun increment() {
        counter++
    }

    @Synchronized fun reset() {
        counter = 0
    }

    companion object {

        val instance = CounterSingleton()
        
    }

}

