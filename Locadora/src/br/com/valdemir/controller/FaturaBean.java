package br.com.valdemir.controller;



import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import br.com.valdemir.dao.FaturaDAO;
import br.com.valdemir.model.Fatura;
import br.com.valdemir.model.Filme;

public class FaturaBean {
	private FaturaDAO faturaDAO;
	private Fatura fatura = new Fatura();
	@SuppressWarnings("unused")
	private DataModel<Filme> filmes;
	
	public void novo(){
		fatura = new Fatura();
	}

	public void inserir(ActionEvent evt){
		faturaDAO = new FaturaDAO();
	    faturaDAO.inserir(fatura);
	}


	public Fatura getFatura() {
		return fatura;
	}
}
