package lengaburu.family.model;

public class Member {
	private final String name;
	private final Gender gender;
	private Member mother;
	private Member father;
	private Member spouse;

	public Member(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
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

}
