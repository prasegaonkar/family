package lengaburu.family.model.relationships;

import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Sisters implements Relationship {

	@Override
	public Set<Member> apply(Family family, Member member) {
		return member.get(new Siblings()).stream().filter(x -> Gender.FEMALE.equals(x.getGender()))
				.collect(Collectors.toSet());
	}

}