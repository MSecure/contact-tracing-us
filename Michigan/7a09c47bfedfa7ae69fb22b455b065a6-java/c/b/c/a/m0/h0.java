package c.b.c.a.m0;

import b.x.t;
import c.b.c.a.h0.c;
import c.b.c.a.o;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public class h0 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final c f5144a;

    /* renamed from: b  reason: collision with root package name */
    public final int f5145b;

    public h0(c cVar, int i) {
        this.f5144a = cVar;
        this.f5145b = i;
        if (i >= 10) {
            cVar.a(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // c.b.c.a.o
    public void a(byte[] bArr, byte[] bArr2) {
        if (!t.k1(this.f5144a.a(bArr2, this.f5145b), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // c.b.c.a.o
    public byte[] b(byte[] bArr) {
        return this.f5144a.a(bArr, this.f5145b);
    }
}
