package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Trace;
import androidx.lifecycle.ProcessLifecycleInitializer;
import e.j.f.f;
import e.n.a.e;
import e.r.h;
import e.r.k;
import e.r.l;
import e.r.m;
import e.r.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class EmojiCompatInitializer implements e.y.b<Boolean> {

    /* loaded from: classes.dex */
    public static class a extends e.c {
        public a(Context context) {
            super(new b(context));
            this.b = 1;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.g {
        public final Context a;
        public HandlerThread b;

        public b(Context context) {
            this.a = context.getApplicationContext();
        }

        @Override // e.n.a.e.g
        public void a(e.h hVar) {
            HandlerThread handlerThread = new HandlerThread("EmojiCompatInitializer", 10);
            this.b = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.b.getLooper());
            handler.post(new e.n.a.a(this, hVar, handler));
        }

        public void b() {
            HandlerThread handlerThread = this.b;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                int i2 = f.a;
                Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                if (e.c()) {
                    e.a().e();
                }
                Trace.endSection();
            } catch (Throwable th) {
                int i3 = f.a;
                Trace.endSection();
                throw th;
            }
        }
    }

    @Override // e.y.b
    public List<Class<? extends e.y.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // e.y.b
    public /* bridge */ /* synthetic */ Boolean b(Context context) {
        c(context);
        return Boolean.TRUE;
    }

    public Boolean c(Context context) {
        a aVar = new a(context);
        if (e.f1718k == null) {
            synchronized (e.f1717j) {
                if (e.f1718k == null) {
                    e.f1718k = new e(aVar);
                }
            }
        }
        e.y.a b2 = e.y.a.b(context);
        Objects.requireNonNull(b2);
        final h a2 = ((l) b2.a(ProcessLifecycleInitializer.class, new HashSet())).a();
        a2.a(new k() { // from class: androidx.emoji2.text.EmojiCompatInitializer.1
            @u(h.a.ON_RESUME)
            public void onResume() {
                Objects.requireNonNull(EmojiCompatInitializer.this);
                (Build.VERSION.SDK_INT >= 28 ? c.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new d(), 500);
                m mVar = (m) a2;
                mVar.d("removeObserver");
                mVar.a.l(this);
            }
        });
        return Boolean.TRUE;
    }
}
