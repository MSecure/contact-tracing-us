package org.spongycastle.cert;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.x509.CertificateList;
import org.spongycastle.asn1.x509.Extension;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralName;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.IssuingDistributionPoint;

public class X509CRLHolder {
    public Extensions extensions;
    public CertificateList x509CRL;

    public X509CRLHolder(byte[] bArr) throws IOException {
        CertificateList certificateList;
        try {
            ASN1Primitive readObject = new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr), true).readObject();
            IssuingDistributionPoint issuingDistributionPoint = null;
            if (readObject instanceof CertificateList) {
                certificateList = (CertificateList) readObject;
            } else {
                certificateList = readObject != null ? new CertificateList(ASN1Sequence.getInstance(readObject)) : null;
            }
            this.x509CRL = certificateList;
            Extensions extensions2 = certificateList.tbsCertList.crlExtensions;
            this.extensions = extensions2;
            if (extensions2 != null) {
                Extension extension = (Extension) extensions2.extensions.get(Extension.issuingDistributionPoint);
                if (extension != null) {
                    try {
                        ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(extension.value.getOctets());
                        if (fromByteArray instanceof IssuingDistributionPoint) {
                            issuingDistributionPoint = (IssuingDistributionPoint) fromByteArray;
                        } else if (fromByteArray != null) {
                            issuingDistributionPoint = new IssuingDistributionPoint(ASN1Sequence.getInstance(fromByteArray));
                        }
                        boolean z = issuingDistributionPoint.indirectCRL;
                    } catch (IOException e) {
                        throw new IllegalArgumentException("can't convert extension: " + e);
                    }
                }
            }
            new GeneralNames(new GeneralName(certificateList.tbsCertList.issuer));
        } catch (ClassCastException e2) {
            StringBuilder outline15 = GeneratedOutlineSupport.outline15("malformed data: ");
            outline15.append(e2.getMessage());
            throw new CertIOException(outline15.toString(), e2);
        } catch (IllegalArgumentException e3) {
            StringBuilder outline152 = GeneratedOutlineSupport.outline15("malformed data: ");
            outline152.append(e3.getMessage());
            throw new CertIOException(outline152.toString(), e3);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CRLHolder)) {
            return false;
        }
        return this.x509CRL.equals(((X509CRLHolder) obj).x509CRL);
    }

    public int hashCode() {
        return this.x509CRL.hashCode();
    }
}
