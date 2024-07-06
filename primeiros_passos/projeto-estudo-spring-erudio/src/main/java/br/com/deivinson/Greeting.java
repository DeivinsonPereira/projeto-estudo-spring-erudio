package br.com.deivinson;

public class Greeting {
	
	private final Long id;
	private final String content;
	
	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}
	
	public Long getId() {
		return id;
	}
	public String getContent() {
		return content;
	}


}
