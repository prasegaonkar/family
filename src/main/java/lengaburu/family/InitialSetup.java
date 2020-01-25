package lengaburu.family;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;

public class InitialSetup {
	public static Family setup() {
		Family f = new Family("The Shan Family", "King Shan", "Queen Anga");
		f.addChild("Queen Anga", "Chit", Gender.MALE);
		f.addChild("Queen Anga", "Ish", Gender.MALE);
		f.addChild("Queen Anga", "Vich", Gender.MALE);
		f.addChild("Queen Anga", "Aras", Gender.MALE);
		f.addChild("Queen Anga", "Satya", Gender.FEMALE);

		f.addSpouse("Chit", "Amba");
		f.addSpouse("Vich", "Lika");
		f.addSpouse("Aras", "Chitra");
		f.addSpouse("Satya", "Vyan");

		f.addChild("Amba", "Dritha", Gender.FEMALE);
		f.addChild("Amba", "Tritha", Gender.FEMALE);
		f.addChild("Amba", "Vritha", Gender.MALE);

		f.addChild("Lika", "Vila", Gender.FEMALE);
		f.addChild("Lika", "Chika", Gender.FEMALE);

		f.addChild("Chitra", "Jnki", Gender.FEMALE);
		f.addChild("Chitra", "Ahit", Gender.MALE);

		f.addChild("Satya", "Asva", Gender.MALE);
		f.addChild("Satya", "Vyas", Gender.MALE);
		f.addChild("Satya", "Atya", Gender.FEMALE);

		f.addSpouse("Dritha", "Jaya");
		f.addSpouse("Jnki", "Arit");
		f.addSpouse("Asva", "Satvy");
		f.addSpouse("Vyas", "Krpi");

		f.addChild("Dritha", "Yodhan", Gender.MALE);
		f.addChild("Jnki", "Laki", Gender.MALE);
		f.addChild("Jnki", "Lavnya", Gender.FEMALE);
		f.addChild("Satvy", "Vasa", Gender.MALE);
		f.addChild("Krpi", "Kriya", Gender.MALE);
		f.addChild("Krpi", "Krithi", Gender.FEMALE);

		return f;
	}
}
