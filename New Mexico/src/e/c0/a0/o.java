package e.c0.a0;

import android.content.Context;
import android.database.Cursor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import e.c0.a0.s.b;
import e.c0.a0.s.p;
import e.c0.a0.s.q;
import e.c0.a0.s.s;
import e.c0.a0.s.t;
import e.c0.a0.t.g;
import e.c0.c;
import e.c0.f;
import e.c0.k;
import e.c0.m;
import e.c0.n;
import e.c0.v;
import e.v.i;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
/* loaded from: classes.dex */
public class o implements Runnable {
    public static final String u = n.e("WorkerWrapper");
    public Context b;
    public String c;

    /* renamed from: d */
    public List<e> f1114d;

    /* renamed from: e */
    public WorkerParameters.a f1115e;

    /* renamed from: f */
    public e.c0.a0.s.o f1116f;

    /* renamed from: h */
    public e.c0.a0.t.t.a f1118h;

    /* renamed from: j */
    public c f1120j;

    /* renamed from: k */
    public e.c0.a0.r.a f1121k;

    /* renamed from: l */
    public WorkDatabase f1122l;
    public p m;
    public b n;
    public s o;
    public List<String> p;
    public String q;
    public volatile boolean t;

    /* renamed from: i */
    public ListenableWorker.a f1119i = new ListenableWorker.a.C0003a();
    public e.c0.a0.t.s.c<Boolean> r = new e.c0.a0.t.s.c<>();
    public u<ListenableWorker.a> s = null;

    /* renamed from: g */
    public ListenableWorker f1117g = null;

    /* loaded from: classes.dex */
    public static class a {
        public Context a;
        public e.c0.a0.r.a b;
        public e.c0.a0.t.t.a c;

        /* renamed from: d */
        public c f1123d;

        /* renamed from: e */
        public WorkDatabase f1124e;

        /* renamed from: f */
        public String f1125f;

        /* renamed from: g */
        public List<e> f1126g;

        /* renamed from: h */
        public WorkerParameters.a f1127h = new WorkerParameters.a();

        public a(Context context, c cVar, e.c0.a0.t.t.a aVar, e.c0.a0.r.a aVar2, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.c = aVar;
            this.b = aVar2;
            this.f1123d = cVar;
            this.f1124e = workDatabase;
            this.f1125f = str;
        }
    }

    public o(a aVar) {
        this.b = aVar.a;
        this.f1118h = aVar.c;
        this.f1121k = aVar.b;
        this.c = aVar.f1125f;
        this.f1114d = aVar.f1126g;
        this.f1115e = aVar.f1127h;
        this.f1120j = aVar.f1123d;
        WorkDatabase workDatabase = aVar.f1124e;
        this.f1122l = workDatabase;
        this.m = workDatabase.r();
        this.n = this.f1122l.m();
        this.o = this.f1122l.s();
    }

    public final void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            n.c().d(u, String.format("Worker result SUCCESS for %s", this.q), new Throwable[0]);
            if (!this.f1116f.c()) {
                this.f1122l.c();
                try {
                    ((q) this.m).p(v.SUCCEEDED, this.c);
                    ((q) this.m).n(this.c, ((ListenableWorker.a.c) this.f1119i).a);
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((ArrayList) ((e.c0.a0.s.c) this.n).a(this.c)).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((q) this.m).g(str) == v.BLOCKED && ((e.c0.a0.s.c) this.n).b(str)) {
                            n.c().d(u, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                            ((q) this.m).p(v.ENQUEUED, str);
                            ((q) this.m).o(str, currentTimeMillis);
                        }
                    }
                    this.f1122l.l();
                    return;
                } finally {
                    this.f1122l.g();
                    f(false);
                }
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            n.c().d(u, String.format("Worker result RETRY for %s", this.q), new Throwable[0]);
            d();
            return;
        } else {
            n.c().d(u, String.format("Worker result FAILURE for %s", this.q), new Throwable[0]);
            if (!this.f1116f.c()) {
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
                ((q) this.m).p(v.FAILED, str2);
            }
            linkedList.addAll(((e.c0.a0.s.c) this.n).a(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.f1122l.c();
            try {
                v g2 = ((q) this.m).g(this.c);
                ((e.c0.a0.s.n) this.f1122l.q()).a(this.c);
                if (g2 == null) {
                    f(false);
                } else if (g2 == v.RUNNING) {
                    a(this.f1119i);
                } else if (!g2.a()) {
                    d();
                }
                this.f1122l.l();
            } finally {
                this.f1122l.g();
            }
        }
        List<e> list = this.f1114d;
        if (list != null) {
            for (e eVar : list) {
                eVar.b(this.c);
            }
            f.a(this.f1120j, this.f1122l, this.f1114d);
        }
    }

    public final void d() {
        this.f1122l.c();
        try {
            ((q) this.m).p(v.ENQUEUED, this.c);
            ((q) this.m).o(this.c, System.currentTimeMillis());
            ((q) this.m).l(this.c, -1);
            this.f1122l.l();
        } finally {
            this.f1122l.g();
            f(true);
        }
    }

    public final void e() {
        this.f1122l.c();
        try {
            ((q) this.m).o(this.c, System.currentTimeMillis());
            ((q) this.m).p(v.ENQUEUED, this.c);
            ((q) this.m).m(this.c);
            ((q) this.m).l(this.c, -1);
            this.f1122l.l();
        } finally {
            this.f1122l.g();
            f(false);
        }
    }

    /* JADX WARN: Finally extract failed */
    public final void f(boolean z) {
        ListenableWorker listenableWorker;
        this.f1122l.c();
        try {
            q qVar = (q) this.f1122l.r();
            Objects.requireNonNull(qVar);
            i t = i.t("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1", 0);
            qVar.a.b();
            Cursor b = e.v.p.b.b(qVar.a, t, false, null);
            boolean z2 = b.moveToFirst() && b.getInt(0) != 0;
            b.close();
            t.Q();
            if (!z2) {
                g.a(this.b, RescheduleReceiver.class, false);
            }
            if (z) {
                ((q) this.m).p(v.ENQUEUED, this.c);
                ((q) this.m).l(this.c, -1);
            }
            if (!(this.f1116f == null || (listenableWorker = this.f1117g) == null || !listenableWorker.a())) {
                e.c0.a0.r.a aVar = this.f1121k;
                String str = this.c;
                d dVar = (d) aVar;
                synchronized (dVar.f1090l) {
                    dVar.f1085g.remove(str);
                    dVar.h();
                }
            }
            this.f1122l.l();
            this.f1122l.g();
            this.r.j(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.f1122l.g();
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
        this.f1122l.c();
        try {
            b(this.c);
            f fVar = ((ListenableWorker.a.C0003a) this.f1119i).a;
            ((q) this.m).n(this.c, fVar);
            this.f1122l.l();
        } finally {
            this.f1122l.g();
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

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
        if ((r1.b == r0 && r1.f1198k > 0) != false) goto L_0x00be;
     */
    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    /* Code decompiled incorrectly, please refer to instructions dump */
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
            this.f1122l.c();
            try {
                e.c0.a0.s.o i2 = ((q) this.m).i(this.c);
                this.f1116f = i2;
                if (i2 == null) {
                    n.c().b(u, String.format("Didn't find WorkSpec for id %s", this.c), new Throwable[0]);
                    f(false);
                } else if (i2.b != vVar) {
                    g();
                    this.f1122l.l();
                    n.c().a(u, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f1116f.c), new Throwable[0]);
                } else {
                    if (!i2.c()) {
                        e.c0.a0.s.o oVar = this.f1116f;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    e.c0.a0.s.o oVar2 = this.f1116f;
                    if (!(oVar2.n == 0) && currentTimeMillis < oVar2.a()) {
                        n.c().a(u, String.format("Delaying execution for %s because it is being executed before schedule.", this.f1116f.c), new Throwable[0]);
                        f(true);
                    }
                    this.f1122l.l();
                    this.f1122l.g();
                    if (this.f1116f.c()) {
                        a2 = this.f1116f.f1192e;
                    } else {
                        m mVar = this.f1120j.f1235d;
                        String str2 = this.f1116f.f1191d;
                        Objects.requireNonNull(mVar);
                        String str3 = k.a;
                        try {
                            kVar = (k) Class.forName(str2).newInstance();
                        } catch (Exception e2) {
                            n.c().b(k.a, f.a.a.a.a.x("Trouble instantiating + ", str2), e2);
                            kVar = null;
                        }
                        if (kVar == null) {
                            n.c().b(u, String.format("Could not create Input Merger %s", this.f1116f.f1191d), new Throwable[0]);
                            h();
                            return;
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f1116f.f1192e);
                        p pVar = this.m;
                        String str4 = this.c;
                        q qVar = (q) pVar;
                        Objects.requireNonNull(qVar);
                        i t = i.t("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                        if (str4 == null) {
                            t.J(1);
                        } else {
                            t.L(1, str4);
                        }
                        qVar.a.b();
                        Cursor b = e.v.p.b.b(qVar.a, t, false, null);
                        try {
                            ArrayList arrayList2 = new ArrayList(b.getCount());
                            while (b.moveToNext()) {
                                arrayList2.add(f.b(b.getBlob(0)));
                            }
                            b.close();
                            t.Q();
                            arrayList.addAll(arrayList2);
                            a2 = kVar.a(arrayList);
                        } catch (Throwable th) {
                            b.close();
                            t.Q();
                            throw th;
                        }
                    }
                    UUID fromString = UUID.fromString(this.c);
                    List<String> list = this.p;
                    WorkerParameters.a aVar = this.f1115e;
                    int i3 = this.f1116f.f1198k;
                    c cVar = this.f1120j;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, a2, list, aVar, i3, cVar.a, this.f1118h, cVar.c, new e.c0.a0.t.q(this.f1122l, this.f1118h), new e.c0.a0.t.p(this.f1122l, this.f1121k, this.f1118h));
                    if (this.f1117g == null) {
                        this.f1117g = this.f1120j.c.b(this.b, this.f1116f.c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f1117g;
                    if (listenableWorker == null) {
                        n.c().b(u, String.format("Could not create Worker %s", this.f1116f.c), new Throwable[0]);
                    } else if (listenableWorker.f300e) {
                        n.c().b(u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f1116f.c), new Throwable[0]);
                    } else {
                        listenableWorker.f300e = true;
                        this.f1122l.c();
                        try {
                            if (((q) this.m).g(this.c) == vVar) {
                                ((q) this.m).p(v.RUNNING, this.c);
                                ((q) this.m).k(this.c);
                                z = true;
                            } else {
                                z = false;
                            }
                            this.f1122l.l();
                            if (!z) {
                                g();
                                return;
                            } else if (!i()) {
                                e.c0.a0.t.s.c cVar2 = new e.c0.a0.t.s.c();
                                e.c0.a0.t.n nVar = new e.c0.a0.t.n(this.b, this.f1116f, this.f1117g, workerParameters.f304e, this.f1118h);
                                ((e.c0.a0.t.t.b) this.f1118h).c.execute(nVar);
                                e.c0.a0.t.s.c<Void> cVar3 = nVar.b;
                                cVar3.a(new m(this, cVar3, cVar2), ((e.c0.a0.t.t.b) this.f1118h).c);
                                cVar2.a(new n(this, cVar2, this.q), ((e.c0.a0.t.t.b) this.f1118h).a);
                                return;
                            } else {
                                return;
                            }
                        } finally {
                        }
                    }
                    h();
                    return;
                }
                this.f1122l.l();
            } finally {
            }
        }
    }
}
