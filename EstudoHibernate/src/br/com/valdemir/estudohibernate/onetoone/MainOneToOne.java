package br.com.valdemir.estudohibernate.onetoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainOneToOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Query query =  em.createQuery("SELECT pai  FROM Pai pai", Pai.class);
		List<Pai> lista = query.getResultList();
		
		System.out.println(lista.size());
		
		//teste6666666666
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
