package c.b.a.a.g.h;

import c.a.a.a.a;

public final class v0 extends x0 {

    /* renamed from: f  reason: collision with root package name */
    public final int f4046f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4047g;

    public v0(byte[] bArr, int i, int i2) {
        super(bArr);
        q0.h(i, i + i2, bArr.length);
        this.f4046f = i;
        this.f4047g = i2;
    }

    @Override // c.b.a.a.g.h.x0, c.b.a.a.g.h.q0
    public final byte c(int i) {
        int i2 = this.f4047g;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.f4062e[this.f4046f + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        throw new ArrayIndexOutOfBoundsException(a.k(40, "Index > length: ", i, ", ", i2));
    }

    @Override // c.b.a.a.g.h.x0, c.b.a.a.g.h.q0
    public final byte e(int i) {
        return this.f4062e[this.f4046f + i];
    }

    @Override // c.b.a.a.g.h.x0
    public final int p() {
        return this.f4046f;
    }

    @Override // c.b.a.a.g.h.x0, c.b.a.a.g.h.q0
    public final int size() {
        return this.f4047g;
    }
}
