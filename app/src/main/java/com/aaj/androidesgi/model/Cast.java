package com.aaj.androidesgi.model;

import android.os.Parcelable;

import java.io.Serializable;
import java.lang.Integer;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class Cast
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class Cast extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Parcelable.Creator<Cast> CREATOR = getCreator(Cast.class);

	private Integer cast_id;
	private String character;
	private String credit_id;
	private String name;
	private Integer order;
	private String profile_path;
	
	/**
	 * Empty constructor
	 */
	public Cast() {
		super();
	}
	
	/**
	 * Constructor
	 * @param cast_id Type Integer
	 * @param character Type String
	 * @param credit_id Type String
	 * @param name Type String
	 * @param order Type Integer
	 * @param profile_path Type String
	 */
	public Cast(Integer cast_id, String character, String credit_id, String name, Integer order, String profile_path) {
		super();
		this.cast_id = cast_id;
		this.character = character;
		this.credit_id = credit_id;
		this.name = name;
		this.order = order;
		this.profile_path = profile_path;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "Cast [cast_id=%s, character=%s, credit_id=%s, name=%s, order=%s, profile_path=%s, #parent=%s]", this.cast_id, this.character, this.credit_id, this.name, this.order, this.profile_path, super.toString());
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
	 * Getter method for variable cast_id
	 * @return Integer Returns cast_id variable
	 */
	public Integer getCast_id() {
		return this.cast_id;
	}

	/**
	 * Setter method for variable cast_id
	 * @param v Variable cast_id
	 */
	public void setCast_id(Integer v) {
		this.cast_id = v;
	}

	/**
	 * Getter method for variable character
	 * @return String Returns character variable
	 */
	public String getCharacter() {
		return this.character;
	}

	/**
	 * Setter method for variable character
	 * @param v Variable character
	 */
	public void setCharacter(String v) {
		this.character = v;
	}

	/**
	 * Getter method for variable credit_id
	 * @return String Returns credit_id variable
	 */
	public String getCredit_id() {
		return this.credit_id;
	}

	/**
	 * Setter method for variable credit_id
	 * @param v Variable credit_id
	 */
	public void setCredit_id(String v) {
		this.credit_id = v;
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
	 * Getter method for variable order
	 * @return Integer Returns order variable
	 */
	public Integer getOrder() {
		return this.order;
	}

	/**
	 * Setter method for variable order
	 * @param v Variable order
	 */
	public void setOrder(Integer v) {
		this.order = v;
	}

	/**
	 * Getter method for variable profile_path
	 * @return String Returns profile_path variable
	 */
	public String getProfile_path() {
		return this.profile_path;
	}

	/**
	 * Setter method for variable profile_path
	 * @param v Variable profile_path
	 */
	public void setProfile_path(String v) {
		this.profile_path = v;
	}

}