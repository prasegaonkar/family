package lengaburu.family.model.relationships;

import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Daughters implements Relationship {

	@Override
	public List<Member> apply(Family family, Member member) {
		return member.get(new Children()).stream().filter(x -> Gender.FEMALE.equals(x.getGender()))
				.collect(Collectors.toList());
	}

}
