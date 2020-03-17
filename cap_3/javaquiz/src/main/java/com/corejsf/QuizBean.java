package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class QuizBean implements Serializable {

	/**
	 * 
	 */
  private static final long serialVersionUID = -5191744926776189111L;
  private int currentProblem;
  private int tries;
  private int score;
  
  private String response="";
  private String correctAnswer;
  
  private ArrayList<Problem> problems = new ArrayList<Problem>( Arrays.asList(
		   new Problem( "What trademarked slogan describes Java development? Write once, ...",
		                "run anywhere"),
		   new Problem( "What are the first 4 bytes of every class file (in hexadecimal) ?",
				        "CAFEBABE"),
		   new Problem( "What does this statement print? System.out.println(1+\"2\"); ",
			            "12"),
		   new Problem( "Which Java keyword is used to define a subclass?",
		                "exends"),
		   new Problem( "What was the original name of the Java programming language?",
	                    "Oak"),
		   new Problem( "Which java.util class describe a point in time?",
	                    "Date")		  
		  ));
  
  public String getQuestion() {
     return problems.get(currentProblem).getQuestion();
  }
  
  public String getAnswer() { return correctAnswer ; }
  
  public int getScore() { return score; }
  
  public String getResponse() { return response; }
  public void setResponse( String value) {
	  this.response = value;
  }
  
  public String answerAction() {
	  tries++;
	  
	  if ( problems.get(currentProblem).isCorrect(response)) {
		  score++;
		  nextProblem();
		  if ( currentProblem == problems.size()) return "done";
		  else return "success";
	  }else if ( tries == 1) return "failure";
	  else {
		  nextProblem();
		  if ( currentProblem == problems.size()) return "done";
		  else return "failure";
	  }
  }
  
  public String startOverAction() {
	  Collections.shuffle(problems);
	  currentProblem = 0;
	  score = 0;
	  tries = 0;
	  response = "";
	  return "startOver";
  }
  
  private void nextProblem() {
	  correctAnswer = problems.get(currentProblem).getAnswer();
	  currentProblem++;
	  tries=0;
	  response="";
  }
}