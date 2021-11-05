package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import b.b0.e;
import b.b0.g;
import b.b0.h;
import b.b0.r;
import b.b0.x;
import b.b0.y.s.m;
import b.b0.y.s.n;
import b.b0.y.s.o;
import b.b0.y.s.p;
import b.b0.y.s.r.c;
import b.b0.y.s.s.b;
import c.b.b.e.a.u;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {
    public Context mAppContext;
    public boolean mRunInForeground;
    public volatile boolean mStopped;
    public boolean mUsed;
    public WorkerParameters mWorkerParams;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0005a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final e f437a = e.f1027c;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0005a.class != obj.getClass()) {
                    return false;
                }
                return this.f437a.equals(((C0005a) obj).f437a);
            }

            public int hashCode() {
                return this.f437a.hashCode() + (C0005a.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder h = c.a.a.a.a.h("Failure {mOutputData=");
                h.append(this.f437a);
                h.append('}');
                return h.toString();
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            public final e f438a;

            public c() {
                this.f438a = e.f1027c;
            }

            public c(e eVar) {
                this.f438a = eVar;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f438a.equals(((c) obj).f438a);
            }

            public int hashCode() {
                return this.f438a.hashCode() + (c.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder h = c.a.a.a.a.h("Success {mOutputData=");
                h.append(this.f438a);
                h.append('}');
                return h.toString();
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.mAppContext = context;
            this.mWorkerParams = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context getApplicationContext() {
        return this.mAppContext;
    }

    public Executor getBackgroundExecutor() {
        return this.mWorkerParams.f446f;
    }

    public final UUID getId() {
        return this.mWorkerParams.f441a;
    }

    public final e getInputData() {
        return this.mWorkerParams.f442b;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f444d.f450c;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.f445e;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.f443c;
    }

    public b.b0.y.s.s.a getTaskExecutor() {
        return this.mWorkerParams.f447g;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.f444d.f448a;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f444d.f449b;
    }

    public x getWorkerFactory() {
        return this.mWorkerParams.h;
    }

    public boolean isRunInForeground() {
        return this.mRunInForeground;
    }

    public final boolean isStopped() {
        return this.mStopped;
    }

    public final boolean isUsed() {
        return this.mUsed;
    }

    public void onStopped() {
    }

    public final u<Void> setForegroundAsync(g gVar) {
        this.mRunInForeground = true;
        h hVar = this.mWorkerParams.j;
        Context applicationContext = getApplicationContext();
        UUID id = getId();
        n nVar = (n) hVar;
        if (nVar != null) {
            c cVar = new c();
            b.b0.y.s.s.a aVar = nVar.f1287a;
            ((b) aVar).f1334a.execute(new m(nVar, cVar, id, gVar, applicationContext));
            return cVar;
        }
        throw null;
    }

    public final u<Void> setProgressAsync(e eVar) {
        r rVar = this.mWorkerParams.i;
        getApplicationContext();
        UUID id = getId();
        p pVar = (p) rVar;
        if (pVar != null) {
            c cVar = new c();
            b.b0.y.s.s.a aVar = pVar.f1296b;
            ((b) aVar).f1334a.execute(new o(pVar, id, eVar, cVar));
            return cVar;
        }
        throw null;
    }

    public final void setUsed() {
        this.mUsed = true;
    }

    public abstract u<a> startWork();

    public final void stop() {
        this.mStopped = true;
        onStopped();
    }
}
