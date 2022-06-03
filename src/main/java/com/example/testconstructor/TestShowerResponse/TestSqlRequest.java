package com.example.testconstructor.TestShowerResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestSqlRequest {
    public String testName;
    public String questionName;
    public String answerName;
    public Boolean isCorrectAnswer;


}

