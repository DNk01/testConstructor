package com.example.testconstructor.Answer;


import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private QuestionRepository questionRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(Answer question) {
        return answerRepository.save(question);
    }

    public Answer findAnswerById(Long id) { return answerRepository.findById(id).get(); }

    public void deleteAnswerById(Long id) { answerRepository.deleteById(id); }

    public List<Answer> findAllAnswers() { return answerRepository.findAll(); }

    public Answer updateAnswer(Long id, Long question_id, String answer_name) {
        Answer answer = new Answer();
        answer.answer_id=id;
        answer.question_id=question_id;
        answer.answer_name=answer_name;
        return answerRepository.save(answer);
    }

    public Question getQuestionByAnswerId(Long id){
        Long question_id = answerRepository.getById(id).getQuestion_id();
        return questionRepository.getById(question_id);
    }
}
