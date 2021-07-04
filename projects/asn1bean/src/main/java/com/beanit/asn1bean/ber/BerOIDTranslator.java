package com.beanit.asn1bean.ber;

public interface BerOIDTranslator {
  public String translate(String oid) throws NoTranslationException;
}
