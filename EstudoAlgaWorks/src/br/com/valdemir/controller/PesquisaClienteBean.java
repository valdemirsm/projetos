package br.com.valdemir.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Integer> clientesFiltrados;
	
	public void enviar()
	{
		throw new RuntimeException("Eroooooooooooooo Valdemir");
	}
	
	public PesquisaClienteBean()
	{
		clientesFiltrados = new ArrayList<Integer>();
		for(int i =0; i < 50; i++)
		{
			clientesFiltrados.add(i);
		}
	}

	public List<Integer> getClientesFiltrados() {
		return clientesFiltrados;
	}
}
