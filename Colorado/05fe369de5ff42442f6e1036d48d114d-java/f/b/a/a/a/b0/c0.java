package f.b.a.a.a.b0;

import android.database.Cursor;
import android.os.CancellationSignal;
import e.b.a.m;
import e.t.i;
import e.t.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class c0 implements Callable<List<h0>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ CancellationSignal b;
    public final /* synthetic */ a0 c;

    public c0(a0 a0Var, i iVar, CancellationSignal cancellationSignal) {
        this.c = a0Var;
        this.a = iVar;
        this.b = cancellationSignal;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<h0> call() {
        Cursor b2 = b.b(this.c.a, this.a, false, this.b);
        try {
            int d0 = m.h.d0(b2, "id");
            int d02 = m.h.d0(b2, "createdTimestampMs");
            int d03 = m.h.d0(b2, "sharedStatus");
            int d04 = m.h.d0(b2, "verificationCode");
            int d05 = m.h.d0(b2, "longTermToken");
            int d06 = m.h.d0(b2, "certificate");
            int d07 = m.h.d0(b2, "testResult");
            int d08 = m.h.d0(b2, "onsetDate");
            int d09 = m.h.d0(b2, "isServerOnsetDate");
            int d010 = m.h.d0(b2, "hasSymptoms");
            int d011 = m.h.d0(b2, "revisionToken");
            int d012 = m.h.d0(b2, "travelStatus");
            int d013 = m.h.d0(b2, "isCodeFromLink");
            int d014 = m.h.d0(b2, "lastUpdatedTimestampMs");
            int d015 = m.h.d0(b2, "isPreAuth");
            int i2 = d014;
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(h0.a(b2.getLong(d0), b2.getLong(d02), m.h.v1(b2.getString(d03)), b2.getString(d04), b2.getString(d05), b2.getString(d06), m.h.w1(b2.getString(d07)), b2.getInt(d09) != 0, m.h.u1(b2.getString(d08)), m.h.t1(b2.getString(d010)), b2.getString(d011), m.h.x1(b2.getString(d012)), b2.getInt(d013) != 0, b2.getLong(i2), b2.getInt(d015) != 0));
                d015 = d015;
                d0 = d0;
                i2 = i2;
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }
}
