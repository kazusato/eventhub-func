package dev.kazusato.azfunc.msgproc

import org.springframework.stereotype.Service
import java.util.function.Function

@Service("MsgProc")
class MyMsgProc2 : Function<MsgReq, MsgResp> {

	override fun apply(req: MsgReq): MsgResp {
		return MsgResp("Hello, ${req.text}")
	}

}