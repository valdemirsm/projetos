package br.com.valdemir.controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valdemir.model.Usuario;
import br.com.valdemir.service.UsuarioService;
import br.com.valdemir.util.jsf.FacesUtil;

@Named
@SessionScoped
public class CadastroUsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioService usuarioService;
	
	private Usuario usuario;
	
	@PostConstruct
	public void init()
	{
		usuario = new Usuario();
	}
	
	public void salvar()
	{
		usuarioService.salvar(usuario);
		limpar();
		FacesUtil.addInfoMessage("Usuário salvo com sucesso!");
	}
	
	private void limpar() {
		usuario = new Usuario();
	}
	
	public boolean isEditando()
	{
		return usuario.getId() == null? false : true;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
