package com.example.testconstructor.TestShowerResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class TestRequest {
	public String testName;
	public List<QuestionsRequest> questions;
}
