package com.example.testconstructor.Question;

import com.example.testconstructor.Answer.Answer;
import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.TestConstructorResponse.QuestionResponse;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestRepository;
import com.example.testconstructor.TestShowerResponse.AnswersShowerResponse;
import com.example.testconstructor.TestShowerResponse.QuestionsShowerResponse;
import com.example.testconstructor.TestShowerResponse.TestResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	private final AnswerService answerService;
	Random random = new Random();

	public QuestionService(QuestionRepository questionRepository, AnswerService answerService) {
		this.questionRepository = questionRepository;
		this.answerService = answerService;
	}

	public void createQuestionList(List<QuestionResponse> questions, Long testId) {
		for (int i = 0; i < questions.size(); i++) {
			Long questionId = createQuestion(questions.get(i).questionName, testId);
			answerService.createAnswerList(questions, questionId);
		}
	}

	public Long createQuestion(String questionName, Long testId) {
		return questionRepository.save(new Question((long) random.nextInt(92233720), testId, questionName)).questionId;
	}

	public TestResponse showTest(Test test) {
		List<Question> allQuestions = findAllQuestions();
		List<Answer> allAnswers = answerService.findAllAnswers();
		List<QuestionsShowerResponse> questionsShowerResponses = new ArrayList<>();

		for (int i = 0; i < allQuestions.size(); i++) {
			if (Objects.equals(allQuestions.get(i).testId, test.getTestId())) {
				Question question = allQuestions.get(i);
				List<AnswersShowerResponse> answersShowerResponses = new ArrayList<>();
				for (int y = 0; y < allAnswers.size(); y++) {
					if (Objects.equals(allAnswers.get(y).getQuestionId(), question.questionId)) {
						Answer answer = allAnswers.get(y);
						answersShowerResponses.add(
							new AnswersShowerResponse(answer.getAnswerName(), answer.getIsCorrectAnswer()));
					}
				}
				questionsShowerResponses.add(new QuestionsShowerResponse(question.questionName, answersShowerResponses));
			}
		}

		return new TestResponse(test.getTestName(), questionsShowerResponses);
	}

	public String checkTest(Test test, TestResponse testResponse) {

		TestResponse correctTestResponse = showTest(test);
		int countFalseAnswers = 0;
		for(int i = 0; i < testResponse.questions.size(); i++){
			for(int y = 0; y < testResponse.questions.get(i).answers.size(); y++){
				if(testResponse.questions.get(i).answers.get(y).isRightAnswer
					!= correctTestResponse.questions.get(i).answers.get(y).isRightAnswer)
					countFalseAnswers++;
					break;
			}
		}
		return "Вы правильно ответили на " + (testResponse.questions.size() - countFalseAnswers) + " вопросов из " + testResponse.questions.size();
	}

	public List<Question> findAllQuestions() {
		return questionRepository.findAll();
	}

}
