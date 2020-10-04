package dev.kazusato.azfunc.msgproc

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.AuthorizationLevel
import com.microsoft.azure.functions.annotation.FunctionName
import com.microsoft.azure.functions.annotation.HttpTrigger
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler
import java.util.*

class MsgProcHandler : AzureSpringBootRequestHandler<MsgReq, MsgResp>() {

	@FunctionName("MsgProc")
	fun exec(
			@HttpTrigger(name = "req", methods = [HttpMethod.POST], authLevel = AuthorizationLevel.ANONYMOUS)
			req: HttpRequestMessage<Optional<MsgReq>>,
			ctx: ExecutionContext
	): HttpResponseMessage {
		ctx.logger.info("FUNCTION INPUT: ${req.body.get()}")

		return req.createResponseBuilder(HttpStatus.OK)
				.body(handleRequest(req.body.get(), ctx))
				.header("Content-Type", "application/json")
				.build()
	}

}