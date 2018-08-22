package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class Collection
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class Collection extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<Collection> CREATOR = getCreator(Collection.class);

	private String name;
	private String backdrop_path;
	private String poster_path;
	
	/**
	 * Empty constructor
	 */
	public Collection() {
		super();
	}
	
	/**
	 * Constructor
	 * @param name Type String
	 * @param backdrop_path Type String
	 * @param poster_path Type String
	 */
	public Collection(String name, String backdrop_path, String poster_path) {
		super();
		this.name = name;
		this.backdrop_path = backdrop_path;
		this.poster_path = poster_path;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "Collection [name=%s, backdrop_path=%s, poster_path=%s, #parent=%s]", this.name, this.backdrop_path, this.poster_path, super.toString());
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
	 * Getter method for variable name
	 * @return String Returns name variable
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter method for variable name
	 * @param v Variable name
	 */
	public void setName(String v) {
		this.name = v;
	}

	/**
	 * Getter method for variable backdrop_path
	 * @return String Returns backdrop_path variable
	 */
	public String getBackdrop_path() {
		return this.backdrop_path;
	}

	/**
	 * Setter method for variable backdrop_path
	 * @param v Variable backdrop_path
	 */
	public void setBackdrop_path(String v) {
		this.backdrop_path = v;
	}

	/**
	 * Getter method for variable poster_path
	 * @return String Returns poster_path variable
	 */
	public String getPoster_path() {
		return this.poster_path;
	}

	/**
	 * Setter method for variable poster_path
	 * @param v Variable poster_path
	 */
	public void setPoster_path(String v) {
		this.poster_path = v;
	}

}