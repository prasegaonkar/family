package lengaburu.family.model.relationships;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lengaburu.family.ExecutionContext;
import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class Children implements Relation {

	public List<Member> apply(Member member) {
		Family family = ExecutionContext.getFamily();
		final Map<String, Member> all = family.getAll();
		return all.values().stream().filter(x -> member.equals(x.getMother()) || member.equals(x.getFather()))
				.collect(Collectors.toList());
	}

}
