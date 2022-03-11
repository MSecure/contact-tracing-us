package e.c0.x;

import android.content.Context;
import android.database.Cursor;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import e.c0.b;
import e.c0.e;
import e.c0.i;
import e.c0.k;
import e.c0.l;
import e.c0.w;
import e.c0.x.s.n;
import e.c0.x.s.p;
import e.c0.x.s.q;
import e.c0.x.s.s;
import e.c0.x.s.t;
import e.c0.x.t.f;
import e.c0.x.t.m;
import e.c0.x.t.p.c;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

public class o implements Runnable {
    public static final String u = l.e("WorkerWrapper");
    public Context b;
    public String c;

    /* renamed from: d  reason: collision with root package name */
    public List<e> f1056d;

    /* renamed from: e  reason: collision with root package name */
    public WorkerParameters.a f1057e;

    /* renamed from: f  reason: collision with root package name */
    public e.c0.x.s.o f1058f;

    /* renamed from: g  reason: collision with root package name */
    public ListenableWorker f1059g;

    /* renamed from: h  reason: collision with root package name */
    public ListenableWorker.a f1060h = new ListenableWorker.a.C0003a();

    /* renamed from: i  reason: collision with root package name */
    public b f1061i;

    /* renamed from: j  reason: collision with root package name */
    public e.c0.x.t.q.a f1062j;

    /* renamed from: k  reason: collision with root package name */
    public e.c0.x.r.a f1063k;

    /* renamed from: l  reason: collision with root package name */
    public WorkDatabase f1064l;
    public p m;
    public e.c0.x.s.b n;
    public s o;
    public List<String> p;
    public String q;
    public c<Boolean> r = new c<>();
    public u<ListenableWorker.a> s = null;
    public volatile boolean t;

    public static class a {
        public Context a;
        public e.c0.x.r.a b;
        public e.c0.x.t.q.a c;

        /* renamed from: d  reason: collision with root package name */
        public b f1065d;

        /* renamed from: e  reason: collision with root package name */
        public WorkDatabase f1066e;

        /* renamed from: f  reason: collision with root package name */
        public String f1067f;

        /* renamed from: g  reason: collision with root package name */
        public List<e> f1068g;

        /* renamed from: h  reason: collision with root package name */
        public WorkerParameters.a f1069h = new WorkerParameters.a();

        public a(Context context, b bVar, e.c0.x.t.q.a aVar, e.c0.x.r.a aVar2, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.c = aVar;
            this.b = aVar2;
            this.f1065d = bVar;
            this.f1066e = workDatabase;
            this.f1067f = str;
        }
    }

    public o(a aVar) {
        this.b = aVar.a;
        this.f1062j = aVar.c;
        this.f1063k = aVar.b;
        this.c = aVar.f1067f;
        this.f1056d = aVar.f1068g;
        this.f1057e = aVar.f1069h;
        this.f1059g = null;
        this.f1061i = aVar.f1065d;
        WorkDatabase workDatabase = aVar.f1066e;
        this.f1064l = workDatabase;
        this.m = workDatabase.r();
        this.n = this.f1064l.m();
        this.o = this.f1064l.s();
    }

    public final void a(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            l.c().d(u, String.format("Worker result SUCCESS for %s", this.q), new Throwable[0]);
            if (!this.f1058f.c()) {
                this.f1064l.c();
                try {
                    p pVar = this.m;
                    ((q) pVar).p(e.c0.s.SUCCEEDED, this.c);
                    e eVar = ((ListenableWorker.a.c) this.f1060h).a;
                    ((q) this.m).n(this.c, eVar);
                    long currentTimeMillis = System.currentTimeMillis();
                    Iterator it = ((ArrayList) ((e.c0.x.s.c) this.n).a(this.c)).iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        if (((q) this.m).g(str) == e.c0.s.BLOCKED && ((e.c0.x.s.c) this.n).b(str)) {
                            l.c().d(u, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                            p pVar2 = this.m;
                            ((q) pVar2).p(e.c0.s.ENQUEUED, str);
                            ((q) this.m).o(str, currentTimeMillis);
                        }
                    }
                    this.f1064l.l();
                    return;
                } finally {
                    this.f1064l.g();
                    f(false);
                }
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            l.c().d(u, String.format("Worker result RETRY for %s", this.q), new Throwable[0]);
            d();
            return;
        } else {
            l.c().d(u, String.format("Worker result FAILURE for %s", this.q), new Throwable[0]);
            if (!this.f1058f.c()) {
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
            if (((q) this.m).g(str2) != e.c0.s.CANCELLED) {
                p pVar = this.m;
                ((q) pVar).p(e.c0.s.FAILED, str2);
            }
            linkedList.addAll(((e.c0.x.s.c) this.n).a(str2));
        }
    }

    public void c() {
        if (!i()) {
            this.f1064l.c();
            try {
                e.c0.s g2 = ((q) this.m).g(this.c);
                ((n) this.f1064l.q()).a(this.c);
                if (g2 == null) {
                    f(false);
                } else if (g2 == e.c0.s.RUNNING) {
                    a(this.f1060h);
                } else if (!g2.a()) {
                    d();
                }
                this.f1064l.l();
            } finally {
                this.f1064l.g();
            }
        }
        List<e> list = this.f1056d;
        if (list != null) {
            for (e eVar : list) {
                eVar.b(this.c);
            }
            f.a(this.f1061i, this.f1064l, this.f1056d);
        }
    }

    public final void d() {
        this.f1064l.c();
        try {
            p pVar = this.m;
            ((q) pVar).p(e.c0.s.ENQUEUED, this.c);
            ((q) this.m).o(this.c, System.currentTimeMillis());
            ((q) this.m).l(this.c, -1);
            this.f1064l.l();
        } finally {
            this.f1064l.g();
            f(true);
        }
    }

    public final void e() {
        this.f1064l.c();
        try {
            ((q) this.m).o(this.c, System.currentTimeMillis());
            p pVar = this.m;
            ((q) pVar).p(e.c0.s.ENQUEUED, this.c);
            ((q) this.m).m(this.c);
            ((q) this.m).l(this.c, -1);
            this.f1064l.l();
        } finally {
            this.f1064l.g();
            f(false);
        }
    }

    /* JADX INFO: finally extract failed */
    public final void f(boolean z) {
        ListenableWorker listenableWorker;
        this.f1064l.c();
        try {
            if (((ArrayList) ((q) this.f1064l.r()).c()).isEmpty()) {
                f.a(this.b, RescheduleReceiver.class, false);
            }
            if (z) {
                ((q) this.m).p(e.c0.s.ENQUEUED, this.c);
                ((q) this.m).l(this.c, -1);
            }
            if (!(this.f1058f == null || (listenableWorker = this.f1059g) == null || !listenableWorker.a())) {
                e.c0.x.r.a aVar = this.f1063k;
                String str = this.c;
                d dVar = (d) aVar;
                synchronized (dVar.f1034k) {
                    dVar.f1029f.remove(str);
                    dVar.g();
                }
            }
            this.f1064l.l();
            this.f1064l.g();
            this.r.j(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.f1064l.g();
            throw th;
        }
    }

    public final void g() {
        e.c0.s g2 = ((q) this.m).g(this.c);
        if (g2 == e.c0.s.RUNNING) {
            l.c().a(u, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.c), new Throwable[0]);
            f(true);
            return;
        }
        l.c().a(u, String.format("Status for %s is %s; not doing any work", this.c, g2), new Throwable[0]);
        f(false);
    }

    public void h() {
        this.f1064l.c();
        try {
            b(this.c);
            ((q) this.m).n(this.c, ((ListenableWorker.a.C0003a) this.f1060h).a);
            this.f1064l.l();
        } finally {
            this.f1064l.g();
            f(false);
        }
    }

    public final boolean i() {
        if (!this.t) {
            return false;
        }
        l.c().a(u, String.format("Work interrupted for %s", this.q), new Throwable[0]);
        e.c0.s g2 = ((q) this.m).g(this.c);
        if (g2 == null) {
            f(false);
        } else {
            f(!g2.a());
        }
        return true;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ba, code lost:
        if ((r1.b == r0 && r1.f1140k > 0) != false) goto L_0x00bc;
     */
    public void run() {
        i iVar;
        e a2;
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
        e.c0.s sVar = e.c0.s.ENQUEUED;
        if (!i()) {
            this.f1064l.c();
            try {
                e.c0.x.s.o i2 = ((q) this.m).i(this.c);
                this.f1058f = i2;
                if (i2 == null) {
                    l.c().b(u, String.format("Didn't find WorkSpec for id %s", this.c), new Throwable[0]);
                    f(false);
                } else if (i2.b != sVar) {
                    g();
                    this.f1064l.l();
                    l.c().a(u, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f1058f.c), new Throwable[0]);
                } else {
                    if (!i2.c()) {
                        e.c0.x.s.o oVar = this.f1058f;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    e.c0.x.s.o oVar2 = this.f1058f;
                    if (!(oVar2.n == 0) && currentTimeMillis < oVar2.a()) {
                        l.c().a(u, String.format("Delaying execution for %s because it is being executed before schedule.", this.f1058f.c), new Throwable[0]);
                        f(true);
                    }
                    this.f1064l.l();
                    this.f1064l.g();
                    if (this.f1058f.c()) {
                        a2 = this.f1058f.f1134e;
                    } else {
                        k kVar = this.f1061i.f1000d;
                        String str2 = this.f1058f.f1133d;
                        Objects.requireNonNull(kVar);
                        String str3 = i.a;
                        try {
                            iVar = (i) Class.forName(str2).newInstance();
                        } catch (Exception e2) {
                            l.c().b(i.a, f.a.a.a.a.t("Trouble instantiating + ", str2), e2);
                            iVar = null;
                        }
                        if (iVar == null) {
                            l.c().b(u, String.format("Could not create Input Merger %s", this.f1058f.f1133d), new Throwable[0]);
                            h();
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.f1058f.f1134e);
                        p pVar = this.m;
                        String str4 = this.c;
                        q qVar = (q) pVar;
                        Objects.requireNonNull(qVar);
                        e.t.i v = e.t.i.v("SELECT output FROM workspec WHERE id IN (SELECT prerequisite_id FROM dependency WHERE work_spec_id=?)", 1);
                        if (str4 == null) {
                            v.N(1);
                        } else {
                            v.P(1, str4);
                        }
                        qVar.a.b();
                        Cursor b2 = e.t.p.b.b(qVar.a, v, false, null);
                        try {
                            ArrayList arrayList2 = new ArrayList(b2.getCount());
                            while (b2.moveToNext()) {
                                arrayList2.add(e.a(b2.getBlob(0)));
                            }
                            b2.close();
                            v.V();
                            arrayList.addAll(arrayList2);
                            a2 = iVar.a(arrayList);
                        } catch (Throwable th) {
                            b2.close();
                            v.V();
                            throw th;
                        }
                    }
                    UUID fromString = UUID.fromString(this.c);
                    List<String> list = this.p;
                    WorkerParameters.a aVar = this.f1057e;
                    int i3 = this.f1058f.f1140k;
                    b bVar = this.f1061i;
                    Executor executor = bVar.a;
                    e.c0.x.t.q.a aVar2 = this.f1062j;
                    w wVar = bVar.c;
                    WorkDatabase workDatabase = this.f1064l;
                    e.c0.x.t.q.a aVar3 = this.f1062j;
                    WorkerParameters workerParameters = new WorkerParameters(fromString, a2, list, aVar, i3, executor, aVar2, wVar, new e.c0.x.t.n(workDatabase, aVar3), new m(workDatabase, this.f1063k, aVar3));
                    if (this.f1059g == null) {
                        this.f1059g = this.f1061i.c.b(this.b, this.f1058f.c, workerParameters);
                    }
                    ListenableWorker listenableWorker = this.f1059g;
                    if (listenableWorker == null) {
                        l.c().b(u, String.format("Could not create Worker %s", this.f1058f.c), new Throwable[0]);
                    } else if (listenableWorker.f310d) {
                        l.c().b(u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f1058f.c), new Throwable[0]);
                    } else {
                        listenableWorker.f310d = true;
                        this.f1064l.c();
                        try {
                            if (((q) this.m).g(this.c) == sVar) {
                                z = true;
                                ((q) this.m).p(e.c0.s.RUNNING, this.c);
                                ((q) this.m).k(this.c);
                            } else {
                                z = false;
                            }
                            this.f1064l.l();
                            if (!z) {
                                g();
                                return;
                            } else if (!i()) {
                                c cVar = new c();
                                ((e.c0.x.t.q.b) this.f1062j).c.execute(new m(this, cVar));
                                cVar.a(new n(this, cVar, this.q), ((e.c0.x.t.q.b) this.f1062j).a);
                                return;
                            } else {
                                return;
                            }
                        } finally {
                            this.f1064l.g();
                        }
                    }
                    h();
                }
            } finally {
                this.f1064l.g();
            }
        }
    }
}
