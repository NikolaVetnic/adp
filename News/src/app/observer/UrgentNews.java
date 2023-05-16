package app.observer;

import java.time.LocalDate;

public class UrgentNews extends News {

	public UrgentNews(String title, LocalDate created, String content) {
		super(title, created, content);
	}

	@Override
	public String printTitle() {
		return this.title.toUpperCase();
	}

	@Override
	public String printDate() {
		return this.created.toString();
	}
}
