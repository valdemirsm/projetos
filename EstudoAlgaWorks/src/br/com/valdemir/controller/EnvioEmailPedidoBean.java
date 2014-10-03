package br.com.valdemir.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.valdemir.model.Pedido;
import br.com.valdemir.util.jsf.FacesUtil;

@Named
@RequestScoped
public class EnvioEmailPedidoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	@PedidoEmissao
	private Pedido pedido;
	
	public void enviarPedido() throws IOException
	{
		Properties prop = new Properties();
		prop.load(getClass().getResourceAsStream("/Mail.properties"));

		SimpleEmail email = new SimpleEmail();
		//email.setSSLOnConnect(Boolean.parseBoolean(prop.getProperty("mail.enable.ssl")));
		email.setHostName( prop.getProperty("mail.server.host"));
		//email.setSslSmtpPort(prop.getProperty("mail.server.port"));
		email.setSmtpPort(587);
		email.setAuthenticator( new DefaultAuthenticator( prop.getProperty("mail.username") ,  prop.getProperty("mail.password") ) );
		try {
		    email.setFrom( prop.getProperty("mail.from"));
		     
		    email.setDebug(true);
		     
		    email.setSubject( "Pedido: "+pedido.getId() );
		    email.setMsg( "Pedido aguardando sua autorização..." );
		    email.addTo( pedido.getCliente().getEmail());//por favor trocar antes de testar!!!!
		     
		    email.send();
		    FacesUtil.addInfoMessage("Email enviado com sucesso....");
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}

}
