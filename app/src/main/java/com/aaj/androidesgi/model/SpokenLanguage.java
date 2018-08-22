package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class SpokenLanguage
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class SpokenLanguage extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<SpokenLanguage> CREATOR = getCreator(SpokenLanguage.class);

	private String iso_639_1;
	private String name;
	
	/**
	 * Empty constructor
	 */
	public SpokenLanguage() {
		super();
	}
	
	/**
	 * Constructor
	 * @param iso_639_1 Type String
	 * @param name Type String
	 */
	public SpokenLanguage(String iso_639_1, String name) {
		super();
		this.iso_639_1 = iso_639_1;
		this.name = name;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "SpokenLanguage [iso_639_1=%s, name=%s, #parent=%s]", this.iso_639_1, this.name, super.toString());
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
	 * Getter method for variable iso_639_1
	 * @return String Returns iso_639_1 variable
	 */
	public String getIso_639_1() {
		return this.iso_639_1;
	}

	/**
	 * Setter method for variable iso_639_1
	 * @param v Variable iso_639_1
	 */
	public void setIso_639_1(String v) {
		this.iso_639_1 = v;
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