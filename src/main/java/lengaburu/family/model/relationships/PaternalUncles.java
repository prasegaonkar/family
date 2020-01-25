package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class PaternalUncles implements Relationship {

	@Override
	public Set<Member> apply(Family family, Member member) {
		Member father = member.getFather();
		if (father != null) {
			return father.get(new Brothers());
		}
		return new HashSet<>();
	}

}
