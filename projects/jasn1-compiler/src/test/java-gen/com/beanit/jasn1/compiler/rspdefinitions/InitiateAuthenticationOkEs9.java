/**
 * This class file was automatically generated by jASN1 (http://www.beanit.com)
 */

package com.beanit.jasn1.compiler.rspdefinitions;

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

import com.beanit.jasn1.compiler.pkix1explicit88.Certificate;
import com.beanit.jasn1.compiler.pkix1explicit88.CertificateList;
import com.beanit.jasn1.compiler.pkix1explicit88.Time;
import com.beanit.jasn1.compiler.pkix1implicit88.SubjectKeyIdentifier;

public class InitiateAuthenticationOkEs9 implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	public static final BerTag tag = new BerTag(BerTag.UNIVERSAL_CLASS, BerTag.CONSTRUCTED, 16);

	public byte[] code = null;
	public TransactionId transactionId = null;
	public ServerSigned1 serverSigned1 = null;
	public BerOctetString serverSignature1 = null;
	public SubjectKeyIdentifier euiccCiPKIdToBeUsed = null;
	public Certificate serverCertificate = null;
	
	public InitiateAuthenticationOkEs9() {
	}

	public InitiateAuthenticationOkEs9(byte[] code) {
		this.code = code;
	}

	public InitiateAuthenticationOkEs9(TransactionId transactionId, ServerSigned1 serverSigned1, BerOctetString serverSignature1, SubjectKeyIdentifier euiccCiPKIdToBeUsed, Certificate serverCertificate) {
		this.transactionId = transactionId;
		this.serverSigned1 = serverSigned1;
		this.serverSignature1 = serverSignature1;
		this.euiccCiPKIdToBeUsed = euiccCiPKIdToBeUsed;
		this.serverCertificate = serverCertificate;
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
		codeLength += serverCertificate.encode(reverseOS, true);
		
		codeLength += euiccCiPKIdToBeUsed.encode(reverseOS, true);
		
		codeLength += serverSignature1.encode(reverseOS, false);
		// write tag: APPLICATION_CLASS, PRIMITIVE, 55
		reverseOS.write(0x37);
		reverseOS.write(0x5F);
		codeLength += 2;
		
		codeLength += serverSigned1.encode(reverseOS, true);
		
		codeLength += transactionId.encode(reverseOS, false);
		// write tag: CONTEXT_CLASS, PRIMITIVE, 0
		reverseOS.write(0x80);
		codeLength += 1;
		
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
		vByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 0)) {
			transactionId = new TransactionId();
			vByteCount += transactionId.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(ServerSigned1.tag)) {
			serverSigned1 = new ServerSigned1();
			vByteCount += serverSigned1.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(BerTag.APPLICATION_CLASS, BerTag.PRIMITIVE, 55)) {
			serverSignature1 = new BerOctetString();
			vByteCount += serverSignature1.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(SubjectKeyIdentifier.tag)) {
			euiccCiPKIdToBeUsed = new SubjectKeyIdentifier();
			vByteCount += euiccCiPKIdToBeUsed.decode(is, false);
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
		}
		
		if (berTag.equals(Certificate.tag)) {
			serverCertificate = new Certificate();
			vByteCount += serverCertificate.decode(is, false);
			if (lengthVal >= 0 && vByteCount == lengthVal) {
				return tlByteCount + vByteCount;
			}
			vByteCount += berTag.decode(is);
		}
		else {
			throw new IOException("Tag does not match the mandatory sequence element tag.");
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
		sb.append("\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (transactionId != null) {
			sb.append("transactionId: ").append(transactionId);
		}
		else {
			sb.append("transactionId: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverSigned1 != null) {
			sb.append("serverSigned1: ");
			serverSigned1.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("serverSigned1: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverSignature1 != null) {
			sb.append("serverSignature1: ").append(serverSignature1);
		}
		else {
			sb.append("serverSignature1: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (euiccCiPKIdToBeUsed != null) {
			sb.append("euiccCiPKIdToBeUsed: ").append(euiccCiPKIdToBeUsed);
		}
		else {
			sb.append("euiccCiPKIdToBeUsed: <empty-required-field>");
		}
		
		sb.append(",\n");
		for (int i = 0; i < indentLevel + 1; i++) {
			sb.append("\t");
		}
		if (serverCertificate != null) {
			sb.append("serverCertificate: ");
			serverCertificate.appendAsString(sb, indentLevel + 1);
		}
		else {
			sb.append("serverCertificate: <empty-required-field>");
		}
		
		sb.append("\n");
		for (int i = 0; i < indentLevel; i++) {
			sb.append("\t");
		}
		sb.append("}");
	}

}

