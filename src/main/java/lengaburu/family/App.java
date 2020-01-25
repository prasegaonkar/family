package lengaburu.family;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.relationship.MaternalAunts;
import lengaburu.family.relationship.Siblings;
import lengaburu.family.relationship.SisterInLaws;

public class App {
	public static void main(String[] args) {
		final Family theShanFamily = InitialSetup.setup();
		theShanFamily.addChild("Chitra", "Aria", Gender.FEMALE);
		System.out.println(theShanFamily.getRelationship("Lavnya", new MaternalAunts()));
		System.out.println(theShanFamily.getRelationship("Aria", new Siblings()));
		System.out.println(theShanFamily.getRelationship("Atya", new SisterInLaws()));
	}
}
