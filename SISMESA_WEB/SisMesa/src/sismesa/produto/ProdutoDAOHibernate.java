package sismesa.produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

public class ProdutoDAOHibernate implements ProdutoDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Produto produto) {
		this.session.saveOrUpdate(produto);
	}

	@Override
	public void excluir(Produto produto) {
		try {
			this.session.delete(produto);
			this.session.flush();

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Não foi possível realizar a operação!", null));
		}

	}

	@Override
	public List<Produto> listar() {
		Criteria criteria = this.session.createCriteria(Produto.class);
		return criteria.list();
	}

	@Override
	public Produto buscaProduto(int codigo) {
		String hql = "from Produto p where p.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (Produto) consulta.uniqueResult();
	}

	@Override
	public CartesianChartModel prodVendidos() {
		int anoAnterior = 0;
		int codigoAnterior = 0;
		String hql = "select m.data, produto.codigo from Mesa m inner join m.produto as produto group by m.data, produto.codigo";
		Query consulta = this.session.createQuery(hql);

		List lista = consulta.list();

		ArrayList arAno = new ArrayList();
		ArrayList arProduto = new ArrayList();
		CartesianChartModel categoryModel = new CartesianChartModel();

		for (int i = 0; i < lista.size(); i++) {

			Object[] obj = (Object[]) lista.get(i);

			Date data = (Date) obj[0];
			GregorianCalendar calendario = new GregorianCalendar();
			calendario.setTime(data);
			int ano = calendario.get(calendario.YEAR);
			if (ano != anoAnterior) {
				arAno.add(arAno.size(), ano);
			}
			anoAnterior = ano;

			int codigo = (Integer) obj[1];
			if (codigo != codigoAnterior) {
				arProduto.add(arProduto.size(), codigo);
			}
			codigoAnterior = codigo;

		}

		for (int a = 0; a < arProduto.size(); a++) {
			ChartSeries prod = new ChartSeries();
			prod.setLabel((String) this.session.createQuery("select nome from Produto where codigo= "+arProduto.get(a)).uniqueResult());
			for (int b = 0; b < arAno.size(); b++) {
				String hql2 = "select sum(m.vlr_total) from Mesa m inner join m.produto as produto where produto.codigo = :cod_produto and STR(m.data,'yyyy') = :data";
				Query consulta2 = this.session.createQuery(hql2);
				consulta2.setInteger("cod_produto", (Integer) arProduto.get(a));
				consulta2.setInteger("data", (Integer) arAno.get(b));
				Double valor = (Double) consulta2.uniqueResult();

				if (valor == null)
					valor = (double) 0;
				
				prod.set(arAno.get(b).toString(), valor);
				System.out.println(valor);
			}
			categoryModel.addSeries(prod);
		}

		/*
		 * String hql =
		 * "select m.data, produto.nome, sum(m.vlr_total) from Mesa m inner join m.produto as produto group by m.data, produto.nome"
		 * ; Query consulta = this.session.createQuery(hql);
		 * 
		 * List lista = consulta.list();
		 * 
		 * 
		 * CartesianChartModel categoryModel = new CartesianChartModel();
		 * 
		 * for(int i =0; i < lista.size(); i++){ Object[] obj = (Object[] )
		 * lista.get(i); Date data = (Date)obj[0];
		 * 
		 * GregorianCalendar calendario = new GregorianCalendar();
		 * calendario.setTime(data); int ano = calendario.get(calendario.YEAR);
		 * String nome = (String)obj[1]; double valor = (Double)obj[2];
		 * 
		 * ChartSeries produto = new ChartSeries(); produto.setLabel(nome);
		 * produto.set(String.valueOf(ano), valor);
		 * 
		 * System.out.println(nome); System.out.println(ano);
		 * System.out.println(valor); categoryModel.addSeries(produto); }
		 */

		/*
		 * CartesianChartModel categoryModel = new CartesianChartModel();
		 * 
		 * ChartSeries boys = new ChartSeries(); boys.setLabel("Boys");
		 * 
		 * boys.set("2004", 120); boys.set("2005", 100);
		 * 
		 * 
		 * ChartSeries girls = new ChartSeries(); girls.setLabel("Girls");
		 * 
		 * girls.set("2004", 0); girls.set("2005", 100);
		 * 
		 * 
		 * 
		 * categoryModel.addSeries(boys); categoryModel.addSeries(girls);
		 */
		return categoryModel;

	}

}
