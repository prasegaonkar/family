package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.ExecutionContext;
import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class BrotherInLaws implements Relation {

	@Override
	public List<Member> apply(Member member) {
		Member spouse = member.getSpouse();
		List<Member> brothersOfSpouse = new ArrayList<>();
		if (spouse != null) {
			brothersOfSpouse.addAll(Relationships.BROTHER.resolve(spouse));
		}
		List<Member> sisters = Relationships.SISTER.resolve(member);
		Set<Member> husbandsOfSisters = sisters.stream().filter(x -> x.getSpouse() != null).map(Member::getSpouse)
				.collect(Collectors.toSet());
		Set<Member> brotherInLaws = new HashSet<>();
		brotherInLaws.addAll(brothersOfSpouse);
		brotherInLaws.addAll(husbandsOfSisters);

		Family family = ExecutionContext.getFamily();
		return family.getMembersByFilter(m -> brotherInLaws.contains(m));
	}
}