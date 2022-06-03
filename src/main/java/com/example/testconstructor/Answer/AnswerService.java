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

    public void createAnswerList(QuestionResponse questionResponses, Long questionId) {
            for (int y = 0; y < questionResponses.answerResponse.size(); y++) {
                createAnswer(questionResponses.answerResponse.get(y), questionId);
            }

    }

    public void createAnswer(AnswerResponse answerResponse, Long questionId) {
        answerRepository.save(new Answer(random.nextLong(), questionId, answerResponse.answerName, answerResponse.isRightAnswer));
    }

}
