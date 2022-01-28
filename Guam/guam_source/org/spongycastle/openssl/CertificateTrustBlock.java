package org.spongycastle.openssl;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Enumeration;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERUTF8String;

public class CertificateTrustBlock {
    public CertificateTrustBlock(byte[] bArr) {
        Enumeration objects = ASN1Sequence.getInstance(bArr).getObjects();
        while (objects.hasMoreElements()) {
            Object obj = (ASN1Encodable) objects.nextElement();
            if (obj instanceof ASN1Sequence) {
                ASN1Sequence.getInstance(obj);
            } else if (obj instanceof ASN1TaggedObject) {
                ASN1Sequence.getInstance((ASN1TaggedObject) obj, false);
            } else if (!(obj instanceof DERUTF8String)) {
                continue;
            } else {
                if (obj != null && !(obj instanceof DERUTF8String)) {
                    if (obj instanceof byte[]) {
                        try {
                            obj = ASN1Primitive.fromByteArray((byte[]) obj);
                        } catch (Exception e) {
                            throw new IllegalArgumentException(GeneratedOutlineSupport.outline3(e, GeneratedOutlineSupport.outline15("encoding error in getInstance: ")));
                        }
                    } else {
                        StringBuilder outline15 = GeneratedOutlineSupport.outline15("illegal object in getInstance: ");
                        outline15.append(obj.getClass().getName());
                        throw new IllegalArgumentException(outline15.toString());
                    }
                }
                ((DERUTF8String) obj).getString();
            }
        }
    }
}
