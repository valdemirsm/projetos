package br.com.valdemir.controller;


import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import br.com.valdemir.dao.FilmeDAO;
import br.com.valdemir.model.Filme;

public class FilmeBean {
	private FilmeDAO filmeDAO;
	private Filme filme = new Filme();
	@SuppressWarnings("unused")
	private DataModel<Filme> filmes;


	public void inserir(ActionEvent evt){
		filmeDAO = new FilmeDAO();
		if (filme.getId_filme() == 0) {
			filmeDAO.inserir(filme);
		}
		else {
			filmeDAO.alterar(filme);
		}
		filme = new Filme();
	}

/*	public void selecionar(){
		filme = filmes.getRowData();
	}*/

	public void alterar(ActionEvent evt){
		int id_filme = (Integer) evt.getComponent().getAttributes().get("id_filme"); 
		String nome_filme = (String) evt.getComponent().getAttributes().get("nome_filme"); 
		float preco_filme = (Float) evt.getComponent().getAttributes().get("preco_filme"); 
		int qtde_filme = (Integer) evt.getComponent().getAttributes().get("qtde_filme"); 
		String genero_filme = (String) evt.getComponent().getAttributes().get("genero_filme"); 
		filme.setId_filme(id_filme);
		filme.setNome(nome_filme);
		filme.setPreco(preco_filme);
		filme.setQuantidade_estoque(qtde_filme);
		filme.setGenero(genero_filme);
		filmeDAO = new FilmeDAO();
		filmeDAO.alterar(filme);
	}

	public void remover(ActionEvent event){
		int id = (Integer) event.getComponent().getAttributes().get("id_filme"); 
		filmeDAO = new FilmeDAO();
		filmeDAO.remover(id);
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public List<Filme> getFilmes() {
		filmeDAO = new FilmeDAO();
		Filme film = new Filme();
		List<Filme> filmeList = filmeDAO.listar(film);
		//clientes = new ListDataModel<Cliente>(clienteList);
		//clientes = new ArrayList(Cliente <clienteList>;);
		return filmeList;
	}

	public void setFilmes(DataModel<Filme> filmes) {
		this.filmes = filmes;
	}
	
/*	public ArrayList  getLista() {         
		ArrayList lista = new ArrayList();     
		lista.add("Romance");   
		lista.add("Ação");
		lista.add("Drama");
		return lista;
	}   */       

}
