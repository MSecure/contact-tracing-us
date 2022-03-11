package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import e.c0.f;
import f.b.b.f.a.u;
/* loaded from: classes.dex */
public abstract class ListenableWorker {
    public Context b;
    public WorkerParameters c;

    /* renamed from: d */
    public volatile boolean f299d;

    /* renamed from: e */
    public boolean f300e;

    /* renamed from: f */
    public boolean f301f;

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a */
        /* loaded from: classes.dex */
        public static final class C0003a extends a {
            public final f a = f.c;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0003a.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((C0003a) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode() + (C0003a.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder h2 = f.a.a.a.a.h("Failure {mOutputData=");
                h2.append(this.a);
                h2.append('}');
                return h2.toString();
            }
        }

        /* loaded from: classes.dex */
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

        /* loaded from: classes.dex */
        public static final class c extends a {
            public final f a;

            public c() {
                this.a = f.c;
            }

            public c(f fVar) {
                this.a = fVar;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.a.equals(((c) obj).a);
            }

            public int hashCode() {
                return this.a.hashCode() + (c.class.getName().hashCode() * 31);
            }

            public String toString() {
                StringBuilder h2 = f.a.a.a.a.h("Success {mOutputData=");
                h2.append(this.a);
                h2.append('}');
                return h2.toString();
            }
        }
    }

    @Keep
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.b = context;
            this.c = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public boolean a() {
        return this.f301f;
    }

    public void b() {
    }

    public abstract u<a> d();

    public final void f() {
        this.f299d = true;
        b();
    }
}
