package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;

class Siblings implements Relation {

	@Override
	public List<Member> apply(Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return Relationships.CHILDREN.resolve(mother).stream().filter(c -> !c.getName().equals(member.getName()))
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

}
