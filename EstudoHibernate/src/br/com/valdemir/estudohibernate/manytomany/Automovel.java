package br.com.valdemir.estudohibernate.manytomany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="automovel")
public class Automovel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Integer id;
	@Column(name="descricao")
	private String descricao;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="automovel_opcional", joinColumns=@JoinColumn(name="id_automovel"), inverseJoinColumns=@JoinColumn(name="id_opcional"))
	private Collection<Opcional> opcionals;
	
	
	public Automovel() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Collection<Opcional> getOpcionals() {
		if (opcionals == null){
			opcionals = new ArrayList<Opcional>();
		}
		return opcionals;
	}

	public void setOpcionals(Collection<Opcional> opcionals) {
		this.opcionals = opcionals;
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
		Automovel other = (Automovel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
