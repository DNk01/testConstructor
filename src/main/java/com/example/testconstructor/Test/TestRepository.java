package com.example.testconstructor.Test;

import com.example.testconstructor.TestShowerResponse.TestSqlRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    @Query(value = "select new com.example.testconstructor.TestShowerResponse.TestSqlRequest(t.testName, q.questionName, a.answerName, a.isCorrectAnswer) from Test t\n" +
            "left join Question q on t.testId=q.testId\n" +
            "left join Answer a on q.questionId=a.questionId\n" +
            "where t.testId=?1")
    List<TestSqlRequest> showTest(Long test_id);

    @Query(value = "select q.questionId from Test t\n" +
        "left join Question q on t.testId=q.testId\n" +
        "where t.testId=?1")
    List<Long> findAllQuestions(Long test_id);
}

