package f.b.c.k.t;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import f.a.a.a.a;
import f.b.c.k.t.v;
import f.b.c.k.x.m;
import f.b.c.k.x.n;
import java.util.Locale;
import java.util.Objects;

public final /* synthetic */ class i implements n {
    public final r a;
    public final v b;

    public i(r rVar, v vVar) {
        this.a = rVar;
        this.b = vVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x0330  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x033a  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0326  */
    @Override // f.b.c.k.x.n
    public Object get() {
        Throwable th;
        Throwable th2;
        Throwable th3;
        long j2;
        r rVar = this.a;
        v vVar = this.b;
        SparseArray<d1> sparseArray = rVar.f3103h;
        m.a aVar = m.a.DEBUG;
        long j3 = -1;
        int i2 = 0;
        if (vVar.b.a == -1) {
            m.a(aVar, "LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
            return new v.b(false, 0, 0, 0);
        }
        r0 r0Var = ((n0) vVar.a).a;
        Cursor cursor = null;
        try {
            Cursor rawQuery = r0Var.f3110i.rawQuery("PRAGMA page_count", null);
            try {
                Long valueOf = rawQuery.moveToFirst() ? Long.valueOf(rawQuery.getLong(0)) : null;
                rawQuery.close();
                long longValue = valueOf.longValue();
                try {
                    Cursor rawQuery2 = r0Var.f3110i.rawQuery("PRAGMA page_size", null);
                    try {
                        Long valueOf2 = rawQuery2.moveToFirst() ? Long.valueOf(rawQuery2.getLong(0)) : null;
                        rawQuery2.close();
                        long longValue2 = valueOf2.longValue() * longValue;
                        if (longValue2 < vVar.b.a) {
                            m.a(aVar, "LruGarbageCollector", "Garbage collection skipped; Cache size " + longValue2 + " is lower than threshold " + vVar.b.a, new Object[0]);
                            return new v.b(false, 0, 0, 0);
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        Objects.requireNonNull(vVar.b);
                        r0 r0Var2 = ((n0) vVar.a).a;
                        long j4 = r0Var2.f3105d.f3082f;
                        try {
                            Cursor rawQuery3 = r0Var2.f3110i.rawQuery("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)", null);
                            try {
                                Long valueOf3 = rawQuery3.moveToFirst() ? Long.valueOf(rawQuery3.getLong(0)) : null;
                                rawQuery3.close();
                                int longValue3 = (int) ((((float) 10) / 100.0f) * ((float) (valueOf3.longValue() + j4)));
                                Objects.requireNonNull(vVar.b);
                                if (longValue3 > 1000) {
                                    StringBuilder h2 = a.h("Capping sequence numbers to collect down to the maximum of ");
                                    Objects.requireNonNull(vVar.b);
                                    h2.append(1000);
                                    h2.append(" from ");
                                    h2.append(longValue3);
                                    m.a(aVar, "LruGarbageCollector", h2.toString(), new Object[0]);
                                    Objects.requireNonNull(vVar.b);
                                    longValue3 = 1000;
                                }
                                long currentTimeMillis2 = System.currentTimeMillis();
                                if (longValue3 == 0) {
                                    j2 = currentTimeMillis2;
                                } else {
                                    v.c cVar = new v.c(longValue3);
                                    b1 b1Var = ((n0) vVar.a).a.f3105d;
                                    Cursor rawQuery4 = b1Var.a.f3110i.rawQuery("SELECT target_proto FROM targets", null);
                                    while (rawQuery4.moveToNext()) {
                                        try {
                                            cVar.a(Long.valueOf(b1Var.g(rawQuery4.getBlob(i2)).c));
                                            i2 = 0;
                                            currentTimeMillis2 = currentTimeMillis2;
                                        } catch (Throwable unused) {
                                        }
                                    }
                                    j2 = currentTimeMillis2;
                                    rawQuery4.close();
                                    Cursor rawQuery5 = ((n0) vVar.a).a.f3110i.rawQuery("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0", null);
                                    while (rawQuery5.moveToNext()) {
                                        try {
                                            cVar.a(Long.valueOf(rawQuery5.getLong(0)));
                                        } catch (Throwable unused2) {
                                        }
                                    }
                                    rawQuery5.close();
                                    j3 = cVar.a.peek().longValue();
                                }
                                long currentTimeMillis3 = System.currentTimeMillis();
                                b1 b1Var2 = ((n0) vVar.a).a.f3105d;
                                int[] iArr = new int[1];
                                Cursor rawQueryWithFactory = b1Var2.a.f3110i.rawQueryWithFactory(new s0(new Object[]{Long.valueOf(j3)}), "SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?", null, null);
                                while (rawQueryWithFactory.moveToNext()) {
                                    try {
                                        int i3 = rawQueryWithFactory.getInt(0);
                                        if (sparseArray.get(i3) == null) {
                                            b1Var2.a.f3110i.execSQL("DELETE FROM target_documents WHERE target_id = ?", new Object[]{Integer.valueOf(i3)});
                                            b1Var2.a.f3110i.execSQL("DELETE FROM targets WHERE target_id = ?", new Object[]{Integer.valueOf(i3)});
                                            b1Var2.f3082f--;
                                            iArr[0] = iArr[0] + 1;
                                            sparseArray = sparseArray;
                                            currentTimeMillis3 = currentTimeMillis3;
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                }
                                rawQueryWithFactory.close();
                                b1Var2.h();
                                int i4 = iArr[0];
                                long currentTimeMillis4 = System.currentTimeMillis();
                                n0 n0Var = (n0) vVar.a;
                                Objects.requireNonNull(n0Var);
                                int[] iArr2 = new int[1];
                                while (true) {
                                    boolean z = true;
                                    while (true) {
                                        if (z) {
                                            SQLiteDatabase sQLiteDatabase = n0Var.a.f3110i;
                                            s0 s0Var = new s0(new Object[]{Long.valueOf(j3), 100});
                                            m0 m0Var = new m0(n0Var, iArr2);
                                            Cursor rawQueryWithFactory2 = sQLiteDatabase.rawQueryWithFactory(s0Var, "select path from target_documents group by path having COUNT(*) = 1 AND target_id = 0 AND sequence_number <= ? LIMIT ?", null, null);
                                            int i5 = 0;
                                            while (rawQueryWithFactory2.moveToNext()) {
                                                try {
                                                    i5++;
                                                    m0Var.a(rawQueryWithFactory2);
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                            rawQueryWithFactory2.close();
                                            if (i5 != 100) {
                                                z = false;
                                            }
                                        } else {
                                            int i6 = iArr2[0];
                                            long currentTimeMillis5 = System.currentTimeMillis();
                                            StringBuilder i7 = a.i("LRU Garbage Collection:\n", "\tCounted targets in ");
                                            i7.append(j2 - currentTimeMillis);
                                            i7.append("ms\n");
                                            StringBuilder h3 = a.h(i7.toString());
                                            Locale locale = Locale.ROOT;
                                            h3.append(String.format(locale, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(longValue3), Long.valueOf(currentTimeMillis3 - j2)));
                                            StringBuilder h4 = a.h(h3.toString());
                                            h4.append(String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(i4), Long.valueOf(currentTimeMillis4 - currentTimeMillis3)));
                                            StringBuilder h5 = a.h(h4.toString());
                                            h5.append(String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(i6), Long.valueOf(currentTimeMillis5 - currentTimeMillis4)));
                                            StringBuilder h6 = a.h(h5.toString());
                                            h6.append(String.format(locale, "Total Duration: %dms", Long.valueOf(currentTimeMillis5 - currentTimeMillis)));
                                            m.a(aVar, "LruGarbageCollector", h6.toString(), new Object[0]);
                                            return new v.b(true, longValue3, i4, i6);
                                        }
                                    }
                                }
                            } catch (Throwable th4) {
                                th3 = th4;
                                cursor = rawQuery3;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th3;
                            }
                        } catch (Throwable th5) {
                            th3 = th5;
                            if (cursor != null) {
                            }
                            throw th3;
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        cursor = rawQuery2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th2;
                    }
                } catch (Throwable th7) {
                    th2 = th7;
                    if (cursor != null) {
                    }
                    throw th2;
                }
            } catch (Throwable th8) {
                th = th8;
                cursor = rawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Throwable th9) {
            th = th9;
            if (cursor != null) {
            }
            throw th;
        }
        throw th;
        throw th;
        throw th;
        throw th;
    }
}
