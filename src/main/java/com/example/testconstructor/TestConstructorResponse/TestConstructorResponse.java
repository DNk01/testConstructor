package com.example.testconstructor.TestConstructorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TestConstructorResponse {
	public String testName;
	public List<QuestionResponse> questions;
}
