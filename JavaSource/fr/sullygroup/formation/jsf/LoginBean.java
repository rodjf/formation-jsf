package fr.sullygroup.formation.jsf;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import org.librairie.dao.ProduitDao;
import org.librairie.model.Produit;


@ManagedBean
public class LoginBean {
	private String login;
	
	private String password;
	
	
	public LoginBean() {
		Produit produit = new ProduitDao().findProduitById(1);
		System.out.println(produit.getTitre());
	}

	@PostConstruct
	public void init(){
		System.out.println(getDateDuJour().toString() + " ===== INIT ");
	}
	
/*	public void onChangeValue(ValueChangeEvent valueChangeEvent){
		System.out.println("valeur changée");
	}
	*/
	public String connecter(){
		String retour;
		
		System.out.println("entrée dans connecter");
		
		if ("admin".equals(login))
			retour = "menu";
		else
			retour = "failure";
		
		System.out.println("retour = " + retour);
		return retour + "?faces-redirect=true";
	}

	public Date getDateDuJour(){
		System.out.println("entrée dans getDateDuJour()");
		return new Date();
	}
	
	public void onLoginChange(ValueChangeEvent valueChangeEvent){
		System.out.println("changement du login");
	}
	
	public String getLogin() {
		System.out.println("getLogin");
		return login;
	}

	public void setLogin(String login) {
		System.out.println("setlogin : login = " + login);
		this.login = login;
	}

	public String getPassword() {
		System.out.println("getpassword");
		return password;
	}

	public void setPassword(String password) {
		System.out.println("setpassword : password = "+ password);
		this.password = password;
	}

}
