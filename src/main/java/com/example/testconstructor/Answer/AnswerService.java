package com.example.testconstructor.Answer;


import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionRepository;
import com.example.testconstructor.TestConstructorResponse.AnswerResponse;
import com.example.testconstructor.TestConstructorResponse.QuestionResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    Random random = new Random();

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public void createAnswerList(List<QuestionResponse> questionResponses, Long testId) {
        for (QuestionResponse questionRespons : questionResponses) {
            for (int y = 0; y < questionRespons.answerResponse.size(); y++) {
                createAnswer(questionRespons.answerResponse.get(y), testId);
            }

        }
    }

    public void createAnswer(AnswerResponse answerResponse, Long testId) {
        answerRepository.save(new Answer(random.nextLong(), testId, answerResponse.answerName, answerResponse.isRightAnswer));
    }

    public void deleteAnswerById(Long answerId) {
        answerRepository.deleteById(answerId);
    }

    public List<Answer> findAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer updateAnswer(Long answerId, Long questionId, String answerName, Boolean isCorrectAnswer) {
        Answer answer = new Answer();
        answer.setAnswerId(answerId);
        answer.setQuestionId(questionId);
        answer.setAnswerName(answerName);
        answer.setIsCorrectAnswer(isCorrectAnswer);
        return answerRepository.save(answer);
    }

    public Question getQuestionByAnswerId(Long answerId) {

        Long question_id = answerRepository.findById(answerId).get().getQuestionId();
        return questionRepository.getById(question_id);
    }
}
