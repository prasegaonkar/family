package lengaburu.family.model.relationships;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;
import lengaburu.family.model.Relationship;

public class Siblings implements Relationship {

	@Override
	public Set<Member> apply(Member p) {
		Member mother = p.getMother();
		if (mother != null) {
			return mother.getChildren().stream().filter(c -> !c.getName().equals(p.getName()))
					.collect(Collectors.toSet());
		}
		return new HashSet<>();
	}

}
