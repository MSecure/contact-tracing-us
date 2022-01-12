package org.spongycastle.asn1.cms;

import org.pathcheck.covidsafepaths.BuildConfig;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;

public interface CMSObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_ri;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.data;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.signedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.envelopedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.signedAndEnvelopedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.digestedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = PKCSObjectIdentifiers.encryptedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = PKCSObjectIdentifiers.id_ct_authData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = PKCSObjectIdentifiers.id_ct_compressedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = PKCSObjectIdentifiers.id_ct_authEnvelopedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = PKCSObjectIdentifiers.id_ct_timestampedData;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.16");
        id_ri = aSN1ObjectIdentifier11;
        if (aSN1ObjectIdentifier11 != null) {
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, BuildConfig.EN_API_VERSION);
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = id_ri;
            if (aSN1ObjectIdentifier12 != null) {
                new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, "4");
                return;
            }
            throw null;
        }
        throw null;
    }
}
