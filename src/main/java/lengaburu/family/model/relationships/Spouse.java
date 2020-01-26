package lengaburu.family.model.relationships;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Member;

class Spouse implements Relation {

	@Override
	public List<Member> apply(Member member) {
		Member spouse = member.getSpouse();
		if (spouse != null) {
			return Arrays.asList(spouse).stream().collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

}
