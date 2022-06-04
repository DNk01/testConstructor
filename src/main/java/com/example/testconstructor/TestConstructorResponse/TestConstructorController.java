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
	private final QuestionService questionService;
	private final UrlService urlService;

	@Autowired
	public TestConstructorController(TestService testService,
									 QuestionService questionService,
									 UrlService urlService) {
		this.testService = testService;
		this.questionService = questionService;
		this.urlService = urlService;
	}

	@PostMapping("")
	public String createTest(@RequestBody TestRequest testRequest) {
		Long testId = testService.createTest(testRequest.testName);
		questionService.createQuestionList(testRequest.questions, testId);
		return testId.toString();
	}
}
