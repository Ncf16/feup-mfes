package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MasculineQuote {
  private static int hc = 0;
  private static MasculineQuote instance = null;

  public MasculineQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MasculineQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MasculineQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MasculineQuote;
  }

  public String toString() {

    return "<Masculine>";
  }
}
