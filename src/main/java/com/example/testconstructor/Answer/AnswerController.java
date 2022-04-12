package com.example.testconstructor.Answer;

import com.example.testconstructor.Question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class AnswerController {
    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);
    }

    @GetMapping("{id}")
    ResponseEntity<Answer> findAnswer(@PathVariable("id") Long id) {
        return ResponseEntity.ok(answerService.findAnswerById(id));
    }

    @DeleteMapping("{id}")
    public void deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswerById(id);
    }

    @GetMapping
    List<Answer> getAllAnswers() {
        return answerService.findAllAnswers();
    }

    @PutMapping("/{id}")
    public Answer updateAnswer(@PathVariable("id") Long id, Long questionId, String answerName) {
        return answerService.updateAnswer(id, questionId, answerName);
    }

    @GetMapping("{id}/test")
    public Question getQuestionByAnswerId(@PathVariable("id") Long id) {
        return answerService.getQuestionByAnswerId(id);
    }

}
