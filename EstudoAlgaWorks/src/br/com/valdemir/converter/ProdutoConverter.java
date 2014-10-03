package br.com.valdemir.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.valdemir.model.Produto;
import br.com.valdemir.repository.ProdutoRepository;
import br.com.valdemir.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Produto.class)
public class ProdutoConverter implements Converter{
	private ProdutoRepository produtos;

	public ProdutoConverter() {
		produtos = CDIServiceLocator.getBean(ProdutoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Produto retorno = null;

		if (value != null) {
			Long id = new Long(value);
			retorno = produtos.buscarProdutoId(id);
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Produto produto = ((Produto) value);
			return produto.getId() == null ? null : produto.getId().toString();
		}

		return "";
	}

}
