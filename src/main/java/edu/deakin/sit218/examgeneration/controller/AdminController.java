package edu.deakin.sit218.examgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	@GetMapping("/fileUpload")
	public String showFile() {
		return "fileUpload";
	}
}