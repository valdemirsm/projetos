package sismesa.util;

import sismesa.mesa.MesaDAO;
import sismesa.mesa.MesaDAOHibernate;
import sismesa.produto.ProdutoDAO;
import sismesa.produto.ProdutoDAOHibernate;

public class DAOFactory {
	public static ProdutoDAO criaProdutoDAO(){
		ProdutoDAOHibernate produtoDAOHibernate = new ProdutoDAOHibernate();
		produtoDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return produtoDAOHibernate;
	}
	public static MesaDAO criaMesaDAO(){
		MesaDAOHibernate mesaDAOHibernate = new MesaDAOHibernate();
		mesaDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return mesaDAOHibernate;
	}
}
