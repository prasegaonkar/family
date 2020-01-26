package lengaburu.family;

import lengaburu.family.ExecutionContext;
import lengaburu.family.model.Family;

public class TestContext {

	public static void setup() {
		ExecutionContext.setup();
	}

	public static Family getFamily() {
		return ExecutionContext.getFamily();
	}

}
