package com.javapulse;

public class Report implements DocumentPrototype {

	private String content;
	private String author;

	public Report(String author) {
		this.author = author;
	}

	@Override
	public DocumentPrototype clone() {
		Report newReport = new Report(this.author);
		newReport.fillContent(this.content);
		return newReport;
	}

	@Override
	public void fillContent(String content) {
		this.content = content;
	}

	@Override
	public void print() {
		System.out.println("Report created by: " + author);
		System.out.println("Report content: " + content);
	}

}
