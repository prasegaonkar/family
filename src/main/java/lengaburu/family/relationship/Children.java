package lengaburu.family.relationship;

import java.util.Set;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class Children implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		return p.getChildren();
	}

}
