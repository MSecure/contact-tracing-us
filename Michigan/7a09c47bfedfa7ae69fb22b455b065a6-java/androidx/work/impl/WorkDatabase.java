package androidx.work.impl;

import android.content.Context;
import android.text.TextUtils;
import b.b.k.i;
import b.b0.y.i;
import b.b0.y.j;
import b.b0.y.r.b;
import b.b0.y.r.e;
import b.b0.y.r.k;
import b.b0.y.r.n;
import b.b0.y.r.q;
import b.b0.y.r.t;
import b.s.h;
import b.w.a.c;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final long f451a = TimeUnit.DAYS.toMillis(1);

    public class a implements c.AbstractC0052c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f452a;

        public a(Context context) {
            this.f452a = context;
        }

        @Override // b.w.a.c.AbstractC0052c
        public c a(c.b bVar) {
            Context context = this.f452a;
            String str = bVar.f2612b;
            c.a aVar = bVar.f2613c;
            if (aVar == null) {
                throw new IllegalArgumentException("Must set a callback to create the configuration.");
            } else if (context == null) {
                throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
            } else if (!TextUtils.isEmpty(str)) {
                return new b.w.a.g.c(context, str, aVar, true);
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
            aVar = i.j.u(context, WorkDatabase.class, "androidx.work.workdb");
            aVar.f2504g = new a(context);
        }
        aVar.f2502e = executor;
        b.b0.y.h hVar = new b.b0.y.h();
        if (aVar.f2501d == null) {
            aVar.f2501d = new ArrayList<>();
        }
        aVar.f2501d.add(hVar);
        aVar.a(b.b0.y.i.f1084a);
        aVar.a(new i.g(context, 2, 3));
        aVar.a(b.b0.y.i.f1085b);
        aVar.a(b.b0.y.i.f1086c);
        aVar.a(new i.g(context, 5, 6));
        aVar.a(b.b0.y.i.f1087d);
        aVar.a(b.b0.y.i.f1088e);
        aVar.a(b.b0.y.i.f1089f);
        aVar.a(new i.h(context));
        aVar.a(new i.g(context, 10, 11));
        aVar.j = false;
        aVar.k = true;
        return (WorkDatabase) aVar.b();
    }

    public static String c() {
        StringBuilder h = c.a.a.a.a.h("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < ");
        h.append(System.currentTimeMillis() - f451a);
        h.append(" AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))");
        return h.toString();
    }

    public abstract b b();

    public abstract e d();

    public abstract b.b0.y.r.h e();

    public abstract k f();

    public abstract n g();

    public abstract q h();

    public abstract t i();
}
