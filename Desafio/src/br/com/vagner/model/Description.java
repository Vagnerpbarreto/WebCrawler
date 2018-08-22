package br.com.vagner.model;

public class Description {

	private String type;
	private Object content;

	public Description() {
		// TODO Auto-generated constructor stub
	}

	public Description(String type, Object content) {
		super();
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
