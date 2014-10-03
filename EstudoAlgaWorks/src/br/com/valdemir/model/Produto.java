package br.com.valdemir.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import br.com.valdemir.service.NegocioException;
import br.com.valdemir.validation.SKU;


@Entity
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	@NotBlank  @SKU
	@Column(unique=true)						
	private String sku;		
	@NotNull
	@Column(name="valor_unitario", precision=10, scale=2)
	private BigDecimal valorUnitario;
	@NotNull @Min(0) @Max(value=999, message="tem um valor muito auto")
	@Column(name="quantidade_estoque", length=4)
	private Integer quantidadeEstoque;
	
	@NotNull
	@ManyToOne
	@JoinColumn(nullable=false)
	private Categoria categoria;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public void baixarEstoque(Integer quantidade) {
		int novaQuantidade = this.getQuantidadeEstoque() - quantidade;
		if (novaQuantidade < 0)
		{
			throw new NegocioException("Não há disponibilidade no estoque de "+quantidade+
					" item do produto "+ this.getSku()+ ".");
		}
		this.quantidadeEstoque = novaQuantidade;
	}
	public void adicionarEstoque(Integer quantidade) {
		this.setQuantidadeEstoque(this.quantidadeEstoque + quantidade);
		
	}

	
}
