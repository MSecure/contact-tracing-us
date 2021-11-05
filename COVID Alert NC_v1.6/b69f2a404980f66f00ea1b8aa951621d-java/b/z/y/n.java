package b.z.y;

import android.content.Context;
import android.database.Cursor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import b.z.b;
import b.z.e;
import b.z.j;
import b.z.l;
import b.z.m;
import b.z.y.r.o;
import b.z.y.r.p;
import b.z.y.r.q;
import b.z.y.r.r;
import b.z.y.r.t;
import b.z.y.s.f;
import b.z.y.s.r.c;
import c.b.b.e.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class n implements Runnable {
    public static final String u = m.e("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    public Context f1979b;

    /* renamed from: c  reason: collision with root package name */
    public String f1980c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f1981d;

    /* renamed from: e  reason: collision with root package name */
    public WorkerParameters.a f1982e;
    public p f;
    public ListenableWorker g;
    public ListenableWorker.a h = new ListenableWorker.a.C0004a();
    public b i;
    public b.z.y.s.s.a j;
    public b.z.y.q.a k;
    public WorkDatabase l;
    public q m;
    public b.z.y.r.b n;
    public t o;
    public List<String> p;
    public String q;
    public c<Boolean> r = new c<>();
    public u<ListenableWorker.a> s = null;
    public volatile boolean t;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1983a;

        /* renamed from: b  reason: collision with root package name */
        public b.z.y.q.a f1984b;

        /* renamed from: c  reason: collision with root package name */
        public b.z.y.s.s.a f1985c;

        /* renamed from: d  reason: collision with root package name */
        public b f1986d;

        /* renamed from: e  reason: collision with root package name */
        public WorkDatabase f1987e;
        public String f;
        public List<e> g;
        public WorkerParameters.a h = new WorkerParameters.a();

        public a(Context context, b bVar, b.z.y.s.s.a aVar, b.z.y.q.a aVar2, WorkDatabase workDatabase, String str) {
            this.f1983a = context.getApplicationContext();
            this.f1985c = aVar;
            this.f1984b = aVar2;
            this.f1986d = bVar;
            this.f1987e = workDatabase;
            this.f = str;
        }
    }

    public n(a aVar) {
        this.f1979b = aVar.f1983a;
        this.j = aVar.f1985c;
        this.k = aVar.f1984b;
        this.f1980c = aVar.f;
        this.f1981d = aVar.g;
        this.f1982e = aVar.h;
        this.g = null;
        this.i = aVar.f1986d;
        WorkDatabase workDatabase = aVar.f1987e;
        this.l = workDatabase;
        this.m = workDatabase.h();
        this.n = this.l.b();
        this.o = this.l.i();
    }

    public final void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            m.c().d(u, String.format("Worker result SUCCESS for %s", this.q), new Throwable[0]);
            if (!this.f.c()) {
                this.l.beginTransaction();
                try {
                    q qVar = this.m;
                    ((r) qVar).p(b.z.u.SUCCEEDED, this.f1980c);
                    e eVar = ((ListenableWorker.a.c) this.h).f308a;
                    ((r) this.m).n(this.f1980c, eVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((ArrayList) ((b.z.y.r.c) this.n).a(this.f1980c)).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((r) this.m).g(str) == b.z.u.BLOCKED && ((b.z.y.r.c) this.n).b(str)) {
                            m.c().d(u, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                            q qVar2 = this.m;
                            ((r) qVar2).p(b.z.u.ENQUEUED, str);
                            ((r) this.m).o(str, currentTimeMillis);
                        }
                    }
                    this.l.setTransactionSuccessful();
                    return;
                } finally {
                    this.l.endTransaction();
                    f(false);
                }
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            m.c().d(u, String.format("Worker result RETRY for %s", this.q), new Throwable[0]);
            d();
            return;
        } else {
            m.c().d(u, String.format("Worker result FAILURE for %s", this.q), new Throwable[0]);
            if (!this.f.c()) {
                h();
                return;
            }
        }
        e();
    }

    public final void b(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (((r) this.m).g(str2) != b.z.u.CANCELLED) {
                q qVar = this.m;
                ((r) qVar).p(b.z.u.FAILED, str2);
            }
            linkedList.addAll(((b.z.y.r.c) this.n).a(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.l.beginTransaction();
            try {
                b.z.u g2 = ((r) this.m).g(this.f1980c);
                ((o) this.l.g()).a(this.f1980c);
                if (g2 == null) {
                    f(false);
                } else if (g2 == b.z.u.RUNNING) {
                    a(this.h);
                } else if (!g2.b()) {
                    d();
                }
                this.l.setTransactionSuccessful();
            } finally {
                this.l.endTransaction();
            }
        }
        List<e> list = this.f1981d;
        if (list != null) {
            for (e eVar : list) {
                eVar.b(this.f1980c);
            }
            f.b(this.i, this.l, this.f1981d);
        }
    }

    public final void d() {
        this.l.beginTransaction();
        try {
            q qVar = this.m;
            ((r) qVar).p(b.z.u.ENQUEUED, this.f1980c);
            ((r) this.m).o(this.f1980c, System.currentTimeMillis());
            ((r) this.m).l(this.f1980c, -1);
            this.l.setTransactionSuccessful();
        } finally {
            this.l.endTransaction();
            f(true);
        }
    }

    public final void e() {
        this.l.beginTransaction();
        try {
            ((r) this.m).o(this.f1980c, System.currentTimeMillis());
            q qVar = this.m;
            ((r) qVar).p(b.z.u.ENQUEUED, this.f1980c);
            ((r) this.m).m(this.f1980c);
            ((r) this.m).l(this.f1980c, -1);
            this.l.setTransactionSuccessful();
        } finally {
            this.l.endTransaction();
            f(false);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void f(boolean z) {
        this.l.beginTransaction();
        try {
            if (((ArrayList) ((r) this.l.h()).c()).isEmpty()) {
                f.a(this.f1979b, RescheduleReceiver.class, false);
            }
            if (z) {
                ((r) this.m).p(b.z.u.ENQUEUED, this.f1980c);
                ((r) this.m).l(this.f1980c, -1);
            }
            if (!(this.f == null || this.g == null || !this.g.isRunInForeground())) {
                b.z.y.q.a aVar = this.k;
                String str = this.f1980c;
                d dVar = (d) aVar;
                synchronized (dVar.l) {
                    dVar.g.remove(str);
                    dVar.h();
                }
            }
            this.l.setTransactionSuccessful();
            this.l.endTransaction();
            this.r.k(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.l.endTransaction();
            throw th;
        }
    }

    public final void g() {
        b.z.u g2 = ((r) this.m).g(this.f1980c);
        if (g2 == b.z.u.RUNNING) {
            m.c().a(u, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f1980c), new Throwable[0]);
            f(true);
            return;
        }
        m.c().a(u, String.format("Status for %s is %s; not doing any work", this.f1980c, g2), new Throwable[0]);
        f(false);
    }

    public void h() {
        this.l.beginTransaction();
        try {
            b(this.f1980c);
            ((r) this.m).n(this.f1980c, ((ListenableWorker.a.C0004a) this.h).f307a);
            this.l.setTransactionSuccessful();
        } finally {
            this.l.endTransaction();
            f(false);
        }
    }

    public final boolean i() {
        if (!this.t) {
            return false;
        }
        m.c().a(u, String.format("Work interrupted for %s", this.q), new Throwable[0]);
        b.z.u g2 = ((r) this.m).g(this.f1980c);
        if (g2 == null) {
            f(false);
        } else {
            f(!g2.b());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c6, code lost:
        if ((r2.f2092b == r0 && r2.k > 0) != false) goto L_0x00c8;
     */
    public void run() {
        e b2;
        boolean z;
        WorkDatabase workDatabase;
        List<String> a2 = ((b.z.y.r.u) this.o).a(this.f1980c);
        this.p = a2;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f1980c);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String str : a2) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        this.q = sb.toString();
        b.z.u uVar = b.z.u.ENQUEUED;
        if (!i()) {
            this.l.beginTransaction();
            try {
                p i2 = ((r) this.m).i(this.f1980c);
                this.f = i2;
                if (i2 == null) {
                    m.c().b(u, String.format("Didn't find WorkSpec for id %s", this.f1980c), new Throwable[0]);
                    f(false);
                    workDatabase = this.l;
                } else if (i2.f2092b != uVar) {
                    g();
                    this.l.setTransactionSuccessful();
                    m.c().a(u, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f.f2093c), new Throwable[0]);
                } else {
                    if (!i2.c()) {
                        p pVar = this.f;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!(this.f.n == 0) && currentTimeMillis < this.f.a()) {
                        m.c().a(u, String.format("Delaying execution for %s because it is being executed before schedule.", this.f.f2093c), new Throwable[0]);
                        f(true);
                        workDatabase = this.l;
                    }
                    this.l.setTransactionSuccessful();
                    this.l.endTransaction();
                    if (this.f.c()) {
                        b2 = this.f.f2095e;
                    } else {
                        l lVar = this.i.f1892d;
                        String str2 = this.f.f2094d;
                        if (lVar != null) {
                            j a3 = j.a(str2);
                            if (a3 == null) {
                                m.c().b(u, String.format("Could not create Input Merger %s", this.f.f2094d), new Throwable[0]);
                                h();
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.f.f2095e);
                            q qVar = this.m;
                            String str3 = this.f1980c;
                            r rVar = (r) qVar;
                            if (rVar != null) {
                                b.r.j d2 = b.r.j.d("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                                if (str3 == null) {
                                    d2.f(1);
                                } else {
                                    d2.g(1, str3);
                                }
                                rVar.f2098a.assertNotSuspendingTransaction();
                                Cursor b3 = b.r.q.b.b(rVar.f2098a, d2, false, null);
                                try {
                                    ArrayList arrayList2 = new ArrayList(b3.getCount());
                                    while (b3.moveToNext()) {
                                        arrayList2.add(e.g(b3.getBlob(0)));
                                    }
                                    b3.close();
                                    d2.h();
                                    arrayList.addAll(arrayList2);
                                    b2 = a3.b(arrayList);
                                } catch (Throwable th) {
                                    b3.close();
                                    d2.h();
                                    throw th;
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    UUID fromString = UUID.fromString(this.f1980c);
                    List<String> list = this.p;
                    WorkerParameters.a aVar = this.f1982e;
                    int i3 = this.f.k;
                    b bVar = this.i;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, b2, list, aVar, i3, bVar.f1889a, this.j, bVar.f1891c, new b.z.y.s.p(this.l, this.j), new b.z.y.s.n(this.l, this.k, this.j));
                    if (this.g == null) {
                        this.g = this.i.f1891c.a(this.f1979b, this.f.f2093c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.g;
                    if (listenableWorker == null) {
                        m.c().b(u, String.format("Could not create Worker %s", this.f.f2093c), new Throwable[0]);
                    } else if (listenableWorker.isUsed()) {
                        m.c().b(u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f.f2093c), new Throwable[0]);
                    } else {
                        this.g.setUsed();
                        this.l.beginTransaction();
                        try {
                            if (((r) this.m).g(this.f1980c) == uVar) {
                                z = true;
                                ((r) this.m).p(b.z.u.RUNNING, this.f1980c);
                                ((r) this.m).k(this.f1980c);
                            } else {
                                z = false;
                            }
                            this.l.setTransactionSuccessful();
                            if (!z) {
                                g();
                                return;
                            } else if (!i()) {
                                c cVar = new c();
                                ((b.z.y.s.s.b) this.j).f2185c.execute(new l(this, cVar));
                                cVar.b(new m(this, cVar, this.q), ((b.z.y.s.s.b) this.j).f2183a);
                                return;
                            } else {
                                return;
                            }
                        } finally {
                            this.l.endTransaction();
                        }
                    }
                    h();
                    return;
                }
                workDatabase.setTransactionSuccessful();
            } finally {
                this.l.endTransaction();
            }
        }
    }
}
