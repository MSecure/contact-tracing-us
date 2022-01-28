package f.b.a.a.a.b0;

import android.database.Cursor;
import com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase;
import e.b.a.m;
import e.t.i;
import e.t.n.d;
import e.t.p.b;
import f.b.a.a.a.v.c;
import f.b.b.c.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class h {
    public final c a;

    public h(ExposureNotificationDatabase exposureNotificationDatabase) {
        this.a = exposureNotificationDatabase.m();
    }

    public void a() {
        d dVar = (d) this.a;
        d.a(dVar.a, true, new e(dVar));
    }

    public List<g> b() {
        d dVar = (d) this.a;
        Objects.requireNonNull(dVar);
        i t = i.t("SELECT * FROM AnalyticsLoggingEntity", 0);
        dVar.a.b();
        Cursor b = b.b(dVar.a, t, false, null);
        try {
            int d0 = m.h.d0(b, "key");
            int d02 = m.h.d0(b, "eventProto");
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(new i(b.getLong(d0), b.getString(d02)));
            }
            return arrayList;
        } finally {
            b.close();
            t.Q();
        }
    }

    public void c(c cVar) {
        c cVar2 = this.a;
        i iVar = new i(0, a.a.c(cVar.toByteArray()));
        d dVar = (d) cVar2;
        dVar.a.b();
        dVar.a.c();
        try {
            dVar.b.e(iVar);
            dVar.a.l();
        } finally {
            dVar.a.g();
        }
    }
}
