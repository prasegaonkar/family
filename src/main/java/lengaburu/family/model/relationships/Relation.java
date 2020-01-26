package lengaburu.family.model.relationships;

import java.util.List;
import java.util.function.BiFunction;

import lengaburu.family.model.Family;
import lengaburu.family.model.Member;

interface Relation extends BiFunction<Family, Member, List<Member>> {

}
