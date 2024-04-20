package com.javapulse;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
		// private constructor to prevent instantiation
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	public void doSomething() {
		System.out.println("Doing something in Singleton");
	}

}
