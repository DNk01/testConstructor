package com.example.testconstructor.TestShowerResponse;

import com.example.testconstructor.Answer.Answer;
import com.example.testconstructor.Question.Question;
import com.example.testconstructor.Test.Test;
import liquibase.pro.packaged.A;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class TestResponse {
	public String testName;
	public List<QuestionsShowerResponse> questions;
}
