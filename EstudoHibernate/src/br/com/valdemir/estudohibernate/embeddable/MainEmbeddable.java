package br.com.valdemir.estudohibernate.embeddable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainEmbeddable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Funcionario f = new Funcionario();
		f.setIdade(45);
		f.setNome("valdemir do santos");
		f.setDocumento(new Documentacao("4578452", "78888895", "33333544"));
		em.persist(f);
		
		Funcionario fun = em.find(Funcionario.class, 1);
		System.out.println(fun.getDocumento().getCpf());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
