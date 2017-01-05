
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LinkedInTest {
  public LinkedIn l = new LinkedIn();

  private void assertTrue(final Boolean cond) {

    return;
  }

  public void registerUserTest() {

    Person p1 = null;
    Person p2 = null;
    Person p3 = null;
    assertTrue(Utils.equals(l.getUsers().size(), 0L));
    p1 = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    assertTrue(Utils.equals(l.getUsers().size(), 1L));
    Boolean forAllExpResult_1 = true;
    VDMSet set_1 = l.getUsers();
    for (Iterator iterator_1 = set_1.iterator(); iterator_1.hasNext() && forAllExpResult_1; ) {
      Person s = ((Person) iterator_1.next());
      forAllExpResult_1 = Utils.equals(s.getName(), "Luis");
    }
    assertTrue(forAllExpResult_1);

    Long exists1Counter_1 = 0L;
    VDMSet set_2 = l.getUsers();
    for (Iterator iterator_2 = set_2.iterator();
        iterator_2.hasNext() && (exists1Counter_1.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_2.next());
      if (Utils.equals(s.getName(), "Luis")) {
        exists1Counter_1++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_1, 1L));

    p2 = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 23L, "luis23");
    assertTrue(Utils.equals(l.getUsers().size(), 2L));
    Boolean forAllExpResult_2 = true;
    VDMSet set_3 = l.getUsers();
    for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext() && forAllExpResult_2; ) {
      Person s = ((Person) iterator_3.next());
      forAllExpResult_2 = Utils.equals(s.getName(), "Luis");
    }
    assertTrue(forAllExpResult_2);

    p3 = l.registerUser("Carla", quotes.FeminineQuote.getInstance(), 30L, "carla30");
    assertTrue(Utils.equals(l.getUsers().size(), 3L));
    Long exists1Counter_2 = 0L;
    VDMSet set_4 = l.getUsers();
    for (Iterator iterator_4 = set_4.iterator();
        iterator_4.hasNext() && (exists1Counter_2.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_4.next());
      if (Utils.equals(s.getName(), "Carla")) {
        exists1Counter_2++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_2, 1L));
  }

  public void searchPersonByNameTest() {

    Person p1 = null;
    Person p2 = null;
    VDMSet pplSearched = null;
    assertTrue(Utils.equals(0L, l.getUsers().size()));
    p1 = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    p2 = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 23L, "luis23");
    pplSearched = l.searchPersonByName("Luis");
    assertTrue(Utils.equals(pplSearched.size(), 2L));
    for (Iterator iterator_33 = pplSearched.iterator(); iterator_33.hasNext(); ) {
      Person p = (Person) iterator_33.next();
      assertTrue(Utils.equals(p.getName(), "Luis"));
    }
    pplSearched = l.searchPersonByName("Joao");
    assertTrue(Utils.equals(pplSearched.size(), 0L));
    return;
  }

  public void createDestroyConnectionTest() {

    Person p = null;
    Person p1 = null;
    Person p2 = null;
    p = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    p1 = l.registerUser("Filipe", quotes.MasculineQuote.getInstance(), 22L, "filipe22");
    p2 = l.registerUser("Maria", quotes.FeminineQuote.getInstance(), 24L, "maria24");
    l.createConnection(p, p1);
    l.createConnection(p1, p2);
    Boolean andResult_3 = false;

    if (Utils.equals(p.getConnections().size(), 1L)) {
      Boolean andResult_4 = false;

      if (Utils.equals(p1.getConnections().size(), 2L)) {
        if (Utils.equals(p2.getConnections().size(), 1L)) {
          andResult_4 = true;
        }
      }

      if (andResult_4) {
        andResult_3 = true;
      }
    }

    assertTrue(andResult_3);

    Boolean existsExpResult_1 = false;
    VDMSet set_5 = p.getConnections();
    for (Iterator iterator_5 = set_5.iterator(); iterator_5.hasNext() && !(existsExpResult_1); ) {
      Person s = ((Person) iterator_5.next());
      existsExpResult_1 = Utils.equals(s.getUsername(), "filipe22");
    }
    assertTrue(existsExpResult_1);

    Long exists1Counter_3 = 0L;
    VDMSet set_6 = p1.getConnections();
    for (Iterator iterator_6 = set_6.iterator();
        iterator_6.hasNext() && (exists1Counter_3.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_6.next());
      if (Utils.equals(s.getUsername(), "luis22")) {
        exists1Counter_3++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_3, 1L));

    Long exists1Counter_4 = 0L;
    VDMSet set_7 = p1.getConnections();
    for (Iterator iterator_7 = set_7.iterator();
        iterator_7.hasNext() && (exists1Counter_4.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_7.next());
      if (Utils.equals(s.getUsername(), "maria24")) {
        exists1Counter_4++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_4, 1L));

    Long exists1Counter_5 = 0L;
    VDMSet set_8 = p2.getConnections();
    for (Iterator iterator_8 = set_8.iterator();
        iterator_8.hasNext() && (exists1Counter_5.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_8.next());
      if (Utils.equals(s.getUsername(), "filipe22")) {
        exists1Counter_5++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_5, 1L));

    l.destroyConnection(p, p1);
    Boolean andResult_5 = false;

    if (Utils.equals(p.getConnections().size(), 0L)) {
      Boolean andResult_6 = false;

      if (Utils.equals(p1.getConnections().size(), 1L)) {
        if (Utils.equals(p2.getConnections().size(), 1L)) {
          andResult_6 = true;
        }
      }

      if (andResult_6) {
        andResult_5 = true;
      }
    }

    assertTrue(andResult_5);

    Long exists1Counter_6 = 0L;
    VDMSet set_9 = p1.getConnections();
    for (Iterator iterator_9 = set_9.iterator();
        iterator_9.hasNext() && (exists1Counter_6.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_9.next());
      if (Utils.equals(s.getUsername(), "maria24")) {
        exists1Counter_6++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_6, 1L));

    Long exists1Counter_7 = 0L;
    VDMSet set_10 = p2.getConnections();
    for (Iterator iterator_10 = set_10.iterator();
        iterator_10.hasNext() && (exists1Counter_7.longValue() < 2L);
        ) {
      Person s = ((Person) iterator_10.next());
      if (Utils.equals(s.getUsername(), "filipe22")) {
        exists1Counter_7++;
      }
    }
    assertTrue(Utils.equals(exists1Counter_7, 1L));

    l.destroyConnection(p1, p2);
    Boolean andResult_7 = false;

    if (Utils.equals(p.getConnections().size(), 0L)) {
      Boolean andResult_8 = false;

      if (Utils.equals(p1.getConnections().size(), 0L)) {
        if (Utils.equals(p2.getConnections().size(), 0L)) {
          andResult_8 = true;
        }
      }

      if (andResult_8) {
        andResult_7 = true;
      }
    }

    assertTrue(andResult_7);

    return;
  }

  public void commonContactsTest() {

    Person p = null;
    Person p1 = null;
    Person p2 = null;
    Person p3 = null;
    assertTrue(Utils.equals(0L, l.getUsers().size()));
    p = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    p1 = l.registerUser("Filipe", quotes.MasculineQuote.getInstance(), 22L, "filipe22");
    p2 = l.registerUser("Pedro", quotes.MasculineQuote.getInstance(), 22L, "pedro22");
    p3 = l.registerUser("Joana", quotes.FeminineQuote.getInstance(), 22L, "joana22");
    l.createConnection(p1, p2);
    l.createConnection(p, p2);
    l.createConnection(p2, p3);
    assertTrue(Utils.equals(l.commonContacts(p1, p), SetUtil.set(p2)));
    assertTrue(Utils.empty(l.commonContacts(p2, p3)));
  }

  public void mostContactsTest() {

    Person p = null;
    Person p1 = null;
    Person p2 = null;
    Person p3 = null;
    assertTrue(Utils.equals(0L, l.getUsers().size()));
    p = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    p1 = l.registerUser("Filipe", quotes.MasculineQuote.getInstance(), 22L, "filipe22");
    p2 = l.registerUser("Pedro", quotes.MasculineQuote.getInstance(), 22L, "pedro22");
    p3 = l.registerUser("Maria", quotes.FeminineQuote.getInstance(), 24L, "maria24");
    assertTrue(Utils.equals(SetUtil.set(p, p1, p2, p3), l.mostContacts()));
    l.createConnection(p, p1);
    l.createConnection(p1, p2);
    assertTrue(Utils.equals(l.mostContacts(), SetUtil.set(p1)));
    l.createConnection(p2, p3);
    assertTrue(Utils.equals(l.mostContacts(), SetUtil.set(p1, p2)));
    l.destroyConnection(p, p1);
    assertTrue(Utils.equals(l.mostContacts(), SetUtil.set(p2)));
    l.createConnection(p, p1);
    l.createConnection(p3, p);
    assertTrue(Utils.equals(l.mostContacts(), SetUtil.set(p, p1, p2, p3)));
  }

  public void distanceBetweenPeopleTest() {

    Person p = null;
    Person p1 = null;
    Person p2 = null;
    Person p3 = null;
    assertTrue(Utils.equals(l.getUsers().size(), 0L));
    p = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    p1 = l.registerUser("Filipe", quotes.MasculineQuote.getInstance(), 22L, "filipe22");
    p2 = l.registerUser("Pedro", quotes.MasculineQuote.getInstance(), 22L, "pedro22");
    p3 = l.registerUser("Jose", quotes.MasculineQuote.getInstance(), 22L, "jose22");
    assertTrue(Utils.equals(l.getUsers().size(), 4L));
    l.createConnection(p, p1);
    l.createConnection(p1, p2);
    assertTrue(Utils.equals(l.distanceBetweenPeople(p, p1), 1L));
    assertTrue(Utils.equals(l.distanceBetweenPeople(p, p2), 2L));
    assertTrue(Utils.equals(l.distanceBetweenPeople(p, p), 0L));
    assertTrue(Utils.equals(l.distanceBetweenPeople(p, p3), -1L));
    assertTrue(Utils.equals(l.distanceBetweenPeople(p1, p3), -1L));
    assertTrue(Utils.equals(l.distanceBetweenPeople(p2, p3), -1L));
    return;
  }

  public void avgDistTest() {

    Person p = l.registerUser("Pedro", quotes.MasculineQuote.getInstance(), 22L, "pedro22");
    Person p1 = l.registerUser("Luis", quotes.MasculineQuote.getInstance(), 22L, "luis22");
    Person p2 = l.registerUser("Carlos", quotes.MasculineQuote.getInstance(), 22L, "carlos22");
    Person p3 = l.registerUser("Filipe", quotes.MasculineQuote.getInstance(), 22L, "filipe22");
    Person p4 = null;
    assertTrue(Utils.equals(0L, l.avgDist()));
    l.createConnection(p, p1);
    l.createConnection(p3, p1);
    l.createConnection(p2, p3);
    l.createConnection(p2, p);
    assertTrue(Utils.equals(Utils.divide((1.0 * 8L), 6L), l.avgDist()));
    p4 = l.registerUser("Jose", quotes.MasculineQuote.getInstance(), 22L, "jose22");
    assertTrue(Utils.equals(Utils.divide((1.0 * 8L), 6L), l.avgDist()));
  }

  public LinkedIn getLinkedIn() {

    return l;
  }

  public static void main() {

    LinkedInTest lt = new LinkedInTest();
    lt.registerUserTest();
    lt.getLinkedIn().cleanUsers();
    lt.searchPersonByNameTest();
    lt.getLinkedIn().cleanUsers();
    lt.mostContactsTest();
    lt.getLinkedIn().cleanUsers();
    lt.commonContactsTest();
    lt.getLinkedIn().cleanUsers();
    lt.avgDistTest();
    lt.getLinkedIn().cleanUsers();
    lt.createDestroyConnectionTest();
    lt.getLinkedIn().cleanUsers();
    lt.distanceBetweenPeopleTest();
    PersonTest.main();
    return;
  }

  public LinkedInTest() {}

  public String toString() {

    return "LinkedInTest{" + "l := " + Utils.toString(l) + "}";
  }
}
