package com.example.testconstructor.Statisctics;

import com.example.testconstructor.Test.Test;
import com.example.testconstructor.Users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticController {
    private final StatisticService statisticService;

    @Autowired
    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @PostMapping
    public Statistic createStatistic(@RequestBody Statistic statistic) {
        return statisticService.createStatistic(statistic);
    }

    @GetMapping("{id}")
    ResponseEntity<Statistic> findStatistic(@PathVariable("id") Long id) {
        return ResponseEntity.ok(statisticService.findStatisticById(id));
    }

    @DeleteMapping("{id}")
    public void deleteStatistic(@PathVariable("id") Long id) {
        statisticService.deleteStatisticById(id);
    }

    @GetMapping
    List<Statistic> getAllStatistic() {
        return statisticService.findAllStatistics();
    }

    @PutMapping("/{id}")
    public Statistic updateStatistic(@PathVariable("id") Long statistic_id, Long user_id, Long test_id, Integer right_questions_amount) {
        return statisticService.updateStatistic(statistic_id, user_id, test_id, right_questions_amount);
    }

    @GetMapping("{id}/user")
    public User getUserByStatisticId(@PathVariable("id") Long id) {
        return statisticService.getUserByStatisticId(id);
    }

    @GetMapping("{id}/test")
    public Test getTestByStatisticId(@PathVariable("id") Long id) {
        return statisticService.getTestByStatisticId(id);
    }

}
