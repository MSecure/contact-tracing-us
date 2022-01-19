package org.spongycastle.pkcs;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.pkcs.CertificationRequest;

public class PKCS10CertificationRequest {
    public CertificationRequest certificationRequest;

    public PKCS10CertificationRequest(byte[] bArr) throws IOException {
        CertificationRequest certificationRequest2;
        try {
            ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(bArr);
            if (fromByteArray instanceof CertificationRequest) {
                certificationRequest2 = (CertificationRequest) fromByteArray;
            } else {
                certificationRequest2 = fromByteArray != null ? new CertificationRequest(ASN1Sequence.getInstance(fromByteArray)) : null;
            }
            this.certificationRequest = certificationRequest2;
        } catch (ClassCastException e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("malformed data: ");
            outline15.append(e.getMessage());
            throw new PKCSIOException(outline15.toString(), e);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("malformed data: ");
            outline152.append(e2.getMessage());
            throw new PKCSIOException(outline152.toString(), e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PKCS10CertificationRequest)) {
            return false;
        }
        return this.certificationRequest.equals(((PKCS10CertificationRequest) obj).certificationRequest);
    }

    public int hashCode() {
        return this.certificationRequest.hashCode();
    }
}
