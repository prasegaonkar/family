package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Siblings implements Relationship {

	@Override
	public List<Member> apply(Family family, Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return mother.get(new Children()).stream().filter(c -> !c.getName().equals(member.getName()))
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

}
