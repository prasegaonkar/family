package lengaburu.family.model.relationships;

import java.util.List;

import lengaburu.family.ExecutionContext;
import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class Children implements Relation {

	public List<Member> apply(Member member) {
		Family family = ExecutionContext.getFamily();
		return family.getMembersByFilter(x -> member.equals(x.getMother()) || member.equals(x.getFather()));
	}

}
