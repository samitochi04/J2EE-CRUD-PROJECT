package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@GetMapping
	public String getHome() {
		return "<html>" +
				"<head>" +
				"<style>" +
				"body { font-family: Arial, sans-serif; background-color: #f4f4f9; color: #333; text-align: center; padding: 20px; }" +
				"h1 { color: #2c3e50; margin-bottom: 20px; }" +
				".container { max-width: 600px; margin: auto; padding: 20px; background-color: #ffffff; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); border-radius: 8px; }" +
				"a { text-decoration: none; color: #3498db; font-weight: bold; }" +
				"a:hover { color: #2980b9; }" +
				".button { display: inline-block; margin: 10px 0; padding: 10px 15px; background-color: #3498db; color: #fff; border-radius: 5px; transition: background-color 0.3s; }" +
				".button:hover { background-color: #2980b9; }" +
				"</style>" +
				"</head>" +
				"<body>" +
				"<div class=\"container\">" +
				"<h1>Ceci est une page protégée uniquement pour les admins</h1>" +
				"<div><a href=\"/computers/populate\" class=\"button\">Populer</a></div>" +
				"<div><a href=\"/computer\" class=\"button\">Liste des utilisateurs</a></div>" +
				"</div>" +
				"</body>" +
				"</html>";
	}
}