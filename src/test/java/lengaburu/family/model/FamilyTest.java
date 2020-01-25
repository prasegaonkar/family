package lengaburu.family.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import lengaburu.family.InitialSetup;
import lengaburu.family.relationship.Daughters;
import lengaburu.family.relationship.Sons;

public class FamilyTest {
	private Family family = null;

	@Before
	public void setup() {
		this.family = InitialSetup.setup();
	}

	@Test
	public void testForFirstFamilyMembers() {
		FamilyMember king = family.get("King Shan");
		FamilyMember queen = family.get("Queen Anga");

		assertThat(king.getSequenceNumber()).isEqualTo(1);
		assertThat(king.getMother()).isNull();
		assertThat(king.getFather()).isNull();
		assertThat(king.getSpouse()).isEqualTo(queen);
		assertThat(king.getGender()).isEqualTo(Gender.MALE);
		assertThat(king.getSiblings()).isNullOrEmpty();
		assertThat(king.getChildren()).isNotEmpty();
		assertThat(king.getChildren().size()).isEqualTo(5);
		assertThat(king.getRelatives(new Sons()).size()).isEqualTo(4);
		assertThat(king.getRelatives(new Daughters()).size()).isEqualTo(1);

		assertThat(queen.getSequenceNumber()).isEqualTo(2);
		assertThat(queen.getMother()).isNull();
		assertThat(queen.getFather()).isNull();
		assertThat(queen.getSpouse()).isEqualTo(king);
		assertThat(queen.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(queen.getSiblings()).isNullOrEmpty();
		assertThat(queen.getChildren()).isNotEmpty();
		assertThat(queen.getChildren().size()).isEqualTo(5);
		assertThat(queen.getRelatives(new Sons()).size()).isEqualTo(4);
		assertThat(queen.getRelatives(new Daughters()).size()).isEqualTo(1);
	}
}
