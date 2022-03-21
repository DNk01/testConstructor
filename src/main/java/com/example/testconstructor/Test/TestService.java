package com.example.testconstructor.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Test findTestById(Long id) {
        return testRepository.findById(id).get();
    }

    public void deleteTestById(Long id) {
        testRepository.deleteById(id);
    }

    public List<Test> findAllTests() {
        return testRepository.findAll();
    }
}
