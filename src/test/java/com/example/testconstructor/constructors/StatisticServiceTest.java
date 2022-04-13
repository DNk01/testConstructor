package com.example.testconstructor.constructors;

import com.example.testconstructor.Answer.AnswerService;
import com.example.testconstructor.Question.QuestionService;
import com.example.testconstructor.Statisctics.Statistic;
import com.example.testconstructor.Statisctics.StatisticService;
import com.example.testconstructor.Test.TestService;
import com.example.testconstructor.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class StatisticServiceTest {

    @Autowired
    private StatisticService statisticService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Statistic s1 = new Statistic(1L, 1L, 1L, 4);
        Statistic s2 = new Statistic(2L, 1L, 2L, 3);

        //createStatistic test
        assertThat(statisticService.createStatistic(s1)).isEqualTo(s1);

        //findStatisticById test
        assertThat(statisticService.findStatisticById(1L)).isEqualTo(s1);

        //findAllStatistics test
        statisticService.createStatistic(s2);
        assertThat(statisticService.findAllStatistics().size()).isEqualTo(2);

        //deleteStatisticById test
        statisticService.deleteStatisticById(1L);
        assertThat(statisticService.findAllStatistics().size()).isEqualTo(1);
        statisticService.createStatistic(s1);

        //updateStatistic test
        statisticService.updateStatistic(1L, 2L, 1L, 2);
        assertThat(statisticService.findStatisticById(1L).getRight_answers_amount()).isEqualTo(2);

        //getUserByStatisticId
        assertThat(statisticService.getUserByStatisticId(1L).getUserId()).isEqualTo(2L);

        //getTestByStatisticId
        assertThat(statisticService.getTestByStatisticId(1L).getId()).isEqualTo(1L);
    }
}