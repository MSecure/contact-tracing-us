package org.spongycastle.asn1.x9;

import com.google.common.util.concurrent.MoreExecutors;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.math.ec.ECCurve;

public class X9ECPoint extends ASN1Object {
    public final ASN1OctetString encoding;

    public X9ECPoint(ECCurve eCCurve, ASN1OctetString aSN1OctetString) {
        this.encoding = new DEROctetString(MoreExecutors.clone(aSN1OctetString.getOctets()));
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.encoding;
    }
}
