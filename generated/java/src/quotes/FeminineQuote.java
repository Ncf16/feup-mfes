package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FeminineQuote {
  private static int hc = 0;
  private static FeminineQuote instance = null;

  public FeminineQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static FeminineQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new FeminineQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof FeminineQuote;
  }

  public String toString() {

    return "<Feminine>";
  }
}
