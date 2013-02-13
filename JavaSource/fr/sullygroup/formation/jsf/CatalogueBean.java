package fr.sullygroup.formation.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.librairie.dao.CategorieDao;
import org.librairie.dao.CriteresProduit;
import org.librairie.dao.ProduitDao;
import org.librairie.model.Categorie;
import org.librairie.model.Produit;

@ManagedBean
@ViewScoped
public class CatalogueBean implements Serializable {
	private List<Produit> produits;
	
	private Collection<Categorie> categories;
	
	private List<String> idLangues = new ArrayList<String>();
	
	//CriteresProduit criteresProduit;
	
	String critereTitre;
	
	String critereCategorie;
	
	private List<SelectItem> selectCategories;


	@PostConstruct
	public void init(){
		this.idLangues.add("E");
		this.idLangues.add("F");
		this.critereTitre = new String();
		this.critereCategorie = new String();
		this.selectCategories = new ArrayList<SelectItem>();
		//criteresProduit = new CriteresProduit(this.titre, idCategorie, idLangues, typePrix)
		
		this.categories = new CategorieDao().findAllCategories();
		for (Categorie element : categories){
			selectCategories.add(new SelectItem(element.getId(), element.getDescription()));
		}
		System.out.println("init de CatalogueBean");
		filtrer();
	}
	
	public void filtrer(){
		System.out.println("filtrer");
		this.produits = new ProduitDao().findProduitByCriteres(new CriteresProduit(this.critereTitre, this.critereCategorie, idLangues, null));
		
	}
	
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public Collection<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}


	public void setCategories(Collection<Categorie> categories) {
		this.categories = categories;
	}

	public String getCritereCategorie() {
		return critereCategorie;
	}

	public void setCritereCategorie(String critereCategorie) {
		this.critereCategorie = critereCategorie;
	}

	public List<String> getIdLangues() {
		return idLangues;
	}

	public void setIdLangues(List<String> idLangues) {
		this.idLangues = idLangues;
	}

	public String getCritereTitre() {
		return critereTitre;
	}

	public void setCritereTitre(String titre) {
		this.critereTitre = titre;
	}

	public List<SelectItem> getSelectCategories() {
		return selectCategories;
	}

	public void setSelectCategories(List<SelectItem> selectCategories) {
		this.selectCategories = selectCategories;
	}

	
}
