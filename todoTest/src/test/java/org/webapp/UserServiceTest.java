package org.webapp;

import org.junit.Test;
import org.webapp.dao.User;
import org.webapp.dao.UserService;

public class UserServiceTest {
	
	
	@Test
	public void joinTest(){
		User user = new User();
		
		user.setId("admin11");
		user.setName("admin11");
		user.setPassword("admin11");
		
		UserService service = new UserService();
		
		service.saveUser(user);
	}
}
