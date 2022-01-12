package org.spongycastle.crypto.macs;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Hashtable;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public class HMac {
    public static Hashtable blockLengths;
    public int blockLength;
    public Digest digest;
    public int digestSize;
    public byte[] inputPad;
    public Memoable ipadState;
    public Memoable opadState;
    public byte[] outputBuf;

    static {
        Hashtable hashtable = new Hashtable();
        blockLengths = hashtable;
        hashtable.put("GOST3411", 32);
        blockLengths.put("MD2", 16);
        blockLengths.put("MD4", 64);
        blockLengths.put("MD5", 64);
        blockLengths.put("RIPEMD128", 64);
        blockLengths.put("RIPEMD160", 64);
        blockLengths.put("SHA-1", 64);
        blockLengths.put("SHA-224", 64);
        blockLengths.put("SHA-256", 64);
        blockLengths.put("SHA-384", 128);
        blockLengths.put("SHA-512", 128);
        blockLengths.put("Tiger", 64);
        blockLengths.put("Whirlpool", 64);
    }

    public HMac(Digest digest2) {
        int i;
        if (digest2 instanceof ExtendedDigest) {
            i = ((ExtendedDigest) digest2).getByteLength();
        } else {
            Integer num = (Integer) blockLengths.get(digest2.getAlgorithmName());
            if (num != null) {
                i = num.intValue();
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("unknown digest passed: ");
                outline17.append(digest2.getAlgorithmName());
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        this.digest = digest2;
        int digestSize2 = digest2.getDigestSize();
        this.digestSize = digestSize2;
        this.blockLength = i;
        this.inputPad = new byte[i];
        this.outputBuf = new byte[(i + digestSize2)];
    }

    public int doFinal(byte[] bArr, int i) {
        this.digest.doFinal(this.outputBuf, this.blockLength);
        Memoable memoable = this.opadState;
        if (memoable != null) {
            ((Memoable) this.digest).reset(memoable);
            Digest digest2 = this.digest;
            digest2.update(this.outputBuf, this.blockLength, digest2.getDigestSize());
        } else {
            Digest digest3 = this.digest;
            byte[] bArr2 = this.outputBuf;
            digest3.update(bArr2, 0, bArr2.length);
        }
        int doFinal = this.digest.doFinal(bArr, i);
        int i2 = this.blockLength;
        while (true) {
            byte[] bArr3 = this.outputBuf;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        Memoable memoable2 = this.ipadState;
        if (memoable2 != null) {
            ((Memoable) this.digest).reset(memoable2);
        } else {
            Digest digest4 = this.digest;
            byte[] bArr4 = this.inputPad;
            digest4.update(bArr4, 0, bArr4.length);
        }
        return doFinal;
    }
}
