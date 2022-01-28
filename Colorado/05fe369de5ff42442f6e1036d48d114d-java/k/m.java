package k;

import f.a.a.a.a;
import java.nio.charset.Charset;
import java.util.Objects;

public final class m implements f {
    public final e b = new e();
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4268d;

    public m(r rVar) {
        Objects.requireNonNull(rVar, "sink == null");
        this.c = rVar;
    }

    @Override // k.f
    public f G(int i2) {
        if (!this.f4268d) {
            this.b.V(i2);
            c();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // k.f
    public f a(byte[] bArr) {
        if (!this.f4268d) {
            e eVar = this.b;
            Objects.requireNonNull(eVar);
            if (bArr != null) {
                eVar.U(bArr, 0, bArr.length);
                c();
                return this;
            }
            throw new IllegalArgumentException("source == null");
        }
        throw new IllegalStateException("closed");
    }

    public f c() {
        if (!this.f4268d) {
            long d2 = this.b.d();
            if (d2 > 0) {
                this.c.h(this.b, d2);
            }
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, k.r
    public void close() {
        if (!this.f4268d) {
            Throwable th = null;
            try {
                e eVar = this.b;
                long j2 = eVar.c;
                if (j2 > 0) {
                    this.c.h(eVar, j2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.c.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f4268d = true;
            if (th != null) {
                Charset charset = u.a;
                throw th;
            }
        }
    }

    public f d(String str) {
        if (!this.f4268d) {
            this.b.Y(str);
            c();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    @Override // k.f, k.r, java.io.Flushable
    public void flush() {
        if (!this.f4268d) {
            e eVar = this.b;
            long j2 = eVar.c;
            if (j2 > 0) {
                this.c.h(eVar, j2);
            }
            this.c.flush();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // k.r
    public void h(e eVar, long j2) {
        if (!this.f4268d) {
            this.b.h(eVar, j2);
            c();
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // k.f
    public f q(int i2) {
        if (!this.f4268d) {
            this.b.X(i2);
            c();
            return this;
        }
        throw new IllegalStateException("closed");
    }

    public String toString() {
        StringBuilder i2 = a.i("buffer(");
        i2.append(this.c);
        i2.append(")");
        return i2.toString();
    }

    @Override // k.f
    public f u(int i2) {
        if (!this.f4268d) {
            this.b.W(i2);
            c();
            return this;
        }
        throw new IllegalStateException("closed");
    }
}
