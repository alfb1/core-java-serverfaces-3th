package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5737630437352928181L;

	private ArrayList<Name> names = new ArrayList<Name>( Arrays.asList(
			                                             new Name("William", "Dupont"),
			                                             new Name("Anna",    "Keeney"),
			                                             new Name("Mariko",  "Randor"),
			                                             new Name("John",    "Wilson"))
			);
	
	public ArrayList<Name> getNames() {
		return names;
	}
	
	public String deleteRow(Name name) {
		this.names.remove(name);
		return null;
	}
}
