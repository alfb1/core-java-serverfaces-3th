package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "tp")
@SessionScoped
public class TabbedPane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8294354731233662384L;

	private int index;
	private static final int JEFFERSON_INDEX = 0;
	private static final int ROOSEVELT_INDEX = 1;
	private static final int LINCOLN_INDEX = 2;
	private static final int WASHINGTON_INDEX = 3;

	private String[] tabToolTips = { "jeffersonToolTip", "rooseveltToolTip", "lincolnToolTip", "washingtonTollTip" };

	public TabbedPane() {
		index = JEFFERSON_INDEX;
	}

	// Listeners
	public void jeffersonAction(ActionEvent e) {
		index = JEFFERSON_INDEX;
	}

	public void rooseveltAction(ActionEvent e) {
		index = ROOSEVELT_INDEX;
	}

	public void lincolnAction(ActionEvent e) {
		index = LINCOLN_INDEX;
	}

	public void washingtonAction(ActionEvent e) {
		index = WASHINGTON_INDEX;
	}

	// Estilos CSS
	public String getJeffersonStyle() {
		return getCSS(JEFFERSON_INDEX);
	}

	public String getRooseveltStyle() {
		return getCSS(ROOSEVELT_INDEX);
	}

	public String getLincolnStyle() {
		return getCSS(LINCOLN_INDEX);
	}

	public String getWashingtonStyle() {
		return getCSS(WASHINGTON_INDEX);
	}

	private String getCSS(int forIndex) {
		return forIndex == index ? "tabbedPaneTextSelected" : "tabbedPaneText";
	}

	public boolean getJeffersonCurrent() {
		return index == JEFFERSON_INDEX;
	}

	public boolean getRooseveltCurrent() {
		return index == ROOSEVELT_INDEX;
	}

	public boolean getLincolnCurrent() {
		return index == LINCOLN_INDEX;
	}

	public boolean getWashingtonCurrent() {
		return index == WASHINGTON_INDEX;
	}

}
