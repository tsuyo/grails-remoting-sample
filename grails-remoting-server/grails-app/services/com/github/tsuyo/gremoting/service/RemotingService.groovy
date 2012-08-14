package com.github.tsuyo.gremoting.service

import com.github.tsuyo.gremoting.common.IRemotingService
import com.github.tsuyo.gremoting.common.RemotingObject

class RemotingService implements IRemotingService {
	static expose = ['rmi', 'hessian', 'burlap', 'httpinvoker']

	@Override
	RemotingObject remotingMethod(RemotingObject remotingObject) {
		println "[TM] ${remotingObject}"
		return new RemotingObject(remotingObject.id + 10,
			"from server: ${remotingObject.protocol}")
	}

}
