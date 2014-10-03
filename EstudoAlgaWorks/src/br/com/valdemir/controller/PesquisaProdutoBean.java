package br.com.valdemir.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valdemir.model.Produto;
import br.com.valdemir.repository.ProdutoRepository;
import br.com.valdemir.repository.filter.ProdutoFilter;
import br.com.valdemir.util.jsf.FacesUtil;

@Named(value = "pesquisaProdutoBean")
@SessionScoped
public class PesquisaProdutoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private ProdutoRepository produtoRepository;
	private ProdutoFilter filtro;
	private List<Produto> produtosFiltrados;
	private Produto produtoSelecionado;

	public PesquisaProdutoBean()
	{
		filtro = new ProdutoFilter();
	}
	public List<Produto> getProdutosFiltrados() {
		return produtosFiltrados;
	}
	
	public void pesquisar()
	{
		produtosFiltrados = produtoRepository.filtrados(filtro);
	}
	
	public void excluir()
	{
		produtoRepository.remover(produtoSelecionado);
		produtosFiltrados.remove(produtoSelecionado);
		FacesUtil.addInfoMessage("Produto "+produtoSelecionado.getSku()+" excluido com sucesso");
	}

	public ProdutoFilter getFiltro() {
		return filtro;
	}
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}
	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}
