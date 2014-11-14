package br.com.valdemir;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import br.com.valdemir.model.ModelInputTextarea;
import br.com.valdemir.model.ModelLista;

@javax.faces.bean.ManagedBean
@SessionScoped
public class ManagedBean {
	
	private ModelInputTextarea modelInputTextarea;
	private String inputSecret;
	private String inputHidden;
	private String valorSelecionadoOneMenu;
	private List<ModelLista> lista;
	private List<ModelLista> listaSelecionada;
	private Boolean habilitaCampo;
	private Part uploadeFile;
	private ModelLista modelLista;
	private Double valor = 10.21;
	
	public ManagedBean() {
		super();
	}

	@PostConstruct
	public void init()
	{
		modelInputTextarea = new ModelInputTextarea();
		modelLista = new ModelLista();
		listaSelectOneMenu();
	}
	
	private void listaSelectOneMenu()
	{
		lista = new ArrayList<ModelLista>();
		for (int i = 0; i < 10; i++) 
		{
			ModelLista m = new ModelLista();
			m.setId(i);
			m.setDescricao("nome"+i);
			lista.add(m);
		}
	}
	
	public void salvarImagem()
	{
		try {
			InputStream is = uploadeFile.getInputStream();
			// Estudar mais----
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String inputText;

	public String getInputText() {
		return inputText;
	}

	public void setInputText(String inputText) {
		this.inputText = inputText;
	}

	public ModelInputTextarea getModelInputTextarea() {
		return modelInputTextarea;
	}

	public void setModelInputTextarea(ModelInputTextarea modelInputTextarea) {
		this.modelInputTextarea = modelInputTextarea;
	}

	public String getInputSecret() {
		return inputSecret;
	}

	public void setInputSecret(String inputSecret) {
		this.inputSecret = inputSecret;
	}

	public String getInputHidden() {
		return inputHidden;
	}

	public void setInputHidden(String inputHidden) {
		this.inputHidden = inputHidden;
	}

	public String getValorSelecionadoOneMenu() {
		return valorSelecionadoOneMenu;
	}

	public void setValorSelecionadoOneMenu(String valorSelecionadoOneMenu) {
		this.valorSelecionadoOneMenu = valorSelecionadoOneMenu;
	}

	public List<ModelLista> getLista() {
		return lista;
	}

	public void setLista(List<ModelLista> lista) {
		this.lista = lista;
	}

	public List<ModelLista> getListaSelecionada() {
		return listaSelecionada;
	}

	public void setListaSelecionada(List<ModelLista> listaSelecionada) {
		this.listaSelecionada = listaSelecionada;
	}

	public Boolean getHabilitaCampo() {
		return habilitaCampo;
	}

	public void setHabilitaCampo(Boolean habilitaCampo) {
		this.habilitaCampo = habilitaCampo;
	}

	public Part getUploadeFile() {
		return uploadeFile;
	}

	public void setUploadeFile(Part uploadeFile) {
		this.uploadeFile = uploadeFile;
	}

	public ModelLista getModelLista() {
		return modelLista;
	}

	public void setModelLista(ModelLista modelLista) {
		this.modelLista = modelLista;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	
}
