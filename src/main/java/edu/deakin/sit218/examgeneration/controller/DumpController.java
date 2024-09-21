package edu.deakin.sit218.examgeneration.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import edu.deakin.sit218.examgeneration.entity.*;

@Controller
public class DumpController {
	private final Path localFileStorage = Paths.get("/var/www/html");

	@GetMapping("/csrf")
	public String showCSRF() {
		return "csrf";
	}

	@GetMapping("/docsrf")
	public String doCSRF(@RequestParam("input") String input, Model model) {
		UserDAO userdao = new UserDAOImpl();
		User tempu = userdao.retrieveUserByID(1);
		tempu.setSecret(input);
		userdao.updateUser(tempu);
		tempu = userdao.retrieveUserByID(1);
		model.addAttribute("secret2", tempu.toString());
		return "csrf";
	}

	@GetMapping("/DA")
	public String showLFI() {
		return "DA";
	}

	@GetMapping("/doDA")
	public String doDA(@RequestParam("username") String username, Model model) {
		UserDAO userdao = new UserDAOImpl();
		model.addAttribute("username",userdao.retrieveUser(username));
		return "outDA";
	}

	@GetMapping("/ssrf")
	public String showSSRF() {
		return "ssrf";
	}

	@GetMapping("/dossrf")
	public String doSSRF(@RequestParam("url") String url, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		try {
			// Fetching from external URL (SSRF vulnerability)
			ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
			model.addAttribute("response", response.getBody());
			return "ssrf";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "access-denied";
		}
	}
}
