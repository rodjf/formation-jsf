package org.librairie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.librairie.model.Categorie;
import org.librairie.model.Produit;

public class ProduitDao extends AbstractDao {
	private final static Log log = LogFactory.getLog(ProduitDao.class);

    public ProduitDao() {}
    public ProduitDao(boolean resource) {
        super(resource);
    }
    
    public void createProduit(Produit p) {
        String query = 
            "insert into produit (id,titre,isbn,editeur,auteur,nb_pages,langue," +
            "date_parution,table_matiere,prix,disponible,categorie_id) " + 
            "values (?,?,?,?,?,?,?,?,?,?,?,?) ";

        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = getConnection();
            st = connection.prepareStatement(query);
            int id = findMaxProduitId() + 1;
            st.setInt(1, id);
            st.setString(2, p.getTitre());
            st.setString(3, p.getIsbn());
            st.setString(4, p.getEditeur());
            st.setString(5, p.getAuteur());
            st.setInt(6, p.getNbPages());
            st.setString(7, p.getLangue());
            st.setDate(8, new Date(p.getDateParution().getTime()));
            st.setString(9, p.getTableMatiere());
            st.setFloat(10, p.getPrix());
            st.setBoolean(11, p.isDisponible());
            st.setInt(12, p.getCategorie().getId().intValue());
            
            st.executeUpdate();
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(st);
            close(connection);
        }
    }
    
    private int findMaxProduitId() {
        String query = "select max(id) from produit";

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        int max = 1;
        try {
            connection = getConnection();
            st = connection.prepareStatement(query);
            rs = st.executeQuery();
            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(st);
            close(connection);
        }
        return max;
    }

    public Produit findProduitById(long id) {
        String query = 
            "select id,titre,isbn,editeur,auteur,nb_pages,langue," +
            "date_parution,table_matiere,prix,disponible,categorie_id " + 
    		"from produit where id = ?";

        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Produit  produit = null;
        try {
            connection = getConnection();
            st = connection.prepareStatement(query);
            st.setLong(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                produit = populate(rs);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(st);
            close(connection);
        }
        return produit;
    }

    public List<Produit> findProduitByCriteres(CriteresProduit criteres) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Produit> produits = new ArrayList<Produit>();
        try {
        	// Construction de la chaîne de requête
        	StringBuffer query = new StringBuffer();
        	query.append("select id,titre,isbn,editeur,auteur,nb_pages,langue,")
        		 .append("date_parution,table_matiere,prix,disponible,categorie_id ")
        		 .append("from produit where 1=1");
        	if (criteres.getIdCategorie() != null && !criteres.getIdCategorie().equals("")) {
        		query.append(" and categorie_id = ").append(criteres.getIdCategorie());
        	}
        	if (criteres.getTitre() != null && !criteres.getTitre().equals("")) {
        		query.append(" and titre like '%").append(criteres.getTitre()).append("%'");
        	}
        	if ("P30".equals(criteres.getTypePrix())) {
        		query.append(" and prix < 30");
        	}
        	query.append(" and langue in ('',");
        	for (Iterator itLangues = criteres.getIdLangues().iterator(); itLangues.hasNext();) {
				String langue = (String) itLangues.next();
				query.append("'").append(langue).append("',");
			}
        	query.deleteCharAt(query.length() - 1);
        	query.append(")");
        	log.info("Requ�te findProduit : " + query);
        	
            connection = getConnection();
            st = connection.prepareStatement(query.toString());
            rs = st.executeQuery();
            while (rs.next()) {
                produits.add(populate(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(st);
            close(connection);
        }
        return produits;
    }

    private Produit populate(ResultSet rs) throws SQLException {
        Produit produit = new Produit();
        produit.setId(new Long(rs.getInt(1)));
        produit.setTitre(rs.getString(2));
        produit.setIsbn(rs.getString(3));
        produit.setEditeur(rs.getString(4));
        produit.setAuteur(rs.getString(5));
        produit.setNbPages(rs.getInt(6));
        produit.setLangue(rs.getString(7));
        produit.setDateParution(rs.getDate(8));
        produit.setTableMatiere(rs.getString(9));
        produit.setPrix(rs.getFloat(10));
        produit.setDisponible(rs.getBoolean(11));
        Long categorieId = new Long(rs.getLong(12));
        
        CategorieDao categorieDao = new CategorieDao();
        Categorie categorie = categorieDao.findCategorieById(categorieId.longValue());
        produit.setCategorie(categorie);
        return produit;
    }
}
