package lengaburu.family.model.procedures;

import lengaburu.family.model.AddMember;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Member;
import lengaburu.family.model.exceptions.ChildAdditionFailed;

public class AddChild implements AddMember {

	@Override
	public void accept(Member member, Member child) {
		if (Gender.FEMALE.equals(member.getGender())) {
			child.setMother(member);
			child.setFather(member.getSpouse());
		} else {
			throw new ChildAdditionFailed();
		}
	}

}
