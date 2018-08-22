package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Locale;

import com.digipolitan.libraries.foundation.classes.parcelables.AbstractParcelable;

/**
 * Using standard Javadoc tags
 * Class Identifiable
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class Identifiable extends AbstractParcelable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<Identifiable> CREATOR = getCreator(Identifiable.class);

	private Integer id;
	
	/**
	 * Empty constructor
	 */
	public Identifiable() {
	}
	
	/**
	 * Constructor
	 * @param id Type Integer
	 */
	public Identifiable(Integer id) {
		this.id = id;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "Identifiable [id=%s]", this.id);
	}
	
	/**
	 * Override default equals() method
	 * @param obj An object to compare
	 * @return boolean Returns true if same otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj instanceof Identifiable) {
			Identifiable convObj = (Identifiable) obj;
			return (this.getId()!=null?this.getId().equals(convObj.getId()):this.getId()==convObj.getId());
		}
		return false;
	}
	
	/**
	 * Override default clone() method
	 * @return Object Object cloned
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	/**
	 * Getter method for variable id
	 * @return Integer Returns id variable
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Setter method for variable id
	 * @param v Variable id
	 */
	public void setId(Integer v) {
		this.id = v;
	}

}