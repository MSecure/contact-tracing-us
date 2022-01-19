package org.spongycastle.cert;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.AttributeCertificate;
import org.spongycastle.asn1.x509.Extensions;

public class X509AttributeCertificateHolder {
    public AttributeCertificate attrCert;

    public X509AttributeCertificateHolder(byte[] bArr) throws IOException {
        AttributeCertificate attributeCertificate;
        try {
            ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(bArr);
            if (fromByteArray instanceof AttributeCertificate) {
                attributeCertificate = (AttributeCertificate) fromByteArray;
            } else {
                attributeCertificate = fromByteArray != null ? new AttributeCertificate(ASN1Sequence.getInstance(fromByteArray)) : null;
            }
            this.attrCert = attributeCertificate;
            Extensions extensions = attributeCertificate.acinfo.extensions;
        } catch (ClassCastException e) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("malformed data: ");
            outline15.append(e.getMessage());
            throw new CertIOException(outline15.toString(), e);
        } catch (IllegalArgumentException e2) {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("malformed data: ");
            outline152.append(e2.getMessage());
            throw new CertIOException(outline152.toString(), e2);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509AttributeCertificateHolder)) {
            return false;
        }
        return this.attrCert.equals(((X509AttributeCertificateHolder) obj).attrCert);
    }

    public int hashCode() {
        return this.attrCert.hashCode();
    }
}
