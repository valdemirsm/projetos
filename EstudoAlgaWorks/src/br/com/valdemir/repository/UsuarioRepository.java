package br.com.valdemir.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.valdemir.model.Usuario;
import br.com.valdemir.repository.filter.UsuarioFilter;
import br.com.valdemir.service.NegocioException;
import br.com.valdemir.util.jpa.Transactional;

public class UsuarioRepository implements Serializable{

	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager manager;
	
	public Usuario guardar(Usuario usuario)
	{
		return manager.merge(usuario);
	}
	
	public boolean verificarEmailCadastrado(String email)
	{
		Query query =  manager.createQuery("FROM Usuario WHERE email = :em", Usuario.class);
		query.setParameter("em", email);
		List<Usuario> lista =  query.getResultList();
		if (lista != null && lista.size() > 0)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> buscarUsuarioPorNome(UsuarioFilter usuarioFilter) {
		Session sessao = manager.unwrap(Session.class);
		Criteria criteria = sessao.createCriteria(Usuario.class);
		
		if (StringUtils.isNotBlank(usuarioFilter.getNome()))
		{
			criteria.add(Restrictions.like("nome" , usuarioFilter.getNome().toUpperCase(), MatchMode.ANYWHERE));
		}
		return criteria.addOrder(Order.asc("nome")).list();
	}

	public Usuario buscarUsuarioPorId(Long id) {
		return manager.find(Usuario.class, id);
	}

	@Transactional
	public void remove(Usuario usuarioSelecionado) {
		Usuario usuarioExcluir = buscarUsuarioPorId(usuarioSelecionado.getId());
		try {
			manager.remove(usuarioExcluir);
			manager.flush();
		} catch (TransactionException e) {
			new NegocioException("Usuario não pode ser excluido");
		}

	}
	
	public List<Usuario> vendedores() {
		// TODO filtrar apenas vendedores (por um grupo específico)
		return this.manager.createQuery("from Usuario", Usuario.class).getResultList();
	}
	
	public Usuario porEmail(String email)
	{
		Usuario usuario = null;
		try {
			usuario = this.manager.createQuery("from Usuario where lower(email) = :email", Usuario.class).setParameter("email", email.toLowerCase()).getSingleResult();
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		return usuario;
	}
}
