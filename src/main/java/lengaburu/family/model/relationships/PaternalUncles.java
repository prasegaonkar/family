package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.List;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class PaternalUncles implements Relationship {

	@Override
	public List<Member> apply(Family family, Member member) {
		Member father = member.getFather();
		if (father != null) {
			return father.get(new Brothers());
		}
		return new ArrayList<>();
	}

}
