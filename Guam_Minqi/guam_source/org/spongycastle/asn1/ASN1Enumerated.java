package org.spongycastle.asn1;

import com.horcrux.svg.PathParser;
import java.io.IOException;
import org.spongycastle.util.Properties;

public class ASN1Enumerated extends ASN1Primitive {
    public static ASN1Enumerated[] cache = new ASN1Enumerated[12];
    public final byte[] bytes;

    public ASN1Enumerated(byte[] bArr) {
        if (Properties.isOverrideSet("org.spongycastle.asn1.allow_unsafe_integer") || !ASN1Integer.isMalformed(bArr)) {
            this.bytes = PathParser.clone(bArr);
            return;
        }
        throw new IllegalArgumentException("malformed enumerated");
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1Enumerated)) {
            return false;
        }
        return PathParser.areEqual(this.bytes, ((ASN1Enumerated) aSN1Primitive).bytes);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public void encode(ASN1OutputStream aSN1OutputStream) throws IOException {
        aSN1OutputStream.writeEncoded(10, this.bytes);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public int encodedLength() {
        return StreamUtil.calculateBodyLength(this.bytes.length) + 1 + this.bytes.length;
    }

    @Override // org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return PathParser.hashCode(this.bytes);
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    public boolean isConstructed() {
        return false;
    }
}
