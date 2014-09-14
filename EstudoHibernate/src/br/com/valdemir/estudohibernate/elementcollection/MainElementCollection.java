package br.com.valdemir.estudohibernate.elementcollection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainElementCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
		
		Grupo g = new Grupo();
		em.persist(g);
		
		Grupo gfind = em.find(Grupo.class, 2);
		System.out.println(gfind.getId() +" "+gfind.getUfs().size());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}

}
