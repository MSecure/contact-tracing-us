package com.google.android.apps.exposurenotification.storage;

import f.b.a.a.a.n0.e1;
import f.b.a.a.a.n0.l0;
import f.b.a.a.a.n0.m1;
import f.b.a.a.a.n0.q0;
import f.b.a.a.a.n0.r;
import f.b.a.a.a.n0.w0;
import f.b.a.a.a.n0.x;
/* loaded from: classes.dex */
public abstract class ExposureNotificationDatabase extends e.v.g {

    /* renamed from: k */
    public static final e.v.o.a f447k;

    /* renamed from: l */
    public static final e.v.o.a f448l;
    public static final e.v.o.a m;
    public static final e.v.o.a n;
    public static final e.v.o.a o;
    public static final e.v.o.a p;
    public static final e.v.o.a q;
    public static final e.v.o.a r;
    public static final e.v.o.a s;
    public static final e.v.o.a[] t;

    /* loaded from: classes.dex */
    public class a extends e.v.o.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN isCodeFromLink INTEGER NOT NULL DEFAULT 0");
        }
    }

    /* loaded from: classes.dex */
    public class b extends e.v.o.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE DownloadServerEntity (indexUri TEXT NOT NULL, mostRecentSuccessfulDownload TEXT, PRIMARY KEY(indexUri))");
        }
    }

    /* loaded from: classes.dex */
    public class c extends e.v.o.a {
        public c(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE AnalyticsLoggingEntity (key INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, eventProto TEXT NOT NULL )");
        }
    }

    /* loaded from: classes.dex */
    public class d extends e.v.o.a {
        public d(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE RevisionTokenEntity (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, createdTimestampMs INTEGER NOT NULL,revisionToken TEXT NOT NULL);");
            ((e.x.a.f.a) bVar).b.execSQL("INSERT INTO RevisionTokenEntity (createdTimestampMs, revisionToken) SELECT createdTimestampMs, revisionToken FROM DiagnosisEntity WHERE revisionToken IS NOT NULL;");
        }
    }

    /* loaded from: classes.dex */
    public class e extends e.v.o.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE WorkerStatusEntity (workerTaskNameAndStatus TEXT NOT NULL, lastRunTimestampMillis INTEGER NOT NULL, PRIMARY KEY(workerTaskNameAndStatus))");
        }
    }

    /* loaded from: classes.dex */
    public class f extends e.v.o.a {
        public f(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE ExposureCheckEntity (checkTime INTEGER NOT NULL, PRIMARY KEY(checkTime))");
        }
    }

    /* loaded from: classes.dex */
    public class g extends e.v.o.a {
        public g(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN lastUpdatedTimestampMs INTEGER NOT NULL DEFAULT 0");
            ((e.x.a.f.a) bVar).b.execSQL("UPDATE DiagnosisEntity SET lastUpdatedTimestampMs = createdTimestampMs");
        }
    }

    /* loaded from: classes.dex */
    public class h extends e.v.o.a {
        public h(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE VerificationCodeRequestEntity (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, requestTime INTEGER NOT NULL, expiresAtTime INTEGER, nonce TEXT NOT NULL)");
        }
    }

    /* loaded from: classes.dex */
    public class i extends e.v.o.a {
        public i(int i2, int i3) {
            super(i2, i3);
        }

        @Override // e.v.o.a
        public void a(e.x.a.b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("ALTER TABLE DiagnosisEntity ADD COLUMN isPreAuth INTEGER NOT NULL DEFAULT 0");
        }
    }

    static {
        a aVar = new a(35, 36);
        f447k = aVar;
        b bVar = new b(36, 37);
        f448l = bVar;
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
        t = new e.v.o.a[]{aVar, bVar, cVar, dVar, eVar, fVar, gVar, hVar, iVar};
    }

    public abstract f.b.a.a.a.n0.c m();

    public abstract r n();

    public abstract x o();

    public abstract l0 p();

    public abstract q0 q();

    public abstract w0 r();

    public abstract e1 s();

    public abstract m1 t();
}
