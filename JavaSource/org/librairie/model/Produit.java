/*
 * Created on 1 oct. 2004
 */
package org.librairie.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author oh
 */
public class Produit  implements Serializable {
	private static final long serialVersionUID = 3025782994491000436L;
	
	private Long id;
    private String titre;
    private String isbn;
    private String editeur;
    private String auteur;
    private int nbPages;
    private String langue;
    private Date dateParution;
    private String tableMatiere;
    private float prix;
    private boolean disponible;
    private Categorie categorie;
    /**
     * @return Returns the auteur.
     */
    public String getAuteur() {
        return auteur;
    }
    /**
     * @param auteur The auteur to set.
     */
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
    /**
     * @return Returns the categorie.
     */
    public Categorie getCategorie() {
        return categorie;
    }
    /**
     * @param categorie The categorie to set.
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    /**
     * @return Returns the dateParution.
     */
    public Date getDateParution() {
        return dateParution;
    }
    /**
     * @param dateParution The dateParution to set.
     */
    public void setDateParution(Date dateParution) {
        this.dateParution = dateParution;
    }
    /**
     * @return Returns the editeur.
     */
    public String getEditeur() {
        return editeur;
    }
    /**
     * @param editeur The editeur to set.
     */
    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }
    /**
     * @return Returns the enStock.
     */
    public boolean isDisponible() {
        return disponible;
    }
    /**
     * @param enStock The enStock to set.
     */
    public void setDisponible(boolean enStock) {
        this.disponible = enStock;
    }
    /**
     * @return Returns the id.
     */
    public Long getId() {
        return id;
    }
    /**
     * @param id The id to set.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * @return Returns the isbn.
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * @param isbn The isbn to set.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * @return Returns the langue.
     */
    public String getLangue() {
        return langue;
    }
    /**
     * @param langue The langue to set.
     */
    public void setLangue(String langue) {
        this.langue = langue;
    }
    /**
     * @return Returns the nbPages.
     */
    public int getNbPages() {
        return nbPages;
    }
    /**
     * @param nbPages The nbPages to set.
     */
    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }
    /**
     * @return Returns the prix.
     */
    public float getPrix() {
        return prix;
    }
    /**
     * @param prix The prix to set.
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }
    /**
     * @return Returns the tableMatiere.
     */
    public String getTableMatiere() {
        return tableMatiere;
    }
    /**
     * @param tableMatiere The tableMatiere to set.
     */
    public void setTableMatiere(String tableMatiere) {
        this.tableMatiere = tableMatiere;
    }
    /**
     * @return Returns the titre.
     */
    public String getTitre() {
        return titre;
    }
    /**
     * @param titre The titre to set.
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id=").append(id)
          .append(",titre=").append(titre)
          .append(",editeur=").append(editeur)
          .append(",isbn=").append(isbn)
          .append(",nbPages=").append(nbPages)
          .append(",langue=").append(langue)
          .append(",dateParution=").append(dateParution)
          .append(",tableMatiere=").append(tableMatiere)
          .append(",prix=").append(prix)
          .append(",enStock=").append(disponible)
          .append("]");
        return sb.toString();
    }
}
