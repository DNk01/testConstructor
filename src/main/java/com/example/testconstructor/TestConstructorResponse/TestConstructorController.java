package com.example.testconstructor.TestConstructorResponse;

import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.TestShowerResponse.TestRequest;
import com.example.testconstructor.Url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/createTest")
public class TestConstructorController {

	private final TestService testService;

	@Autowired
	public TestConstructorController(TestService testService) {
		this.testService = testService;
	}

	@PostMapping("")
	public String createTest(@RequestBody TestRequest testRequest) {
		return testService.createTest(testRequest).toString();
	}
}
