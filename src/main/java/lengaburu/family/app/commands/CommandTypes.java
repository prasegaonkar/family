package lengaburu.family.app.commands;

import java.io.IOException;
import java.io.OutputStream;

public enum CommandTypes {

	ADD_CHILD(new AddChildCommand()), GET_RELATIONSHIP(new GetRelationshipCommand());

	private final AppCommand cmd;

	CommandTypes(AppCommand cmd) {
		this.cmd = cmd;
	}

	public AppCommand getCmd() {
		return cmd;
	}

	public void execute(String[] tokens, OutputStream os) throws IOException {
		cmd.execute(tokens, os);
	}

}