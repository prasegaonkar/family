package lengaburu.family.model;

public enum Gender {
	MALE, FEMALE;

	public Gender opposite() {
		if (this.equals(MALE)) {
			return FEMALE;
		}
		return MALE;
	}

	public static Gender determineGender(String gender) {
		try {
			return Gender.valueOf(gender.toUpperCase());
		} catch (Exception ex) {
			throw new RuntimeException("Invalid gender token observed: " + gender);
		}
	}
}
