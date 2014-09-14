package br.com.valdemir.estudohibernate.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.valdemir.estudohibernate.onetoone.Pai;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Pai pessoaSelecionada = new Pai();
	
	public void enviar()
	{
		System.out.println(pessoaSelecionada.getNome());
	}
	
	public Pai getPessoaSelecionada() {
		return pessoaSelecionada;
	}
	public void setPessoaSelecionada(Pai pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	public List<Pai> getPessoas() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query query =  em.createQuery("SELECT p  FROM Pai p", Pai.class);
		List list = query.getResultList();
		List<Pai> lista = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			lista.add((Pai) list.get(i));
		}
		
		return lista;
	}
}
