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

    public Answer findAnswerById(Long id) {
        return answerRepository.findById(id).get();
    }

    public void deleteAnswerById(Long id) {
        answerRepository.deleteById(id);
    }

    public List<Answer> findAllAnswers() {
        return answerRepository.findAll();
    }

    public Answer updateAnswer(Long id, Long questionId, String answerName) {
        Answer answer = new Answer();
        answer.setAnswerId(id);
        answer.setQuestionId(questionId);
        answer.setAnswerName(answerName);
        return answerRepository.save(answer);
    }

    public Question getQuestionByAnswerId(Long id) {

        Long question_id = answerRepository.findById(id).get().getQuestionId();
        return questionRepository.getById(question_id);
    }
}
