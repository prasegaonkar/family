package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.List;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class MaternalAunts implements Relation {

	public List<Member> apply(Family family, Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return Relationships.SISTER.resolve(family, mother);
		}
		return new ArrayList<>();
	}

}
