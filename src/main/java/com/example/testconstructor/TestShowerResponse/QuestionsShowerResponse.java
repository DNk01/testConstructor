package com.example.testconstructor.TestShowerResponse;

import com.example.testconstructor.Answer.Answer;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class QuestionsShowerResponse {
	public String questionName;
	public List<AnswersShowerResponse> answers;
}
