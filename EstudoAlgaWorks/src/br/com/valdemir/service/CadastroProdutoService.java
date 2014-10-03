package br.com.valdemir.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.valdemir.model.Produto;
import br.com.valdemir.repository.ProdutoRepository;
import br.com.valdemir.util.jpa.Transactional;

public class CadastroProdutoService implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto salvar(Produto produto)
	{
		Produto produtoExistente = produtoRepository.porSku(produto.getSku());
		if (produtoExistente != null && !produtoExistente.equals(produto))
		{
			throw new NegocioException("Já existe um produto com SKU informado.");
		}
		return produtoRepository.guardar(produto);
	}
	
}
