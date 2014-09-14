package br.com.valdemir.estudohibernate.fkcomposta;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity(name="aluno")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AlunoPK pk;

	public AlunoPK getPk() {
		return pk;
	}

	public void setPk(AlunoPK pk) {
		this.pk = pk;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		Aluno other = (Aluno) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}
	
	
}
