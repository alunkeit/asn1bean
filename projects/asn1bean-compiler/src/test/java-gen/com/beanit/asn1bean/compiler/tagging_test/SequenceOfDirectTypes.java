/*
 * This class file was automatically generated by ASN1bean (http://www.beanit.com)
 */

package com.beanit.asn1bean.compiler.tagging_test;

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


public class SequenceOfDirectTypes implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static class UntaggedChoice implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		private byte[] code = null;
		private BerInteger myInteger = null;
		private BerBoolean myBoolean = null;
		
		public UntaggedChoice() {
		}

		public UntaggedChoice(byte[] code) {
			this.code = code;
		}

		public void setMyInteger(BerInteger myInteger) {
			this.myInteger = myInteger;
		}

		public BerInteger getMyInteger() {
			return myInteger;
		}

		public void setMyBoolean(BerBoolean myBoolean) {
			this.myBoolean = myBoolean;
		}

		public BerBoolean getMyBoolean() {
			return myBoolean;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				reverseOS.write(code);
				return code.length;
			}

			int codeLength = 0;
			if (myBoolean != null) {
				codeLength += myBoolean.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				reverseOS.write(0x84);
				codeLength += 1;
				return codeLength;
			}
			
			if (myInteger != null) {
				codeLength += myInteger.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				reverseOS.write(0x83);
				codeLength += 1;
				return codeLength;
			}
			
			throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
		}

		@Override public int decode(InputStream is) throws IOException {
			return decode(is, null);
		}

		public int decode(InputStream is, BerTag berTag) throws IOException {

			int tlvByteCount = 0;
			boolean tagWasPassed = (berTag != null);

			if (berTag == null) {
				berTag = new BerTag();
				tlvByteCount += berTag.decode(is);
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
				myInteger = new BerInteger();
				tlvByteCount += myInteger.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
				myBoolean = new BerBoolean();
				tlvByteCount += myBoolean.decode(is, false);
				return tlvByteCount;
			}

			if (tagWasPassed) {
				return 0;
			}

			throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS);
			code = reverseOS.getArray();
		}

		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			if (myInteger != null) {
				sb.append("myInteger: ").append(myInteger);
				return;
			}

			if (myBoolean != null) {
				sb.append("myBoolean: ").append(myBoolean);
				return;
			}

			sb.append("<none>");
		}

	}

	public static class TaggedChoice implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		private byte[] code = null;
		private BerInteger myInteger = null;
		private BerBoolean myBoolean = null;
		
		public TaggedChoice() {
		}

		public TaggedChoice(byte[] code) {
			this.code = code;
		}

		public void setMyInteger(BerInteger myInteger) {
			this.myInteger = myInteger;
		}

		public BerInteger getMyInteger() {
			return myInteger;
		}

		public void setMyBoolean(BerBoolean myBoolean) {
			this.myBoolean = myBoolean;
		}

		public BerBoolean getMyBoolean() {
			return myBoolean;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				reverseOS.write(code);
				return code.length;
			}

			int codeLength = 0;
			if (myBoolean != null) {
				codeLength += myBoolean.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				reverseOS.write(0x84);
				codeLength += 1;
				return codeLength;
			}
			
			if (myInteger != null) {
				codeLength += myInteger.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				reverseOS.write(0x83);
				codeLength += 1;
				return codeLength;
			}
			
			throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
		}

		@Override public int decode(InputStream is) throws IOException {
			return decode(is, null);
		}

		public int decode(InputStream is, BerTag berTag) throws IOException {

			int tlvByteCount = 0;
			boolean tagWasPassed = (berTag != null);

			if (berTag == null) {
				berTag = new BerTag();
				tlvByteCount += berTag.decode(is);
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
				myInteger = new BerInteger();
				tlvByteCount += myInteger.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
				myBoolean = new BerBoolean();
				tlvByteCount += myBoolean.decode(is, false);
				return tlvByteCount;
			}

			if (tagWasPassed) {
				return 0;
			}

			throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS);
			code = reverseOS.getArray();
		}

		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			if (myInteger != null) {
				sb.append("myInteger: ").append(myInteger);
				return;
			}

			if (myBoolean != null) {
				sb.append("myBoolean: ").append(myBoolean);
				return;
			}

			sb.append("<none>");
		}

	}

	public static class UntaggedChoice2 implements BerType, Serializable {

		private static final long serialVersionUID = 1L;

		private byte[] code = null;
		private BerInteger myInteger = null;
		private BerBoolean myBoolean = null;
		
		public UntaggedChoice2() {
		}

		public UntaggedChoice2(byte[] code) {
			this.code = code;
		}

		public void setMyInteger(BerInteger myInteger) {
			this.myInteger = myInteger;
		}

		public BerInteger getMyInteger() {
			return myInteger;
		}

		public void setMyBoolean(BerBoolean myBoolean) {
			this.myBoolean = myBoolean;
		}

		public BerBoolean getMyBoolean() {
			return myBoolean;
		}

		@Override public int encode(OutputStream reverseOS) throws IOException {

			if (code != null) {
				reverseOS.write(code);
				return code.length;
			}

			int codeLength = 0;
			if (myBoolean != null) {
				codeLength += myBoolean.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 9
				reverseOS.write(0x89);
				codeLength += 1;
				return codeLength;
			}
			
			if (myInteger != null) {
				codeLength += myInteger.encode(reverseOS, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 8
				reverseOS.write(0x88);
				codeLength += 1;
				return codeLength;
			}
			
			throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
		}

		@Override public int decode(InputStream is) throws IOException {
			return decode(is, null);
		}

		public int decode(InputStream is, BerTag berTag) throws IOException {

			int tlvByteCount = 0;
			boolean tagWasPassed = (berTag != null);

			if (berTag == null) {
				berTag = new BerTag();
				tlvByteCount += berTag.decode(is);
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
				myInteger = new BerInteger();
				tlvByteCount += myInteger.decode(is, false);
				return tlvByteCount;
			}

			if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 9)) {
				myBoolean = new BerBoolean();
				tlvByteCount += myBoolean.decode(is, false);
				return tlvByteCount;
			}

			if (tagWasPassed) {
				return 0;
			}

			throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
			encode(reverseOS);
			code = reverseOS.getArray();
		}

		@Override public String toString() {
			StringBuilder sb = new StringBuilder();
			appendAsString(sb, 0);
			return sb.toString();
		}

		public void appendAsString(StringBuilder sb, int indentLevel) {

			if (myInteger != null) {
				sb.append("myInteger: ").append(myInteger);
				return;
			}

			if (myBoolean != null) {
				sb.append("myBoolean: ").append(myBoolean);
				return;
			}

			sb.append("<none>");
		}

	}

	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 43);

	private byte[] code = null;
	private BerInteger untaggedInt = null;
	private BerInteger explicitlyTaggedInt = null;
	private BerInteger implicitlyTaggedInt = null;
	private UntaggedChoice untaggedChoice = null;
	private TaggedChoice taggedChoice = null;
	private BerAny taggedAny = null;
	private UntaggedChoice2 untaggedChoice2 = null;
	
	public SequenceOfDirectTypes() {
	}

	public SequenceOfDirectTypes(byte[] code) {
		this.code = code;
	}

	public void setUntaggedInt(BerInteger untaggedInt) {
		this.untaggedInt = untaggedInt;
	}

	public BerInteger getUntaggedInt() {
		return untaggedInt;
	}

	public void setExplicitlyTaggedInt(BerInteger explicitlyTaggedInt) {
		this.explicitlyTaggedInt = explicitlyTaggedInt;
	}

	public BerInteger getExplicitlyTaggedInt() {
		return explicitlyTaggedInt;
	}

	public void setImplicitlyTaggedInt(BerInteger implicitlyTaggedInt) {
		this.implicitlyTaggedInt = implicitlyTaggedInt;
	}

	public BerInteger getImplicitlyTaggedInt() {
		return implicitlyTaggedInt;
	}

	public void setUntaggedChoice(UntaggedChoice untaggedChoice) {
		this.untaggedChoice = untaggedChoice;
	}

	public UntaggedChoice getUntaggedChoice() {
		return untaggedChoice;
	}

	public void setTaggedChoice(TaggedChoice taggedChoice) {
		this.taggedChoice = taggedChoice;
	}

	public TaggedChoice getTaggedChoice() {
		return taggedChoice;
	}

	public void setTaggedAny(BerAny taggedAny) {
		this.taggedAny = taggedAny;
	}

	public BerAny getTaggedAny() {
		return taggedAny;
	}

	public void setUntaggedChoice2(UntaggedChoice2 untaggedChoice2) {
		this.untaggedChoice2 = untaggedChoice2;
	}

	public UntaggedChoice2 getUntaggedChoice2() {
		return untaggedChoice2;
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
		int sublength;

		if (untaggedChoice2 != null) {
			codeLength += untaggedChoice2.encode(reverseOS);
		}
		
		sublength = taggedAny.encode(reverseOS);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
		reverseOS.write(0xA6);
		codeLength += 1;
		
		sublength = taggedChoice.encode(reverseOS);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
		reverseOS.write(0xA5);
		codeLength += 1;
		
		codeLength += untaggedChoice.encode(reverseOS);
		
		codeLength += implicitlyTaggedInt.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 2
		reverseOS.write(0x82);
		codeLength += 1;
		
		sublength = explicitlyTaggedInt.encode(reverseOS, true);
		codeLength += sublength;
		codeLength += BerLength.encodeLength(reverseOS, sublength);
		// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
		reverseOS.write(0xA1);
		codeLength += 1;
		
		codeLength += untaggedInt.encode(reverseOS, true);
		
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
		int numDecodedBytes;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlByteCount += tag.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		tlByteCount += length.decode(is);
		int lengthVal = length.val;
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerInteger.tag)) {
			untaggedInt = new BerInteger();
			vByteCount += untaggedInt.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 1)) {
			vByteCount += length.decode(is);
			explicitlyTaggedInt = new BerInteger();
			vByteCount += explicitlyTaggedInt.decode(is, true);
			vByteCount += length.readEocIfIndefinite(is);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			implicitlyTaggedInt = new BerInteger();
			vByteCount += implicitlyTaggedInt.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		untaggedChoice = new UntaggedChoice();
		numDecodedBytes = untaggedChoice.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			vByteCount += length.decode(is);
			taggedChoice = new TaggedChoice();
			vByteCount += taggedChoice.decode(is, null);
			vByteCount += length.readEocIfIndefinite(is);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 6)) {
			vByteCount += length.decode(is);
			taggedAny = new BerAny();
			vByteCount += taggedAny.decode(is, null);
			vByteCount += length.readEocIfIndefinite(is);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match mandatory sequence component.");
		}
		
		untaggedChoice2 = new UntaggedChoice2();
		numDecodedBytes = untaggedChoice2.decode(is, berTag);
		if (numDecodedBytes != 0) {
			vByteCount += numDecodedBytes;
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			untaggedChoice2 = null;
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
		if (untaggedInt != null) {
			sb.append("untaggedInt: ").append(untaggedInt);
		}
		else {
			sb.append("untaggedInt: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (explicitlyTaggedInt != null) {
			sb.append("explicitlyTaggedInt: ").append(explicitlyTaggedInt);
		}
		else {
			sb.append("explicitlyTaggedInt: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (implicitlyTaggedInt != null) {
			sb.append("implicitlyTaggedInt: ").append(implicitlyTaggedInt);
		}
		else {
			sb.append("implicitlyTaggedInt: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (untaggedChoice != null) {
			sb.append("untaggedChoice: ");
			untaggedChoice.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("untaggedChoice: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (taggedChoice != null) {
			sb.append("taggedChoice: ");
			taggedChoice.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("taggedChoice: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (taggedAny != null) {
			sb.append("taggedAny: ").append(taggedAny);
		}
		else {
			sb.append("taggedAny: <empty-required-field>");
		}
		
		if (untaggedChoice2 != null) {
			sb.append(",\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("untaggedChoice2: ");
			untaggedChoice2.appendAsString(sb, indentLevel + 1);
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

