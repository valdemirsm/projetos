package br.com.valdemir.estudohibernate.query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.valdemir.estudohibernate.manytoone.Pessoa;

public class ConsultaQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Query query = em.createQuery("SELECT o FROM Pessoa o", Pessoa.class);
//		List<Pessoa> enderecos = query.getResultList();
//		System.out.println(enderecos.size());
		
//		Query sql = em.createQuery("SELECT o.id, o.nome FROM Pessoa o");
//		List<Object[]> pessoas = sql.getResultList();
//		
//		for (Object[] pessoa : pessoas) {
//			System.out.println(pessoa[0]+" - "+pessoa[1]);
//		}
		
		Query sql = em.createNamedQuery(Pessoa.lista);
		List<ResumoPessoa> resumos = sql.getResultList();
		for(ResumoPessoa r : resumos){
			System.out.println(r.getId() +" - "+r.getNome());
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
