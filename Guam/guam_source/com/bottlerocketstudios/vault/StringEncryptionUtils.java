package com.bottlerocketstudios.vault;

import android.util.Pair;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class StringEncryptionUtils {

    public static class UnencryptedException extends Throwable {
        public UnencryptedException(String str, Throwable th) {
            super(str, th);
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr, String str) throws GeneralSecurityException {
        Pair pair;
        byte[] bArr2;
        Cipher instance = Cipher.getInstance(str);
        if (bArr == null) {
            pair = null;
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            if (bArr.length <= 6) {
                throw new GeneralSecurityException("Not enough data");
            } else if (wrap.get() != 121) {
                throw new GeneralSecurityException("Invalid header");
            } else if (wrap.get() == 1) {
                int i = wrap.getInt();
                if (i > 0) {
                    bArr2 = new byte[i];
                    wrap.get(bArr2, 0, i);
                } else {
                    bArr2 = null;
                }
                int length = bArr.length - (i + 6);
                byte[] bArr3 = new byte[length];
                wrap.get(bArr3, 0, length);
                pair = new Pair(bArr2, bArr3);
            } else {
                throw new GeneralSecurityException("Incorrect header version");
            }
        }
        if (pair == null) {
            return null;
        }
        if (pair.first == null) {
            instance.init(2, secretKey);
        } else {
            instance.init(2, secretKey, new IvParameterSpec((byte[]) pair.first));
        }
        return instance.doFinal((byte[]) pair.second);
    }
}
