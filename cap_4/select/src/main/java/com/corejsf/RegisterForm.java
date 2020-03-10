package com.corejsf;

import java.awt.Color;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "form")
@SessionScoped
public class RegisterForm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9135132918574885834L;

	public enum Education {
		HIGH_SCHOOL, BACHELOR, MASTER, DOCTOR
	};

	public static class WeekDay {
		private int dayOfWeek;

		public WeekDay(int dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
		}

		public String getDayName() {
			DateFormatSymbols symbols = new DateFormatSymbols();
			String[] weekdays = symbols.getWeekdays();
			return weekdays[dayOfWeek];
		}

		public int getDayNumber() {
			return dayOfWeek;
		}
	}

	private String name;
	private boolean contactMe;
	private int[] bestDaysToContact;
	private Integer yearOfBirth;
	private int[] colors;

	private Set<String> languages = new TreeSet<String>();
	private Education education = Education.BACHELOR;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isContactMe() {
		return contactMe;
	}

	public void setContactMe(boolean contactMe) {
		this.contactMe = contactMe;
	}

	public int[] getBestDaysToContact() {
		return bestDaysToContact;
	}

	public void setBestDaysToContact(int[] bestDaysToContact) {
		this.bestDaysToContact = bestDaysToContact;
	}
	
	

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int[] getColors() {
		return colors;
	}

	public void setColors(int[] colors) {
		this.colors = colors;
	}

	public Set<String> getLanguages() {
		return languages;
	}

	public void setLanguages(Set<String> languages) {
		this.languages = languages;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
	
	public Collection<SelectItem> getYearItems(){ return birthYears; }
	
	public WeekDay[] getDaysOfTheWeek() { return daysOfTheWeek ; }
	
	public SelectItem[] getLanguageItems() { return languageItems ; }
	
	public SelectItem[] getColorItems() { return colorItems ; }
	
	public Map<String, Education> getEducationItems(){ return educationItems; }
	
	public String getBestDaysConcatenated() {
		//return Arrays.toString(bestDaysToContact);
		StringBuilder result = new StringBuilder();
		
		for( int day : bestDaysToContact) {
			result.append(String.format("%s ", RegisterForm.daysOfTheWeek[day].getDayName() ));
		}
		
		return result.toString() ;
	}
	
	public String getColorsConcatenated() {
		StringBuilder result = new StringBuilder();
		for( int color : colors) result.append(String.format("%06x ", color));
		
		return result.toString();
	}
	
	private SelectItem[] colorItems = {
			new SelectItem( Color.RED.getRGB(), "Red"), // value, label
			new SelectItem( Color.GREEN.getRGB(), "Green"), // value, label
			new SelectItem( Color.BLUE.getRGB(), "Blue"), // value, label
			new SelectItem( Color.YELLOW.getRGB(), "Yellow"), // value, label
			new SelectItem( Color.ORANGE.getRGB(), "Orange"), // value, label
	};
	
	private static Map<String, Education> educationItems;
	static {
		educationItems = new LinkedHashMap<String, Education>();
		educationItems.put("High School", Education.HIGH_SCHOOL);
		educationItems.put("Bachelor's", Education.BACHELOR);
		educationItems.put("Master's", Education.MASTER);
		educationItems.put("Doctorate", Education.DOCTOR);
	};
	
	private static SelectItem[] languageItems = {
			new SelectItem("English"),
			new SelectItem("French"),
			new SelectItem("Russian"),
			new SelectItem("Italian"),
			new SelectItem("Esperanto", "Esperanto", "", true) //desabilitado
	};
	
	private static Collection<SelectItem> birthYears;
	static {
		birthYears = new ArrayList<SelectItem>();
		//The first item is a "no selection" item
		
		birthYears.add( new SelectItem( null, "Pick a year:", "", false, false, true));
		
		for( int i = 1900; i < 2020; i++) birthYears.add( new SelectItem( i ));
	}
	
	private static WeekDay[] daysOfTheWeek;
	static {
		daysOfTheWeek = new WeekDay[7];
		
		for( int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
			daysOfTheWeek[ i - Calendar.SUNDAY ] = new WeekDay(i);
		}
	}
}
