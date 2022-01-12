package org.spongycastle.openssl;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.pkcs.RSAPublicKey;
import org.spongycastle.asn1.sec.ECPrivateKey;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.asn1.x509.DSAParameter;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.asn1.x9.X9ECParameters;
import org.spongycastle.asn1.x9.X9ObjectIdentifiers;
import org.spongycastle.cert.X509AttributeCertificateHolder;
import org.spongycastle.cert.X509CRLHolder;
import org.spongycastle.cert.X509CertificateHolder;
import org.spongycastle.pkcs.PKCS10CertificationRequest;
import org.spongycastle.pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.spongycastle.util.encoders.Hex;
import org.spongycastle.util.io.pem.PemHeader;
import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemObjectParser;
import org.spongycastle.util.io.pem.PemReader;

public class PEMParser extends PemReader {
    public final Map parsers;

    public class DSAKeyPairParser implements PEMKeyPairParser {
        public DSAKeyPairParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.openssl.PEMKeyPairParser
        public PEMKeyPair parse(byte[] bArr) throws IOException {
            try {
                ASN1Sequence instance = ASN1Sequence.getInstance(bArr);
                if (instance.size() == 6) {
                    ASN1Integer instance2 = ASN1Integer.getInstance(instance.getObjectAt(1));
                    ASN1Integer instance3 = ASN1Integer.getInstance(instance.getObjectAt(2));
                    ASN1Integer instance4 = ASN1Integer.getInstance(instance.getObjectAt(3));
                    return new PEMKeyPair(new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(instance2.getValue(), instance3.getValue(), instance4.getValue())), ASN1Integer.getInstance(instance.getObjectAt(4))), new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_dsa, new DSAParameter(instance2.getValue(), instance3.getValue(), instance4.getValue())), ASN1Integer.getInstance(instance.getObjectAt(5))));
                }
                throw new PEMException("malformed sequence in DSA private key");
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e2, GeneratedOutlineSupport.outline17("problem creating DSA private key: ")), e2);
            }
        }
    }

    public class ECCurveParamsParser implements PemObjectParser {
        public ECCurveParamsParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                ASN1Primitive fromByteArray = ASN1Primitive.fromByteArray(pemObject.content);
                if (fromByteArray instanceof ASN1ObjectIdentifier) {
                    return ASN1Primitive.fromByteArray(pemObject.content);
                }
                if (fromByteArray instanceof ASN1Sequence) {
                    return X9ECParameters.getInstance(fromByteArray);
                }
                return null;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e2, GeneratedOutlineSupport.outline17("exception extracting EC named curve: ")));
            }
        }
    }

    public class ECDSAKeyPairParser implements PEMKeyPairParser {
        public ECDSAKeyPairParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.openssl.PEMKeyPairParser
        public PEMKeyPair parse(byte[] bArr) throws IOException {
            ECPrivateKey eCPrivateKey;
            try {
                ASN1Sequence instance = ASN1Sequence.getInstance(bArr);
                if (instance instanceof ECPrivateKey) {
                    eCPrivateKey = (ECPrivateKey) instance;
                } else {
                    eCPrivateKey = instance != null ? new ECPrivateKey(ASN1Sequence.getInstance(instance)) : null;
                }
                AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, eCPrivateKey.getObjectInTag(0));
                return new PEMKeyPair(new SubjectPublicKeyInfo(algorithmIdentifier, ((DERBitString) eCPrivateKey.getObjectInTag(1)).getBytes()), new PrivateKeyInfo(algorithmIdentifier, eCPrivateKey));
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e2, GeneratedOutlineSupport.outline17("problem creating EC private key: ")), e2);
            }
        }
    }

    public class EncryptedPrivateKeyParser implements PemObjectParser {
        public EncryptedPrivateKeyParser() {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;
            try {
                byte[] bArr = pemObject.content;
                if (bArr instanceof EncryptedPrivateKeyInfo) {
                    encryptedPrivateKeyInfo = (EncryptedPrivateKeyInfo) bArr;
                } else {
                    encryptedPrivateKeyInfo = bArr != null ? new EncryptedPrivateKeyInfo(ASN1Sequence.getInstance(bArr)) : null;
                }
                return new PKCS8EncryptedPrivateKeyInfo(encryptedPrivateKeyInfo);
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing ENCRYPTED PRIVATE KEY: ")), e);
            }
        }
    }

    public class KeyPairParser implements PemObjectParser {
        public final PEMKeyPairParser pemKeyPairParser;

        public KeyPairParser(PEMKeyPairParser pEMKeyPairParser) {
            this.pemKeyPairParser = pEMKeyPairParser;
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            boolean z = false;
            String str = null;
            for (PemHeader pemHeader : pemObject.headers) {
                if (pemHeader.name.equals("Proc-Type") && pemHeader.value.equals("4,ENCRYPTED")) {
                    z = true;
                } else if (pemHeader.name.equals("DEK-Info")) {
                    str = pemHeader.value;
                }
            }
            byte[] bArr = pemObject.content;
            if (!z) {
                return this.pemKeyPairParser.parse(bArr);
            }
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
                return new PEMEncryptedKeyPair(stringTokenizer.nextToken(), Hex.decode(stringTokenizer.nextToken()), bArr, this.pemKeyPairParser);
            } catch (IOException e) {
                if (z) {
                    throw new PEMException("exception decoding - please check password and data.", e);
                }
                throw new PEMException(e.getMessage(), e);
            } catch (IllegalArgumentException e2) {
                if (z) {
                    throw new PEMException("exception decoding - please check password and data.", e2);
                }
                throw new PEMException(e2.getMessage(), e2);
            }
        }
    }

    public class PKCS10CertificationRequestParser implements PemObjectParser {
        public PKCS10CertificationRequestParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return new PKCS10CertificationRequest(pemObject.content);
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing certrequest: ")), e);
            }
        }
    }

    public class PKCS7Parser implements PemObjectParser {
        public PKCS7Parser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return ContentInfo.getInstance(new ASN1InputStream(pemObject.content).readObject());
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing PKCS7 object: ")), e);
            }
        }
    }

    public class PrivateKeyParser implements PemObjectParser {
        public PrivateKeyParser() {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return PrivateKeyInfo.getInstance(pemObject.content);
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing PRIVATE KEY: ")), e);
            }
        }
    }

    public class PublicKeyParser implements PemObjectParser {
        public PublicKeyParser() {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            return SubjectPublicKeyInfo.getInstance(pemObject.content);
        }
    }

    public class RSAKeyPairParser implements PEMKeyPairParser {
        public RSAKeyPairParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.openssl.PEMKeyPairParser
        public PEMKeyPair parse(byte[] bArr) throws IOException {
            try {
                ASN1Sequence instance = ASN1Sequence.getInstance(bArr);
                if (instance.size() == 9) {
                    RSAPrivateKey instance2 = RSAPrivateKey.getInstance(instance);
                    RSAPublicKey rSAPublicKey = new RSAPublicKey(instance2.modulus, instance2.publicExponent);
                    AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE);
                    return new PEMKeyPair(new SubjectPublicKeyInfo(algorithmIdentifier, rSAPublicKey), new PrivateKeyInfo(algorithmIdentifier, instance2));
                }
                throw new PEMException("malformed sequence in RSA private key");
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e2, GeneratedOutlineSupport.outline17("problem creating RSA private key: ")), e2);
            }
        }
    }

    public class RSAPublicKeyParser implements PemObjectParser {
        public RSAPublicKeyParser() {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            RSAPublicKey rSAPublicKey;
            try {
                byte[] bArr = pemObject.content;
                if (bArr instanceof RSAPublicKey) {
                    rSAPublicKey = (RSAPublicKey) bArr;
                } else {
                    rSAPublicKey = bArr != null ? new RSAPublicKey(ASN1Sequence.getInstance(bArr)) : null;
                }
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, DERNull.INSTANCE), rSAPublicKey);
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e2, GeneratedOutlineSupport.outline17("problem extracting key: ")), e2);
            }
        }
    }

    public class X509AttributeCertificateParser implements PemObjectParser {
        public X509AttributeCertificateParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            return new X509AttributeCertificateHolder(pemObject.content);
        }
    }

    public class X509CRLParser implements PemObjectParser {
        public X509CRLParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return new X509CRLHolder(pemObject.content);
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing cert: ")), e);
            }
        }
    }

    public class X509CertificateParser implements PemObjectParser {
        public X509CertificateParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return new X509CertificateHolder(pemObject.content);
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing cert: ")), e);
            }
        }
    }

    public class X509TrustedCertificateParser implements PemObjectParser {
        public X509TrustedCertificateParser(AnonymousClass1 r2) {
        }

        @Override // org.spongycastle.util.io.pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return new X509TrustedCertificateBlock(pemObject.content);
            } catch (Exception e) {
                throw new PEMException(GeneratedOutlineSupport.outline4(e, GeneratedOutlineSupport.outline17("problem parsing cert: ")), e);
            }
        }
    }

    public PEMParser(Reader reader) {
        super(reader);
        HashMap hashMap = new HashMap();
        this.parsers = hashMap;
        hashMap.put("CERTIFICATE REQUEST", new PKCS10CertificationRequestParser(null));
        this.parsers.put("NEW CERTIFICATE REQUEST", new PKCS10CertificationRequestParser(null));
        this.parsers.put("CERTIFICATE", new X509CertificateParser(null));
        this.parsers.put("TRUSTED CERTIFICATE", new X509TrustedCertificateParser(null));
        this.parsers.put("X509 CERTIFICATE", new X509CertificateParser(null));
        this.parsers.put("X509 CRL", new X509CRLParser(null));
        this.parsers.put("PKCS7", new PKCS7Parser(null));
        this.parsers.put("CMS", new PKCS7Parser(null));
        this.parsers.put("ATTRIBUTE CERTIFICATE", new X509AttributeCertificateParser(null));
        this.parsers.put("EC PARAMETERS", new ECCurveParamsParser(null));
        this.parsers.put("PUBLIC KEY", new PublicKeyParser());
        this.parsers.put("RSA PUBLIC KEY", new RSAPublicKeyParser());
        this.parsers.put("RSA PRIVATE KEY", new KeyPairParser(new RSAKeyPairParser(null)));
        this.parsers.put("DSA PRIVATE KEY", new KeyPairParser(new DSAKeyPairParser(null)));
        this.parsers.put("EC PRIVATE KEY", new KeyPairParser(new ECDSAKeyPairParser(null)));
        this.parsers.put("ENCRYPTED PRIVATE KEY", new EncryptedPrivateKeyParser());
        this.parsers.put("PRIVATE KEY", new PrivateKeyParser());
    }

    public Object readObject() throws IOException {
        PemObject readPemObject = readPemObject();
        if (readPemObject == null) {
            return null;
        }
        String str = readPemObject.type;
        if (this.parsers.containsKey(str)) {
            return ((PemObjectParser) this.parsers.get(str)).parseObject(readPemObject);
        }
        throw new IOException(GeneratedOutlineSupport.outline10("unrecognised object: ", str));
    }
}
