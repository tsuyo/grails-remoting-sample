package com.github.tsuyo.gremoting.service

class RemotingService {
	static remote = [
        protocol: 'rmi',
        iface: com.github.tsuyo.gremoting.common.IRemotingService,
        // host: 'localhost',
        // port: '8080',
        webcontext: 'grails-remoting-server'
    ]
}
