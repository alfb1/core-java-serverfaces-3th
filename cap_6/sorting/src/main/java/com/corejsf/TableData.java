package com.corejsf;

import java.io.Serializable;
import java.util.Comparator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

import org.apache.commons.lang3.ArrayUtils;


@ManagedBean
@SessionScoped
public class TableData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5737630437352928181L;
    private SortFilterModel<Name> filterModel;
	private Name[] names;
	
	public TableData() {
		doFilterModel();
	}
	
	//private DataModel<Name> model = new ArrayDataModel<Name>(names);
	
	public DataModel<Name> getNames() {
		return filterModel;
	}
	
	public String sortByFirst() {
		filterModel.sortBy(new Comparator<Name>() {
			public int compare(Name n1, Name n2) {
				return n1.getFirst().compareTo(n2.getFirst());
			}
		});
		
		return null;		
	}
	
	public String sortByLast() {
		filterModel.sortBy(new Comparator<Name>() {
			public int compare(Name n1, Name n2) {
				return n1.getLast().compareTo(n2.getLast());
			}
		});
		
		return null;		
	}	
	
	public String deleteRow() 
	{
		Name name = filterModel.getRowData();
		names = ArrayUtils.removeElement(names, name);
		filterModel = new SortFilterModel<Name>( new ArrayDataModel<Name>(names));
		return null;
	}
	
	public String reset()
	{
		doFilterModel();
		return null;
	}
	
	public void doFilterModel() {
		names = new Name[] {
                new Name("William", "Dupont"),
                new Name("Anna",    "Keeney"),
                new Name("Mariko",  "Randor"),
                new Name("John",    "Wilson")
                };

		filterModel = new SortFilterModel<Name>( new ArrayDataModel<Name>(names));
	}
	
}
