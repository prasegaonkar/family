package lengaburu.family.rules.add;

import lengaburu.family.exceptions.ChildAdditionFailed;
import lengaburu.family.model.FamilyMember;
import lengaburu.family.model.Gender;

public class AddChild {

	public void add(FamilyMember child, FamilyMember member) {
		if (Gender.FEMALE.equals(member.getGender())) {
			updateChild(child, member);
			updateMother(child, member);
			updateFather(child, member);
		} else {
			throw new ChildAdditionFailed();
		}
	}

	private void updateChild(FamilyMember child, FamilyMember mother) {
		child.setMother(mother);
		child.setFather(mother.getSpouse());
	}

	private void updateMother(FamilyMember child, FamilyMember mother) {
		mother.addChild(child);
	}

	private void updateFather(FamilyMember child, FamilyMember mother) {
		FamilyMember father = mother.getSpouse();
		if (father != null) {
			father.addChild(child);
		}
	}

}
