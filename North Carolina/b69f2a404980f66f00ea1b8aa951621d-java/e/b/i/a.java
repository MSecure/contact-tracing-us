package e.b.i;

import androidx.recyclerview.widget.RecyclerView;
import c.b.a.a.c.n.c;
import e.b.d;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public char[] f4865a;

    /* renamed from: b  reason: collision with root package name */
    public Reader f4866b;

    /* renamed from: c  reason: collision with root package name */
    public int f4867c;

    /* renamed from: d  reason: collision with root package name */
    public int f4868d;

    /* renamed from: e  reason: collision with root package name */
    public int f4869e;
    public int f;
    public int g = -1;
    public String[] h = new String[RecyclerView.d0.FLAG_ADAPTER_POSITION_UNKNOWN];
    public boolean i;

    public a(Reader reader, int i2) {
        c.J1(reader);
        c.t1(reader.markSupported());
        this.f4866b = reader;
        this.f4865a = new char[(i2 > 32768 ? 32768 : i2)];
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    public static String c(char[] cArr, String[] strArr, int i2, int i3) {
        if (i3 > 12) {
            return new String(cArr, i2, i3);
        }
        boolean z = true;
        if (i3 < 1) {
            return "";
        }
        int i4 = i3 * 31;
        int i5 = i2;
        int i6 = 0;
        while (i6 < i3) {
            i4 = (i4 * 31) + cArr[i5];
            i6++;
            i5++;
        }
        int i7 = i4 & 511;
        String str = strArr[i7];
        if (str == null) {
            String str2 = new String(cArr, i2, i3);
            strArr[i7] = str2;
            return str2;
        }
        if (i3 == str.length()) {
            int i8 = i2;
            int i9 = i3;
            int i10 = 0;
            while (true) {
                int i11 = i9 - 1;
                if (i9 == 0) {
                    break;
                }
                int i12 = i8 + 1;
                int i13 = i10 + 1;
                if (cArr[i8] != str.charAt(i10)) {
                    break;
                }
                i8 = i12;
                i9 = i11;
                i10 = i13;
            }
            if (!z) {
                return str;
            }
            String str3 = new String(cArr, i2, i3);
            strArr[i7] = str3;
            return str3;
        }
        z = false;
        if (!z) {
        }
    }

    public void a() {
        this.f4869e++;
    }

    public final void b() {
        int i2;
        int i3;
        boolean z;
        if (!this.i && (i2 = this.f4869e) >= this.f4868d) {
            int i4 = this.g;
            if (i4 != -1) {
                i3 = i2 - i4;
                i2 = i4;
            } else {
                i3 = 0;
            }
            try {
                long j = (long) i2;
                long skip = this.f4866b.skip(j);
                this.f4866b.mark(32768);
                int i5 = 0;
                while (true) {
                    z = true;
                    if (i5 > 1024) {
                        break;
                    }
                    int read = this.f4866b.read(this.f4865a, i5, this.f4865a.length - i5);
                    if (read == -1) {
                        this.i = true;
                    }
                    if (read <= 0) {
                        break;
                    }
                    i5 += read;
                }
                this.f4866b.reset();
                if (i5 > 0) {
                    if (skip != j) {
                        z = false;
                    }
                    c.t1(z);
                    this.f4867c = i5;
                    this.f += i2;
                    this.f4869e = i3;
                    if (this.g != -1) {
                        this.g = 0;
                    }
                    int i6 = 24576;
                    if (this.f4867c <= 24576) {
                        i6 = this.f4867c;
                    }
                    this.f4868d = i6;
                }
            } catch (IOException e2) {
                throw new d(e2);
            }
        }
    }

    public char d() {
        b();
        char c2 = m() ? 65535 : this.f4865a[this.f4869e];
        this.f4869e++;
        return c2;
    }

    public String e() {
        int i2 = this.f4869e;
        int i3 = this.f4867c;
        char[] cArr = this.f4865a;
        int i4 = i2;
        while (i4 < i3) {
            char c2 = cArr[i4];
            if (c2 == 0 || c2 == '&' || c2 == '<') {
                break;
            }
            i4++;
        }
        this.f4869e = i4;
        return i4 > i2 ? c(this.f4865a, this.h, i2, i4 - i2) : "";
    }

    public String f() {
        char c2;
        b();
        int i2 = this.f4869e;
        while (true) {
            int i3 = this.f4869e;
            if (i3 < this.f4867c && (((c2 = this.f4865a[i3]) >= 'A' && c2 <= 'Z') || ((c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2)))) {
                this.f4869e++;
            }
        }
        return c(this.f4865a, this.h, i2, this.f4869e - i2);
    }

    public String g(char c2) {
        int i2;
        b();
        int i3 = this.f4869e;
        while (true) {
            if (i3 >= this.f4867c) {
                i2 = -1;
                break;
            } else if (c2 == this.f4865a[i3]) {
                i2 = i3 - this.f4869e;
                break;
            } else {
                i3++;
            }
        }
        if (i2 == -1) {
            return j();
        }
        String c3 = c(this.f4865a, this.h, this.f4869e, i2);
        this.f4869e += i2;
        return c3;
    }

    public String h(char... cArr) {
        b();
        int i2 = this.f4869e;
        int i3 = this.f4867c;
        char[] cArr2 = this.f4865a;
        int i4 = i2;
        loop0:
        while (i4 < i3) {
            for (char c2 : cArr) {
                if (cArr2[i4] == c2) {
                    break loop0;
                }
            }
            i4++;
        }
        this.f4869e = i4;
        return i4 > i2 ? c(this.f4865a, this.h, i2, i4 - i2) : "";
    }

    public String i(char... cArr) {
        b();
        int i2 = this.f4869e;
        int i3 = this.f4867c;
        char[] cArr2 = this.f4865a;
        int i4 = i2;
        while (i4 < i3 && Arrays.binarySearch(cArr, cArr2[i4]) < 0) {
            i4++;
        }
        this.f4869e = i4;
        return i4 > i2 ? c(this.f4865a, this.h, i2, i4 - i2) : "";
    }

    public String j() {
        b();
        char[] cArr = this.f4865a;
        String[] strArr = this.h;
        int i2 = this.f4869e;
        String c2 = c(cArr, strArr, i2, this.f4867c - i2);
        this.f4869e = this.f4867c;
        return c2;
    }

    public char k() {
        b();
        if (m()) {
            return 65535;
        }
        return this.f4865a[this.f4869e];
    }

    public boolean l() {
        b();
        return this.f4869e >= this.f4867c;
    }

    public final boolean m() {
        return this.f4869e >= this.f4867c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036 A[RETURN] */
    public boolean n(String str) {
        boolean z;
        b();
        b();
        int length = str.length();
        if (length <= this.f4867c - this.f4869e) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (str.charAt(i2) != this.f4865a[this.f4869e + i2]) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return false;
            }
            this.f4869e = str.length() + this.f4869e;
            return true;
        }
        z = false;
        if (z) {
        }
    }

    public boolean o(String str) {
        boolean z;
        b();
        int length = str.length();
        if (length <= this.f4867c - this.f4869e) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                } else if (Character.toUpperCase(str.charAt(i2)) != Character.toUpperCase(this.f4865a[this.f4869e + i2])) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        z = false;
        if (!z) {
            return false;
        }
        this.f4869e = str.length() + this.f4869e;
        return true;
    }

    public boolean p(char c2) {
        return !l() && this.f4865a[this.f4869e] == c2;
    }

    public boolean q(char... cArr) {
        if (l()) {
            return false;
        }
        b();
        char c2 = this.f4865a[this.f4869e];
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    public boolean r() {
        if (l()) {
            return false;
        }
        char c2 = this.f4865a[this.f4869e];
        return (c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z') || Character.isLetter(c2);
    }

    public int s(CharSequence charSequence) {
        b();
        char charAt = charSequence.charAt(0);
        int i2 = this.f4869e;
        while (i2 < this.f4867c) {
            int i3 = 1;
            if (charAt != this.f4865a[i2]) {
                do {
                    i2++;
                    if (i2 >= this.f4867c) {
                        break;
                    }
                } while (charAt != this.f4865a[i2]);
            }
            int i4 = i2 + 1;
            int length = (charSequence.length() + i4) - 1;
            int i5 = this.f4867c;
            if (i2 < i5 && length <= i5) {
                int i6 = i4;
                while (i6 < length && charSequence.charAt(i3) == this.f4865a[i6]) {
                    i6++;
                    i3++;
                }
                if (i6 == length) {
                    return i2 - this.f4869e;
                }
            }
            i2 = i4;
        }
        return -1;
    }

    public int t() {
        return this.f + this.f4869e;
    }

    public String toString() {
        if (this.f4867c - this.f4869e < 0) {
            return "";
        }
        char[] cArr = this.f4865a;
        int i2 = this.f4869e;
        return new String(cArr, i2, this.f4867c - i2);
    }

    public void u() {
        int i2 = this.g;
        if (i2 != -1) {
            this.f4869e = i2;
            this.g = -1;
            return;
        }
        throw new d(new IOException("Mark invalid"));
    }

    public void v() {
        int i2 = this.f4869e;
        if (i2 >= 1) {
            this.f4869e = i2 - 1;
            return;
        }
        throw new d(new IOException("No buffer left to unconsume"));
    }
}
