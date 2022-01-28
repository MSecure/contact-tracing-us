package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ASN1ObjectIdentifier extends ASN1Primitive {
    public static final ConcurrentMap<OidHandle, ASN1ObjectIdentifier> pool = new ConcurrentHashMap();
    public byte[] body;
    public final String identifier;

    public static class OidHandle {
        public final byte[] enc;
        public final int key;

        public OidHandle(byte[] bArr) {
            this.key = PathParser.hashCode(bArr);
            this.enc = bArr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof OidHandle) {
                return PathParser.areEqual(this.enc, ((OidHandle) obj).enc);
            }
            return false;
        }

        public int hashCode() {
            return this.key;
        }
    }

    public ASN1ObjectIdentifier(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        boolean z = true;
        long j = 0;
        BigInteger bigInteger = null;
        for (int i = 0; i != bArr.length; i++) {
            int i2 = bArr[i] & 255;
            if (j <= 72057594037927808L) {
                long j2 = j + ((long) (i2 & 127));
                if ((i2 & 128) == 0) {
                    if (z) {
                        if (j2 < 40) {
                            stringBuffer.append('0');
                        } else if (j2 < 80) {
                            stringBuffer.append('1');
                            j2 -= 40;
                        } else {
                            stringBuffer.append('2');
                            j2 -= 80;
                        }
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(j2);
                    j = 0;
                } else {
                    j = j2 << 7;
                }
            } else {
                BigInteger or = (bigInteger == null ? BigInteger.valueOf(j) : bigInteger).or(BigInteger.valueOf((long) (i2 & 127)));
                if ((i2 & 128) == 0) {
                    if (z) {
                        stringBuffer.append('2');
                        or = or.subtract(BigInteger.valueOf(80));
                        z = false;
                    }
                    stringBuffer.append('.');
                    stringBuffer.append(or);
                    j = 0;
                    bigInteger = null;
                } else {
                    bigInteger = or.shiftLeft(7);
                }
            }
        }
        this.identifier = stringBuffer.toString();
        this.body = PathParser.clone(bArr);
    }

    public static ASN1ObjectIdentifier fromOctetString(byte[] bArr) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = pool.get(new OidHandle(bArr));
        return aSN1ObjectIdentifier == null ? new ASN1ObjectIdentifier(bArr) : aSN1ObjectIdentifier;
    }

    public static ASN1ObjectIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ObjectIdentifier)) {
            return (ASN1ObjectIdentifier) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) obj;
            if (aSN1Encodable.toASN1Primitive() instanceof ASN1ObjectIdentifier) {
                return (ASN1ObjectIdentifier) aSN1Encodable.toASN1Primitive();
            }
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1ObjectIdentifier) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("failed to construct object identifier from byte[]: ");
                outline15.append(e.getMessage());
                throw new IllegalArgumentException(outline15.toString());
            }
        } else {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("illegal object in getInstance: ");
            outline152.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline152.toString());
        }
    }

    public static boolean isValidBranchID(String str, int i) {
        boolean z;
        char charAt;
        int length = str.length();
        do {
            z = false;
            while (true) {
                length--;
                if (length < i) {
                    return z;
                }
                charAt = str.charAt(length);
                if ('0' <= charAt && charAt <= '9') {
                    z = true;
                }
            }
            if (charAt != '.') {
                break;
            }
        } while (z);
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive == this) {
            return true;
        }
        if (!(aSN1Primitive instanceof ASN1ObjectIdentifier)) {
            return false;
        }
        return this.identifier.equals(((ASN1ObjectIdentifier) aSN1Primitive).identifier);
    }

    public final void doOutput(ByteArrayOutputStream byteArrayOutputStream) {
        int i;
        String str;
        int i2;
        String str2;
        String str3;
        String str4 = this.identifier;
        int indexOf = str4.indexOf(46, 0);
        if (indexOf == -1) {
            str = str4.substring(0);
            i = -1;
        } else {
            i = indexOf + 1;
            str = str4.substring(0, indexOf);
        }
        int parseInt = Integer.parseInt(str) * 40;
        if (i == -1) {
            i2 = i;
            str2 = null;
        } else {
            int indexOf2 = str4.indexOf(46, i);
            if (indexOf2 == -1) {
                str2 = str4.substring(i);
                i2 = -1;
            } else {
                str2 = str4.substring(i, indexOf2);
                i2 = indexOf2 + 1;
            }
        }
        if (str2.length() <= 18) {
            writeField(byteArrayOutputStream, ((long) parseInt) + Long.parseLong(str2));
        } else {
            writeField(byteArrayOutputStream, new BigInteger(str2).add(BigInteger.valueOf((long) parseInt)));
        }
        while (true) {
            if (i2 != -1) {
                if (i2 == -1) {
                    str3 = null;
                } else {
                    int indexOf3 = str4.indexOf(46, i2);
                    if (indexOf3 == -1) {
                        str3 = str4.substring(i2);
                        i2 = -1;
                    } else {
                        String substring = str4.substring(i2, indexOf3);
                        i2 = indexOf3 + 1;
                        str3 = substring;
                    }
                }
                if (str3.length() <= 18) {
                    writeField(byteArrayOutputStream, Long.parseLong(str3));
                } else {
                    writeField(byteArrayOutputStream, new BigInteger(str3));
                }
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        byte[] body2 = getBody();
        aSN1OutputStream.write(6);
        aSN1OutputStream.writeLength(body2.length);
        aSN1OutputStream.os.write(body2);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        int length = getBody().length;
        return StreamUtil.calculateBodyLength(length) + 1 + length;
    }

    public final synchronized byte[] getBody() {
        if (this.body == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            doOutput(byteArrayOutputStream);
            this.body = byteArrayOutputStream.toByteArray();
        }
        return this.body;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.identifier.hashCode();
    }

    public ASN1ObjectIdentifier intern() {
        OidHandle oidHandle = new OidHandle(getBody());
        ASN1ObjectIdentifier aSN1ObjectIdentifier = pool.get(oidHandle);
        if (aSN1ObjectIdentifier != null) {
            return aSN1ObjectIdentifier;
        }
        ASN1ObjectIdentifier putIfAbsent = pool.putIfAbsent(oidHandle, this);
        return putIfAbsent == null ? this : putIfAbsent;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return this.identifier;
    }

    public final void writeField(ByteArrayOutputStream byteArrayOutputStream, long j) {
        byte[] bArr = new byte[9];
        int i = 8;
        bArr[8] = (byte) (((int) j) & 127);
        while (j >= 128) {
            j >>= 7;
            i--;
            bArr[i] = (byte) ((((int) j) & 127) | 128);
        }
        byteArrayOutputStream.write(bArr, i, 9 - i);
    }

    public final void writeField(ByteArrayOutputStream byteArrayOutputStream, BigInteger bigInteger) {
        int bitLength = (bigInteger.bitLength() + 6) / 7;
        if (bitLength == 0) {
            byteArrayOutputStream.write(0);
            return;
        }
        byte[] bArr = new byte[bitLength];
        int i = bitLength - 1;
        for (int i2 = i; i2 >= 0; i2--) {
            bArr[i2] = (byte) ((bigInteger.intValue() & 127) | 128);
            bigInteger = bigInteger.shiftRight(7);
        }
        bArr[i] = (byte) (bArr[i] & Byte.MAX_VALUE);
        byteArrayOutputStream.write(bArr, 0, bitLength);
    }

    public static ASN1ObjectIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1ObjectIdentifier)) {
            return getInstance(object);
        }
        byte[] octets = ASN1OctetString.getInstance(aSN1TaggedObject.getObject()).getOctets();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = pool.get(new OidHandle(octets));
        return aSN1ObjectIdentifier == null ? new ASN1ObjectIdentifier(octets) : aSN1ObjectIdentifier;
    }

    public ASN1ObjectIdentifier(String str) {
        char charAt;
        boolean z = false;
        if (str.length() >= 3 && str.charAt(1) == '.' && (charAt = str.charAt(0)) >= '0' && charAt <= '2') {
            z = isValidBranchID(str, 2);
        }
        if (z) {
            this.identifier = str;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline9("string ", str, " not an OID"));
    }

    public ASN1ObjectIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        if (isValidBranchID(str, 0)) {
            this.identifier = aSN1ObjectIdentifier.identifier + "." + str;
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline9("string ", str, " not a valid OID branch"));
    }
}
