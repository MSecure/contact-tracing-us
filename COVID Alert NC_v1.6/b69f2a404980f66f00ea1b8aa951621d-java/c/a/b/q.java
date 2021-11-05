package c.a.b;

import c.a.b.b;

public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f2234a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f2235b;

    /* renamed from: c  reason: collision with root package name */
    public final v f2236c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2237d;

    public interface a {
        void a(v vVar);
    }

    public interface b<T> {
        void a(T t);
    }

    public q(v vVar) {
        this.f2237d = false;
        this.f2234a = null;
        this.f2235b = null;
        this.f2236c = vVar;
    }

    public q(T t, b.a aVar) {
        this.f2237d = false;
        this.f2234a = t;
        this.f2235b = aVar;
        this.f2236c = null;
    }
}
