package br.com.valdemir.model;

import java.util.Date;

public class ItemFatura {
	private int id_filme_alugado;
	private int id_fatura;
	private int id_filme;
	private String nome_cliente;
	private String nome_filme;
	private float preco_filme;
	private int situacao;
	private String desc_situacao;
	private Date data_devolucao;
	private Date data_pagamento;
	private Date data_retirada;
	public int getId_filme_alugado() {
		return id_filme_alugado;
	}
	public void setId_filme_alugado(int id_filme_alugado) {
		this.id_filme_alugado = id_filme_alugado;
	}
	public int getId_fatura() {
		return id_fatura;
	}
	public void setId_fatura(int id_fatura) {
		this.id_fatura = id_fatura;
	}
	public int getId_filme() {
		return id_filme;
	}
	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getNome_filme() {
		return nome_filme;
	}
	public void setNome_filme(String nome_filme) {
		this.nome_filme = nome_filme;
	}
	public float getPreco_filme() {
		return preco_filme;
	}
	public void setPreco_filme(float preco_filme) {
		this.preco_filme = preco_filme;
	}
	public int getSituacao() {
		return situacao;
	}
	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	public String getDesc_situacao() {
		return desc_situacao;
	}
	public void setDesc_situacao(String desc_situacao) {
		this.desc_situacao = desc_situacao;
	}
	public Date getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public Date getData_pagamento() {
		return data_pagamento;
	}
	public void setData_pagamento(Date data_pagamento) {
		this.data_pagamento = data_pagamento;
	}
	public Date getData_retirada() {
		return data_retirada;
	}
	public void setData_retirada(Date data_retirada) {
		this.data_retirada = data_retirada;
	}
	
	
}
