package br.com.valdemir.controller;

import javax.faces.model.SelectItem;

public class ComboBean {
	private SelectItem [] states = new SelectItem[]{
		       new SelectItem("A��o"),
		       new SelectItem("Romance"),
		       new SelectItem("Com�dia"),
		       new SelectItem("Drama"),
		       new SelectItem("Terror"),
		    // rest of states omitted for clarity
		    };

	public SelectItem[] getStates() {
		return states;
	}	
}
