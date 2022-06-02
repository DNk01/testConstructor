package com.example.testconstructor.TestShowerResponse;


import com.example.testconstructor.Answer.Answer;
import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.TestConstructorResponse.TestConstructorResponse;
import com.example.testconstructor.Url.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/passageTest")
public class TestShowerController {

	private final TestService testService;
	private final QuestionService questionService;
	private final UrlService urlService;

	@Autowired
	public TestShowerController(TestService testService,
								QuestionService questionService,
								UrlService urlService) {
		this.testService = testService;
		this.questionService = questionService;
		this.urlService = urlService;
	}

	@GetMapping("{url}")
	public TestResponse showTest(HttpServletResponse response, @PathVariable("url") String url) {
		changeCorsPolicy(response);
		Test test = testService.findTestById(urlService.parseUrl(url));
		return questionService.showTest(test);
	}

	@PostMapping("{url}")
	public String finishTest(HttpServletResponse response,
							 @PathVariable("url") String url,
							 @RequestBody TestResponse testResponse) {
		changeCorsPolicy(response);
		Test test = testService.findTestById(urlService.parseUrl(url));
		return questionService.checkTest(test, testResponse);
	}

	private void changeCorsPolicy(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
	}
}