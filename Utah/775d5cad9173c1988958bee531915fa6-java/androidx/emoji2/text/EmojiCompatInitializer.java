package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Trace;
import androidx.lifecycle.ProcessLifecycleInitializer;
import e.i.e.f;
import e.m.a.e;
import e.q.h;
import e.q.k;
import e.q.l;
import e.q.m;
import e.q.u;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class EmojiCompatInitializer implements e.x.b<Boolean> {

    public static class a extends e.c {
        public a(Context context) {
            super(new b(context));
            this.b = 1;
        }
    }

    public static class b implements e.g {
        public final Context a;
        public HandlerThread b;

        public b(Context context) {
            this.a = context.getApplicationContext();
        }

        @Override // e.m.a.e.g
        public void a(e.h hVar) {
            HandlerThread handlerThread = new HandlerThread("EmojiCompatInitializer", 10);
            this.b = handlerThread;
            handlerThread.start();
            Handler handler = new Handler(this.b.getLooper());
            handler.post(new e.m.a.a(this, hVar, handler));
        }

        public void b() {
            HandlerThread handlerThread = this.b;
            if (handlerThread != null) {
                handlerThread.quitSafely();
            }
        }
    }

    public static class c {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static class d implements Runnable {
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

    @Override // e.x.b
    public List<Class<? extends e.x.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // e.x.b
    public /* bridge */ /* synthetic */ Boolean b(Context context) {
        c(context);
        return Boolean.TRUE;
    }

    public Boolean c(Context context) {
        a aVar = new a(context);
        if (e.f1633k == null) {
            synchronized (e.f1632j) {
                if (e.f1633k == null) {
                    e.f1633k = new e(aVar);
                }
            }
        }
        e.x.a b2 = e.x.a.b(context);
        Objects.requireNonNull(b2);
        final h a2 = ((l) b2.a(ProcessLifecycleInitializer.class, new HashSet())).a();
        a2.a(new k() {
            /* class androidx.emoji2.text.EmojiCompatInitializer.AnonymousClass1 */

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
