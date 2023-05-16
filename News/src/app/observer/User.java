package app.observer;

public class User implements Observer {
	
	private String email;

	public User(String email) {
		this.email = email;
	}
	
	public void sendEmail(String target) {
		System.out.printf("USER %s SENDS AN EMAIL -> %s \n", this.email, target);
	}

	@Override
	public void inform(Subject subject) {
		System.out.printf("USER %s RECEIVES -> %s \n", email, subject.toString());
	}
	
	public String getEmail() {
		return email;
	}
}
