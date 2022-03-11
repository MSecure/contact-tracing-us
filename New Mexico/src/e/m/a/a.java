package e.m.a;

import android.os.SystemClock;
import android.view.Choreographer;
import e.f.h;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<a> f1696g = new ThreadLocal<>();

    /* renamed from: d  reason: collision with root package name */
    public c f1697d;
    public final h<b, Long> a = new h<>();
    public final ArrayList<b> b = new ArrayList<>();
    public final C0047a c = new C0047a();

    /* renamed from: e  reason: collision with root package name */
    public long f1698e = 0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1699f = false;

    /* renamed from: e.m.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0047a {
        public C0047a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0046 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void a() {
            boolean z;
            a.this.f1698e = SystemClock.uptimeMillis();
            a aVar = a.this;
            long j2 = aVar.f1698e;
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
            if (aVar.f1699f) {
                int size = aVar.b.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    } else if (aVar.b.get(size) == null) {
                        aVar.b.remove(size);
                    }
                }
                aVar.f1699f = false;
            }
            if (a.this.b.size() > 0) {
                a aVar2 = a.this;
                if (aVar2.f1697d == null) {
                    aVar2.f1697d = new d(aVar2.c);
                }
                d dVar = (d) aVar2.f1697d;
                dVar.b.postFrameCallback(dVar.c);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(long j2);
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public final C0047a a;

        public c(C0047a aVar) {
            this.a = aVar;
        }
    }

    /* loaded from: classes.dex */
    public static class d extends c {
        public final Choreographer b = Choreographer.getInstance();
        public final Choreographer.FrameCallback c = new Choreographer$FrameCallbackC0048a();

        /* renamed from: e.m.a.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class Choreographer$FrameCallbackC0048a implements Choreographer.FrameCallback {
            public Choreographer$FrameCallbackC0048a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                d.this.a.a();
            }
        }

        public d(C0047a aVar) {
            super(aVar);
        }
    }

    public static a a() {
        ThreadLocal<a> threadLocal = f1696g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }
}
