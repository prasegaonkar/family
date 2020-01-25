package lengaburu.family.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import lengaburu.family.relationship.BrotherInLaws;
import lengaburu.family.relationship.Brothers;
import lengaburu.family.relationship.Daughters;
import lengaburu.family.relationship.MaternalAunts;
import lengaburu.family.relationship.MaternalUncles;
import lengaburu.family.relationship.PaternalAunts;
import lengaburu.family.relationship.PaternalUncles;
import lengaburu.family.relationship.Siblings;
import lengaburu.family.relationship.SisterInLaws;
import lengaburu.family.relationship.Sisters;
import lengaburu.family.relationship.Sons;

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

	public Set<FamilyMember> getRelatives(Relationship relationship) {
		Set<FamilyMember> apply = relationship.apply(this);
		return apply;
	}

	@Override
	public String toString() {
		return "\n\nFamilyMember [sequenceNumber=" + sequenceNumber + "\n, name=" + name + "\n, gender=" + gender
				+ "\n, mother=" + (mother != null ? mother.name : null) + "\n, father="
				+ (father != null ? father.name : null) + "\n, spouse=" + (spouse != null ? spouse.name : null)
				+ "\n, brotherInLaws="
				+ getRelatives(new BrotherInLaws()).stream().map(FamilyMember::getName).collect(Collectors.toList())
				+ "\n, siblings="
				+ getRelatives(new Siblings()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, sisters="
				+ getRelatives(new Sisters()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, brothers="
				+ getRelatives(new Brothers()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, maternalAunts="
				+ getRelatives(new MaternalAunts()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, maternalUncles="
				+ getRelatives(new MaternalUncles()).stream().map(FamilyMember::getName)
						.collect(Collectors.joining(","))
				+ "\n, paternalAunts="
				+ getRelatives(new PaternalAunts()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, paternalUncles="
				+ getRelatives(new PaternalUncles()).stream().map(FamilyMember::getName)
						.collect(Collectors.joining(","))
				+ "\n, sisterInLaws="
				+ getRelatives(new SisterInLaws()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, children=" + children.stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, daughters="
				+ getRelatives(new Daughters()).stream().map(FamilyMember::getName).collect(Collectors.joining(","))
				+ "\n, sons="
				+ getRelatives(new Sons()).stream().map(FamilyMember::getName).collect(Collectors.joining(",")) + "]\n";
	}

}
