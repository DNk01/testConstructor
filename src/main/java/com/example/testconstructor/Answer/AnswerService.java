package com.example.testconstructor.Answer;

import com.example.testconstructor.TestShowerResponse.AnswersRequest;
import com.example.testconstructor.TestShowerResponse.QuestionsRequest;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    Random random = new Random();

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswerList(QuestionsRequest questionsRequest, Long questionId) {
            for (int y = 0; y < questionsRequest.answers.size(); y++) {
                createAnswer(questionsRequest.answers.get(y), questionId);
            }

    }

    public void createAnswer(AnswersRequest answersRequest, Long questionId) {
        answerRepository.save(new Answer(random.nextLong(), questionId,
            answersRequest.answerName, answersRequest.isRightAnswer));
    }

}
