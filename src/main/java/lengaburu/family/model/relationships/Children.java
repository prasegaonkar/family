package lengaburu.family.model.relationships;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Children implements Relationship {

	@Override
	public Set<Member> apply(Family family, Member member) {
		final Map<String, Member> all = family.getAll();
		return all.values().stream().filter(x -> member.equals(x.getMother()) || member.equals(x.getFather()))
				.collect(Collectors.toSet());
	}

}
