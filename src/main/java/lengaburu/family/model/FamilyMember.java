package lengaburu.family.model;

import java.util.HashSet;
import java.util.Set;

public class FamilyMember {
	private final Integer sequenceNumber;
	private final String name;
	private final Gender gender;
	private FamilyMember mother;
	private FamilyMember father;
	private FamilyMember spouse;
	private Set<FamilyMember> children = new HashSet<>();

	public FamilyMember(Integer sequenceNumber, String name, Gender gender) {
		this.sequenceNumber = sequenceNumber;
		this.name = name;
		this.gender = gender;
	}

	public Integer getSequenceNumber() {
		return sequenceNumber;
	}

	public FamilyMember getMother() {
		return mother;
	}

	public void setMother(FamilyMember mother) {
		this.mother = mother;
	}

	public FamilyMember getFather() {
		return father;
	}

	public void setFather(FamilyMember father) {
		this.father = father;
	}

	public FamilyMember getSpouse() {
		return spouse;
	}

	public void setSpouse(FamilyMember spouse) {
		this.spouse = spouse;
	}

	public String getName() {
		return name;
	}

	public Gender getGender() {
		return gender;
	}

	public Set<FamilyMember> getChildren() {
		return children;
	}

	public void addChild(FamilyMember child) {
		children.add(child);
	}

	public Set<FamilyMember> get(Relationship relationship) {
		Set<FamilyMember> apply = relationship.apply(this);
		return apply;
	}

}
