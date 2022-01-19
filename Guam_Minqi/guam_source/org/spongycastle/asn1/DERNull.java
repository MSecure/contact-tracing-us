package org.spongycastle.asn1;

import java.io.IOException;

public class DERNull extends ASN1Null {
    public static final DERNull INSTANCE = new DERNull();
    public static final byte[] zeroBytes = new byte[0];

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(5, zeroBytes);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return 2;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }
}
