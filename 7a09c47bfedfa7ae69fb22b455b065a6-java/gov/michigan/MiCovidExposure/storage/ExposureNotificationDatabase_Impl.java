package gov.michigan.MiCovidExposure.storage;

import android.content.Context;
import b.s.f;
import b.s.h;
import b.s.i;
import b.s.q.d;
import b.w.a.b;
import b.w.a.c;
import b.w.a.g.a;
import java.util.HashMap;
import java.util.HashSet;

public final class ExposureNotificationDatabase_Impl extends ExposureNotificationDatabase {
    public volatile ExposureDao _exposureDao;
    public volatile PositiveDiagnosisDao _positiveDiagnosisDao;
    public volatile TokenDao _tokenDao;

    @Override // b.s.h
    public void clearAllTables() {
        super.assertNotMainThread();
        b p = super.getOpenHelper().p();
        try {
            super.beginTransaction();
            ((a) p).f2616b.execSQL("DELETE FROM `PositiveDiagnosisEntity`");
            ((a) p).f2616b.execSQL("DELETE FROM `ExposureEntity`");
            ((a) p).f2616b.execSQL("DELETE FROM `TokenEntity`");
            super.setTransactionSuccessful();
            super.endTransaction();
            a aVar = (a) p;
            aVar.c(new b.w.a.a("PRAGMA wal_checkpoint(FULL)")).close();
            if (!aVar.b()) {
                aVar.f2616b.execSQL("VACUUM");
            }
        } catch (Throwable th) {
            super.endTransaction();
            ((a) p).c(new b.w.a.a("PRAGMA wal_checkpoint(FULL)")).close();
            a aVar2 = (a) p;
            if (!aVar2.b()) {
                aVar2.f2616b.execSQL("VACUUM");
            }
            throw th;
        }
    }

    @Override // b.s.h
    public f createInvalidationTracker() {
        return new f(this, new HashMap(0), new HashMap(0), "PositiveDiagnosisEntity", "ExposureEntity", "TokenEntity");
    }

    @Override // b.s.h
    public c createOpenHelper(b.s.a aVar) {
        i iVar = new i(aVar, new i.a(22) {
            /* class gov.michigan.MiCovidExposure.storage.ExposureNotificationDatabase_Impl.AnonymousClass1 */

            @Override // b.s.i.a
            public void createAllTables(b bVar) {
                ((a) bVar).f2616b.execSQL("CREATE TABLE IF NOT EXISTS `PositiveDiagnosisEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `created_timestamp_ms` INTEGER NOT NULL, `test_timestamp` TEXT NOT NULL, `shared` INTEGER NOT NULL)");
                a aVar = (a) bVar;
                aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `ExposureEntity` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `date_millis_since_epoch` INTEGER NOT NULL, `received_timestamp_ms` INTEGER NOT NULL)");
                aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS `TokenEntity` (`token` TEXT NOT NULL, `last_updated_timestamp_ms` INTEGER NOT NULL, `responded` INTEGER NOT NULL, PRIMARY KEY(`token`))");
                aVar.f2616b.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                aVar.f2616b.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '92795de803a72f23cc40ba00d5e6f865')");
            }

            @Override // b.s.i.a
            public void dropAllTables(b bVar) {
                a aVar = (a) bVar;
                aVar.f2616b.execSQL("DROP TABLE IF EXISTS `PositiveDiagnosisEntity`");
                aVar.f2616b.execSQL("DROP TABLE IF EXISTS `ExposureEntity`");
                aVar.f2616b.execSQL("DROP TABLE IF EXISTS `TokenEntity`");
                if (ExposureNotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = ExposureNotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        if (((h.b) ExposureNotificationDatabase_Impl.this.mCallbacks.get(i)) == null) {
                            throw null;
                        }
                    }
                }
            }

            @Override // b.s.i.a
            public void onCreate(b bVar) {
                if (ExposureNotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = ExposureNotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        if (((h.b) ExposureNotificationDatabase_Impl.this.mCallbacks.get(i)) == null) {
                            throw null;
                        }
                    }
                }
            }

            @Override // b.s.i.a
            public void onOpen(b bVar) {
                ExposureNotificationDatabase_Impl.this.mDatabase = bVar;
                ExposureNotificationDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (ExposureNotificationDatabase_Impl.this.mCallbacks != null) {
                    int size = ExposureNotificationDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((h.b) ExposureNotificationDatabase_Impl.this.mCallbacks.get(i)).a(bVar);
                    }
                }
            }

            @Override // b.s.i.a
            public void onPostMigrate(b bVar) {
            }

            @Override // b.s.i.a
            public void onPreMigrate(b bVar) {
                b.s.q.b.a(bVar);
            }

            @Override // b.s.i.a
            public i.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(4);
                hashMap.put("id", new d.a("id", "INTEGER", true, 1, null, 1));
                hashMap.put("created_timestamp_ms", new d.a("created_timestamp_ms", "INTEGER", true, 0, null, 1));
                hashMap.put("test_timestamp", new d.a("test_timestamp", "TEXT", true, 0, null, 1));
                hashMap.put("shared", new d.a("shared", "INTEGER", true, 0, null, 1));
                d dVar = new d("PositiveDiagnosisEntity", hashMap, new HashSet(0), new HashSet(0));
                d a2 = d.a(bVar, "PositiveDiagnosisEntity");
                if (!dVar.equals(a2)) {
                    return new i.b(false, "PositiveDiagnosisEntity(gov.michigan.MiCovidExposure.storage.PositiveDiagnosisEntity).\n Expected:\n" + dVar + "\n Found:\n" + a2);
                }
                HashMap hashMap2 = new HashMap(3);
                hashMap2.put("id", new d.a("id", "INTEGER", true, 1, null, 1));
                hashMap2.put("date_millis_since_epoch", new d.a("date_millis_since_epoch", "INTEGER", true, 0, null, 1));
                hashMap2.put("received_timestamp_ms", new d.a("received_timestamp_ms", "INTEGER", true, 0, null, 1));
                d dVar2 = new d("ExposureEntity", hashMap2, new HashSet(0), new HashSet(0));
                d a3 = d.a(bVar, "ExposureEntity");
                if (!dVar2.equals(a3)) {
                    return new i.b(false, "ExposureEntity(gov.michigan.MiCovidExposure.storage.ExposureEntity).\n Expected:\n" + dVar2 + "\n Found:\n" + a3);
                }
                HashMap hashMap3 = new HashMap(3);
                hashMap3.put("token", new d.a("token", "TEXT", true, 1, null, 1));
                hashMap3.put("last_updated_timestamp_ms", new d.a("last_updated_timestamp_ms", "INTEGER", true, 0, null, 1));
                hashMap3.put("responded", new d.a("responded", "INTEGER", true, 0, null, 1));
                d dVar3 = new d("TokenEntity", hashMap3, new HashSet(0), new HashSet(0));
                d a4 = d.a(bVar, "TokenEntity");
                if (dVar3.equals(a4)) {
                    return new i.b(true, null);
                }
                return new i.b(false, "TokenEntity(gov.michigan.MiCovidExposure.storage.TokenEntity).\n Expected:\n" + dVar3 + "\n Found:\n" + a4);
            }
        }, "92795de803a72f23cc40ba00d5e6f865", "2b1a6b8b977fc3f791c5dcacb4de7e8d");
        Context context = aVar.f2453b;
        String str = aVar.f2454c;
        if (context != null) {
            return aVar.f2452a.a(new c.b(context, str, iVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // gov.michigan.MiCovidExposure.storage.ExposureNotificationDatabase
    public ExposureDao exposureDao() {
        ExposureDao exposureDao;
        if (this._exposureDao != null) {
            return this._exposureDao;
        }
        synchronized (this) {
            if (this._exposureDao == null) {
                this._exposureDao = new ExposureDao_Impl(this);
            }
            exposureDao = this._exposureDao;
        }
        return exposureDao;
    }

    @Override // gov.michigan.MiCovidExposure.storage.ExposureNotificationDatabase
    public PositiveDiagnosisDao positiveDiagnosisDao() {
        PositiveDiagnosisDao positiveDiagnosisDao;
        if (this._positiveDiagnosisDao != null) {
            return this._positiveDiagnosisDao;
        }
        synchronized (this) {
            if (this._positiveDiagnosisDao == null) {
                this._positiveDiagnosisDao = new PositiveDiagnosisDao_Impl(this);
            }
            positiveDiagnosisDao = this._positiveDiagnosisDao;
        }
        return positiveDiagnosisDao;
    }

    @Override // gov.michigan.MiCovidExposure.storage.ExposureNotificationDatabase
    public TokenDao tokenDao() {
        TokenDao tokenDao;
        if (this._tokenDao != null) {
            return this._tokenDao;
        }
        synchronized (this) {
            if (this._tokenDao == null) {
                this._tokenDao = new TokenDao_Impl(this);
            }
            tokenDao = this._tokenDao;
        }
        return tokenDao;
    }
}
