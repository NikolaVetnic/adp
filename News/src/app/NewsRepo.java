package app;

import java.util.ArrayList;
import java.util.List;

import app.observer.News;
import app.observer.User;

public class NewsRepo {

	private List<News> news;

	public NewsRepo() {
		this.news = new ArrayList<>();
	}
	
	public List<News> getNews() {
		return news;
	}
	
	public void addNews(News... inputNews) {
		for (News newsItem : inputNews)
			this.news.add(newsItem);
	}
}
