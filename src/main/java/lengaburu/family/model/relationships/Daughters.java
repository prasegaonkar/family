package lengaburu.family.model.relationships;

import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;

class Daughters implements Relation {

	public List<Member> apply(Family family, Member member) {
		return Relationships.CHILDREN.resolve(family, member).stream().filter(x -> Gender.FEMALE.equals(x.getGender()))
				.collect(Collectors.toList());
	}

}
