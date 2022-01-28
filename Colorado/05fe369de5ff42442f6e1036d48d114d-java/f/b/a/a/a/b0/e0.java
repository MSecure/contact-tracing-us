package f.b.a.a.a.b0;

import android.database.Cursor;
import e.b.a.m;
import e.t.i;
import e.t.p.b;
import java.util.concurrent.Callable;

public class e0 implements Callable<h0> {
    public final /* synthetic */ i a;
    public final /* synthetic */ a0 b;

    public e0(a0 a0Var, i iVar) {
        this.b = a0Var;
        this.a = iVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public h0 call() {
        h0 h0Var;
        Cursor b2 = b.b(this.b.a, this.a, false, null);
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
            if (b2.moveToFirst()) {
                h0Var = h0.a(b2.getLong(d0), b2.getLong(d02), m.h.v1(b2.getString(d03)), b2.getString(d04), b2.getString(d05), b2.getString(d06), m.h.w1(b2.getString(d07)), b2.getInt(d09) != 0, m.h.u1(b2.getString(d08)), m.h.t1(b2.getString(d010)), b2.getString(d011), m.h.x1(b2.getString(d012)), b2.getInt(d013) != 0, b2.getLong(d014), b2.getInt(d015) != 0);
            } else {
                h0Var = null;
            }
            return h0Var;
        } finally {
            b2.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.Q();
    }
}
