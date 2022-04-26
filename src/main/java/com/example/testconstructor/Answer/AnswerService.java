package com.example.testconstructor.Answer;


import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    public Answer createAnswer(Answer question) {
        return answerRepository.save(question);
    }

    public Answer findAnswerById(Long answerId) {
        return answerRepository.findById(answerId).get();
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
