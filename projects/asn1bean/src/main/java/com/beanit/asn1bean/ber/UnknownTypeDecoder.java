package com.beanit.asn1bean.ber;

import java.io.IOException;
import java.io.InputStream;

public interface UnknownTypeDecoder {
  public Object decode(InputStream in) throws IOException;
}
