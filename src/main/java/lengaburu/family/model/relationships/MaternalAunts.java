package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.List;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class MaternalAunts implements Relationship {

	@Override
	public List<Member> apply(Family family, Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return mother.get(new Sisters());
		}
		return new ArrayList<>();
	}

}
