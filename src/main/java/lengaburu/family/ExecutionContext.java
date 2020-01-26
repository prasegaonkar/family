package lengaburu.family;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;

public class ExecutionContext {
	private static Family theShanFamily;

	public static Family getFamily() {
		return theShanFamily;
	}

	public static void setup() {
		theShanFamily = new Family("The Shan Family", "King Shan", "Queen Anga");
		theShanFamily.addChild("Queen Anga", "Chit", Gender.MALE);
		theShanFamily.addChild("Queen Anga", "Ish", Gender.MALE);
		theShanFamily.addChild("Queen Anga", "Vich", Gender.MALE);
		theShanFamily.addChild("Queen Anga", "Aras", Gender.MALE);
		theShanFamily.addChild("Queen Anga", "Satya", Gender.FEMALE);

		theShanFamily.addSpouse("Chit", "Amba");
		theShanFamily.addSpouse("Vich", "Lika");
		theShanFamily.addSpouse("Aras", "Chitra");
		theShanFamily.addSpouse("Satya", "Vyan");

		theShanFamily.addChild("Amba", "Dritha", Gender.FEMALE);
		theShanFamily.addChild("Amba", "Tritha", Gender.FEMALE);
		theShanFamily.addChild("Amba", "Vritha", Gender.MALE);

		theShanFamily.addChild("Lika", "Vila", Gender.FEMALE);
		theShanFamily.addChild("Lika", "Chika", Gender.FEMALE);

		theShanFamily.addChild("Chitra", "Jnki", Gender.FEMALE);
		theShanFamily.addChild("Chitra", "Ahit", Gender.MALE);

		theShanFamily.addChild("Satya", "Asva", Gender.MALE);
		theShanFamily.addChild("Satya", "Vyas", Gender.MALE);
		theShanFamily.addChild("Satya", "Atya", Gender.FEMALE);

		theShanFamily.addSpouse("Dritha", "Jaya");
		theShanFamily.addSpouse("Jnki", "Arit");
		theShanFamily.addSpouse("Asva", "Satvy");
		theShanFamily.addSpouse("Vyas", "Krpi");

		theShanFamily.addChild("Dritha", "Yodhan", Gender.MALE);
		theShanFamily.addChild("Jnki", "Laki", Gender.MALE);
		theShanFamily.addChild("Jnki", "Lavnya", Gender.FEMALE);
		theShanFamily.addChild("Satvy", "Vasa", Gender.MALE);
		theShanFamily.addChild("Krpi", "Kriya", Gender.MALE);
		theShanFamily.addChild("Krpi", "Krithi", Gender.FEMALE);

	}

}
