package com.omn.mpfactory.restfull.user;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.omn.mpfactory.model.User;

@Controller
@RequestMapping("/userController")
public class UserController {
	
	UserFacade userFacade;
	
	@RequestMapping(
			method = RequestMethod.GET, 
			value = "/userList")
	public ModelAndView getUsers() {
		List<User> userList = userFacade.findAll();
		return new ModelAndView("userList", "users", userList);
	}

	public void setUserFacade(UserFacade userFacade) {
		this.userFacade = userFacade;
	}

}
