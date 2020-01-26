package lengaburu.family.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lengaburu.family.model.exceptions.MemberAlreadyExists;
import lengaburu.family.model.exceptions.MemberNotFound;
import lengaburu.family.model.procedures.ModelProcedures;
import lengaburu.family.model.relationships.Relationships;

public class Family {
	private final String name;
	private final Map<String, Member> namesToMembersMapping;

	public Family(String name, String kingName, String queenName) {
		this.name = name;
		this.namesToMembersMapping = new LinkedHashMap<>();
		final Member king = new Member(kingName, Gender.MALE);
		final Member queen = new Member(queenName, Gender.FEMALE);
		ModelProcedures.ADD_SPOUSE.run(king, queen);
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
		Member spouse = new Member(spouseName, member.getGender().opposite());
		ModelProcedures.ADD_SPOUSE.run(member, spouse);
		namesToMembersMapping.put(spouseName, spouse);
	}

	public void addChild(String memberName, String childName, Gender childGender) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		newMemberNameUniquenessCheck(childName);
		Member child = new Member(childName, childGender);
		Member member = namesToMembersMapping.get(memberName);
		ModelProcedures.ADD_CHILD.run(member, child);
		namesToMembersMapping.put(childName, child);
	}

	public List<String> get(String memberName, Relationships relationship) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
		final Member member = namesToMembersMapping.get(memberName);
		final List<Member> relatives = relationship.resolve(member);
		return relatives.stream().map(Member::getName).collect(Collectors.toList());
	}

	public Member get(String memberName) {
		return namesToMembersMapping.get(memberName);
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
