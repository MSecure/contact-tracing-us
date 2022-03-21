package com.google.android.apps.exposurenotification.storage;

import android.content.Context;
import e.t.f;
import e.t.g;
import e.t.h;
import e.t.p.c;
import e.v.a.b;
import e.v.a.c;
import f.b.a.a.a.w.c;
import f.b.a.a.a.w.d;
import f.b.a.a.a.w.d0;
import f.b.a.a.a.w.e0;
import f.b.a.a.a.w.h0;
import f.b.a.a.a.w.i0;
import f.b.a.a.a.w.o;
import f.b.a.a.a.w.o0;
import f.b.a.a.a.w.p;
import f.b.a.a.a.w.p0;
import f.b.a.a.a.w.t;
import f.b.a.a.a.w.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class ExposureNotificationDatabase_Impl extends ExposureNotificationDatabase {
    public volatile c q;
    public volatile o r;
    public volatile t s;
    public volatile d0 t;
    public volatile h0 u;
    public volatile o0 v;

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
            aVar.b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            aVar.b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '3e26bf5c119a5f697a07ef8566db2b60')");
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
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f1856h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull(ExposureNotificationDatabase_Impl.this.f1856h.get(i2));
                }
            }
        }

        @Override // e.t.h.a
        public void c(b bVar) {
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f1856h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    Objects.requireNonNull(ExposureNotificationDatabase_Impl.this.f1856h.get(i2));
                }
            }
        }

        @Override // e.t.h.a
        public void d(b bVar) {
            ExposureNotificationDatabase_Impl.this.a = bVar;
            ExposureNotificationDatabase_Impl.this.i(bVar);
            List<g.b> list = ExposureNotificationDatabase_Impl.this.f1856h;
            if (list != null) {
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ExposureNotificationDatabase_Impl.this.f1856h.get(i2).a(bVar);
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
            if (cVar7.equals(a7)) {
                return new h.b(true, null);
            }
            return new h.b(false, "WorkerStatusEntity(com.google.android.apps.exposurenotification.storage.WorkerStatusEntity).\n Expected:\n" + cVar7 + "\n Found:\n" + a7);
        }
    }

    @Override // e.t.g
    public f e() {
        return new f(this, new HashMap(0), new HashMap(0), "AnalyticsLoggingEntity", "CountryEntity", "DiagnosisEntity", "DownloadServerEntity", "ExposureEntity", "RevisionTokenEntity", "WorkerStatusEntity");
    }

    @Override // e.t.g
    public e.v.a.c f(e.t.a aVar) {
        h hVar = new h(aVar, new a(40), "3e26bf5c119a5f697a07ef8566db2b60", "9af364433bd2fc80bbb2313ddac49f75");
        Context context = aVar.b;
        String str = aVar.c;
        if (context != null) {
            return aVar.a.a(new c.b(context, str, hVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public f.b.a.a.a.w.c m() {
        f.b.a.a.a.w.c cVar;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            if (this.q == null) {
                this.q = new d(this);
            }
            cVar = this.q;
        }
        return cVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public o n() {
        o oVar;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            if (this.r == null) {
                this.r = new p(this);
            }
            oVar = this.r;
        }
        return oVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public t o() {
        t tVar;
        if (this.s != null) {
            return this.s;
        }
        synchronized (this) {
            if (this.s == null) {
                this.s = new u(this);
            }
            tVar = this.s;
        }
        return tVar;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public d0 p() {
        d0 d0Var;
        if (this.t != null) {
            return this.t;
        }
        synchronized (this) {
            if (this.t == null) {
                this.t = new e0(this);
            }
            d0Var = this.t;
        }
        return d0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public h0 q() {
        h0 h0Var;
        if (this.u != null) {
            return this.u;
        }
        synchronized (this) {
            if (this.u == null) {
                this.u = new i0(this);
            }
            h0Var = this.u;
        }
        return h0Var;
    }

    @Override // com.google.android.apps.exposurenotification.storage.ExposureNotificationDatabase
    public o0 r() {
        o0 o0Var;
        if (this.v != null) {
            return this.v;
        }
        synchronized (this) {
            if (this.v == null) {
                this.v = new p0(this);
            }
            o0Var = this.v;
        }
        return o0Var;
    }
}
