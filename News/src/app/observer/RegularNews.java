package app.observer;

import java.time.LocalDate;

public class RegularNews extends News {

	public RegularNews(String title, LocalDate created, String content) {
		super(title, created, content);
	}

	@Override
	public String printTitle() {
		return this.title;
	}

	@Override
	public String printDate() {
		return this.created.plusDays(1).toString();
	}
}
