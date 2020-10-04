package dev.kazusato.azfunc.msgproc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MessageProcessingFunction {
}

fun main(args: Array<String>) {
	runApplication<MessageProcessingFunction>(*args)
}