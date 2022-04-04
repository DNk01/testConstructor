package com.example.testconstructor.Answer;

import com.example.testconstructor.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
