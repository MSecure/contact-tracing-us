package androidx.work;

import android.content.Context;
import androidx.annotation.Keep;
import e.c0.e;
import f.b.b.f.a.u;

public abstract class ListenableWorker {
    public Context b;
    public WorkerParameters c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f310d;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0003a extends a {
            public final e a = e.c;

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
            public final e a;

            public c() {
                this.a = e.c;
            }

            public c(e eVar) {
                this.a = eVar;
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
        return false;
    }

    public void b() {
    }

    public abstract u<a> d();

    public final void f() {
        b();
    }
}
