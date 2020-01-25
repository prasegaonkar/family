package lengaburu.family.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.exceptions.MemberAlreadyExists;
import lengaburu.family.exceptions.MemberNotFound;
import lengaburu.family.rules.add.AddChild;
import lengaburu.family.rules.add.AddSpouse;
import lengaburu.family.rules.retrieve.BySequenceNumber;

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

	public void addSpouse(String familyMemberName, String spouseName) {
		if (namesToMembersMapping.containsKey(familyMemberName) == false) {
			throw new MemberNotFound();
		}
		newMemberNameUniquenessCheck(spouseName);
		FamilyMember member = namesToMembersMapping.get(familyMemberName);
		FamilyMember spouse = new FamilyMember(nextSequenceNumber(), spouseName, member.getGender().opposite());
		new AddSpouse().add(spouse, member);
		namesToMembersMapping.put(spouseName, spouse);
	}

	public void addChild(String memberName, String childName, Gender childGender) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		newMemberNameUniquenessCheck(childName);
		FamilyMember child = new FamilyMember(nextSequenceNumber(), childName, childGender);
		FamilyMember member = namesToMembersMapping.get(memberName);
		new AddChild().add(child, member);
		namesToMembersMapping.put(childName, child);
	}

	public List<String> getRelationship(String memberName, Relationship relationship) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		final FamilyMember member = namesToMembersMapping.get(memberName);
		final Set<FamilyMember> relatives = member.getRelatives(relationship);
		return relatives.stream().sorted(new BySequenceNumber()).map(FamilyMember::getName)
				.collect(Collectors.toList());
	}

	public FamilyMember get(String name) {
		return namesToMembersMapping.get(name);
	}

	public Map<String, FamilyMember> getAll() {
		return namesToMembersMapping;
	}

	private int nextSequenceNumber() {
		return getNumberOfMembers() + 1;
	}

	public int getNumberOfMembers() {
		return namesToMembersMapping.size();
	}

	private void newMemberNameUniquenessCheck(String memberName) {
		if (namesToMembersMapping.containsKey(memberName)) {
			throw new MemberAlreadyExists();
		}
	}
}
