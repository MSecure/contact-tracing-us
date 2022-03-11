package k;

import java.util.Arrays;
/* loaded from: classes.dex */
public final class q extends h {

    /* renamed from: g  reason: collision with root package name */
    public final transient byte[][] f4594g;

    /* renamed from: h  reason: collision with root package name */
    public final transient int[] f4595h;

    public q(e eVar, int i2) {
        super(null);
        u.b(eVar.c, 0, (long) i2);
        o oVar = eVar.b;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            int i6 = oVar.c;
            int i7 = oVar.b;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                oVar = oVar.f4592f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        this.f4594g = new byte[i5];
        this.f4595h = new int[i5 * 2];
        o oVar2 = eVar.b;
        int i8 = 0;
        while (i3 < i2) {
            byte[][] bArr = this.f4594g;
            bArr[i8] = oVar2.a;
            int i9 = oVar2.c;
            int i10 = oVar2.b;
            int i11 = (i9 - i10) + i3;
            i3 = i11 > i2 ? i2 : i11;
            int[] iArr = this.f4595h;
            iArr[i8] = i3;
            iArr[bArr.length + i8] = i10;
            oVar2.f4590d = true;
            i8++;
            oVar2 = oVar2.f4592f;
        }
    }

    @Override // k.h
    public String a() {
        return t().a();
    }

    @Override // k.h
    public byte c(int i2) {
        u.b((long) this.f4595h[this.f4594g.length - 1], (long) i2, 1);
        int s = s(i2);
        int i3 = s == 0 ? 0 : this.f4595h[s - 1];
        int[] iArr = this.f4595h;
        byte[][] bArr = this.f4594g;
        return bArr[s][(i2 - i3) + iArr[bArr.length + s]];
    }

    @Override // k.h
    public String e() {
        return t().e();
    }

    @Override // k.h, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hVar.l() == l() && h(0, hVar, 0, l())) {
                return true;
            }
        }
        return false;
    }

    @Override // k.h
    public boolean h(int i2, h hVar, int i3, int i4) {
        if (i2 < 0 || i2 > l() - i4) {
            return false;
        }
        int s = s(i2);
        while (i4 > 0) {
            int i5 = s == 0 ? 0 : this.f4595h[s - 1];
            int min = Math.min(i4, ((this.f4595h[s] - i5) + i5) - i2);
            int[] iArr = this.f4595h;
            byte[][] bArr = this.f4594g;
            if (!hVar.i(i3, bArr[s], (i2 - i5) + iArr[bArr.length + s], min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            s++;
        }
        return true;
    }

    @Override // k.h, java.lang.Object
    public int hashCode() {
        int i2 = this.c;
        if (i2 != 0) {
            return i2;
        }
        int length = this.f4594g.length;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (i3 < length) {
            byte[] bArr = this.f4594g[i3];
            int[] iArr = this.f4595h;
            int i6 = iArr[length + i3];
            int i7 = iArr[i3];
            int i8 = (i7 - i4) + i6;
            while (i6 < i8) {
                i5 = (i5 * 31) + bArr[i6];
                i6++;
            }
            i3++;
            i4 = i7;
        }
        this.c = i5;
        return i5;
    }

    @Override // k.h
    public boolean i(int i2, byte[] bArr, int i3, int i4) {
        if (i2 < 0 || i2 > l() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int s = s(i2);
        while (i4 > 0) {
            int i5 = s == 0 ? 0 : this.f4595h[s - 1];
            int min = Math.min(i4, ((this.f4595h[s] - i5) + i5) - i2);
            int[] iArr = this.f4595h;
            byte[][] bArr2 = this.f4594g;
            if (!u.a(bArr2[s], (i2 - i5) + iArr[bArr2.length + s], bArr, i3, min)) {
                return false;
            }
            i2 += min;
            i3 += min;
            i4 -= min;
            s++;
        }
        return true;
    }

    @Override // k.h
    public int l() {
        return this.f4595h[this.f4594g.length - 1];
    }

    @Override // k.h
    public h m(int i2, int i3) {
        return t().m(i2, i3);
    }

    @Override // k.h
    public h n() {
        return t().n();
    }

    @Override // k.h
    public byte[] o() {
        int[] iArr = this.f4595h;
        byte[][] bArr = this.f4594g;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr2 = this.f4595h;
            int i4 = iArr2[length + i2];
            int i5 = iArr2[i2];
            System.arraycopy(this.f4594g[i2], i4, bArr2, i3, i5 - i3);
            i2++;
            i3 = i5;
        }
        return bArr2;
    }

    @Override // k.h
    public String q() {
        return t().q();
    }

    @Override // k.h
    public void r(e eVar) {
        int length = this.f4594g.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int[] iArr = this.f4595h;
            int i4 = iArr[length + i2];
            int i5 = iArr[i2];
            o oVar = new o(this.f4594g[i2], i4, (i4 + i5) - i3);
            o oVar2 = eVar.b;
            if (oVar2 == null) {
                oVar.f4593g = oVar;
                oVar.f4592f = oVar;
                eVar.b = oVar;
            } else {
                oVar2.f4593g.b(oVar);
            }
            i2++;
            i3 = i5;
        }
        eVar.c += (long) i3;
    }

    public final int s(int i2) {
        int binarySearch = Arrays.binarySearch(this.f4595h, 0, this.f4594g.length, i2 + 1);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public final h t() {
        return new h(o());
    }

    @Override // k.h, java.lang.Object
    public String toString() {
        return t().toString();
    }
}
