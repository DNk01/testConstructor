package com.example.testconstructor.Question;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "question")
public class Question {
    @Id
    @Column(name = "question_id")
    Long questionId;

    @Column(name = "test_id")
    Long testId;

    @Column(name = "question_name")
    String questionName;

}
