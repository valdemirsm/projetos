package br.com.valdemir.util.mail;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

@RequestScoped
public class Mailer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public void novaMensagem()
	{
		SimpleEmail email = new SimpleEmail();
		email.setSSLOnConnect(true);
		email.setHostName( "smtp.seudominio.com.br" );
		email.setSslSmtpPort( "465" );
		email.setAuthenticator( new DefaultAuthenticator( "rodrigo@seudominio.com.br" ,  "1234" ) );
		try {
		    email.setFrom( "rodrigo@seudominio.com.br");
		     
		    email.setDebug(true);
		     
		    email.setSubject( "Assunto do E-mail" );
		    email.setMsg( "Texto sem formatação" );
		    email.addTo( "rodrigoaramburu@gmail.com" );//por favor trocar antes de testar!!!!
		     
		    email.send();
		     
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}
}
