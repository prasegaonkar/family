package lengaburu.family.relationship;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class MaternalUncles implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		FamilyMember mother = p.getMother();
		if (mother != null) {
			return mother.get(new Brothers());
		}
		return new HashSet<>();
	}

}
