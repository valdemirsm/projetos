package br.com.valdemir.estudohibernate.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class Documentacao{
	
	@Column(name="rg")
	private String rg;
	@Column(name="cpf")
	private String cpf;
	@Column(name="tituloEleitor")
	private String tituloEleitor;
	
	
	/**
	 * 
	 */
	public Documentacao() {
		super();
	}
	/**
	 * @param rg
	 * @param cpf
	 * @param tituloEleitor
	 */
	public Documentacao(String rg, String cpf, String tituloEleitor) {
		super();
		this.rg = rg;
		this.cpf = cpf;
		this.tituloEleitor = tituloEleitor;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTituloEleitor() {
		return tituloEleitor;
	}
	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}
}
