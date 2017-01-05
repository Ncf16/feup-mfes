
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class LinkedIn {
  private VDMSet users = SetUtil.set();
  private Number avgDistance = 1L;
  private VDMSet usersMostContacts = SetUtil.set();

  public void cg_init_LinkedIn_1() {

    return;
  }

  public LinkedIn() {

    cg_init_LinkedIn_1();
  }

  public Person registerUser(final String n, final Object g, final Number a, final String u) {

    Person p = new Person(n, ((Object) g), a, u);
    addPerson(p);
    return p;
  }

  public void addPerson(final Person p) {

    users = SetUtil.union(Utils.copy(users), SetUtil.set(p));
  }

  public VDMSet searchPersonByName(final String name) {

    VDMSet setCompResult_1 = SetUtil.set();
    VDMSet set_12 = Utils.copy(users);
    for (Iterator iterator_12 = set_12.iterator(); iterator_12.hasNext(); ) {
      Person p = ((Person) iterator_12.next());
      if (Utils.equals(p.getName(), name)) {
        setCompResult_1.add(p);
      }
    }
    return Utils.copy(setCompResult_1);
  }

  public void createConnection(final Person p1, final Person p2) {

    p1.addConnection(p2);
    p2.addConnection(p1);
  }

  public void destroyConnection(final Person p1, final Person p2) {

    p1.removeConnection(p2);
    p2.removeConnection(p1);
  }

  public VDMSet commonContacts(final Person p, final Person p1) {

    VDMSet setCompResult_2 = SetUtil.set();
    VDMSet set_15 = p1.getConnections();
    for (Iterator iterator_16 = set_15.iterator(); iterator_16.hasNext(); ) {
      Person user = ((Person) iterator_16.next());
      if (SetUtil.inSet(user, p.getConnections())) {
        setCompResult_2.add(user);
      }
    }
    return Utils.copy(setCompResult_2);
  }

  public VDMSet mostContacts() {

    VDMSet setCompResult_3 = SetUtil.set();
    VDMSet set_18 = Utils.copy(users);
    for (Iterator iterator_19 = set_18.iterator(); iterator_19.hasNext(); ) {
      Person s = ((Person) iterator_19.next());
      Boolean existsExpResult_5 = false;
      VDMSet set_19 = Utils.copy(users);
      for (Iterator iterator_20 = set_19.iterator();
          iterator_20.hasNext() && !(existsExpResult_5);
          ) {
        Person p1 = ((Person) iterator_20.next());
        existsExpResult_5 = p1.connectionsSize().longValue() > s.connectionsSize().longValue();
      }
      if (!(existsExpResult_5)) {
        setCompResult_3.add(s);
      }
    }
    return Utils.copy(setCompResult_3);
  }

  public Number distanceBetweenPeople(final Person p, final Person p1) {

    VDMSeq queue = SeqUtil.seq();
    Person current = null;
    for (Iterator iterator_34 = users.iterator(); iterator_34.hasNext(); ) {
      Person u = (Person) iterator_34.next();
      u.setDistance(-1L);
    }
    p.setDistance(0L);
    queue = SeqUtil.conc(Utils.copy(queue), SeqUtil.seq(p));
    Boolean whileCond_1 = true;
    while (whileCond_1) {
      whileCond_1 = !(Utils.empty(queue));
      if (!(whileCond_1)) {
        break;
      }

      {
        current = ((Person) queue.get(0));
        queue = SeqUtil.tail(Utils.copy(queue));
        for (Iterator iterator_35 = current.getConnections().iterator(); iterator_35.hasNext(); ) {
          Person c = (Person) iterator_35.next();
          if (Utils.equals(c.getDistance(), -1L)) {
            c.setDistance(current.getDistance().doubleValue() + 1L);
            queue = SeqUtil.conc(Utils.copy(queue), SeqUtil.seq(c));
          }

          if (Utils.equals(c, p1)) {
            return c.getDistance();
          }
        }
      }
    }

    return -1L;
  }

  public Number avgDist() {

    Number avg = 0L;
    Number cnt = 0L;
    for (Iterator iterator_36 = users.iterator(); iterator_36.hasNext(); ) {
      Person u = (Person) iterator_36.next();
      VDMSet users2 = SetUtil.diff(Utils.copy(users), SetUtil.set(u));
      for (Iterator iterator_37 = users2.iterator(); iterator_37.hasNext(); ) {
        Person uu = (Person) iterator_37.next();
        Number dst = distanceBetweenPeople(u, uu);
        if (!(Utils.equals(dst, -1L))) {
          avg = avg.longValue() + dst.longValue();
          cnt = cnt.longValue() + 1L;
        }
      }
    }
    if (Utils.equals(cnt, 0L)) {
      return 0L;

    } else {
      avgDistance = Utils.divide((1.0 * avg.longValue()), cnt.longValue());
    }

    return avgDistance;
  }

  public VDMSet getUsers() {

    return Utils.copy(users);
  }

  public void cleanUsers() {

    users = SetUtil.set();
    return;
  }

  public String toString() {

    return "LinkedIn{"
        + "users := "
        + Utils.toString(users)
        + ", avgDistance := "
        + Utils.toString(avgDistance)
        + ", usersMostContacts := "
        + Utils.toString(usersMostContacts)
        + "}";
  }
}
