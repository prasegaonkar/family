package lengaburu.family.app.commands;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.ExecutionContext;
import lengaburu.family.model.Family;
import lengaburu.family.model.exceptions.MemberNotFound;
import lengaburu.family.model.relationships.Relationships;

class GetRelationshipCommand implements AppCommand {

	@Override
	public void execute(String[] tokens, OutputStream os) throws IOException {
		if (tokens.length != 3) {
			throw new RuntimeException("Invalid command syntax");
		}
		String memberName = tokens[1];
		Relationships relationship = determineRelationship(tokens[2]);
		try {
			Family family = ExecutionContext.getFamily();
			List<String> list = family.get(memberName, relationship);
			if (list.size() == 0) {
				os.write("NONE".getBytes());
			}
			os.write(list.stream().collect(Collectors.joining(" ")).getBytes());
		} catch (MemberNotFound memberNotFound) {
			os.write("PERSON_NOT_FOUND".getBytes());
		}
	}

	private Relationships determineRelationship(String rName) {
		for (Relationships r : Relationships.values()) {
			if (r.getLabel().equalsIgnoreCase(rName)) {
				return r;
			}
		}
		throw new RuntimeException("Invalid relationship token observed: " + rName);
	}

}
