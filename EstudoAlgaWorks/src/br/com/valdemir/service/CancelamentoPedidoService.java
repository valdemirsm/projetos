package br.com.valdemir.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.model.StatusPedido;
import br.com.valdemir.repository.PedidoRepository;
import br.com.valdemir.util.jpa.Transactional;

public class CancelamentoPedidoService implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepository pedidoRepository;
	
	@Inject
	private EstoqueService estoqueService;
	@Transactional
	public Pedido cancelar(Pedido pedido) {
		pedido = pedidoRepository.porId(pedido.getId());
		
		if (pedido.isNaoCancelavel())
		{
			throw new NegocioException("Pedido não pode ser cancelado no status "+pedido.getStatus().getDescricao());
		}
		if (pedido.isEmitido())
		{
			this.estoqueService.retornarItensEstoque(pedido);
		}
		pedido.setStatus(StatusPedido.CANCELADO);
		
		pedido = pedidoRepository.guardar(pedido);
		return pedido;
	}
	
	

}
