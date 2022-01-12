package org.spongycastle.asn1.x9;

import okhttp3.internal.cache.DiskLruCache;
import org.pathcheck.covidsafepaths.BuildConfig;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface X9ObjectIdentifiers {
    public static final ASN1ObjectIdentifier ansi_X9_42;
    public static final ASN1ObjectIdentifier ansi_X9_62;
    public static final ASN1ObjectIdentifier cTwoCurve;
    public static final ASN1ObjectIdentifier characteristic_two_field;
    public static final ASN1ObjectIdentifier ecdsa_with_SHA2;
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier id_dsa = new ASN1ObjectIdentifier("1.2.840.10040.4.1");
    public static final ASN1ObjectIdentifier id_ecPublicKey;
    public static final ASN1ObjectIdentifier id_ecSigType;
    public static final ASN1ObjectIdentifier id_fieldType;
    public static final ASN1ObjectIdentifier id_publicKeyType;
    public static final ASN1ObjectIdentifier ppBasis;
    public static final ASN1ObjectIdentifier primeCurve;
    public static final ASN1ObjectIdentifier prime_field;
    public static final ASN1ObjectIdentifier tpBasis;
    public static final ASN1ObjectIdentifier x9_42_schemes;
    public static final ASN1ObjectIdentifier x9_44;
    public static final ASN1ObjectIdentifier x9_44_components;
    public static final ASN1ObjectIdentifier x9_63_scheme;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.2.840.10045");
        ansi_X9_62 = aSN1ObjectIdentifier;
        if (aSN1ObjectIdentifier != null) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier, DiskLruCache.VERSION_1);
            id_fieldType = aSN1ObjectIdentifier2;
            if (aSN1ObjectIdentifier2 != null) {
                prime_field = new ASN1ObjectIdentifier(aSN1ObjectIdentifier2, DiskLruCache.VERSION_1);
                ASN1ObjectIdentifier aSN1ObjectIdentifier3 = id_fieldType;
                if (aSN1ObjectIdentifier3 != null) {
                    ASN1ObjectIdentifier aSN1ObjectIdentifier4 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier3, BuildConfig.EN_API_VERSION);
                    characteristic_two_field = aSN1ObjectIdentifier4;
                    if (aSN1ObjectIdentifier4 != null) {
                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier4, "3.1");
                        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = characteristic_two_field;
                        if (aSN1ObjectIdentifier5 != null) {
                            tpBasis = new ASN1ObjectIdentifier(aSN1ObjectIdentifier5, "3.2");
                            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = characteristic_two_field;
                            if (aSN1ObjectIdentifier6 != null) {
                                ppBasis = new ASN1ObjectIdentifier(aSN1ObjectIdentifier6, "3.3");
                                ASN1ObjectIdentifier aSN1ObjectIdentifier7 = ansi_X9_62;
                                if (aSN1ObjectIdentifier7 != null) {
                                    ASN1ObjectIdentifier aSN1ObjectIdentifier8 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier7, "4");
                                    id_ecSigType = aSN1ObjectIdentifier8;
                                    if (aSN1ObjectIdentifier8 != null) {
                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier8, DiskLruCache.VERSION_1);
                                        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = ansi_X9_62;
                                        if (aSN1ObjectIdentifier9 != null) {
                                            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier9, BuildConfig.EN_API_VERSION);
                                            id_publicKeyType = aSN1ObjectIdentifier10;
                                            if (aSN1ObjectIdentifier10 != null) {
                                                id_ecPublicKey = new ASN1ObjectIdentifier(aSN1ObjectIdentifier10, DiskLruCache.VERSION_1);
                                                ASN1ObjectIdentifier aSN1ObjectIdentifier11 = id_ecSigType;
                                                if (aSN1ObjectIdentifier11 != null) {
                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier12 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier11, BuildConfig.MATOMO_SITE_ID);
                                                    ecdsa_with_SHA2 = aSN1ObjectIdentifier12;
                                                    if (aSN1ObjectIdentifier12 != null) {
                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier12, DiskLruCache.VERSION_1);
                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = ecdsa_with_SHA2;
                                                        if (aSN1ObjectIdentifier13 != null) {
                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier13, BuildConfig.EN_API_VERSION);
                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = ecdsa_with_SHA2;
                                                            if (aSN1ObjectIdentifier14 != null) {
                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier14, BuildConfig.MATOMO_SITE_ID);
                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier15 = ecdsa_with_SHA2;
                                                                if (aSN1ObjectIdentifier15 != null) {
                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier15, "4");
                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier16 = ansi_X9_62;
                                                                    if (aSN1ObjectIdentifier16 != null) {
                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier16, BuildConfig.MATOMO_SITE_ID);
                                                                        ellipticCurve = aSN1ObjectIdentifier17;
                                                                        if (aSN1ObjectIdentifier17 != null) {
                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier17, "0");
                                                                            cTwoCurve = aSN1ObjectIdentifier18;
                                                                            if (aSN1ObjectIdentifier18 != null) {
                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier18, DiskLruCache.VERSION_1);
                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier19 = cTwoCurve;
                                                                                if (aSN1ObjectIdentifier19 != null) {
                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier19, BuildConfig.EN_API_VERSION);
                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier20 = cTwoCurve;
                                                                                    if (aSN1ObjectIdentifier20 != null) {
                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier20, BuildConfig.MATOMO_SITE_ID);
                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = cTwoCurve;
                                                                                        if (aSN1ObjectIdentifier21 != null) {
                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier21, "4");
                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = cTwoCurve;
                                                                                            if (aSN1ObjectIdentifier22 != null) {
                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier22, "5");
                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier23 = cTwoCurve;
                                                                                                if (aSN1ObjectIdentifier23 != null) {
                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier23, "6");
                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier24 = cTwoCurve;
                                                                                                    if (aSN1ObjectIdentifier24 != null) {
                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier24, "7");
                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = cTwoCurve;
                                                                                                        if (aSN1ObjectIdentifier25 != null) {
                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier25, "8");
                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier26 = cTwoCurve;
                                                                                                            if (aSN1ObjectIdentifier26 != null) {
                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier26, "9");
                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier27 = cTwoCurve;
                                                                                                                if (aSN1ObjectIdentifier27 != null) {
                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier27, "10");
                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier28 = cTwoCurve;
                                                                                                                    if (aSN1ObjectIdentifier28 != null) {
                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier28, "11");
                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = cTwoCurve;
                                                                                                                        if (aSN1ObjectIdentifier29 != null) {
                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier29, "12");
                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier30 = cTwoCurve;
                                                                                                                            if (aSN1ObjectIdentifier30 != null) {
                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier30, "13");
                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier31 = cTwoCurve;
                                                                                                                                if (aSN1ObjectIdentifier31 != null) {
                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier31, "14");
                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier32 = cTwoCurve;
                                                                                                                                    if (aSN1ObjectIdentifier32 != null) {
                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier32, "15");
                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = cTwoCurve;
                                                                                                                                        if (aSN1ObjectIdentifier33 != null) {
                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier33, "16");
                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier34 = cTwoCurve;
                                                                                                                                            if (aSN1ObjectIdentifier34 != null) {
                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier34, "17");
                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier35 = cTwoCurve;
                                                                                                                                                if (aSN1ObjectIdentifier35 != null) {
                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier35, "18");
                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier36 = cTwoCurve;
                                                                                                                                                    if (aSN1ObjectIdentifier36 != null) {
                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier36, "19");
                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier37 = cTwoCurve;
                                                                                                                                                        if (aSN1ObjectIdentifier37 != null) {
                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier37, "20");
                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier38 = ellipticCurve;
                                                                                                                                                            if (aSN1ObjectIdentifier38 != null) {
                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier39 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier38, DiskLruCache.VERSION_1);
                                                                                                                                                                primeCurve = aSN1ObjectIdentifier39;
                                                                                                                                                                if (aSN1ObjectIdentifier39 != null) {
                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier39, DiskLruCache.VERSION_1);
                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier40 = primeCurve;
                                                                                                                                                                    if (aSN1ObjectIdentifier40 != null) {
                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier40, BuildConfig.EN_API_VERSION);
                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier41 = primeCurve;
                                                                                                                                                                        if (aSN1ObjectIdentifier41 != null) {
                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier41, BuildConfig.MATOMO_SITE_ID);
                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier42 = primeCurve;
                                                                                                                                                                            if (aSN1ObjectIdentifier42 != null) {
                                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier42, "4");
                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier43 = primeCurve;
                                                                                                                                                                                if (aSN1ObjectIdentifier43 != null) {
                                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier43, "5");
                                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier44 = primeCurve;
                                                                                                                                                                                    if (aSN1ObjectIdentifier44 != null) {
                                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier44, "6");
                                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier45 = primeCurve;
                                                                                                                                                                                        if (aSN1ObjectIdentifier45 != null) {
                                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier45, "7");
                                                                                                                                                                                            new ASN1ObjectIdentifier("1.2.840.10040.4.3");
                                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier46 = new ASN1ObjectIdentifier("1.3.133.16.840.63.0");
                                                                                                                                                                                            x9_63_scheme = aSN1ObjectIdentifier46;
                                                                                                                                                                                            if (aSN1ObjectIdentifier46 != null) {
                                                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier46, BuildConfig.EN_API_VERSION);
                                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier47 = x9_63_scheme;
                                                                                                                                                                                                if (aSN1ObjectIdentifier47 != null) {
                                                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier47, BuildConfig.MATOMO_SITE_ID);
                                                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier48 = x9_63_scheme;
                                                                                                                                                                                                    if (aSN1ObjectIdentifier48 != null) {
                                                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier48, "16");
                                                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier49 = new ASN1ObjectIdentifier("1.2.840.10046");
                                                                                                                                                                                                        ansi_X9_42 = aSN1ObjectIdentifier49;
                                                                                                                                                                                                        if (aSN1ObjectIdentifier49 != null) {
                                                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier49, "2.1");
                                                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier50 = ansi_X9_42;
                                                                                                                                                                                                            if (aSN1ObjectIdentifier50 != null) {
                                                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier51 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier50, BuildConfig.MATOMO_SITE_ID);
                                                                                                                                                                                                                x9_42_schemes = aSN1ObjectIdentifier51;
                                                                                                                                                                                                                if (aSN1ObjectIdentifier51 != null) {
                                                                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier51, DiskLruCache.VERSION_1);
                                                                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier52 = x9_42_schemes;
                                                                                                                                                                                                                    if (aSN1ObjectIdentifier52 != null) {
                                                                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier52, BuildConfig.EN_API_VERSION);
                                                                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier53 = x9_42_schemes;
                                                                                                                                                                                                                        if (aSN1ObjectIdentifier53 != null) {
                                                                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier53, BuildConfig.MATOMO_SITE_ID);
                                                                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier54 = x9_42_schemes;
                                                                                                                                                                                                                            if (aSN1ObjectIdentifier54 != null) {
                                                                                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier54, "4");
                                                                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier55 = x9_42_schemes;
                                                                                                                                                                                                                                if (aSN1ObjectIdentifier55 != null) {
                                                                                                                                                                                                                                    new ASN1ObjectIdentifier(aSN1ObjectIdentifier55, "5");
                                                                                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier56 = x9_42_schemes;
                                                                                                                                                                                                                                    if (aSN1ObjectIdentifier56 != null) {
                                                                                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier56, "6");
                                                                                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier57 = x9_42_schemes;
                                                                                                                                                                                                                                        if (aSN1ObjectIdentifier57 != null) {
                                                                                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier57, "7");
                                                                                                                                                                                                                                            ASN1ObjectIdentifier aSN1ObjectIdentifier58 = x9_42_schemes;
                                                                                                                                                                                                                                            if (aSN1ObjectIdentifier58 != null) {
                                                                                                                                                                                                                                                new ASN1ObjectIdentifier(aSN1ObjectIdentifier58, "8");
                                                                                                                                                                                                                                                ASN1ObjectIdentifier aSN1ObjectIdentifier59 = new ASN1ObjectIdentifier("1.3.133.16.840.9.44");
                                                                                                                                                                                                                                                x9_44 = aSN1ObjectIdentifier59;
                                                                                                                                                                                                                                                if (aSN1ObjectIdentifier59 != null) {
                                                                                                                                                                                                                                                    ASN1ObjectIdentifier aSN1ObjectIdentifier60 = new ASN1ObjectIdentifier(aSN1ObjectIdentifier59, DiskLruCache.VERSION_1);
                                                                                                                                                                                                                                                    x9_44_components = aSN1ObjectIdentifier60;
                                                                                                                                                                                                                                                    if (aSN1ObjectIdentifier60 != null) {
                                                                                                                                                                                                                                                        new ASN1ObjectIdentifier(aSN1ObjectIdentifier60, DiskLruCache.VERSION_1);
                                                                                                                                                                                                                                                        ASN1ObjectIdentifier aSN1ObjectIdentifier61 = x9_44_components;
                                                                                                                                                                                                                                                        if (aSN1ObjectIdentifier61 != null) {
                                                                                                                                                                                                                                                            new ASN1ObjectIdentifier(aSN1ObjectIdentifier61, BuildConfig.EN_API_VERSION);
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
                                                                                                                                                                                                                                        throw null;
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    throw null;
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                throw null;
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            throw null;
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                        throw null;
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    throw null;
                                                                                                                                                                                                                }
                                                                                                                                                                                                                throw null;
                                                                                                                                                                                                            }
                                                                                                                                                                                                            throw null;
                                                                                                                                                                                                        }
                                                                                                                                                                                                        throw null;
                                                                                                                                                                                                    }
                                                                                                                                                                                                    throw null;
                                                                                                                                                                                                }
                                                                                                                                                                                                throw null;
                                                                                                                                                                                            }
                                                                                                                                                                                            throw null;
                                                                                                                                                                                        }
                                                                                                                                                                                        throw null;
                                                                                                                                                                                    }
                                                                                                                                                                                    throw null;
                                                                                                                                                                                }
                                                                                                                                                                                throw null;
                                                                                                                                                                            }
                                                                                                                                                                            throw null;
                                                                                                                                                                        }
                                                                                                                                                                        throw null;
                                                                                                                                                                    }
                                                                                                                                                                    throw null;
                                                                                                                                                                }
                                                                                                                                                                throw null;
                                                                                                                                                            }
                                                                                                                                                            throw null;
                                                                                                                                                        }
                                                                                                                                                        throw null;
                                                                                                                                                    }
                                                                                                                                                    throw null;
                                                                                                                                                }
                                                                                                                                                throw null;
                                                                                                                                            }
                                                                                                                                            throw null;
                                                                                                                                        }
                                                                                                                                        throw null;
                                                                                                                                    }
                                                                                                                                    throw null;
                                                                                                                                }
                                                                                                                                throw null;
                                                                                                                            }
                                                                                                                            throw null;
                                                                                                                        }
                                                                                                                        throw null;
                                                                                                                    }
                                                                                                                    throw null;
                                                                                                                }
                                                                                                                throw null;
                                                                                                            }
                                                                                                            throw null;
                                                                                                        }
                                                                                                        throw null;
                                                                                                    }
                                                                                                    throw null;
                                                                                                }
                                                                                                throw null;
                                                                                            }
                                                                                            throw null;
                                                                                        }
                                                                                        throw null;
                                                                                    }
                                                                                    throw null;
                                                                                }
                                                                                throw null;
                                                                            }
                                                                            throw null;
                                                                        }
                                                                        throw null;
                                                                    }
                                                                    throw null;
                                                                }
                                                                throw null;
                                                            }
                                                            throw null;
                                                        }
                                                        throw null;
                                                    }
                                                    throw null;
                                                }
                                                throw null;
                                            }
                                            throw null;
                                        }
                                        throw null;
                                    }
                                    throw null;
                                }
                                throw null;
                            }
                            throw null;
                        }
                        throw null;
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
