package com.example.testconstructor.TestConstructorResponse;

import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/createTest")
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

	@RequestMapping(method = RequestMethod.POST)
	public String createTest(@RequestBody TestConstructorResponse testConstructorResponse) {
		Long testId = testService.createTest(testConstructorResponse.testName);
		questionService.createQuestionList(testConstructorResponse.questions, testId);
		return urlService.generateUrl(testId);
	}
}
