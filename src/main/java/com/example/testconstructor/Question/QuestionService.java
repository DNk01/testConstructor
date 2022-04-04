package com.example.testconstructor.Question;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestRepository;
import com.example.testconstructor.Test.TestService;
import org.springframework.stereotype.Service;

import javax.management.QueryEval;
import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private TestRepository testRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).get();
    }

    public void deleteQuestionById(Long id) {
        questionRepository.deleteById(id);
    }

    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    public Question updateQuestion(Long id, Long test_id, String question_name) {
        Question question = new Question();
        question.question_id = id;
        question.test_id = test_id;
        question.question_name = question_name;
        return questionRepository.save(question);
    }

    public Test getTestByQuestionId(Long id) {
        Long test_id = questionRepository.getById(id).getTest_id();
        return testRepository.getById(test_id);
    }
}
