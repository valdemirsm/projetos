package br.com.valdemir.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.repository.PedidoRepository;
import br.com.valdemir.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Pedido.class)
public class PedidoConverter implements Converter{
	//@Inject
		private PedidoRepository pedidoRepository;

		public PedidoConverter() {
			this.pedidoRepository = (PedidoRepository) CDIServiceLocator.getBean(PedidoRepository.class);
		}

		@Override
		public Object getAsObject(FacesContext context, UIComponent component, String value) {
			Pedido retorno = null;

			if (value != null) {
				retorno = this.pedidoRepository.porId(new Long(value));
			}

			return retorno;
		}

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value) {
			if (value != null) {
				return ((Pedido) value).getId() != null ? ((Pedido) value).getId().toString() : "";
			}
			return "";
		}

}
