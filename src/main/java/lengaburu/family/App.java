package lengaburu.family;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Relationship;
import lengaburu.family.model.exceptions.ChildAdditionFailed;
import lengaburu.family.model.exceptions.MemberNotFound;

public class App {
	private static final Family theShanFamily = InitialSetup.setup();

	public static void main(String[] args) throws IOException {
		String filePath = args[0];
		new App().process(filePath, System.out);
	}

	public void process(String filePath, OutputStream os) throws IOException {
		try {
			List<String> commands = Files.readAllLines(Paths.get(filePath));
			commands.forEach(c -> {
				try {
					execute(c, os);
					os.write(System.lineSeparator().getBytes());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
		} catch (IOException e) {
			os.write(e.getMessage().getBytes());
		}
	}

	private void execute(String command, OutputStream os) throws IOException {
		if (command != null && command.trim().length() > 0) {
			command = command.trim();
			String[] tokens = command.split(" ");
			if (tokens != null && tokens.length > 0) {
				ActionType actionType = determineAction(tokens[0]);
				if (ActionType.ADD_CHILD.equals(actionType)) {
					executeAddChild(tokens, os);
				} else {
					executeGetRelationship(tokens, os);
				}
			}
		}
	}

	private void executeGetRelationship(String[] tokens, OutputStream os) throws IOException {
		if (tokens.length != 3) {
			throw new RuntimeException("Invalid command syntax");
		}
		String memberName = tokens[1];
		Relationship relationship = determineRelationship(tokens[2]);
		try {
			List<String> list = theShanFamily.get(memberName, relationship);
			if (list.size() == 0) {
				os.write("NONE".getBytes());
			}
			os.write(list.stream().collect(Collectors.joining(" ")).getBytes());
		} catch (MemberNotFound memberNotFound) {
			os.write("PERSON_NOT_FOUND".getBytes());
		}
	}

	private Relationship determineRelationship(String rName) {
		try {
			for (Relationships r : Relationships.values()) {
				if (r.getName().equalsIgnoreCase(rName)) {
					return r.getRelationship();
				}
			}
			throw new RuntimeException("Invalid relationship token observed: " + rName);
		} catch (Exception ex) {
			throw new RuntimeException("Invalid relationship token observed: " + rName);
		}
	}

	private void executeAddChild(String[] tokens, OutputStream os) throws IOException {
		if (tokens.length != 4) {
			throw new RuntimeException("Invalid command syntax");
		}
		String motherName = tokens[1];
		String childName = tokens[2];
		Gender childGender = determineGender(tokens[3]);
		try {
			theShanFamily.addChild(motherName, childName, childGender);
			os.write("CHILD_ADDITION_SUCCEEDED".getBytes());
		} catch (MemberNotFound memberNotFound) {
			os.write("PERSON_NOT_FOUND".getBytes());
		} catch (ChildAdditionFailed childAdditionFailed) {
			os.write("CHILD_ADDITION_FAILED".getBytes());
		}
	}

	private Gender determineGender(String gender) {
		try {
			return Gender.valueOf(gender.toUpperCase());
		} catch (Exception ex) {
			throw new RuntimeException("Invalid gender token observed: " + gender);
		}
	}

	private ActionType determineAction(String action) {
		try {
			return ActionType.valueOf(action.toUpperCase());
		} catch (Exception ex) {
			throw new RuntimeException("Invalid action token observed: " + action);
		}
	}

}

enum ActionType {
	ADD_CHILD, GET_RELATIONSHIP;
}