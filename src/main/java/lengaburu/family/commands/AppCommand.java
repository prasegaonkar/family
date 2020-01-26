package lengaburu.family.commands;

import java.io.IOException;
import java.io.OutputStream;

import lengaburu.family.model.Family;

interface AppCommand {
	void execute(Family family, String[] tokens, OutputStream os) throws IOException;
}
