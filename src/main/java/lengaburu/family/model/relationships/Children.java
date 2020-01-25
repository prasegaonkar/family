package lengaburu.family.model.relationships;

import java.util.Set;

import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Children implements Relationship {

	@Override
	public Set<Member> apply(Member p) {
		return p.getChildren();
	}

}
