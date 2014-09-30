package sismesa.produto;

import javax.persistence.Entity;

@Entity
public class ProdutosVendidos {
	private String nomeproduto;
	private float valorvendido;
	public String getNomeproduto() {
		return nomeproduto;
	}
	public void setNomeproduto(String nomeproduto) {
		this.nomeproduto = nomeproduto;
	}
	public float getValorvendido() {
		return valorvendido;
	}
	public void setValorvendido(float valorvendido) {
		this.valorvendido = valorvendido;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeproduto == null) ? 0 : nomeproduto.hashCode());
		result = prime * result + Float.floatToIntBits(valorvendido);
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
		ProdutosVendidos other = (ProdutosVendidos) obj;
		if (nomeproduto == null) {
			if (other.nomeproduto != null)
				return false;
		} else if (!nomeproduto.equals(other.nomeproduto))
			return false;
		if (Float.floatToIntBits(valorvendido) != Float
				.floatToIntBits(other.valorvendido))
			return false;
		return true;
	}
	
	
	
}
