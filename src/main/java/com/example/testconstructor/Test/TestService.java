package com.example.testconstructor.Test;

import com.example.testconstructor.TestShowerResponse.AnswersRequest;
import com.example.testconstructor.TestShowerResponse.QuestionsRequest;
import com.example.testconstructor.TestShowerResponse.TestRequest;
import com.example.testconstructor.TestShowerResponse.TestSqlRequest;
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
        List<TestSqlRequest> objects = testRepository.showTest(test.getTestId());
        List<QuestionsRequest> questionsShowerResponses = new ArrayList<>();
        List<AnswersRequest> answersShowerResponses = new ArrayList<>();

        if(!objects.isEmpty()) {
            String questionName = (String) objects.get(0).questionName;
            for (int i = 0; i < objects.size(); i++) {
                if (Objects.equals((String) objects.get(i).questionName, questionName)) {
                    answersShowerResponses.add(
                            new AnswersRequest((String) objects.get(i).answerName, (Boolean) objects.get(i).isCorrectAnswer)
                    );
                }
                else{
                    questionsShowerResponses.add(new QuestionsRequest(questionName, answersShowerResponses));
                    answersShowerResponses = new ArrayList<AnswersRequest>();
                    answersShowerResponses.add(
                            new AnswersRequest((String) objects.get(i).answerName, (Boolean) objects.get(i).isCorrectAnswer)
                    );
                    questionName = (String) objects.get(i).questionName;
                }
            }
            questionsShowerResponses.add(new QuestionsRequest(questionName, answersShowerResponses));
            return new TestRequest((String) objects.get(0).testName, questionsShowerResponses);
        }
        return new TestRequest();
    }
}
