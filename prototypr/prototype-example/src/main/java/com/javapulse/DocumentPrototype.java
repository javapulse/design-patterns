package com.javapulse;

public interface DocumentPrototype {

	DocumentPrototype clone();
	void fillContent(String content);
	void print();

}
