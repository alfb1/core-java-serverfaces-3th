package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean(name="autoComplete")
@SessionScoped
public class AutoCompleteImplements implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String[] getLocations() {
		return new String[] {
				"Arvada", "Colorado Springs", "Baltimore", "Brittany", "Bahamas",
				"Belgrade", "Boulder", "Bayou", "Brighton", "Buffalo", "Denver", "Dixie",
				"Evergreen", "Ft. Collins", "Los Angeles", "Los Lobos", "Las Vegas",
				"Loverland", "Vail"
		};
	}

}
