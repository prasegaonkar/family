package lengaburu.family.model.relationships;

import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Daughters implements Relationship {

	@Override
	public Set<Member> apply(Member p) {
		return p.getChildren().stream().filter(x -> Gender.FEMALE.equals(x.getGender())).collect(Collectors.toSet());
	}

}
