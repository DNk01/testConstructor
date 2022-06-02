package com.example.testconstructor.TestConstructorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionResponse {
	public String questionName;
	public List<AnswerResponse> answerResponse;
}
