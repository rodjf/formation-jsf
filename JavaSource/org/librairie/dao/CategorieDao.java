package org.librairie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import org.librairie.model.Categorie;

public class CategorieDao extends AbstractDao {
    private final static String QRY_FIND_ALL_CATEGORY = "select id,code,description from categorie";
    private final static String QRY_FIND_CATEGORY_BY_ID = "select id,code,description from categorie where id=?";

    public CategorieDao() {}
    public CategorieDao(boolean resource) {
        super(resource);
    }
    
    public Collection<Categorie>  findAllCategories() {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        Collection<Categorie> categories = new ArrayList<Categorie>();
        try {
            connection = getConnection();
            st = connection.createStatement();
            rs = st.executeQuery(QRY_FIND_ALL_CATEGORY);
            while (rs.next()) {
                Categorie categorie = populate(rs);
                categories.add(categorie);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(st);
            close(connection);
        }
        return categories;
    }

    public Categorie findCategorieById(long id) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Categorie categorie = null;
        try {
            connection = getConnection();
            st = connection.prepareStatement(QRY_FIND_CATEGORY_BY_ID);
            st.setLong(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                categorie = populate(rs);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(rs);
            close(st);
            close(connection);
        }
        return categorie;
    }
    
    private Categorie populate(ResultSet rs) throws SQLException {
    	Categorie categorie = new Categorie();
        categorie.setId(new Long(rs.getInt(1)));
        categorie.setCode(rs.getString(2));
        categorie.setDescription(rs.getString(3));
        return categorie;
    	
    }
}
