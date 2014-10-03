package br.com.valdemir.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valdemir.model.ItemPedido;
import br.com.valdemir.model.Pedido;
import br.com.valdemir.repository.PedidoRepository;
import br.com.valdemir.util.jpa.Transactional;

public class EstoqueService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepository pedidoRepository;

	@Transactional
	public void baixarItensEstoque(Pedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		
		for (ItemPedido item : pedido.getItens())
		{
			item.getProduto().baixarEstoque(item.getQuantidade());
		}
		
	}

	public void retornarItensEstoque(Pedido pedido) {
		pedido = this.pedidoRepository.porId(pedido.getId());
		for (ItemPedido item : pedido.getItens())
		{
			item.getProduto().adicionarEstoque(item.getQuantidade());
		}
	}
	
	
}
