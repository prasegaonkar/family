package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Siblings implements Relationship {

	@Override
	public Set<Member> apply(Family family, Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return mother.get(new Children()).stream().filter(c -> !c.getName().equals(member.getName()))
					.collect(Collectors.toSet());
		}
		return new HashSet<>();
	}

}
