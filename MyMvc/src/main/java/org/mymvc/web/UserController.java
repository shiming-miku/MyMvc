package org.mymvc.web;

import org.mymvc.model.User;
import org.mymvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private final Logger log=LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String list(Model model){
		User user=userService.selectByPrimaryKey(1000L);
		model.addAttribute("user", user);
		return "userlist";
	}
}
