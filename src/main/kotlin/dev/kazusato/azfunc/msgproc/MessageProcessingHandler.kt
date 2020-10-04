package dev.kazusato.azfunc.msgproc

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler
import java.util.*

class MessageProcessingHandler : AzureSpringBootRequestHandler<String, Void>() {

	@FunctionName("MsgProc")
	fun exec(
			@HttpTrigger(name = "req", methods = [HttpMethod.POST], authLevel = AuthorizationLevel.ANONYMOUS)
			req: HttpRequestMessage<Optional<String>>,
			ctx: ExecutionContext
	): HttpResponseMessage {
		handleRequest(req.body.get(), ctx)
		return req.createResponseBuilder(HttpStatus.OK)
				.body("{\"message\": \"hello world\"}")
				.header("Content-Type", "application/json")
				.build()
	}

}