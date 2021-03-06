package lengaburu.family.app.commands;

import java.io.IOException;
import java.io.OutputStream;

import lengaburu.family.ExecutionContext;
import lengaburu.family.model.Family;
import lengaburu.family.model.Gender;
import lengaburu.family.model.exceptions.ChildAdditionFailed;
import lengaburu.family.model.exceptions.MemberNotFound;

class AddChildCommand implements AppCommand {

	@Override
	public void execute(String[] tokens, OutputStream os) throws IOException {
		String motherName = tokens[1];
		String childName = tokens[2];
		Gender childGender = Gender.determineGender(tokens[3]);
		try {
			Family family = ExecutionContext.getFamily();
			family.addChild(motherName, childName, childGender);
			os.write("CHILD_ADDITION_SUCCEEDED".getBytes());
		} catch (MemberNotFound memberNotFound) {
			os.write("PERSON_NOT_FOUND".getBytes());
		} catch (ChildAdditionFailed childAdditionFailed) {
			os.write("CHILD_ADDITION_FAILED".getBytes());
		}
	}

	@Override
	public void validateCommand(String[] tokens) {
		if (tokens.length != 4) {
			throw new RuntimeException("Invalid command syntax");
		}
	}

}
