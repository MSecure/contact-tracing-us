package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.Keep;
import b.z.e;
import b.z.g;
import b.z.h;
import b.z.r;
import b.z.x;
import b.z.y.s.m;
import b.z.y.s.n;
import b.z.y.s.o;
import b.z.y.s.p;
import b.z.y.s.r.c;
import b.z.y.s.s.b;
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
        public static final class C0004a extends a {

            /* renamed from: a  reason: collision with root package name */
            public final e f307a = e.f1912c;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0004a.class != obj.getClass()) {
                    return false;
                }
                return this.f307a.equals(((C0004a) obj).f307a);
            }

            public int hashCode() {
                return this.f307a.hashCode() + (C0004a.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder g = c.a.a.a.a.g("Failure {mOutputData=");
                g.append(this.f307a);
                g.append('}');
                return g.toString();
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
            public final e f308a;

            public c() {
                this.f308a = e.f1912c;
            }

            public c(e eVar) {
                this.f308a = eVar;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f308a.equals(((c) obj).f308a);
            }

            public int hashCode() {
                return this.f308a.hashCode() + (c.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder g = c.a.a.a.a.g("Success {mOutputData=");
                g.append(this.f308a);
                g.append('}');
                return g.toString();
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
        return this.mWorkerParams.f;
    }

    public final UUID getId() {
        return this.mWorkerParams.f311a;
    }

    public final e getInputData() {
        return this.mWorkerParams.f312b;
    }

    public final Network getNetwork() {
        return this.mWorkerParams.f314d.f318c;
    }

    public final int getRunAttemptCount() {
        return this.mWorkerParams.f315e;
    }

    public final Set<String> getTags() {
        return this.mWorkerParams.f313c;
    }

    public b.z.y.s.s.a getTaskExecutor() {
        return this.mWorkerParams.g;
    }

    public final List<String> getTriggeredContentAuthorities() {
        return this.mWorkerParams.f314d.f316a;
    }

    public final List<Uri> getTriggeredContentUris() {
        return this.mWorkerParams.f314d.f317b;
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
            b.z.y.s.s.a aVar = nVar.f2139a;
            ((b) aVar).f2183a.execute(new m(nVar, cVar, id, gVar, applicationContext));
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
            b.z.y.s.s.a aVar = pVar.f2148b;
            ((b) aVar).f2183a.execute(new o(pVar, id, eVar, cVar));
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
