package org.spongycastle.asn1;

import java.io.IOException;

public class DERBMPString extends ASN1Primitive implements ASN1String {
    public final char[] string;

    public DERBMPString(char[] cArr) {
        this.string = cArr;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERBMPString)) {
            return false;
        }
        char[] cArr = this.string;
        char[] cArr2 = ((DERBMPString) aSN1Primitive).string;
        if (cArr != cArr2) {
            if (cArr == null || cArr2 == null || cArr.length != cArr2.length) {
                return false;
            }
            for (int i = 0; i != cArr.length; i++) {
                if (cArr[i] != cArr2[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.write(30);
        aSN1OutputStream.writeLength(this.string.length * 2);
        int i = 0;
        while (true) {
            char[] cArr = this.string;
            if (i != cArr.length) {
                char c = cArr[i];
                aSN1OutputStream.write((byte) (c >> '\b'));
                aSN1OutputStream.write((byte) c);
                i++;
            } else {
                return;
            }
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return (this.string.length * 2) + StreamUtil.calculateBodyLength(this.string.length * 2) + 1;
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return new String(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        char[] cArr = this.string;
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
