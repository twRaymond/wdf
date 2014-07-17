package com.wdf.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	public final static String LOGIN_PAGE = "/login/login";

	@RequestMapping(value = "/login.on", method = RequestMethod.GET)
	public String on(HttpServletRequest request, Model model) {
		System.out.println("session id is : ".concat(request.getSession().getId()));
		System.out.println("Account is : ");
		System.out.println("Account Password is : ".concat(request.getSession().getId()));
		return LOGIN_PAGE;
	}
	
	@RequestMapping(value = "/login.off", method = RequestMethod.GET)
	public String off(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate();
		return LOGIN_PAGE;
	}
}
