package br.com.valdemir.utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ConvertDate {
	public ConvertDate(){
	}
	
	public static String ConvDatSQL(String format, Date dtConsulta){
		try {  
	        SimpleDateFormat formatter = new SimpleDateFormat(format, new Locale("pt", "BR"));  
	        return formatter.format(dtConsulta);  
	    } catch (Exception e) {  
	        return "";  
	    }
	}
}
