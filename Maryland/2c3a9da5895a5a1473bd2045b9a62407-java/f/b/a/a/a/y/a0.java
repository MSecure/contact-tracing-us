package f.b.a.a.a.y;

import android.database.Cursor;
import e.b.a.m;
import e.t.i;
import e.t.p.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class a0 implements Callable<List<c0>> {
    public final /* synthetic */ i a;
    public final /* synthetic */ v b;

    public a0(v vVar, i iVar) {
        this.b = vVar;
        this.a = iVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public List<c0> call() {
        Cursor b2 = b.b(this.b.a, this.a, false, null);
        try {
            int b0 = m.h.b0(b2, "id");
            int b02 = m.h.b0(b2, "createdTimestampMs");
            int b03 = m.h.b0(b2, "sharedStatus");
            int b04 = m.h.b0(b2, "verificationCode");
            int b05 = m.h.b0(b2, "longTermToken");
            int b06 = m.h.b0(b2, "certificate");
            int b07 = m.h.b0(b2, "testResult");
            int b08 = m.h.b0(b2, "onsetDate");
            int b09 = m.h.b0(b2, "isServerOnsetDate");
            int b010 = m.h.b0(b2, "hasSymptoms");
            int b011 = m.h.b0(b2, "revisionToken");
            int b012 = m.h.b0(b2, "travelStatus");
            int b013 = m.h.b0(b2, "isCodeFromLink");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(c0.a(b2.getLong(b0), b2.getLong(b02), m.h.p1(b2.getString(b03)), b2.getString(b04), b2.getString(b05), b2.getString(b06), m.h.q1(b2.getString(b07)), b2.getInt(b09) != 0, m.h.o1(b2.getString(b08)), m.h.n1(b2.getString(b010)), b2.getString(b011), m.h.r1(b2.getString(b012)), b2.getInt(b013) != 0));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // java.lang.Object
    public void finalize() {
        this.a.V();
    }
}
