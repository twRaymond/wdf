package com.wdf.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@RequestMapping(value = "/index.doInit", method = RequestMethod.GET)
	public String doInit(HttpServletRequest request, Model model) {
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		System.out.println("ipAddress:" + ipAddress);
		model.addAttribute("ipAddress", ipAddress);
		return "index";
	}
}
