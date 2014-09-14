package br.com.valdemir.estudohibernate.fkcomposta;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ImpostoPk implements Serializable{
	private String nomeImposto;
	private String uf;
	public String getNomeImposto() {
		return nomeImposto;
	}
	public void setNomeImposto(String nomeImposto) {
		this.nomeImposto = nomeImposto;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	
}
