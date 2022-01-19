package org.spongycastle.crypto.digests;

import com.horcrux.svg.PathParser;
import org.spongycastle.util.Memoable;

public class SHA512Digest extends LongDigest {
    public SHA512Digest() {
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA512Digest(this);
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        PathParser.longToBigEndian(this.H1, bArr, i);
        PathParser.longToBigEndian(this.H2, bArr, i + 8);
        PathParser.longToBigEndian(this.H3, bArr, i + 16);
        PathParser.longToBigEndian(this.H4, bArr, i + 24);
        PathParser.longToBigEndian(this.H5, bArr, i + 32);
        PathParser.longToBigEndian(this.H6, bArr, i + 40);
        PathParser.longToBigEndian(this.H7, bArr, i + 48);
        PathParser.longToBigEndian(this.H8, bArr, i + 56);
        reset();
        return 64;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-512";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 64;
    }

    @Override // org.spongycastle.crypto.Digest, org.spongycastle.crypto.digests.LongDigest
    public void reset() {
        super.reset();
        this.H1 = 7640891576956012808L;
        this.H2 = -4942790177534073029L;
        this.H3 = 4354685564936845355L;
        this.H4 = -6534734903238641935L;
        this.H5 = 5840696475078001361L;
        this.H6 = -7276294671716946913L;
        this.H7 = 2270897969802886507L;
        this.H8 = 6620516959819538809L;
    }

    public SHA512Digest(SHA512Digest sHA512Digest) {
        super(sHA512Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((SHA512Digest) memoable);
    }
}
