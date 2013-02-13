package fr.sullygroup.formation.jsf;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;


@ManagedBean
public class DateBean {
	
	private Date maDate;

	@PostConstruct
	public void init(){
		maDate = new Date();
	}
	
	public Date getMaDate() {
		return maDate;
	}

	public void setMaDate(Date maDate) {
		this.maDate = maDate;
	}
	
	

}
