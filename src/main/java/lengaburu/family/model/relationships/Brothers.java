package lengaburu.family.model.relationships;

import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;

class Brothers implements Relation {

	public List<Member> apply(Member member) {
		return Relationships.SIBLING.resolve(member).stream().filter(x -> Gender.MALE.equals(x.getGender()))
				.collect(Collectors.toList());
	}

}
