package dev.kazusato.azfunc.msgproc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsgProcFunction {
}

fun main(args: Array<String>) {
	runApplication<MsgProcFunction>(*args)
}