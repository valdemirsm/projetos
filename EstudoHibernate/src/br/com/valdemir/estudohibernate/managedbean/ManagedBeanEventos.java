package br.com.valdemir.estudohibernate.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.event.ActionEvent;

@ManagedBean
public class ManagedBeanEventos {
	public void listener(ActionEvent e){
		UIComponent source = e.getComponent();
		System.out.println(source.getId());
	}
}
