package h.a.l1.a;

import f.b.g.b1;
import f.b.g.d0;
import f.b.g.k;
import f.b.g.r;
import f.b.g.t0;
import h.a.c1;
import h.a.e1;
import h.a.g0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class b {
    public static volatile r a = r.a();

    public static final class a<T extends t0> implements Object<T> {
        public static final ThreadLocal<Reference<byte[]>> c = new ThreadLocal<>();
        public final b1<T> a;
        public final T b;

        public a(T t) {
            this.b = t;
            this.a = (b1<T>) t.getParserForType();
        }

        public Object a(InputStream inputStream) {
            byte[] bArr;
            if ((inputStream instanceof a) && ((a) inputStream).c == this.a) {
                try {
                    t0 t0Var = ((a) inputStream).b;
                    if (t0Var != null) {
                        return t0Var;
                    }
                    throw new IllegalStateException("message not available");
                } catch (IllegalStateException unused) {
                }
            }
            k kVar = null;
            try {
                if (inputStream instanceof g0) {
                    int available = inputStream.available();
                    if (available > 0 && available <= 4194304) {
                        ThreadLocal<Reference<byte[]>> threadLocal = c;
                        Reference<byte[]> reference = threadLocal.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < available) {
                            bArr = new byte[available];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i2 = available;
                        while (true) {
                            if (i2 <= 0) {
                                break;
                            }
                            int read = inputStream.read(bArr, available - i2, i2);
                            if (read == -1) {
                                break;
                            }
                            i2 -= read;
                        }
                        if (i2 == 0) {
                            kVar = k.h(bArr, 0, available, false);
                        } else {
                            throw new RuntimeException("size inaccurate: " + available + " != " + (available - i2));
                        }
                    } else if (available == 0) {
                        return this.b;
                    }
                }
                if (kVar == null) {
                    kVar = k.f(inputStream);
                }
                kVar.c = Integer.MAX_VALUE;
                try {
                    T a2 = this.a.a(kVar, b.a);
                    try {
                        kVar.a(0);
                        return a2;
                    } catch (d0 e2) {
                        e2.b = a2;
                        throw e2;
                    }
                } catch (d0 e3) {
                    throw new e1(c1.m.g("Invalid protobuf byte sequence").f(e3));
                }
            } catch (IOException e4) {
                throw new RuntimeException(e4);
            }
        }

        public InputStream b(Object obj) {
            return new a((t0) obj, this.a);
        }
    }
}
