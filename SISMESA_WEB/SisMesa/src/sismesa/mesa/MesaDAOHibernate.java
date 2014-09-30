package sismesa.mesa;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import sismesa.produto.Produto;


public class MesaDAOHibernate implements MesaDAO{
	private Session session;
	
	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Mesa mesa) {
		mesa.setData(new Date());
		this.session.saveOrUpdate(mesa);
	}

	@Override
	public void excluir(Mesa mesa) {
		this.session.delete(mesa);
		
	}

	@Override
	public List<Mesa> listar() {
		Criteria criteria = this.session.createCriteria(Mesa.class);
		return criteria.list();
	}

	@Override
	public List<Mesa> listarAbertas() {
		String hql = "from Mesa m where m.situacao = :situacao";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("situacao", "Aberto");
		return (List<Mesa>) consulta;
	}

}
