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
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("malformed data: ");
            outline17.append(e.getMessage());
            throw new PKCSIOException(outline17.toString(), e);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("malformed data: ");
            outline172.append(e2.getMessage());
            throw new PKCSIOException(outline172.toString(), e2);
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
