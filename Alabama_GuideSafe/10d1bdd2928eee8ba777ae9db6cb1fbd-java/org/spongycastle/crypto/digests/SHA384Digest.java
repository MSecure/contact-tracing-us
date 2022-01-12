package org.spongycastle.crypto.digests;

import com.google.common.util.concurrent.MoreExecutors;
import org.spongycastle.util.Memoable;

public class SHA384Digest extends LongDigest {
    public SHA384Digest() {
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA384Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        MoreExecutors.longToBigEndian(this.H1, bArr, i);
        MoreExecutors.longToBigEndian(this.H2, bArr, i + 8);
        MoreExecutors.longToBigEndian(this.H3, bArr, i + 16);
        MoreExecutors.longToBigEndian(this.H4, bArr, i + 24);
        MoreExecutors.longToBigEndian(this.H5, bArr, i + 32);
        MoreExecutors.longToBigEndian(this.H6, bArr, i + 40);
        reset();
        return 48;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-384";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 48;
    }

    @Override // org.spongycastle.crypto.Digest, org.spongycastle.crypto.digests.LongDigest
    public void reset() {
        super.reset();
        this.H1 = -3766243637369397544L;
        this.H2 = 7105036623409894663L;
        this.H3 = -7973340178411365097L;
        this.H4 = 1526699215303891257L;
        this.H5 = 7436329637833083697L;
        this.H6 = -8163818279084223215L;
        this.H7 = -2662702644619276377L;
        this.H8 = 5167115440072839076L;
    }

    public SHA384Digest(SHA384Digest sHA384Digest) {
        super(sHA384Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        super.copyIn((SHA384Digest) memoable);
    }
}
