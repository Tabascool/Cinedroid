package com.aaj.androidesgi.model;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Using standard Javadoc tags
 * Class MovieResult
 * @author Digipolitan ServicesClassGenerator
 * @copyright Digipolitan
 * @version 1.0
 */
public class MovieResult extends Identifiable implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	public static final Creator<MovieResult> CREATOR = getCreator(MovieResult.class);

	private Boolean adult;
	private String backdrop_path;
	private Collection belongs_to_collection;
	private Integer budget;
	private List<Genre> genres;
	private String homepage;
	private String imdb_id;
	private String original_language;
	private String original_title;
	private String overview;
	private Double popularity;
	private String poster_path;
	private List<ProductionCompany> production_companies;
	private List<ProductionCountry> production_countries;
	private String release_date;
	private Integer revenue;
	private Integer runtime;
	private List<SpokenLanguage> spoken_languages;
	private String status;
	private String tagline;
	private String title;
	private Boolean video;
	private Double vote_average;
	private Integer vote_count;
	
	/**
	 * Empty constructor
	 */
	public MovieResult() {
		super();
	}
	
	/**
	 * Constructor
	 * @param adult Type Boolean
	 * @param backdrop_path Type String
	 * @param belongs_to_collection Type Collection
	 * @param budget Type Integer
	 * @param genres Type List<Genre>
	 * @param homepage Type String
	 * @param imdb_id Type String
	 * @param original_language Type String
	 * @param original_title Type String
	 * @param overview Type String
	 * @param popularity Type Double
	 * @param poster_path Type String
	 * @param production_companies Type List<ProductionCompany>
	 * @param productionCountries Type List<ProductionCountry>
	 * @param release_date Type String
	 * @param revenue Type Integer
	 * @param runtime Type Integer
	 * @param spoken_languages Type List<SpokenLanguage>
	 * @param status Type String
	 * @param tagline Type String
	 * @param title Type String
	 * @param video Type Boolean
	 * @param vote_average Type Double
	 * @param vote_count Type Integer
	 */
	public MovieResult(Boolean adult, String backdrop_path, Collection belongs_to_collection, Integer budget, List<Genre> genres, String homepage, String imdb_id, String original_language, String original_title, String overview, Double popularity, String poster_path, List<ProductionCompany> production_companies, List<ProductionCountry> productionCountries, String release_date, Integer revenue, Integer runtime, List<SpokenLanguage> spoken_languages, String status, String tagline, String title, Boolean video, Double vote_average, Integer vote_count) {
		super();
		this.adult = adult;
		this.backdrop_path = backdrop_path;
		this.belongs_to_collection = belongs_to_collection;
		this.budget = budget;
		this.genres = genres;
		this.homepage = homepage;
		this.imdb_id = imdb_id;
		this.original_language = original_language;
		this.original_title = original_title;
		this.overview = overview;
		this.popularity = popularity;
		this.poster_path = poster_path;
		this.production_companies = production_companies;
		this.production_countries = productionCountries;
		this.release_date = release_date;
		this.revenue = revenue;
		this.runtime = runtime;
		this.spoken_languages = spoken_languages;
		this.status = status;
		this.tagline = tagline;
		this.title = title;
		this.video = video;
		this.vote_average = vote_average;
		this.vote_count = vote_count;
	}
	
	/**
	 * Override default toString() method
	 * @return string Human readable string for debug
	 */
	@Override
	public String toString() {
		return String.format(Locale.US, "MovieResult [adult=%s, backdrop_path=%s, belongs_to_collection=%s, budget=%s, genres=%s, homepage=%s, imdb_id=%s, original_language=%s, original_title=%s, overview=%s, popularity=%s, poster_path=%s, production_companies=%s, production_countries=%s, release_date=%s, revenue=%s, runtime=%s, spoken_languages=%s, status=%s, tagline=%s, title=%s, video=%s, vote_average=%s, vote_count=%s, #parent=%s]", this.adult, this.backdrop_path, this.belongs_to_collection, this.budget, this.genres, this.homepage, this.imdb_id, this.original_language, this.original_title, this.overview, this.popularity, this.poster_path, this.production_companies, this.production_countries, this.release_date, this.revenue, this.runtime, this.spoken_languages, this.status, this.tagline, this.title, this.video, this.vote_average, this.vote_count, super.toString());
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
	 * Getter method for variable adult
	 * @return Boolean Returns adult variable
	 */
	public Boolean getAdult() {
		return this.adult;
	}

	/**
	 * Setter method for variable adult
	 * @param v Variable adult
	 */
	public void setAdult(Boolean v) {
		this.adult = v;
	}

	/**
	 * Getter method for variable backdrop_path
	 * @return String Returns backdrop_path variable
	 */
	public String getBackdrop_path() {
		return this.backdrop_path;
	}

	/**
	 * Setter method for variable backdrop_path
	 * @param v Variable backdrop_path
	 */
	public void setBackdrop_path(String v) {
		this.backdrop_path = v;
	}

	/**
	 * Getter method for variable belongs_to_collection
	 * @return Collection Returns belongs_to_collection variable
	 */
	public Collection getBelongs_to_collection() {
		return this.belongs_to_collection;
	}

	/**
	 * Setter method for variable belongs_to_collection
	 * @param v Variable belongs_to_collection
	 */
	public void setBelongs_to_collection(Collection v) {
		this.belongs_to_collection = v;
	}

	/**
	 * Getter method for variable budget
	 * @return Integer Returns budget variable
	 */
	public Integer getBudget() {
		return this.budget;
	}

	/**
	 * Setter method for variable budget
	 * @param v Variable budget
	 */
	public void setBudget(Integer v) {
		this.budget = v;
	}

	/**
	 * Getter method for variable genres
	 * @return List<Genre> Returns genres variable
	 */
	public List<Genre> getGenres() {
		return this.genres;
	}

	/**
	 * Setter method for variable genres
	 * @param v Variable genres
	 */
	public void setGenres(List<Genre> v) {
		this.genres = new ArrayList<Genre>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param genre Element for testing
	 * @return boolean Result test
	 */
	public boolean containsGenre(Genre genre) {
		if(this.genres != null)
			return this.genres.contains(genre);
		return false;
	}

	/**
	 * Add a Genre element
	 * @param genre A Genre element to insert
	 */
	public void addGenre(Genre genre) {
		if(this.genres == null)
			this.genres = new ArrayList<Genre>();
		this.genres.add(genre);
	}

	/**
	 * Get a Genre element by index
	 * @param index Index into list
	 * @return Genre An Genre object
	 */
	public Genre getGenre(int index) {
		if(this.genres != null && index < this.genres.size())
			return this.genres.get(index);
		return null;
	}

	/**
	 * Remove a Genre element
	 * @param genre A Genre element to remove
	 */
	public void removeGenre(Genre genre) {
		if(this.genres != null)
			this.genres.remove(genre);
	}

	/**
	 * Remove all Genre elements
	 */
	public void removeAllGenres() {
		if(this.genres != null)
			this.genres.clear();
	}

	/**
	 * Getter method for variable homepage
	 * @return String Returns homepage variable
	 */
	public String getHomepage() {
		return this.homepage;
	}

	/**
	 * Setter method for variable homepage
	 * @param v Variable homepage
	 */
	public void setHomepage(String v) {
		this.homepage = v;
	}

	/**
	 * Getter method for variable imdb_id
	 * @return String Returns imdb_id variable
	 */
	public String getImdb_id() {
		return this.imdb_id;
	}

	/**
	 * Setter method for variable imdb_id
	 * @param v Variable imdb_id
	 */
	public void setImdb_id(String v) {
		this.imdb_id = v;
	}

	/**
	 * Getter method for variable original_language
	 * @return String Returns original_language variable
	 */
	public String getOriginal_language() {
		return this.original_language;
	}

	/**
	 * Setter method for variable original_language
	 * @param v Variable original_language
	 */
	public void setOriginal_language(String v) {
		this.original_language = v;
	}

	/**
	 * Getter method for variable original_title
	 * @return String Returns original_title variable
	 */
	public String getOriginal_title() {
		return this.original_title;
	}

	/**
	 * Setter method for variable original_title
	 * @param v Variable original_title
	 */
	public void setOriginal_title(String v) {
		this.original_title = v;
	}

	/**
	 * Getter method for variable overview
	 * @return String Returns overview variable
	 */
	public String getOverview() {
		return this.overview;
	}

	/**
	 * Setter method for variable overview
	 * @param v Variable overview
	 */
	public void setOverview(String v) {
		this.overview = v;
	}

	/**
	 * Getter method for variable popularity
	 * @return Double Returns popularity variable
	 */
	public Double getPopularity() {
		return this.popularity;
	}

	/**
	 * Setter method for variable popularity
	 * @param v Variable popularity
	 */
	public void setPopularity(Double v) {
		this.popularity = v;
	}

	/**
	 * Getter method for variable poster_path
	 * @return String Returns poster_path variable
	 */
	public String getPoster_path() {
		return this.poster_path;
	}

	/**
	 * Setter method for variable poster_path
	 * @param v Variable poster_path
	 */
	public void setPoster_path(String v) {
		this.poster_path = v;
	}

	/**
	 * Getter method for variable production_companies
	 * @return List<ProductionCompany> Returns production_companies variable
	 */
	public List<ProductionCompany> getProduction_companies() {
		return this.production_companies;
	}

	/**
	 * Setter method for variable production_companies
	 * @param v Variable production_companies
	 */
	public void setProduction_companies(List<ProductionCompany> v) {
		this.production_companies = new ArrayList<ProductionCompany>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param productionCompanie Element for testing
	 * @return boolean Result test
	 */
	public boolean containsProductionCompanie(ProductionCompany productionCompanie) {
		if(this.production_companies != null)
			return this.production_companies.contains(productionCompanie);
		return false;
	}

	/**
	 * Add a ProductionCompany element
	 * @param productionCompanie A ProductionCompany element to insert
	 */
	public void addProductionCompanie(ProductionCompany productionCompanie) {
		if(this.production_companies == null)
			this.production_companies = new ArrayList<ProductionCompany>();
		this.production_companies.add(productionCompanie);
	}

	/**
	 * Get a ProductionCompany element by index
	 * @param index Index into list
	 * @return ProductionCompany An ProductionCompany object
	 */
	public ProductionCompany getProductionCompanie(int index) {
		if(this.production_companies != null && index < this.production_companies.size())
			return this.production_companies.get(index);
		return null;
	}

	/**
	 * Remove a ProductionCompany element
	 * @param productionCompanie A ProductionCompany element to remove
	 */
	public void removeProductionCompanie(ProductionCompany productionCompanie) {
		if(this.production_companies != null)
			this.production_companies.remove(productionCompanie);
	}

	/**
	 * Remove all ProductionCompany elements
	 */
	public void removeAllProductionCompanies() {
		if(this.production_companies != null)
			this.production_companies.clear();
	}

	/**
	 * Getter method for variable production_countries
	 * @return List<ProductionCountry> Returns production_countries variable
	 */
	public List<ProductionCountry> getProduction_countries() {
		return this.production_countries;
	}

	/**
	 * Setter method for variable production_countries
	 * @param v Variable production_countries
	 */
	public void setProduction_countries(List<ProductionCountry> v) {
		this.production_countries = new ArrayList<ProductionCountry>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param productionCountrie Element for testing
	 * @return boolean Result test
	 */
	public boolean containsProductionCountrie(ProductionCountry productionCountrie) {
		if(this.production_countries != null)
			return this.production_countries.contains(productionCountrie);
		return false;
	}

	/**
	 * Add a ProductionCountry element
	 * @param productionCountrie A ProductionCountry element to insert
	 */
	public void addProductionCountrie(ProductionCountry productionCountrie) {
		if(this.production_countries == null)
			this.production_countries = new ArrayList<ProductionCountry>();
		this.production_countries.add(productionCountrie);
	}

	/**
	 * Get a ProductionCountry element by index
	 * @param index Index into list
	 * @return ProductionCountry An ProductionCountry object
	 */
	public ProductionCountry getProductionCountrie(int index) {
		if(this.production_countries != null && index < this.production_countries.size())
			return this.production_countries.get(index);
		return null;
	}

	/**
	 * Remove a ProductionCountry element
	 * @param productionCountrie A ProductionCountry element to remove
	 */
	public void removeProductionCountrie(ProductionCountry productionCountrie) {
		if(this.production_countries != null)
			this.production_countries.remove(productionCountrie);
	}

	/**
	 * Remove all ProductionCountry elements
	 */
	public void removeAllProductionCountries() {
		if(this.production_countries != null)
			this.production_countries.clear();
	}

	/**
	 * Getter method for variable release_date
	 * @return String Returns release_date variable
	 */
	public String getRelease_date() {
		return this.release_date;
	}

	/**
	 * Setter method for variable release_date
	 * @param v Variable release_date
	 */
	public void setRelease_date(String v) {
		this.release_date = v;
	}

	/**
	 * Getter method for variable revenue
	 * @return Integer Returns revenue variable
	 */
	public Integer getRevenue() {
		return this.revenue;
	}

	/**
	 * Setter method for variable revenue
	 * @param v Variable revenue
	 */
	public void setRevenue(Integer v) {
		this.revenue = v;
	}

	/**
	 * Getter method for variable runtime
	 * @return Integer Returns runtime variable
	 */
	public Integer getRuntime() {
		return this.runtime;
	}

	/**
	 * Setter method for variable runtime
	 * @param v Variable runtime
	 */
	public void setRuntime(Integer v) {
		this.runtime = v;
	}

	/**
	 * Getter method for variable spoken_languages
	 * @return List<SpokenLanguage> Returns spoken_languages variable
	 */
	public List<SpokenLanguage> getSpoken_languages() {
		return this.spoken_languages;
	}

	/**
	 * Setter method for variable spoken_languages
	 * @param v Variable spoken_languages
	 */
	public void setSpoken_languages(List<SpokenLanguage> v) {
		this.spoken_languages = new ArrayList<SpokenLanguage>(v);
	}

	/**
	 * Returns true if element is contained into list
	 * @param spokenLanguage Element for testing
	 * @return boolean Result test
	 */
	public boolean containsSpokenLanguage(SpokenLanguage spokenLanguage) {
		if(this.spoken_languages != null)
			return this.spoken_languages.contains(spokenLanguage);
		return false;
	}

	/**
	 * Add a SpokenLanguage element
	 * @param spokenLanguage A SpokenLanguage element to insert
	 */
	public void addSpokenLanguage(SpokenLanguage spokenLanguage) {
		if(this.spoken_languages == null)
			this.spoken_languages = new ArrayList<SpokenLanguage>();
		this.spoken_languages.add(spokenLanguage);
	}

	/**
	 * Get a SpokenLanguage element by index
	 * @param index Index into list
	 * @return SpokenLanguage An SpokenLanguage object
	 */
	public SpokenLanguage getSpokenLanguage(int index) {
		if(this.spoken_languages != null && index < this.spoken_languages.size())
			return this.spoken_languages.get(index);
		return null;
	}

	/**
	 * Remove a SpokenLanguage element
	 * @param spokenLanguage A SpokenLanguage element to remove
	 */
	public void removeSpokenLanguage(SpokenLanguage spokenLanguage) {
		if(this.spoken_languages != null)
			this.spoken_languages.remove(spokenLanguage);
	}

	/**
	 * Remove all SpokenLanguage elements
	 */
	public void removeAllSpokenLanguages() {
		if(this.spoken_languages != null)
			this.spoken_languages.clear();
	}

	/**
	 * Getter method for variable status
	 * @return String Returns status variable
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * Setter method for variable status
	 * @param v Variable status
	 */
	public void setStatus(String v) {
		this.status = v;
	}

	/**
	 * Getter method for variable tagline
	 * @return String Returns tagline variable
	 */
	public String getTagline() {
		return this.tagline;
	}

	/**
	 * Setter method for variable tagline
	 * @param v Variable tagline
	 */
	public void setTagline(String v) {
		this.tagline = v;
	}

	/**
	 * Getter method for variable title
	 * @return String Returns title variable
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Setter method for variable title
	 * @param v Variable title
	 */
	public void setTitle(String v) {
		this.title = v;
	}

	/**
	 * Getter method for variable video
	 * @return Boolean Returns video variable
	 */
	public Boolean getVideo() {
		return this.video;
	}

	/**
	 * Setter method for variable video
	 * @param v Variable video
	 */
	public void setVideo(Boolean v) {
		this.video = v;
	}

	/**
	 * Getter method for variable vote_average
	 * @return Double Returns vote_average variable
	 */
	public Double getVote_average() {
		return this.vote_average;
	}

	/**
	 * Setter method for variable vote_average
	 * @param v Variable vote_average
	 */
	public void setVote_average(Double v) {
		this.vote_average = v;
	}

	/**
	 * Getter method for variable vote_count
	 * @return Integer Returns vote_count variable
	 */
	public Integer getVote_count() {
		return this.vote_count;
	}

	/**
	 * Setter method for variable vote_count
	 * @param v Variable vote_count
	 */
	public void setVote_count(Integer v) {
		this.vote_count = v;
	}

}