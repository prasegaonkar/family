package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class SisterInLaws implements Relationship {

	@Override
	public Set<Member> apply(Family family, Member member) {
		Member spouse = member.getSpouse();
		Set<Member> sistersOfSpouse = new HashSet<>();
		if (spouse != null) {
			sistersOfSpouse.addAll(spouse.get(new Sisters()));
		}
		Set<Member> brothers = member.get(new Brothers());
		Set<Member> wivesOfBrothers = brothers.stream().filter(x -> x.getSpouse() != null).map(Member::getSpouse)
				.collect(Collectors.toSet());
		Set<Member> sisterInLaws = new HashSet<>();
		sisterInLaws.addAll(sistersOfSpouse);
		sisterInLaws.addAll(wivesOfBrothers);
		return sisterInLaws;
	}

}
