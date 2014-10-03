package br.com.valdemir.controller;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.service.EmissaoPedidoService;
import br.com.valdemir.util.jsf.FacesUtil;

@Named
@RequestScoped
public class EmissaoPedidoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EmissaoPedidoService emissaoPedidoService;
	@Inject
	@PedidoEmissao
	private Pedido pedido;
	@Inject
	private Event<PedidoAlteradoEvent> pedidoAlteradoEvent;
	public void emitirPedido()
	{
		this.pedido.removerItemVazio();
		try {
			this.pedido = this.emissaoPedidoService.emitir(this.pedido);
			//lançar evento CDI para atualizar o atributo pedido em outro controller CadastroPedidoBean
			this.pedidoAlteradoEvent.fire(new PedidoAlteradoEvent(this.pedido));
			FacesUtil.addInfoMessage("Pedido emitido com sucesso.");
		} finally {
			this.pedido.adicionarItemVazio();
		}
	}
	
}
