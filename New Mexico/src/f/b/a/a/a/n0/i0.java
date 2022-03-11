package f.b.a.a.a.n0;

import android.database.Cursor;
import e.b.a.m;
import e.v.i;
import e.v.p.b;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class i0 implements Callable<j0> {
    public final /* synthetic */ i a;
    public final /* synthetic */ d0 b;

    public i0(d0 d0Var, i iVar) {
        this.b = d0Var;
        this.a = iVar;
    }

    @Override // java.util.concurrent.Callable
    public j0 call() {
        j0 j0Var;
        Cursor b = b.b(this.b.a, this.a, false, null);
        try {
            int h0 = m.e.h0(b, "id");
            int h02 = m.e.h0(b, "createdTimestampMs");
            int h03 = m.e.h0(b, "sharedStatus");
            int h04 = m.e.h0(b, "verificationCode");
            int h05 = m.e.h0(b, "longTermToken");
            int h06 = m.e.h0(b, "certificate");
            int h07 = m.e.h0(b, "testResult");
            int h08 = m.e.h0(b, "onsetDate");
            int h09 = m.e.h0(b, "isServerOnsetDate");
            int h010 = m.e.h0(b, "hasSymptoms");
            int h011 = m.e.h0(b, "revisionToken");
            int h012 = m.e.h0(b, "travelStatus");
            int h013 = m.e.h0(b, "isCodeFromLink");
            int h014 = m.e.h0(b, "lastUpdatedTimestampMs");
            int h015 = m.e.h0(b, "isPreAuth");
            if (b.moveToFirst()) {
                j0Var = j0.a(b.getLong(h0), b.getLong(h02), m.e.P1(b.getString(h03)), b.getString(h04), b.getString(h05), b.getString(h06), m.e.Q1(b.getString(h07)), b.getInt(h09) != 0, m.e.O1(b.getString(h08)), m.e.N1(b.getString(h010)), b.getString(h011), m.e.R1(b.getString(h012)), b.getInt(h013) != 0, b.getLong(h014), b.getInt(h015) != 0);
            } else {
                j0Var = null;
            }
            return j0Var;
        } finally {
            b.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.Q();
    }
}
