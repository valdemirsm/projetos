package br.com.valdemir.controller;

import br.com.valdemir.model.Pedido;

public class PedidoAlteradoEvent {
	
	private Pedido pedido;
	
	public PedidoAlteradoEvent(Pedido pedido)
	{
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	
}
