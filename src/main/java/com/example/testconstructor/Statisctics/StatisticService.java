package com.example.testconstructor.Statisctics;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Test.TestRepository;
import com.example.testconstructor.Users.User;
import com.example.testconstructor.Users.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticService {
    private final StatisticRepository statisticRepository;
    private UserRepository userRepository;
    private TestRepository testRepository;

    public StatisticService(StatisticRepository statisticRepository, UserRepository userRepository, TestRepository testRepository) {
        this.statisticRepository = statisticRepository;
        this.userRepository = userRepository;
        this.testRepository = testRepository;
    }

    public Statistic createStatistic(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    public Statistic findStatisticById(Long id) {
        return statisticRepository.findById(id).get();
    }

    public void deleteStatisticById(Long id) {
        statisticRepository.deleteById(id);
    }

    public List<Statistic> findAllStatistics() {
        return statisticRepository.findAll();
    }

    public Statistic updateStatistic(Long id, Long userId, Long testId, Integer rightQuestionAmount) {
        Statistic statistic = new Statistic();
        statistic.setStatistic_id(id);
        statistic.setUser_id(userId);
        statistic.setTest_id(testId);
        statistic.setRight_answers_amount(rightQuestionAmount);
        return statisticRepository.save(statistic);
    }

    public User getUserByStatisticId(Long statisticId) {
        Long userId = statisticRepository.findById(statisticId).get().getUser_id();
        return userRepository.getById(userId);
    }

    public Test getTestByStatisticId(Long statisticId) {
        Long testId = statisticRepository.findById(statisticId).get().getTest_id();
        return testRepository.getById(testId);
    }
}
