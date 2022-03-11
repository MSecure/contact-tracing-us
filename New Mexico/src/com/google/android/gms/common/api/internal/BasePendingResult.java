package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import e.b.a.m;
import f.b.a.c.b.l.f;
import f.b.a.c.b.l.g;
import f.b.a.c.b.l.i;
import f.b.a.c.b.l.j;
import f.b.a.c.b.l.l.h0;
import f.b.a.c.e.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends i> extends f<R> {

    /* renamed from: f */
    public R f466f;

    /* renamed from: g */
    public Status f467g;

    /* renamed from: h */
    public volatile boolean f468h;

    /* renamed from: i */
    public boolean f469i;
    @KeepName
    public b mResultGuardian;
    public final Object a = new Object();
    public final CountDownLatch c = new CountDownLatch(1);

    /* renamed from: d */
    public final ArrayList<f.a> f464d = new ArrayList<>();

    /* renamed from: e */
    public final AtomicReference<Object> f465e = new AtomicReference<>();
    public final a<R> b = new a<>(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public static class a<R extends i> extends d {
        public a(@RecentlyNonNull Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(@RecentlyNonNull Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                Pair pair = (Pair) message.obj;
                j jVar = (j) pair.first;
                i iVar = (i) pair.second;
                try {
                    jVar.a(iVar);
                } catch (RuntimeException e2) {
                    BasePendingResult.e(iVar);
                    throw e2;
                }
            } else if (i2 != 2) {
                new Exception();
            } else {
                ((BasePendingResult) message.obj).b(Status.f459h);
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b {
        public b(h0 h0Var) {
            BasePendingResult.this = r1;
        }

        public final void finalize() {
            BasePendingResult.e(BasePendingResult.this.f466f);
            super.finalize();
        }
    }

    static {
        new h0();
    }

    @Deprecated
    public BasePendingResult() {
        new WeakReference(null);
    }

    public static void e(i iVar) {
        if (iVar instanceof g) {
            try {
                ((g) iVar).a();
            } catch (RuntimeException unused) {
                String.valueOf(iVar).length();
            }
        }
    }

    public abstract R a(@RecentlyNonNull Status status);

    @Deprecated
    public final void b(@RecentlyNonNull Status status) {
        synchronized (this.a) {
            if (!c()) {
                d(a(status));
                this.f469i = true;
            }
        }
    }

    @RecentlyNonNull
    public final boolean c() {
        return this.c.getCount() == 0;
    }

    public final void d(@RecentlyNonNull R r) {
        synchronized (this.a) {
            if (!this.f469i) {
                c();
                boolean z = true;
                m.e.t(!c(), "Results have already been set");
                if (this.f468h) {
                    z = false;
                }
                m.e.t(z, "Result has already been consumed");
                f(r);
                return;
            }
            e(r);
        }
    }

    public final void f(R r) {
        this.f466f = r;
        this.f467g = r.getStatus();
        this.c.countDown();
        if (this.f466f instanceof g) {
            this.mResultGuardian = new b(null);
        }
        ArrayList<f.a> arrayList = this.f464d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            f.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f467g);
        }
        this.f464d.clear();
    }
}
