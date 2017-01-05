
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Person {
  private VDMSet connections = SetUtil.set();
  private String name = "";
  private Number age = 99L;
  private Object gender = quotes.MasculineQuote.getInstance();
  private String CV = "";
  private VDMSet skillset = SetUtil.set();
  private String location = "";
  private Number distance = 0L;
  private String username;

  public void cg_init_Person_1(final String n, final Object g, final Number a, final String u) {

    name = n;
    gender = g;
    age = a;
    username = u;
    return;
  }

  public Person(final String n, final Object g, final Number a, final String u) {

    cg_init_Person_1(n, g, a, u);
  }

  public void addConnection(final Person p) {

    connections = SetUtil.union(Utils.copy(connections), SetUtil.set(p));
  }

  public void removeConnection(final Person p) {

    connections = SetUtil.diff(Utils.copy(connections), SetUtil.set(p));
  }

  public void editLocation(final String loc) {

    location = loc;
  }

  public void editCV(final String cv) {

    CV = cv;
  }

  public void addSkill(final String description, final Number evaluation) {

    Skill skill = new Skill(description, evaluation);
    skillset = SetUtil.union(Utils.copy(skillset), SetUtil.set(skill));
  }

  public void editSkillLevel(final String description, final Number newLevel) {

    for (Iterator iterator_38 = skillset.iterator(); iterator_38.hasNext(); ) {
      Skill skills = (Skill) iterator_38.next();
      if (Utils.equals(skills.getDescription(), description)) {
        skills.setLevel(newLevel);
      }
    }
  }

  public String getUsername() {

    return username;
  }

  public String getName() {

    return name;
  }

  public Number getAge() {

    return age;
  }

  public String getCV() {

    return CV;
  }

  public String getLocation() {

    return location;
  }

  public VDMSet getSkillset() {

    return Utils.copy(skillset);
  }

  public Object getGender() {

    return gender;
  }

  public VDMSet getConnections() {

    return Utils.copy(connections);
  }

  public Number getDistance() {

    return distance;
  }

  public Number connectionsSize() {

    return connections.size();
  }

  public void setDistance(final Number d) {

    distance = d;
  }

  public Person() {}

  public String toString() {

    return "Person{"
        + "connections := "
        + Utils.toString(connections)
        + ", name := "
        + Utils.toString(name)
        + ", age := "
        + Utils.toString(age)
        + ", gender := "
        + Utils.toString(gender)
        + ", CV := "
        + Utils.toString(CV)
        + ", skillset := "
        + Utils.toString(skillset)
        + ", location := "
        + Utils.toString(location)
        + ", distance := "
        + Utils.toString(distance)
        + ", username := "
        + Utils.toString(username)
        + "}";
  }
}
