package br.com.valdemir.util;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valdemir.ManagedBean;
import br.com.valdemir.model.ModelLista;

@FacesConverter(value="converterModel")
public class ConverterModel implements Converter{

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		ModelLista retorno = null;
		if (arg2 == null || arg2.isEmpty()){
			return null;
		}
		ManagedBean m = new ManagedBean();
		
		for(ModelLista l : m.listaSelectOneMenu())
		{
			if(l.getId() == Integer.parseInt(arg2))
			{
				retorno = l;
			}
		}
		// ModelLista lista = (ModelLista) arg2;
		return retorno;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		ModelLista lista = (ModelLista) arg2;
		if (lista == null || lista.getId() == null)
		{
			return null;
		}
		
		return lista.getId().toString();
	}

}
