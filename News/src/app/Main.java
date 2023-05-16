package app;

import java.time.LocalDate;
import java.util.Random;

import app.observer.News;
import app.observer.RegularNews;
import app.observer.UrgentNews;
import app.observer.User;

public class Main {
	
	private static UserRepo userRepo = new UserRepo();
	private static NewsRepo newsRepo = new NewsRepo();

	public static void main(String[] args) {
		
		userRepo.addUsers(
				new User("mika@gmail.com"),
				new User("zika@gmail.com"),
				new User("tika@gmail.com"),
				new User("pika@gmail.com"));
		
		newsRepo.addNews(
				new RegularNews("Regular News #0", LocalDate.now(), "Contents of regular news #0."),
				new UrgentNews("Urgent News #0", LocalDate.now(), "Contents of URGENT news #0."));
		
		// subscribe all users to all news with 50% chance
		for (News news : newsRepo.getNews())
			for (User user : userRepo.getUsers())
				if (new Random().nextDouble() < .5) 
					news.attach(user);
		
		// publish all news
		for (News news : newsRepo.getNews())
			news.publish();
		
		// send out emails with 50% chance
		for (User sender : userRepo.getUsers())
			for (User target : userRepo.getUsers())
				if (new Random().nextDouble() < .5) 
					sender.sendEmail(target.getEmail());
	}
}
