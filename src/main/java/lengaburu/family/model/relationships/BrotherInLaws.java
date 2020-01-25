package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class BrotherInLaws implements Relationship {

	@Override
	public Set<Member> apply(Member m) {
		Member spouse = m.getSpouse();
		Set<Member> brothersOfSpouse = new HashSet<>();
		if (spouse != null) {
			brothersOfSpouse.addAll(spouse.get(new Brothers()));
		}
		Set<Member> sisters = m.get(new Sisters());
		Set<Member> husbandsOfSisters = sisters.stream().filter(x -> x.getSpouse() != null)
				.map(Member::getSpouse).collect(Collectors.toSet());
		Set<Member> brotherInLaws = new HashSet<>();
		brotherInLaws.addAll(brothersOfSpouse);
		brotherInLaws.addAll(husbandsOfSisters);
		return brotherInLaws;
	}

}
