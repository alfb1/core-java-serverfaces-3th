package com.corejsf;

import java.io.Serializable;

public class Problem implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -10273812002139579L;
	private String question;
	private String answer;
	
	public Problem(String question, String answer)
	{
		this.question = question;
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public boolean isCorrect(String response)
	{
		return response.trim().equalsIgnoreCase(answer);
	}

}
