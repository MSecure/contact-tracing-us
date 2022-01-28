package c.b.a.a.g.b;

public final class c0 {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f3234a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f3235b;

    public c0(int i, z zVar) {
        byte[] bArr = new byte[i];
        this.f3235b = bArr;
        this.f3234a = g0.F(bArr);
    }

    public final y a() {
        if (this.f3234a.m() == 0) {
            return new d0(this.f3235b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }
}
