package com.beanit.asn1bean.ber;

import com.beanit.asn1bean.util.HexString;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class UnknownTypeHandler {
  private static List<UnknownTypeDecoder> decoders = new ArrayList<UnknownTypeDecoder>();

  public static void register(UnknownTypeDecoder decoder) {
    decoders.add(decoder);
  }

  /**
   * Requests registered Decoders if one of them is able to interpret the given byte sequence.
   *
   * @param in - an input stream pointing to the data to be decoed.
   * @return Object - the decoded object
   * @throws IOException - in case of an I/O error
   */
  public static Object decode(InputStream in) throws IOException {

    // save the bytes of the InputStream
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    in.transferTo(out);

    for (UnknownTypeDecoder decoder : decoders) {
      try {

        Object o = decoder.decode(new ByteArrayInputStream(out.toByteArray()));

        if (o != null) return o;
      } catch (IOException e) {
        continue;
      }
    }

    return HexString.fromBytes(new ByteArrayInputStream(out.toByteArray()).readAllBytes());
  }
}
