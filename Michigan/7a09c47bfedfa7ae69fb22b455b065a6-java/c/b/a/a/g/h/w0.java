package c.b.a.a.g.h;

public final class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final b1 f4051a;

    /* renamed from: b  reason: collision with root package name */
    public final byte[] f4052b;

    public w0(int i, s0 s0Var) {
        byte[] bArr = new byte[i];
        this.f4052b = bArr;
        this.f4051a = b1.A(bArr);
    }

    public final q0 a() {
        if (this.f4051a.E() == 0) {
            return new x0(this.f4052b);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }
}
