package br.com.valdemir.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PesquisaEnderecoBean {
	private static final long serialVersionUID = 1L;
	private List<Integer> enderecoFiltrados;
	public PesquisaEnderecoBean()
	{
		enderecoFiltrados = new ArrayList<Integer>();
		for(int i =0; i < 50; i++)
		{
			enderecoFiltrados.add(i);
		}
	}
	public List<Integer> getEnderecoFiltrados() {
		return enderecoFiltrados;
	}


}
