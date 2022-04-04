package com.example.testconstructor.Statisctics;

import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Question.QuestionRepository;
import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestRepository;
import com.example.testconstructor.Users.User;
import com.example.testconstructor.Users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;
    private UserRepository userRepository;
    private TestRepository testRepository;

    public StatisticService(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;
    }

    public Statistic createStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    public Statistic findStatisticById(UUID id) {
        return statisticRepository.findById(id).get();
    }

    public void deleteStatisticById(UUID id) {
        statisticRepository.deleteById(id);
    }

    public List<Statistic> findAllStatistics() {
        return statisticRepository.findAll();
    }

    public Statistic updateStatistic(UUID statistic_id, Long user_id, Long test_id, Integer right_questions_amount) {
        Statistic statistic = new Statistic();
        statistic.statistic_id = statistic_id;
        statistic.user_id = user_id;
        statistic.test_id = test_id;
        statistic.right_answers_amount = right_questions_amount;
        return statisticRepository.save(statistic);
    }

    public User getUserByStatisticId(UUID statistic_id){
        Long user_id = statisticRepository.getById(statistic_id).getUser_id();
        return userRepository.getById(user_id);
    }

    public Test getTestByStatisticId(UUID statistic_id){
        Long test_id = statisticRepository.getById(statistic_id).getTest_id();
        return testRepository.getById(test_id);
    }
}
