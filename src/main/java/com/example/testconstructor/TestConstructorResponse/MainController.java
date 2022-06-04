package com.example.testconstructor.TestConstructorResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@GetMapping
	public String mainPage(){
		return "index";
	}

	@GetMapping("/{id}")
	public String passage(@PathVariable long id){
		return "index";
	}

	@GetMapping("/create")
	public String create(){
		return "index";
	}
}