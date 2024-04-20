package com.javapulse;

public class Main {
	public static void main(String[] args) {
		DocumentPrototype reportPrototype = new Report("John");

		DocumentPrototype newReport = reportPrototype.clone();
		newReport.fillContent("Monthly Sales Report ...");
		newReport.print();

		DocumentPrototype anotherReport = reportPrototype.clone();
		anotherReport.fillContent("Quarterly Financial Report ...");
		anotherReport.print();
	}
}