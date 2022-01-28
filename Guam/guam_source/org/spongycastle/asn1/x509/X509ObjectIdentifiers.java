package org.spongycastle.asn1.x509;

import com.android.tools.r8.GeneratedOutlineSupport;
import okhttp3.internal.cache.DiskLruCache;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface X509ObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_ad;
    public static final ASN1ObjectIdentifier id_ad_caIssuers;
    public static final ASN1ObjectIdentifier id_ad_ocsp;
    public static final ASN1ObjectIdentifier id_at_name = GeneratedOutlineSupport.outline19("2.5.4.41");
    public static final ASN1ObjectIdentifier id_at_organizationIdentifier = GeneratedOutlineSupport.outline19("2.5.4.97");
    public static final ASN1ObjectIdentifier id_at_telephoneNumber = new ASN1ObjectIdentifier("2.5.4.20").intern();
    public static final ASN1ObjectIdentifier id_pkix;

    static {
        new ASN1ObjectIdentifier("2.5.4.3").intern();
        new ASN1ObjectIdentifier("2.5.4.6").intern();
        new ASN1ObjectIdentifier("2.5.4.7").intern();
        new ASN1ObjectIdentifier("2.5.4.8").intern();
        new ASN1ObjectIdentifier("2.5.4.10").intern();
        new ASN1ObjectIdentifier("2.5.4.11").intern();
        new ASN1ObjectIdentifier("1.3.14.3.2.26").intern();
        new ASN1ObjectIdentifier("1.3.36.3.2.1").intern();
        new ASN1ObjectIdentifier("1.3.36.3.3.1.2").intern();
        new ASN1ObjectIdentifier("2.5.8.1.1").intern();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
        id_pkix = aSN1ObjectIdentifier;
        if (aSN1ObjectIdentifier != null) {
            new ASN1ObjectIdentifier(aSN1ObjectIdentifier, DiskLruCache.VERSION_1);
            new ASN1ObjectIdentifier("2.5.29");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = id_pkix;
            if (aSN1ObjectIdentifier2 != null) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, "48");
                id_ad = aSN1ObjectIdentifier3;
                if (aSN1ObjectIdentifier3 != null) {
                    id_ad_caIssuers = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, BuildConfig.EN_API_VERSION).intern();
                    ASN1ObjectIdentifier aSN1ObjectIdentifier4 = id_ad;
                    if (aSN1ObjectIdentifier4 != null) {
                        id_ad_ocsp = new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, DiskLruCache.VERSION_1).intern();
                        return;
                    }
                    throw null;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }
}
