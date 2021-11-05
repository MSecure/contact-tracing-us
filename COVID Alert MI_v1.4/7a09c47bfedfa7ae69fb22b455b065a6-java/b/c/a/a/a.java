package b.c.a.a;

import java.util.concurrent.Executor;

public class a extends c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f1340c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f1341d = new ExecutorC0020a();

    /* renamed from: a  reason: collision with root package name */
    public c f1342a;

    /* renamed from: b  reason: collision with root package name */
    public c f1343b;

    /* renamed from: b.c.a.a.a$a  reason: collision with other inner class name */
    public static class ExecutorC0020a implements Executor {
        public void execute(Runnable runnable) {
            a.d().f1342a.a(runnable);
        }
    }

    public a() {
        b bVar = new b();
        this.f1343b = bVar;
        this.f1342a = bVar;
    }

    public static a d() {
        if (f1340c != null) {
            return f1340c;
        }
        synchronized (a.class) {
            if (f1340c == null) {
                f1340c = new a();
            }
        }
        return f1340c;
    }

    @Override // b.c.a.a.c
    public void a(Runnable runnable) {
        this.f1342a.a(runnable);
    }

    @Override // b.c.a.a.c
    public boolean b() {
        return this.f1342a.b();
    }

    @Override // b.c.a.a.c
    public void c(Runnable runnable) {
        this.f1342a.c(runnable);
    }
}
