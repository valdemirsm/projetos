import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.valdemir.model.Categoria;
import br.com.valdemir.model.Cliente;
import br.com.valdemir.model.Endereco;
import br.com.valdemir.model.TipoPessoa;


public class teste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PedidoPu");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		Categoria cate =  new Categoria();
//		cate.setDescricao("teste");
//		em.persist(cate);
		
		List<Categoria> categorias = em.createQuery("from Categoria", Categoria.class).getResultList();
		
		System.out.println(categorias.size());
		
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Valdemir");
//		cliente.setEmail("demir@hotmail.com");
//		cliente.setDocumentoReceitaFederal("454545");
//		cliente.setTipo(TipoPessoa.FISICA);
//		
//		Endereco end = new Endereco();
//		end.setLogradouro("tesasdf");
//		end.setNumero("1212");
//		end.setCidade("cidade");
//		end.setUf("MT");
//		end.setCep("78700-000");
//		end.setCliente(cliente);
//		
//		cliente.getEnderecos().add(end);
//		
//		em.persist(cliente);
		em.getTransaction().commit();

	}

}
