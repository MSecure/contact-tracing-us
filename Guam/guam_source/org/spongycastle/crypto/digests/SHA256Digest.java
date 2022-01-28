package org.spongycastle.crypto.digests;

import com.horcrux.svg.PathParser;
import org.spongycastle.util.Memoable;

public class SHA256Digest extends GeneralDigest {
    public static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    public int H1;
    public int H2;
    public int H3;
    public int H4;
    public int H5;
    public int H6;
    public int H7;
    public int H8;
    public int[] X;
    public int xOff;

    public SHA256Digest() {
        this.X = new int[64];
        reset();
    }

    public final int Ch(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    public final int Maj(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    public final int Sum0(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    public final int Sum1(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    @Override // org.spongycastle.util.Memoable
    public Memoable copy() {
        return new SHA256Digest(this);
    }

    public final void copyIn(SHA256Digest sHA256Digest) {
        super.copyIn((GeneralDigest) sHA256Digest);
        this.H1 = sHA256Digest.H1;
        this.H2 = sHA256Digest.H2;
        this.H3 = sHA256Digest.H3;
        this.H4 = sHA256Digest.H4;
        this.H5 = sHA256Digest.H5;
        this.H6 = sHA256Digest.H6;
        this.H7 = sHA256Digest.H7;
        this.H8 = sHA256Digest.H8;
        int[] iArr = sHA256Digest.X;
        System.arraycopy(iArr, 0, this.X, 0, iArr.length);
        this.xOff = sHA256Digest.xOff;
    }

    @Override // org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        finish();
        PathParser.intToBigEndian(this.H1, bArr, i);
        PathParser.intToBigEndian(this.H2, bArr, i + 4);
        PathParser.intToBigEndian(this.H3, bArr, i + 8);
        PathParser.intToBigEndian(this.H4, bArr, i + 12);
        PathParser.intToBigEndian(this.H5, bArr, i + 16);
        PathParser.intToBigEndian(this.H6, bArr, i + 20);
        PathParser.intToBigEndian(this.H7, bArr, i + 24);
        PathParser.intToBigEndian(this.H8, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHA-256";
    }

    @Override // org.spongycastle.crypto.Digest
    public int getDigestSize() {
        return 32;
    }

    @Override // org.spongycastle.crypto.digests.GeneralDigest
    public void processBlock() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.X;
            int i2 = iArr[i - 2];
            int i3 = ((i2 >>> 10) ^ (((i2 >>> 17) | (i2 << 15)) ^ ((i2 >>> 19) | (i2 << 13)))) + iArr[i - 7];
            int i4 = iArr[i - 15];
            iArr[i] = i3 + ((i4 >>> 3) ^ (((i4 >>> 7) | (i4 << 25)) ^ ((i4 >>> 18) | (i4 << 14)))) + iArr[i - 16];
        }
        int i5 = this.H1;
        int i6 = this.H2;
        int i7 = this.H3;
        int i8 = this.H4;
        int i9 = this.H5;
        int i10 = this.H6;
        int i11 = this.H7;
        int i12 = this.H8;
        int i13 = 0;
        int i14 = 0;
        while (i13 < 8) {
            int Ch = Ch(i9, i10, i11) + Sum1(i9) + K[i14] + this.X[i14] + i12;
            int i15 = i8 + Ch;
            int Maj = Maj(i5, i6, i7) + Sum0(i5) + Ch;
            int i16 = i14 + 1;
            int Ch2 = Ch(i15, i9, i10) + Sum1(i15) + K[i16] + this.X[i16] + i11;
            int i17 = i7 + Ch2;
            int Maj2 = Maj(Maj, i5, i6) + Sum0(Maj) + Ch2;
            int i18 = i16 + 1;
            int Ch3 = Ch(i17, i15, i9) + Sum1(i17) + K[i18] + this.X[i18] + i10;
            int i19 = i6 + Ch3;
            int Maj3 = Maj(Maj2, Maj, i5) + Sum0(Maj2) + Ch3;
            int i20 = i18 + 1;
            int Ch4 = Ch(i19, i17, i15) + Sum1(i19) + K[i20] + this.X[i20] + i9;
            int i21 = i5 + Ch4;
            int Maj4 = Maj(Maj3, Maj2, Maj) + Sum0(Maj3) + Ch4;
            int i22 = i20 + 1;
            int Ch5 = Ch(i21, i19, i17) + Sum1(i21) + K[i22] + this.X[i22] + i15;
            int i23 = Maj + Ch5;
            int Maj5 = Maj(Maj4, Maj3, Maj2) + Sum0(Maj4) + Ch5;
            int i24 = i22 + 1;
            int Ch6 = Ch(i23, i21, i19) + Sum1(i23) + K[i24] + this.X[i24] + i17;
            int i25 = Maj2 + Ch6;
            int Maj6 = Maj(Maj5, Maj4, Maj3) + Sum0(Maj5) + Ch6;
            int i26 = i24 + 1;
            int Ch7 = Ch(i25, i23, i21) + Sum1(i25) + K[i26] + this.X[i26] + i19;
            int i27 = Maj3 + Ch7;
            int Maj7 = Maj(Maj6, Maj5, Maj4) + Sum0(Maj6) + Ch7;
            int i28 = i26 + 1;
            int Ch8 = Ch(i27, i25, i23) + Sum1(i27) + K[i28] + this.X[i28] + i21;
            i14 = i28 + 1;
            i13++;
            i9 = Maj4 + Ch8;
            i5 = Maj(Maj7, Maj6, Maj5) + Sum0(Maj7) + Ch8;
            i10 = i27;
            i6 = Maj7;
            i11 = i25;
            i7 = Maj6;
            i12 = i23;
            i8 = Maj5;
        }
        this.H1 += i5;
        this.H2 += i6;
        this.H3 += i7;
        this.H4 += i8;
        this.H5 += i9;
        this.H6 += i10;
        this.H7 += i11;
        this.H8 += i12;
        this.xOff = 0;
        for (int i29 = 0; i29 < 16; i29++) {
            this.X[i29] = 0;
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
        this.H1 = 1779033703;
        this.H2 = -1150833019;
        this.H3 = 1013904242;
        this.H4 = -1521486534;
        this.H5 = 1359893119;
        this.H6 = -1694144372;
        this.H7 = 528734635;
        this.H8 = 1541459225;
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

    public SHA256Digest(SHA256Digest sHA256Digest) {
        super(sHA256Digest);
        this.X = new int[64];
        copyIn(sHA256Digest);
    }

    @Override // org.spongycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((SHA256Digest) memoable);
    }
}
