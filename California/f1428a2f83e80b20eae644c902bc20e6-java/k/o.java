package k;

public final class o {
    public final byte[] a;
    public int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4011d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4012e;

    /* renamed from: f  reason: collision with root package name */
    public o f4013f;

    /* renamed from: g  reason: collision with root package name */
    public o f4014g;

    public o() {
        this.a = new byte[8192];
        this.f4012e = true;
        this.f4011d = false;
    }

    public o(o oVar) {
        byte[] bArr = oVar.a;
        int i2 = oVar.b;
        int i3 = oVar.c;
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.f4012e = false;
        this.f4011d = true;
        oVar.f4011d = true;
    }

    public o(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.b = i2;
        this.c = i3;
        this.f4012e = false;
        this.f4011d = true;
    }

    public o a() {
        o oVar = this.f4013f;
        o oVar2 = oVar != this ? oVar : null;
        o oVar3 = this.f4014g;
        oVar3.f4013f = oVar;
        this.f4013f.f4014g = oVar3;
        this.f4013f = null;
        this.f4014g = null;
        return oVar2;
    }

    public o b(o oVar) {
        oVar.f4014g = this;
        oVar.f4013f = this.f4013f;
        this.f4013f.f4014g = oVar;
        this.f4013f = oVar;
        return oVar;
    }

    public void c(o oVar, int i2) {
        if (oVar.f4012e) {
            int i3 = oVar.c;
            if (i3 + i2 > 8192) {
                if (!oVar.f4011d) {
                    int i4 = oVar.b;
                    if ((i3 + i2) - i4 <= 8192) {
                        byte[] bArr = oVar.a;
                        System.arraycopy(bArr, i4, bArr, 0, i3 - i4);
                        oVar.c -= oVar.b;
                        oVar.b = 0;
                    } else {
                        throw new IllegalArgumentException();
                    }
                } else {
                    throw new IllegalArgumentException();
                }
            }
            System.arraycopy(this.a, this.b, oVar.a, oVar.c, i2);
            oVar.c += i2;
            this.b += i2;
            return;
        }
        throw new IllegalArgumentException();
    }
}
