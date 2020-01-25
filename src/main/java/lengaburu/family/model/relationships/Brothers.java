package lengaburu.family.model.relationships;

import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Relationship;

public class Brothers implements Relationship {

	@Override
	public Set<Member> apply(Member p) {
		return p.get(new Siblings()).stream().filter(x -> Gender.MALE.equals(x.getGender()))
				.collect(Collectors.toSet());
	}

}
