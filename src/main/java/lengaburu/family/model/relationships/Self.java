package lengaburu.family.model.relationships;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;

class Self implements Relation {

	@Override
	public List<Member> apply(Member member) {
		return Arrays.asList(member).stream().collect(Collectors.toList());
	}

}
