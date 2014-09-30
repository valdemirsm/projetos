package br.com.valdemir.controller;

import javax.faces.model.SelectItem;

public class ComboBean {
	private SelectItem [] states = new SelectItem[]{
		       new SelectItem("Ação"),
		       new SelectItem("Romance"),
		       new SelectItem("Comédia"),
		       new SelectItem("Drama"),
		       new SelectItem("Terror"),
		    // rest of states omitted for clarity
		    };

	public SelectItem[] getStates() {
		return states;
	}	
}
