package lengaburu.family.rules.add;

import lengaburu.family.model.FamilyMember;

public class AddSpouse {

	public void add(FamilyMember spouse, FamilyMember member) {
		spouse.setSpouse(member);
		member.setSpouse(spouse);
	}


}
