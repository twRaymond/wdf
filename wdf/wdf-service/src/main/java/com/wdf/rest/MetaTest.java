package com.wdf.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wdf.common.model.Users;

@RestController
public class MetaTest {
	@RequestMapping(value = "/user/obj/json", method = RequestMethod.GET)
	public Users view(String accountId) {
		Users user = new Users();
		user.setAccountId(accountId);
		return user;
	}

	@RequestMapping("/user/str/json")
	public String view2(String accountId) {
		return "{\"accountId\" : ".concat(accountId).concat("}");
	}
}
