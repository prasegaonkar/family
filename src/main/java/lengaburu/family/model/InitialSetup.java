package lengaburu.family.model;

public class InitialSetup {
	public static Family setup() {
		Family f = new Family("The Shan Family", "King Shan", "Queen Anga");
		f.addChild("Queen Anga", "Chit", Gender.MALE);
		f.addChild("Queen Anga", "Ish", Gender.MALE);
		f.addChild("Queen Anga", "Vich", Gender.MALE);
		f.addChild("Queen Anga", "Aras", Gender.MALE);
		f.addChild("Queen Anga", "Satya", Gender.FEMALE);

		f.addSpouse("Chit", "Amba", Gender.FEMALE);

		f.addSpouse("Vich", "Lika", Gender.FEMALE);

		f.addSpouse("Aras", "Chitra", Gender.FEMALE);

		f.addSpouse("Satya", "Vyan", Gender.MALE);
		return f;
	}
}
