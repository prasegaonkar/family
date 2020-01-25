package lengaburu.family;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.model.Relationship;

public class App {
	private static final Family theShanFamily = InitialSetup.setup();

	public static void main(String[] args) throws IOException {
		String filePath = args[0];
		List<String> commands = Files.readAllLines(Paths.get(filePath));
		commands.forEach(App::execute);
	}

	private static void execute(String command) {
		if (command != null && command.trim().length() > 0) {
			command = command.trim();
			String[] tokens = command.split(" ");
			if (tokens != null && tokens.length > 0) {
				ActionType actionType = determineAction(tokens[0]);
				if (ActionType.ADD_CHILD.equals(actionType)) {
					executeAddChild(tokens);
				} else {
					executeGetRelationship(tokens);
				}
			}
		}
	}

	private static void executeGetRelationship(String[] tokens) {
		if (tokens.length != 3) {
			throw new RuntimeException("Invalid command syntax");
		}
		String memberName = tokens[1];
		Relationship relationship = determineRelationship(tokens[2]);
		theShanFamily.get(memberName, relationship);
	}

	private static Relationship determineRelationship(String rName) {
		try {
			for (Relationships r : Relationships.values()) {
				if (r.getName().equals(rName)) {
					return r.getRelationship();
				}
			}
			throw new RuntimeException("Invalid relationship token observed: " + rName);
		} catch (Exception ex) {
			throw new RuntimeException("Invalid relationship token observed: " + rName);
		}
	}

	private static void executeAddChild(String[] tokens) {
		if (tokens.length != 4) {
			throw new RuntimeException("Invalid command syntax");
		}
		String motherName = tokens[1];
		String childName = tokens[2];
		Gender childGender = determineGender(tokens[3]);
		theShanFamily.addChild(motherName, childName, childGender);
	}

	private static Gender determineGender(String gender) {
		try {
			return Gender.valueOf(gender.toUpperCase());
		} catch (Exception ex) {
			throw new RuntimeException("Invalid gender token observed: " + gender);
		}
	}

	private static ActionType determineAction(String action) {
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