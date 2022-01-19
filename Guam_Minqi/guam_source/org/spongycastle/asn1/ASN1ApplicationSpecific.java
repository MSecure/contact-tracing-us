package org.spongycastle.asn1;

import com.horcrux.svg.PathParser;
import java.io.IOException;

public abstract class ASN1ApplicationSpecific extends ASN1Primitive {
    public final boolean isConstructed;
    public final byte[] octets;
    public final int tag;

    public ASN1ApplicationSpecific(boolean z, int i, byte[] bArr) {
        this.isConstructed = z;
        this.tag = i;
        this.octets = PathParser.clone(bArr);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1ApplicationSpecific)) {
            return false;
        }
        ASN1ApplicationSpecific aSN1ApplicationSpecific = (ASN1ApplicationSpecific) aSN1Primitive;
        if (this.isConstructed == aSN1ApplicationSpecific.isConstructed && this.tag == aSN1ApplicationSpecific.tag && PathParser.areEqual(this.octets, aSN1ApplicationSpecific.octets)) {
            return true;
        }
        return false;
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(this.isConstructed ? 96 : 64, this.tag, this.octets);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() throws IOException {
        return StreamUtil.calculateBodyLength(this.octets.length) + StreamUtil.calculateTagLength(this.tag) + this.octets.length;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        boolean z = this.isConstructed;
        return ((z ? 1 : 0) ^ this.tag) ^ PathParser.hashCode(this.octets);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return this.isConstructed;
    }
}
