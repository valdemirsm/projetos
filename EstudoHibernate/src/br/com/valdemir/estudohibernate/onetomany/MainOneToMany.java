package br.com.valdemir.estudohibernate.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainOneToMany {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		Condominio condominio = new Condominio();
//		condominio.setNome("Rio cachoeira");
//		em.merge(condominio);
//	
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
		
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		Condominio condominio = em.find(Condominio.class, 1);
//		System.out.println(condominio.getNome());
//		
//		CondominioCasa condominioCasa = new CondominioCasa();
//		condominioCasa.setNome("casa01");
//		condominioCasa.setCondominio(condominio);
//		em.merge(condominioCasa);
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		Condominio condominio = em.find(Condominio.class, 1);
//		System.out.println(condominio.getNome());
//		
//		for (CondominioCasa casa : condominio.getCondominioCasas()) {
//			System.out.println(casa.getNome());
//		}
//		em.close();
//		emf.close();
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
//		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		
//		Condominio condominio = em.find(Condominio.class, 1);
//		System.out.println(condominio.getNome());
//		
//		CondominioCasa condominioCasa = new CondominioCasa();
//		condominioCasa.setNome("casa01111gkkkgg");
//		condominio.getCondominioCasas().add(condominioCasa);
//		
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Condominio condominio = em.find(Condominio.class, 1);
		System.out.println(condominio.getNome());
		

		em.close();
		emf.close();
	}

}
