package lengaburu.family.model.procedures;

import lengaburu.family.model.AddMember;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;
import lengaburu.family.model.exceptions.ChildAdditionFailed;

public class AddChild implements AddMember {

	@Override
	public void accept(Member member, Member child) {
		if (Gender.FEMALE.equals(member.getGender())) {
			updateChild(child, member);
			updateMother(child, member);
			updateFather(child, member);
		} else {
			throw new ChildAdditionFailed();
		}
	}

	private void updateChild(Member child, Member mother) {
		child.setMother(mother);
		child.setFather(mother.getSpouse());
	}

	private void updateMother(Member child, Member mother) {
		mother.addChild(child);
	}

	private void updateFather(Member child, Member mother) {
		Member father = mother.getSpouse();
		if (father != null) {
			father.addChild(child);
		}
	}
}
