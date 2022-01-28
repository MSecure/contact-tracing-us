package e.b0.a0;

import android.content.Context;
import android.database.Cursor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import e.b0.a0.s.b;
import e.b0.a0.s.p;
import e.b0.a0.s.q;
import e.b0.a0.s.s;
import e.b0.a0.s.t;
import e.b0.a0.t.g;
import e.b0.c;
import e.b0.f;
import e.b0.k;
import e.b0.m;
import e.b0.n;
import e.b0.v;
import e.u.i;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class o implements Runnable {
    public static final String u = n.e("WorkerWrapper");
    public Context b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f1035d;

    /* renamed from: e  reason: collision with root package name */
    public WorkerParameters.a f1036e;

    /* renamed from: f  reason: collision with root package name */
    public e.b0.a0.s.o f1037f;

    /* renamed from: g  reason: collision with root package name */
    public ListenableWorker f1038g;

    /* renamed from: h  reason: collision with root package name */
    public e.b0.a0.t.t.a f1039h;

    /* renamed from: i  reason: collision with root package name */
    public ListenableWorker.a f1040i = new ListenableWorker.a.C0003a();

    /* renamed from: j  reason: collision with root package name */
    public c f1041j;

    /* renamed from: k  reason: collision with root package name */
    public e.b0.a0.r.a f1042k;

    /* renamed from: l  reason: collision with root package name */
    public WorkDatabase f1043l;
    public p m;
    public b n;
    public s o;
    public List<String> p;
    public String q;
    public e.b0.a0.t.s.c<Boolean> r = new e.b0.a0.t.s.c<>();
    public u<ListenableWorker.a> s = null;
    public volatile boolean t;

    public static class a {
        public Context a;
        public e.b0.a0.r.a b;
        public e.b0.a0.t.t.a c;

        /* renamed from: d  reason: collision with root package name */
        public c f1044d;

        /* renamed from: e  reason: collision with root package name */
        public WorkDatabase f1045e;

        /* renamed from: f  reason: collision with root package name */
        public String f1046f;

        /* renamed from: g  reason: collision with root package name */
        public List<e> f1047g;

        /* renamed from: h  reason: collision with root package name */
        public WorkerParameters.a f1048h = new WorkerParameters.a();

        public a(Context context, c cVar, e.b0.a0.t.t.a aVar, e.b0.a0.r.a aVar2, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.c = aVar;
            this.b = aVar2;
            this.f1044d = cVar;
            this.f1045e = workDatabase;
            this.f1046f = str;
        }
    }

    public o(a aVar) {
        this.b = aVar.a;
        this.f1039h = aVar.c;
        this.f1042k = aVar.b;
        this.c = aVar.f1046f;
        this.f1035d = aVar.f1047g;
        this.f1036e = aVar.f1048h;
        this.f1038g = null;
        this.f1041j = aVar.f1044d;
        WorkDatabase workDatabase = aVar.f1045e;
        this.f1043l = workDatabase;
        this.m = workDatabase.r();
        this.n = this.f1043l.m();
        this.o = this.f1043l.s();
    }

    public final void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            n.c().d(u, String.format("Worker result SUCCESS for %s", this.q), new Throwable[0]);
            if (!this.f1037f.c()) {
                this.f1043l.c();
                try {
                    p pVar = this.m;
                    ((q) pVar).p(v.SUCCEEDED, this.c);
                    f fVar = ((ListenableWorker.a.c) this.f1040i).a;
                    ((q) this.m).n(this.c, fVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((ArrayList) ((e.b0.a0.s.c) this.n).a(this.c)).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((q) this.m).g(str) == v.BLOCKED && ((e.b0.a0.s.c) this.n).b(str)) {
                            n.c().d(u, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                            p pVar2 = this.m;
                            ((q) pVar2).p(v.ENQUEUED, str);
                            ((q) this.m).o(str, currentTimeMillis);
                        }
                    }
                    this.f1043l.l();
                    return;
                } finally {
                    this.f1043l.g();
                    f(false);
                }
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            n.c().d(u, String.format("Worker result RETRY for %s", this.q), new Throwable[0]);
            d();
            return;
        } else {
            n.c().d(u, String.format("Worker result FAILURE for %s", this.q), new Throwable[0]);
            if (!this.f1037f.c()) {
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
            if (((q) this.m).g(str2) != v.CANCELLED) {
                p pVar = this.m;
                ((q) pVar).p(v.FAILED, str2);
            }
            linkedList.addAll(((e.b0.a0.s.c) this.n).a(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.f1043l.c();
            try {
                v g2 = ((q) this.m).g(this.c);
                ((e.b0.a0.s.n) this.f1043l.q()).a(this.c);
                if (g2 == null) {
                    f(false);
                } else if (g2 == v.RUNNING) {
                    a(this.f1040i);
                } else if (!g2.a()) {
                    d();
                }
                this.f1043l.l();
            } finally {
                this.f1043l.g();
            }
        }
        List<e> list = this.f1035d;
        if (list != null) {
            for (e eVar : list) {
                eVar.b(this.c);
            }
            f.a(this.f1041j, this.f1043l, this.f1035d);
        }
    }

    public final void d() {
        this.f1043l.c();
        try {
            p pVar = this.m;
            ((q) pVar).p(v.ENQUEUED, this.c);
            ((q) this.m).o(this.c, System.currentTimeMillis());
            ((q) this.m).l(this.c, -1);
            this.f1043l.l();
        } finally {
            this.f1043l.g();
            f(true);
        }
    }

    public final void e() {
        this.f1043l.c();
        try {
            ((q) this.m).o(this.c, System.currentTimeMillis());
            p pVar = this.m;
            ((q) pVar).p(v.ENQUEUED, this.c);
            ((q) this.m).m(this.c);
            ((q) this.m).l(this.c, -1);
            this.f1043l.l();
        } finally {
            this.f1043l.g();
            f(false);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void f(boolean z) {
        ListenableWorker listenableWorker;
        this.f1043l.c();
        try {
            q qVar = (q) this.f1043l.r();
            Objects.requireNonNull(qVar);
            i t2 = i.t("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
            qVar.a.b();
            Cursor b2 = e.u.p.b.b(qVar.a, t2, false, null);
            try {
                if (!(b2.moveToFirst() && b2.getInt(0) != 0)) {
                    g.a(this.b, RescheduleReceiver.class, false);
                }
                if (z) {
                    ((q) this.m).p(v.ENQUEUED, this.c);
                    ((q) this.m).l(this.c, -1);
                }
                if (!(this.f1037f == null || (listenableWorker = this.f1038g) == null || !listenableWorker.a())) {
                    e.b0.a0.r.a aVar = this.f1042k;
                    String str = this.c;
                    d dVar = (d) aVar;
                    synchronized (dVar.f1011l) {
                        dVar.f1006g.remove(str);
                        dVar.h();
                    }
                }
                this.f1043l.l();
                this.f1043l.g();
                this.r.j(Boolean.valueOf(z));
            } finally {
                b2.close();
                t2.Q();
            }
        } catch (Throwable th) {
            this.f1043l.g();
            throw th;
        }
    }

    public final void g() {
        v g2 = ((q) this.m).g(this.c);
        if (g2 == v.RUNNING) {
            n.c().a(u, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.c), new Throwable[0]);
            f(true);
            return;
        }
        n.c().a(u, String.format("Status for %s is %s; not doing any work", this.c, g2), new Throwable[0]);
        f(false);
    }

    public void h() {
        this.f1043l.c();
        try {
            b(this.c);
            f fVar = ((ListenableWorker.a.C0003a) this.f1040i).a;
            ((q) this.m).n(this.c, fVar);
            this.f1043l.l();
        } finally {
            this.f1043l.g();
            f(false);
        }
    }

    public final boolean i() {
        if (!this.t) {
            return false;
        }
        n.c().a(u, String.format("Work interrupted for %s", this.q), new Throwable[0]);
        v g2 = ((q) this.m).g(this.c);
        if (g2 == null) {
            f(false);
        } else {
            f(!g2.a());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bc, code lost:
        if ((r1.b == r0 && r1.f1119k > 0) != false) goto L_0x00be;
     */
    public void run() {
        k kVar;
        f a2;
        boolean z;
        List<String> a3 = ((t) this.o).a(this.c);
        this.p = a3;
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.c);
        sb.append(", tags={ ");
        boolean z2 = true;
        for (String str : a3) {
            if (z2) {
                z2 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        this.q = sb.toString();
        v vVar = v.ENQUEUED;
        if (!i()) {
            this.f1043l.c();
            try {
                e.b0.a0.s.o i2 = ((q) this.m).i(this.c);
                this.f1037f = i2;
                if (i2 == null) {
                    n.c().b(u, String.format("Didn't find WorkSpec for id %s", this.c), new Throwable[0]);
                    f(false);
                } else if (i2.b != vVar) {
                    g();
                    this.f1043l.l();
                    n.c().a(u, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f1037f.c), new Throwable[0]);
                } else {
                    if (!i2.c()) {
                        e.b0.a0.s.o oVar = this.f1037f;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    e.b0.a0.s.o oVar2 = this.f1037f;
                    if (!(oVar2.n == 0) && currentTimeMillis < oVar2.a()) {
                        n.c().a(u, String.format("Delaying execution for %s because it is being executed before schedule.", this.f1037f.c), new Throwable[0]);
                        f(true);
                    }
                    this.f1043l.l();
                    this.f1043l.g();
                    if (this.f1037f.c()) {
                        a2 = this.f1037f.f1113e;
                    } else {
                        m mVar = this.f1041j.f1156d;
                        String str2 = this.f1037f.f1112d;
                        Objects.requireNonNull(mVar);
                        String str3 = k.a;
                        try {
                            kVar = (k) Class.forName(str2).newInstance();
                        } catch (Exception e2) {
                            n.c().b(k.a, f.a.a.a.a.w("Trouble instantiating + ", str2), e2);
                            kVar = null;
                        }
                        if (kVar == null) {
                            n.c().b(u, String.format("Could not create Input Merger %s", this.f1037f.f1112d), new Throwable[0]);
                            h();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f1037f.f1113e);
                        p pVar = this.m;
                        String str4 = this.c;
                        q qVar = (q) pVar;
                        Objects.requireNonNull(qVar);
                        i t2 = i.t("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                        if (str4 == null) {
                            t2.J(1);
                        } else {
                            t2.L(1, str4);
                        }
                        qVar.a.b();
                        Cursor b2 = e.u.p.b.b(qVar.a, t2, false, null);
                        try {
                            ArrayList arrayList2 = new ArrayList(b2.getCount());
                            while (b2.moveToNext()) {
                                arrayList2.add(f.b(b2.getBlob(0)));
                            }
                            b2.close();
                            t2.Q();
                            arrayList.addAll(arrayList2);
                            a2 = kVar.a(arrayList);
                        } catch (Throwable th) {
                            b2.close();
                            t2.Q();
                            throw th;
                        }
                    }
                    UUID fromString = UUID.fromString(this.c);
                    List<String> list = this.p;
                    WorkerParameters.a aVar = this.f1036e;
                    int i3 = this.f1037f.f1119k;
                    c cVar = this.f1041j;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, a2, list, aVar, i3, cVar.a, this.f1039h, cVar.c, new e.b0.a0.t.q(this.f1043l, this.f1039h), new e.b0.a0.t.p(this.f1043l, this.f1042k, this.f1039h));
                    if (this.f1038g == null) {
                        this.f1038g = this.f1041j.c.b(this.b, this.f1037f.c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f1038g;
                    if (listenableWorker == null) {
                        n.c().b(u, String.format("Could not create Worker %s", this.f1037f.c), new Throwable[0]);
                    } else if (listenableWorker.f300e) {
                        n.c().b(u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f1037f.c), new Throwable[0]);
                    } else {
                        listenableWorker.f300e = true;
                        this.f1043l.c();
                        try {
                            if (((q) this.m).g(this.c) == vVar) {
                                ((q) this.m).p(v.RUNNING, this.c);
                                ((q) this.m).k(this.c);
                                z = true;
                            } else {
                                z = false;
                            }
                            this.f1043l.l();
                            if (!z) {
                                g();
                                return;
                            } else if (!i()) {
                                e.b0.a0.t.s.c cVar2 = new e.b0.a0.t.s.c();
                                e.b0.a0.t.n nVar = new e.b0.a0.t.n(this.b, this.f1037f, this.f1038g, workerParameters.f304e, this.f1039h);
                                ((e.b0.a0.t.t.b) this.f1039h).c.execute(nVar);
                                e.b0.a0.t.s.c<Void> cVar3 = nVar.b;
                                cVar3.a(new m(this, cVar3, cVar2), ((e.b0.a0.t.t.b) this.f1039h).c);
                                cVar2.a(new n(this, cVar2, this.q), ((e.b0.a0.t.t.b) this.f1039h).a);
                                return;
                            } else {
                                return;
                            }
                        } finally {
                            this.f1043l.g();
                        }
                    }
                    h();
                    return;
                }
                this.f1043l.l();
            } finally {
                this.f1043l.g();
            }
        }
    }
}
