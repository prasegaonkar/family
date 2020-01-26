package lengaburu.family.model;

import static lengaburu.family.model.relationships.Relationships.BROTHER;
import static lengaburu.family.model.relationships.Relationships.BROTHER_IN_LAW;
import static lengaburu.family.model.relationships.Relationships.CHILDREN;
import static lengaburu.family.model.relationships.Relationships.DAUGHTER;
import static lengaburu.family.model.relationships.Relationships.FATHER;
import static lengaburu.family.model.relationships.Relationships.MATERNAL_AUNT;
import static lengaburu.family.model.relationships.Relationships.MATERNAL_UNCLE;
import static lengaburu.family.model.relationships.Relationships.MOTHER;
import static lengaburu.family.model.relationships.Relationships.PATERNAL_AUNT;
import static lengaburu.family.model.relationships.Relationships.PATERNAL_UNCLE;
import static lengaburu.family.model.relationships.Relationships.SELF;
import static lengaburu.family.model.relationships.Relationships.SIBLING;
import static lengaburu.family.model.relationships.Relationships.SISTER;
import static lengaburu.family.model.relationships.Relationships.SISTER_IN_LAW;
import static lengaburu.family.model.relationships.Relationships.SON;
import static lengaburu.family.model.relationships.Relationships.SPOUSE;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import lengaburu.family.TestContext;
import lengaburu.family.model.relationships.Relationships;

public class FamilyTest {
	private Family family = null;
	private Relationships self = SELF;
	private Relationships mother = MOTHER;
	private Relationships father = FATHER;
	private Relationships spouse = SPOUSE;
	private Relationships siblings = SIBLING;
	private Relationships sisterInLaws = SISTER_IN_LAW;
	private Relationships brotherInLaws = BROTHER_IN_LAW;
	private Relationships sisters = SISTER;
	private Relationships brothers = BROTHER;
	private Relationships maternalAunts = MATERNAL_AUNT;
	private Relationships maternalUncles = MATERNAL_UNCLE;
	private Relationships paternalAunts = PATERNAL_AUNT;
	private Relationships paternalUncles = PATERNAL_UNCLE;
	private Relationships children = CHILDREN;
	private Relationships daughters = DAUGHTER;
	private Relationships sons = SON;

	@BeforeClass
	public static void setupClass() {
		TestContext.setup();
	}

	@Before
	public void setup() {
		this.family = TestContext.getFamily();
	}

	@Test
	public void testForKingShan() {
		final String name = "King Shan";
		assertThat(family.get(name, self)).containsExactly(name);
		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Queen Anga");
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
		assertThat(family.get(name, self)).containsExactly(name);
		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("King Shan");
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
		assertThat(family.get(name, mother)).containsExactly("Queen Anga");
		assertThat(family.get(name, father)).containsExactly("King Shan");
		assertThat(family.get(name, spouse)).containsExactly("Amba");
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
		assertThat(family.get(name, mother)).containsExactly("Queen Anga");
		assertThat(family.get(name, father)).containsExactly("King Shan");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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
		assertThat(family.get(name, mother)).containsExactly("Queen Anga");
		assertThat(family.get(name, father)).containsExactly("King Shan");
		assertThat(family.get(name, spouse)).containsExactly("Lika");
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
		assertThat(family.get(name, mother)).containsExactly("Queen Anga");
		assertThat(family.get(name, father)).containsExactly("King Shan");
		assertThat(family.get(name, spouse)).containsExactly("Chitra");
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

		assertThat(family.get(name, mother)).containsExactly("Queen Anga");
		assertThat(family.get(name, father)).containsExactly("King Shan");
		assertThat(family.get(name, spouse)).containsExactly("Vyan");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Chit");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Vich");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Aras");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Satya");
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

		assertThat(family.get(name, mother)).containsExactly("Amba");
		assertThat(family.get(name, father)).containsExactly("Chit");
		assertThat(family.get(name, spouse)).containsExactly("Jaya");
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

		assertThat(family.get(name, mother)).containsExactly("Amba");
		assertThat(family.get(name, father)).containsExactly("Chit");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Amba");
		assertThat(family.get(name, father)).containsExactly("Chit");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Lika");
		assertThat(family.get(name, father)).containsExactly("Vich");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Lika");
		assertThat(family.get(name, father)).containsExactly("Vich");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Chitra");
		assertThat(family.get(name, father)).containsExactly("Aras");
		assertThat(family.get(name, spouse)).containsExactly("Arit");
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

		assertThat(family.get(name, mother)).containsExactly("Chitra");
		assertThat(family.get(name, father)).containsExactly("Aras");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Satya");
		assertThat(family.get(name, father)).containsExactly("Vyan");
		assertThat(family.get(name, spouse)).containsExactly("Satvy");
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

		assertThat(family.get(name, mother)).containsExactly("Satya");
		assertThat(family.get(name, father)).containsExactly("Vyan");
		assertThat(family.get(name, spouse)).containsExactly("Krpi");
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

		assertThat(family.get(name, mother)).containsExactly("Satya");
		assertThat(family.get(name, father)).containsExactly("Vyan");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Dritha");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Jnki");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Asva");
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

		assertThat(family.get(name, mother)).isNullOrEmpty();
		assertThat(family.get(name, father)).isNullOrEmpty();
		assertThat(family.get(name, spouse)).containsExactly("Vyas");
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

		assertThat(family.get(name, mother)).containsExactly("Dritha");
		assertThat(family.get(name, father)).containsExactly("Jaya");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Jnki");
		assertThat(family.get(name, father)).containsExactly("Arit");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Jnki");
		assertThat(family.get(name, father)).containsExactly("Arit");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Satvy");
		assertThat(family.get(name, father)).containsExactly("Asva");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Krpi");
		assertThat(family.get(name, father)).containsExactly("Vyas");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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

		assertThat(family.get(name, mother)).containsExactly("Krpi");
		assertThat(family.get(name, father)).containsExactly("Vyas");
		assertThat(family.get(name, spouse)).isNullOrEmpty();
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
