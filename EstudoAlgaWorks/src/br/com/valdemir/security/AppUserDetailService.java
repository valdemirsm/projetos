package br.com.valdemir.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.valdemir.model.Grupo;
import br.com.valdemir.model.Usuario;
import br.com.valdemir.repository.UsuarioRepository;
import br.com.valdemir.util.cdi.CDIServiceLocator;

public class AppUserDetailService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		UsuarioRepository usuarios  = CDIServiceLocator.getBean(UsuarioRepository.class);
		Usuario usuario = usuarios.porEmail(email);
		UsuarioSistema user = null;
		
		if (usuario != null)
		{
			user = new UsuarioSistema(usuario, getGrupos(usuario));
		}
		return user;
	}

	private Collection<? extends GrantedAuthority> getGrupos(Usuario usuario) {
		List<SimpleGrantedAuthority> authorities =  new ArrayList<>();
		
		for (Grupo grupo : usuario.getGrupos())
		{
			authorities.add(new SimpleGrantedAuthority(grupo.getNome().toUpperCase()));
		}
		return authorities;
	}

}
