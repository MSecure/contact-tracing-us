package k;

import f.a.a.a.a;
import java.io.EOFException;
import java.util.Objects;
/* loaded from: classes.dex */
public final class n implements g {
    public final e b = new e();
    public final s c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4589d;

    public n(s sVar) {
        Objects.requireNonNull(sVar, "source == null");
        this.c = sVar;
    }

    @Override // k.g
    public void C(long j2) {
        boolean z;
        if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.f4589d) {
            while (true) {
                e eVar = this.b;
                if (eVar.c < j2) {
                    if (this.c.m(eVar, 8192) == -1) {
                        z = false;
                        break;
                    }
                } else {
                    z = true;
                    break;
                }
            }
            if (!z) {
                throw new EOFException();
            }
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // k.g
    public boolean F() {
        if (!this.f4589d) {
            e eVar = this.b;
            if (!(eVar.c == 0) || this.c.m(eVar, 8192) != -1) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("closed");
    }

    @Override // k.g
    public byte[] I(long j2) {
        C(j2);
        return this.b.I(j2);
    }

    @Override // k.s, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f4589d) {
            this.f4589d = true;
            this.c.close();
            this.b.c();
        }
    }

    @Override // k.g
    public e l() {
        return this.b;
    }

    @Override // k.s
    public long m(e eVar, long j2) {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j2 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j2);
        } else if (!this.f4589d) {
            e eVar2 = this.b;
            if (eVar2.c == 0 && this.c.m(eVar2, 8192) == -1) {
                return -1;
            }
            return this.b.m(eVar, Math.min(j2, this.b.c));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // k.g
    public h n(long j2) {
        C(j2);
        return this.b.n(j2);
    }

    @Override // k.g
    public byte readByte() {
        C(1);
        return this.b.readByte();
    }

    @Override // k.g
    public int readInt() {
        C(4);
        return this.b.readInt();
    }

    @Override // k.g
    public short readShort() {
        C(2);
        return this.b.readShort();
    }

    @Override // k.g
    public void skip(long j2) {
        if (!this.f4589d) {
            while (j2 > 0) {
                e eVar = this.b;
                if (eVar.c == 0 && this.c.m(eVar, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j2, this.b.c);
                this.b.skip(min);
                j2 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder h2 = a.h("buffer(");
        h2.append(this.c);
        h2.append(")");
        return h2.toString();
    }
}
