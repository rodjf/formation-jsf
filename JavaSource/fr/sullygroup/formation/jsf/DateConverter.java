package fr.sullygroup.formation.jsf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("dateConverter")
public class DateConverter implements Converter {

	
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		SimpleDateFormat formatDate;
		Date maDate = new Date();
		
		if (arg2.contains("/")){
			formatDate = new SimpleDateFormat("dd/MM/yyyy");
		}
//		if (arg2.length() == 10) // année sur 4 car.
		else{
			formatDate  = new SimpleDateFormat("dd-MM-yyyy");
			
		}
		
		
		try {
			maDate = formatDate.parse(arg2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maDate;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		 return new SimpleDateFormat("dd/MM/yyyy").format(arg2);
		
	}

}
