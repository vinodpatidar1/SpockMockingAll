package spock

import javax.servlet.http.HttpServletRequest

import spock.lang.Shared
import spock.lang.Specification

/**
 * @author Krupali Panchal
 */
class DemoSpec extends Specification{

	@Shared Demo demo=new Demo()
	@Shared DAO dao
	
	def setup() {
		dao=Stub()
		demo.dao=dao
	}
	
	def'API to get name'(){
		given: 'Http Servlet Request object'
			HttpServletRequest request=Stub()
			request.getParameter("name") >> "test"
		when: 'demo.getName is called'
			String retVal=demo.getName(request)
		then: 'It should return name'
			retVal=='test'
	}

	def'API to save user'(){
		given: 'name'
			String name="abc"
		when: 'demo.saveUser is called'
			dao.saveUser(_) >> 5
			int retVal=demo.saveUser(name)
		then: 'It should return user id'
			retVal==5
	}
	
	def'API to set name'(){
		given: 'Http Servlet Request object'
			HttpServletRequest request=Mock()
		when: 'demo.getName is called'
			demo.setName(request)
		then: 'It should return name'
			1 * request.getParameter("name") >> "test"
	}
	
	def'API to set name -negative'(){
		given: 'Http Servlet Request object'
			HttpServletRequest request=Stub()
			request.getParameter("name") >> {
				throw new Exception()
			}
		when: 'demo.getName is called'
			demo.setName(request)
		then: 'It should thorw an exception'
			thrown(Exception)
	}
	
	def'API to get user id'(){
		given: 'user name'
			def demoSpy= Spy(Demo.class)
			demoSpy.isValid(_) >> true
			demoSpy.getId(_) >> 3
			String name="test"
		when: 'demo.getUserId is called'
			int id=demoSpy.getUserId(name)
		then: 'It should return id'
			id==3
	}
	
	def'API to print all params'(){
		given: 'Http Servlet Request object'
			HttpServletRequest request=Stub()
			request.getParameter(_) >>> ["First Name","Middle Name","Last Name"]
		when: 'demo.getUserId is called'
			demo.printAllParams(request)
		then: 'It should not throw an exception'
			notThrown(Exception)
	}
	
}
