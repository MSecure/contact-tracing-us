package org.spongycastle.cert;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.asn1.x509.Extensions;

public class X509CertificateHolder {
    public Certificate x509Certificate;

    public X509CertificateHolder(byte[] bArr) throws IOException {
        Certificate certificate;
        try {
            ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(bArr);
            if (fromByteArray instanceof Certificate) {
                certificate = (Certificate) fromByteArray;
            } else {
                certificate = fromByteArray != null ? new Certificate(ASN1Sequence.getInstance(fromByteArray)) : null;
            }
            this.x509Certificate = certificate;
            Extensions extensions = certificate.tbsCert.extensions;
        } catch (ClassCastException e) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("malformed data: ");
            outline17.append(e.getMessage());
            throw new CertIOException(outline17.toString(), e);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("malformed data: ");
            outline172.append(e2.getMessage());
            throw new CertIOException(outline172.toString(), e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        return this.x509Certificate.equals(((X509CertificateHolder) obj).x509Certificate);
    }

    public int hashCode() {
        return this.x509Certificate.hashCode();
    }
}
