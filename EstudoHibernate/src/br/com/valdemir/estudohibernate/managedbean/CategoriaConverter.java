package br.com.valdemir.estudohibernate.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.valdemir.estudohibernate.onetoone.Pai;

@FacesConverter(forClass = Pai.class)
public class CategoriaConverter implements Converter{
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null)
		{
			Integer id = new Integer(value);
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevmediaPersistenceUnit");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			
			Pai query =  em.find(Pai.class, id);
			return query;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent compenent, Object value) {
		if (value != null)
		{
			if (((Pai) value).getId() != null)
			{
				return ((Pai) value).getId().toString();
			}
			return "";
		}
		return "";
	}

}
