package br.com.valdemir.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valdemir.model.Usuario;
import br.com.valdemir.repository.UsuarioRepository;
import br.com.valdemir.util.cdi.CDIServiceLocator;

@FacesConverter(forClass=Usuario.class)
public class UsuarioConverter implements Converter{
	
	private UsuarioRepository usuarioRepository;
	
	public UsuarioConverter()
	{
		usuarioRepository = CDIServiceLocator.getBean(UsuarioRepository.class);
	}
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario usuario = null;
		if (value != null)
		{
			Long id = new Long(value);
			usuario = usuarioRepository.buscarUsuarioPorId(id);
		}
		return usuario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null)
		{
			Usuario usuario = (Usuario) value;
			return usuario.getId() == null ? "" : usuario.getId().toString();
		}
		return "";
	}

}
