package br.com.valdemir.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.valdemir.model.Usuario;
import br.com.valdemir.repository.filter.UsuarioFilter;
import br.com.valdemir.service.UsuarioService;
import br.com.valdemir.util.jsf.FacesUtil;

@Named
@SessionScoped
public class PesquisaUsuarioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuariosFiltrados;
	private UsuarioFilter usuarioFilter;
	private Usuario usuarioSelecionado;
	
	@Inject
	private UsuarioService usuarioService;

	@PostConstruct
	private void init()
	{
		usuarioFilter = new UsuarioFilter();
	}
	public void pesquisar()
	{
		usuariosFiltrados = usuarioService.pesquisar(usuarioFilter);
	}
	public void excluir()
	{
		usuarioService.excluir(usuarioSelecionado);
		usuariosFiltrados.remove(usuarioSelecionado);
		FacesUtil.addInfoMessage("Usuário "+usuarioSelecionado.getId()+" foi excluido com sucesso.");
	}
	public List<Usuario> getUsuariosFiltrados() {
		return usuariosFiltrados;
	}
	public UsuarioFilter getUsuarioFilter() {
		return usuarioFilter;
	}
	public void setUsuarioFilter(UsuarioFilter usuarioFilter) {
		this.usuarioFilter = usuarioFilter;
	}
	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}
	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}
	
	
}
