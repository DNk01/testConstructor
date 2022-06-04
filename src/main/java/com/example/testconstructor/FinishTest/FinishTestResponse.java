package com.example.testconstructor.FinishTest;

import com.example.testconstructor.TestShowerResponse.QuestionsRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinishTestResponse {
	public String testName;
	public String text;
	public List<FinishQuestionResponse> questions;
}
