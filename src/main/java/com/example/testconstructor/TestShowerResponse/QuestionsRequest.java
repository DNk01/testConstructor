package com.example.testconstructor.TestShowerResponse;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestionsRequest {
	public String questionName;
	public List<AnswersRequest> answers;
}
