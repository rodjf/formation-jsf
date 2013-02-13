package fr.sullygroup.formation.jsf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.librairie.dao.CategorieDao;
import org.librairie.model.Categorie;

@ManagedBean
@ApplicationScoped
public class GlobalBean {
	
	List<SelectItem> selectItems = new ArrayList<SelectItem>();
	
	Collection<Categorie> categories;
	
	@PostConstruct
	public void load(){
		for (Categorie categorie : new CategorieDao().findAllCategories())
			selectItems.add(new SelectItem(categorie.getId(), categorie.getDescription()));
	}

	public List<SelectItem> getSelectItems() {
		return selectItems;
	}

	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}

}
