package lengaburu.family.relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class BrotherInLaws implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember m) {
		FamilyMember spouse = m.getSpouse();
		Set<FamilyMember> brothersOfSpouse = spouse.getRelatives(new Brothers());
		Set<FamilyMember> sisters = m.getRelatives(new Sisters());
		Set<FamilyMember> husbandsOfSisters = sisters.stream().map(FamilyMember::getSpouse).collect(Collectors.toSet());
		Set<FamilyMember> brotherInLaws = new HashSet<>();
		brotherInLaws.addAll(brothersOfSpouse);
		brotherInLaws.addAll(husbandsOfSisters);
		return brotherInLaws;
	}

}
