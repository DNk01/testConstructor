package com.example.testconstructor.constructors;

import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;
    private QuestionService questionService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Test test = new Test(1L, "name", 3);
        Test test2 = new Test(2L, "name", 4);
        Test test3 = new Test(3L, "name", 5);

        //createTest test   
        assertThat(testService.createTest(test)).isEqualTo(test);

        //findTestById test
        assertThat(testService.findTestById(1L)).isEqualTo(test);

        //findAllTests test
        testService.createTest(test2);
        testService.createTest(test3);
        assertThat(testService.findAllTests().size()).isEqualTo(3);

        //deleteTestById test
        testService.deleteTestById(1L);
        assertThat(testService.findAllTests().size()).isEqualTo(2);

        //updateTest test
        testService.updateTest(2L, "name", 10);
        assertThat(testService.findTestById(2l).getQuestionsAmount()).isEqualTo(10);

/*
        //createQuestion test
        assertThat(questionService.createQuestion(q1)).isEqualTo(q1);

        //findQuestionById test
        assertThat(questionService.findQuestionById(1L)).isEqualTo(q1);

        //findAllQuestions test
        assertThat(questionService.findAllQuestions().size()).isEqualTo(3);

        //deleteQuestionById test
        questionService.deleteQuestionById(1L);
        assertThat(questionService.findAllQuestions().size()).isEqualTo(2);

        //updateQuestion test
        questionService.updateQuestion(2L, 3L, "new_q2");
        assertThat(questionService.findQuestionById(2l).getQuestion_name()).isEqualTo("new_q2");

        //getTestByQuestionId test
        assertThat(questionService.getTestByQuestionId(2L)).isEqualTo(3L);
*/
    }
}