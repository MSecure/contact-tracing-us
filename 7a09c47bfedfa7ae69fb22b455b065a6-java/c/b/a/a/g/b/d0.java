package c.b.a.a.g.b;

import c.a.a.a.a;

public class d0 extends y {

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f3242e;

    public d0(byte[] bArr) {
        this.f3242e = bArr;
    }

    @Override // c.b.a.a.g.b.y
    public byte e(int i) {
        return this.f3242e[i];
    }

    @Override // c.b.a.a.g.b.y
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y) || size() != ((y) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return obj.equals(this);
        }
        d0 d0Var = (d0) obj;
        int i = this.f3476b;
        int i2 = d0Var.f3476b;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        int size = size();
        if (size > d0Var.size()) {
            int size2 = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(size);
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        } else if (size <= d0Var.size()) {
            byte[] bArr = this.f3242e;
            byte[] bArr2 = d0Var.f3242e;
            int j = j() + size;
            int j2 = j();
            int j3 = d0Var.j();
            while (j2 < j) {
                if (bArr[j2] != bArr2[j3]) {
                    return false;
                }
                j2++;
                j3++;
            }
            return true;
        } else {
            throw new IllegalArgumentException(a.k(59, "Ran off end of other: 0, ", size, ", ", d0Var.size()));
        }
    }

    public int j() {
        return 0;
    }

    @Override // c.b.a.a.g.b.y
    public int size() {
        return this.f3242e.length;
    }
}
