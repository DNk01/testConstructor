package com.example.testconstructor.constructors;

import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Statisctics.StatisticService;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuestionServiceTest {

    @Autowired
    private QuestionService questionService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Question q1 = new Question(1L, 1L, "Guess who?");
        Question q2 = new Question(2L, 1L, "Who did bite 87?");
        Question q3 = new Question(3L, 1L, "Best JoJo?");

        //createQuestion test
        assertThat(questionService.createQuestion(q1)).isEqualTo(q1);

        //findQuestionById test
        assertThat(questionService.findQuestionById(1L)).isEqualTo(q1);

        //findAllQuestions test
        questionService.createQuestion(q2);
        questionService.createQuestion(q3);
        assertThat(questionService.findAllQuestions().size()).isEqualTo(3);

        //deleteQuestionById test
        questionService.deleteQuestionById(1L);
        assertThat(questionService.findAllQuestions().size()).isEqualTo(2);

        //updateQuestion test
        questionService.updateQuestion(2L, 3L, "new_q2");
        assertThat(questionService.findQuestionById(2l).getQuestionName()).isEqualTo("new_q2");

        //getTestByQuestionId test
        assertThat(questionService.getTestByQuestionId(2L).getId()).isEqualTo(3L);
    }
    }