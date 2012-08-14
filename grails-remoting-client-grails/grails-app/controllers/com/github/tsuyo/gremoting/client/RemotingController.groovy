package com.github.tsuyo.gremoting.client

import com.github.tsuyo.gremoting.common.RemotingObject

/**
 * TODO: There seems like a bug in remoting-plugin.
 * Just after run-app, remotingService.remote doesn't work correctly.
 * Force reloading (e.g. touch RemotingService.groovy) in dev can avoid
 * this issue. Need to check RemotingGrailsPlugin.groovy
 */
class RemotingController {

    def remotingService

    def index() {
        def ro = new RemotingObject(params.id as long, params.protocol)
        RemotingObject response = remotingService.remotingMethod(ro)
        render response.toString()
    }

}
