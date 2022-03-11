package com.google.android.apps.exposurenotification.storage;

import android.content.Context;
import e.t.f;
import e.t.g;
import e.t.h;
import e.t.p.c;
import e.v.a.b;
import e.v.a.c;
import f.b.a.a.a.y.c;
import f.b.a.a.a.y.d;
import f.b.a.a.a.y.e0;
import f.b.a.a.a.y.f0;
import f.b.a.a.a.y.i0;
import f.b.a.a.a.y.j0;
import f.b.a.a.a.y.n0;
import f.b.a.a.a.y.o0;
import f.b.a.a.a.y.p;
import f.b.a.a.a.y.q;
import f.b.a.a.a.y.u;
import f.b.a.a.a.y.u0;
import f.b.a.a.a.y.v;
import f.b.a.a.a.y.v0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class ExposureNotificationDatabase_Impl extends ExposureNotificationDatabase {
    public volatile c r;
    public volatile p s;
    public volatile u t;
    public volatile e0 u;
    public volatile n0 v;
    public volatile u0 w;
    public volatile i0 x;

    public class a extends h.a {
        public a(int i2) {
            super(i2);
        }

        @Override // e.t.h.a
        public void a(b bVar) {
            ((e.v.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `AnalyticsLoggingEntity` (`key` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `eventProto` TEXT NOT NULL)");
            e.v.a.f.a aVar = (e.v.a.f.a) bVar;
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `CountryEntity` (`countryCode` TEXT NOT NULL, `lastSeenTimestampMillis` INTEGER NOT NULL, PRIMARY KEY(`countryCode`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `DiagnosisEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `createdTimestampMs` INTEGER NOT NULL, `sharedStatus` TEXT, `verificationCode` TEXT, `longTermToken` TEXT, `certificate` TEXT, `testResult` TEXT, `onsetDate` TEXT, `isServerOnsetDate` INTEGER NOT NULL, `hasSymptoms` TEXT, `revisionToken` TEXT, `travelStatus` TEXT, `isCodeFromLink` INTEGER NOT NULL)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `DownloadServerEntity` (`indexUri` TEXT NOT NULL, `mostRecentSuccessfulDownload` TEXT, PRIMARY KEY(`indexUri`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `ExposureEntity` (`dateDaysSinceEpoch` INTEGER NOT NULL, `exposureScore` REAL NOT NULL, PRIMARY KEY(`dateDaysSinceEpoch`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `RevisionTokenEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `createdTimestampMs` INTEGER NOT NULL, `revisionToken` TEXT NOT NULL)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `WorkerStatusEntity` (`workerTaskNameAndStatus` TEXT NOT NULL, `lastRunTimestampMillis` INTEGER NOT NULL, PRIMARY KEY(`workerTaskNameAndStatus`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `ExposureCheckEntity` (`checkTime` INTEGER NOT NULL, PRIMARY KEY(`checkTime`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            aVar.b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'a0b7e876b4dc9755d63c707fa0a782d2')");
        }

        @Override // e.t.h.a
        public void b(b bVar) {
            e.v.a.f.a aVar = (e.v.a.f.a) bVar;
            aVar.b.execSQL("DROP TABLE IF EXISTS `AnalyticsLoggingEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `CountryEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `DiagnosisEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `DownloadServerEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `ExposureEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `RevisionTokenEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `WorkerStatusEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `ExposureCheckEntity`");
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f1889h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull(ExposureNotificationDatabase_Impl.this.f1889h.get(i2));
                }
            }
        }

        @Override // e.t.h.a
        public void c(b bVar) {
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f1889h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull(ExposureNotificationDatabase_Impl.this.f1889h.get(i2));
                }
            }
        }

        @Override // e.t.h.a
        public void d(b bVar) {
            ExposureNotificationDatabase_Impl.this.a = bVar;
            ExposureNotificationDatabase_Impl.this.i(bVar);
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f1889h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ExposureNotificationDatabase_Impl.this.f1889h.get(i2).a(bVar);
                }
            }
        }

        @Override // e.t.h.a
        public void e(b bVar) {
        }

        @Override // e.t.h.a
        public void f(b bVar) {
            e.t.p.b.a(bVar);
        }

        @Override // e.t.h.a
        public h.b g(b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("key", new c.a("key", "INTEGER", true, 1, null, 1));
            hashMap.put("eventProto", new c.a("eventProto", "TEXT", true, 0, null, 1));
            e.t.p.c cVar = new e.t.p.c("AnalyticsLoggingEntity", hashMap, new HashSet(0), new HashSet(0));
            e.t.p.c a = e.t.p.c.a(bVar, "AnalyticsLoggingEntity");
            if (!cVar.equals(a)) {
                return new h.b(false, "AnalyticsLoggingEntity(com.google.android.apps.exposurenotification.storage.AnalyticsLoggingEntity).\n Expected:\n" + cVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("countryCode", new c.a("countryCode", "TEXT", true, 1, null, 1));
            hashMap2.put("lastSeenTimestampMillis", new c.a("lastSeenTimestampMillis", "INTEGER", true, 0, null, 1));
            e.t.p.c cVar2 = new e.t.p.c("CountryEntity", hashMap2, new HashSet(0), new HashSet(0));
            e.t.p.c a2 = e.t.p.c.a(bVar, "CountryEntity");
            if (!cVar2.equals(a2)) {
                return new h.b(false, "CountryEntity(com.google.android.apps.exposurenotification.storage.CountryEntity).\n Expected:\n" + cVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(13);
            hashMap3.put("id", new c.a("id", "INTEGER", true, 1, null, 1));
            hashMap3.put("createdTimestampMs", new c.a("createdTimestampMs", "INTEGER", true, 0, null, 1));
            hashMap3.put("sharedStatus", new c.a("sharedStatus", "TEXT", false, 0, null, 1));
            hashMap3.put("verificationCode", new c.a("verificationCode", "TEXT", false, 0, null, 1));
            hashMap3.put("longTermToken", new c.a("longTermToken", "TEXT", false, 0, null, 1));
            hashMap3.put("certificate", new c.a("certificate", "TEXT", false, 0, null, 1));
            hashMap3.put("testResult", new c.a("testResult", "TEXT", false, 0, null, 1));
            hashMap3.put("onsetDate", new c.a("onsetDate", "TEXT", false, 0, null, 1));
            hashMap3.put("isServerOnsetDate", new c.a("isServerOnsetDate", "INTEGER", true, 0, null, 1));
            hashMap3.put("hasSymptoms", new c.a("hasSymptoms", "TEXT", false, 0, null, 1));
            hashMap3.put("revisionToken", new c.a("revisionToken", "TEXT", false, 0, null, 1));
            hashMap3.put("travelStatus", new c.a("travelStatus", "TEXT", false, 0, null, 1));
            hashMap3.put("isCodeFromLink", new c.a("isCodeFromLink", "INTEGER", true, 0, null, 1));
            e.t.p.c cVar3 = new e.t.p.c("DiagnosisEntity", hashMap3, new HashSet(0), new HashSet(0));
            e.t.p.c a3 = e.t.p.c.a(bVar, "DiagnosisEntity");
            if (!cVar3.equals(a3)) {
                return new h.b(false, "DiagnosisEntity(com.google.android.apps.exposurenotification.storage.DiagnosisEntity).\n Expected:\n" + cVar3 + "\n Found:\n" + a3);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("indexUri", new c.a("indexUri", "TEXT", true, 1, null, 1));
            hashMap4.put("mostRecentSuccessfulDownload", new c.a("mostRecentSuccessfulDownload", "TEXT", false, 0, null, 1));
            e.t.p.c cVar4 = new e.t.p.c("DownloadServerEntity", hashMap4, new HashSet(0), new HashSet(0));
            e.t.p.c a4 = e.t.p.c.a(bVar, "DownloadServerEntity");
            if (!cVar4.equals(a4)) {
                return new h.b(false, "DownloadServerEntity(com.google.android.apps.exposurenotification.storage.DownloadServerEntity).\n Expected:\n" + cVar4 + "\n Found:\n" + a4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("dateDaysSinceEpoch", new c.a("dateDaysSinceEpoch", "INTEGER", true, 1, null, 1));
            hashMap5.put("exposureScore", new c.a("exposureScore", "REAL", true, 0, null, 1));
            e.t.p.c cVar5 = new e.t.p.c("ExposureEntity", hashMap5, new HashSet(0), new HashSet(0));
            e.t.p.c a5 = e.t.p.c.a(bVar, "ExposureEntity");
            if (!cVar5.equals(a5)) {
                return new h.b(false, "ExposureEntity(com.google.android.apps.exposurenotification.storage.ExposureEntity).\n Expected:\n" + cVar5 + "\n Found:\n" + a5);
            }
            HashMap hashMap6 = new HashMap(3);
            hashMap6.put("id", new c.a("id", "INTEGER", true, 1, null, 1));
            hashMap6.put("createdTimestampMs", new c.a("createdTimestampMs", "INTEGER", true, 0, null, 1));
            hashMap6.put("revisionToken", new c.a("revisionToken", "TEXT", true, 0, null, 1));
            e.t.p.c cVar6 = new e.t.p.c("RevisionTokenEntity", hashMap6, new HashSet(0), new HashSet(0));
            e.t.p.c a6 = e.t.p.c.a(bVar, "RevisionTokenEntity");
            if (!cVar6.equals(a6)) {
                return new h.b(false, "RevisionTokenEntity(com.google.android.apps.exposurenotification.storage.RevisionTokenEntity).\n Expected:\n" + cVar6 + "\n Found:\n" + a6);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("workerTaskNameAndStatus", new c.a("workerTaskNameAndStatus", "TEXT", true, 1, null, 1));
            hashMap7.put("lastRunTimestampMillis", new c.a("lastRunTimestampMillis", "INTEGER", true, 0, null, 1));
            e.t.p.c cVar7 = new e.t.p.c("WorkerStatusEntity", hashMap7, new HashSet(0), new HashSet(0));
            e.t.p.c a7 = e.t.p.c.a(bVar, "WorkerStatusEntity");
            if (!cVar7.equals(a7)) {
                return new h.b(false, "WorkerStatusEntity(com.google.android.apps.exposurenotification.storage.WorkerStatusEntity).\n Expected:\n" + cVar7 + "\n Found:\n" + a7);
            }
            HashMap hashMap8 = new HashMap(1);
            hashMap8.put("checkTime", new c.a("checkTime", "INTEGER", true, 1, null, 1));
            e.t.p.c cVar8 = new e.t.p.c("ExposureCheckEntity", hashMap8, new HashSet(0), new HashSet(0));
            e.t.p.c a8 = e.t.p.c.a(bVar, "ExposureCheckEntity");
            if (cVar8.equals(a8)) {
                return new h.b(true, null);
            }
            return new h.b(false, "ExposureCheckEntity(com.google.android.apps.exposurenotification.storage.ExposureCheckEntity).\n Expected:\n" + cVar8 + "\n Found:\n" + a8);
        }
    }

    @Override // e.t.g
    public f e() {
        return new f(this, new HashMap(0), new HashMap(0), "AnalyticsLoggingEntity", "CountryEntity", "DiagnosisEntity", "DownloadServerEntity", "ExposureEntity", "RevisionTokenEntity", "WorkerStatusEntity", "ExposureCheckEntity");
    }

    @Override // e.t.g
    public e.v.a.c f(e.t.a aVar) {
        h hVar = new h(aVar, new a(41), "a0b7e876b4dc9755d63c707fa0a782d2", "f1c475155a72d5e8a5e96ab89e7390b3");
        Context context = aVar.b;
        String str = aVar.c;
        if (context != null) {
            return aVar.a.a(new c.b(context, str, hVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public f.b.a.a.a.y.c m() {
        f.b.a.a.a.y.c cVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            if (this.r == null) {
                this.r = new d(this);
            }
            cVar = this.r;
        }
        return cVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public p n() {
        p pVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            if (this.s == null) {
                this.s = new q(this);
            }
            pVar = this.s;
        }
        return pVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public u o() {
        u uVar;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new v(this);
            }
            uVar = this.t;
        }
        return uVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public e0 p() {
        e0 e0Var;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            if (this.u == null) {
                this.u = new f0(this);
            }
            e0Var = this.u;
        }
        return e0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public i0 q() {
        i0 i0Var;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            if (this.x == null) {
                this.x = new j0(this);
            }
            i0Var = this.x;
        }
        return i0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public n0 r() {
        n0 n0Var;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            if (this.v == null) {
                this.v = new o0(this);
            }
            n0Var = this.v;
        }
        return n0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public u0 s() {
        u0 u0Var;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            if (this.w == null) {
                this.w = new v0(this);
            }
            u0Var = this.w;
        }
        return u0Var;
    }
}
