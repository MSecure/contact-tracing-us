package com.bottlerocketstudios.vault.keys.wrapper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bottlerocketstudios.vault.salt.PrngSaltGenerator;
import com.bottlerocketstudios.vault.salt.SaltBox;
import com.pedrouid.crypto.RCTAes;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class ObfuscatingSecretKeyWrapper implements SecretKeyWrapper {
    public Cipher mCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    public final Context mContext;
    public final String mPresharedSecret;
    public byte[] mSalt;
    public final PrngSaltGenerator mSaltGenerator;
    public final int mSaltIndex;
    public SecretKey mWrappingKey;

    @SuppressLint({"GetInstance"})
    public ObfuscatingSecretKeyWrapper(Context context, int i, PrngSaltGenerator prngSaltGenerator, String str) throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.mContext = context.getApplicationContext();
        this.mSaltIndex = i;
        this.mSaltGenerator = prngSaltGenerator;
        this.mPresharedSecret = str;
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper
    public void clearKey(Context context) {
        this.mWrappingKey = null;
        this.mSalt = null;
        SaltBox.writeStoredBits(context, this.mSaltIndex, null, 512);
    }

    public final SecretKey getWrappingKey(Context context) {
        if (this.mWrappingKey == null) {
            if (this.mSalt == null) {
                int i = this.mSaltIndex;
                String settingName = SaltBox.getSettingName(i);
                byte[] bArr = SaltBox.sStoredBits.get(i);
                if (SaltBox.isByteArrayInvalid(bArr, 512)) {
                    String string = context.getSharedPreferences("NaCl", 0).getString(settingName, null);
                    if (string != null) {
                        try {
                            byte[] decode = Base64.decode(string, 0);
                            if (!SaltBox.isByteArrayInvalid(decode, 512)) {
                                bArr = decode;
                                SaltBox.sStoredBits.put(i, bArr);
                            }
                        } catch (IllegalArgumentException e) {
                            Log.w("SaltBox", "Stored bits were not properly encoded", e);
                        }
                    }
                    bArr = null;
                    SaltBox.sStoredBits.put(i, bArr);
                }
                this.mSalt = bArr;
                if (bArr == null) {
                    PrngSaltGenerator prngSaltGenerator = this.mSaltGenerator;
                    if (prngSaltGenerator != null) {
                        byte[] bArr2 = new byte[512];
                        prngSaltGenerator.mSecureRandom.nextBytes(bArr2);
                        SaltBox.writeStoredBits(context, this.mSaltIndex, bArr2, 512);
                        this.mSalt = bArr2;
                    } else {
                        throw null;
                    }
                }
            }
            try {
                this.mWrappingKey = new SecretKeySpec(MessageDigest.getInstance("SHA256").digest(AppCompatDelegateImpl.ConfigurationImplApi17.concatByteArrays(this.mPresharedSecret.getBytes("UTF-8"), this.mSalt)), RCTAes.KEY_ALGORITHM);
            } catch (UnsupportedEncodingException e2) {
                Log.e("ObfuscatingSecretKeyWrapper", "Caught java.io.UnsupportedEncodingException", e2);
            } catch (NoSuchAlgorithmException e3) {
                Log.e("ObfuscatingSecretKeyWrapper", "Caught java.security.NoSuchAlgorithmException", e3);
            }
        }
        return this.mWrappingKey;
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper
    public SecretKey unwrap(byte[] bArr, String str) throws GeneralSecurityException {
        this.mCipher.init(4, getWrappingKey(this.mContext));
        return (SecretKey) this.mCipher.unwrap(bArr, str, 3);
    }

    @Override // com.bottlerocketstudios.vault.keys.wrapper.SecretKeyWrapper
    public byte[] wrap(SecretKey secretKey) throws GeneralSecurityException {
        this.mCipher.init(3, getWrappingKey(this.mContext));
        return this.mCipher.wrap(secretKey);
    }
}
