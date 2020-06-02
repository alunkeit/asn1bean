/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.pedefinitions;

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
import com.beanit.jasn1.ber.*;
import com.beanit.jasn1.ber.types.*;
import com.beanit.jasn1.ber.types.string.*;


public class Fcp implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public BerOctetString fileDescriptor = null;
	public BerOctetString fileID = null;
	public ApplicationIdentifier dfName = null;
	public BerOctetString lcsi = null;
	public BerOctetString securityAttributesReferenced = null;
	public BerOctetString efFileSize = null;
	public BerOctetString pinStatusTemplateDO = null;
	public BerOctetString shortEFID = null;
	public ProprietaryInfo proprietaryEFInfo = null;
	public BerOctetString linkPath = null;
	
	public Fcp() {
	}

	public Fcp(byte[] code) {
		this.code = code;
	}

	public Fcp(BerOctetString fileDescriptor, BerOctetString fileID, ApplicationIdentifier dfName, BerOctetString lcsi, BerOctetString securityAttributesReferenced, BerOctetString efFileSize, BerOctetString pinStatusTemplateDO, BerOctetString shortEFID, ProprietaryInfo proprietaryEFInfo, BerOctetString linkPath) {
		this.fileDescriptor = fileDescriptor;
		this.fileID = fileID;
		this.dfName = dfName;
		this.lcsi = lcsi;
		this.securityAttributesReferenced = securityAttributesReferenced;
		this.efFileSize = efFileSize;
		this.pinStatusTemplateDO = pinStatusTemplateDO;
		this.shortEFID = shortEFID;
		this.proprietaryEFInfo = proprietaryEFInfo;
		this.linkPath = linkPath;
	}

	public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				reverseOS.write(code[i]);
			}
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (linkPath != null) {
			codeLength += linkPath.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 7
			reverseOS.write(0xC7);
			codeLength += 1;
		}
		
		if (proprietaryEFInfo != null) {
			codeLength += proprietaryEFInfo.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			reverseOS.write(0xA5);
			codeLength += 1;
		}
		
		if (shortEFID != null) {
			codeLength += shortEFID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 8
			reverseOS.write(0x88);
			codeLength += 1;
		}
		
		if (pinStatusTemplateDO != null) {
			codeLength += pinStatusTemplateDO.encode(reverseOS, false);
			// write tag: PRIVATE_CLASS, PRIMITIVE, 6
			reverseOS.write(0xC6);
			codeLength += 1;
		}
		
		if (efFileSize != null) {
			codeLength += efFileSize.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			reverseOS.write(0x80);
			codeLength += 1;
		}
		
		if (securityAttributesReferenced != null) {
			codeLength += securityAttributesReferenced.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 11
			reverseOS.write(0x8B);
			codeLength += 1;
		}
		
		if (lcsi != null) {
			codeLength += lcsi.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 10
			reverseOS.write(0x8A);
			codeLength += 1;
		}
		
		if (dfName != null) {
			codeLength += dfName.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 4
			reverseOS.write(0x84);
			codeLength += 1;
		}
		
		if (fileID != null) {
			codeLength += fileID.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			reverseOS.write(0x83);
			codeLength += 1;
		}
		
		if (fileDescriptor != null) {
			codeLength += fileDescriptor.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			reverseOS.write(0x82);
			codeLength += 1;
		}
		
		codeLength += BerLength.encodeLength(reverseOS, codeLength);

		if (withTag) {
			codeLength += tag.encode(reverseOS);
		}

		return codeLength;

	}

	public int decode(InputStream is) throws IOException {
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
		if (lengthVal == 0) {
			return tlByteCount;
		}
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 2)) {
			fileDescriptor = new BerOctetString();
			vByteCount += fileDescriptor.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 3)) {
			fileID = new BerOctetString();
			vByteCount += fileID.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 4)) {
			dfName = new ApplicationIdentifier();
			vByteCount += dfName.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 10)) {
			lcsi = new BerOctetString();
			vByteCount += lcsi.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 11)) {
			securityAttributesReferenced = new BerOctetString();
			vByteCount += securityAttributesReferenced.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			efFileSize = new BerOctetString();
			vByteCount += efFileSize.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 6)) {
			pinStatusTemplateDO = new BerOctetString();
			vByteCount += pinStatusTemplateDO.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 8)) {
			shortEFID = new BerOctetString();
			vByteCount += shortEFID.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 5)) {
			proprietaryEFInfo = new ProprietaryInfo();
			vByteCount += proprietaryEFInfo.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		
		if (berTag.equals(BerTag.PRIVATE_CLASS, BerTag.PRIMITIVE, 7)) {
			linkPath = new BerOctetString();
			vByteCount += linkPath.decode(is, false);
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

		throw new IOException("Unexpected end of sequence, length tag: " + lengthVal + ", actual sequence length: " + vByteCount);

	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		sb.append("{");
		boolean firstSelectedElement = true;
		if (fileDescriptor != null) {
			sb.append("\n");
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("fileDescriptor: ").append(fileDescriptor);
			firstSelectedElement = false;
		}
		
		if (fileID != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("fileID: ").append(fileID);
			firstSelectedElement = false;
		}
		
		if (dfName != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("dfName: ").append(dfName);
			firstSelectedElement = false;
		}
		
		if (lcsi != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("lcsi: ").append(lcsi);
			firstSelectedElement = false;
		}
		
		if (securityAttributesReferenced != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("securityAttributesReferenced: ").append(securityAttributesReferenced);
			firstSelectedElement = false;
		}
		
		if (efFileSize != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("efFileSize: ").append(efFileSize);
			firstSelectedElement = false;
		}
		
		if (pinStatusTemplateDO != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("pinStatusTemplateDO: ").append(pinStatusTemplateDO);
			firstSelectedElement = false;
		}
		
		if (shortEFID != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("shortEFID: ").append(shortEFID);
			firstSelectedElement = false;
		}
		
		if (proprietaryEFInfo != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("proprietaryEFInfo: ");
			proprietaryEFInfo.appendAsString(sb, indentLevel + 1);
			firstSelectedElement = false;
		}
		
		if (linkPath != null) {
			if (!firstSelectedElement) {
				sb.append(",\n");
			}
			for (int i = 0; i < indentLevel + 1; i++) {
				sb.append("\t");
			}
			sb.append("linkPath: ").append(linkPath);
			firstSelectedElement = false;
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

