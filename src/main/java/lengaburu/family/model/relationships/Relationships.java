package lengaburu.family.model.relationships;

import java.util.List;

import lengaburu.family.model.Member;

public enum Relationships {

	BROTHER_IN_LAW("brother-in-law", new BrotherInLaws()), BROTHER("brother", new Brothers()),
	CHILDREN("children", new Children()), DAUGHTER("daughter", new Daughters()),
	MATERNAL_AUNT("maternal-aunt", new MaternalAunts()), MATERNAL_UNCLE("maternal-uncle", new MaternalUncles()),
	PATERNAL_AUNT("paternal-aunt", new PaternalAunts()), PATERNAL_UNCLE("paternal-uncle", new PaternalUncles()),
	SISTER_IN_LAW("sister-in-law", new SisterInLaws()), SIBLING("siblings", new Siblings()),
	SISTER("sister", new Sisters()), SON("son", new Sons()), SELF("self", new Self()), MOTHER("mother", new Mother()),
	FATHER("father", new Father()), SPOUSE("spouse", new Spouse());

	private final String label;
	private final Relation relationship;

	Relationships(String label, Relation relationship) {
		this.label = label;
		this.relationship = relationship;
	}

	public Relation getRelationship() {
		return relationship;
	}

	public List<Member> resolve(Member member) {
		return relationship.apply(member);
	}

	public String getLabel() {
		return label;
	}

}
