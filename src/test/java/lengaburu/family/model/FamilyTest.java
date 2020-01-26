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

public class FamilyTest {
	private Family family = null;

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
		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Queen Anga");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Chit", "Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Satya");
		assertThat(family.get(name, SON)).containsExactly("Chit", "Ish", "Vich", "Aras");
	}

	@Test
	public void testForQueenAnga() {
		final String name = "Queen Anga";
		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("King Shan");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Chit", "Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Satya");
		assertThat(family.get(name, SON)).containsExactly("Chit", "Ish", "Vich", "Aras");
	}

	@Test
	public void testForChit() {
		final String name = "Chit";
		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Queen Anga");
		assertThat(family.get(name, FATHER)).containsExactly("King Shan");
		assertThat(family.get(name, SPOUSE)).containsExactly("Amba");
		assertThat(family.get(name, SIBLING)).containsExactly("Ish", "Vich", "Aras", "Satya");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Lika", "Chitra");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Vyan");
		assertThat(family.get(name, SISTER)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Dritha", "Tritha", "Vritha");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, SON)).containsExactly("Vritha");
	}

	@Test
	public void testForIsh() {
		final String name = "Ish";
		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Queen Anga");
		assertThat(family.get(name, FATHER)).containsExactly("King Shan");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Chit", "Vich", "Aras", "Satya");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Amba", "Lika", "Chitra");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Vyan");
		assertThat(family.get(name, SISTER)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER)).containsExactly("Chit", "Vich", "Aras");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForVich() {
		final String name = "Vich";
		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Queen Anga");
		assertThat(family.get(name, FATHER)).containsExactly("King Shan");
		assertThat(family.get(name, SPOUSE)).containsExactly("Lika");
		assertThat(family.get(name, SIBLING)).containsExactly("Chit", "Ish", "Aras", "Satya");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Amba", "Chitra");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Vyan");
		assertThat(family.get(name, SISTER)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForAras() {
		final String name = "Aras";
		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Queen Anga");
		assertThat(family.get(name, FATHER)).containsExactly("King Shan");
		assertThat(family.get(name, SPOUSE)).containsExactly("Chitra");
		assertThat(family.get(name, SIBLING)).containsExactly("Chit", "Ish", "Vich", "Satya");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Amba", "Lika");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Vyan");
		assertThat(family.get(name, SISTER)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Jnki", "Ahit");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Jnki");
		assertThat(family.get(name, SON)).containsExactly("Ahit");
	}

	@Test
	public void testForSatya() {
		final String name = "Satya";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Queen Anga");
		assertThat(family.get(name, FATHER)).containsExactly("King Shan");
		assertThat(family.get(name, SPOUSE)).containsExactly("Vyan");
		assertThat(family.get(name, SIBLING)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Amba", "Lika", "Chitra");
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Asva", "Vyas", "Atya");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Atya");
		assertThat(family.get(name, SON)).containsExactly("Asva", "Vyas");
	}

	@Test
	public void testForAmba() {
		final String name = "Amba";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Chit");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Dritha", "Tritha", "Vritha");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, SON)).containsExactly("Vritha");
	}

	@Test
	public void testForLika() {
		final String name = "Lika";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Vich");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Vila", "Chika");
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForChitra() {
		final String name = "Chitra";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Aras");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Satya");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Jnki", "Ahit");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Jnki");
		assertThat(family.get(name, SON)).containsExactly("Ahit");
	}

	@Test
	public void testForVyan() {
		final String name = "Vyan";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Satya");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Asva", "Vyas", "Atya");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Atya");
		assertThat(family.get(name, SON)).containsExactly("Asva", "Vyas");
	}

	@Test
	public void testForDritha() {
		final String name = "Dritha";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Amba");
		assertThat(family.get(name, FATHER)).containsExactly("Chit");
		assertThat(family.get(name, SPOUSE)).containsExactly("Jaya");
		assertThat(family.get(name, SIBLING)).containsExactly("Tritha", "Vritha");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Tritha");
		assertThat(family.get(name, BROTHER)).containsExactly("Vritha");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, CHILDREN)).containsExactly("Yodhan");
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).containsExactly("Yodhan");
	}

	@Test
	public void testForTritha() {
		final String name = "Tritha";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Amba");
		assertThat(family.get(name, FATHER)).containsExactly("Chit");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Dritha", "Vritha");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Jaya");
		assertThat(family.get(name, SISTER)).containsExactly("Dritha");
		assertThat(family.get(name, BROTHER)).containsExactly("Vritha");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForVritha() {
		final String name = "Vritha";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Amba");
		assertThat(family.get(name, FATHER)).containsExactly("Chit");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Jaya");
		assertThat(family.get(name, SISTER)).containsExactly("Dritha", "Tritha");
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Ish", "Vich", "Aras");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForVila() {
		final String name = "Vila";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Lika");
		assertThat(family.get(name, FATHER)).containsExactly("Vich");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Chika");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Chika");
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForChika() {
		final String name = "Chika";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Lika");
		assertThat(family.get(name, FATHER)).containsExactly("Vich");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Vila");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Vila");
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Aras");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForJnki() {
		final String name = "Jnki";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Chitra");
		assertThat(family.get(name, FATHER)).containsExactly("Aras");
		assertThat(family.get(name, SPOUSE)).containsExactly("Arit");
		assertThat(family.get(name, SIBLING)).containsExactly("Ahit");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).containsExactly("Ahit");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, CHILDREN)).containsExactly("Laki", "Lavnya");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Lavnya");
		assertThat(family.get(name, SON)).containsExactly("Laki");
	}

	@Test
	public void testForAhit() {
		final String name = "Ahit";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Chitra");
		assertThat(family.get(name, FATHER)).containsExactly("Aras");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Jnki");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Arit");
		assertThat(family.get(name, SISTER)).containsExactly("Jnki");
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Satya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Vich");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForAsva() {
		final String name = "Asva";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Satya");
		assertThat(family.get(name, FATHER)).containsExactly("Vyan");
		assertThat(family.get(name, SPOUSE)).containsExactly("Satvy");
		assertThat(family.get(name, SIBLING)).containsExactly("Vyas", "Atya");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Krpi");
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Atya");
		assertThat(family.get(name, BROTHER)).containsExactly("Vyas");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Vasa");
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).containsExactly("Vasa");
	}

	@Test
	public void testForVyas() {
		final String name = "Vyas";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Satya");
		assertThat(family.get(name, FATHER)).containsExactly("Vyan");
		assertThat(family.get(name, SPOUSE)).containsExactly("Krpi");
		assertThat(family.get(name, SIBLING)).containsExactly("Asva", "Atya");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Satvy");
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Atya");
		assertThat(family.get(name, BROTHER)).containsExactly("Asva");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Kriya", "Krithi");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Krithi");
		assertThat(family.get(name, SON)).containsExactly("Kriya");
	}

	@Test
	public void testForAtya() {
		final String name = "Atya";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Satya");
		assertThat(family.get(name, FATHER)).containsExactly("Vyan");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Asva", "Vyas");
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Satvy", "Krpi");
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).containsExactly("Asva", "Vyas");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).containsExactly("Chit", "Ish", "Vich", "Aras");
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForJaya() {
		final String name = "Jaya";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Dritha");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Tritha");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Vritha");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Yodhan");
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).containsExactly("Yodhan");
	}

	@Test
	public void testForArit() {
		final String name = "Arit";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Jnki");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Ahit");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Laki", "Lavnya");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Lavnya");
		assertThat(family.get(name, SON)).containsExactly("Laki");
	}

	@Test
	public void testForSatvy() {
		final String name = "Satvy";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Asva");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Atya");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Vyas");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Vasa");
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).containsExactly("Vasa");
	}

	@Test
	public void testForKrpi() {
		final String name = "Krpi";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).isNullOrEmpty();
		assertThat(family.get(name, FATHER)).isNullOrEmpty();
		assertThat(family.get(name, SPOUSE)).containsExactly("Vyas");
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).containsExactly("Atya");
		assertThat(family.get(name, BROTHER_IN_LAW)).containsExactly("Asva");
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).containsExactly("Kriya", "Krithi");
		assertThat(family.get(name, DAUGHTER)).containsExactly("Krithi");
		assertThat(family.get(name, SON)).containsExactly("Kriya");
	}

	@Test
	public void testForYodhan() {
		final String name = "Yodhan";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Dritha");
		assertThat(family.get(name, FATHER)).containsExactly("Jaya");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).containsExactly("Tritha");
		assertThat(family.get(name, MATERNAL_UNCLE)).containsExactly("Vritha");
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForLaki() {
		final String name = "Laki";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Jnki");
		assertThat(family.get(name, FATHER)).containsExactly("Arit");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Lavnya");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Lavnya");
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).containsExactly("Ahit");
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForLavnya() {
		final String name = "Lavnya";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Jnki");
		assertThat(family.get(name, FATHER)).containsExactly("Arit");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Laki");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).containsExactly("Laki");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).containsExactly("Ahit");
		assertThat(family.get(name, PATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForVasa() {
		final String name = "Vasa";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Satvy");
		assertThat(family.get(name, FATHER)).containsExactly("Asva");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).isNullOrEmpty();
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Atya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Vyas");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForKriya() {
		final String name = "Kriya";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Krpi");
		assertThat(family.get(name, FATHER)).containsExactly("Vyas");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Krithi");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).containsExactly("Krithi");
		assertThat(family.get(name, BROTHER)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Atya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Asva");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}

	@Test
	public void testForKrithi() {
		final String name = "Krithi";

		assertThat(family.get(name, SELF)).containsExactly(name);
		assertThat(family.get(name, MOTHER)).containsExactly("Krpi");
		assertThat(family.get(name, FATHER)).containsExactly("Vyas");
		assertThat(family.get(name, SPOUSE)).isNullOrEmpty();
		assertThat(family.get(name, SIBLING)).containsExactly("Kriya");
		assertThat(family.get(name, SISTER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER_IN_LAW)).isNullOrEmpty();
		assertThat(family.get(name, SISTER)).isNullOrEmpty();
		assertThat(family.get(name, BROTHER)).containsExactly("Kriya");
		assertThat(family.get(name, MATERNAL_AUNT)).isNullOrEmpty();
		assertThat(family.get(name, MATERNAL_UNCLE)).isNullOrEmpty();
		assertThat(family.get(name, PATERNAL_AUNT)).containsExactly("Atya");
		assertThat(family.get(name, PATERNAL_UNCLE)).containsExactly("Asva");
		assertThat(family.get(name, CHILDREN)).isNullOrEmpty();
		assertThat(family.get(name, DAUGHTER)).isNullOrEmpty();
		assertThat(family.get(name, SON)).isNullOrEmpty();
	}
}
