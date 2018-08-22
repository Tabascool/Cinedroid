package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class MoviesPlusResult
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class MoviesPlusResult extends MoviesResult implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<MoviesPlusResult> CREATOR = getCreator(MoviesPlusResult.class);

	private DateInterval dates;
	
	/**
	 * Empty constructor
	 */
	public MoviesPlusResult() {
		super();
	}
	
	/**
	 * Constructor
	 * @param dates Type DateInterval
	 */
	public MoviesPlusResult(DateInterval dates) {
		super();
		this.dates = dates;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "MoviesPlusResult [dates=%s, #parent=%s]", this.dates, super.toString());
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
		if(super.equals(obj)) {
			if(obj instanceof MoviesPlusResult) {
				MoviesPlusResult convObj = (MoviesPlusResult) obj;
				return (this.getDates()!=null?this.getDates().equals(convObj.getDates()):this.getDates()==convObj.getDates());
			}
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
	 * Getter method for variable dates
	 * @return DateInterval Returns dates variable
	 */
	public DateInterval getDates() {
		return this.dates;
	}

	/**
	 * Setter method for variable dates
	 * @param v Variable dates
	 */
	public void setDates(DateInterval v) {
		this.dates = v;
	}
}