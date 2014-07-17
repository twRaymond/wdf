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

	@RequestMapping(value = "/captcha.process", method = RequestMethod.GET)
	public String process(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		response.setContentType("image/jpeg");
		response.setHeader("Cache-Control", "nocache");
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(service.saveImg());
		// <option value="image/bmp">BMP</option>
		// <option value="image/gif">GIF</option>
		// <option value="image/jpeg">JPEG</option>
		return null;
	}

}
