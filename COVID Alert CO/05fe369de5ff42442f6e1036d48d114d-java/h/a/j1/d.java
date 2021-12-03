package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.j1.a;
import h.a.j1.f;
import h.a.j1.y2;
import h.a.j1.z1;
import h.a.k;
import h.a.l;
import java.io.InputStream;

public abstract class d implements x2 {

    public static abstract class a implements f.i, z1.b {
        public c0 b;
        public final Object c = new Object();

        /* renamed from: d  reason: collision with root package name */
        public final c3 f3838d;

        /* renamed from: e  reason: collision with root package name */
        public int f3839e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f3840f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f3841g;

        public a(int i2, w2 w2Var, c3 c3Var) {
            b.z(w2Var, "statsTraceCtx");
            b.z(c3Var, "transportTracer");
            this.f3838d = c3Var;
            this.b = new z1(this, k.b.a, i2, w2Var, c3Var);
        }

        @Override // h.a.j1.z1.b
        public void a(y2.a aVar) {
            ((a.c) this).f3803j.a(aVar);
        }

        public final void d() {
            boolean z;
            synchronized (this.c) {
                synchronized (this.c) {
                    z = this.f3840f && this.f3839e < 32768 && !this.f3841g;
                }
            }
            if (z) {
                ((a.c) this).f3803j.c();
            }
        }
    }

    @Override // h.a.j1.x2
    public final void b(l lVar) {
        o0 o0Var = ((a) this).b;
        b.z(lVar, "compressor");
        o0Var.b(lVar);
    }

    @Override // h.a.j1.x2
    public final void flush() {
        a aVar = (a) this;
        if (!aVar.b.c()) {
            aVar.b.flush();
        }
    }

    @Override // h.a.j1.x2
    public final void h(InputStream inputStream) {
        b.z(inputStream, "message");
        try {
            if (!((a) this).b.c()) {
                ((a) this).b.d(inputStream);
            }
        } finally {
            q0.b(inputStream);
        }
    }
}
