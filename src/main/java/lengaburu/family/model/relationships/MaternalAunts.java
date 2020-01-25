package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class MaternalAunts implements Relationship {

	@Override
	public Set<Member> apply(Family family, Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return mother.get(new Sisters());
		}
		return new HashSet<>();
	}

}
