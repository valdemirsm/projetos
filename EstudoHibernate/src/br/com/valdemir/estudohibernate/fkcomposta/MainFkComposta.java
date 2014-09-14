package br.com.valdemir.estudohibernate.fkcomposta;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class MainFkComposta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Imposto im = new Imposto();
		im.getId().setNomeImposto("GIA");
		im.getId().setUf("MG");
		im.setValor(45);
		em.persist(im);
		
		Query query = em.createQuery("SELECT i FROM Imposto i WHERE i.id.uf = :Uf", Imposto.class);
		query.setParameter("Uf", "MG");
		List teste = query.getResultList();		
		for (int i = 0; i < teste.size(); i++) {
			Imposto im2 = (Imposto) teste.get(i);
			System.out.println(im2.getId().getNomeImposto());
		}
//		AlunoPK b = new AlunoPK();
//		b.setNome("Valdemir santos");
//		b.setNomeMae("teste");
//		Aluno a = em.find(Aluno.class, b);
//		
//		System.out.println(a.getPk().getNome());
//		
//		Prova p = new Prova();
//		p.setAluno(a);
		
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}

}
