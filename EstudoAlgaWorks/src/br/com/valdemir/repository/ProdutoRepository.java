package br.com.valdemir.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.valdemir.model.Categoria;
import br.com.valdemir.model.Produto;
import br.com.valdemir.repository.filter.ProdutoFilter;
import br.com.valdemir.service.NegocioException;
import br.com.valdemir.util.jpa.Transactional;

public class ProdutoRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public Produto guardar(Produto produto) {
		return manager.merge(produto);
	}

	public Produto porSku(String sku) {
		// TODO Auto-generated method stub
		try {
			return manager.createQuery("FROM Produto WHERE upper(sku) = :sku", Produto.class).setParameter("sku", sku.toUpperCase()).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		 
	}
	
	@SuppressWarnings("unchecked")
	public List<Produto> filtrados(ProdutoFilter filtro)
	{
		Session session = manager.unwrap(Session.class);
		Criteria criteria = session.createCriteria(Produto.class);
		if (StringUtils.isNotBlank(filtro.getSku()))
		{
			criteria.add(Restrictions.eq("sku", filtro.getSku()));
		}
		if (StringUtils.isNotBlank(filtro.getNome()))
		{
			criteria.add(Restrictions.like("nome", filtro.getNome(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Produto buscarProdutoId(Long id) {
		return manager.find(Produto.class, id);
	}
	
	@Transactional
	public void remover(Produto produto)
	{
		try {
			produto = buscarProdutoId(produto.getId());
			manager.remove(produto);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Produto não pode ser excluido");
		}

	}

	public List<Produto> porNome(String nome) {
		return this.manager.createQuery("from Produto where upper(nome) like :nome",Produto.class).setParameter("nome", nome.toUpperCase()+ "%").getResultList();
	}

}
