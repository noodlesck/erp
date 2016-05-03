package com.noodles.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity

public class Menu implements java.io.Serializable {

	// Fields

	private String id;
	private Menu tmenu;
	private String text;
	private String iconcls;
	private String url;
	private Set<Menu> tmenus = new HashSet<Menu>(0);

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** minimal constructor */
	public Menu(String id) {
		this.id = id;
	}

	/** full constructor */
	public Menu(String id, Menu tmenu, String text, String iconcls, String url, Set<Menu> tmenus) {
		this.id = id;
		this.tmenu = tmenu;
		this.text = text;
		this.iconcls = iconcls;
		this.url = url;
		this.tmenus = tmenus;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PID")
	public Menu getTmenu() {
		return this.tmenu;
	}

	public void setTmenu(Menu tmenu) {
		this.tmenu = tmenu;
	}

	@Column(name = "TEXT", length = 100)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "ICONCLS", length = 50)
	public String getIconcls() {
		return this.iconcls;
	}

	public void setIconcls(String iconcls) {
		this.iconcls = iconcls;
	}

	@Column(name = "URL", length = 200)
	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tmenu")
	public Set<Menu> getTmenus() {
		return this.tmenus;
	}

	public void setTmenus(Set<Menu> tmenus) {
		this.tmenus = tmenus;
	}

}