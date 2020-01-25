package lengaburu.family.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import lengaburu.family.InitialSetup;
import lengaburu.family.relationship.BrotherInLaws;
import lengaburu.family.relationship.Brothers;
import lengaburu.family.relationship.Children;
import lengaburu.family.relationship.Daughters;
import lengaburu.family.relationship.MaternalAunts;
import lengaburu.family.relationship.MaternalUncles;
import lengaburu.family.relationship.PaternalAunts;
import lengaburu.family.relationship.PaternalUncles;
import lengaburu.family.relationship.Siblings;
import lengaburu.family.relationship.SisterInLaws;
import lengaburu.family.relationship.Sisters;
import lengaburu.family.relationship.Sons;

public class FamilyTest {
	private Family family = null;

	@Before
	public void setup() {
		this.family = InitialSetup.setup();
	}

	@Test
	public void testForKingShan() {
		final String name = "King Shan";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(1);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Queen Anga");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Chit", "Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, new Daughters())).containsExactly("Satya");
		assertThat(family.get(name, new Sons())).containsExactly("Chit", "Ish", "Vich", "Aras");
	}

	@Test
	public void testForQueenAnga() {
		final String name = "Queen Anga";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(2);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("King Shan");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Chit", "Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, new Daughters())).containsExactly("Satya");
		assertThat(family.get(name, new Sons())).containsExactly("Chit", "Ish", "Vich", "Aras");
	}

	@Test
	public void testForChit() {
		final String name = "Chit";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(3);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Amba");
		assertThat(family.get(name, new Siblings())).containsExactly("Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Lika", "Chitra");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Vyan");
		assertThat(family.get(name, new Sisters())).containsExactly("Satya");
		assertThat(family.get(name, new Brothers())).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Dritha", "Tritha", "Vritha");
		assertThat(family.get(name, new Daughters())).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, new Sons())).containsExactly("Vritha");
	}

	@Test
	public void testForIsh() {
		final String name = "Ish";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(4);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Chit", "Vich", "Aras", "Satya");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Amba", "Lika", "Chitra");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Vyan");
		assertThat(family.get(name, new Sisters())).containsExactly("Satya");
		assertThat(family.get(name, new Brothers())).containsExactly("Chit", "Vich", "Aras");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForVich() {
		final String name = "Vich";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(5);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Lika");
		assertThat(family.get(name, new Siblings())).containsExactly("Chit", "Ish", "Aras", "Satya");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Amba", "Chitra");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Vyan");
		assertThat(family.get(name, new Sisters())).containsExactly("Satya");
		assertThat(family.get(name, new Brothers())).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Vila", "Chika");
		assertThat(family.get(name, new Daughters())).containsExactly("Vila", "Chika");
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForAras() {
		final String name = "Aras";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(6);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Chitra");
		assertThat(family.get(name, new Siblings())).containsExactly("Chit", "Ish", "Vich", "Satya");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Amba", "Lika");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Vyan");
		assertThat(family.get(name, new Sisters())).containsExactly("Satya");
		assertThat(family.get(name, new Brothers())).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Jnki", "Ahit");
		assertThat(family.get(name, new Daughters())).containsExactly("Jnki");
		assertThat(family.get(name, new Sons())).containsExactly("Ahit");
	}

	@Test
	public void testForSatya() {
		final String name = "Satya";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(7);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Vyan");
		assertThat(family.get(name, new Siblings())).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Amba", "Lika", "Chitra");
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Asva", "Vyas", "Atya");
		assertThat(family.get(name, new Daughters())).containsExactly("Atya");
		assertThat(family.get(name, new Sons())).containsExactly("Asva", "Vyas");
	}

	@Test
	public void testForAmba() {
		final String name = "Amba";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(8);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Chit");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Satya");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Dritha", "Tritha", "Vritha");
		assertThat(family.get(name, new Daughters())).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, new Sons())).containsExactly("Vritha");
	}

	@Test
	public void testForLika() {
		final String name = "Lika";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(9);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Vich");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Satya");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Vila", "Chika");
		assertThat(family.get(name, new Daughters())).containsExactly("Vila", "Chika");
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForChitra() {
		final String name = "Chitra";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(10);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Aras");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Satya");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Jnki", "Ahit");
		assertThat(family.get(name, new Daughters())).containsExactly("Jnki");
		assertThat(family.get(name, new Sons())).containsExactly("Ahit");
	}

	@Test
	public void testForVyan() {
		final String name = "Vyan";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(11);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Satya");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Asva", "Vyas", "Atya");
		assertThat(family.get(name, new Daughters())).containsExactly("Atya");
		assertThat(family.get(name, new Sons())).containsExactly("Asva", "Vyas");
	}

	@Test
	public void testForDritha() {
		final String name = "Dritha";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(12);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Amba");
		assertThat(m.getFather().getName()).isEqualTo("Chit");
		assertThat(m.getSpouse().getName()).isEqualTo("Jaya");
		assertThat(family.get(name, new Siblings())).containsExactly("Tritha", "Vritha");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Tritha");
		assertThat(family.get(name, new Brothers())).containsExactly("Vritha");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, new Children())).containsExactly("Yodhan");
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).containsExactly("Yodhan");
	}

	@Test
	public void testForTritha() {
		final String name = "Tritha";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(13);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Amba");
		assertThat(m.getFather().getName()).isEqualTo("Chit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Dritha", "Vritha");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Jaya");
		assertThat(family.get(name, new Sisters())).containsExactly("Dritha");
		assertThat(family.get(name, new Brothers())).containsExactly("Vritha");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForVritha() {
		final String name = "Vritha";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(14);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Amba");
		assertThat(m.getFather().getName()).isEqualTo("Chit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Jaya");
		assertThat(family.get(name, new Sisters())).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForVila() {
		final String name = "Vila";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(15);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Lika");
		assertThat(m.getFather().getName()).isEqualTo("Vich");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Chika");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Chika");
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForChika() {
		final String name = "Chika";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(16);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Lika");
		assertThat(m.getFather().getName()).isEqualTo("Vich");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Vila");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Vila");
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForJnki() {
		final String name = "Jnki";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(17);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Chitra");
		assertThat(m.getFather().getName()).isEqualTo("Aras");
		assertThat(m.getSpouse().getName()).isEqualTo("Arit");
		assertThat(family.get(name, new Siblings())).containsExactly("Ahit");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).containsExactly("Ahit");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, new Children())).containsExactly("Laki", "Lavnya");
		assertThat(family.get(name, new Daughters())).containsExactly("Lavnya");
		assertThat(family.get(name, new Sons())).containsExactly("Laki");
	}

	@Test
	public void testForAhit() {
		final String name = "Ahit";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(18);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Chitra");
		assertThat(m.getFather().getName()).isEqualTo("Aras");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Jnki");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Arit");
		assertThat(family.get(name, new Sisters())).containsExactly("Jnki");
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Satya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForAsva() {
		final String name = "Asva";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(19);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Satya");
		assertThat(m.getFather().getName()).isEqualTo("Vyan");
		assertThat(m.getSpouse().getName()).isEqualTo("Satvy");
		assertThat(family.get(name, new Siblings())).containsExactly("Vyas", "Atya");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Krpi");
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Atya");
		assertThat(family.get(name, new Brothers())).containsExactly("Vyas");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Vasa");
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).containsExactly("Vasa");
	}

	@Test
	public void testForVyas() {
		final String name = "Vyas";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(20);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Satya");
		assertThat(m.getFather().getName()).isEqualTo("Vyan");
		assertThat(m.getSpouse().getName()).isEqualTo("Krpi");
		assertThat(family.get(name, new Siblings())).containsExactly("Asva", "Atya");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Satvy");
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Atya");
		assertThat(family.get(name, new Brothers())).containsExactly("Asva");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Kriya", "Krithi");
		assertThat(family.get(name, new Daughters())).containsExactly("Krithi");
		assertThat(family.get(name, new Sons())).containsExactly("Kriya");
	}

	@Test
	public void testForAtya() {
		final String name = "Atya";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(21);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Satya");
		assertThat(m.getFather().getName()).isEqualTo("Vyan");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Asva", "Vyas");
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Satvy", "Krpi");
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).containsExactly("Asva", "Vyas");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForJaya() {
		final String name = "Jaya";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(22);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Dritha");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Tritha");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Vritha");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Yodhan");
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).containsExactly("Yodhan");
	}

	@Test
	public void testForArit() {
		final String name = "Arit";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(23);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Jnki");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Ahit");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Laki", "Lavnya");
		assertThat(family.get(name, new Daughters())).containsExactly("Lavnya");
		assertThat(family.get(name, new Sons())).containsExactly("Laki");
	}

	@Test
	public void testForSatvy() {
		final String name = "Satvy";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(24);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Asva");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Atya");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Vyas");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Vasa");
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).containsExactly("Vasa");
	}

	@Test
	public void testForKrpi() {
		final String name = "Krpi";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(25);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Vyas");
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).containsExactly("Atya");
		assertThat(family.get(name, new BrotherInLaws())).containsExactly("Asva");
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).containsExactly("Kriya", "Krithi");
		assertThat(family.get(name, new Daughters())).containsExactly("Krithi");
		assertThat(family.get(name, new Sons())).containsExactly("Kriya");
	}

	@Test
	public void testForYodhan() {
		final String name = "Yodhan";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(26);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Dritha");
		assertThat(m.getFather().getName()).isEqualTo("Jaya");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).containsExactly("Tritha");
		assertThat(family.get(name, new MaternalUncles())).containsExactly("Vritha");
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForLaki() {
		final String name = "Laki";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(27);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Jnki");
		assertThat(m.getFather().getName()).isEqualTo("Arit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Lavnya");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Lavnya");
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).containsExactly("Ahit");
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForLavnya() {
		final String name = "Lavnya";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(28);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Jnki");
		assertThat(m.getFather().getName()).isEqualTo("Arit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Laki");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).containsExactly("Laki");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).containsExactly("Ahit");
		assertThat(family.get(name, new PaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForVasa() {
		final String name = "Vasa";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(29);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Satvy");
		assertThat(m.getFather().getName()).isEqualTo("Asva");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).isNullOrEmpty();
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Atya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Vyas");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForKriya() {
		final String name = "Kriya";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(30);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Krpi");
		assertThat(m.getFather().getName()).isEqualTo("Vyas");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Krithi");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).containsExactly("Krithi");
		assertThat(family.get(name, new Brothers())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Atya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Asva");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}

	@Test
	public void testForKrithi() {
		final String name = "Krithi";
		final FamilyMember m = family.get(name);
		assertThat(m.getSequenceNumber()).isEqualTo(31);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Krpi");
		assertThat(m.getFather().getName()).isEqualTo("Vyas");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, new Siblings())).containsExactly("Kriya");
		assertThat(family.get(name, new SisterInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new BrotherInLaws())).isNullOrEmpty();
		assertThat(family.get(name, new Sisters())).isNullOrEmpty();
		assertThat(family.get(name, new Brothers())).containsExactly("Kriya");
		assertThat(family.get(name, new MaternalAunts())).isNullOrEmpty();
		assertThat(family.get(name, new MaternalUncles())).isNullOrEmpty();
		assertThat(family.get(name, new PaternalAunts())).containsExactly("Atya");
		assertThat(family.get(name, new PaternalUncles())).containsExactly("Asva");
		assertThat(family.get(name, new Children())).isNullOrEmpty();
		assertThat(family.get(name, new Daughters())).isNullOrEmpty();
		assertThat(family.get(name, new Sons())).isNullOrEmpty();
	}
}
