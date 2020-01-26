package lengaburu.family.commands;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import lengaburu.family.AppCommand;
import lengaburu.family.model.Family;
import lengaburu.family.model.Relationship;
import lengaburu.family.model.exceptions.MemberNotFound;

class GetRelationshipCommand implements AppCommand {

	@Override
	public void execute(Family family, String[] tokens, OutputStream os) throws IOException {
		if (tokens.length != 3) {
			throw new RuntimeException("Invalid command syntax");
		}
		String memberName = tokens[1];
		Relationship relationship = determineRelationship(tokens[2]);
		try {
			List<String> list = family.get(memberName, relationship);
			if (list.size() == 0) {
				os.write("NONE".getBytes());
			}
			os.write(list.stream().collect(Collectors.joining(" ")).getBytes());
		} catch (MemberNotFound memberNotFound) {
			os.write("PERSON_NOT_FOUND".getBytes());
		}
	}

	private Relationship determineRelationship(String rName) {
		for (RelationshipTypes r : RelationshipTypes.values()) {
			if (r.getName().equalsIgnoreCase(rName)) {
				return r.getRelationship();
			}
		}
		throw new RuntimeException("Invalid relationship token observed: " + rName);
	}

}
