package c.b.b.c;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f3351a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b  reason: collision with root package name */
    public static final a f3352b = new e(new C0078a("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567".toCharArray()), '=');

    /* renamed from: c  reason: collision with root package name */
    public static final a f3353c = new b(new C0078a("base16()", "0123456789ABCDEF".toCharArray()));

    /* renamed from: c.b.b.c.a$a  reason: collision with other inner class name */
    public static final class C0078a {

        /* renamed from: a  reason: collision with root package name */
        public final String f3354a;

        /* renamed from: b  reason: collision with root package name */
        public final char[] f3355b;

        /* renamed from: c  reason: collision with root package name */
        public final int f3356c;

        /* renamed from: d  reason: collision with root package name */
        public final int f3357d;

        /* renamed from: e  reason: collision with root package name */
        public final int f3358e;
        public final int f;
        public final byte[] g;
        public final boolean[] h;

        public C0078a(String str, char[] cArr) {
            if (str != null) {
                this.f3354a = str;
                if (cArr != null) {
                    this.f3355b = cArr;
                    try {
                        int b2 = c.b.b.d.a.b(cArr.length, RoundingMode.UNNECESSARY);
                        this.f3357d = b2;
                        int min = Math.min(8, Integer.lowestOneBit(b2));
                        try {
                            this.f3358e = 8 / min;
                            this.f = this.f3357d / min;
                            this.f3356c = cArr.length - 1;
                            byte[] bArr = new byte[RecyclerView.d0.FLAG_IGNORE];
                            Arrays.fill(bArr, (byte) -1);
                            for (int i = 0; i < cArr.length; i++) {
                                char c2 = cArr[i];
                                c.b.a.a.c.n.c.p(c2 < 128, "Non-ASCII character: %s", c2);
                                c.b.a.a.c.n.c.p(bArr[c2] == -1, "Duplicate character: %s", c2);
                                bArr[c2] = (byte) i;
                            }
                            this.g = bArr;
                            boolean[] zArr = new boolean[this.f3358e];
                            for (int i2 = 0; i2 < this.f; i2++) {
                                zArr[c.b.b.d.a.a(i2 * 8, this.f3357d, RoundingMode.CEILING)] = true;
                            }
                            this.h = zArr;
                        } catch (ArithmeticException e2) {
                            StringBuilder g2 = c.a.a.a.a.g("Illegal alphabet ");
                            g2.append(new String(cArr));
                            throw new IllegalArgumentException(g2.toString(), e2);
                        }
                    } catch (ArithmeticException e3) {
                        StringBuilder g3 = c.a.a.a.a.g("Illegal alphabet length ");
                        g3.append(cArr.length);
                        throw new IllegalArgumentException(g3.toString(), e3);
                    }
                } else {
                    throw null;
                }
            } else {
                throw null;
            }
        }

        public int a(char c2) {
            if (c2 <= 127) {
                byte b2 = this.g[c2];
                if (b2 != -1) {
                    return b2;
                }
                if (c2 <= ' ' || c2 == 127) {
                    StringBuilder g2 = c.a.a.a.a.g("Unrecognized character: 0x");
                    g2.append(Integer.toHexString(c2));
                    throw new d(g2.toString());
                }
                throw new d(c.a.a.a.a.k("Unrecognized character: ", c2));
            }
            StringBuilder g3 = c.a.a.a.a.g("Unrecognized character: 0x");
            g3.append(Integer.toHexString(c2));
            throw new d(g3.toString());
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0078a) {
                return Arrays.equals(this.f3355b, ((C0078a) obj).f3355b);
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f3355b);
        }

        public String toString() {
            return this.f3354a;
        }
    }

    public static final class b extends e {
        public final char[] g = new char[RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN];

        public b(C0078a aVar) {
            super(aVar, null);
            c.b.a.a.c.n.c.o(aVar.f3355b.length == 16);
            for (int i = 0; i < 256; i++) {
                char[] cArr = this.g;
                char[] cArr2 = aVar.f3355b;
                cArr[i] = cArr2[i >>> 4];
                cArr[i | RecyclerView.d0.FLAG_TMP_DETACHED] = cArr2[i & 15];
            }
        }

        @Override // c.b.b.c.a.e, c.b.b.c.a
        public int b(byte[] bArr, CharSequence charSequence) {
            if (charSequence.length() % 2 != 1) {
                int i = 0;
                int i2 = 0;
                while (i < charSequence.length()) {
                    bArr[i2] = (byte) ((this.f3359d.a(charSequence.charAt(i)) << 4) | this.f3359d.a(charSequence.charAt(i + 1)));
                    i += 2;
                    i2++;
                }
                return i2;
            }
            StringBuilder g2 = c.a.a.a.a.g("Invalid input length ");
            g2.append(charSequence.length());
            throw new d(g2.toString());
        }

        @Override // c.b.b.c.a.e, c.b.b.c.a
        public void d(Appendable appendable, byte[] bArr, int i, int i2) {
            c.b.a.a.c.n.c.w(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.g[i4]);
                appendable.append(this.g[i4 | RecyclerView.d0.FLAG_TMP_DETACHED]);
            }
        }

        @Override // c.b.b.c.a.e
        public a h(C0078a aVar, Character ch) {
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
        public final C0078a f3359d;

        /* renamed from: e  reason: collision with root package name */
        public final Character f3360e;
        public transient a f;

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
            if ((r2 < r5.length && r5[r2] != -1) == false) goto L_0x001e;
         */
        public e(C0078a aVar, Character ch) {
            if (aVar != null) {
                this.f3359d = aVar;
                boolean z = false;
                if (ch != null) {
                    char charValue = ch.charValue();
                    byte[] bArr = aVar.g;
                }
                z = true;
                c.b.a.a.c.n.c.q(z, "Padding character %s was already in alphabet", ch);
                this.f3360e = ch;
                return;
            }
            throw null;
        }

        @Override // c.b.b.c.a
        public int b(byte[] bArr, CharSequence charSequence) {
            C0078a aVar;
            CharSequence f2 = f(charSequence);
            C0078a aVar2 = this.f3359d;
            if (aVar2.h[f2.length() % aVar2.f3358e]) {
                int i = 0;
                int i2 = 0;
                while (i < f2.length()) {
                    long j = 0;
                    int i3 = 0;
                    int i4 = 0;
                    while (true) {
                        aVar = this.f3359d;
                        if (i3 >= aVar.f3358e) {
                            break;
                        }
                        j <<= aVar.f3357d;
                        if (i + i3 < f2.length()) {
                            j |= (long) this.f3359d.a(f2.charAt(i4 + i));
                            i4++;
                        }
                        i3++;
                    }
                    int i5 = aVar.f;
                    int i6 = (i5 * 8) - (i4 * aVar.f3357d);
                    int i7 = (i5 - 1) * 8;
                    while (i7 >= i6) {
                        bArr[i2] = (byte) ((int) ((j >>> i7) & 255));
                        i7 -= 8;
                        i2++;
                    }
                    i += this.f3359d.f3358e;
                }
                return i2;
            }
            StringBuilder g = c.a.a.a.a.g("Invalid input length ");
            g.append(f2.length());
            throw new d(g.toString());
        }

        @Override // c.b.b.c.a
        public void d(Appendable appendable, byte[] bArr, int i, int i2) {
            c.b.a.a.c.n.c.w(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                g(appendable, bArr, i + i3, Math.min(this.f3359d.f, i2 - i3));
                i3 += this.f3359d.f;
            }
        }

        @Override // c.b.b.c.a
        public a e() {
            boolean z;
            boolean z2;
            a aVar = this.f;
            if (aVar == null) {
                C0078a aVar2 = this.f3359d;
                char[] cArr = aVar2.f3355b;
                int length = cArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    char c2 = cArr[i];
                    if (c2 >= 'A' && c2 <= 'Z') {
                        z = true;
                        break;
                    }
                    i++;
                }
                if (z) {
                    char[] cArr2 = aVar2.f3355b;
                    int length2 = cArr2.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length2) {
                            z2 = false;
                            break;
                        }
                        char c3 = cArr2[i2];
                        if (c3 >= 'a' && c3 <= 'z') {
                            z2 = true;
                            break;
                        }
                        i2++;
                    }
                    if (!z2) {
                        char[] cArr3 = new char[aVar2.f3355b.length];
                        int i3 = 0;
                        while (true) {
                            char[] cArr4 = aVar2.f3355b;
                            if (i3 >= cArr4.length) {
                                break;
                            }
                            char c4 = cArr4[i3];
                            if (c4 >= 'A' && c4 <= 'Z') {
                                c4 = (char) (c4 ^ ' ');
                            }
                            cArr3[i3] = c4;
                            i3++;
                        }
                        aVar2 = new C0078a(aVar2.f3354a + ".lowerCase()", cArr3);
                    } else {
                        throw new IllegalStateException("Cannot call lowerCase() on a mixed-case alphabet");
                    }
                }
                aVar = aVar2 == this.f3359d ? this : h(aVar2, this.f3360e);
                this.f = aVar;
            }
            return aVar;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            return this.f3359d.equals(eVar.f3359d) && c.b.a.a.c.n.c.J0(this.f3360e, eVar.f3360e);
        }

        @Override // c.b.b.c.a
        public CharSequence f(CharSequence charSequence) {
            if (charSequence != null) {
                Character ch = this.f3360e;
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
            throw null;
        }

        public void g(Appendable appendable, byte[] bArr, int i, int i2) {
            c.b.a.a.c.n.c.w(i, i + i2, bArr.length);
            int i3 = 0;
            c.b.a.a.c.n.c.o(i2 <= this.f3359d.f);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | ((long) (bArr[i + i4] & 255))) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.f3359d.f3357d;
            while (i3 < i2 * 8) {
                C0078a aVar = this.f3359d;
                appendable.append(aVar.f3355b[((int) (j >>> (i5 - i3))) & aVar.f3356c]);
                i3 += this.f3359d.f3357d;
            }
            if (this.f3360e != null) {
                while (i3 < this.f3359d.f * 8) {
                    appendable.append(this.f3360e.charValue());
                    i3 += this.f3359d.f3357d;
                }
            }
        }

        public a h(C0078a aVar, Character ch) {
            return new e(aVar, ch);
        }

        public int hashCode() {
            return this.f3359d.hashCode() ^ Arrays.hashCode(new Object[]{this.f3360e});
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f3359d.f3354a);
            if (8 % this.f3359d.f3357d != 0) {
                if (this.f3360e == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f3360e);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }
    }

    static {
        new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
        new e(new C0078a("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV".toCharArray()), '=');
    }

    public final byte[] a(CharSequence charSequence) {
        try {
            CharSequence f = f(charSequence);
            int length = (int) (((((long) ((e) this).f3359d.f3357d) * ((long) f.length())) + 7) / 8);
            byte[] bArr = new byte[length];
            int b2 = b(bArr, f);
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
        c.b.a.a.c.n.c.w(0, 0 + length, bArr.length);
        C0078a aVar = ((e) this).f3359d;
        StringBuilder sb = new StringBuilder(c.b.b.d.a.a(length, aVar.f, RoundingMode.CEILING) * aVar.f3358e);
        try {
            d(sb, bArr, 0, length);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public abstract void d(Appendable appendable, byte[] bArr, int i, int i2);

    public abstract a e();

    public abstract CharSequence f(CharSequence charSequence);

    public static final class c extends e {
        public c(C0078a aVar, Character ch) {
            super(aVar, ch);
            c.b.a.a.c.n.c.o(aVar.f3355b.length == 64);
        }

        @Override // c.b.b.c.a.e, c.b.b.c.a
        public int b(byte[] bArr, CharSequence charSequence) {
            CharSequence f = f(charSequence);
            C0078a aVar = this.f3359d;
            if (aVar.h[f.length() % aVar.f3358e]) {
                int i = 0;
                int i2 = 0;
                while (i < f.length()) {
                    int i3 = i + 1;
                    int i4 = i3 + 1;
                    int a2 = (this.f3359d.a(f.charAt(i)) << 18) | (this.f3359d.a(f.charAt(i3)) << 12);
                    int i5 = i2 + 1;
                    bArr[i2] = (byte) (a2 >>> 16);
                    if (i4 < f.length()) {
                        int i6 = i4 + 1;
                        int a3 = a2 | (this.f3359d.a(f.charAt(i4)) << 6);
                        i2 = i5 + 1;
                        bArr[i5] = (byte) ((a3 >>> 8) & 255);
                        if (i6 < f.length()) {
                            i4 = i6 + 1;
                            i5 = i2 + 1;
                            bArr[i2] = (byte) ((a3 | this.f3359d.a(f.charAt(i6))) & 255);
                        } else {
                            i = i6;
                        }
                    }
                    i2 = i5;
                    i = i4;
                }
                return i2;
            }
            StringBuilder g = c.a.a.a.a.g("Invalid input length ");
            g.append(f.length());
            throw new d(g.toString());
        }

        @Override // c.b.b.c.a.e, c.b.b.c.a
        public void d(Appendable appendable, byte[] bArr, int i, int i2) {
            int i3 = i + i2;
            c.b.a.a.c.n.c.w(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8);
                int i7 = i6 | (bArr[i5] & 255);
                appendable.append(this.f3359d.f3355b[i7 >>> 18]);
                appendable.append(this.f3359d.f3355b[(i7 >>> 12) & 63]);
                appendable.append(this.f3359d.f3355b[(i7 >>> 6) & 63]);
                appendable.append(this.f3359d.f3355b[i7 & 63]);
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                g(appendable, bArr, i, i3 - i);
            }
        }

        @Override // c.b.b.c.a.e
        public a h(C0078a aVar, Character ch) {
            return new c(aVar, ch);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        public c(String str, String str2, Character ch) {
            super(r0, ch);
            C0078a aVar = new C0078a(str, str2.toCharArray());
            c.b.a.a.c.n.c.o(aVar.f3355b.length == 64);
        }
    }
}
