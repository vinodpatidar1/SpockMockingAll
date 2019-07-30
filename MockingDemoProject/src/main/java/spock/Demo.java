package spock;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

public class Demo {
	
	@Autowired
	public DAO dao;
	private String name;

	public String getName(HttpServletRequest request) {
		return request.getParameter("name");
	}
	
	public int saveUser(String name) {
		if(name!=null && !name.equalsIgnoreCase("")) {
			return dao.saveUser(name);
		}
		return 0;
	}
	
	public void setName(HttpServletRequest request) {
		name = request.getParameter("name");
	}
	
	public int getUserId(String name) {
		int id=0;
		if(isValid(name)) {
			id=getId(name);
		}
		return id;
	}

	public int getId(String name) {
		System.out.println("getting user id from db .......");
		return 10;
	}

	public boolean isValid(String name) {
		System.out.println("validating user name......");
		return false;
	}
	
	public void printAllParams(HttpServletRequest request) {
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("middleName"));
		System.out.println(request.getParameter("lastName"));
	}
}
