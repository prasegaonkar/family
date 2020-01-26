package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.List;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class PaternalAunts implements Relation {

	@Override
	public List<Member> apply(Family family, Member member) {
		Member father = member.getFather();
		if (father != null) {
			return Relationships.SISTER.resolve(family, father);
		}
		return new ArrayList<>();
	}

}
