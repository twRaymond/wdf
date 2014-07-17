package com.wdf.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wdf.service.CaptchaService;

@Controller
public class CaptchaController {

	@Autowired
	CaptchaService service;

	@RequestMapping(value = "/captcha.doInit", method = RequestMethod.GET)
	public String doInit(HttpServletRequest request, Model model) {
		return "captcha/index";
	}

	@RequestMapping(value = "/captcha.reCaptcha", method = RequestMethod.GET)
	public String reCaptcha(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(service.saveImg());
		return null;
	}
	
	@RequestMapping(value = "/captcha.process", method = RequestMethod.GET)
	public String process(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(service.doGray(request.getParameter("tmpCapId")));
		return null;
	}
}
