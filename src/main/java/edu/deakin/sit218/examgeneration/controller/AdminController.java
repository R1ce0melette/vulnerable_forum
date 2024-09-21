package edu.deakin.sit218.examgeneration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class AdminController {
	private static final String UPLOAD_DIR = "/var/www/html/uploads/";

	@GetMapping("/fileUpload")
	public String showFile() {
		return "fileUpload";
	}

	@PostMapping("/fileUpload")
	public String doFile(@RequestParam("file") MultipartFile file, Model model) {
//		if (file.isEmpty()) {
//			model.addAttribute("message", "Failed to upload. The file was empty.");
//			return "fileUpload";
//		}
//		try {
//            // Save the file to a public directory (VULNERABILITY: No validation of file types or content)
//            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
//            Files.write(path, file.getBytes());
//
//            // Return the link to access the uploaded file
//            String fileUrl = "/uploads/" + file.getOriginalFilename();
//            model.addAttribute("message", "File uploaded successfully. File URL: " + fileUrl);
//            return "fileUpload";
//        } catch (IOException e) {
//            model.addAttribute("message", "Failed to upload file: " + e.getMessage());
//            return "fileUpload";
//        }
		model.addAttribute("message", "Upload endpoint reached.");
		return "fileUpload"; // Ensure you have a corresponding view
	}
}