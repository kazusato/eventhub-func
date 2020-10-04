package dev.kazusato.azfunc.msgproc

import com.microsoft.azure.functions.*
import com.microsoft.azure.functions.annotation.*
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler
import java.util.*

class MsgProcHandler : AzureSpringBootRequestHandler<MsgReq, MsgResp>() {

//	@FunctionName("MsgProc")
//	fun exec(
//			@HttpTrigger(name = "req", methods = [HttpMethod.POST], authLevel = AuthorizationLevel.ANONYMOUS)
//			req: HttpRequestMessage<Optional<MsgReq>>,
//			ctx: ExecutionContext
//	): HttpResponseMessage {
//		ctx.logger.info("FUNCTION INPUT: ${req.body.get()}")
//
//		return req.createResponseBuilder(HttpStatus.OK)
//				.body(handleRequest(req.body.get(), ctx))
//				.header("Content-Type", "application/json")
//				.build()
//	}

	@FunctionName("MsgProc")
	fun exec2(
			@EventHubTrigger(name = "req", eventHubName = "testhub", connection = "myconn",
					consumerGroup = "\$Default", cardinality = Cardinality.ONE)
			req: MsgReq,
			ctx: ExecutionContext
	) {
		ctx.logger.info("FUNCTION INPUT: ${req}")
		val result = handleRequest(req, ctx)
		ctx.logger.info("RESULT: ${result}")
	}

}