package com.google.android.apps.exposurenotification.storage;

import e.t.g;
import f.b.a.a.a.y.e0;
import f.b.a.a.a.y.i0;
import f.b.a.a.a.y.n0;
import f.b.a.a.a.y.p;
import f.b.a.a.a.y.u;
import f.b.a.a.a.y.u0;

public abstract class ExposureNotificationDatabase extends g {

    /* renamed from: k  reason: collision with root package name */
    public static final e.t.o.a f413k;

    /* renamed from: l  reason: collision with root package name */
    public static final e.t.o.a f414l;
    public static final e.t.o.a m;
    public static final e.t.o.a n;
    public static final e.t.o.a o;
    public static final e.t.o.a p;
    public static final e.t.o.a[] q;

    public class a extends e.t.o.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN isCodeFromLink INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class b extends e.t.o.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE DownloadServerEntity (indexUri TEXT NOT NULL, mostRecentSuccessfulDownload TEXT, PRIMARY KEY(indexUri))");
        }
    }

    public class c extends e.t.o.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE AnalyticsLoggingEntity (key INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventProto TEXT NOT NULL )");
        }
    }

    public class d extends e.t.o.a {
        public d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE RevisionTokenEntity (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, createdTimestampMs INTEGER NOT NULL,revisionToken TEXT NOT NULL);");
            ((e.v.a.f.a) bVar).b.execSQL("INSERT INTO RevisionTokenEntity (createdTimestampMs, revisionToken) SELECT createdTimestampMs, revisionToken FROM DiagnosisEntity WHERE revisionToken IS NOT NULL;");
        }
    }

    public class e extends e.t.o.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE WorkerStatusEntity (workerTaskNameAndStatus TEXT NOT NULL, lastRunTimestampMillis INTEGER NOT NULL, PRIMARY KEY(workerTaskNameAndStatus))");
        }
    }

    public class f extends e.t.o.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.t.o.a
        public void a(e.v.a.b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE ExposureCheckEntity (checkTime INTEGER NOT NULL, PRIMARY KEY(checkTime))");
        }
    }

    static {
        a aVar = new a(35, 36);
        f413k = aVar;
        b bVar = new b(36, 37);
        f414l = bVar;
        c cVar = new c(37, 38);
        m = cVar;
        d dVar = new d(38, 39);
        n = dVar;
        e eVar = new e(39, 40);
        o = eVar;
        f fVar = new f(40, 41);
        p = fVar;
        q = new e.t.o.a[]{aVar, bVar, cVar, dVar, eVar, fVar};
    }

    public abstract f.b.a.a.a.y.c m();

    public abstract p n();

    public abstract u o();

    public abstract e0 p();

    public abstract i0 q();

    public abstract n0 r();

    public abstract u0 s();
}
