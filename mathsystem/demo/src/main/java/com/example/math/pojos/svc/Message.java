package com.example.math.pojos.svc;

public class Message<H, B> implements Envelope<H, B> {
	private H header;
	private B body;
	
	
	public Message() {
		//Constructor de mensaje vacio
	}
	
	public Message(H header, B body) {
		this.header = header;
		this.body = body;
	}
	
	@Override
	public H getHeader() {
		return header;
	}

	public void setHeader(H header) {
		this.header = header;
	}

	@Override
	public B getBody() {
		// TODO Auto-generated method stub
		return body;
	}
	
	public void setBody(B body) {
		this.body = body;
	}
}
