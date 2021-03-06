package lengaburu.family.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
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

	public void addChild(String memberName, String childName, Gender childGender) {
		memberNotFoundCheck(memberName);
		nameUniquenessCheck(childName);
		Member child = new Member(childName, childGender);
		Member member = namesToMembersMapping.get(memberName);
		ModelProcedures.ADD_CHILD.run(member, child);
		namesToMembersMapping.put(childName, child);
	}

	public List<String> get(String memberName, Relationships relationship) {
		memberNotFoundCheck(memberName);
		final Member member = namesToMembersMapping.get(memberName);
		final List<Member> relatives = relationship.resolve(member);
		return relatives.stream().map(Member::getName).collect(Collectors.toList());
	}

	public List<Member> getMembersByFilter(Predicate<Member> predicate) {
		return namesToMembersMapping.values().stream().filter(predicate).collect(Collectors.toList());
	}

	public void addSpouse(String memberName, String spouseName) {
		memberNotFoundCheck(memberName);
		nameUniquenessCheck(spouseName);
		Member member = namesToMembersMapping.get(memberName);
		Member spouse = new Member(spouseName, member.getGender().opposite());
		ModelProcedures.ADD_SPOUSE.run(member, spouse);
		namesToMembersMapping.put(spouseName, spouse);
	}

	private void memberNotFoundCheck(String memberName) {
		if (namesToMembersMapping.containsKey(memberName) == false) {
			throw new MemberNotFound();
		}
	}

	private void nameUniquenessCheck(String memberName) {
		if (namesToMembersMapping.containsKey(memberName)) {
			throw new MemberAlreadyExists();
		}
	}
}
