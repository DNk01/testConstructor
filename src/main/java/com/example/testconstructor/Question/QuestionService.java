package com.example.testconstructor.Question;

import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.TestShowerResponse.QuestionsRequest;
import com.example.testconstructor.TestShowerResponse.TestRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	private final AnswerService answerService;
	Random random = new Random();
	private final TestService testService;

	public QuestionService(QuestionRepository questionRepository, AnswerService answerService, TestService testService) {
		this.questionRepository = questionRepository;
		this.answerService = answerService;
		this.testService = testService;
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

	public String checkTest(Test test, TestRequest testResponse) {

		TestRequest correctTestResponse = testService.showTest(test);
		int countFalseAnswers = 0;
		for (int i = 0; i < testResponse.questions.size(); i++) {
			for (int y = 0; y < testResponse.questions.get(i).answers.size(); y++) {
				if (testResponse.questions.get(i).answers.get(y).isRightAnswer
					!= correctTestResponse.questions.get(i).answers.get(y).isRightAnswer){
					countFalseAnswers++;
					break;
				}
			}
		}
		return "Вы правильно ответили на " + (testResponse.questions.size() - countFalseAnswers) + " вопросов из " + testResponse.questions.size();
	}


}
