package lengaburu.family.app;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import lengaburu.family.ExecutionContext;
import lengaburu.family.app.commands.CommandTypes;

public class App {
	public static void main(String[] args) throws IOException {
		ExecutionContext.setup();
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
				CommandTypes command = CommandTypes.determineCommand(tokens[0]);
				command.execute(tokens, os);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}