package com.example.testconstructor.TestConstructorResponse;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuestionResponse1 {
	public String questionName;
	public AnswerResponse answerResponse;
}