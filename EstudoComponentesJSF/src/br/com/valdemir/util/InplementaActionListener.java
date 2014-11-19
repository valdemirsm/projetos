package br.com.valdemir.util;

import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class InplementaActionListener implements ActionListener{

	@Override
	public void processAction(ActionEvent event) throws AbortProcessingException {
		UIComponent source = event.getComponent();
		System.out.println("Ação executada no componente "
		+ source.getId());
//		throw new AbortProcessingException();
	}

}
