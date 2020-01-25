package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class PaternalAunts implements Relationship {

	@Override
	public Set<Member> apply(Member p) {
		Member father = p.getFather();
		if (father != null) {
			return father.get(new Sisters());
		}
		return new HashSet<>();
	}

}
