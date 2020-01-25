package lengaburu.family.model;

public final class Queen extends FamilyMember {

	public Queen(final String name, final King king) {
		super(2, name, Gender.FEMALE);
		this.setSpouse(king);
		king.setSpouse(this);
	}

}
