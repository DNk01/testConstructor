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
    Long question_id;

    @Column(name = "test_id")
    Long test_id;

    @Column(name = "question_name")
    String question_name;

}
