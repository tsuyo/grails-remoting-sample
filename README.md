Grails Remoting Sample
======================

This is an umbrella sample application for remoting protocols on grails.
This consists of the following 4 projects and expected to be built/run in order.

1. grails-remoting-common
-------------------------

This includes a common interface and domain object among remoting server/client.

    $ cd grails-remoting-common
    $ gradle jar

2. grails-remoting-server
-------------------------

This is a grails remoting server which includes [Remoting Plugin][1].

    $ cd grails-remoting-server
    $ grails run-app

3. grails-remoting-client-standalone
------------------------------------

This is a standalone remoting client (spring application).
You can test to connect the grails-remoting-server by executing junit test.

    $ cd grails-remoting-client-standalone
    $ gradle test

After this junit test, you should be able to see the following logs
on grails-remoting-server console.

    [TM] id: 1, protocol: rmi
    [TM] id: 2, protocol: hessian
    [TM] id: 3, protocol: burlap
    [TM] id: 4, protocol: httpInvoker

4. grails-remoting-client-grails
--------------------------------

This is another remoting client to the grails-remoting-server,
but implemented by grails.

    $ cd grails-remoting-client-grails
    $ grails run-app

    # this causes a force reloading of the service class
    # and is a workaround for a remoting-plugin (1.2) bug
    $ touch grails-app/services/com/github/tsuyo/gremoting/service/RemotingService.groovy 

    $ curl "http://localhost:9090/grails-remoting-client-grails/remoting?id=1&protocol=rmi"
    id: 11, protocol: from server: rmi

Like standalone client, you should see the following log on the server's console.

    [TM] id: 1, protocol: rmi    

[1]: http://grails.org/plugin/remoting
