package c.a.b;

import c.a.b.b;

public class q<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f2847a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f2848b;

    /* renamed from: c  reason: collision with root package name */
    public final v f2849c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2850d;

    public interface a {
        void a(v vVar);
    }

    public interface b<T> {
        void a(T t);
    }

    public q(v vVar) {
        this.f2850d = false;
        this.f2847a = null;
        this.f2848b = null;
        this.f2849c = vVar;
    }

    public q(T t, b.a aVar) {
        this.f2850d = false;
        this.f2847a = t;
        this.f2848b = aVar;
        this.f2849c = null;
    }
}
