package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.digipolitan.libraries.foundation.classes.parcelables.AbstractParcelable;

/**
 * Using standard Javadoc tags
 * Class MoviesResult
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class MoviesResult extends AbstractParcelable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<MoviesResult> CREATOR = getCreator(MoviesResult.class);

	private Integer page;
	private List<MovieResult> results;
	
	/**
	 * Empty constructor
	 */
	public MoviesResult() {
	}
	
	/**
	 * Constructor
	 * @param page Type Integer
	 * @param results Type List<SimplifiedMovie>
	 */
	public MoviesResult(Integer page, List<MovieResult> results) {
		this.page = page;
		this.results = results;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "MoviesResult [page=%s, results=%s]", this.page, this.results);
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
		if(obj instanceof MoviesResult) {
			MoviesResult convObj = (MoviesResult) obj;
			return (this.getPage()!=null?this.getPage().equals(convObj.getPage()):this.getPage()==convObj.getPage())&&(this.getResults()!=null?this.getResults().equals(convObj.getResults()):this.getResults()==convObj.getResults());
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
	 * Getter method for variable page
	 * @return Integer Returns page variable
	 */
	public Integer getPage() {
		return this.page;
	}

	/**
	 * Setter method for variable page
	 * @param v Variable page
	 */
	public void setPage(Integer v) {
		this.page = v;
	}

	/**
	 * Getter method for variable results
	 * @return List<SimplifiedMovie> Returns results variable
	 */
	public List<MovieResult> getResults() {
		return this.results;
	}

	/**
	 * Setter method for variable results
	 * @param v Variable results
	 */
	public void setResults(List<MovieResult> v) {
		this.results = new ArrayList<MovieResult>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param result Element for testing
	 * @return boolean Result test
	 */
	public boolean containsResult(MovieResult result) {
		if(this.results != null)
			return this.results.contains(result);
		return false;
	}

	/**
	 * Add a SimplifiedMovie element
	 * @param result A SimplifiedMovie element to insert
	 */
	public void addResult(MovieResult result) {
		if(this.results == null)
			this.results = new ArrayList<MovieResult>();
		this.results.add(result);
	}

	/**
	 * Get a SimplifiedMovie element by index
	 * @param index Index into list
	 * @return SimplifiedMovie An SimplifiedMovie object
	 */
	public MovieResult getResult(int index) {
		if(this.results != null && index < this.results.size())
			return this.results.get(index);
		return null;
	}

	/**
	 * Remove a SimplifiedMovie element
	 * @param result A SimplifiedMovie element to remove
	 */
	public void removeResult(MovieResult result) {
		if(this.results != null)
			this.results.remove(result);
	}

	/**
	 * Remove all SimplifiedMovie elements
	 */
	public void removeAllResults() {
		if(this.results != null)
			this.results.clear();
	}

}