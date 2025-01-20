package app.birdlist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CharacterController {
	


    @GetMapping("/")
	String MainPage() {


		return "home.html";
	}
}
