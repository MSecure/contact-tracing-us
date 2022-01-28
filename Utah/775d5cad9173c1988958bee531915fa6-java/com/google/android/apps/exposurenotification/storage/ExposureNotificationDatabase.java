package com.google.android.apps.exposurenotification.storage;

import f.b.a.a.a.l0.g1;
import f.b.a.a.a.l0.j0;
import f.b.a.a.a.l0.n0;
import f.b.a.a.a.l0.r;
import f.b.a.a.a.l0.s0;
import f.b.a.a.a.l0.w;
import f.b.a.a.a.l0.z0;

public abstract class ExposureNotificationDatabase extends e.u.g {

    /* renamed from: k  reason: collision with root package name */
    public static final e.u.o.a f437k;

    /* renamed from: l  reason: collision with root package name */
    public static final e.u.o.a f438l;
    public static final e.u.o.a m;
    public static final e.u.o.a n;
    public static final e.u.o.a o;
    public static final e.u.o.a p;
    public static final e.u.o.a q;
    public static final e.u.o.a r;
    public static final e.u.o.a s;
    public static final e.u.o.a[] t;

    public class a extends e.u.o.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN isCodeFromLink INTEGER NOT NULL DEFAULT 0");
        }
    }

    public class b extends e.u.o.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE DownloadServerEntity (indexUri TEXT NOT NULL, mostRecentSuccessfulDownload TEXT, PRIMARY KEY(indexUri))");
        }
    }

    public class c extends e.u.o.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE AnalyticsLoggingEntity (key INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventProto TEXT NOT NULL )");
        }
    }

    public class d extends e.u.o.a {
        public d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE RevisionTokenEntity (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, createdTimestampMs INTEGER NOT NULL,revisionToken TEXT NOT NULL);");
            ((e.w.a.f.a) bVar).b.execSQL("INSERT INTO RevisionTokenEntity (createdTimestampMs, revisionToken) SELECT createdTimestampMs, revisionToken FROM DiagnosisEntity WHERE revisionToken IS NOT NULL;");
        }
    }

    public class e extends e.u.o.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE WorkerStatusEntity (workerTaskNameAndStatus TEXT NOT NULL, lastRunTimestampMillis INTEGER NOT NULL, PRIMARY KEY(workerTaskNameAndStatus))");
        }
    }

    public class f extends e.u.o.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE ExposureCheckEntity (checkTime INTEGER NOT NULL, PRIMARY KEY(checkTime))");
        }
    }

    public class g extends e.u.o.a {
        public g(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN lastUpdatedTimestampMs INTEGER NOT NULL DEFAULT 0");
            ((e.w.a.f.a) bVar).b.execSQL("UPDATE DiagnosisEntity SET lastUpdatedTimestampMs = createdTimestampMs");
        }
    }

    public class h extends e.u.o.a {
        public h(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("CREATE TABLE VerificationCodeRequestEntity (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, requestTime INTEGER NOT NULL, expiresAtTime INTEGER, nonce TEXT NOT NULL)");
        }
    }

    public class i extends e.u.o.a {
        public i(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.u.o.a
        public void a(e.w.a.b bVar) {
            ((e.w.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN isPreAuth INTEGER NOT NULL DEFAULT 0");
        }
    }

    static {
        a aVar = new a(35, 36);
        f437k = aVar;
        b bVar = new b(36, 37);
        f438l = bVar;
        c cVar = new c(37, 38);
        m = cVar;
        d dVar = new d(38, 39);
        n = dVar;
        e eVar = new e(39, 40);
        o = eVar;
        f fVar = new f(40, 41);
        p = fVar;
        g gVar = new g(41, 42);
        q = gVar;
        h hVar = new h(42, 43);
        r = hVar;
        i iVar = new i(43, 44);
        s = iVar;
        t = new e.u.o.a[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar, iVar};
    }

    public abstract f.b.a.a.a.l0.c m();

    public abstract r n();

    public abstract w o();

    public abstract j0 p();

    public abstract n0 q();

    public abstract s0 r();

    public abstract z0 s();

    public abstract g1 t();
}
