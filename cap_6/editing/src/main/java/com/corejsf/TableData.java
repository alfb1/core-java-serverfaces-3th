package com.corejsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5737630437352928181L;

	private static final Name[] names = new Name[] {
			                                          new Name("William", "Dupont"),
			                                          new Name("Anna",    "Keeney"),
			                                          new Name("Mariko",  "Randor"),
			                                          new Name("John",    "Wilson")
	};
	
	public Name[] getNames() {
		return names;
	}
}
