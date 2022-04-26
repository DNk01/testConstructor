package com.example.testconstructor.Test;

import com.example.testconstructor.Question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class TestService {

    private final TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test createTest(Test test) {
        return testRepository.save(test);
    }

    public Test findTestById(Long testId) {
        return testRepository.findById(testId).get();
    }

    public void deleteTestById(Long testId) {
        testRepository.deleteById(testId);
    }

    public List<Test> findAllTests() {
        return testRepository.findAll();
    }

    public Test updateTest(Long testId, String testName, int questionsAmount) {
        Test test = new Test();
        test.setTestId(testId);
        test.setTestName(testName);
        test.setQuestionsAmount(questionsAmount);
        return testRepository.save(test);
    }
}
