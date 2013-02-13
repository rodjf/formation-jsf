/*
 * Created on 1 oct. 2004
 */
package org.librairie.model;

import java.io.Serializable;

/**
 * @author oh
 */
public class Categorie implements Serializable {
	private static final long serialVersionUID = -2154388876773783840L;
	
	private Long id;
    private String code;
    private String description;

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
     * @return Returns the code.
     */
    public String getCode() {
        return code;
    }
    /**
     * @param code The code to set.
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }
    /**
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[id=").append(id)
          .append(",code=").append(code)
          .append(",description=").append(description)
          .append("]");
        return sb.toString();
    }
}
