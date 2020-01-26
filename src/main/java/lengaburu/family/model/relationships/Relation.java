package lengaburu.family.model.relationships;

import java.util.List;
import java.util.function.Function;

import lengaburu.family.model.Member;

interface Relation extends Function<Member, List<Member>> {

}
