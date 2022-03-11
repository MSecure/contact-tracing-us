package f.b.b.c;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

public abstract class a {
    public static final a a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    public static final a b = new e(new C0107a("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".toCharArray()), '=');
    public static final a c = new b(new C0107a("base16()", "0123456789ABCDEF".toCharArray()));

    /* renamed from: f.b.b.c.a$a  reason: collision with other inner class name */
    public static final class C0107a {
        public final String a;
        public final char[] b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3003d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3004e;

        /* renamed from: f  reason: collision with root package name */
        public final int f3005f;

        /* renamed from: g  reason: collision with root package name */
        public final byte[] f3006g;

        /* renamed from: h  reason: collision with root package name */
        public final boolean[] f3007h;

        public C0107a(String str, char[] cArr) {
            Objects.requireNonNull(str);
            this.a = str;
            Objects.requireNonNull(cArr);
            this.b = cArr;
            try {
                int b2 = f.b.b.d.a.b(cArr.length, RoundingMode.UNNECESSARY);
                this.f3003d = b2;
                int min = Math.min(8, Integer.lowestOneBit(b2));
                try {
                    this.f3004e = 8 / min;
                    this.f3005f = b2 / min;
                    this.c = cArr.length - 1;
                    byte[] bArr = new byte[128];
                    Arrays.fill(bArr, (byte) -1);
                    for (int i2 = 0; i2 < cArr.length; i2++) {
                        char c2 = cArr[i2];
                        f.b.a.c.b.o.b.p(c2 < 128, "Non-ASCII character: %s", c2);
                        f.b.a.c.b.o.b.p(bArr[c2] == -1, "Duplicate character: %s", c2);
                        bArr[c2] = (byte) i2;
                    }
                    this.f3006g = bArr;
                    boolean[] zArr = new boolean[this.f3004e];
                    for (int i3 = 0; i3 < this.f3005f; i3++) {
                        zArr[f.b.b.d.a.a(i3 * 8, this.f3003d, RoundingMode.CEILING)] = true;
                    }
                    this.f3007h = zArr;
                } catch (ArithmeticException e2) {
                    StringBuilder h2 = f.a.a.a.a.h("Illegal alphabet ");
                    h2.append(new String(cArr));
                    throw new IllegalArgumentException(h2.toString(), e2);
                }
            } catch (ArithmeticException e3) {
                StringBuilder h3 = f.a.a.a.a.h("Illegal alphabet length ");
                h3.append(cArr.length);
                throw new IllegalArgumentException(h3.toString(), e3);
            }
        }

        public int a(char c2) {
            if (c2 <= 127) {
                byte b2 = this.f3006g[c2];
                if (b2 != -1) {
                    return b2;
                }
                if (c2 <= ' ' || c2 == 127) {
                    StringBuilder h2 = f.a.a.a.a.h("Unrecognized character: 0x");
                    h2.append(Integer.toHexString(c2));
                    throw new d(h2.toString());
                }
                throw new d(f.a.a.a.a.p("Unrecognized character: ", c2));
            }
            StringBuilder h3 = f.a.a.a.a.h("Unrecognized character: 0x");
            h3.append(Integer.toHexString(c2));
            throw new d(h3.toString());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0107a) {
                return Arrays.equals(this.b, ((C0107a) obj).b);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.b);
        }

        public String toString() {
            return this.a;
        }
    }

    public static final class b extends e {

        /* renamed from: g  reason: collision with root package name */
        public final char[] f3008g = new char[512];

        public b(C0107a aVar) {
            super(aVar, null);
            f.b.a.c.b.o.b.n(aVar.b.length == 16);
            for (int i2 = 0; i2 < 256; i2++) {
                char[] cArr = this.f3008g;
                char[] cArr2 = aVar.b;
                cArr[i2] = cArr2[i2 >>> 4];
                cArr[i2 | 256] = cArr2[i2 & 15];
            }
        }

        @Override // f.b.b.c.a, f.b.b.c.a.e
        public int b(byte[] bArr, CharSequence charSequence) {
            if (charSequence.length() % 2 != 1) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < charSequence.length()) {
                    bArr[i3] = (byte) ((this.f3009d.a(charSequence.charAt(i2)) << 4) | this.f3009d.a(charSequence.charAt(i2 + 1)));
                    i2 += 2;
                    i3++;
                }
                return i3;
            }
            StringBuilder h2 = f.a.a.a.a.h("Invalid input length ");
            h2.append(charSequence.length());
            throw new d(h2.toString());
        }

        @Override // f.b.b.c.a, f.b.b.c.a.e
        public void d(Appendable appendable, byte[] bArr, int i2, int i3) {
            f.b.a.c.b.o.b.E(i2, i2 + i3, bArr.length);
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = bArr[i2 + i4] & 255;
                appendable.append(this.f3008g[i5]);
                appendable.append(this.f3008g[i5 | 256]);
            }
        }

        @Override // f.b.b.c.a.e
        public a h(C0107a aVar, Character ch) {
            return new b(aVar);
        }
    }

    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    public static class e extends a {

        /* renamed from: d  reason: collision with root package name */
        public final C0107a f3009d;

        /* renamed from: e  reason: collision with root package name */
        public final Character f3010e;

        /* renamed from: f  reason: collision with root package name */
        public transient a f3011f;

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            if ((r2 < r5.length && r5[r2] != -1) == false) goto L_0x001f;
         */
        public e(C0107a aVar, Character ch) {
            Objects.requireNonNull(aVar);
            this.f3009d = aVar;
            boolean z = false;
            if (ch != null) {
                char charValue = ch.charValue();
                byte[] bArr = aVar.f3006g;
            }
            z = true;
            f.b.a.c.b.o.b.s(z, "Padding character %s was already in alphabet", ch);
            this.f3010e = ch;
        }

        @Override // f.b.b.c.a
        public int b(byte[] bArr, CharSequence charSequence) {
            C0107a aVar;
            CharSequence f2 = f(charSequence);
            C0107a aVar2 = this.f3009d;
            if (aVar2.f3007h[f2.length() % aVar2.f3004e]) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < f2.length()) {
                    long j2 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        aVar = this.f3009d;
                        if (i4 >= aVar.f3004e) {
                            break;
                        }
                        j2 <<= aVar.f3003d;
                        if (i2 + i4 < f2.length()) {
                            j2 |= (long) this.f3009d.a(f2.charAt(i5 + i2));
                            i5++;
                        }
                        i4++;
                    }
                    int i6 = aVar.f3005f;
                    int i7 = (i6 * 8) - (i5 * aVar.f3003d);
                    int i8 = (i6 - 1) * 8;
                    while (i8 >= i7) {
                        bArr[i3] = (byte) ((int) ((j2 >>> i8) & 255));
                        i8 -= 8;
                        i3++;
                    }
                    i2 += this.f3009d.f3004e;
                }
                return i3;
            }
            StringBuilder h2 = f.a.a.a.a.h("Invalid input length ");
            h2.append(f2.length());
            throw new d(h2.toString());
        }

        @Override // f.b.b.c.a
        public void d(Appendable appendable, byte[] bArr, int i2, int i3) {
            f.b.a.c.b.o.b.E(i2, i2 + i3, bArr.length);
            int i4 = 0;
            while (i4 < i3) {
                g(appendable, bArr, i2 + i4, Math.min(this.f3009d.f3005f, i3 - i4));
                i4 += this.f3009d.f3005f;
            }
        }

        @Override // f.b.b.c.a
        public a e() {
            boolean z;
            boolean z2;
            a aVar = this.f3011f;
            if (aVar == null) {
                C0107a aVar2 = this.f3009d;
                char[] cArr = aVar2.b;
                int length = cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char c = cArr[i2];
                    if (c >= 'A' && c <= 'Z') {
                        z = true;
                        break;
                    }
                    i2++;
                }
                if (z) {
                    char[] cArr2 = aVar2.b;
                    int length2 = cArr2.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length2) {
                            z2 = false;
                            break;
                        }
                        char c2 = cArr2[i3];
                        if (c2 >= 'a' && c2 <= 'z') {
                            z2 = true;
                            break;
                        }
                        i3++;
                    }
                    f.b.a.c.b.o.b.G(!z2, "Cannot call lowerCase() on a mixed-case alphabet");
                    char[] cArr3 = new char[aVar2.b.length];
                    int i4 = 0;
                    while (true) {
                        char[] cArr4 = aVar2.b;
                        if (i4 >= cArr4.length) {
                            break;
                        }
                        char c3 = cArr4[i4];
                        if (c3 >= 'A' && c3 <= 'Z') {
                            c3 = (char) (c3 ^ ' ');
                        }
                        cArr3[i4] = c3;
                        i4++;
                    }
                    aVar2 = new C0107a(f.a.a.a.a.e(new StringBuilder(), aVar2.a, ".lowerCase()"), cArr3);
                }
                aVar = aVar2 == this.f3009d ? this : h(aVar2, this.f3010e);
                this.f3011f = aVar;
            }
            return aVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f3009d.equals(eVar.f3009d) && f.b.a.c.b.o.b.t0(this.f3010e, eVar.f3010e);
        }

        @Override // f.b.b.c.a
        public CharSequence f(CharSequence charSequence) {
            Objects.requireNonNull(charSequence);
            Character ch = this.f3010e;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void g(Appendable appendable, byte[] bArr, int i2, int i3) {
            f.b.a.c.b.o.b.E(i2, i2 + i3, bArr.length);
            int i4 = 0;
            f.b.a.c.b.o.b.n(i3 <= this.f3009d.f3005f);
            long j2 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                j2 = (j2 | ((long) (bArr[i2 + i5] & 255))) << 8;
            }
            int i6 = ((i3 + 1) * 8) - this.f3009d.f3003d;
            while (i4 < i3 * 8) {
                C0107a aVar = this.f3009d;
                appendable.append(aVar.b[((int) (j2 >>> (i6 - i4))) & aVar.c]);
                i4 += this.f3009d.f3003d;
            }
            if (this.f3010e != null) {
                while (i4 < this.f3009d.f3005f * 8) {
                    appendable.append(this.f3010e.charValue());
                    i4 += this.f3009d.f3003d;
                }
            }
        }

        public a h(C0107a aVar, Character ch) {
            return new e(aVar, ch);
        }

        public int hashCode() {
            return this.f3009d.hashCode() ^ Arrays.hashCode(new Object[]{this.f3010e});
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f3009d.a);
            if (8 % this.f3009d.f3003d != 0) {
                if (this.f3010e == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f3010e);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }
    }

    static {
        new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new e(new C0107a("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV".toCharArray()), '=');
    }

    public final byte[] a(CharSequence charSequence) {
        try {
            CharSequence f2 = f(charSequence);
            int length = (int) (((((long) ((e) this).f3009d.f3003d) * ((long) f2.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int b2 = b(bArr, f2);
            if (b2 == length) {
                return bArr;
            }
            byte[] bArr2 = new byte[b2];
            System.arraycopy(bArr, 0, bArr2, 0, b2);
            return bArr2;
        } catch (d e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public abstract int b(byte[] bArr, CharSequence charSequence);

    public String c(byte[] bArr) {
        int length = bArr.length;
        f.b.a.c.b.o.b.E(0, 0 + length, bArr.length);
        C0107a aVar = ((e) this).f3009d;
        StringBuilder sb = new StringBuilder(f.b.b.d.a.a(length, aVar.f3005f, RoundingMode.CEILING) * aVar.f3004e);
        try {
            d(sb, bArr, 0, length);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public abstract void d(Appendable appendable, byte[] bArr, int i2, int i3);

    public abstract a e();

    public abstract CharSequence f(CharSequence charSequence);

    public static final class c extends e {
        public c(C0107a aVar, Character ch) {
            super(aVar, ch);
            f.b.a.c.b.o.b.n(aVar.b.length == 64);
        }

        @Override // f.b.b.c.a, f.b.b.c.a.e
        public int b(byte[] bArr, CharSequence charSequence) {
            CharSequence f2 = f(charSequence);
            C0107a aVar = this.f3009d;
            if (aVar.f3007h[f2.length() % aVar.f3004e]) {
                int i2 = 0;
                int i3 = 0;
                while (i2 < f2.length()) {
                    int i4 = i2 + 1;
                    int i5 = i4 + 1;
                    int a = (this.f3009d.a(f2.charAt(i2)) << 18) | (this.f3009d.a(f2.charAt(i4)) << 12);
                    int i6 = i3 + 1;
                    bArr[i3] = (byte) (a >>> 16);
                    if (i5 < f2.length()) {
                        int i7 = i5 + 1;
                        int a2 = a | (this.f3009d.a(f2.charAt(i5)) << 6);
                        i3 = i6 + 1;
                        bArr[i6] = (byte) ((a2 >>> 8) & 255);
                        if (i7 < f2.length()) {
                            i5 = i7 + 1;
                            i6 = i3 + 1;
                            bArr[i3] = (byte) ((a2 | this.f3009d.a(f2.charAt(i7))) & 255);
                        } else {
                            i2 = i7;
                        }
                    }
                    i3 = i6;
                    i2 = i5;
                }
                return i3;
            }
            StringBuilder h2 = f.a.a.a.a.h("Invalid input length ");
            h2.append(f2.length());
            throw new d(h2.toString());
        }

        @Override // f.b.b.c.a, f.b.b.c.a.e
        public void d(Appendable appendable, byte[] bArr, int i2, int i3) {
            int i4 = i2 + i3;
            f.b.a.c.b.o.b.E(i2, i4, bArr.length);
            while (i3 >= 3) {
                int i5 = i2 + 1;
                int i6 = i5 + 1;
                int i7 = ((bArr[i2] & 255) << 16) | ((bArr[i5] & 255) << 8);
                int i8 = i7 | (bArr[i6] & 255);
                appendable.append(this.f3009d.b[i8 >>> 18]);
                appendable.append(this.f3009d.b[(i8 >>> 12) & 63]);
                appendable.append(this.f3009d.b[(i8 >>> 6) & 63]);
                appendable.append(this.f3009d.b[i8 & 63]);
                i3 -= 3;
                i2 = i6 + 1;
            }
            if (i2 < i4) {
                g(appendable, bArr, i2, i4 - i2);
            }
        }

        @Override // f.b.b.c.a.e
        public a h(C0107a aVar, Character ch) {
            return new c(aVar, ch);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public c(String str, String str2, Character ch) {
            super(r0, ch);
            C0107a aVar = new C0107a(str, str2.toCharArray());
            f.b.a.c.b.o.b.n(aVar.b.length == 64);
        }
    }
}
