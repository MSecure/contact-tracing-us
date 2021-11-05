package c.b.c.a.m0;

import c.b.c.a.h0.c;
import c.b.c.a.o;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;

public class h0 implements o {

    /* renamed from: a  reason: collision with root package name */
    public final c f3747a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3748b;

    public h0(c cVar, int i) {
        this.f3747a = cVar;
        this.f3748b = i;
        if (i >= 10) {
            cVar.a(new byte[0], i);
            return;
        }
        throw new InvalidAlgorithmParameterException("tag size too small, need at least 10 bytes");
    }

    @Override // c.b.c.a.o
    public void a(byte[] bArr, byte[] bArr2) {
        if (!c.b.a.a.c.n.c.K0(this.f3747a.a(bArr2, this.f3748b), bArr)) {
            throw new GeneralSecurityException("invalid MAC");
        }
    }

    @Override // c.b.c.a.o
    public byte[] b(byte[] bArr) {
        return this.f3747a.a(bArr, this.f3748b);
    }
}
