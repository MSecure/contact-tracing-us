package androidx.work.impl;

import android.content.Context;
import android.text.TextUtils;
import b.b.k.i;
import b.r.h;
import b.u.a.c;
import b.z.y.i;
import b.z.y.j;
import b.z.y.r.b;
import b.z.y.r.e;
import b.z.y.r.k;
import b.z.y.r.n;
import b.z.y.r.q;
import b.z.y.r.t;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final long f319a = TimeUnit.DAYS.toMillis(1);

    public class a implements c.AbstractC0042c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f320a;

        public a(Context context) {
            this.f320a = context;
        }

        @Override // b.u.a.c.AbstractC0042c
        public c a(c.b bVar) {
            Context context = this.f320a;
            String str = bVar.f1738b;
            c.a aVar = bVar.f1739c;
            if (aVar == null) {
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            } else if (context == null) {
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            } else if (!TextUtils.isEmpty(str)) {
                return new b.u.a.g.c(context, str, aVar, true);
            } else {
                throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
            }
        }
    }

    public static WorkDatabase a(Context context, Executor executor, boolean z) {
        h.a aVar;
        if (z) {
            aVar = new h.a(context, WorkDatabase.class, null);
            aVar.h = true;
        } else {
            j.a();
            aVar = i.j.T(context, WorkDatabase.class, "androidx.work.workdb");
            aVar.g = new a(context);
        }
        aVar.f1640e = executor;
        b.z.y.h hVar = new b.z.y.h();
        if (aVar.f1639d == null) {
            aVar.f1639d = new ArrayList<>();
        }
        aVar.f1639d.add(hVar);
        aVar.a(b.z.y.i.f1960a);
        aVar.a(new i.g(context, 2, 3));
        aVar.a(b.z.y.i.f1961b);
        aVar.a(b.z.y.i.f1962c);
        aVar.a(new i.g(context, 5, 6));
        aVar.a(b.z.y.i.f1963d);
        aVar.a(b.z.y.i.f1964e);
        aVar.a(b.z.y.i.f);
        aVar.a(new i.h(context));
        aVar.a(new i.g(context, 10, 11));
        aVar.j = false;
        aVar.k = true;
        return (WorkDatabase) aVar.b();
    }

    public static String c() {
        StringBuilder g = c.a.a.a.a.g("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        g.append(System.currentTimeMillis() - f319a);
        g.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return g.toString();
    }

    public abstract b b();

    public abstract e d();

    public abstract b.z.y.r.h e();

    public abstract k f();

    public abstract n g();

    public abstract q h();

    public abstract t i();
}
