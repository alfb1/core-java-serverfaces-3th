package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ParamBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1696303790928167172L;
	String param1="Manaus";
	String param2="Dolar";
    
	List<String> listParam1 = new ArrayList<String>();
	List<String> listParam2 = new ArrayList<String>();
	String result = "user_option";
	
	public String getResult() {
		return result;
	}



	public ParamBean(){
		listParam1.add("Manaus");
		listParam1.add("Rio");
		listParam1.add("Sao Paulo");
		listParam1.add("Curitiba");
		
		listParam2.add("Dolar");
		listParam2.add("Euro");
		listParam2.add("Libra");
		listParam2.add("Real");
	}
	
	
	
	public List<String> getListParam1() {
		return listParam1;
	}



	public List<String> getListParam2() {
		return listParam2;
	}



	public String getParam1() {
		return param1;
	}

	public void setParam1(String param1) {
		this.param1 = param1;
	}

	public String getParam2() {
		return param2;
	}

	public void setParam2(String param2) {
		this.param2 = param2;
	}

}
