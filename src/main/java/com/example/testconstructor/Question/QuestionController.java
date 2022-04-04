package com.example.testconstructor.Question;

import com.example.testconstructor.Test.Test;
import liquibase.pro.packaged.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question createQuestion(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @GetMapping("{id}")
    ResponseEntity<Question> findQuestion(@PathVariable("id") Long id) {
        return ResponseEntity.ok(questionService.findQuestionById(id));
    }

    @DeleteMapping("{id}")
    public void deleteQuestion(@PathVariable("id") Long id) {
        questionService.deleteQuestionById(id);
    }

    @GetMapping
    List<Question> getAllQuestions() {
        return questionService.findAllQuestions();
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable("id") Long id, Long test_id, String question_name) {
        return questionService.updateQuestion(id, test_id, question_name);
    }

    @GetMapping("{id}/test")
    public Test getTestByQuestionId(@PathVariable("id") Long id){
        return questionService.getTestByQuestionId(id);
    }

}
