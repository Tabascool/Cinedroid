package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class ProductionCompany
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class ProductionCompany extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<ProductionCompany> CREATOR = getCreator(ProductionCompany.class);

	private String name;
	
	/**
	 * Empty constructor
	 */
	public ProductionCompany() {
		super();
	}
	
	/**
	 * Constructor
	 * @param name Type String
	 */
	public ProductionCompany(String name) {
		super();
		this.name = name;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "ProductionCompany [name=%s, #parent=%s]", this.name, super.toString());
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

}