package br.com.valdemir.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.model.StatusPedido;
import br.com.valdemir.repository.PedidoRepository;
import br.com.valdemir.util.jpa.Transactional;

public class EmissaoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PedidoService pedidoService;
	
	@Inject
	private PedidoRepository pedidoRepository;
	
	@Inject 
	EstoqueService estoqueService;
	
	@Transactional
	public Pedido emitir(Pedido pedido)
	{
		pedido = this.pedidoService.salvar(pedido);
		
		if (pedido.isNaoEmissivel())
		{
			throw new NegocioException("Pedido não pode ser emitido com status "+ pedido.getStatus().getDescricao());
		}
		
		this.estoqueService.baixarItensEstoque(pedido);
		pedido.setStatus(StatusPedido.EMITIDO);
		
		pedido = this.pedidoRepository.guardar(pedido);
		
		return pedido;
	}
}
