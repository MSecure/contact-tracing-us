package e.j.g;

import android.os.Handler;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class o<T> implements Runnable {
    public Callable<T> b;
    public e.j.i.a<T> c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f1598d;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ e.j.i.a b;
        public final /* synthetic */ Object c;

        public a(o oVar, e.j.i.a aVar, Object obj) {
            this.b = aVar;
            this.c = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            this.b.a(this.c);
        }
    }

    public o(Handler handler, Callable<T> callable, e.j.i.a<T> aVar) {
        this.b = callable;
        this.c = aVar;
        this.f1598d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T t;
        try {
            t = this.b.call();
        } catch (Exception unused) {
            t = null;
        }
        this.f1598d.post(new a(this, this.c, t));
    }
}
