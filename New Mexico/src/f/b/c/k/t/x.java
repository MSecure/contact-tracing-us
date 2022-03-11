package f.b.c.k.t;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import f.a.a.a.a;
import f.b.c.k.t.v;
import f.b.c.k.x.m;
import f.b.c.k.x.n;
import java.util.Objects;
/* loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {
    public final v.d b;

    public x(v.d dVar) {
        this.b = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        v.d dVar = this.b;
        r rVar = dVar.b;
        v.b bVar = (v.b) rVar.a.g("Collect garbage", new n(rVar, v.this) { // from class: f.b.c.k.t.i
            public final r a;
            public final v b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // f.b.c.k.x.n
            public Object get() {
                Throwable th;
                Throwable th2;
                Throwable th3;
                long j2;
                Cursor rawQueryWithFactory;
                Cursor rawQueryWithFactory2;
                r rVar2 = this.a;
                v vVar = this.b;
                SparseArray<d1> sparseArray = rVar2.f3612h;
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
                    Cursor rawQuery = r0Var.f3619i.rawQuery("PRAGMA page_count", null);
                    try {
                        Long valueOf = rawQuery.moveToFirst() ? Long.valueOf(rawQuery.getLong(0)) : null;
                        rawQuery.close();
                        long longValue = valueOf.longValue();
                        try {
                            Cursor rawQuery2 = r0Var.f3619i.rawQuery("PRAGMA page_size", null);
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
                                long j4 = r0Var2.f3614d.f3591f;
                                try {
                                    Cursor rawQuery3 = r0Var2.f3619i.rawQuery("SELECT COUNT(*) FROM (SELECT sequence_number FROM target_documents GROUP BY path HAVING COUNT(*) = 1 AND target_id = 0)", null);
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
                                            b1 b1Var = ((n0) vVar.a).a.f3614d;
                                            rawQueryWithFactory2 = b1Var.a.f3619i.rawQuery("SELECT target_proto FROM targets", null);
                                            while (rawQueryWithFactory2.moveToNext()) {
                                                try {
                                                    cVar.a(Long.valueOf(b1Var.g(rawQueryWithFactory2.getBlob(i2)).c));
                                                    i2 = 0;
                                                    currentTimeMillis2 = currentTimeMillis2;
                                                } finally {
                                                    if (rawQueryWithFactory2 != null) {
                                                        try {
                                                            rawQueryWithFactory2.close();
                                                        } catch (Throwable unused) {
                                                        }
                                                    }
                                                }
                                            }
                                            j2 = currentTimeMillis2;
                                            rawQueryWithFactory2.close();
                                            rawQueryWithFactory = ((n0) vVar.a).a.f3619i.rawQuery("select sequence_number from target_documents group by path having COUNT(*) = 1 AND target_id = 0", null);
                                            while (rawQueryWithFactory.moveToNext()) {
                                                try {
                                                    cVar.a(Long.valueOf(rawQueryWithFactory.getLong(0)));
                                                } finally {
                                                    if (rawQueryWithFactory != null) {
                                                        try {
                                                            rawQueryWithFactory.close();
                                                        } catch (Throwable unused2) {
                                                        }
                                                    }
                                                }
                                            }
                                            rawQueryWithFactory.close();
                                            j3 = cVar.a.peek().longValue();
                                        }
                                        long currentTimeMillis3 = System.currentTimeMillis();
                                        b1 b1Var2 = ((n0) vVar.a).a.f3614d;
                                        int[] iArr = new int[1];
                                        rawQueryWithFactory = b1Var2.a.f3619i.rawQueryWithFactory(new s0(new Object[]{Long.valueOf(j3)}), "SELECT target_id FROM targets WHERE last_listen_sequence_number <= ?", null, null);
                                        while (rawQueryWithFactory.moveToNext()) {
                                            try {
                                                int i3 = rawQueryWithFactory.getInt(0);
                                                if (sparseArray.get(i3) == null) {
                                                    b1Var2.a.f3619i.execSQL("DELETE FROM target_documents WHERE target_id = ?", new Object[]{Integer.valueOf(i3)});
                                                    b1Var2.a.f3619i.execSQL("DELETE FROM targets WHERE target_id = ?", new Object[]{Integer.valueOf(i3)});
                                                    b1Var2.f3591f--;
                                                    iArr[0] = iArr[0] + 1;
                                                    sparseArray = sparseArray;
                                                    currentTimeMillis3 = currentTimeMillis3;
                                                }
                                            } finally {
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
                                            for (boolean z = true; z; z = false) {
                                                SQLiteDatabase sQLiteDatabase = n0Var.a.f3619i;
                                                s0 s0Var = new s0(new Object[]{Long.valueOf(j3), 100});
                                                m0 m0Var = 
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0232: CONSTRUCTOR  (r9v10 'm0Var' f.b.c.k.t.m0) = (r1v4 'n0Var' f.b.c.k.t.n0), (r2v2 'iArr2' int[]) call: f.b.c.k.t.m0.<init>(f.b.c.k.t.n0, int[]):void type: CONSTRUCTOR in method: f.b.c.k.t.i.get():java.lang.Object, file: classes.dex
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:270)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:233)
                                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:90)
                                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:194)
                                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:174)
                                                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:79)
                                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:301)
                                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:255)
                                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:248)
                                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:369)
                                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:304)
                                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:270)
                                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: f.b.c.k.t.m0, state: NOT_LOADED
                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:268)
                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:668)
                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:378)
                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:263)
                                                    	... 71 more
                                                    */
                                                /*
                                                // Method dump skipped, instructions count: 830
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: f.b.c.k.t.i.get():java.lang.Object");
                                            }
                                        });
                                        dVar.c = true;
                                        dVar.a();
                                    }
                                }
