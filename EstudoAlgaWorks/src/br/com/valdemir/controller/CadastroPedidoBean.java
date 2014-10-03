package br.com.valdemir.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.valdemir.model.Cliente;
import br.com.valdemir.model.EnderecoEntrega;
import br.com.valdemir.model.FormaPagamento;
import br.com.valdemir.model.ItemPedido;
import br.com.valdemir.model.Pedido;
import br.com.valdemir.model.Produto;
import br.com.valdemir.model.Usuario;
import br.com.valdemir.repository.ClienteRepository;
import br.com.valdemir.repository.ProdutoRepository;
import br.com.valdemir.repository.UsuarioRepository;
import br.com.valdemir.service.PedidoService;
import br.com.valdemir.util.jsf.FacesUtil;
import br.com.valdemir.validation.SKU;

@Named
@SessionScoped
public class CadastroPedidoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioRepository usuarioRepository;
	@Inject
	private ClienteRepository clienteRepository;
	@Inject
	private ProdutoRepository produtoRepository;
	@Inject
	private PedidoService pedidoService;
	@Produces
	@PedidoEmissao
	private Pedido pedido;
	private List<Usuario> vendedores;
	private Produto produtoLinhaEditavel;
	private String sku;

	public CadastroPedidoBean() {
		limpar();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.vendedores = this.usuarioRepository.vendedores();
			this.pedido.adicionarItemVazio();
			this.recalcularPedido();
		}
	}

	private void limpar() {
		pedido = new Pedido();
		pedido.setEnderecoEntrega(new EnderecoEntrega());
	}

	public List<Cliente> completarCliente(String nome) {
		return clienteRepository.porNome(nome);
	}

	public void salvar() {
		this.pedido.removerItemVazio();
		try
		{
			this.pedido = pedidoService.salvar(this.pedido);
			FacesUtil.addInfoMessage("Pedido salvo com sucesso.");
	
		}
		finally
		{
			this.pedido.adicionarItemVazio();
		}
	}
	
	public void recalcularPedido()
	{
		if (this.pedido != null)
		{
			this.pedido.recalcularValorTotal();
		}
	}
	public List<Produto> completarProduto(String nome)
	{
		return this.produtoRepository.porNome(nome);
	}
	
	public void carregarProdutoLinhaEditavel()
	{
		ItemPedido item = this.pedido.getItens().get(0);
		
		if (this.produtoLinhaEditavel != null) {
			if (this.existeItemComProduto(this.produtoLinhaEditavel)) {
				FacesUtil
						.addErrorMessage("Já existe um item no pedido com o produto informado");
			} else {
				item.setProduto(this.produtoLinhaEditavel);
				item.setValorUnitario(this.produtoLinhaEditavel
						.getValorUnitario());

				this.pedido.adicionarItemVazio();
				this.produtoLinhaEditavel = null;
				this.sku = null;

				this.pedido.recalcularValorTotal();
			}

		}
	}
	
	private boolean existeItemComProduto(Produto produto)
	{
		boolean existeItem =  false;
		for (ItemPedido item : this.pedido.getItens())
		{
			if (produto.equals(item.getProduto()))
			{
				existeItem = true;
				break;
			}
		}
		return existeItem;
	}
	
	public void carregarProdutoPorSku()
	{
		if (StringUtils.isNotEmpty(this.sku))
		{
			this.produtoLinhaEditavel = this.produtoRepository.porSku(this.sku);
			this.carregarProdutoLinhaEditavel();
		}
	}
	
	public void atualizarQuantidade(ItemPedido item, int linha)
	{
		if (item.getQuantidade() < 1)
		{
			if (linha == 0)
			{
				item.setQuantidade(1);
			}
			else
			{
				this.getPedido().getItens().remove(item);
			}
		}
		this.pedido.recalcularValorTotal();
	}
	// aqui receberá o evento disparado no controller EmissaoPedidoBean
	public void pedidoAlterado(@Observes PedidoAlteradoEvent event)
	{
		this.pedido = event.getPedido();
	}
	public FormaPagamento[] getFormasPagamentos()
	{
		return FormaPagamento.values();
	}
	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Usuario> getVendedores() {
		return vendedores;
	}

	public Produto getProdutoLinhaEditavel() {
		return produtoLinhaEditavel;
	}

	public void setProdutoLinhaEditavel(Produto produtoLinhaEditavel) {
		this.produtoLinhaEditavel = produtoLinhaEditavel;
	}
	@SKU
	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}
	
	

}
