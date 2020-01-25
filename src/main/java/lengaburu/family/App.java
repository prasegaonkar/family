package lengaburu.family;

import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.rules.retrieve.BySequenceNumber;

public class App {
	public static void main(String[] args) {
		final Family theShanFamily = InitialSetup.setup();

		System.out.println(
				theShanFamily.getAll().values().stream().sorted(new BySequenceNumber()).collect(Collectors.toList()));

//		
//		
//		theShanFamily.addChild("Chitra", "Aria", Gender.FEMALE);
//		System.out.println(theShanFamily.getRelationship("Lavnya", new MaternalAunts()));
//		System.out.println(theShanFamily.getRelationship("Aria", new Siblings()));
//		System.out.println(theShanFamily.getRelationship("Atya", new SisterInLaws()));
	}
}
