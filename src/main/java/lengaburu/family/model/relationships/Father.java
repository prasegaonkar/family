package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;

class Father implements Relation {

	@Override
	public List<Member> apply(Member member) {
		Member father = member.getFather();
		if (father != null) {
			return Arrays.asList(father).stream().collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

}
