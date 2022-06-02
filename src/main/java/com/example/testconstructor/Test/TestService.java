package com.example.testconstructor.Test;

import com.example.testconstructor.Question.Question;
import com.example.testconstructor.TestShowerResponse.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class TestService {

    private final TestRepository testRepository;
    Random random = new Random();

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Long createTest(String testName) {
        return testRepository.save(new Test((long) random.nextInt(1000000), testName)).testId;
    }

    public Test findTestById(Long testId) {
        return testRepository.findById(testId).get();
    }
}
