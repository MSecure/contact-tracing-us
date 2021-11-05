package b.c.a.a;

import java.util.concurrent.Executor;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f767c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f768d = new ExecutorC0013a();

    /* renamed from: a  reason: collision with root package name */
    public c f769a;

    /* renamed from: b  reason: collision with root package name */
    public c f770b;

    /* renamed from: b.c.a.a.a$a  reason: collision with other inner class name */
    public static class ExecutorC0013a implements Executor {
        public void execute(Runnable runnable) {
            a.d().f769a.a(runnable);
        }
    }

    public a() {
        b bVar = new b();
        this.f770b = bVar;
        this.f769a = bVar;
    }

    public static a d() {
        if (f767c != null) {
            return f767c;
        }
        synchronized (a.class) {
            if (f767c == null) {
                f767c = new a();
            }
        }
        return f767c;
    }

    @Override // b.c.a.a.c
    public void a(Runnable runnable) {
        this.f769a.a(runnable);
    }

    @Override // b.c.a.a.c
    public boolean b() {
        return this.f769a.b();
    }

    @Override // b.c.a.a.c
    public void c(Runnable runnable) {
        this.f769a.c(runnable);
    }
}
