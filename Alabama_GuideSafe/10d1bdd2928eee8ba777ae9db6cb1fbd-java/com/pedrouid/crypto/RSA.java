package com.pedrouid.crypto;

import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.pkcs.PrivateKeyInfo;
import org.spongycastle.asn1.pkcs.RSAPrivateKey;
import org.spongycastle.asn1.x509.SubjectPublicKeyInfo;
import org.spongycastle.openssl.PEMParser;
import org.spongycastle.util.encoders.Base64;
import org.spongycastle.util.io.pem.PemHeader;
import org.spongycastle.util.io.pem.PemObject;
import org.spongycastle.util.io.pem.PemReader;
import org.spongycastle.util.io.pem.PemWriter;

public class RSA {
    public static Charset CharsetUTF_8;
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public RSA() {
        CharsetUTF_8 = StandardCharsets.UTF_8;
    }

    public final String dataToPem(String str, byte[] bArr) throws IOException {
        int i;
        PemObject pemObject = new PemObject(str, bArr);
        StringWriter stringWriter = new StringWriter();
        PemWriter pemWriter = new PemWriter(stringWriter);
        pemWriter.write("-----BEGIN " + pemObject.type + "-----");
        pemWriter.newLine();
        if (!pemObject.headers.isEmpty()) {
            for (PemHeader pemHeader : pemObject.headers) {
                pemWriter.write(pemHeader.name);
                pemWriter.write(": ");
                pemWriter.write(pemHeader.value);
                pemWriter.newLine();
            }
            pemWriter.newLine();
        }
        byte[] encode = Base64.encode(pemObject.content);
        for (int i2 = 0; i2 < encode.length; i2 += pemWriter.buf.length) {
            int i3 = 0;
            while (true) {
                char[] cArr = pemWriter.buf;
                if (i3 == cArr.length || (i = i2 + i3) >= encode.length) {
                    pemWriter.write(pemWriter.buf, 0, i3);
                    pemWriter.newLine();
                } else {
                    cArr[i3] = (char) encode[i];
                    i3++;
                }
            }
            pemWriter.write(pemWriter.buf, 0, i3);
            pemWriter.newLine();
        }
        pemWriter.write("-----END " + pemObject.type + "-----");
        pemWriter.newLine();
        pemWriter.close();
        return stringWriter.toString();
    }

    public void generate(int i) throws IOException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyPairGenerator instance = KeyPairGenerator.getInstance("RSA");
        instance.initialize(i);
        KeyPair genKeyPair = instance.genKeyPair();
        this.publicKey = genKeyPair.getPublic();
        this.privateKey = genKeyPair.getPrivate();
    }

    public String getPrivateKey() throws IOException {
        return dataToPem("RSA PRIVATE KEY", ASN1Primitive.fromByteArray(PrivateKeyInfo.getInstance(this.privateKey.getEncoded()).privKey.getOctets()).toASN1Primitive().getEncoded());
    }

    public String getPublicKey() throws IOException {
        SubjectPublicKeyInfo instance = SubjectPublicKeyInfo.getInstance(this.publicKey.getEncoded());
        if (instance != null) {
            DERBitString dERBitString = instance.keyData;
            if (dERBitString.padBits == 0) {
                return dataToPem("RSA PUBLIC KEY", new ASN1InputStream(MoreExecutors.clone(dERBitString.data)).readObject().getEncoded());
            }
            throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
        }
        throw null;
    }

    public void setPrivateKey(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        RSAPrivateKey instance = RSAPrivateKey.getInstance(new ASN1InputStream(new PemReader(new StringReader(str)).readPemObject().content).readObject());
        this.privateKey = KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(instance.modulus, instance.privateExponent));
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    public void setPublicKey(String str) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        Throwable th;
        StringReader stringReader = null;
        try {
            StringReader stringReader2 = new StringReader(str);
            try {
                PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(((SubjectPublicKeyInfo) new PEMParser(stringReader2).readObject()).getEncoded()));
                stringReader2.close();
                this.publicKey = generatePublic;
            } catch (Throwable th2) {
                th = th2;
                stringReader = stringReader2;
                if (stringReader != null) {
                    stringReader.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (stringReader != null) {
            }
            throw th;
        }
    }

    public final String sign(byte[] bArr, String str) throws NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, SignatureException {
        Signature instance = Signature.getInstance(str);
        instance.initSign(this.privateKey);
        instance.update(bArr);
        return android.util.Base64.encodeToString(instance.sign(), 0);
    }
}
