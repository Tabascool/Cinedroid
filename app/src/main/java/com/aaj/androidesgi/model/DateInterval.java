package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

import com.digipolitan.libraries.foundation.classes.parcelables.AbstractParcelable;

/**
 * Using standard Javadoc tags
 * Class DateInterval
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class DateInterval extends AbstractParcelable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<DateInterval> CREATOR = getCreator(DateInterval.class);

	private String minimum;
	private String maximum;
	
	/**
	 * Empty constructor
	 */
	public DateInterval() {
	}
	
	/**
	 * Constructor
	 * @param minimum Type String
	 * @param maximum Type String
	 */
	public DateInterval(String minimum, String maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "DateInterval [minimum=%s, maximum=%s]", this.minimum, this.maximum);
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
		if(obj instanceof DateInterval) {
			DateInterval convObj = (DateInterval) obj;
			return (this.getMinimum()!=null?this.getMinimum().equals(convObj.getMinimum()):this.getMinimum()==convObj.getMinimum())&&(this.getMaximum()!=null?this.getMaximum().equals(convObj.getMaximum()):this.getMaximum()==convObj.getMaximum());
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
	 * Getter method for variable minimum
	 * @return String Returns minimum variable
	 */
	public String getMinimum() {
		return this.minimum;
	}

	/**
	 * Setter method for variable minimum
	 * @param v Variable minimum
	 */
	public void setMinimum(String v) {
		this.minimum = v;
	}

	/**
	 * Getter method for variable maximum
	 * @return String Returns maximum variable
	 */
	public String getMaximum() {
		return this.maximum;
	}

	/**
	 * Setter method for variable maximum
	 * @param v Variable maximum
	 */
	public void setMaximum(String v) {
		this.maximum = v;
	}

}