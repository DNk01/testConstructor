package com.example.testconstructor.FinishTest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinishAnswerResponse {
	public String answerName;
	public ColorResponse isRightAnswer;
}
