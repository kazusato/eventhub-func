package dev.kazusato.azfunc.msgproc

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.function.Consumer

@Service
class MsgProc : Consumer<String> {

	companion object {
		private val logger: Logger = LoggerFactory.getLogger(this::class.java.enclosingClass)
	}

	override fun accept(msg: String) {
		logger.info("======== HELLO WORLD ========")
	}

}