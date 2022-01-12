package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;

public class ASN1Boolean extends ASN1Primitive {
    public static final ASN1Boolean FALSE = new ASN1Boolean(false);
    public static final byte[] FALSE_VALUE = {0};
    public static final ASN1Boolean TRUE = new ASN1Boolean(true);
    public static final byte[] TRUE_VALUE = {-1};
    public final byte[] value;

    public ASN1Boolean(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("byte value should have 1 byte in it");
        } else if (bArr[0] == 0) {
            this.value = FALSE_VALUE;
        } else if ((bArr[0] & 255) == 255) {
            this.value = TRUE_VALUE;
        } else {
            this.value = MoreExecutors.clone(bArr);
        }
    }

    public static ASN1Boolean fromOctetString(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        } else if (bArr[0] == 0) {
            return FALSE;
        } else {
            if ((bArr[0] & 255) == 255) {
                return TRUE;
            }
            return new ASN1Boolean(bArr);
        }
    }

    public static ASN1Boolean getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1Boolean)) {
            return (ASN1Boolean) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return (ASN1Boolean) ASN1Primitive.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("failed to construct boolean from byte[]: ");
                outline17.append(e.getMessage());
                throw new IllegalArgumentException(outline17.toString());
            }
        } else {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("illegal object in getInstance: ");
            outline172.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline172.toString());
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Boolean) || this.value[0] != ((ASN1Boolean) aSN1Primitive).value[0]) {
            return false;
        }
        return true;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(1, this.value);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return 3;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.value[0];
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public boolean isTrue() {
        return this.value[0] != 0;
    }

    public String toString() {
        return this.value[0] != 0 ? "TRUE" : "FALSE";
    }

    public static ASN1Boolean getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (z || (object instanceof ASN1Boolean)) {
            return getInstance(object);
        }
        return fromOctetString(((ASN1OctetString) object).getOctets());
    }

    public ASN1Boolean(boolean z) {
        this.value = z ? TRUE_VALUE : FALSE_VALUE;
    }
}
