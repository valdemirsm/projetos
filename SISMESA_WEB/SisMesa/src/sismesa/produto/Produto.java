package sismesa.produto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Produto implements Serializable{
	@Id
	@GeneratedValue
	private int codigo;
	private String nome;
	private int tipo;
	private float valor_unitario;
	private String un;
	private float saldo_estoque;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public float getValor_unitario() {
		return valor_unitario;
	}
	public void setValor_unitario(float valor_unitario) {
		this.valor_unitario = valor_unitario;
	}
	public String getUn() {
		return un;
	}
	public void setUn(String un) {
		this.un = un;
	}
	public float getSaldo_estoque() {
		return saldo_estoque;
	}
	public void setSaldo_estoque(float saldo_estoque) {
		this.saldo_estoque = saldo_estoque;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(saldo_estoque);
		result = prime * result + tipo;
		result = prime * result + ((un == null) ? 0 : un.hashCode());
		result = prime * result + Float.floatToIntBits(valor_unitario);
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
		Produto other = (Produto) obj;
		if (codigo != other.codigo)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(saldo_estoque) != Float
				.floatToIntBits(other.saldo_estoque))
			return false;
		if (tipo != other.tipo)
			return false;
		if (un == null) {
			if (other.un != null)
				return false;
		} else if (!un.equals(other.un))
			return false;
		if (Float.floatToIntBits(valor_unitario) != Float
				.floatToIntBits(other.valor_unitario))
			return false;
		return true;
	}
	
	

}
