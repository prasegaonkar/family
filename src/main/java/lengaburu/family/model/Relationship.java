package lengaburu.family.model;

import java.util.List;
import java.util.function.BiFunction;

public interface Relationship extends BiFunction<Family, Member, List<Member>> {

}
