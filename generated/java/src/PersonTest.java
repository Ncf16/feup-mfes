
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PersonTest {
  public Person person = new Person("Teste", quotes.MasculineQuote.getInstance(), 22L, "Teste22");

  private void assertTrue(final Boolean cond) {

    return;
  }

  public void personConstructorTest() {

    Person testPerson = new Person("Teste", quotes.MasculineQuote.getInstance(), 22L, "Teste22");
    assertTrue(Utils.equals(testPerson.getName(), "Teste"));
    assertTrue(Utils.equals(testPerson.getGender(), quotes.MasculineQuote.getInstance()));
    assertTrue(Utils.equals(testPerson.getAge(), 22L));
    assertTrue(Utils.equals(testPerson.getUsername(), "Teste22"));
    assertTrue(Utils.equals(testPerson.getCV(), ""));
    assertTrue(Utils.equals(testPerson.getLocation(), ""));
    assertTrue(Utils.equals(testPerson.getSkillset().size(), 0L));
    assertTrue(Utils.equals(testPerson.getConnections().size(), 0L));
    return;
  }

  public void addRemoveConnectionTest() {

    Person p1 = new Person("Pedro", quotes.MasculineQuote.getInstance(), 22L, "Pedro22");
    Person p2 = new Person("Joana", quotes.FeminineQuote.getInstance(), 45L, "Joana45");
    Person p3 = new Person("Ana", quotes.FeminineQuote.getInstance(), 19L, "Ana19");
    assertTrue(Utils.equals(p1.getConnections().size(), 0L));
    assertTrue(Utils.equals(p1.getConnections().size(), 0L));
    p1.addConnection(p2);
    assertTrue(Utils.equals(p1.getConnections().size(), 1L));
    Boolean forAllExpResult_5 = true;
    VDMSet set_25 = p1.getConnections();
    for (Iterator iterator_27 = set_25.iterator(); iterator_27.hasNext() && forAllExpResult_5; ) {
      Person p = ((Person) iterator_27.next());
      forAllExpResult_5 = Utils.equals(p.getName(), "Joana");
    }
    assertTrue(forAllExpResult_5);

    p1.addConnection(p3);
    assertTrue(Utils.equals(p1.getConnections().size(), 2L));
    Long exists1Counter_8 = 0L;
    VDMSet set_26 = p1.getConnections();
    for (Iterator iterator_28 = set_26.iterator();
        iterator_28.hasNext() && (exists1Counter_8.longValue() < 2L);
        ) {
      Person p = ((Person) iterator_28.next());
      if (Utils.equals(p.getName(), "Ana")) {
        exists1Counter_8++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_8, 1L));

    p1.removeConnection(p2);
    assertTrue(Utils.equals(p1.getConnections().size(), 1L));
    Boolean forAllExpResult_6 = true;
    VDMSet set_27 = p1.getConnections();
    for (Iterator iterator_29 = set_27.iterator(); iterator_29.hasNext() && forAllExpResult_6; ) {
      Person p = ((Person) iterator_29.next());
      forAllExpResult_6 = Utils.equals(p.getName(), "Ana");
    }
    assertTrue(forAllExpResult_6);

    p1.removeConnection(p3);
    assertTrue(Utils.equals(p1.getConnections().size(), 0L));
    return;
  }

  public void editLocationTest() {

    person.editLocation("Location String");
    assertTrue(Utils.equals(person.getLocation(), "Location String"));
    assertTrue(Utils.equals(person.getLocation().length(), 15L));
    person.editLocation("");
    assertTrue(Utils.equals(person.getLocation(), ""));
    assertTrue(Utils.equals(person.getLocation().length(), 0L));
    return;
  }

  public void editCVTest() {

    person.editCV("TestCV String");
    assertTrue(Utils.equals(person.getCV(), "TestCV String"));
    assertTrue(Utils.equals(person.getCV().length(), 13L));
    person.editCV("");
    assertTrue(Utils.equals(person.getCV(), ""));
    assertTrue(Utils.equals(person.getCV().length(), 0L));
    return;
  }

  public void addEditSkillsTest() {

    Person p1 = new Person("Pedro", quotes.MasculineQuote.getInstance(), 22L, "Pedro22");
    assertTrue(Utils.equals(p1.getSkillset().size(), 0L));
    p1.addSkill("C++", 4L);
    assertTrue(Utils.equals(p1.getSkillset().size(), 1L));
    Long exists1Counter_9 = 0L;
    VDMSet set_28 = p1.getSkillset();
    for (Iterator iterator_30 = set_28.iterator();
        iterator_30.hasNext() && (exists1Counter_9.longValue() < 2L);
        ) {
      Skill p = ((Skill) iterator_30.next());
      Boolean andResult_36 = false;

      if (Utils.equals(p.getDescription(), "C++")) {
        if (Utils.equals(p.getLevel(), 4L)) {
          andResult_36 = true;
        }
      }

      if (andResult_36) {
        exists1Counter_9++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_9, 1L));

    p1.addSkill("Java", 5L);
    assertTrue(Utils.equals(p1.getSkillset().size(), 2L));
    Long exists1Counter_10 = 0L;
    VDMSet set_29 = p1.getSkillset();
    for (Iterator iterator_31 = set_29.iterator();
        iterator_31.hasNext() && (exists1Counter_10.longValue() < 2L);
        ) {
      Skill p = ((Skill) iterator_31.next());
      Boolean andResult_37 = false;

      if (Utils.equals(p.getDescription(), "Java")) {
        if (Utils.equals(p.getLevel(), 5L)) {
          andResult_37 = true;
        }
      }

      if (andResult_37) {
        exists1Counter_10++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_10, 1L));

    p1.editSkillLevel("C++", 3L);
    assertTrue(Utils.equals(p1.getSkillset().size(), 2L));
    Long exists1Counter_11 = 0L;
    VDMSet set_30 = p1.getSkillset();
    for (Iterator iterator_32 = set_30.iterator();
        iterator_32.hasNext() && (exists1Counter_11.longValue() < 2L);
        ) {
      Skill p = ((Skill) iterator_32.next());
      Boolean andResult_38 = false;

      if (Utils.equals(p.getDescription(), "C++")) {
        if (Utils.equals(p.getLevel(), 3L)) {
          andResult_38 = true;
        }
      }

      if (andResult_38) {
        exists1Counter_11++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_11, 1L));

    return;
  }

  public static void main(String[] args) {

    PersonTest personTest = new PersonTest();
    personTest.personConstructorTest();
    personTest.addRemoveConnectionTest();
    personTest.editLocationTest();
    personTest.editCVTest();
    personTest.addEditSkillsTest();
    return;
  }

  public PersonTest() {}

  public String toString() {

    return "PersonTest{" + "person := " + Utils.toString(person) + "}";
  }
}
