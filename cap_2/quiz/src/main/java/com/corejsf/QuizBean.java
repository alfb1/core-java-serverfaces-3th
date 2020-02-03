package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class QuizBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2549539547460668779L;
	private ArrayList<ProblemBean> problems = new ArrayList<ProblemBean>();
	private int currentIndex;
	private int score;

	public QuizBean() {
		// pi
		problems.add(new ProblemBean(new int[] { 3, 1, 4, 1, 5 }, 9));

		// fibonnaci
		problems.add(new ProblemBean(new int[] { 1, 1, 2, 3, 5 }, 8));

		// squares
		problems.add(new ProblemBean(new int[] { 1, 4, 9, 16, 25 }, 36));

		// cousins
		problems.add(new ProblemBean(new int[] { 2, 3, 5, 7, 11 }, 13));

		// power of 2
		problems.add(new ProblemBean(new int[] { 1, 2, 4, 8, 16 }, 32));

	}

	public int getScore() {
		return score;
	}

	public ProblemBean getCurrent() {
		return problems.get(currentIndex);
	}

	public String getAnswer() {
		return "";
	}
	
	public void setAnswer(String newValue) {
		try {
			int answer = Integer.parseInt( newValue.trim() );
			
			if (getCurrent().getSolution() == answer)
				score++;
			
			currentIndex = ( currentIndex + 1 ) % problems.size();
		}
		catch( NumberFormatException ex) {
			System.out.println("Ocorreu um erro : " + ex.getMessage());
		}
	}

}
