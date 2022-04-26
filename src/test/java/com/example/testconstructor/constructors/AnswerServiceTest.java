package com.example.testconstructor.constructors;

import com.example.testconstructor.Answer.Answer;
import com.example.testconstructor.Answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AnswerServiceTest {
    @Autowired
    private AnswerService answerService;

    @org.junit.jupiter.api.Test
    void CRUDServiceTest() {
        Answer a1 = new Answer(1L, 1L, "a1", Boolean.TRUE);
        Answer a2 = new Answer(2L, 2L, "a2", Boolean.TRUE);
        Answer a3 = new Answer(3L, 3L, "a3", Boolean.TRUE);

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
        answerService.updateAnswer(2L, 2L, "new_a2", Boolean.TRUE);
        assertThat(answerService.findAnswerById(2l).getAnswerName()).isEqualTo("new_a2");

        //getTestByQuestionId test
        assertThat(answerService.getQuestionByAnswerId(2L).getQuestionId()).isEqualTo(2L);
    }
}
