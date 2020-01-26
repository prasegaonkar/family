package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;

class Mother implements Relation {

	@Override
	public List<Member> apply(Member member) {
		Member mother = member.getMother();
		if (mother != null) {
			return Arrays.asList(mother).stream().collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

}
