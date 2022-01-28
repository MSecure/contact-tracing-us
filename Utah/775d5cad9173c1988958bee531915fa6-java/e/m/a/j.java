package e.m.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Trace;
import e.b.a.m;
import e.i.e.f;
import e.i.f.d;
import e.i.f.k;
import e.i.f.l;
import e.m.a.e;
import java.nio.ByteBuffer;
import java.util.Objects;

public class j extends e.c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f1647d = new a();

    public static class a {
    }

    public static class b implements e.g {
        public final Context a;
        public final e.i.f.e b;
        public final a c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f1648d = new Object();

        /* renamed from: e  reason: collision with root package name */
        public Handler f1649e;

        /* renamed from: f  reason: collision with root package name */
        public HandlerThread f1650f;

        /* renamed from: g  reason: collision with root package name */
        public e.h f1651g;

        /* renamed from: h  reason: collision with root package name */
        public ContentObserver f1652h;

        /* renamed from: i  reason: collision with root package name */
        public Runnable f1653i;

        public class a implements Runnable {
            public final /* synthetic */ e.h b;

            public a(e.h hVar) {
                this.b = hVar;
            }

            public void run() {
                b bVar = b.this;
                bVar.f1651g = this.b;
                bVar.c();
            }
        }

        public b(Context context, e.i.f.e eVar, a aVar) {
            m.e.q(context, "Context cannot be null");
            m.e.q(eVar, "FontRequest cannot be null");
            this.a = context.getApplicationContext();
            this.b = eVar;
            this.c = aVar;
        }

        @Override // e.m.a.e.g
        public void a(e.h hVar) {
            m.e.q(hVar, "LoaderCallback cannot be null");
            synchronized (this.f1648d) {
                try {
                    int i2 = f.a;
                    Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.threadCreation");
                    if (this.f1649e == null) {
                        HandlerThread handlerThread = new HandlerThread("emojiCompat", 10);
                        this.f1650f = handlerThread;
                        handlerThread.start();
                        this.f1649e = new Handler(this.f1650f.getLooper());
                    }
                    Trace.endSection();
                    this.f1649e.post(new a(hVar));
                } catch (Throwable th) {
                    int i3 = f.a;
                    Trace.endSection();
                    throw th;
                }
            }
        }

        public final void b() {
            this.f1651g = null;
            ContentObserver contentObserver = this.f1652h;
            if (contentObserver != null) {
                a aVar = this.c;
                Context context = this.a;
                Objects.requireNonNull(aVar);
                context.getContentResolver().unregisterContentObserver(contentObserver);
                this.f1652h = null;
            }
            synchronized (this.f1648d) {
                this.f1649e.removeCallbacks(this.f1653i);
                HandlerThread handlerThread = this.f1650f;
                if (handlerThread != null) {
                    handlerThread.quit();
                }
                this.f1649e = null;
                this.f1650f = null;
            }
        }

        public void c() {
            if (this.f1651g != null) {
                try {
                    l d2 = d();
                    int i2 = d2.f1512e;
                    if (i2 == 2) {
                        synchronized (this.f1648d) {
                        }
                    }
                    if (i2 == 0) {
                        try {
                            int i3 = f.a;
                            Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            a aVar = this.c;
                            Context context = this.a;
                            Objects.requireNonNull(aVar);
                            Typeface b2 = e.i.c.e.a.b(context, null, new l[]{d2}, 0);
                            ByteBuffer V0 = m.e.V0(this.a, null, d2.a);
                            if (V0 != null) {
                                try {
                                    Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                    k kVar = new k(b2, m.e.g1(V0));
                                    Trace.endSection();
                                    Trace.endSection();
                                    this.f1651g.b(kVar);
                                    b();
                                } catch (Throwable th) {
                                    throw th;
                                }
                            } else {
                                throw new RuntimeException("Unable to open file.");
                            }
                        } finally {
                            int i4 = f.a;
                            Trace.endSection();
                        }
                    } else {
                        throw new RuntimeException("fetchFonts result is not OK. (" + i2 + ")");
                    }
                } catch (Throwable th2) {
                    this.f1651g.a(th2);
                    b();
                }
            }
        }

        public final l d() {
            try {
                a aVar = this.c;
                Context context = this.a;
                e.i.f.e eVar = this.b;
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

    public j(Context context, e.i.f.e eVar) {
        super(new b(context, eVar, f1647d));
    }
}
