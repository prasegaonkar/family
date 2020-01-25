package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class MaternalUncles implements Relationship {

	@Override
	public Set<Member> apply(Member p) {
		Member mother = p.getMother();
		if (mother != null) {
			return mother.get(new Brothers());
		}
		return new HashSet<>();
	}

}
