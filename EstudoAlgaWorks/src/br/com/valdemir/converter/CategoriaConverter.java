package br.com.valdemir.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valdemir.model.Categoria;
import br.com.valdemir.repository.CategoriaRepository;
import br.com.valdemir.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter{
	private CategoriaRepository categorias;

	public CategoriaConverter() {
		categorias = CDIServiceLocator.getBean(CategoriaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = categorias.buscarCategoriaId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			return ((Categoria) value).getId().toString();
		}

		return "";
	}

}
