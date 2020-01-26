package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class SisterInLaws implements Relation {

	@Override
	public List<Member> apply(Family family, Member member) {
		Member spouse = member.getSpouse();
		Set<Member> sistersOfSpouse = new HashSet<>();
		if (spouse != null) {
			sistersOfSpouse.addAll(Relationships.SISTER.resolve(family, spouse));
		}
		List<Member> brothers = Relationships.BROTHER.resolve(family, member);

		Set<Member> wivesOfBrothers = brothers.stream().filter(x -> x.getSpouse() != null).map(Member::getSpouse)
				.collect(Collectors.toSet());
		Set<Member> sisterInLaws = new HashSet<>();
		sisterInLaws.addAll(sistersOfSpouse);
		sisterInLaws.addAll(wivesOfBrothers);

		return family.getAll().values().stream().filter(m -> sisterInLaws.contains(m)).collect(Collectors.toList());
	}

}
