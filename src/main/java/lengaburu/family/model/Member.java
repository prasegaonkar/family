package lengaburu.family.model;

import java.util.HashSet;
import java.util.Set;

public class Member {
	private final Integer sequenceNumber;
	private final String name;
	private final Gender gender;
	private Member mother;
	private Member father;
	private Member spouse;
	private Set<Member> children = new HashSet<>();

	public Member(Integer sequenceNumber, String name, Gender gender) {
		this.sequenceNumber = sequenceNumber;
		this.name = name;
		this.gender = gender;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public Member getMother() {
		return mother;
	}

	public void setMother(Member mother) {
		this.mother = mother;
	}

	public Member getFather() {
		return father;
	}

	public void setFather(Member father) {
		this.father = father;
	}

	public Member getSpouse() {
		return spouse;
	}

	public void setSpouse(Member spouse) {
		this.spouse = spouse;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Set<Member> getChildren() {
		return children;
	}

	public void addChild(Member child) {
		children.add(child);
	}

	public Set<Member> get(Relationship relationship) {
		Set<Member> apply = relationship.apply(this);
		return apply;
	}

	public void add(AddMember procedure, Member newMember) {
		procedure.accept(this, newMember);
	}

}
