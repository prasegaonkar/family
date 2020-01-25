package lengaburu.family.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.model.exceptions.MemberAlreadyExists;
import lengaburu.family.model.exceptions.MemberNotFound;
import lengaburu.family.model.procedures.AddChild;
import lengaburu.family.model.procedures.AddSpouse;
import lengaburu.family.rules.retrieve.BySequenceNumber;

public class Family {
	private final String name;
	private final Map<String, Member> namesToMembersMapping;

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

	public void addSpouse(String memberName, String spouseName) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		newMemberNameUniquenessCheck(spouseName);
		Member member = namesToMembersMapping.get(memberName);
		Member spouse = new Member(nextSequenceNumber(), spouseName, member.getGender().opposite());
		member.add(new AddSpouse(), spouse);
		namesToMembersMapping.put(spouseName, spouse);
	}

	public void addChild(String memberName, String childName, Gender childGender) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		newMemberNameUniquenessCheck(childName);
		Member child = new Member(nextSequenceNumber(), childName, childGender);
		Member member = namesToMembersMapping.get(memberName);
		member.add(new AddChild(), child);
		namesToMembersMapping.put(childName, child);
	}

	public List<String> get(String memberName, Relationship relationship) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		final Member member = namesToMembersMapping.get(memberName);
		final Set<Member> relatives = member.get(relationship);
		return relatives.stream().sorted(new BySequenceNumber()).map(Member::getName).collect(Collectors.toList());
	}

	public Member get(String memberName) {
		return namesToMembersMapping.get(memberName);
	}

	private int nextSequenceNumber() {
		return namesToMembersMapping.size() + 1;
	}

	private void newMemberNameUniquenessCheck(String memberName) {
		if (namesToMembersMapping.containsKey(memberName)) {
			throw new MemberAlreadyExists();
		}
	}

	public Map<String, Member> getAll() {
		return namesToMembersMapping;
	}
}
