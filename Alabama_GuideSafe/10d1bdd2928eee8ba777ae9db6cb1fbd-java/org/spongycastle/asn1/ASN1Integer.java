package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.math.BigInteger;
import org.spongycastle.util.Properties;

public class ASN1Integer extends ASN1Primitive {
    public final byte[] bytes;

    public ASN1Integer(long j) {
        this.bytes = BigInteger.valueOf(j).toByteArray();
    }

    public static ASN1Integer getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Integer)) {
            return (ASN1Integer) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Integer) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (Exception e) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("encoding error in getInstance: ")));
            }
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("illegal object in getInstance: ");
            outline17.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline17.toString());
        }
    }

    public static boolean isMalformed(byte[] bArr) {
        if (bArr.length > 1) {
            if (bArr[0] == 0 && (bArr[1] & 128) == 0) {
                return true;
            }
            return bArr[0] == -1 && (bArr[1] & 128) != 0;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Integer)) {
            return false;
        }
        return MoreExecutors.areEqual(this.bytes, ((ASN1Integer) aSN1Primitive).bytes);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(2, this.bytes);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    public BigInteger getValue() {
        return new BigInteger(this.bytes);
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getValue().toString();
    }

    public ASN1Integer(BigInteger bigInteger) {
        this.bytes = bigInteger.toByteArray();
    }

    public ASN1Integer(byte[] bArr, boolean z) {
        if (Properties.isOverrideSet("org.spongycastle.asn1.allow_unsafe_integer") || !isMalformed(bArr)) {
            this.bytes = z ? MoreExecutors.clone(bArr) : bArr;
            return;
        }
        throw new IllegalArgumentException("malformed integer");
    }
}
