package edu.deakin.sit218.examgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DumpController {
	@GetMapping("/csrf")
	public String showCSRF() {
		return "csrf";
	}
	@GetMapping("/lfi")
	public String showLFI() {
		return "lfi";
	}
	@GetMapping("/ssrf")
	public String showSSRF() {
		return "ssrf";
	}
}
