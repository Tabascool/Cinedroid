package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.aaj.androidesgi.model.Cast;
import com.aaj.androidesgi.model.Crew;

/**
 * Using standard Javadoc tags
 * Class CreditsResult
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class CreditsResult extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<CreditsResult> CREATOR = getCreator(CreditsResult.class);

	private List<Cast> cast;
	private List<Crew> crew;
	
	/**
	 * Empty constructor
	 */
	public CreditsResult() {
		super();
	}
	
	/**
	 * Constructor
	 * @param cast Type List<Cast>
	 * @param crew Type List<Crew>
	 */
	public CreditsResult(List<Cast> cast, List<Crew> crew) {
		super();
		this.cast = cast;
		this.crew = crew;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "CreditsResult [cast=%s, crew=%s, #parent=%s]", this.cast, this.crew, super.toString());
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
	 * Getter method for variable cast
	 * @return List<Cast> Returns cast variable
	 */
	public List<Cast> getcast() {
		return this.cast;
	}

	/**
	 * Setter method for variable cast
	 * @param v Variable cast
	 */
	public void setcast(List<Cast> v) {
		this.cast = new ArrayList<Cast>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param cast Element for testing
	 * @return boolean Result test
	 */
	public boolean containsCast(Cast cast) {
		if(this.cast != null)
			return this.cast.contains(cast);
		return false;
	}

	/**
	 * Add a Cast element
	 * @param cast A Cast element to insert
	 */
	public void addCast(Cast cast) {
		if(this.cast == null)
			this.cast = new ArrayList<Cast>();
		this.cast.add(cast);
	}

	/**
	 * Get a Cast element by index
	 * @param index Index into list
	 * @return Cast An Cast object
	 */
	public Cast getCast(int index) {
		if(this.cast != null && index < this.cast.size())
			return this.cast.get(index);
		return null;
	}

	/**
	 * Remove a Cast element
	 * @param cast A Cast element to remove
	 */
	public void removeCast(Cast cast) {
		if(this.cast != null)
			this.cast.remove(cast);
	}

	/**
	 * Remove all Cast elements
	 */
	public void removeAllcast() {
		if(this.cast != null)
			this.cast.clear();
	}

	/**
	 * Getter method for variable crew
	 * @return List<Crew> Returns crew variable
	 */
	public List<Crew> getcrew() {
		return this.crew;
	}

	/**
	 * Setter method for variable crew
	 * @param v Variable crew
	 */
	public void setcrew(List<Crew> v) {
		this.crew = new ArrayList<Crew>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param crew Element for testing
	 * @return boolean Result test
	 */
	public boolean containsCrew(Crew crew) {
		if(this.crew != null)
			return this.crew.contains(crew);
		return false;
	}

	/**
	 * Add a Crew element
	 * @param crew A Crew element to insert
	 */
	public void addCrew(Crew crew) {
		if(this.crew == null)
			this.crew = new ArrayList<Crew>();
		this.crew.add(crew);
	}

	/**
	 * Get a Crew element by index
	 * @param index Index into list
	 * @return Crew An Crew object
	 */
	public Crew getCrew(int index) {
		if(this.crew != null && index < this.crew.size())
			return this.crew.get(index);
		return null;
	}

	/**
	 * Remove a Crew element
	 * @param crew A Crew element to remove
	 */
	public void removeCrew(Crew crew) {
		if(this.crew != null)
			this.crew.remove(crew);
	}

	/**
	 * Remove all Crew elements
	 */
	public void removeAllcrew() {
		if(this.crew != null)
			this.crew.clear();
	}

}