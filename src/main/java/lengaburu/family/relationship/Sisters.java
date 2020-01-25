package lengaburu.family.relationship;

import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Relationship;

public class Sisters implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		return p.get(new Siblings()).stream().filter(x -> Gender.FEMALE.equals(x.getGender()))
				.collect(Collectors.toSet());
	}

}
