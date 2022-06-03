package com.example.testconstructor.Test;

import com.example.testconstructor.TestShowerResponse.AnswersRequest;
import com.example.testconstructor.TestShowerResponse.QuestionsRequest;
import com.example.testconstructor.TestShowerResponse.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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

    public TestRequest showTest(Test test){
        List<Object[]> objects = testRepository.showTest(test.getTestId());
        List<QuestionsRequest> questionsShowerResponses = new ArrayList<>();
        List<AnswersRequest> answersShowerResponses = new ArrayList<>();

        if(!objects.isEmpty()) {
            String questionName = (String) objects.get(0)[1];
            for (int i = 0; i < objects.size(); i++) {
                if (Objects.equals((String) objects.get(i)[1], questionName)) {
                    answersShowerResponses.add(
                            new AnswersRequest((String) objects.get(i)[2], (Boolean) objects.get(i)[3])
                    );
                }
                else{
                    questionsShowerResponses.add(new QuestionsRequest(questionName, answersShowerResponses));
                    answersShowerResponses.clear();
                    answersShowerResponses.add(
                            new AnswersRequest((String) objects.get(i)[2], (Boolean) objects.get(i)[3])
                    );
                    questionName = (String) objects.get(i)[1];
                }
            }
            questionsShowerResponses.add(new QuestionsRequest(questionName, answersShowerResponses));
            return new TestRequest((String) objects.get(0)[0], questionsShowerResponses);
        }
        return new TestRequest();
    }
}
