package lengaburu.family.rules.add;

import java.util.Set;

import lengaburu.family.model.FamilyMember;

public class AddChild {

	public void add(FamilyMember child, FamilyMember mother) {
		updateChild(child, mother);
		if (mother != null) {
			updateSiblings(child, mother);
			updateMother(child, mother);
			updateFather(child, mother);
		}
	}

	private void updateSiblings(FamilyMember child, FamilyMember mother) {
		Set<FamilyMember> children = mother.getChildren();
		children.forEach(s -> s.addSibling(child));
	}

	private void updateChild(FamilyMember child, FamilyMember mother) {
		child.setMother(mother);
		if (mother != null) {
			child.setFather(mother.getSpouse());
			child.addSiblings(mother.getChildren());
		}
	}

	private void updateFather(FamilyMember child, FamilyMember mother) {
		FamilyMember father = mother.getSpouse();
		if (father != null) {
			father.addChild(child);
		}
	}

	private void updateMother(FamilyMember child, FamilyMember mother) {
		mother.addChild(child);
	}

}
