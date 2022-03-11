package com.google.android.apps.exposurenotification.storage;

import android.content.Context;
import e.v.f;
import e.v.g;
import e.v.h;
import e.v.p.d;
import e.x.a.b;
import e.x.a.c;
import f.b.a.a.a.n0.c;
import f.b.a.a.a.n0.d0;
import f.b.a.a.a.n0.e1;
import f.b.a.a.a.n0.f1;
import f.b.a.a.a.n0.l0;
import f.b.a.a.a.n0.m0;
import f.b.a.a.a.n0.m1;
import f.b.a.a.a.n0.n1;
import f.b.a.a.a.n0.q0;
import f.b.a.a.a.n0.r;
import f.b.a.a.a.n0.r0;
import f.b.a.a.a.n0.s;
import f.b.a.a.a.n0.w0;
import f.b.a.a.a.n0.x;
import f.b.a.a.a.n0.x0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public final class ExposureNotificationDatabase_Impl extends ExposureNotificationDatabase {
    public volatile q0 A;
    public volatile e1 B;
    public volatile c u;
    public volatile r v;
    public volatile x w;
    public volatile l0 x;
    public volatile w0 y;
    public volatile m1 z;

    /* loaded from: classes.dex */
    public class a extends h.a {
        public a(int i2) {
            super(i2);
        }

        @Override // e.v.h.a
        public void a(b bVar) {
            ((e.x.a.f.a) bVar).b.execSQL("CREATE TABLE IF NOT EXISTS `AnalyticsLoggingEntity` (`key` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `eventProto` TEXT NOT NULL)");
            e.x.a.f.a aVar = (e.x.a.f.a) bVar;
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `CountryEntity` (`countryCode` TEXT NOT NULL, `lastSeenTimestampMillis` INTEGER NOT NULL, PRIMARY KEY(`countryCode`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `DiagnosisEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `createdTimestampMs` INTEGER NOT NULL, `sharedStatus` TEXT, `verificationCode` TEXT, `longTermToken` TEXT, `certificate` TEXT, `testResult` TEXT, `onsetDate` TEXT, `isServerOnsetDate` INTEGER NOT NULL, `hasSymptoms` TEXT, `revisionToken` TEXT, `travelStatus` TEXT, `isCodeFromLink` INTEGER NOT NULL, `lastUpdatedTimestampMs` INTEGER NOT NULL, `isPreAuth` INTEGER NOT NULL)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `DownloadServerEntity` (`indexUri` TEXT NOT NULL, `mostRecentSuccessfulDownload` TEXT, PRIMARY KEY(`indexUri`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `ExposureEntity` (`dateDaysSinceEpoch` INTEGER NOT NULL, `exposureScore` REAL NOT NULL, PRIMARY KEY(`dateDaysSinceEpoch`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `RevisionTokenEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `createdTimestampMs` INTEGER NOT NULL, `revisionToken` TEXT NOT NULL)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `WorkerStatusEntity` (`workerTaskNameAndStatus` TEXT NOT NULL, `lastRunTimestampMillis` INTEGER NOT NULL, PRIMARY KEY(`workerTaskNameAndStatus`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `ExposureCheckEntity` (`checkTime` INTEGER NOT NULL, PRIMARY KEY(`checkTime`))");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS `VerificationCodeRequestEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `requestTime` INTEGER NOT NULL, `expiresAtTime` INTEGER, `nonce` TEXT NOT NULL)");
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            aVar.b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4836c55219c4fc971dcb008b0e9a9633')");
        }

        @Override // e.v.h.a
        public void b(b bVar) {
            e.x.a.f.a aVar = (e.x.a.f.a) bVar;
            aVar.b.execSQL("DROP TABLE IF EXISTS `AnalyticsLoggingEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `CountryEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `DiagnosisEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `DownloadServerEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `ExposureEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `RevisionTokenEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `WorkerStatusEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `ExposureCheckEntity`");
            aVar.b.execSQL("DROP TABLE IF EXISTS `VerificationCodeRequestEntity`");
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f2065h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull(ExposureNotificationDatabase_Impl.this.f2065h.get(i2));
                }
            }
        }

        @Override // e.v.h.a
        public void c(b bVar) {
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f2065h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull(ExposureNotificationDatabase_Impl.this.f2065h.get(i2));
                }
            }
        }

        @Override // e.v.h.a
        public void d(b bVar) {
            ExposureNotificationDatabase_Impl.this.a = bVar;
            ExposureNotificationDatabase_Impl.this.i(bVar);
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f2065h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ExposureNotificationDatabase_Impl.this.f2065h.get(i2).a(bVar);
                }
            }
        }

        @Override // e.v.h.a
        public void e(b bVar) {
        }

        @Override // e.v.h.a
        public void f(b bVar) {
            e.v.p.b.a(bVar);
        }

        @Override // e.v.h.a
        public h.b g(b bVar) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("key", new d.a("key", "INTEGER", true, 1, null, 1));
            hashMap.put("eventProto", new d.a("eventProto", "TEXT", true, 0, null, 1));
            d dVar = new d("AnalyticsLoggingEntity", hashMap, new HashSet(0), new HashSet(0));
            d a = d.a(bVar, "AnalyticsLoggingEntity");
            if (!dVar.equals(a)) {
                return new h.b(false, "AnalyticsLoggingEntity(com.google.android.apps.exposurenotification.storage.AnalyticsLoggingEntity).\n Expected:\n" + dVar + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(2);
            hashMap2.put("countryCode", new d.a("countryCode", "TEXT", true, 1, null, 1));
            hashMap2.put("lastSeenTimestampMillis", new d.a("lastSeenTimestampMillis", "INTEGER", true, 0, null, 1));
            d dVar2 = new d("CountryEntity", hashMap2, new HashSet(0), new HashSet(0));
            d a2 = d.a(bVar, "CountryEntity");
            if (!dVar2.equals(a2)) {
                return new h.b(false, "CountryEntity(com.google.android.apps.exposurenotification.storage.CountryEntity).\n Expected:\n" + dVar2 + "\n Found:\n" + a2);
            }
            HashMap hashMap3 = new HashMap(15);
            hashMap3.put("id", new d.a("id", "INTEGER", true, 1, null, 1));
            hashMap3.put("createdTimestampMs", new d.a("createdTimestampMs", "INTEGER", true, 0, null, 1));
            hashMap3.put("sharedStatus", new d.a("sharedStatus", "TEXT", false, 0, null, 1));
            hashMap3.put("verificationCode", new d.a("verificationCode", "TEXT", false, 0, null, 1));
            hashMap3.put("longTermToken", new d.a("longTermToken", "TEXT", false, 0, null, 1));
            hashMap3.put("certificate", new d.a("certificate", "TEXT", false, 0, null, 1));
            hashMap3.put("testResult", new d.a("testResult", "TEXT", false, 0, null, 1));
            hashMap3.put("onsetDate", new d.a("onsetDate", "TEXT", false, 0, null, 1));
            hashMap3.put("isServerOnsetDate", new d.a("isServerOnsetDate", "INTEGER", true, 0, null, 1));
            hashMap3.put("hasSymptoms", new d.a("hasSymptoms", "TEXT", false, 0, null, 1));
            hashMap3.put("revisionToken", new d.a("revisionToken", "TEXT", false, 0, null, 1));
            hashMap3.put("travelStatus", new d.a("travelStatus", "TEXT", false, 0, null, 1));
            hashMap3.put("isCodeFromLink", new d.a("isCodeFromLink", "INTEGER", true, 0, null, 1));
            hashMap3.put("lastUpdatedTimestampMs", new d.a("lastUpdatedTimestampMs", "INTEGER", true, 0, null, 1));
            hashMap3.put("isPreAuth", new d.a("isPreAuth", "INTEGER", true, 0, null, 1));
            d dVar3 = new d("DiagnosisEntity", hashMap3, new HashSet(0), new HashSet(0));
            d a3 = d.a(bVar, "DiagnosisEntity");
            if (!dVar3.equals(a3)) {
                return new h.b(false, "DiagnosisEntity(com.google.android.apps.exposurenotification.storage.DiagnosisEntity).\n Expected:\n" + dVar3 + "\n Found:\n" + a3);
            }
            HashMap hashMap4 = new HashMap(2);
            hashMap4.put("indexUri", new d.a("indexUri", "TEXT", true, 1, null, 1));
            hashMap4.put("mostRecentSuccessfulDownload", new d.a("mostRecentSuccessfulDownload", "TEXT", false, 0, null, 1));
            d dVar4 = new d("DownloadServerEntity", hashMap4, new HashSet(0), new HashSet(0));
            d a4 = d.a(bVar, "DownloadServerEntity");
            if (!dVar4.equals(a4)) {
                return new h.b(false, "DownloadServerEntity(com.google.android.apps.exposurenotification.storage.DownloadServerEntity).\n Expected:\n" + dVar4 + "\n Found:\n" + a4);
            }
            HashMap hashMap5 = new HashMap(2);
            hashMap5.put("dateDaysSinceEpoch", new d.a("dateDaysSinceEpoch", "INTEGER", true, 1, null, 1));
            hashMap5.put("exposureScore", new d.a("exposureScore", "REAL", true, 0, null, 1));
            d dVar5 = new d("ExposureEntity", hashMap5, new HashSet(0), new HashSet(0));
            d a5 = d.a(bVar, "ExposureEntity");
            if (!dVar5.equals(a5)) {
                return new h.b(false, "ExposureEntity(com.google.android.apps.exposurenotification.storage.ExposureEntity).\n Expected:\n" + dVar5 + "\n Found:\n" + a5);
            }
            HashMap hashMap6 = new HashMap(3);
            hashMap6.put("id", new d.a("id", "INTEGER", true, 1, null, 1));
            hashMap6.put("createdTimestampMs", new d.a("createdTimestampMs", "INTEGER", true, 0, null, 1));
            hashMap6.put("revisionToken", new d.a("revisionToken", "TEXT", true, 0, null, 1));
            d dVar6 = new d("RevisionTokenEntity", hashMap6, new HashSet(0), new HashSet(0));
            d a6 = d.a(bVar, "RevisionTokenEntity");
            if (!dVar6.equals(a6)) {
                return new h.b(false, "RevisionTokenEntity(com.google.android.apps.exposurenotification.storage.RevisionTokenEntity).\n Expected:\n" + dVar6 + "\n Found:\n" + a6);
            }
            HashMap hashMap7 = new HashMap(2);
            hashMap7.put("workerTaskNameAndStatus", new d.a("workerTaskNameAndStatus", "TEXT", true, 1, null, 1));
            hashMap7.put("lastRunTimestampMillis", new d.a("lastRunTimestampMillis", "INTEGER", true, 0, null, 1));
            d dVar7 = new d("WorkerStatusEntity", hashMap7, new HashSet(0), new HashSet(0));
            d a7 = d.a(bVar, "WorkerStatusEntity");
            if (!dVar7.equals(a7)) {
                return new h.b(false, "WorkerStatusEntity(com.google.android.apps.exposurenotification.storage.WorkerStatusEntity).\n Expected:\n" + dVar7 + "\n Found:\n" + a7);
            }
            HashMap hashMap8 = new HashMap(1);
            hashMap8.put("checkTime", new d.a("checkTime", "INTEGER", true, 1, null, 1));
            d dVar8 = new d("ExposureCheckEntity", hashMap8, new HashSet(0), new HashSet(0));
            d a8 = d.a(bVar, "ExposureCheckEntity");
            if (!dVar8.equals(a8)) {
                return new h.b(false, "ExposureCheckEntity(com.google.android.apps.exposurenotification.storage.ExposureCheckEntity).\n Expected:\n" + dVar8 + "\n Found:\n" + a8);
            }
            HashMap hashMap9 = new HashMap(4);
            hashMap9.put("id", new d.a("id", "INTEGER", true, 1, null, 1));
            hashMap9.put("requestTime", new d.a("requestTime", "INTEGER", true, 0, null, 1));
            hashMap9.put("expiresAtTime", new d.a("expiresAtTime", "INTEGER", false, 0, null, 1));
            hashMap9.put("nonce", new d.a("nonce", "TEXT", true, 0, null, 1));
            d dVar9 = new d("VerificationCodeRequestEntity", hashMap9, new HashSet(0), new HashSet(0));
            d a9 = d.a(bVar, "VerificationCodeRequestEntity");
            if (dVar9.equals(a9)) {
                return new h.b(true, null);
            }
            return new h.b(false, "VerificationCodeRequestEntity(com.google.android.apps.exposurenotification.storage.VerificationCodeRequestEntity).\n Expected:\n" + dVar9 + "\n Found:\n" + a9);
        }
    }

    @Override // e.v.g
    public f e() {
        return new f(this, new HashMap(0), new HashMap(0), "AnalyticsLoggingEntity", "CountryEntity", "DiagnosisEntity", "DownloadServerEntity", "ExposureEntity", "RevisionTokenEntity", "WorkerStatusEntity", "ExposureCheckEntity", "VerificationCodeRequestEntity");
    }

    @Override // e.v.g
    public e.x.a.c f(e.v.a aVar) {
        h hVar = new h(aVar, new a(44), "4836c55219c4fc971dcb008b0e9a9633", "151ba1f401b4c059a51b52357a3439a8");
        Context context = aVar.b;
        String str = aVar.c;
        if (context != null) {
            return aVar.a.a(new c.b(context, str, hVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public f.b.a.a.a.n0.c m() {
        f.b.a.a.a.n0.c cVar;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            if (this.u == null) {
                this.u = new f.b.a.a.a.n0.d(this);
            }
            cVar = this.u;
        }
        return cVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public r n() {
        r rVar;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            if (this.v == null) {
                this.v = new s(this);
            }
            rVar = this.v;
        }
        return rVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public x o() {
        x xVar;
        if (this.w != null) {
            return this.w;
        }
        synchronized (this) {
            if (this.w == null) {
                this.w = new d0(this);
            }
            xVar = this.w;
        }
        return xVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public l0 p() {
        l0 l0Var;
        if (this.x != null) {
            return this.x;
        }
        synchronized (this) {
            if (this.x == null) {
                this.x = new m0(this);
            }
            l0Var = this.x;
        }
        return l0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public q0 q() {
        q0 q0Var;
        if (this.A != null) {
            return this.A;
        }
        synchronized (this) {
            if (this.A == null) {
                this.A = new r0(this);
            }
            q0Var = this.A;
        }
        return q0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public w0 r() {
        w0 w0Var;
        if (this.y != null) {
            return this.y;
        }
        synchronized (this) {
            if (this.y == null) {
                this.y = new x0(this);
            }
            w0Var = this.y;
        }
        return w0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public e1 s() {
        e1 e1Var;
        if (this.B != null) {
            return this.B;
        }
        synchronized (this) {
            if (this.B == null) {
                this.B = new f1(this);
            }
            e1Var = this.B;
        }
        return e1Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public m1 t() {
        m1 m1Var;
        if (this.z != null) {
            return this.z;
        }
        synchronized (this) {
            if (this.z == null) {
                this.z = new n1(this);
            }
            m1Var = this.z;
        }
        return m1Var;
    }
}
