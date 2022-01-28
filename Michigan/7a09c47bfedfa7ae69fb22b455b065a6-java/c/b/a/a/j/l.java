package c.b.a.a.j;

import java.util.concurrent.ExecutionException;

public final class l implements c, e, f {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4113a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final int f4114b;

    /* renamed from: c  reason: collision with root package name */
    public final b0<Void> f4115c;

    /* renamed from: d  reason: collision with root package name */
    public int f4116d;

    /* renamed from: e  reason: collision with root package name */
    public int f4117e;

    /* renamed from: f  reason: collision with root package name */
    public int f4118f;

    /* renamed from: g  reason: collision with root package name */
    public Exception f4119g;
    public boolean h;

    public l(int i, b0<Void> b0Var) {
        this.f4114b = i;
        this.f4115c = b0Var;
    }

    public final void a() {
        if (this.f4116d + this.f4117e + this.f4118f != this.f4114b) {
            return;
        }
        if (this.f4119g != null) {
            b0<Void> b0Var = this.f4115c;
            int i = this.f4117e;
            int i2 = this.f4114b;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i);
            sb.append(" out of ");
            sb.append(i2);
            sb.append(" underlying tasks failed");
            b0Var.h(new ExecutionException(sb.toString(), this.f4119g));
        } else if (this.h) {
            this.f4115c.j();
        } else {
            this.f4115c.i(null);
        }
    }

    @Override // c.b.a.a.j.c
    public final void b() {
        synchronized (this.f4113a) {
            this.f4118f++;
            this.h = true;
            a();
        }
    }

    @Override // c.b.a.a.j.e
    public final void c(Exception exc) {
        synchronized (this.f4113a) {
            this.f4117e++;
            this.f4119g = exc;
            a();
        }
    }

    @Override // c.b.a.a.j.f
    public final void onSuccess(Object obj) {
        synchronized (this.f4113a) {
            this.f4116d++;
            a();
        }
    }
}
