package org.spongycastle.openssl;

import java.io.IOException;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.cert.X509CertificateHolder;

public class X509TrustedCertificateBlock {
    public X509TrustedCertificateBlock(byte[] bArr) throws IOException {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        new X509CertificateHolder(aSN1InputStream.readObject().getEncoded());
        new CertificateTrustBlock(aSN1InputStream.readObject().getEncoded());
    }
}
