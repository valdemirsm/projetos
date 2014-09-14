package br.com.valdemir.estudohibernate.manytoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainManyToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Pessoa p = new Pessoa();
		p.setNome("Maria de Souza");
		em.persist(p);
		
//		Endereco e = new Endereco();
//		e.setEndereco("Palmeiras");
//		e.setRua("Rua palestra");
//		e.setTelefone("78454545");
//		e.setPessoa(p);
//		em.persist(e);
//
//		
//		Pessoa pe = em.find(Pessoa.class, 3);
//		for (Endereco en : pe.getEnderecos()) {
//			System.out.println(en.getEndereco());
//			en.setRua("testando");
//		}
		
//		Query query =  em.createQuery("", Pessoa.class);
//		List<Pessoa> lista = query.getResultList();
//		
//		System.out.println(lista.size());
//	
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
