package org.librairie.dao;

import java.util.List;

public class CriteresProduit {
	private String titre;
	private String idCategorie;
	private List<String> idLangues;
	private String typePrix;
	
	public CriteresProduit(String titre, String idCategorie, List<String> idLangues, String typePrix) {
		this.titre = titre;
		this.idCategorie = idCategorie;
		this.idLangues = idLangues;
		this.typePrix = typePrix;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

	public List getIdLangues() {
		return idLangues;
	}

	public String getTitre() {
		return titre;
	}

	public String getTypePrix() {
		return typePrix;
	}
}
