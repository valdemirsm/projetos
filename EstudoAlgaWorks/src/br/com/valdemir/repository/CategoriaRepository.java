package br.com.valdemir.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.valdemir.model.Categoria;

public class CategoriaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public Categoria buscarCategoriaId(Long id)
	{
		return manager.find(Categoria.class, id);
	}

	public List<Categoria> buscarCategoriaRaizes()
	{
		return manager.createQuery("FROM Categoria c WHERE c.categoriaPai IS NULL", Categoria.class).getResultList();
	}

	public List<Categoria> subcategoriasDe(Categoria categoriaPai) {
		return manager.createQuery("FROM Categoria WHERE categoriaPai = :raiz", Categoria.class).setParameter("raiz", categoriaPai).getResultList();
	}
}
