package lengaburu.family.model.relationships;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

class Children implements Relation {

	public List<Member> apply(Family family, Member member) {
		final Map<String, Member> all = family.getAll();
		return all.values().stream().filter(x -> member.equals(x.getMother()) || member.equals(x.getFather()))
				.collect(Collectors.toList());
	}

}
