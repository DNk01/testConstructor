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
    Long answer_id;

    @Column(name = "question_id")
    Long question_id;

    @Column(name = "answer_name")
    String answer_name;

}
