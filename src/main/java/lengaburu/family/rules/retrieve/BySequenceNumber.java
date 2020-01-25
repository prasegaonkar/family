package lengaburu.family.rules.retrieve;

import java.util.Comparator;

import lengaburu.family.model.Member;

public class BySequenceNumber implements Comparator<Member> {

	public int compare(Member o1, Member o2) {
		return o1.getSequenceNumber().compareTo(o2.getSequenceNumber());
	}

}
