package org.spongycastle.crypto.digests;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.horcrux.svg.PathParser;
import org.spongycastle.util.Memoable;

public class SHA1Digest extends GeneralDigest {
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int H5;
    public int[] X;
    public int xOff;

    public SHA1Digest() {
        this.X = new int[80];
        reset();
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA1Digest(this);
    }

    public final void copyIn(SHA1Digest sHA1Digest) {
        this.H1 = sHA1Digest.H1;
        this.H2 = sHA1Digest.H2;
        this.H3 = sHA1Digest.H3;
        this.H4 = sHA1Digest.H4;
        this.H5 = sHA1Digest.H5;
        int[] iArr = sHA1Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA1Digest.xOff;
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        PathParser.intToBigEndian(this.H1, bArr, i);
        PathParser.intToBigEndian(this.H2, bArr, i + 4);
        PathParser.intToBigEndian(this.H3, bArr, i + 8);
        PathParser.intToBigEndian(this.H4, bArr, i + 12);
        PathParser.intToBigEndian(this.H5, bArr, i + 16);
        reset();
        return 20;
    }

    public final int f(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    public final int g(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-1";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 20;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.X;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.H1;
        int i4 = this.H2;
        int i5 = this.H3;
        int i6 = this.H4;
        int i7 = this.H5;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int i10 = i9 + 1;
            int outline1 = GeneratedOutlineSupport.outline1(f(i4, i5, i6) + ((i3 << 5) | (i3 >>> 27)), this.X[i9], 1518500249, i7);
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int outline12 = GeneratedOutlineSupport.outline1(f(i3, i11, i5) + ((outline1 << 5) | (outline1 >>> 27)), this.X[i10], 1518500249, i6);
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int outline13 = GeneratedOutlineSupport.outline1(f(outline1, i13, i11) + ((outline12 << 5) | (outline12 >>> 27)), this.X[i12], 1518500249, i5);
            i7 = (outline1 >>> 2) | (outline1 << 30);
            int i15 = i14 + 1;
            i4 = GeneratedOutlineSupport.outline1(f(outline12, i7, i13) + ((outline13 << 5) | (outline13 >>> 27)), this.X[i14], 1518500249, i11);
            i6 = (outline12 >>> 2) | (outline12 << 30);
            i3 = GeneratedOutlineSupport.outline1(f(outline13, i6, i7) + ((i4 << 5) | (i4 >>> 27)), this.X[i15], 1518500249, i13);
            i5 = (outline13 >>> 2) | (outline13 << 30);
            i8++;
            i9 = i15 + 1;
        }
        int i16 = 0;
        while (i16 < 4) {
            int[] iArr2 = this.X;
            int i17 = i9 + 1;
            int outline14 = GeneratedOutlineSupport.outline1(((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6), iArr2[i9], 1859775393, i7);
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int outline15 = GeneratedOutlineSupport.outline1(((outline14 << 5) | (outline14 >>> 27)) + ((i3 ^ i18) ^ i5), iArr2[i17], 1859775393, i6);
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int outline16 = GeneratedOutlineSupport.outline1(((outline15 << 5) | (outline15 >>> 27)) + ((outline14 ^ i20) ^ i18), iArr2[i19], 1859775393, i5);
            i7 = (outline14 >>> 2) | (outline14 << 30);
            int i22 = i21 + 1;
            i4 = GeneratedOutlineSupport.outline1(((outline16 << 5) | (outline16 >>> 27)) + ((outline15 ^ i7) ^ i20), iArr2[i21], 1859775393, i18);
            i6 = (outline15 >>> 2) | (outline15 << 30);
            i3 = GeneratedOutlineSupport.outline1(((i4 << 5) | (i4 >>> 27)) + ((outline16 ^ i6) ^ i7), iArr2[i22], 1859775393, i20);
            i5 = (outline16 >>> 2) | (outline16 << 30);
            i16++;
            i9 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int i24 = i9 + 1;
            int outline17 = GeneratedOutlineSupport.outline1(g(i4, i5, i6) + ((i3 << 5) | (i3 >>> 27)), this.X[i9], -1894007588, i7);
            int i25 = (i4 >>> 2) | (i4 << 30);
            int i26 = i24 + 1;
            int outline18 = GeneratedOutlineSupport.outline1(g(i3, i25, i5) + ((outline17 << 5) | (outline17 >>> 27)), this.X[i24], -1894007588, i6);
            int i27 = (i3 >>> 2) | (i3 << 30);
            int i28 = i26 + 1;
            int outline19 = GeneratedOutlineSupport.outline1(g(outline17, i27, i25) + ((outline18 << 5) | (outline18 >>> 27)), this.X[i26], -1894007588, i5);
            i7 = (outline17 >>> 2) | (outline17 << 30);
            int i29 = i28 + 1;
            i4 = GeneratedOutlineSupport.outline1(g(outline18, i7, i27) + ((outline19 << 5) | (outline19 >>> 27)), this.X[i28], -1894007588, i25);
            i6 = (outline18 >>> 2) | (outline18 << 30);
            i3 = GeneratedOutlineSupport.outline1(g(outline19, i6, i7) + ((i4 << 5) | (i4 >>> 27)), this.X[i29], -1894007588, i27);
            i5 = (outline19 >>> 2) | (outline19 << 30);
            i23++;
            i9 = i29 + 1;
        }
        int i30 = 0;
        while (i30 <= 3) {
            int[] iArr3 = this.X;
            int i31 = i9 + 1;
            int outline110 = GeneratedOutlineSupport.outline1(((i3 << 5) | (i3 >>> 27)) + ((i4 ^ i5) ^ i6), iArr3[i9], -899497514, i7);
            int i32 = (i4 >>> 2) | (i4 << 30);
            int i33 = i31 + 1;
            int outline111 = GeneratedOutlineSupport.outline1(((outline110 << 5) | (outline110 >>> 27)) + ((i3 ^ i32) ^ i5), iArr3[i31], -899497514, i6);
            int i34 = (i3 >>> 2) | (i3 << 30);
            int i35 = i33 + 1;
            int outline112 = GeneratedOutlineSupport.outline1(((outline111 << 5) | (outline111 >>> 27)) + ((outline110 ^ i34) ^ i32), iArr3[i33], -899497514, i5);
            i7 = (outline110 >>> 2) | (outline110 << 30);
            int i36 = i35 + 1;
            i4 = GeneratedOutlineSupport.outline1(((outline112 << 5) | (outline112 >>> 27)) + ((outline111 ^ i7) ^ i34), iArr3[i35], -899497514, i32);
            i6 = (outline111 >>> 2) | (outline111 << 30);
            i3 = GeneratedOutlineSupport.outline1(((i4 << 5) | (i4 >>> 27)) + ((outline112 ^ i6) ^ i7), iArr3[i36], -899497514, i34);
            i5 = (outline112 >>> 2) | (outline112 << 30);
            i30++;
            i9 = i36 + 1;
        }
        this.H1 += i3;
        this.H2 += i4;
        this.H3 += i5;
        this.H4 += i6;
        this.H5 += i7;
        this.xOff = 0;
        for (int i37 = 0; i37 < 16; i37++) {
            this.X[i37] = 0;
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processLength(long j) {
        if (this.xOff > 14) {
            processBlock();
        }
        int[] iArr = this.X;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & -1);
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processWord(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = i2 + 1;
        int i4 = (bArr[i3 + 1] & 255) | (bArr[i] << 24) | ((bArr[i2] & 255) << 16) | ((bArr[i3] & 255) << 8);
        int[] iArr = this.X;
        int i5 = this.xOff;
        iArr[i5] = i4;
        int i6 = i5 + 1;
        this.xOff = i6;
        if (i6 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest, org.spongycastle.crypto.Digest
    public void reset() {
        super.reset();
        this.H1 = 1732584193;
        this.H2 = -271733879;
        this.H3 = -1732584194;
        this.H4 = 271733878;
        this.H5 = -1009589776;
        this.xOff = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.X;
            if (i != iArr.length) {
                iArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public SHA1Digest(SHA1Digest sHA1Digest) {
        super(sHA1Digest);
        this.X = new int[80];
        copyIn(sHA1Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        SHA1Digest sHA1Digest = (SHA1Digest) memoable;
        super.copyIn((GeneralDigest) sHA1Digest);
        copyIn(sHA1Digest);
    }
}
