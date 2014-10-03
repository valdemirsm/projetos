package br.com.valdemir.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.valdemir.model.Usuario;
import br.com.valdemir.repository.UsuarioRepository;
import br.com.valdemir.repository.filter.UsuarioFilter;
import br.com.valdemir.util.jpa.Transactional;

public class UsuarioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario)
	{
		if (usuario != null && usuario.getId() == null && usuarioRepository.verificarEmailCadastrado(usuario.getEmail()))
		{
			throw new NegocioException("E-mail já cadastrado");
		}
		return usuarioRepository.guardar(usuario);
	}

	public List<Usuario> pesquisar(UsuarioFilter usuarioFilter) {
		return usuarioRepository.buscarUsuarioPorNome(usuarioFilter);
	}

	public void excluir(Usuario usuarioSelecionado) {
		usuarioRepository.remove(usuarioSelecionado);
	}
	
}
