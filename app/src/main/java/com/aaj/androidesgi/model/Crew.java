package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class Crew
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class Crew extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<Crew> CREATOR = getCreator(Crew.class);

	private String credit_id;
	private String department;
	private String job;
	private String name;
	private String profile_path;
	
	/**
	 * Empty constructor
	 */
	public Crew() {
		super();
	}
	
	/**
	 * Constructor
	 * @param credit_id Type String
	 * @param department Type String
	 * @param job Type String
	 * @param name Type String
	 * @param profile_path Type String
	 */
	public Crew(String credit_id, String department, String job, String name, String profile_path) {
		super();
		this.credit_id = credit_id;
		this.department = department;
		this.job = job;
		this.name = name;
		this.profile_path = profile_path;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "Crew [credit_id=%s, department=%s, job=%s, name=%s, profile_path=%s, #parent=%s]", this.credit_id, this.department, this.job, this.name, this.profile_path, super.toString());
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
	 * Getter method for variable credit_id
	 * @return String Returns credit_id variable
	 */
	public String getCreditId() {
		return this.credit_id;
	}

	/**
	 * Setter method for variable credit_id
	 * @param v Variable credit_id
	 */
	public void setCreditId(String v) {
		this.credit_id = v;
	}

	/**
	 * Getter method for variable department
	 * @return String Returns department variable
	 */
	public String getDepartment() {
		return this.department;
	}

	/**
	 * Setter method for variable department
	 * @param v Variable department
	 */
	public void setDepartment(String v) {
		this.department = v;
	}

	/**
	 * Getter method for variable job
	 * @return String Returns job variable
	 */
	public String getJob() {
		return this.job;
	}

	/**
	 * Setter method for variable job
	 * @param v Variable job
	 */
	public void setJob(String v) {
		this.job = v;
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