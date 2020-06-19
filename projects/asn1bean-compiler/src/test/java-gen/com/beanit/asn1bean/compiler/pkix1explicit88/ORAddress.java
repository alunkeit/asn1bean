/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.pkix1explicit88;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;


public class ORAddress implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	private byte[] code = null;
	public BuiltInStandardAttributes builtInStandardAttributes = null;
	public BuiltInDomainDefinedAttributes builtInDomainDefinedAttributes = null;
	public ExtensionAttributes extensionAttributes = null;
	
	public ORAddress() {
	}

	public ORAddress(byte[] code) {
		this.code = code;
	}

	public ORAddress(BuiltInStandardAttributes builtInStandardAttributes, BuiltInDomainDefinedAttributes builtInDomainDefinedAttributes, ExtensionAttributes extensionAttributes) {
		this.builtInStandardAttributes = builtInStandardAttributes;
		this.builtInDomainDefinedAttributes = builtInDomainDefinedAttributes;
		this.extensionAttributes = extensionAttributes;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (extensionAttributes != null) {
			codeLength += extensionAttributes.encode(reverseOS, true);
		}
		
		if (builtInDomainDefinedAttributes != null) {
			codeLength += builtInDomainDefinedAttributes.encode(reverseOS, true);
		}
		
		codeLength += builtInStandardAttributes.encode(reverseOS, true);
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlByteCount = 0;
		int vByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BuiltInStandardAttributes.tag)) {
			builtInStandardAttributes = new BuiltInStandardAttributes();
			vByteCount += builtInStandardAttributes.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BuiltInDomainDefinedAttributes.tag)) {
			builtInDomainDefinedAttributes = new BuiltInDomainDefinedAttributes();
			vByteCount += builtInDomainDefinedAttributes.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(ExtensionAttributes.tag)) {
			extensionAttributes = new ExtensionAttributes();
			vByteCount += extensionAttributes.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (lengthVal < 0) {
			if (!berTag.equals(0, 0, 0)) {
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			vByteCount += BerLength.readEocByte(is);
			return tlByteCount + vByteCount;
		}

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", bytes decoded: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (builtInStandardAttributes != null) {
			sb.append("builtInStandardAttributes: ");
			builtInStandardAttributes.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("builtInStandardAttributes: <empty-required-field>");
		}
		
		if (builtInDomainDefinedAttributes != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("builtInDomainDefinedAttributes: ");
			builtInDomainDefinedAttributes.appendAsString(sb, indentLevel + 1);
		}
		
		if (extensionAttributes != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("extensionAttributes: ");
			extensionAttributes.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

