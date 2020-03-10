package com.corejsf;


public class WeekDay {
  private int day ;
  private static String[] daysOfWeek = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab" };
  
  public WeekDay(int day) {
	  this.day = day;
  }
  
  public String getDayName() {
	  return WeekDay.daysOfWeek[ this.day ];
			  
  }
  
  public int getDayNumber() {
	  return this.day ;
  }
}
