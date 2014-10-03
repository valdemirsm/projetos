package br.com.valdemir.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.model.StatusPedido;
import br.com.valdemir.repository.PedidoRepository;
import br.com.valdemir.util.jpa.Transactional;

public class PedidoService implements Serializable{
	private static final long serialVersionUID = 1L;

	@Inject
	private PedidoRepository pedidoRepository;

	@Transactional
	public Pedido salvar(Pedido pedido) {
		if (pedido.isNovo()) {
			pedido.setDataCriacao(new Date());
			pedido.setStatus(StatusPedido.ORCAMENTO);
		}
		pedido.recalcularValorTotal();
		
		if (pedido.isNaoAlteravel())
		{
			throw new NegocioException("Pedido não pode ser alterado no status "+ pedido.getStatus().getDescricao() + ".");
		}
		if (pedido.getItens().isEmpty())
		{
			throw new NegocioException("O pedido dever ter pelo ao menos um item");
		}
		if (pedido.isValorTotalNegativo())
		{
			throw new NegocioException("Valor total do pedido não pode ser negativo");
		}
		pedido = this.pedidoRepository.guardar(pedido);
		return pedido;
	}
}
