package b.b0.y;

import android.content.Context;
import android.database.Cursor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import b.b0.b;
import b.b0.e;
import b.b0.j;
import b.b0.l;
import b.b0.m;
import b.b0.y.r.o;
import b.b0.y.r.p;
import b.b0.y.r.q;
import b.b0.y.r.r;
import b.b0.y.r.t;
import b.b0.y.s.f;
import b.b0.y.s.r.c;
import c.b.b.e.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class n implements Runnable {
    public static final String u = m.e("WorkerWrapper");

    /* renamed from: b  reason: collision with root package name */
    public Context f1106b;

    /* renamed from: c  reason: collision with root package name */
    public String f1107c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f1108d;

    /* renamed from: e  reason: collision with root package name */
    public WorkerParameters.a f1109e;

    /* renamed from: f  reason: collision with root package name */
    public p f1110f;

    /* renamed from: g  reason: collision with root package name */
    public ListenableWorker f1111g;
    public ListenableWorker.a h = new ListenableWorker.a.C0005a();
    public b i;
    public b.b0.y.s.s.a j;
    public b.b0.y.q.a k;
    public WorkDatabase l;
    public q m;
    public b.b0.y.r.b n;
    public t o;
    public List<String> p;
    public String q;
    public c<Boolean> r = new c<>();
    public u<ListenableWorker.a> s = null;
    public volatile boolean t;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public Context f1112a;

        /* renamed from: b  reason: collision with root package name */
        public b.b0.y.q.a f1113b;

        /* renamed from: c  reason: collision with root package name */
        public b.b0.y.s.s.a f1114c;

        /* renamed from: d  reason: collision with root package name */
        public b f1115d;

        /* renamed from: e  reason: collision with root package name */
        public WorkDatabase f1116e;

        /* renamed from: f  reason: collision with root package name */
        public String f1117f;

        /* renamed from: g  reason: collision with root package name */
        public List<e> f1118g;
        public WorkerParameters.a h = new WorkerParameters.a();

        public a(Context context, b bVar, b.b0.y.s.s.a aVar, b.b0.y.q.a aVar2, WorkDatabase workDatabase, String str) {
            this.f1112a = context.getApplicationContext();
            this.f1114c = aVar;
            this.f1113b = aVar2;
            this.f1115d = bVar;
            this.f1116e = workDatabase;
            this.f1117f = str;
        }
    }

    public n(a aVar) {
        this.f1106b = aVar.f1112a;
        this.j = aVar.f1114c;
        this.k = aVar.f1113b;
        this.f1107c = aVar.f1117f;
        this.f1108d = aVar.f1118g;
        this.f1109e = aVar.h;
        this.f1111g = null;
        this.i = aVar.f1115d;
        WorkDatabase workDatabase = aVar.f1116e;
        this.l = workDatabase;
        this.m = workDatabase.h();
        this.n = this.l.b();
        this.o = this.l.i();
    }

    public final void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            m.c().d(u, String.format("Worker result SUCCESS for %s", this.q), new Throwable[0]);
            if (!this.f1110f.c()) {
                this.l.beginTransaction();
                try {
                    q qVar = this.m;
                    ((r) qVar).p(b.b0.u.SUCCEEDED, this.f1107c);
                    e eVar = ((ListenableWorker.a.c) this.h).f438a;
                    ((r) this.m).n(this.f1107c, eVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((ArrayList) ((b.b0.y.r.c) this.n).a(this.f1107c)).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((r) this.m).g(str) == b.b0.u.BLOCKED && ((b.b0.y.r.c) this.n).b(str)) {
                            m.c().d(u, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                            q qVar2 = this.m;
                            ((r) qVar2).p(b.b0.u.ENQUEUED, str);
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
            if (!this.f1110f.c()) {
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
            if (((r) this.m).g(str2) != b.b0.u.CANCELLED) {
                q qVar = this.m;
                ((r) qVar).p(b.b0.u.FAILED, str2);
            }
            linkedList.addAll(((b.b0.y.r.c) this.n).a(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.l.beginTransaction();
            try {
                b.b0.u g2 = ((r) this.m).g(this.f1107c);
                ((o) this.l.g()).a(this.f1107c);
                if (g2 == null) {
                    f(false);
                } else if (g2 == b.b0.u.RUNNING) {
                    a(this.h);
                } else if (!g2.b()) {
                    d();
                }
                this.l.setTransactionSuccessful();
            } finally {
                this.l.endTransaction();
            }
        }
        List<e> list = this.f1108d;
        if (list != null) {
            for (e eVar : list) {
                eVar.b(this.f1107c);
            }
            f.b(this.i, this.l, this.f1108d);
        }
    }

    public final void d() {
        this.l.beginTransaction();
        try {
            q qVar = this.m;
            ((r) qVar).p(b.b0.u.ENQUEUED, this.f1107c);
            ((r) this.m).o(this.f1107c, System.currentTimeMillis());
            ((r) this.m).l(this.f1107c, -1);
            this.l.setTransactionSuccessful();
        } finally {
            this.l.endTransaction();
            f(true);
        }
    }

    public final void e() {
        this.l.beginTransaction();
        try {
            ((r) this.m).o(this.f1107c, System.currentTimeMillis());
            q qVar = this.m;
            ((r) qVar).p(b.b0.u.ENQUEUED, this.f1107c);
            ((r) this.m).m(this.f1107c);
            ((r) this.m).l(this.f1107c, -1);
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
                f.a(this.f1106b, RescheduleReceiver.class, false);
            }
            if (z) {
                ((r) this.m).p(b.b0.u.ENQUEUED, this.f1107c);
                ((r) this.m).l(this.f1107c, -1);
            }
            if (!(this.f1110f == null || this.f1111g == null || !this.f1111g.isRunInForeground())) {
                b.b0.y.q.a aVar = this.k;
                String str = this.f1107c;
                d dVar = (d) aVar;
                synchronized (dVar.l) {
                    dVar.f1072g.remove(str);
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
        b.b0.u g2 = ((r) this.m).g(this.f1107c);
        if (g2 == b.b0.u.RUNNING) {
            m.c().a(u, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f1107c), new Throwable[0]);
            f(true);
            return;
        }
        m.c().a(u, String.format("Status for %s is %s; not doing any work", this.f1107c, g2), new Throwable[0]);
        f(false);
    }

    public void h() {
        this.l.beginTransaction();
        try {
            b(this.f1107c);
            ((r) this.m).n(this.f1107c, ((ListenableWorker.a.C0005a) this.h).f437a);
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
        b.b0.u g2 = ((r) this.m).g(this.f1107c);
        if (g2 == null) {
            f(false);
        } else {
            f(!g2.b());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c6, code lost:
        if ((r2.f1235b == r0 && r2.k > 0) != false) goto L_0x00c8;
     */
    public void run() {
        e b2;
        boolean z;
        WorkDatabase workDatabase;
        List<String> a2 = ((b.b0.y.r.u) this.o).a(this.f1107c);
        this.p = a2;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f1107c);
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
        b.b0.u uVar = b.b0.u.ENQUEUED;
        if (!i()) {
            this.l.beginTransaction();
            try {
                p i2 = ((r) this.m).i(this.f1107c);
                this.f1110f = i2;
                if (i2 == null) {
                    m.c().b(u, String.format("Didn't find WorkSpec for id %s", this.f1107c), new Throwable[0]);
                    f(false);
                    workDatabase = this.l;
                } else if (i2.f1235b != uVar) {
                    g();
                    this.l.setTransactionSuccessful();
                    m.c().a(u, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f1110f.f1236c), new Throwable[0]);
                } else {
                    if (!i2.c()) {
                        p pVar = this.f1110f;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!(this.f1110f.n == 0) && currentTimeMillis < this.f1110f.a()) {
                        m.c().a(u, String.format("Delaying execution for %s because it is being executed before schedule.", this.f1110f.f1236c), new Throwable[0]);
                        f(true);
                        workDatabase = this.l;
                    }
                    this.l.setTransactionSuccessful();
                    this.l.endTransaction();
                    if (this.f1110f.c()) {
                        b2 = this.f1110f.f1238e;
                    } else {
                        l lVar = this.i.f1000d;
                        String str2 = this.f1110f.f1237d;
                        if (lVar != null) {
                            j a3 = j.a(str2);
                            if (a3 == null) {
                                m.c().b(u, String.format("Could not create Input Merger %s", this.f1110f.f1237d), new Throwable[0]);
                                h();
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(this.f1110f.f1238e);
                            q qVar = this.m;
                            String str3 = this.f1107c;
                            r rVar = (r) qVar;
                            if (rVar != null) {
                                b.s.j c2 = b.s.j.c("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                                if (str3 == null) {
                                    c2.e(1);
                                } else {
                                    c2.f(1, str3);
                                }
                                rVar.f1243a.assertNotSuspendingTransaction();
                                Cursor b3 = b.s.q.b.b(rVar.f1243a, c2, false, null);
                                try {
                                    ArrayList arrayList2 = new ArrayList(b3.getCount());
                                    while (b3.moveToNext()) {
                                        arrayList2.add(e.g(b3.getBlob(0)));
                                    }
                                    b3.close();
                                    c2.g();
                                    arrayList.addAll(arrayList2);
                                    b2 = a3.b(arrayList);
                                } catch (Throwable th) {
                                    b3.close();
                                    c2.g();
                                    throw th;
                                }
                            } else {
                                throw null;
                            }
                        } else {
                            throw null;
                        }
                    }
                    UUID fromString = UUID.fromString(this.f1107c);
                    List<String> list = this.p;
                    WorkerParameters.a aVar = this.f1109e;
                    int i3 = this.f1110f.k;
                    b bVar = this.i;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, b2, list, aVar, i3, bVar.f997a, this.j, bVar.f999c, new b.b0.y.s.p(this.l, this.j), new b.b0.y.s.n(this.l, this.k, this.j));
                    if (this.f1111g == null) {
                        this.f1111g = this.i.f999c.b(this.f1106b, this.f1110f.f1236c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f1111g;
                    if (listenableWorker == null) {
                        m.c().b(u, String.format("Could not create Worker %s", this.f1110f.f1236c), new Throwable[0]);
                    } else if (listenableWorker.isUsed()) {
                        m.c().b(u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f1110f.f1236c), new Throwable[0]);
                    } else {
                        this.f1111g.setUsed();
                        this.l.beginTransaction();
                        try {
                            if (((r) this.m).g(this.f1107c) == uVar) {
                                z = true;
                                ((r) this.m).p(b.b0.u.RUNNING, this.f1107c);
                                ((r) this.m).k(this.f1107c);
                            } else {
                                z = false;
                            }
                            this.l.setTransactionSuccessful();
                            if (!z) {
                                g();
                                return;
                            } else if (!i()) {
                                c cVar = new c();
                                ((b.b0.y.s.s.b) this.j).f1336c.execute(new l(this, cVar));
                                cVar.b(new m(this, cVar, this.q), ((b.b0.y.s.s.b) this.j).f1334a);
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
