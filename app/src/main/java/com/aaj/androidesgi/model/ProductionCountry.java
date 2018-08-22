package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

import com.digipolitan.libraries.foundation.classes.parcelables.AbstractParcelable;

/**
 * Using standard Javadoc tags
 * Class ProductionCountry
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class ProductionCountry extends AbstractParcelable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<ProductionCountry> CREATOR = getCreator(ProductionCountry.class);

	private String iso_3166_1;
	private String name;
	
	/**
	 * Empty constructor
	 */
	public ProductionCountry() {
	}
	
	/**
	 * Constructor
	 * @param iso_3166_1 Type String
	 * @param name Type String
	 */
	public ProductionCountry(String iso_3166_1, String name) {
		this.iso_3166_1 = iso_3166_1;
		this.name = name;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "ProductionCountry [iso_3166_1=%s, name=%s]", this.iso_3166_1, this.name);
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
		if(obj instanceof ProductionCountry) {
			ProductionCountry convObj = (ProductionCountry) obj;
			return (this.getIso_3166_1()!=null?this.getIso_3166_1().equals(convObj.getIso_3166_1()):this.getIso_3166_1()==convObj.getIso_3166_1())&&(this.getName()!=null?this.getName().equals(convObj.getName()):this.getName()==convObj.getName());
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
	 * Getter method for variable iso_3166_1
	 * @return String Returns iso_3166_1 variable
	 */
	public String getIso_3166_1() {
		return this.iso_3166_1;
	}

	/**
	 * Setter method for variable iso_3166_1
	 * @param v Variable iso_3166_1
	 */
	public void setIso_3166_1(String v) {
		this.iso_3166_1 = v;
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