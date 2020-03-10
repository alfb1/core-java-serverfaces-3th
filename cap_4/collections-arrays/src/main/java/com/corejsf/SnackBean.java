package com.corejsf;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItemGroup;

@ManagedBean( name="snack")
@SessionScoped
public class SnackBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5829273302364194395L;
	
	private static Map<String, Object> condimentItems;
	private int[] clientBurgerItems;
	private int clienteDay;
	
	private static WeekDay[] daysOfWeek = { 		 new WeekDay(0) ,
	 new WeekDay(1) ,
	 new WeekDay(2) ,
	 new WeekDay(3) ,
	 new WeekDay(4) ,
	 new WeekDay(5) ,
	 new WeekDay(6)  };
	
	private int condiment;
	
	
	static {
		condimentItems = new LinkedHashMap<String, Object>();
		condimentItems.put("Chesse" , 1);
		condimentItems.put("Pickle" , 2);
		condimentItems.put("Mustard", 3);
		condimentItems.put("Lettuce", 4);
		condimentItems.put("Onions" , 5);
	}
	
	
	//Menu items
	private SelectItem[] burgerItems = {
			new SelectItem(11, "Quarter pounder"),
			new SelectItem(12, "Single"),
			new SelectItem(13, "Veggie"),
	};
	
	private SelectItem[] beverageItems = {
			new SelectItem(21, "Coke"),
			new SelectItem(22, "Pepsi"),
			new SelectItem(23, "Water"),
			new SelectItem(24, "Coffee"),
			new SelectItem(25, "Tea"),
	};
	
	private SelectItem[] condimentItems2 = {
			new SelectItem(31, "cheese"),
			new SelectItem(32, "pickle"),
			new SelectItem(33, "mustard"),
			new SelectItem(34, "lettuce"),
			new SelectItem(35, "onions"),
	};

	private SelectItemGroup burgers   = new SelectItemGroup( "Burgers", //valor
			                                                 "burgers on the menu", //descrição
			                                                 false,                 //desabilitado
			                                                 burgerItems            //selecao de itens
			                                               );
	
	private SelectItemGroup beverages  = new SelectItemGroup( "Beverages", "beverages on the menu",  false, beverageItems );
	private SelectItemGroup condiments = new SelectItemGroup("Condiments", "condiments on the menu", false, condimentItems2 );
	
	private SelectItem[] menuItems = { burgers, beverages, condiments };
	
	public Map<String, Object> getCondimentItems(){
		return condimentItems;
	}
	
	public int getCondiment() {
		return condiment;
	}
	
	public SelectItem[] getMenuItems() {
		 return this.menuItems ;
	}

	public void setCondiment(int condiment) {
		this.condiment = condiment;
	}

	public WeekDay[] getDaysOfWeek() {
		return daysOfWeek;
	}

	public int[] getClientBurgerItems() {
		return clientBurgerItems;
	}

	public void setClientBurgerItems(int[] clientBurgerItems) {
		this.clientBurgerItems = clientBurgerItems;
	}

	public int getClienteDay() {
		return clienteDay;
	}

	public void setClienteDay(int clienteDay) {
		this.clienteDay = clienteDay;
	}
	
	
	
}
