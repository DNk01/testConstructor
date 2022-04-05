package com.example.testconstructor.constructors;

import com.example.testconstructor.Answer.Answer;
import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Statisctics.Statistic;
import com.example.testconstructor.Statisctics.StatisticService;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Users.User;
import com.example.testconstructor.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TestServiceTest {

    @Autowired
    private TestService testService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private AnswerService answerService;
    @Autowired
    private UserService userService;
    @Autowired
    private StatisticService statisticService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Test test = new Test(1L, "name", 3);
        Test test2 = new Test(2L, "name", 4);
        Test test3 = new Test(3L, "name", 5);

        Question q1 = new Question(1L, 1L, "q1");
        Question q2 = new Question(2L, 2L, "q2");
        Question q3 = new Question(3L, 3L, "q3");

        Answer a1 = new Answer(1L, 1L, "a1");
        Answer a2 = new Answer(2L, 2L, "a2");
        Answer a3 = new Answer(3L, 3L, "a3");

        User u1 = new User(1L, "Dmitry", "Litvinenko");
        User u2 = new User(2l, "Danila", "Kolotilov");

        Statistic s1 = new Statistic();
        s1.setTest_id(2L);
        s1.setUser_id(1L);
        s1.setRight_answers_amount(4);

        Statistic s2 = new Statistic();
        s2.setTest_id(2L);
        s2.setUser_id(2L);
        s2.setRight_answers_amount(3);

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
        assertThat(questionService.findQuestionById(2l).getQuestion_name()).isEqualTo("new_q2");

        //getTestByQuestionId test
        assertThat(questionService.getTestByQuestionId(2L).getId()).isEqualTo(3L);


        //createAnswer test
        assertThat(answerService.createAnswer(a1)).isEqualTo(a1);

        //findAnswerById test
        assertThat(answerService.findAnswerById(1L)).isEqualTo(a1);

        //findAllAnswers test
        answerService.createAnswer(a2);
        answerService.createAnswer(a3);
        assertThat(answerService.findAllAnswers().size()).isEqualTo(3);

        //deleteAnswerById test
        answerService.deleteAnswerById(1L);
        assertThat(answerService.findAllAnswers().size()).isEqualTo(2);

        //updateAnswer test
        answerService.updateAnswer(2L, 2L, "new_a2");
        assertThat(answerService.findAnswerById(2l).getAnswer_name()).isEqualTo("new_a2");

        //getTestByQuestionId test
        assertThat(answerService.getQuestionByAnswerId(2L).getQuestion_id()).isEqualTo(2L);


        //createUser test
        assertThat(userService.createUser(u1)).isEqualTo(u1);

        //findUserById test
        assertThat(userService.findUserById(1L)).isEqualTo(u1);

        //findAllUsers test
        userService.createUser(u2);
        assertThat(userService.findAllUsers().size()).isEqualTo(2);

        //deleteUserById test
        userService.deleteUserById(1L);
        assertThat(userService.findAllUsers().size()).isEqualTo(1);

        //updateUser test
        userService.updateUser(2L, "Vasya", "Pupkin");
        assertThat(userService.findUserById(2l).getUser_name()).isEqualTo("Vasya");
        assertThat(userService.findUserById(2L).getUser_surname()).isEqualTo("Pupkin");
        userService.createUser(u1);


        //createStatistic test
        assertThat(statisticService.createStatistic(s1)).isEqualTo(s1);

        //findStatisticById test
        assertThat(statisticService.findStatisticById(s1.getStatistic_id())).isEqualTo(s1);

        //findAllStatistics test
        statisticService.createStatistic(s2);
        assertThat(statisticService.findAllStatistics().size()).isEqualTo(2);

        //deleteStatisticById test
        statisticService.deleteStatisticById(s1.getStatistic_id());
        assertThat(statisticService.findAllStatistics().size()).isEqualTo(1);

        //updateStatistic test
        statisticService.updateStatistic(s2.getStatistic_id(), 2L, 1L, 2);
        assertThat(statisticService.findStatisticById(s2.getStatistic_id()).getRight_answers_amount()).isEqualTo(2);


    }
}