package lengaburu.family.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyMember {
	private final Integer sequenceNumber;
	private final String name;
	private final Gender gender;
	private FamilyMember mother;
	private FamilyMember father;
	private FamilyMember spouse;
	private Set<FamilyMember> siblings = new HashSet<>();
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

	public Set<FamilyMember> getSiblings() {
		return siblings;
	}

	public void addSibling(FamilyMember sibling) {
		siblings.add(sibling);
	}

	public void addSiblings(Set<FamilyMember> siblings) {
		this.siblings.addAll(siblings);
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

	public Set<FamilyMember> getRelatives(Relationship relationship) {
		return relationship.apply(this);
	}

	@Override
	public String toString() {
		return "FamilyMember [sequenceNumber=" + sequenceNumber + "\n, name=" + name + "\n, gender=" + gender
				+ "\n, mother=" + (mother != null ? mother.name : null) + "\n, father="
				+ (father != null ? father.name : null) + "\n, spouse=" + (spouse != null ? spouse.name : null)
				+ "\n, siblings="
				+ siblings.stream().sorted(Comparator.comparingInt(FamilyMember::getSequenceNumber))
						.map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, children=" + children.stream().sorted(Comparator.comparingInt(FamilyMember::getSequenceNumber))
						.map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "]\n";
	}

}
