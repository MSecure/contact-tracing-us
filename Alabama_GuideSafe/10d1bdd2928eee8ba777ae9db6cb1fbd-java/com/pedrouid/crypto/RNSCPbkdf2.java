package com.pedrouid.crypto;

import android.util.Base64;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.crypto.digests.SHA1Digest;
import org.spongycastle.crypto.digests.SHA224Digest;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.digests.SHA384Digest;
import org.spongycastle.crypto.digests.SHA512Digest;
import org.spongycastle.crypto.macs.HMac;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.util.Memoable;

public class RNSCPbkdf2 extends ReactContextBaseJavaModule {
    public RNSCPbkdf2(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static byte[] pbkdf2(byte[] bArr, byte[] bArr2, Integer num, Integer num2, String str) throws NullPointerException, NoSuchAlgorithmException {
        byte[] bArr3;
        HashMap hashMap = new HashMap();
        hashMap.put("SHA1", new SHA1Digest());
        hashMap.put("SHA224", new SHA224Digest());
        hashMap.put("SHA256", new SHA256Digest());
        hashMap.put("SHA384", new SHA384Digest());
        hashMap.put("SHA512", new SHA512Digest());
        ExtendedDigest extendedDigest = (ExtendedDigest) hashMap.get(str);
        if (extendedDigest != null) {
            HMac hMac = new HMac(extendedDigest);
            int i = hMac.digestSize;
            byte[] bArr4 = new byte[i];
            int intValue = num.intValue();
            int intValue2 = (num2.intValue() * 8) / 8;
            int i2 = hMac.digestSize;
            int i3 = ((intValue2 + i2) - 1) / i2;
            byte[] bArr5 = new byte[4];
            int i4 = i3 * i2;
            byte[] bArr6 = new byte[i4];
            KeyParameter keyParameter = new KeyParameter(bArr);
            hMac.digest.reset();
            byte[] bArr7 = keyParameter.key;
            int length = bArr7.length;
            int i5 = 0;
            if (length > hMac.blockLength) {
                hMac.digest.update(bArr7, 0, length);
                hMac.digest.doFinal(hMac.inputPad, 0);
                length = hMac.digestSize;
            } else {
                System.arraycopy(bArr7, 0, hMac.inputPad, 0, length);
            }
            while (true) {
                bArr3 = hMac.inputPad;
                if (length >= bArr3.length) {
                    break;
                }
                bArr3[length] = 0;
                length++;
            }
            System.arraycopy(bArr3, 0, hMac.outputBuf, 0, hMac.blockLength);
            byte[] bArr8 = hMac.inputPad;
            int i6 = hMac.blockLength;
            for (int i7 = 0; i7 < i6; i7++) {
                bArr8[i7] = (byte) (bArr8[i7] ^ 54);
            }
            byte[] bArr9 = hMac.outputBuf;
            int i8 = hMac.blockLength;
            for (int i9 = 0; i9 < i8; i9++) {
                bArr9[i9] = (byte) (bArr9[i9] ^ 92);
            }
            Digest digest = hMac.digest;
            if (digest instanceof Memoable) {
                Memoable copy = ((Memoable) digest).copy();
                hMac.opadState = copy;
                ((Digest) copy).update(hMac.outputBuf, 0, hMac.blockLength);
            }
            Digest digest2 = hMac.digest;
            byte[] bArr10 = hMac.inputPad;
            digest2.update(bArr10, 0, bArr10.length);
            Digest digest3 = hMac.digest;
            if (digest3 instanceof Memoable) {
                hMac.ipadState = ((Memoable) digest3).copy();
            }
            int i10 = 0;
            int i11 = 1;
            while (i11 <= i3) {
                int i12 = 3;
                while (true) {
                    byte b = (byte) (bArr5[i12] + 1);
                    bArr5[i12] = b;
                    if (b != 0) {
                        break;
                    }
                    i12--;
                }
                if (intValue != 0) {
                    if (bArr2 != null) {
                        hMac.digest.update(bArr2, i5, bArr2.length);
                    }
                    hMac.digest.update(bArr5, i5, 4);
                    hMac.doFinal(bArr4, i5);
                    System.arraycopy(bArr4, i5, bArr6, i10, i);
                    int i13 = 1;
                    while (i13 < intValue) {
                        hMac.digest.update(bArr4, i5, i);
                        hMac.doFinal(bArr4, i5);
                        for (int i14 = i5; i14 != i; i14++) {
                            int i15 = i10 + i14;
                            bArr6[i15] = (byte) (bArr4[i14] ^ bArr6[i15]);
                        }
                        i13++;
                        i5 = 0;
                    }
                    i10 += i2;
                    i11++;
                    i5 = 0;
                } else {
                    throw new IllegalArgumentException("iteration count must be at least 1.");
                }
            }
            int i16 = intValue2 + 0;
            if (i16 >= 0) {
                byte[] bArr11 = new byte[i16];
                int i17 = i4 - 0;
                if (i17 < i16) {
                    System.arraycopy(bArr6, 0, bArr11, 0, i17);
                } else {
                    System.arraycopy(bArr6, 0, bArr11, 0, i16);
                }
                return new KeyParameter(bArr11, 0, intValue2).key;
            }
            StringBuffer stringBuffer = new StringBuffer(0);
            stringBuffer.append(" > ");
            stringBuffer.append(intValue2);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        throw new NoSuchAlgorithmException("Specified hash algorithm is not supported");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNSCPbkdf2";
    }

    @ReactMethod
    public void hash(String str, String str2, Integer num, Integer num2, String str3, Promise promise) {
        try {
            promise.resolve(Base64.encodeToString(pbkdf2(Base64.decode(str, 0), Base64.decode(str2, 0), num, num2, str3), 2));
        } catch (Exception e) {
            promise.reject("-1", e.getMessage());
        }
    }
}
