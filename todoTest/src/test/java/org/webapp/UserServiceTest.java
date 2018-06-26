package org.webapp;

import org.junit.Test;
import org.webapp.dao.User;
import org.webapp.dao.UserService;

public class UserServiceTest {
	
	
	@Test
	public void joinTest(){
		User user = new User();
		
		user.setId("admin12");
		user.setName("admin12");
		user.setPassword("admin12");
		
		UserService service = new UserService();
		
		service.saveUser(user);
	}
}
