package lengaburu.family;

import java.io.IOException;
import java.io.OutputStream;

import lengaburu.family.model.Family;

public interface AppCommand {
	void execute(Family family, String[] tokens, OutputStream os) throws IOException;
}
