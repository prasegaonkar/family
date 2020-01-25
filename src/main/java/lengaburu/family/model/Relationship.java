package lengaburu.family.model;

import java.util.Set;
import java.util.function.BiFunction;

public interface Relationship extends BiFunction<Family, Member, Set<Member>> {

}
