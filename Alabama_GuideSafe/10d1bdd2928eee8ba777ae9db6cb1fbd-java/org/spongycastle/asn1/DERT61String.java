package org.spongycastle.asn1;

import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import org.spongycastle.util.Strings;

public class DERT61String extends ASN1Primitive implements ASN1String {
    public byte[] string;

    public DERT61String(byte[] bArr) {
        this.string = MoreExecutors.clone(bArr);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof DERT61String)) {
            return false;
        }
        return MoreExecutors.areEqual(this.string, ((DERT61String) aSN1Primitive).string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(20, this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.string.length) + 1 + this.string.length;
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        return Strings.fromByteArray(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return MoreExecutors.hashCode(this.string);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }

    public String toString() {
        return getString();
    }
}
