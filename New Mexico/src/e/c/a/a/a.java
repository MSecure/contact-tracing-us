package e.c.a.a;

import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class a extends c {
    public static volatile a c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f1073d = new ExecutorC0021a();
    public c a;
    public c b;

    /* renamed from: e.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class ExecutorC0021a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.d().a.a(runnable);
        }
    }

    public a() {
        b bVar = new b();
        this.b = bVar;
        this.a = bVar;
    }

    public static a d() {
        if (c != null) {
            return c;
        }
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
        }
        return c;
    }

    @Override // e.c.a.a.c
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // e.c.a.a.c
    public boolean b() {
        return this.a.b();
    }

    @Override // e.c.a.a.c
    public void c(Runnable runnable) {
        this.a.c(runnable);
    }
}
