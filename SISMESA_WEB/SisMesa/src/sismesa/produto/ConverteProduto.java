package sismesa.produto;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConverteProduto implements Converter{
	private ProdutoRN produtoRN = new ProdutoRN();
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
        return produtoRN.buscaProduto(Integer.parseInt(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		Produto prod = (Produto) arg2;  
        return String.valueOf(prod.getCodigo());  
	}

}
