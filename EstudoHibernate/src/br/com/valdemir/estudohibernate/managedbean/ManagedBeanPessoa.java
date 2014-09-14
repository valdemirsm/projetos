package br.com.valdemir.estudohibernate.managedbean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.valdemir.estudohibernate.manytoone.Pessoa;

@ManagedBean
public class ManagedBeanPessoa {
	private Pessoa pessoa = new Pessoa();

	public void salvar(Pessoa p){
		FacesContext context = FacesContext.getCurrentInstance();
		EntityManager em = 	(EntityManager) context.getExternalContext().getRequestMap().get("DevmediaPersistenceUnit");	
		em.persist(p);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public List<Pessoa> getConsultarPessoa(){
		FacesContext context = FacesContext.getCurrentInstance();
		EntityManager em = 	(EntityManager) context.getExternalContext().getRequestMap().get("DevmediaPersistenceUnit");	
		
		Query query = em.createQuery("SELECT o FROM Pessoa o", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();

		return pessoas;
		
	}
	
	public void validatorPessoa(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		FacesMessage message = new FacesMessage("Pedido popular: máximo R$ 200");
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		throw new ValidatorException(message);
	}
}
