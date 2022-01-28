package f.b.a.a.a.l0;

import android.database.Cursor;
import e.b.a.m;
import e.u.i;
import e.u.p.b;
import f.b.b.a.a;
import f.b.b.a.l;
import f.b.b.a.o;
import java.util.concurrent.Callable;

public class y implements Callable<l<h0>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ a0 b;

    public y(a0 a0Var, i iVar) {
        this.b = a0Var;
        this.a = iVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public l<h0> call() {
        h0 h0Var;
        Cursor b2 = b.b(this.b.a, this.a, false, null);
        try {
            int g0 = m.e.g0(b2, "id");
            int g02 = m.e.g0(b2, "createdTimestampMs");
            int g03 = m.e.g0(b2, "sharedStatus");
            int g04 = m.e.g0(b2, "verificationCode");
            int g05 = m.e.g0(b2, "longTermToken");
            int g06 = m.e.g0(b2, "certificate");
            int g07 = m.e.g0(b2, "testResult");
            int g08 = m.e.g0(b2, "onsetDate");
            int g09 = m.e.g0(b2, "isServerOnsetDate");
            int g010 = m.e.g0(b2, "hasSymptoms");
            int g011 = m.e.g0(b2, "revisionToken");
            int g012 = m.e.g0(b2, "travelStatus");
            int g013 = m.e.g0(b2, "isCodeFromLink");
            int g014 = m.e.g0(b2, "lastUpdatedTimestampMs");
            int g015 = m.e.g0(b2, "isPreAuth");
            if (b2.moveToFirst()) {
                h0Var = h0.a(b2.getLong(g0), b2.getLong(g02), m.e.H1(b2.getString(g03)), b2.getString(g04), b2.getString(g05), b2.getString(g06), m.e.I1(b2.getString(g07)), b2.getInt(g09) != 0, m.e.G1(b2.getString(g08)), m.e.F1(b2.getString(g010)), b2.getString(g011), m.e.J1(b2.getString(g012)), b2.getInt(g013) != 0, b2.getLong(g014), b2.getInt(g015) != 0);
            } else {
                h0Var = null;
            }
            return h0Var == null ? a.b : new o(h0Var);
        } finally {
            b2.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.Q();
    }
}
