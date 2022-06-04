package com.example.testconstructor.Answer;

import com.example.testconstructor.Question.Question;
import com.example.testconstructor.TestShowerResponse.AnswersRequest;
import com.example.testconstructor.TestShowerResponse.TestSqlRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
	@Query(value = "SELECT a.answerName from Question q " +
		"JOIN Answer a on q.questionId = a.questionId " +
		"WHERE a.questionId = ?1 " +
		"AND a.isCorrectAnswer = true")
	List<String> showRightAnswers(Long question_id);
}
