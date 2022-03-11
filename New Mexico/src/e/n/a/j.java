package e.n.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import e.b.a.m;
import e.j.f.f;
import e.j.g.d;
import e.j.g.k;
import e.j.g.l;
import e.n.a.e;
import java.nio.ByteBuffer;
import java.util.Objects;
/* loaded from: classes.dex */
public class j extends e.c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f1732d = new a();

    /* loaded from: classes.dex */
    public static class a {
    }

    /* loaded from: classes.dex */
    public static class b implements e.g {
        public final Context a;
        public final e.j.g.e b;
        public final a c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f1733d = new Object();

        /* renamed from: e  reason: collision with root package name */
        public Handler f1734e;

        /* renamed from: f  reason: collision with root package name */
        public HandlerThread f1735f;

        /* renamed from: g  reason: collision with root package name */
        public e.h f1736g;

        /* renamed from: h  reason: collision with root package name */
        public ContentObserver f1737h;

        /* renamed from: i  reason: collision with root package name */
        public Runnable f1738i;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ e.h b;

            public a(e.h hVar) {
                this.b = hVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f1736g = this.b;
                bVar.c();
            }
        }

        public b(Context context, e.j.g.e eVar, a aVar) {
            m.e.q(context, "Context cannot be null");
            m.e.q(eVar, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = eVar;
            this.c = aVar;
        }

        @Override // e.n.a.e.g
        public void a(e.h hVar) {
            m.e.q(hVar, "LoaderCallback cannot be null");
            synchronized (this.f1733d) {
                int i2 = f.a;
                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.threadCreation");
                if (this.f1734e == null) {
                    HandlerThread handlerThread = new HandlerThread("emojiCompat", 10);
                    this.f1735f = handlerThread;
                    handlerThread.start();
                    this.f1734e = new Handler(this.f1735f.getLooper());
                }
                Trace.endSection();
                this.f1734e.post(new a(hVar));
            }
        }

        public final void b() {
            this.f1736g = null;
            ContentObserver contentObserver = this.f1737h;
            if (contentObserver != null) {
                a aVar = this.c;
                Context context = this.a;
                Objects.requireNonNull(aVar);
                context.getContentResolver().unregisterContentObserver(contentObserver);
                this.f1737h = null;
            }
            synchronized (this.f1733d) {
                this.f1734e.removeCallbacks(this.f1738i);
                HandlerThread handlerThread = this.f1735f;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.f1734e = null;
                this.f1735f = null;
            }
        }

        public void c() {
            if (this.f1736g != null) {
                try {
                    l d2 = d();
                    int i2 = d2.f1597e;
                    if (i2 == 2) {
                        synchronized (this.f1733d) {
                        }
                    }
                    if (i2 == 0) {
                        int i3 = f.a;
                        Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                        a aVar = this.c;
                        Context context = this.a;
                        Objects.requireNonNull(aVar);
                        Typeface b = e.j.c.e.a.b(context, null, new l[]{d2}, 0);
                        ByteBuffer b1 = m.e.b1(this.a, null, d2.a);
                        if (b1 != null) {
                            Trace.beginSection("EmojiCompat.MetadataRepo.create");
                            k kVar = new k(b, m.e.m1(b1));
                            Trace.endSection();
                            Trace.endSection();
                            this.f1736g.b(kVar);
                            b();
                            return;
                        }
                        throw new RuntimeException("Unable to open file.");
                    }
                    throw new RuntimeException("fetchFonts result is not OK. (" + i2 + ")");
                } catch (Throwable th) {
                    this.f1736g.a(th);
                    b();
                }
            }
        }

        public final l d() {
            try {
                a aVar = this.c;
                Context context = this.a;
                e.j.g.e eVar = this.b;
                Objects.requireNonNull(aVar);
                k a2 = d.a(context, eVar, null);
                if (a2.a == 0) {
                    l[] lVarArr = a2.b;
                    if (lVarArr != null && lVarArr.length != 0) {
                        return lVarArr[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                StringBuilder h2 = f.a.a.a.a.h("fetchFonts failed (");
                h2.append(a2.a);
                h2.append(")");
                throw new RuntimeException(h2.toString());
            } catch (PackageManager.NameNotFoundException e2) {
                throw new RuntimeException("provider not found", e2);
            }
        }
    }

    public j(Context context, e.j.g.e eVar) {
        super(new b(context, eVar, f1732d));
    }
}
