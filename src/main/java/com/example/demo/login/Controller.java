package com.example.demo.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.Result;
import com.example.demo.user.pojo.User;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@CrossOrigin
	@RequestMapping("/login")
	public Result login(@RequestBody User user) {
		Result result = new Result();
		String username = user.getUsername();
		String password = user.getPassword();
		if(!"admin".equals(username) || !"123456".equals(password)) {
			result.setCode(400);
		}else {
			result.setCode(200);
		}
		return result;
	}
}
