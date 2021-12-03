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
public abstract class BasePendingResult<R extends i> extends f<R> {
    public final Object a = new Object();
    public final a<R> b = new a<>(Looper.getMainLooper());
    public final CountDownLatch c = new CountDownLatch(1);

    /* renamed from: d  reason: collision with root package name */
    public final ArrayList<f.a> f458d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<Object> f459e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    public R f460f;

    /* renamed from: g  reason: collision with root package name */
    public Status f461g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f462h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f463i;
    @KeepName
    public b mResultGuardian;

    public static class a<R extends i> extends d {
        public a(@RecentlyNonNull Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: f.b.a.c.b.l.j */
        /* JADX WARN: Multi-variable type inference failed */
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
                ((BasePendingResult) message.obj).b(Status.f453h);
            }
        }
    }

    public final class b {
        public b(h0 h0Var) {
        }

        public final void finalize() {
            BasePendingResult.e(BasePendingResult.this.f460f);
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
                this.f463i = true;
            }
        }
    }

    @RecentlyNonNull
    public final boolean c() {
        return this.c.getCount() == 0;
    }

    public final void d(@RecentlyNonNull R r) {
        synchronized (this.a) {
            if (!this.f463i) {
                c();
                boolean z = true;
                m.h.r(!c(), "Results have already been set");
                if (this.f462h) {
                    z = false;
                }
                m.h.r(z, "Result has already been consumed");
                f(r);
                return;
            }
            e(r);
        }
    }

    public final void f(R r) {
        this.f460f = r;
        this.f461g = r.getStatus();
        this.c.countDown();
        if (this.f460f instanceof g) {
            this.mResultGuardian = new b(null);
        }
        ArrayList<f.a> arrayList = this.f458d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            f.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f461g);
        }
        this.f458d.clear();
    }
}
