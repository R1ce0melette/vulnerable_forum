package edu.deakin.sit218.examgeneration.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamGenController {
	@GetMapping("/xss")
	public String showXSS() {
		return "xss";
	}

	@GetMapping("/postxss")
	public String doXSS(@RequestParam("payload") String payload, Model model) {
		model.addAttribute("payload", payload);
		return "xss";
	}
}