package lengaburu.family.commands;

import java.io.IOException;
import java.io.OutputStream;

import lengaburu.family.AppCommand;
import lengaburu.family.model.Family;

public enum CommandTypes {

	ADD_CHILD(new AddChildCommand()), GET_RELATIONSHIP(new GetRelationshipCommand());

	private final AppCommand cmd;

	CommandTypes(AppCommand cmd) {
		this.cmd = cmd;
	}

	public AppCommand getCmd() {
		return cmd;
	}

	public void execute(Family family, String[] tokens, OutputStream os) throws IOException {
		cmd.execute(family, tokens, os);
	}

}