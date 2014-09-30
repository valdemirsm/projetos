package sismesa.produto;

import java.sql.BatchUpdateException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.CartesianChartModel;

import sismesa.util.DAOFactory;

public class ProdutoRN {
	private ProdutoDAO produtoDAO;

	public ProdutoRN() {
		this.produtoDAO = DAOFactory.criaProdutoDAO();
	}

	public void salvar(Produto produto) {
		int error = 0;
		if (produto.getNome() == "") {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(
									FacesMessage.SEVERITY_WARN,
									"Deve ser informado a descricao do produto!",
									null));
			error = 1;
		}
		if (produto.getUn() == "") {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Deve ser informada a Unidade!", null));
			error = 1;
		}
		if (produto.getValor_unitario() == 0) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,
							"Deve ser informado o valor unitário do produto!",
							null));
			error = 1;
		}

		if (error == 0) {
			try {
				this.produtoDAO.salvar(produto);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Processo realizado com sucesso!", null));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Não foi possível realizar a operação!", null));
			}

		}

	}

	public void excluir(Produto produto) {
		produto = this.produtoDAO.buscaProduto(produto.getCodigo());
		this.produtoDAO.excluir(produto);

	}

	public String editar(Produto produto) {
		return null;
	}

	public List<Produto> listar() {
		return this.produtoDAO.listar();
	}

	public Produto buscaProduto(int id) {
		return this.produtoDAO.buscaProduto(id);
	}
	
	public CartesianChartModel prodVendidos() {
		return this.produtoDAO.prodVendidos();
	}
}
