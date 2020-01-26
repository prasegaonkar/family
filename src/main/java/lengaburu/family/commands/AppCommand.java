package lengaburu.family.commands;

import java.io.IOException;
import java.io.OutputStream;

interface AppCommand {
	void execute(String[] tokens, OutputStream os) throws IOException;
}
