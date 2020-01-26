package lengaburu.family.model.procedures;

import lengaburu.family.model.Member;

class AddSpouse implements AddMember {

	@Override
	public void accept(Member member, Member spouse) {
		spouse.setSpouse(member);
		member.setSpouse(spouse);
	}

}
