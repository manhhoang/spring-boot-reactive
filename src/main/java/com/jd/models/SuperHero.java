package com.jd.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * An entity SuperHero composed by seven fields (id, name, pseudonym, publisher,
 * skills, allies, dateOfAppearance). The Entity annotation indicates that this
 * class is a JPA entity. The Table annotation specifies the name for the table
 * in the db.
 *
 * @author Manh Hoang
 */
@Entity
@Table(name = "super_hero")
public class SuperHero {

	// ------------------------
	// PRIVATE FIELDS
	// ------------------------

	// An autogenerated id (unique for each super hero in the db)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long superHeroId;

	// The super hero's name
	@NotNull
	private String name;

	// The super hero's pseudonym
	private String pseudonym;

	// The super hero's publisher
	private String publisher;

	// The super hero's skills
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "super_hero_skill", joinColumns = { @JoinColumn(name = "super_hero_id") }, inverseJoinColumns = {
			@JoinColumn(name = "skill_id") })
	private Set<Skill> skills;

	// The super hero's allies if the superhero has any
	@Transient
	private Set<SuperHero> allies;

	// The super hero's date of first appearance (format YYYY-MM-DD)
	private String dateOfAppearance;

	// ------------------------
	// PUBLIC METHODS
	// ------------------------

	public SuperHero() {
	}

	public SuperHero(long id) {
		this.superHeroId = id;
	}

	public SuperHero(String name) {
		this.name = name;
	}

	public SuperHero(String name, String pseudonym, String publisher, Set<Skill> skills, String dateOfAppearance) {
		this.name = name;
		this.pseudonym = pseudonym;
		this.publisher = publisher;
		this.skills = skills;
		this.dateOfAppearance = dateOfAppearance;
	}

	public SuperHero(String name, String pseudonym, String publisher, Set<Skill> skills, Set<SuperHero> allies,
			String dateOfAppearance) {
		this.name = name;
		this.pseudonym = pseudonym;
		this.publisher = publisher;
		this.skills = skills;
		this.allies = allies;
		this.dateOfAppearance = dateOfAppearance;
	}

	// Getter and setter methods

	public String getName() {
		return name;
	}

	public long getSuperHeroId() {
		return superHeroId;
	}

	public void setSuperHeroId(long superHeroId) {
		this.superHeroId = superHeroId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPseudonym() {
		return pseudonym;
	}

	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Set<SuperHero> getAllies() {
		return allies;
	}

	public void setAllies(Set<SuperHero> allies) {
		this.allies = allies;
	}

	public String getDateOfAppearance() {
		return dateOfAppearance;
	}

	public void setDateOfAppearance(String dateOfAppearance) {
		this.dateOfAppearance = dateOfAppearance;
	}

} // class SuperHero
