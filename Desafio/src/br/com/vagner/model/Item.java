package br.com.vagner.model;

import java.util.List;

public class Item {

	private String title;
	private String link;
	private List<Description> description;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(String title, String link, List<Description> description) {
		super();
		this.title = title;
		this.link = link;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<Description> getDescription() {
		return description;
	}

	public void setDescription(List<Description> description) {
		this.description = description;
	}

}
