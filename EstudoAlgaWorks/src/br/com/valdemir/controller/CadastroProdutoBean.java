package br.com.valdemir.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import br.com.valdemir.model.Categoria;
import br.com.valdemir.model.Produto;
import br.com.valdemir.repository.CategoriaRepository;
import br.com.valdemir.service.CadastroProdutoService;
import br.com.valdemir.util.jsf.FacesUtil;

@Named(value = "cadastroProdutoBean")
@SessionScoped
public class CadastroProdutoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaRepository categoriaRepository;
	
	@Inject
	private CadastroProdutoService cadastroProdutoService;
	private Produto produto;
	@NotNull
	private Categoria categoriaPai;
	private List<Categoria> categoriasRaiz;
	private List<Categoria> subcategorias;

	@PostConstruct
	public void init() {
		produto = new Produto();
	}

	public void inicializar() {
		if (FacesUtil.isNotPostback()) {
			this.categoriasRaiz = categoriaRepository.buscarCategoriaRaizes();
		}
		
		if (this.categoriaPai != null)
		{
			carregarSubcategoria();
		}
	}
	
	public void carregarSubcategoria()
	{
		this.subcategorias = categoriaRepository.subcategoriasDe(categoriaPai);
	}

	public void salvar() {
		this.produto = cadastroProdutoService.salvar(this.produto);
		limpar();
		FacesUtil.addInfoMessage("Produto salvo com sucesso!");
	}
	
	private void limpar()
	{
		this.produto = new Produto();
		this.categoriaPai = null;
		this.categoriasRaiz = new ArrayList<>();
	}
	
	public boolean isEditando()
	{
		return this.produto.getId() != null;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		if (produto != null)
		{
			this.categoriaPai = this.produto.getCategoria().getCategoriaPai();
		}
		
	}

	public List<Categoria> getCategoriasRaiz() {
		return categoriasRaiz;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getSubcategorias() {
		return subcategorias;
	}

}
