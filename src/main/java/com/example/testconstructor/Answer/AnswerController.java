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

    @DeleteMapping("{id}")
    public void deleteAnswer(@PathVariable("id") Long id) {
        answerService.deleteAnswerById(id);
    }

    @GetMapping
    List<Answer> getAllAnswers() {
        return answerService.findAllAnswers();
    }

    @PutMapping("/{id}")
    public Answer updateAnswer(@PathVariable("id") Long answerId, Long questionId, String answerName, Boolean isCorrectAnswer) {
        return answerService.updateAnswer(answerId, questionId, answerName, isCorrectAnswer);
    }

    @GetMapping("{id}/test")
    public Question getQuestionByAnswerId(@PathVariable("id") Long answerId) {
        return answerService.getQuestionByAnswerId(answerId);
    }

}
