package com.example.testconstructor.FinishTest;

import com.example.testconstructor.TestShowerResponse.AnswersRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinishQuestionResponse {
	public String questionName;
	public List<FinishAnswerResponse> answers;
}
