package com.corejsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Planetarium implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2938828730733981196L;
	private String selectedPlanet;

	public String getSelectedPlanet() {
		return selectedPlanet;
	}

	public String changePlanet(String newValue) {
		selectedPlanet = newValue;
		return selectedPlanet;
	}
}
