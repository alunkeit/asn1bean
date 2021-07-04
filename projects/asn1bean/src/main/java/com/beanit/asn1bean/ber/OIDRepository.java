package com.beanit.asn1bean.ber;

import java.util.ArrayList;
import java.util.List;

public class OIDRepository {

  private static List<BerOIDTranslator> translators = new ArrayList<BerOIDTranslator>();

  public static void register(BerOIDTranslator translator) {
    translators.add(translator);
  }

  public static String translate(String oid) {

    for (BerOIDTranslator t : translators) {
      try {
        String s = t.translate(oid);
        return s;
      } catch (NoTranslationException e) {
        continue;
      }
    }
    return oid;
  }
}
