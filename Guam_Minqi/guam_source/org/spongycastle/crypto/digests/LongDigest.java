package org.spongycastle.crypto.digests;

import com.horcrux.svg.PathParser;
import org.spongycastle.crypto.ExtendedDigest;
import org.spongycastle.util.Memoable;

public abstract class LongDigest implements ExtendedDigest, Memoable {
    public static final long[] K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    public long H1;
    public long H2;
    public long H3;
    public long H4;
    public long H5;
    public long H6;
    public long H7;
    public long H8;
    public long[] W;
    public long byteCount1;
    public long byteCount2;
    public int wOff;
    public byte[] xBuf;
    public int xBufOff;

    public LongDigest() {
        this.xBuf = new byte[8];
        this.W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    public final long Ch(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    public final long Maj(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    public final long Sum0(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    public final long Sum1(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    public final void adjustByteCounts() {
        long j = this.byteCount1;
        if (j > 2305843009213693951L) {
            this.byteCount2 += j >>> 61;
            this.byteCount1 = j & 2305843009213693951L;
        }
    }

    public void copyIn(LongDigest longDigest) {
        byte[] bArr = longDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = longDigest.xBufOff;
        this.byteCount1 = longDigest.byteCount1;
        this.byteCount2 = longDigest.byteCount2;
        this.H1 = longDigest.H1;
        this.H2 = longDigest.H2;
        this.H3 = longDigest.H3;
        this.H4 = longDigest.H4;
        this.H5 = longDigest.H5;
        this.H6 = longDigest.H6;
        this.H7 = longDigest.H7;
        this.H8 = longDigest.H8;
        long[] jArr = longDigest.W;
        System.arraycopy(jArr, 0, this.W, 0, jArr.length);
        this.wOff = longDigest.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long j = this.byteCount1 << 3;
        long j2 = this.byteCount2;
        update(Byte.MIN_VALUE);
        while (this.xBufOff != 0) {
            update((byte) 0);
        }
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.W;
        jArr[14] = j2;
        jArr[15] = j;
        processBlock();
    }

    @Override // org.spongycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    public void processBlock() {
        adjustByteCounts();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.W;
            long j = jArr[i - 2];
            long j2 = ((j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)))) + jArr[i - 7];
            long j3 = jArr[i - 15];
            jArr[i] = j2 + ((j3 >>> 7) ^ (((j3 << 63) | (j3 >>> 1)) ^ ((j3 << 56) | (j3 >>> 8)))) + jArr[i - 16];
        }
        long j4 = this.H1;
        long j5 = this.H2;
        long j6 = this.H3;
        long j7 = this.H4;
        long j8 = this.H5;
        long j9 = this.H6;
        long j10 = this.H7;
        long j11 = j9;
        long j12 = j7;
        int i2 = 0;
        long j13 = j5;
        long j14 = j6;
        long j15 = j8;
        int i3 = 0;
        long j16 = this.H8;
        long j17 = j4;
        long j18 = j10;
        while (i3 < 10) {
            int i4 = i2 + 1;
            long Sum1 = Sum1(j15) + Ch(j15, j11, j18) + K[i2] + this.W[i2] + j16;
            long j19 = j12 + Sum1;
            long Sum0 = Sum0(j17) + Maj(j17, j13, j14) + Sum1;
            int i5 = i4 + 1;
            long Sum12 = Sum1(j19) + Ch(j19, j15, j11) + K[i4] + this.W[i4] + j18;
            long j20 = j14 + Sum12;
            long Sum02 = Sum0(Sum0) + Maj(Sum0, j17, j13) + Sum12;
            int i6 = i5 + 1;
            long Sum13 = Sum1(j20) + Ch(j20, j19, j15) + K[i5] + this.W[i5] + j11;
            long j21 = j13 + Sum13;
            long Sum03 = Sum0(Sum02) + Maj(Sum02, Sum0, j17) + Sum13;
            int i7 = i6 + 1;
            long Sum14 = Sum1(j21) + Ch(j21, j20, j19) + K[i6] + this.W[i6] + j15;
            long j22 = j17 + Sum14;
            long Sum04 = Sum0(Sum03) + Maj(Sum03, Sum02, Sum0) + Sum14;
            int i8 = i7 + 1;
            long Sum15 = Sum1(j22) + Ch(j22, j21, j20) + K[i7] + this.W[i7] + j19;
            long j23 = Sum0 + Sum15;
            long Sum05 = Sum0(Sum04) + Maj(Sum04, Sum03, Sum02) + Sum15;
            int i9 = i8 + 1;
            long Sum16 = Sum1(j23) + Ch(j23, j22, j21) + K[i8] + this.W[i8] + j20;
            long j24 = Sum02 + Sum16;
            long Sum06 = Sum0(Sum05) + Maj(Sum05, Sum04, Sum03) + Sum16;
            int i10 = i9 + 1;
            long Sum17 = Sum1(j24) + Ch(j24, j23, j22) + K[i9] + this.W[i9] + j21;
            long j25 = Sum03 + Sum17;
            long Sum07 = Sum0(Sum06) + Maj(Sum06, Sum05, Sum04) + Sum17;
            long Sum18 = Sum1(j25) + Ch(j25, j24, j23) + K[i10] + this.W[i10] + j22;
            long j26 = Sum04 + Sum18;
            long Sum08 = Sum0(Sum07) + Maj(Sum07, Sum06, Sum05) + Sum18;
            i3++;
            j14 = Sum06;
            i2 = i10 + 1;
            j15 = j26;
            j18 = j24;
            j11 = j25;
            j12 = Sum05;
            j16 = j23;
            j13 = Sum07;
            j17 = Sum08;
        }
        this.H1 += j17;
        this.H2 += j13;
        this.H3 += j14;
        this.H4 += j12;
        this.H5 += j15;
        this.H6 += j11;
        this.H7 += j18;
        this.H8 += j16;
        this.wOff = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.W[i11] = 0;
        }
    }

    public void processWord(byte[] bArr, int i) {
        long[] jArr = this.W;
        int i2 = this.wOff;
        int bigEndianToInt = PathParser.bigEndianToInt(bArr, i);
        jArr[i2] = (((long) PathParser.bigEndianToInt(bArr, i + 4)) & 4294967295L) | ((((long) bigEndianToInt) & 4294967295L) << 32);
        int i3 = this.wOff + 1;
        this.wOff = i3;
        if (i3 == 16) {
            processBlock();
        }
    }

    @Override // org.spongycastle.crypto.Digest
    public void reset() {
        this.byteCount1 = 0;
        this.byteCount2 = 0;
        int i = 0;
        this.xBufOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.W;
            if (i != jArr.length) {
                jArr[i] = 0;
                i++;
            } else {
                return;
            }
        }
    }

    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        int i2 = i + 1;
        this.xBufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    public LongDigest(LongDigest longDigest) {
        this.xBuf = new byte[8];
        this.W = new long[80];
        copyIn(longDigest);
    }

    @Override // org.spongycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.xBuf.length) {
            processWord(bArr, i);
            byte[] bArr2 = this.xBuf;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}
