package e.l.a;

import android.os.SystemClock;
import android.view.Choreographer;
import e.e.h;
import java.util.ArrayList;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f1542g = new ThreadLocal<>();
    public final h<b, Long> a = new h<>();
    public final ArrayList<b> b = new ArrayList<>();
    public final C0041a c = new C0041a();

    /* renamed from: d  reason: collision with root package name */
    public c f1543d;

    /* renamed from: e  reason: collision with root package name */
    public long f1544e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1545f = false;

    /* renamed from: e.l.a.a$a  reason: collision with other inner class name */
    public class C0041a {
        public C0041a() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0046 A[SYNTHETIC] */
        public void a() {
            boolean z;
            a.this.f1544e = SystemClock.uptimeMillis();
            a aVar = a.this;
            long j2 = aVar.f1544e;
            long uptimeMillis = SystemClock.uptimeMillis();
            for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                b bVar = aVar.b.get(i2);
                if (bVar != null) {
                    Long orDefault = aVar.a.getOrDefault(bVar, null);
                    if (orDefault != null) {
                        if (orDefault.longValue() < uptimeMillis) {
                            aVar.a.remove(bVar);
                        } else {
                            z = false;
                            if (!z) {
                                bVar.a(j2);
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                }
            }
            if (aVar.f1545f) {
                int size = aVar.b.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    } else if (aVar.b.get(size) == null) {
                        aVar.b.remove(size);
                    }
                }
                aVar.f1545f = false;
            }
            if (a.this.b.size() > 0) {
                a aVar2 = a.this;
                if (aVar2.f1543d == null) {
                    aVar2.f1543d = new d(aVar2.c);
                }
                d dVar = (d) aVar2.f1543d;
                dVar.b.postFrameCallback(dVar.c);
            }
        }
    }

    public interface b {
        boolean a(long j2);
    }

    public static abstract class c {
        public final C0041a a;

        public c(C0041a aVar) {
            this.a = aVar;
        }
    }

    public static class d extends c {
        public final Choreographer b = Choreographer.getInstance();
        public final Choreographer.FrameCallback c = new Choreographer$FrameCallbackC0042a();

        /* renamed from: e.l.a.a$d$a  reason: collision with other inner class name */
        public class Choreographer$FrameCallbackC0042a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC0042a() {
            }

            public void doFrame(long j2) {
                d.this.a.a();
            }
        }

        public d(C0041a aVar) {
            super(aVar);
        }
    }

    public static a a() {
        ThreadLocal<a> threadLocal = f1542g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }
}
