package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.aaj.androidesgi.model.Image;

/**
 * Using standard Javadoc tags
 * Class ImageResult
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class ImageResult extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<ImageResult> CREATOR = getCreator(ImageResult.class);

	private List<Image> backdrops;
	private List<Image> posters;
	
	/**
	 * Empty constructor
	 */
	public ImageResult() {
		super();
	}
	
	/**
	 * Constructor
	 * @param backdrops Type List<Image>
	 * @param posters Type List<Image>
	 */
	public ImageResult(List<Image> backdrops, List<Image> posters) {
		super();
		this.backdrops = backdrops;
		this.posters = posters;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "ImageResult [backdrops=%s, posters=%s, #parent=%s]", this.backdrops, this.posters, super.toString());
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
	 * Getter method for variable backdrops
	 * @return List<Image> Returns backdrops variable
	 */
	public List<Image> getBackdrops() {
		return this.backdrops;
	}

	/**
	 * Setter method for variable backdrops
	 * @param v Variable backdrops
	 */
	public void setBackdrops(List<Image> v) {
		this.backdrops = new ArrayList<Image>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param backdrop Element for testing
	 * @return boolean Result test
	 */
	public boolean containsBackdrop(Image backdrop) {
		if(this.backdrops != null)
			return this.backdrops.contains(backdrop);
		return false;
	}

	/**
	 * Add a Image element
	 * @param backdrop A Image element to insert
	 */
	public void addBackdrop(Image backdrop) {
		if(this.backdrops == null)
			this.backdrops = new ArrayList<Image>();
		this.backdrops.add(backdrop);
	}

	/**
	 * Get a Image element by index
	 * @param index Index into list
	 * @return Image An Image object
	 */
	public Image getBackdrop(int index) {
		if(this.backdrops != null && index < this.backdrops.size())
			return this.backdrops.get(index);
		return null;
	}

	/**
	 * Remove a Image element
	 * @param backdrop A Image element to remove
	 */
	public void removeBackdrop(Image backdrop) {
		if(this.backdrops != null)
			this.backdrops.remove(backdrop);
	}

	/**
	 * Remove all Image elements
	 */
	public void removeAllBackdrops() {
		if(this.backdrops != null)
			this.backdrops.clear();
	}

	/**
	 * Getter method for variable posters
	 * @return List<Image> Returns posters variable
	 */
	public List<Image> getPosters() {
		return this.posters;
	}

	/**
	 * Setter method for variable posters
	 * @param v Variable posters
	 */
	public void setPosters(List<Image> v) {
		this.posters = new ArrayList<Image>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param poster Element for testing
	 * @return boolean Result test
	 */
	public boolean containsPoster(Image poster) {
		if(this.posters != null)
			return this.posters.contains(poster);
		return false;
	}

	/**
	 * Add a Image element
	 * @param poster A Image element to insert
	 */
	public void addPoster(Image poster) {
		if(this.posters == null)
			this.posters = new ArrayList<Image>();
		this.posters.add(poster);
	}

	/**
	 * Get a Image element by index
	 * @param index Index into list
	 * @return Image An Image object
	 */
	public Image getPoster(int index) {
		if(this.posters != null && index < this.posters.size())
			return this.posters.get(index);
		return null;
	}

	/**
	 * Remove a Image element
	 * @param poster A Image element to remove
	 */
	public void removePoster(Image poster) {
		if(this.posters != null)
			this.posters.remove(poster);
	}

	/**
	 * Remove all Image elements
	 */
	public void removeAllPosters() {
		if(this.posters != null)
			this.posters.clear();
	}

}