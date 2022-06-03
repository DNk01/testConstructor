package com.example.testconstructor.Test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Long> {
    @Query(value="select t.test_name, q.question_name, a.answer_name, a.is_correct_answer from test t\n" +
            "left join question q on t.test_id=q.test_id\n" +
            "left join answer a on q.question_id=a.question_id\n" +
            "where t.test_id=?", nativeQuery = true)
    List<Object[]> showTest(Long test_id);
}
