package lengaburu.family.model;

public final class Queen extends Member {

	public Queen(final Family family, final String name, final King king) {
		super(family, 2, name, Gender.FEMALE);
		this.setSpouse(king);
		king.setSpouse(this);
	}

}
