package lengaburu.family.relationship;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class MaternalAunts implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		FamilyMember mother = p.getMother();
		if (mother != null) {
			return mother.getRelatives(new Sisters());
		}
		return new HashSet<>();
	}

}
