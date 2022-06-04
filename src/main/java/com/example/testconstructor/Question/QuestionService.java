package com.example.testconstructor.Question;

import com.example.testconstructor.Answer.AnswerRepository;
import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.FinishTest.FinishAnswerResponse;
import com.example.testconstructor.FinishTest.FinishQuestionResponse;
import com.example.testconstructor.FinishTest.FinishTestResponse;
import com.example.testconstructor.Test.TestRepository;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.TestShowerResponse.AnswersRequest;
import com.example.testconstructor.TestShowerResponse.QuestionsRequest;
import com.example.testconstructor.TestShowerResponse.TestRequest;
import com.example.testconstructor.Url.Url;
import com.example.testconstructor.Url.UrlService;
import liquibase.pro.packaged.F;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	private final TestRepository testRepository;
	private final AnswerService answerService;
	Random random = new Random();
	private final TestService testService;
	private final AnswerRepository answerRepository;
	private final UrlService urlService;

	public QuestionService(QuestionRepository questionRepository,
						   TestRepository testRepository,
						   AnswerService answerService,
						   TestService testService,
						   AnswerRepository answerRepository,
						   UrlService urlService) {
		this.questionRepository = questionRepository;
		this.testRepository = testRepository;
		this.answerService = answerService;
		this.testService = testService;
		this.answerRepository = answerRepository;
		this.urlService = urlService;
	}

	public void createQuestionList(List<QuestionsRequest> questions, Long testId) {
		for (int i = 0; i < questions.size(); i++) {
			Long questionId = createQuestion(questions.get(i).questionName, testId);
			answerService.createAnswerList(questions.get(i), questionId);
		}
	}

	public Long createQuestion(String questionName, Long testId) {
		return questionRepository.save(new Question((long) random.nextInt(92233720), testId, questionName)).questionId;
	}
	public List<String> userAnswers(QuestionsRequest questionsRequest){
		List<String> answersRequest = new ArrayList<>();
		for(int i = 0; i < questionsRequest.answers.size(); i++){
			if(questionsRequest.answers.get(i).isRightAnswer)
			answersRequest.add(questionsRequest.answers.get(i).answerName);
		}
		return answersRequest;
	}
	public String checkTest(TestRequest testResponse, String url) {
		Test test = testService.findTestById(urlService.parseUrl(url));
		List<Long> questionsIds = testRepository.findAllQuestions(test.getTestId());
		FinishTestResponse finishTestResponse = new FinishTestResponse();
		TestRequest correctTestResponse = testService.showTest(test);
		String total;
		boolean flag =false;
		List<String> questions = new ArrayList<>();
		int countFalseAnswers = 0;
		finishTestResponse.setTestName(testResponse.testName);
		for (int i = 0; i < testResponse.questions.size(); i++) {
			for (int y = 0; y < testResponse.questions.get(i).answers.size(); y++) {
				if (testResponse.questions.get(i).answers.get(y).isRightAnswer
					!= correctTestResponse.questions.get(i).answers.get(y).isRightAnswer){
					countFalseAnswers++;
					String sumQuestion = "\nВопрос №" + (i + 1) + ": " + testResponse.questions.get(i).questionName +
						" ответ неверный. Правильный ответ - " + answerRepository.showRightAnswers(questionsIds.get(i));
					String input = ", Ваш ответ: " + userAnswers(testResponse.questions.get(i));
					questions.add(sumQuestion + input);
					flag = true;
					break;
				}
			}
			if(!flag){
				String sumQuestion = "\nВопрос №" + (i + 1) + ": " + testResponse.questions.get(i).questionName +
					" ответ правильный";
				String input = ", Ваш ответ: " + userAnswers(testResponse.questions.get(i));
				questions.add(sumQuestion + input);
			}
			flag = false;
		}
		total = "Итого: Вы правильно ответили на " +
			(testResponse.questions.size() - countFalseAnswers) +
			" вопросов из " + testResponse.questions.size();
		return questions + "\n" + total ;
	}
}
