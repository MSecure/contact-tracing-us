package f.b.a.b.i.s.h;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import f.b.a.b.i.i;
import f.b.a.b.i.s.i.c;
import f.b.a.b.i.t.a;
import f.b.a.b.i.t.b;
/* loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {
    public final l b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2643d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f2644e;

    public g(l lVar, i iVar, int i2, Runnable runnable) {
        this.b = lVar;
        this.c = iVar;
        this.f2643d = i2;
        this.f2644e = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        try {
            l lVar = this.b;
            i iVar = this.c;
            int i2 = this.f2643d;
            runnable = this.f2644e;
            try {
                b bVar = lVar.f2649f;
                c cVar = lVar.c;
                cVar.getClass();
                bVar.c(new b.a(cVar) { // from class: f.b.a.b.i.s.h.j
                    public final c a;

                    {
                        this.a = r1;
                    }

                    @Override // f.b.a.b.i.t.b.a
                    public Object a() {
                        return Integer.valueOf(this.a.g());
                    }
                });
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) lVar.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (!(activeNetworkInfo != null && activeNetworkInfo.isConnected())) {
                    lVar.f2649f.c(new b.a(lVar, iVar, i2) { // from class: f.b.a.b.i.s.h.k
                        public final l a;
                        public final i b;
                        public final int c;

                        {
                            this.a = r1;
                            this.b = r2;
                            this.c = r3;
                        }

                        @Override // f.b.a.b.i.t.b.a
                        public Object a() {
                            l lVar2 = this.a;
                            lVar2.f2647d.a(this.b, this.c + 1);
                            return null;
                        }
                    });
                } else {
                    lVar.a(iVar, i2);
                }
            } catch (a unused) {
                lVar.f2647d.a(iVar, i2 + 1);
            }
        } finally {
            runnable.run();
        }
    }
}
