package sismesa.mesa;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.Query;

import sismesa.util.DAOFactory;

public class MesaRN {
	private MesaDAO mesaDAO;

	public MesaRN() {
		this.mesaDAO = DAOFactory.criaMesaDAO();
	}

	public void salvar(Mesa mesa) {
		int error = 0;
		if (mesa.getQtde() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,"Deve ser informado a quantidade!",null));
			error = 1;
		}
		if (mesa.getVlr_unit() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,"Deve ser informado o valor unitario!",null));
			error = 1;
		}
		if (mesa.getDescricao() == "") {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,"Deve ser informado a mesa!",null));
			error = 1;
		}
		if (mesa.getProduto().getCodigo() == 0) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN,"Deve ser informado o produto!",null));
			error = 1;
		}
		
		if (error == 0) {
			try {
				mesa.setSituacao("Aberto");
				this.mesaDAO.salvar(mesa);
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,"Processo realizado com sucesso!",null));
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,"Não foi possível realizar a operação!",null));
			}
			
			
		}
	}

	public void excluir(Mesa mesa) {
		this.mesaDAO.excluir(mesa);
	}

	public String editar(Mesa mesa) {
		return null;
	}

	public List<Mesa> listar() {
		return this.mesaDAO.listar();
	}
	
	public List<Mesa> listarAbertas() {
		return this.mesaDAO.listarAbertas();
	}
}
