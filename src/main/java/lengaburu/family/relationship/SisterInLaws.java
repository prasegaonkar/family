package lengaburu.family.relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class SisterInLaws implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		FamilyMember spouse = p.getSpouse();
		Set<FamilyMember> sistersOfSpouse = spouse.getRelatives(new Sisters());
		Set<FamilyMember> brothers = p.getRelatives(new Brothers());
		Set<FamilyMember> wivesOfBrothers = brothers.stream().map(FamilyMember::getSpouse).collect(Collectors.toSet());
		Set<FamilyMember> sisterInLaws = new HashSet<>();
		sisterInLaws.addAll(sistersOfSpouse);
		sisterInLaws.addAll(wivesOfBrothers);
		return sisterInLaws;
	}

}
