package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.util.Locale;

import com.digipolitan.libraries.foundation.classes.parcelables.AbstractParcelable;

/**
 * Using standard Javadoc tags
 * Class Image
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class Image extends AbstractParcelable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<Image> CREATOR = getCreator(Image.class);

	private Double aspect_ratio;
	private String file_path;
	private Integer height;
	private String iso_639_1;
	private Double vote_average;
	private Integer vote_count;
	private Integer width;

	/**
	 * Empty constructor
	 */
	public Image() {
	}

	/**
	 * Constructor
	 * @param aspect_ratio Type Double
	 * @param file_path Type String
	 * @param height Type Integer
	 * @param iso_639_1 Type String
	 * @param vote_average Type Double
	 * @param vote_count Type Integer
	 * @param width Type Integer
	 */
	public Image(Double aspect_ratio, String file_path, Integer height, String iso_639_1, Double vote_average, Integer vote_count, Integer width) {
		this.aspect_ratio = aspect_ratio;
		this.file_path = file_path;
		this.height = height;
		this.iso_639_1 = iso_639_1;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
		this.width = width;
	}

	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "Image [aspect_ratio=%s, file_path=%s, height=%s, iso_639_1=%s, vote_average=%s, vote_count=%s, width=%s]", this.aspect_ratio, this.file_path, this.height, this.iso_639_1, this.vote_average, this.vote_count, this.width);
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
		if(obj instanceof Image) {
			Image convObj = (Image) obj;
			return (this.getAspectRatio()!=null?this.getAspectRatio().equals(convObj.getAspectRatio()):this.getAspectRatio()==convObj.getAspectRatio())&&(this.getFilePath()!=null?this.getFilePath().equals(convObj.getFilePath()):this.getFilePath()==convObj.getFilePath())&&(this.getHeight()!=null?this.getHeight().equals(convObj.getHeight()):this.getHeight()==convObj.getHeight())&&(this.getIso6391()!=null?this.getIso6391().equals(convObj.getIso6391()):this.getIso6391()==convObj.getIso6391())&&(this.getVoteAverage()!=null?this.getVoteAverage().equals(convObj.getVoteAverage()):this.getVoteAverage()==convObj.getVoteAverage())&&(this.getVoteCount()!=null?this.getVoteCount().equals(convObj.getVoteCount()):this.getVoteCount()==convObj.getVoteCount())&&(this.getWidth()!=null?this.getWidth().equals(convObj.getWidth()):this.getWidth()==convObj.getWidth());
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
	 * Getter method for variable aspect_ratio
	 * @return Double Returns aspect_ratio variable
	 */
	public Double getAspectRatio() {
		return this.aspect_ratio;
	}

	/**
	 * Setter method for variable aspect_ratio
	 * @param v Variable aspect_ratio
	 */
	public void setAspectRatio(Double v) {
		this.aspect_ratio = v;
	}

	/**
	 * Getter method for variable file_path
	 * @return String Returns file_path variable
	 */
	public String getFilePath() {
		return this.file_path;
	}

	/**
	 * Setter method for variable file_path
	 * @param v Variable file_path
	 */
	public void setFilePath(String v) {
		this.file_path = v;
	}

	/**
	 * Getter method for variable height
	 * @return Integer Returns height variable
	 */
	public Integer getHeight() {
		return this.height;
	}

	/**
	 * Setter method for variable height
	 * @param v Variable height
	 */
	public void setHeight(Integer v) {
		this.height = v;
	}

	/**
	 * Getter method for variable iso_639_1
	 * @return String Returns iso_639_1 variable
	 */
	public String getIso6391() {
		return this.iso_639_1;
	}

	/**
	 * Setter method for variable iso_639_1
	 * @param v Variable iso_639_1
	 */
	public void setIso6391(String v) {
		this.iso_639_1 = v;
	}

	/**
	 * Getter method for variable vote_average
	 * @return Double Returns vote_average variable
	 */
	public Double getVoteAverage() {
		return this.vote_average;
	}

	/**
	 * Setter method for variable vote_average
	 * @param v Variable vote_average
	 */
	public void setVoteAverage(Double v) {
		this.vote_average = v;
	}

	/**
	 * Getter method for variable vote_count
	 * @return Integer Returns vote_count variable
	 */
	public Integer getVoteCount() {
		return this.vote_count;
	}

	/**
	 * Setter method for variable vote_count
	 * @param v Variable vote_count
	 */
	public void setVoteCount(Integer v) {
		this.vote_count = v;
	}

	/**
	 * Getter method for variable width
	 * @return Integer Returns width variable
	 */
	public Integer getWidth() {
		return this.width;
	}

	/**
	 * Setter method for variable width
	 * @param v Variable width
	 */
	public void setWidth(Integer v) {
		this.width = v;
	}

}