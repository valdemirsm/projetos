package br.com.valdemir.controller;


import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;

import br.com.valdemir.dao.ClienteDAO;
import br.com.valdemir.model.Cliente;

public class ClienteBean{
	private ClienteDAO clienteDAO;
	private Cliente cliente = new Cliente();
	@SuppressWarnings("unused")
	private DataModel<Cliente> clientes;


	
	public boolean inserir(ActionEvent evt){
		clienteDAO = new ClienteDAO();
		if (cliente.getId_cliente() == 0) {
			clienteDAO.inserir(cliente);
		}
		else {
			clienteDAO.alterar(cliente);
		}
		cliente = new Cliente();
		
		return false;
	}

	public void alterar(ActionEvent evt){
		int id_cli = (Integer) evt.getComponent().getAttributes().get("id_cli"); 
		String nome_cli = (String) evt.getComponent().getAttributes().get("nome_cli"); 
		String cpf_cli = (String) evt.getComponent().getAttributes().get("cpf_cli"); 
		String rg_cli = (String) evt.getComponent().getAttributes().get("rg_cli"); 
		cliente.setId_cliente(id_cli);
		cliente.setNome(nome_cli);
		cliente.setCpf(cpf_cli);
		cliente.setRg(rg_cli);
		clienteDAO = new ClienteDAO();
		clienteDAO.alterar(cliente);
	}

	public void remover(ActionEvent event){
		int id = (Integer) event.getComponent().getAttributes().get("id_cli");  
		clienteDAO = new ClienteDAO();
		clienteDAO.remover(id);
	}

	public Cliente getCliente() {
		return cliente;
	}
	

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		clienteDAO = new ClienteDAO();
		Cliente cli = new Cliente();
		List<Cliente> clienteList = clienteDAO.listar(cli);
		return clienteList;
	}

	public void setClientes(DataModel<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public boolean valida(){
		return false;
	}
	
}
