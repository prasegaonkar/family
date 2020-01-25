package lengaburu.family;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;

public class App {
	private final Family family;

	public App() {
		this.family = new Family("The Shan Family", "King Shan", "Queen Anga");
		family.addChild("Queen Anga", "Chit", Gender.MALE);
		family.addChild("Queen Anga", "Ish", Gender.MALE);
		family.addChild("Queen Anga", "Vich", Gender.MALE);
		family.addChild("Queen Anga", "Aras", Gender.MALE);
		family.addChild("Queen Anga", "Satya", Gender.FEMALE);

		family.addSpouse("Chit", "Amba", Gender.FEMALE);

		family.addSpouse("Vich", "Lika", Gender.FEMALE);

		family.addSpouse("Aras", "Chitra", Gender.FEMALE);

		family.addSpouse("Satya", "Vyan", Gender.MALE);
	}
	
	public Family getFamily() {
		return family;
	}

	public static void main(String[] args) {
		App app = new App();
		System.out.println(app.family);
	}
}
