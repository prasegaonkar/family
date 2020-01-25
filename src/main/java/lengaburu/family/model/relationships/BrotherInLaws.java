package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class BrotherInLaws implements Relationship {

	@Override
	public List<Member> apply(Family family, Member member) {
		Member spouse = member.getSpouse();
		List<Member> brothersOfSpouse = new ArrayList<>();
		if (spouse != null) {
			brothersOfSpouse.addAll(spouse.get(new Brothers()));
		}
		List<Member> sisters = member.get(new Sisters());
		Set<Member> husbandsOfSisters = sisters.stream().filter(x -> x.getSpouse() != null).map(Member::getSpouse)
				.collect(Collectors.toSet());
		Set<Member> brotherInLaws = new HashSet<>();
		brotherInLaws.addAll(brothersOfSpouse);
		brotherInLaws.addAll(husbandsOfSisters);

		return family.getAll().values().stream().filter(m -> brotherInLaws.contains(m)).collect(Collectors.toList());
	}

}
