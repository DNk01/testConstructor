package com.example.testconstructor.Answer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "answer")
public class Answer {
    @Id
    @Column(name = "answer_id")
    Long answerId;

    @Column(name = "question_id")
    Long questionId;

    @Column(name = "answer_name")
    String answerName;

    @Column(name = "is_correct_answer")
    Boolean isCorrectAnswer;

}
