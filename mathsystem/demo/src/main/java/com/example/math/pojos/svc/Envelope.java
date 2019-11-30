package com.example.math.pojos.svc;

public interface Envelope<H,B> {
	public H getHeader();
	public B getBody();
}
