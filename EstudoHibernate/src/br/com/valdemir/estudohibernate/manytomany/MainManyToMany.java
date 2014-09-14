package br.com.valdemir.estudohibernate.manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainManyToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Automovel a = em.find(Automovel.class, 1);
//		System.out.println(a.getOpcionals().size());
		
//		Opcional o = em.find(Opcional.class, 1);
//		System.out.println(o.getAutomovels().size());
		
		Opcional o = new Opcional();
		o.setDescricao("Marceneta");
		Automovel a = new Automovel();
		a.setDescricao("Caravam");
		a.getOpcionals().add(o);
		em.persist(a);
		

		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}

}
