package lengaburu.family.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import lengaburu.family.InitialSetup;
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

public class FamilyTest {
	private Family family = null;
	private Siblings siblings = new Siblings();
	private SisterInLaws sisterInLaws = new SisterInLaws();
	private BrotherInLaws brotherInLaws = new BrotherInLaws();
	private Sisters sisters = new Sisters();
	private Brothers brothers = new Brothers();
	private MaternalAunts maternalAunts = new MaternalAunts();
	private MaternalUncles maternalUncles = new MaternalUncles();
	private PaternalAunts paternalAunts = new PaternalAunts();
	private PaternalUncles paternalUncles = new PaternalUncles();
	private Children children = new Children();
	private Daughters daughters = new Daughters();
	private Sons sons = new Sons();

	@Before
	public void setup() {
		this.family = InitialSetup.setup();
	}

	@Test
	public void testForKingShan() {
		final String name = "King Shan";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Queen Anga");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Chit", "Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, daughters)).containsExactly("Satya");
		assertThat(family.get(name, sons)).containsExactly("Chit", "Ish", "Vich", "Aras");
	}

	@Test
	public void testForQueenAnga() {
		final String name = "Queen Anga";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("King Shan");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Chit", "Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, daughters)).containsExactly("Satya");
		assertThat(family.get(name, sons)).containsExactly("Chit", "Ish", "Vich", "Aras");
	}

	@Test
	public void testForChit() {
		final String name = "Chit";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Amba");
		assertThat(family.get(name, siblings)).containsExactly("Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Lika", "Chitra");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Vyan");
		assertThat(family.get(name, sisters)).containsExactly("Satya");
		assertThat(family.get(name, brothers)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Dritha", "Tritha", "Vritha");
		assertThat(family.get(name, daughters)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, sons)).containsExactly("Vritha");
	}

	@Test
	public void testForIsh() {
		final String name = "Ish";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Chit", "Vich", "Aras", "Satya");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Amba", "Lika", "Chitra");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Vyan");
		assertThat(family.get(name, sisters)).containsExactly("Satya");
		assertThat(family.get(name, brothers)).containsExactly("Chit", "Vich", "Aras");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForVich() {
		final String name = "Vich";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Lika");
		assertThat(family.get(name, siblings)).containsExactly("Chit", "Ish", "Aras", "Satya");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Amba", "Chitra");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Vyan");
		assertThat(family.get(name, sisters)).containsExactly("Satya");
		assertThat(family.get(name, brothers)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, daughters)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForAras() {
		final String name = "Aras";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Chitra");
		assertThat(family.get(name, siblings)).containsExactly("Chit", "Ish", "Vich", "Satya");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Amba", "Lika");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Vyan");
		assertThat(family.get(name, sisters)).containsExactly("Satya");
		assertThat(family.get(name, brothers)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Jnki", "Ahit");
		assertThat(family.get(name, daughters)).containsExactly("Jnki");
		assertThat(family.get(name, sons)).containsExactly("Ahit");
	}

	@Test
	public void testForSatya() {
		final String name = "Satya";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Queen Anga");
		assertThat(m.getFather().getName()).isEqualTo("King Shan");
		assertThat(m.getSpouse().getName()).isEqualTo("Vyan");
		assertThat(family.get(name, siblings)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Amba", "Lika", "Chitra");
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Asva", "Vyas", "Atya");
		assertThat(family.get(name, daughters)).containsExactly("Atya");
		assertThat(family.get(name, sons)).containsExactly("Asva", "Vyas");
	}

	@Test
	public void testForAmba() {
		final String name = "Amba";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Chit");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).containsExactly("Satya");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Dritha", "Tritha", "Vritha");
		assertThat(family.get(name, daughters)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, sons)).containsExactly("Vritha");
	}

	@Test
	public void testForLika() {
		final String name = "Lika";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Vich");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).containsExactly("Satya");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, daughters)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForChitra() {
		final String name = "Chitra";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Aras");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).containsExactly("Satya");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Jnki", "Ahit");
		assertThat(family.get(name, daughters)).containsExactly("Jnki");
		assertThat(family.get(name, sons)).containsExactly("Ahit");
	}

	@Test
	public void testForVyan() {
		final String name = "Vyan";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Satya");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Asva", "Vyas", "Atya");
		assertThat(family.get(name, daughters)).containsExactly("Atya");
		assertThat(family.get(name, sons)).containsExactly("Asva", "Vyas");
	}

	@Test
	public void testForDritha() {
		final String name = "Dritha";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Amba");
		assertThat(m.getFather().getName()).isEqualTo("Chit");
		assertThat(m.getSpouse().getName()).isEqualTo("Jaya");
		assertThat(family.get(name, siblings)).containsExactly("Tritha", "Vritha");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Tritha");
		assertThat(family.get(name, brothers)).containsExactly("Vritha");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, children)).containsExactly("Yodhan");
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).containsExactly("Yodhan");
	}

	@Test
	public void testForTritha() {
		final String name = "Tritha";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Amba");
		assertThat(m.getFather().getName()).isEqualTo("Chit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Dritha", "Vritha");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).containsExactly("Jaya");
		assertThat(family.get(name, sisters)).containsExactly("Dritha");
		assertThat(family.get(name, brothers)).containsExactly("Vritha");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForVritha() {
		final String name = "Vritha";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Amba");
		assertThat(m.getFather().getName()).isEqualTo("Chit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).containsExactly("Jaya");
		assertThat(family.get(name, sisters)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForVila() {
		final String name = "Vila";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Lika");
		assertThat(m.getFather().getName()).isEqualTo("Vich");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Chika");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Chika");
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForChika() {
		final String name = "Chika";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Lika");
		assertThat(m.getFather().getName()).isEqualTo("Vich");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Vila");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Vila");
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForJnki() {
		final String name = "Jnki";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Chitra");
		assertThat(m.getFather().getName()).isEqualTo("Aras");
		assertThat(m.getSpouse().getName()).isEqualTo("Arit");
		assertThat(family.get(name, siblings)).containsExactly("Ahit");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).containsExactly("Ahit");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, children)).containsExactly("Laki", "Lavnya");
		assertThat(family.get(name, daughters)).containsExactly("Lavnya");
		assertThat(family.get(name, sons)).containsExactly("Laki");
	}

	@Test
	public void testForAhit() {
		final String name = "Ahit";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Chitra");
		assertThat(m.getFather().getName()).isEqualTo("Aras");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Jnki");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).containsExactly("Arit");
		assertThat(family.get(name, sisters)).containsExactly("Jnki");
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Satya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForAsva() {
		final String name = "Asva";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Satya");
		assertThat(m.getFather().getName()).isEqualTo("Vyan");
		assertThat(m.getSpouse().getName()).isEqualTo("Satvy");
		assertThat(family.get(name, siblings)).containsExactly("Vyas", "Atya");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Krpi");
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Atya");
		assertThat(family.get(name, brothers)).containsExactly("Vyas");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Vasa");
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).containsExactly("Vasa");
	}

	@Test
	public void testForVyas() {
		final String name = "Vyas";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Satya");
		assertThat(m.getFather().getName()).isEqualTo("Vyan");
		assertThat(m.getSpouse().getName()).isEqualTo("Krpi");
		assertThat(family.get(name, siblings)).containsExactly("Asva", "Atya");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Satvy");
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Atya");
		assertThat(family.get(name, brothers)).containsExactly("Asva");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Kriya", "Krithi");
		assertThat(family.get(name, daughters)).containsExactly("Krithi");
		assertThat(family.get(name, sons)).containsExactly("Kriya");
	}

	@Test
	public void testForAtya() {
		final String name = "Atya";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Satya");
		assertThat(m.getFather().getName()).isEqualTo("Vyan");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Asva", "Vyas");
		assertThat(family.get(name, sisterInLaws)).containsExactly("Satvy", "Krpi");
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).containsExactly("Asva", "Vyas");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForJaya() {
		final String name = "Jaya";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Dritha");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).containsExactly("Tritha");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Vritha");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Yodhan");
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).containsExactly("Yodhan");
	}

	@Test
	public void testForArit() {
		final String name = "Arit";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Jnki");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).containsExactly("Ahit");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Laki", "Lavnya");
		assertThat(family.get(name, daughters)).containsExactly("Lavnya");
		assertThat(family.get(name, sons)).containsExactly("Laki");
	}

	@Test
	public void testForSatvy() {
		final String name = "Satvy";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Asva");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).containsExactly("Atya");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Vyas");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Vasa");
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).containsExactly("Vasa");
	}

	@Test
	public void testForKrpi() {
		final String name = "Krpi";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother()).isNull();
		assertThat(m.getFather()).isNull();
		assertThat(m.getSpouse().getName()).isEqualTo("Vyas");
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).containsExactly("Atya");
		assertThat(family.get(name, brotherInLaws)).containsExactly("Asva");
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).containsExactly("Kriya", "Krithi");
		assertThat(family.get(name, daughters)).containsExactly("Krithi");
		assertThat(family.get(name, sons)).containsExactly("Kriya");
	}

	@Test
	public void testForYodhan() {
		final String name = "Yodhan";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Dritha");
		assertThat(m.getFather().getName()).isEqualTo("Jaya");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).containsExactly("Tritha");
		assertThat(family.get(name, maternalUncles)).containsExactly("Vritha");
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForLaki() {
		final String name = "Laki";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Jnki");
		assertThat(m.getFather().getName()).isEqualTo("Arit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Lavnya");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Lavnya");
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).containsExactly("Ahit");
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForLavnya() {
		final String name = "Lavnya";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Jnki");
		assertThat(m.getFather().getName()).isEqualTo("Arit");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Laki");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).containsExactly("Laki");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).containsExactly("Ahit");
		assertThat(family.get(name, paternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, paternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForVasa() {
		final String name = "Vasa";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Satvy");
		assertThat(m.getFather().getName()).isEqualTo("Asva");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).isNullOrEmpty();
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Atya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Vyas");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForKriya() {
		final String name = "Kriya";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.MALE);
		assertThat(m.getMother().getName()).isEqualTo("Krpi");
		assertThat(m.getFather().getName()).isEqualTo("Vyas");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Krithi");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).containsExactly("Krithi");
		assertThat(family.get(name, brothers)).isNullOrEmpty();
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Atya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Asva");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}

	@Test
	public void testForKrithi() {
		final String name = "Krithi";
		final Member m = family.get(name);
		assertThat(m.getName()).isEqualTo(name);
		assertThat(m.getGender()).isEqualTo(Gender.FEMALE);
		assertThat(m.getMother().getName()).isEqualTo("Krpi");
		assertThat(m.getFather().getName()).isEqualTo("Vyas");
		assertThat(m.getSpouse()).isNull();
		assertThat(family.get(name, siblings)).containsExactly("Kriya");
		assertThat(family.get(name, sisterInLaws)).isNullOrEmpty();
		assertThat(family.get(name, brotherInLaws)).isNullOrEmpty();
		assertThat(family.get(name, sisters)).isNullOrEmpty();
		assertThat(family.get(name, brothers)).containsExactly("Kriya");
		assertThat(family.get(name, maternalAunts)).isNullOrEmpty();
		assertThat(family.get(name, maternalUncles)).isNullOrEmpty();
		assertThat(family.get(name, paternalAunts)).containsExactly("Atya");
		assertThat(family.get(name, paternalUncles)).containsExactly("Asva");
		assertThat(family.get(name, children)).isNullOrEmpty();
		assertThat(family.get(name, daughters)).isNullOrEmpty();
		assertThat(family.get(name, sons)).isNullOrEmpty();
	}
}
