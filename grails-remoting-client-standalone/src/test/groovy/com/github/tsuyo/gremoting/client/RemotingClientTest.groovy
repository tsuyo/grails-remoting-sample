package com.github.tsuyo.gremoting.client

//@Grab(group='org.springframework', module='spring-context', version='3.1.2.RELEASE')
import org.springframework.context.support.ClassPathXmlApplicationContext

import com.github.tsuyo.gremoting.common.IRemotingService
import com.github.tsuyo.gremoting.common.RemotingObject

import org.junit.Test
import org.junit.BeforeClass
import static org.junit.Assert.*

class RemotingClientTest {

    static def context

    @BeforeClass
    public static void setUp() {
    	context = new ClassPathXmlApplicationContext("remoting_client.xml")
    }

    @Test
    public void testRmi() {
    	def ro = new RemotingObject(1, 'rmi')
		def rmiService = context.getBean("rmiService")
		def serverRo = rmiService.remotingMethod(ro)
		assertEquals('id: 11, protocol: from server: rmi', serverRo.toString())
    }

    @Test
    public void testHessian() {
	    def ro = new RemotingObject(2, 'hessian')
		def hessianService = context.getBean("hessianService")
		def serverRo = hessianService.remotingMethod(ro)
		assertEquals('id: 12, protocol: from server: hessian', serverRo.toString())
    }

    @Test
    public void testBurlap() {
	    def ro = new RemotingObject(3, 'burlap')
		def burlapService = context.getBean("burlapService")
		def serverRo = burlapService.remotingMethod(ro)
		assertEquals('id: 13, protocol: from server: burlap', serverRo.toString())
    }

    @Test
    public void testHttpInvoker() {
	    def ro = new RemotingObject(4, 'httpInvoker')
		def httpInvokerService = context.getBean("httpInvokerService")
		def serverRo = httpInvokerService.remotingMethod(ro)
		assertEquals('id: 14, protocol: from server: httpInvoker', serverRo.toString())
    }

}