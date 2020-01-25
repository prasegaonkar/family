package lengaburu.family.model;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import lengaburu.family.exceptions.MemberNotFoundException;
import lengaburu.family.exceptions.MemberAlreadyExistsException;
import lengaburu.family.rules.add.AddChild;
import lengaburu.family.rules.add.AddSpouse;

public class Family {
	private final String name;
	private final Map<String, FamilyMember> namesToMembersMapping;

	public Family(String name, String kingName, String queenName) {
		this.name = name;
		this.namesToMembersMapping = new HashMap<>();
		final King king = new King(kingName);
		final Queen queen = new Queen(queenName, king);
		namesToMembersMapping.put(kingName, king);
		namesToMembersMapping.put(queenName, queen);
	}

	public String getName() {
		return this.name;
	}

	public void addSpouse(String familyMemberName, String spouseName, Gender spouseGender) {
		if (namesToMembersMapping.containsKey(familyMemberName) == false) {
			throw new MemberNotFoundException();
		}
		if (namesToMembersMapping.containsKey(spouseName)) {
			throw new MemberAlreadyExistsException();
		}
		FamilyMember spouse = new FamilyMember(nextSequenceNumber(), spouseName, spouseGender);
		FamilyMember member = namesToMembersMapping.get(familyMemberName);
		new AddSpouse().add(spouse, member);
		namesToMembersMapping.put(spouseName, spouse);
	}

	public void addChild(String motherName, String childName, Gender childGender) {
		if (namesToMembersMapping.containsKey(motherName) == false) {
			throw new MemberNotFoundException();
		}
		if (namesToMembersMapping.containsKey(childName)) {
			throw new MemberAlreadyExistsException();
		}
		FamilyMember child = new FamilyMember(nextSequenceNumber(), childName, childGender);
		FamilyMember mother = namesToMembersMapping.get(motherName);
		new AddChild().add(child, mother);
		namesToMembersMapping.put(childName, child);
	}

	public FamilyMember get(String name) {
		return namesToMembersMapping.get(name);
	}

	private int nextSequenceNumber() {
		return getNumberOfMembers() + 1;
	}

	public int getNumberOfMembers() {
		return namesToMembersMapping.size();
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		namesToMembersMapping.values().stream().sorted(Comparator.comparingInt(FamilyMember::getSequenceNumber))
				.forEach(e -> builder.append(e).append("\n"));
		return builder.toString();
	}

}
