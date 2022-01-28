package c.b.a.a.g;

import java.util.concurrent.ExecutionException;

public final class k implements b, d, e {

    /* renamed from: a  reason: collision with root package name */
    public final Object f2860a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final int f2861b;

    /* renamed from: c  reason: collision with root package name */
    public final a0<Void> f2862c;

    /* renamed from: d  reason: collision with root package name */
    public int f2863d;

    /* renamed from: e  reason: collision with root package name */
    public int f2864e;
    public int f;
    public Exception g;
    public boolean h;

    public k(int i, a0<Void> a0Var) {
        this.f2861b = i;
        this.f2862c = a0Var;
    }

    public final void a() {
        if (this.f2863d + this.f2864e + this.f != this.f2861b) {
            return;
        }
        if (this.g != null) {
            a0<Void> a0Var = this.f2862c;
            int i = this.f2864e;
            int i2 = this.f2861b;
            StringBuilder sb = new StringBuilder(54);
            sb.append(i);
            sb.append(" out of ");
            sb.append(i2);
            sb.append(" underlying tasks failed");
            a0Var.h(new ExecutionException(sb.toString(), this.g));
        } else if (this.h) {
            this.f2862c.j();
        } else {
            this.f2862c.i(null);
        }
    }

    @Override // c.b.a.a.g.b
    public final void b() {
        synchronized (this.f2860a) {
            this.f++;
            this.h = true;
            a();
        }
    }

    @Override // c.b.a.a.g.d
    public final void c(Exception exc) {
        synchronized (this.f2860a) {
            this.f2864e++;
            this.g = exc;
            a();
        }
    }

    @Override // c.b.a.a.g.e
    public final void onSuccess(Object obj) {
        synchronized (this.f2860a) {
            this.f2863d++;
            a();
        }
    }
}
