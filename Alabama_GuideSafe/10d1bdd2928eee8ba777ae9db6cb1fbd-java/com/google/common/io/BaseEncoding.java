package com.google.common.io;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.common.math.IntMath;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

public abstract class BaseEncoding {
    public static final BaseEncoding BASE16 = new Base16Encoding(new Alphabet("base16()", "0123456789ABCDEF".toCharArray()));
    public static final BaseEncoding BASE32 = new StandardBaseEncoding(new Alphabet("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".toCharArray()), '=');
    public static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    public static final class Alphabet {
        public final int bitsPerChar;
        public final int bytesPerChunk;
        public final char[] chars;
        public final int charsPerChunk;
        public final byte[] decodabet;
        public final int mask;
        public final String name;

        public Alphabet(String str, char[] cArr) {
            if (str != null) {
                this.name = str;
                if (cArr != null) {
                    this.chars = cArr;
                    try {
                        int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                        this.bitsPerChar = log2;
                        int min = Math.min(8, Integer.lowestOneBit(log2));
                        try {
                            this.charsPerChunk = 8 / min;
                            this.bytesPerChunk = this.bitsPerChar / min;
                            this.mask = cArr.length - 1;
                            byte[] bArr = new byte[128];
                            Arrays.fill(bArr, (byte) -1);
                            for (int i = 0; i < cArr.length; i++) {
                                char c = cArr[i];
                                ReactYogaConfigProvider.checkArgument(c < 128, "Non-ASCII character: %s", c);
                                ReactYogaConfigProvider.checkArgument(bArr[c] == -1, "Duplicate character: %s", c);
                                bArr[c] = (byte) i;
                            }
                            this.decodabet = bArr;
                            boolean[] zArr = new boolean[this.charsPerChunk];
                            for (int i2 = 0; i2 < this.bytesPerChunk; i2++) {
                                zArr[IntMath.divide(i2 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                            }
                        } catch (ArithmeticException e) {
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Illegal alphabet ");
                            outline17.append(new String(cArr));
                            throw new IllegalArgumentException(outline17.toString(), e);
                        }
                    } catch (ArithmeticException e2) {
                        StringBuilder outline172 = GeneratedOutlineSupport.outline17("Illegal alphabet length ");
                        outline172.append(cArr.length);
                        throw new IllegalArgumentException(outline172.toString(), e2);
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof Alphabet) {
                return Arrays.equals(this.chars, ((Alphabet) obj).chars);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.chars);
        }

        public String toString() {
            return this.name;
        }
    }

    public static final class Base16Encoding extends StandardBaseEncoding {
        public final char[] encoding = new char[512];

        public Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            ReactYogaConfigProvider.checkArgument1(alphabet.chars.length == 16);
            for (int i = 0; i < 256; i++) {
                char[] cArr = this.encoding;
                char[] cArr2 = alphabet.chars;
                cArr[i] = cArr2[i >>> 4];
                cArr[i | 256] = cArr2[i & 15];
            }
        }

        @Override // com.google.common.io.BaseEncoding, com.google.common.io.BaseEncoding.StandardBaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            ReactYogaConfigProvider.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.encoding[i4]);
                appendable.append(this.encoding[i4 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public BaseEncoding newInstance(Alphabet alphabet, Character ch) {
            return new Base16Encoding(alphabet);
        }
    }

    public static class StandardBaseEncoding extends BaseEncoding {
        public final Alphabet alphabet;
        public transient BaseEncoding lowerCase;
        public final Character paddingChar;

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            if ((r2 < r5.length && r5[r2] != -1) == false) goto L_0x001e;
         */
        public StandardBaseEncoding(Alphabet alphabet2, Character ch) {
            if (alphabet2 != null) {
                this.alphabet = alphabet2;
                boolean z = false;
                if (ch != null) {
                    char charValue = ch.charValue();
                    byte[] bArr = alphabet2.decodabet;
                }
                z = true;
                ReactYogaConfigProvider.checkArgument(z, "Padding character %s was already in alphabet", ch);
                this.paddingChar = ch;
                return;
            }
            throw null;
        }

        public void encodeChunkTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            ReactYogaConfigProvider.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            ReactYogaConfigProvider.checkArgument1(i2 <= this.alphabet.bytesPerChunk);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | ((long) (bArr[i + i4] & 255))) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.alphabet.bitsPerChar;
            while (i3 < i2 * 8) {
                Alphabet alphabet2 = this.alphabet;
                appendable.append(alphabet2.chars[((int) (j >>> (i5 - i3))) & alphabet2.mask]);
                i3 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i3 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i3 += this.alphabet.bitsPerChar;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            ReactYogaConfigProvider.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                encodeChunkTo(appendable, bArr, i + i3, Math.min(this.alphabet.bytesPerChunk, i2 - i3));
                i3 += this.alphabet.bytesPerChunk;
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof StandardBaseEncoding)) {
                return false;
            }
            StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
            if (!this.alphabet.equals(standardBaseEncoding.alphabet) || !ReactYogaConfigProvider.equal1(this.paddingChar, standardBaseEncoding.paddingChar)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Arrays.hashCode(new Object[]{this.paddingChar});
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            boolean z;
            boolean z2;
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet alphabet2 = this.alphabet;
                char[] cArr = alphabet2.chars;
                int length = cArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    char c = cArr[i];
                    if (c >= 'A' && c <= 'Z') {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    char[] cArr2 = alphabet2.chars;
                    int length2 = cArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z2 = false;
                            break;
                        }
                        char c2 = cArr2[i2];
                        if (c2 >= 'a' && c2 <= 'z') {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                    ReactYogaConfigProvider.checkState1(!z2, "Cannot call lowerCase() on a mixed-case alphabet");
                    char[] cArr3 = new char[alphabet2.chars.length];
                    int i3 = 0;
                    while (true) {
                        char[] cArr4 = alphabet2.chars;
                        if (i3 >= cArr4.length) {
                            break;
                        }
                        char c3 = cArr4[i3];
                        if (c3 >= 'A' && c3 <= 'Z') {
                            c3 = (char) (c3 ^ ' ');
                        }
                        cArr3[i3] = c3;
                        i3++;
                    }
                    alphabet2 = new Alphabet(GeneratedOutlineSupport.outline14(new StringBuilder(), alphabet2.name, ".lowerCase()"), cArr3);
                }
                baseEncoding = alphabet2 == this.alphabet ? this : newInstance(alphabet2, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        public BaseEncoding newInstance(Alphabet alphabet2, Character ch) {
            return new StandardBaseEncoding(alphabet2, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet.name);
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.paddingChar);
                    sb.append("')");
                }
            }
            return sb.toString();
        }
    }

    static {
        new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new StandardBaseEncoding(new Alphabet("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV".toCharArray()), '=');
    }

    public String encode(byte[] bArr) {
        int length = bArr.length;
        ReactYogaConfigProvider.checkPositionIndexes(0, 0 + length, bArr.length);
        Alphabet alphabet = ((StandardBaseEncoding) this).alphabet;
        StringBuilder sb = new StringBuilder(IntMath.divide(length, alphabet.bytesPerChunk, RoundingMode.CEILING) * alphabet.charsPerChunk);
        try {
            encodeTo(sb, bArr, 0, length);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public abstract void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public abstract BaseEncoding lowerCase();

    public static final class Base64Encoding extends StandardBaseEncoding {
        /* JADX WARNING: Illegal instructions before constructor call */
        public Base64Encoding(String str, String str2, Character ch) {
            super(r0, ch);
            Alphabet alphabet = new Alphabet(str, str2.toCharArray());
            ReactYogaConfigProvider.checkArgument1(alphabet.chars.length == 64);
        }

        @Override // com.google.common.io.BaseEncoding, com.google.common.io.BaseEncoding.StandardBaseEncoding
        public void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            int i3 = i + i2;
            ReactYogaConfigProvider.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8);
                int i7 = i6 | (bArr[i5] & 255);
                appendable.append(this.alphabet.chars[i7 >>> 18]);
                appendable.append(this.alphabet.chars[(i7 >>> 12) & 63]);
                appendable.append(this.alphabet.chars[(i7 >>> 6) & 63]);
                appendable.append(this.alphabet.chars[i7 & 63]);
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                encodeChunkTo(appendable, bArr, i, i3 - i);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        public BaseEncoding newInstance(Alphabet alphabet, Character ch) {
            return new Base64Encoding(alphabet, ch);
        }

        public Base64Encoding(Alphabet alphabet, Character ch) {
            super(alphabet, ch);
            ReactYogaConfigProvider.checkArgument1(alphabet.chars.length == 64);
        }
    }
}
