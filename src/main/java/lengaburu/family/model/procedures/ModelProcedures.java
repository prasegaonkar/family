package lengaburu.family.model.procedures;

import lengaburu.family.model.Member;
import lengaburu.family.model.AddMember;

public enum ModelProcedures {

	ADD_CHILD(new AddChild()), ADD_SPOUSE(new AddSpouse());

	private final AddMember procedure;

	private ModelProcedures(AddMember proc) {
		this.procedure = proc;
	}

	public void run(Member t, Member u) {
		procedure.accept(t, u);
	}
}
