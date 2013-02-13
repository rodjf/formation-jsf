package fr.sullygroup.formation.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "passwordValidator")
public class PasswordValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ValidatorException {
		String champ = new String(arg2.toString());
		if (champ.startsWith("!")){
			if (! champ.endsWith("!")){
				throw new ValidatorException(new FacesMessage("Le mot de passe commençant par '!' doit aussi se terminer par '!'"));
			}
		}
		
	}

}
