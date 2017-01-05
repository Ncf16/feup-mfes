
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Skill {
  private String description = "";
  private Number level = 1L;

  public void cg_init_Skill_1(final String desc, final Number lev) {

    description = desc;
    level = lev;
    return;
  }

  public Skill(final String desc, final Number lev) {

    cg_init_Skill_1(desc, lev);
  }

  public String getDescription() {

    return description;
  }

  public void setDescription(final String desc) {

    description = desc;
  }

  public Number getLevel() {

    return level;
  }

  public void setLevel(final Number lev) {

    level = lev;
  }

  public Skill() {}

  public String toString() {

    return "Skill{"
        + "description := "
        + Utils.toString(description)
        + ", level := "
        + Utils.toString(level)
        + "}";
  }
}
