package lengaburu.family;

import lengaburu.family.model.Relationship;
import lengaburu.family.model.relationships.BrotherInLaws;
import lengaburu.family.model.relationships.Brothers;
import lengaburu.family.model.relationships.Children;
import lengaburu.family.model.relationships.Daughters;
import lengaburu.family.model.relationships.MaternalAunts;
import lengaburu.family.model.relationships.MaternalUncles;
import lengaburu.family.model.relationships.PaternalAunts;
import lengaburu.family.model.relationships.PaternalUncles;
import lengaburu.family.model.relationships.Siblings;
import lengaburu.family.model.relationships.SisterInLaws;
import lengaburu.family.model.relationships.Sisters;
import lengaburu.family.model.relationships.Sons;

public enum Relationships {
	BROTHER_IN_LAW("brother-in-law", new BrotherInLaws()), BROTHER("brother", new Brothers()),
	CHILDREN("children", new Children()), DAUGHTER("daughter", new Daughters()),
	MATERNAL_AUNT("maternal-aunt", new MaternalAunts()), MATERNAL_UNCLE("maternal-uncle", new MaternalUncles()),
	PATERNAL_AUNT("paternal-aunt", new PaternalAunts()), PATERNAL_UNCLE("paternal-uncle", new PaternalUncles()),
	SISTER_IN_LAW("sister-in-law", new SisterInLaws()), SIBLING("sibling", new Siblings()),
	SISTER("sister", new Sisters()), SON("son", new Sons());

	private final String name;
	private final Relationship relationship;

	Relationships(String name, Relationship relationship) {
		this.name = name;
		this.relationship = relationship;
	}

	public String getName() {
		return name;
	}

	public Relationship getRelationship() {
		return relationship;
	}

}
