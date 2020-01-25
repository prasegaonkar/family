package lengaburu.family.rules.retrieve;

import java.util.Comparator;

import lengaburu.family.model.FamilyMember;

public class BySequenceNumber implements Comparator<FamilyMember> {

	public int compare(FamilyMember o1, FamilyMember o2) {
		return o1.getSequenceNumber().compareTo(o2.getSequenceNumber());
	}

}
