package br.com.valdemir.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valdemir.model.Cliente;
import br.com.valdemir.repository.ClienteRepository;
import br.com.valdemir.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Cliente.class)
public class ClienteConverter implements Converter{
	//@Inject
		private ClienteRepository clientes;

		public ClienteConverter() {
			this.clientes = (ClienteRepository) CDIServiceLocator.getBean(ClienteRepository.class);
		}

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Cliente retorno = null;

			if (value != null) {
				retorno = this.clientes.porId(new Long(value));
			}

			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				return ((Cliente) value).getId().toString();
			}
			return "";
		}

}
