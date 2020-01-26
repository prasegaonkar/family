package lengaburu.family;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import lengaburu.family.commands.CommandTypes;
import lengaburu.family.model.Family;

public class App {
	private static final Family theShanFamily = InitialSetup.setup();

	public static void main(String[] args) throws IOException {
		String filePath = args[0];
		new App().processFile(filePath, System.out);
	}

	public void processFile(String filePath, OutputStream os) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get(filePath));
		lines.forEach(line -> {
			if (line != null && line.trim().length() > 0) {
				line = line.trim();
				processInstruction(line, os);
			}
		});
	}

	private void processInstruction(String line, OutputStream os) {
		try {
			String[] tokens = line.split(" ");
			if (tokens != null && tokens.length > 0) {
				CommandTypes command = determineCommand(tokens[0]);
				command.execute(theShanFamily, tokens, os);
				os.write(System.lineSeparator().getBytes());
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private CommandTypes determineCommand(String command) {
		try {
			return CommandTypes.valueOf(command.toUpperCase());
		} catch (Exception ex) {
			throw new RuntimeException("Invalid command token observed: " + command);
		}
	}

}