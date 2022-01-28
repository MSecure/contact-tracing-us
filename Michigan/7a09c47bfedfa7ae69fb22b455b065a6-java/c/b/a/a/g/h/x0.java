package c.b.a.a.g.h;

import c.a.a.a.a;

public class x0 extends q0 {

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f4062e;

    public x0(byte[] bArr) {
        if (bArr != null) {
            this.f4062e = bArr;
            return;
        }
        throw null;
    }

    @Override // c.b.a.a.g.h.q0
    public byte c(int i) {
        return this.f4062e[i];
    }

    @Override // c.b.a.a.g.h.q0
    public byte e(int i) {
        return this.f4062e[i];
    }

    @Override // c.b.a.a.g.h.q0
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0) || size() != ((q0) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return obj.equals(this);
        }
        x0 x0Var = (x0) obj;
        int i = this.f4008b;
        int i2 = x0Var.f4008b;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > x0Var.size()) {
            int size2 = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(size);
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        } else if (size <= x0Var.size()) {
            byte[] bArr = this.f4062e;
            byte[] bArr2 = x0Var.f4062e;
            int p = p() + size;
            int p2 = p();
            int p3 = x0Var.p();
            while (p2 < p) {
                if (bArr[p2] != bArr2[p3]) {
                    return false;
                }
                p2++;
                p3++;
            }
            return true;
        } else {
            throw new IllegalArgumentException(a.k(59, "Ran off end of other: 0, ", size, ", ", x0Var.size()));
        }
    }

    @Override // c.b.a.a.g.h.q0
    public final q0 l(int i, int i2) {
        int h = q0.h(0, i2, size());
        return h == 0 ? q0.f4006c : new v0(this.f4062e, p(), h);
    }

    public int p() {
        return 0;
    }

    @Override // c.b.a.a.g.h.q0
    public int size() {
        return this.f4062e.length;
    }
}
