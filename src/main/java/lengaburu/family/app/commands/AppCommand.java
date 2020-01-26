package lengaburu.family.app.commands;

import java.io.IOException;
import java.io.OutputStream;

interface AppCommand {
	void validateCommand(String[] tokens);

	void execute(String[] tokens, OutputStream os) throws IOException;
}
