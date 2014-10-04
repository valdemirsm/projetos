package br.com.valdemir.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.model.StatusPedido;
import br.com.valdemir.repository.PedidoRepository;
import br.com.valdemir.repository.filter.PedidoFilter;

@Named
@RequestScoped
public class PesquisaPedidoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidoRepository pedidoRepository;
	private PedidoFilter filtro;
	private List<Pedido> pedidosFiltrados;
	
	public PesquisaPedidoBean()
	{
		filtro = new PedidoFilter();
		pedidosFiltrados = new ArrayList<>();
	}
	
	public void pesquisar()
	{
		pedidosFiltrados = pedidoRepository.filtrados(filtro);
	}
	
	public StatusPedido[] getStatus()
	{
		return StatusPedido.values();
	}

	public List<Pedido> getPedidosFiltrados() {
		return pedidosFiltrados;
	}

	public PedidoFilter getFiltro() {
		return filtro;
	}

	public void setFiltro(PedidoFilter filtro) {
		this.filtro = filtro;
	}
	
	
}
