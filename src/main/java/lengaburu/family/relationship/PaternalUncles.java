package lengaburu.family.relationship;

import java.util.HashSet;
import java.util.Set;

import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Relationship;

public class PaternalUncles implements Relationship {

	@Override
	public Set<FamilyMember> apply(FamilyMember p) {
		FamilyMember father = p.getFather();
		if (father != null) {
			return father.get(new Brothers());
		}
		return new HashSet<>();
	}

}
