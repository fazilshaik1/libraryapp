package com.dxctraining.consoleapp.author.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {
	
	@Id
	@GeneratedValue
	private int id;
    private String name;

    public Author(String name){
        this.name = name;
    }
    public Author() {
    	
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int hashCode() {
    	return id;
    }
    
    public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if ((null == o) || !(o instanceof Author)) {
			return false;
		}
		Author that = (Author) o;
		boolean isequals = this.id == that.id;
		return isequals;
	}

}
