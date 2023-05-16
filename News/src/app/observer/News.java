package app.observer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class News implements Subject {
	
	protected String title;
	protected LocalDate created;
	private String content;
	
	private List<Observer> observers;
	
	public News(String title, LocalDate created, String content) {
		this.title = title;
		this.created = created;
		this.content = content;
		
		this.observers = new ArrayList<>();
	}
	
	public void publish() {
		for (Observer o : observers)
			o.inform(this);
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}
	
	public abstract String printTitle();
	
	public abstract String printDate();
	
	public String printContent() {
		return this.content;
	}
	
	@Override
	public String toString() {
		return String.format("NEWS [ %s, %s :: %s ]", printTitle(), printDate(), printContent());
	}
}
