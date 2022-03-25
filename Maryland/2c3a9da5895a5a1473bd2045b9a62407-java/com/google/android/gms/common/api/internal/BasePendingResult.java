package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
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
    public final ArrayList<f.a> f430d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<Object> f431e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    public R f432f;

    /* renamed from: g  reason: collision with root package name */
    public Status f433g;

    /* renamed from: h  reason: collision with root package name */
    public volatile boolean f434h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f435i;
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
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
            } else {
                ((BasePendingResult) message.obj).b(Status.f425h);
            }
        }
    }

    public final class b {
        public b(h0 h0Var) {
        }

        public final void finalize() {
            BasePendingResult.e(BasePendingResult.this.f432f);
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
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(iVar);
                StringBuilder sb = new StringBuilder(valueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    public abstract R a(@RecentlyNonNull Status status);

    @Deprecated
    public final void b(@RecentlyNonNull Status status) {
        synchronized (this.a) {
            if (!c()) {
                d(a(status));
                this.f435i = true;
            }
        }
    }

    @RecentlyNonNull
    public final boolean c() {
        return this.c.getCount() == 0;
    }

    public final void d(@RecentlyNonNull R r) {
        synchronized (this.a) {
            if (!this.f435i) {
                c();
                boolean z = true;
                m.h.r(!c(), "Results have already been set");
                if (this.f434h) {
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
        this.f432f = r;
        this.f433g = r.getStatus();
        this.c.countDown();
        if (this.f432f instanceof g) {
            this.mResultGuardian = new b(null);
        }
        ArrayList<f.a> arrayList = this.f430d;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            f.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f433g);
        }
        this.f430d.clear();
    }
}
