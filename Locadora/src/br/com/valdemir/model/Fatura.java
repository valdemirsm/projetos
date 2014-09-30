package br.com.valdemir.model;

import java.util.Date;

public class Fatura {
	private int id_fatura;
	private int id_cliente;
	private String nome_cliente;
	private Date data_pagamento;
	private Date data_retirada;
	public int getId_fatura() {
		return id_fatura;
	}
	public void setId_fatura(int id_fatura) {
		this.id_fatura = id_fatura;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
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
