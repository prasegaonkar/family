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
		cmd.validateCommand(tokens);
		cmd.execute(tokens, os);
		os.write(System.lineSeparator().getBytes());
	}

	public static CommandTypes determineCommand(String command) {
		try {
			return CommandTypes.valueOf(command.toUpperCase());
		} catch (Exception ex) {
			throw new RuntimeException("Invalid command token observed: " + command);
		}
	}
}