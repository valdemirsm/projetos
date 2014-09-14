package br.com.valdemir.estudohibernate.fkcomposta;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Imposto implements Serializable{
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private ImpostoPk id;
	private long valor;
	public ImpostoPk getId() {
		if (id == null)
			id = new ImpostoPk();
		return id;
	}
	public void setId(ImpostoPk id) {
		this.id = id;
	}
	public long getValor() {
		return valor;
	}
	public void setValor(long valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imposto other = (Imposto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
