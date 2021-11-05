package e.b.i;

import androidx.recyclerview.widget.RecyclerView;
import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.b.h.j;
import e.b.i.i;
import java.util.Arrays;

public final class k {
    public static final char[] r;
    public static final int[] s = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};

    /* renamed from: a  reason: collision with root package name */
    public final a f4912a;

    /* renamed from: b  reason: collision with root package name */
    public final e f4913b;

    /* renamed from: c  reason: collision with root package name */
    public l f4914c = l.Data;

    /* renamed from: d  reason: collision with root package name */
    public i f4915d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4916e = false;
    public String f = null;
    public StringBuilder g = new StringBuilder(1024);
    public StringBuilder h = new StringBuilder(1024);
    public i.AbstractC0117i i;
    public i.h j = new i.h();
    public i.g k = new i.g();
    public i.c l = new i.c();
    public i.e m = new i.e();
    public i.d n = new i.d();
    public String o;
    public final int[] p = new int[1];
    public final int[] q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', '<', '&'};
        r = cArr;
        Arrays.sort(cArr);
    }

    public k(a aVar, e eVar) {
        this.f4912a = aVar;
        this.f4913b = eVar;
    }

    public final void a(String str) {
        if (this.f4913b.a()) {
            this.f4913b.add(new d(this.f4912a.t(), "Invalid character reference: %s", str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01d0, code lost:
        if (r13.f4912a.q('=', '-', '_') == false) goto L_0x01d8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01a2  */
    public int[] b(Character ch, boolean z) {
        boolean z2;
        boolean z3;
        char c2;
        int i2;
        char c3;
        String str;
        int i3;
        char c4;
        char c5;
        if (this.f4912a.l()) {
            return null;
        }
        if (ch != null && ch.charValue() == this.f4912a.k()) {
            return null;
        }
        a aVar = this.f4912a;
        char[] cArr = r;
        aVar.b();
        if (!aVar.l() && Arrays.binarySearch(cArr, aVar.f4865a[aVar.f4869e]) >= 0) {
            return null;
        }
        int[] iArr = this.p;
        a aVar2 = this.f4912a;
        if (aVar2.f4867c - aVar2.f4869e < 1024) {
            aVar2.f4868d = 0;
        }
        aVar2.b();
        aVar2.g = aVar2.f4869e;
        if (this.f4912a.n("#")) {
            boolean o2 = this.f4912a.o("X");
            a aVar3 = this.f4912a;
            if (o2) {
                aVar3.b();
                int i4 = aVar3.f4869e;
                while (true) {
                    int i5 = aVar3.f4869e;
                    if (i5 >= aVar3.f4867c || (((c5 = aVar3.f4865a[i5]) < '0' || c5 > '9') && ((c5 < 'A' || c5 > 'F') && (c5 < 'a' || c5 > 'f')))) {
                        str = a.c(aVar3.f4865a, aVar3.h, i4, aVar3.f4869e - i4);
                    } else {
                        aVar3.f4869e++;
                    }
                }
                str = a.c(aVar3.f4865a, aVar3.h, i4, aVar3.f4869e - i4);
            } else {
                aVar3.b();
                int i6 = aVar3.f4869e;
                while (true) {
                    int i7 = aVar3.f4869e;
                    if (i7 >= aVar3.f4867c || (c4 = aVar3.f4865a[i7]) < '0' || c4 > '9') {
                        str = a.c(aVar3.f4865a, aVar3.h, i6, aVar3.f4869e - i6);
                    } else {
                        aVar3.f4869e = i7 + 1;
                    }
                }
                str = a.c(aVar3.f4865a, aVar3.h, i6, aVar3.f4869e - i6);
            }
            if (str.length() == 0) {
                a("numeric reference with no numerals");
            } else {
                a aVar4 = this.f4912a;
                aVar4.g = -1;
                if (!aVar4.n(";")) {
                    a("missing semicolon");
                }
                try {
                    i3 = Integer.valueOf(str, o2 ? 16 : 10).intValue();
                } catch (NumberFormatException unused) {
                    i3 = -1;
                }
                if (i3 == -1 || ((i3 >= 55296 && i3 <= 57343) || i3 > 1114111)) {
                    a("character outside of valid range");
                    iArr[0] = 65533;
                    return iArr;
                }
                if (i3 >= 128 && i3 < s.length + RecyclerView.d0.FLAG_IGNORE) {
                    a("character is not a valid unicode code point");
                    i3 = s[i3 - 128];
                }
                iArr[0] = i3;
                return iArr;
            }
        } else {
            a aVar5 = this.f4912a;
            aVar5.b();
            int i8 = aVar5.f4869e;
            while (true) {
                int i9 = aVar5.f4869e;
                if (i9 < aVar5.f4867c && (((c3 = aVar5.f4865a[i9]) >= 'A' && c3 <= 'Z') || ((c3 >= 'a' && c3 <= 'z') || Character.isLetter(c3)))) {
                    aVar5.f4869e++;
                }
            }
            while (!aVar5.m() && (r5 = aVar5.f4865a[(i2 = aVar5.f4869e)]) >= '0' && r5 <= '9') {
                aVar5.f4869e = i2 + 1;
            }
            String c6 = a.c(aVar5.f4865a, aVar5.h, i8, aVar5.f4869e - i8);
            boolean p2 = this.f4912a.p(';');
            if (!j.d(c6)) {
                if (!(j.b.extended.b(c6) != -1) || !p2) {
                    z2 = false;
                    if (z2) {
                        this.f4912a.u();
                        if (p2) {
                            a("invalid named reference");
                        }
                        return null;
                    }
                    if (z) {
                        if (!this.f4912a.r()) {
                            a aVar6 = this.f4912a;
                            if (!(!aVar6.l() && (c2 = aVar6.f4865a[aVar6.f4869e]) >= '0' && c2 <= '9')) {
                            }
                        }
                    }
                    a aVar7 = this.f4912a;
                    aVar7.g = -1;
                    if (!aVar7.n(";")) {
                        a("missing semicolon");
                    }
                    int[] iArr2 = this.q;
                    String str2 = j.f4850b.get(c6);
                    if (str2 != null) {
                        iArr2[0] = str2.codePointAt(0);
                        iArr2[1] = str2.codePointAt(1);
                        z3 = true;
                    } else {
                        int b2 = j.b.extended.b(c6);
                        if (b2 != -1) {
                            iArr2[0] = b2;
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    }
                    if (z3) {
                        iArr[0] = this.q[0];
                        return iArr;
                    } else if (z3) {
                        return this.q;
                    } else {
                        throw new IllegalArgumentException(a.o("Unexpected characters returned for ", c6));
                    }
                }
            }
            z2 = true;
            if (z2) {
            }
        }
        this.f4912a.u();
        return null;
    }

    public void c() {
        this.n.g();
        this.n.f4897d = true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: e.b.i.i$h */
    /* JADX WARN: Multi-variable type inference failed */
    public i.AbstractC0117i d(boolean z) {
        i.g gVar;
        if (z) {
            i.h hVar = this.j;
            hVar.s();
            gVar = hVar;
        } else {
            i.g gVar2 = this.k;
            gVar2.g();
            gVar = gVar2;
        }
        this.i = gVar;
        return gVar;
    }

    public void e(char c2) {
        f(String.valueOf(c2));
    }

    public void f(String str) {
        if (this.f == null) {
            this.f = str;
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append(str);
    }

    public void g(i iVar) {
        c.o1(this.f4916e);
        this.f4915d = iVar;
        this.f4916e = true;
        i.j jVar = iVar.f4893a;
        if (jVar == i.j.StartTag) {
            this.o = ((i.h) iVar).f4902b;
        } else if (jVar == i.j.EndTag && ((i.g) iVar).j != null) {
            j("Attributes incorrectly present on end tag");
        }
    }

    public void h() {
        i.AbstractC0117i iVar = this.i;
        if (iVar.f4904d != null) {
            iVar.r();
        }
        g(this.i);
    }

    public void i(l lVar) {
        if (this.f4913b.a()) {
            this.f4913b.add(new d(this.f4912a.t(), "Unexpectedly reached end of file (EOF) in input state [%s]", lVar));
        }
    }

    public void j(String str) {
        if (this.f4913b.a()) {
            this.f4913b.add(new d(this.f4912a.t(), str));
        }
    }

    public void k(l lVar) {
        if (this.f4913b.a()) {
            this.f4913b.add(new d(this.f4912a.t(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.f4912a.k()), lVar));
        }
    }

    public boolean l() {
        return this.o != null && this.i.p().equalsIgnoreCase(this.o);
    }
}
