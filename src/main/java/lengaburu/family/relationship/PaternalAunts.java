package lengaburu.family.relationship;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class PaternalAunts implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		FamilyMember father = p.getFather();
		if (father != null) {
			return father.getRelatives(new Sisters());
		}
		return new HashSet<>();
	}

}
