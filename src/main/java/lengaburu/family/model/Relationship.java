package lengaburu.family.model;

import java.util.Set;
import java.util.function.Function;

public interface Relationship extends Function<Member, Set<Member>> {

}
