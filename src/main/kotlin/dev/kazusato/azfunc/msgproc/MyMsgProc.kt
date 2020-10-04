package dev.kazusato.azfunc.msgproc

import org.springframework.stereotype.Service
import java.util.function.Function

@Service
class MyMsgProc : Function<MsgReq, MsgResp> {

	override fun apply(req: MsgReq): MsgResp {
		return MsgResp("Welcome, ${req.text}")
	}

}