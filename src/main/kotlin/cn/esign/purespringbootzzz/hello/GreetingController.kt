package cn.esign.purespringbootzzz.hello

import java.util.concurrent.atomic.AtomicLong
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress
import java.util.concurrent.TimeUnit

@RestController
class GreetingController {
    private val counter = AtomicLong()

    @RequestMapping("/greeting", method = [RequestMethod.GET, RequestMethod.POST])
    fun greeting(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        TimeUnit.MICROSECONDS.sleep(100)
        return Greeting(counter.incrementAndGet(), String.format(template, name))
    }

    companion object {
        private val template = "Hello, %s!"
    }
}