package lengaburu.family.model;

public enum Gender {
	MALE, FEMALE;

	public Gender opposite() {
		if (this.equals(MALE)) {
			return FEMALE;
		}
		return MALE;
	}
}
