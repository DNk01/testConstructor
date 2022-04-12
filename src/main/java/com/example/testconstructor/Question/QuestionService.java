package com.example.testconstructor.Question;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final TestRepository testRepository;

    public QuestionService(QuestionRepository questionRepository, TestRepository testRepository) {
        this.questionRepository = questionRepository;
        this.testRepository = testRepository;
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

    public Question updateQuestion(Long id, Long testId, String questionName) {
        Question question = new Question();
        question.setQuestionId(id);
        question.setTestId(testId);
        question.setQuestionName(questionName);
        return questionRepository.save(question);
    }

    public Test getTestByQuestionId(Long id) {
        Question question = questionRepository.findById(id).get();
        Long test_id = question.getTestId();
        return testRepository.findById(test_id).get();
    }
}
