package sismesa.mesa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import sismesa.produto.Produto;

@Entity
public class Mesa implements Serializable{
	@Id
	@GeneratedValue
	private int idmesa;
	private String descricao;
	private String situacao;
	private Date data;
	
	@ManyToOne
	@JoinColumn(name= "cod_produto", nullable = false)
	private Produto produto;
	private int qtde;
	private float vlr_unit;
	private float vlr_total;


	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public int getIdmesa() {
		return idmesa;
	}
	public void setIdmesa(int idmesa) {
		this.idmesa = idmesa;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public float getVlr_unit() {
		return vlr_unit;
	}
	public void setVlr_unit(float vlr_unit) {
		this.vlr_unit = vlr_unit;
	}
	public float getVlr_total() {
		return vlr_total;
	}
	public void setVlr_total(float vlr_total) {
		this.vlr_total = vlr_total;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + idmesa;
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + qtde;
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		result = prime * result + Float.floatToIntBits(vlr_total);
		result = prime * result + Float.floatToIntBits(vlr_unit);
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
		Mesa other = (Mesa) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idmesa != other.idmesa)
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (qtde != other.qtde)
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		if (Float.floatToIntBits(vlr_total) != Float
				.floatToIntBits(other.vlr_total))
			return false;
		if (Float.floatToIntBits(vlr_unit) != Float
				.floatToIntBits(other.vlr_unit))
			return false;
		return true;
	}

	
}
