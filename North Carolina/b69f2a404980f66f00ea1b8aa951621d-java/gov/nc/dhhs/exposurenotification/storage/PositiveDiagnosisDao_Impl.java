package gov.nc.dhhs.exposurenotification.storage;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import b.b.k.i;
import b.r.b;
import b.r.h;
import b.r.j;
import b.r.m;
import b.r.o.d;
import b.u.a.f;
import b.u.a.g.e;
import c.b.b.e.a.u;
import e.c.a.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class PositiveDiagnosisDao_Impl extends PositiveDiagnosisDao {
    public final h __db;
    public final b<PositiveDiagnosisEntity> __insertionAdapterOfPositiveDiagnosisEntity;
    public final m __preparedStmtOfDeleteById;
    public final m __preparedStmtOfMarkSharedForId;

    public PositiveDiagnosisDao_Impl(h hVar) {
        this.__db = hVar;
        this.__insertionAdapterOfPositiveDiagnosisEntity = new b<PositiveDiagnosisEntity>(hVar) {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass1 */

            public void bind(f fVar, PositiveDiagnosisEntity positiveDiagnosisEntity) {
                ((e) fVar).f1754b.bindLong(1, positiveDiagnosisEntity.getId());
                e eVar = (e) fVar;
                eVar.f1754b.bindLong(2, positiveDiagnosisEntity.getCreatedTimestampMs());
                String fromOffsetDateTime = ZonedDateTimeTypeConverter.fromOffsetDateTime(positiveDiagnosisEntity.getTestTimestamp());
                if (fromOffsetDateTime == null) {
                    eVar.f1754b.bindNull(3);
                } else {
                    eVar.f1754b.bindString(3, fromOffsetDateTime);
                }
                eVar.f1754b.bindLong(4, positiveDiagnosisEntity.isShared() ? 1 : 0);
            }

            @Override // b.r.m
            public String createQuery() {
                return "INSERT OR REPLACE INTO `PositiveDiagnosisEntity` (`id`,`created_timestamp_ms`,`test_timestamp`,`shared`) VALUES (nullif(?, 0),?,?,?)";
            }
        };
        this.__preparedStmtOfDeleteById = new m(hVar) {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass2 */

            @Override // b.r.m
            public String createQuery() {
                return "DELETE FROM PositiveDiagnosisEntity WHERE id = ?";
            }
        };
        this.__preparedStmtOfMarkSharedForId = new m(hVar) {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass3 */

            @Override // b.r.m
            public String createQuery() {
                return "UPDATE PositiveDiagnosisEntity SET shared = ? WHERE id = ?";
            }
        };
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public u<Void> deleteById(final long j) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                f acquire = PositiveDiagnosisDao_Impl.this.__preparedStmtOfDeleteById.acquire();
                ((e) acquire).f1754b.bindLong(1, j);
                PositiveDiagnosisDao_Impl.this.__db.beginTransaction();
                try {
                    ((b.u.a.g.f) acquire).b();
                    PositiveDiagnosisDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PositiveDiagnosisDao_Impl.this.__db.endTransaction();
                    PositiveDiagnosisDao_Impl.this.__preparedStmtOfDeleteById.release(acquire);
                }
            }
        });
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public List<PositiveDiagnosisEntity> getAll() {
        j d2 = j.d("SELECT * FROM PositiveDiagnosisEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.__db, d2, false, null);
        try {
            int a0 = i.j.a0(b2, "id");
            int a02 = i.j.a0(b2, "created_timestamp_ms");
            int a03 = i.j.a0(b2, "test_timestamp");
            int a04 = i.j.a0(b2, "shared");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                PositiveDiagnosisEntity positiveDiagnosisEntity = new PositiveDiagnosisEntity(ZonedDateTimeTypeConverter.toOffsetDateTime(b2.getString(a03)), b2.getInt(a04) != 0);
                positiveDiagnosisEntity.id = b2.getLong(a0);
                positiveDiagnosisEntity.setCreatedTimestampMs(b2.getLong(a02));
                arrayList.add(positiveDiagnosisEntity);
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public LiveData<List<PositiveDiagnosisEntity>> getAllLiveData() {
        final j d2 = j.d("SELECT * FROM PositiveDiagnosisEntity ORDER BY id DESC", 0);
        return this.__db.getInvalidationTracker().b(new String[]{"PositiveDiagnosisEntity"}, false, new Callable<List<PositiveDiagnosisEntity>>() {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass8 */

            @Override // java.util.concurrent.Callable
            public List<PositiveDiagnosisEntity> call() {
                Cursor b2 = b.r.q.b.b(PositiveDiagnosisDao_Impl.this.__db, d2, false, null);
                try {
                    int a0 = i.j.a0(b2, "id");
                    int a02 = i.j.a0(b2, "created_timestamp_ms");
                    int a03 = i.j.a0(b2, "test_timestamp");
                    int a04 = i.j.a0(b2, "shared");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        PositiveDiagnosisEntity positiveDiagnosisEntity = new PositiveDiagnosisEntity(ZonedDateTimeTypeConverter.toOffsetDateTime(b2.getString(a03)), b2.getInt(a04) != 0);
                        positiveDiagnosisEntity.id = b2.getLong(a0);
                        positiveDiagnosisEntity.setCreatedTimestampMs(b2.getLong(a02));
                        arrayList.add(positiveDiagnosisEntity);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }

            @Override // java.lang.Object
            public void finalize() {
                d2.h();
            }
        });
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public LiveData<PositiveDiagnosisEntity> getById(long j) {
        final j d2 = j.d("SELECT * FROM PositiveDiagnosisEntity WHERE id = ?", 1);
        d2.e(1, j);
        return this.__db.getInvalidationTracker().b(new String[]{"PositiveDiagnosisEntity"}, false, new Callable<PositiveDiagnosisEntity>() {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass7 */

            @Override // java.util.concurrent.Callable
            public PositiveDiagnosisEntity call() {
                boolean z = false;
                PositiveDiagnosisEntity positiveDiagnosisEntity = null;
                Cursor b2 = b.r.q.b.b(PositiveDiagnosisDao_Impl.this.__db, d2, false, null);
                try {
                    int a0 = i.j.a0(b2, "id");
                    int a02 = i.j.a0(b2, "created_timestamp_ms");
                    int a03 = i.j.a0(b2, "test_timestamp");
                    int a04 = i.j.a0(b2, "shared");
                    if (b2.moveToFirst()) {
                        s offsetDateTime = ZonedDateTimeTypeConverter.toOffsetDateTime(b2.getString(a03));
                        if (b2.getInt(a04) != 0) {
                            z = true;
                        }
                        PositiveDiagnosisEntity positiveDiagnosisEntity2 = new PositiveDiagnosisEntity(offsetDateTime, z);
                        positiveDiagnosisEntity2.id = b2.getLong(a0);
                        positiveDiagnosisEntity2.setCreatedTimestampMs(b2.getLong(a02));
                        positiveDiagnosisEntity = positiveDiagnosisEntity2;
                    }
                    return positiveDiagnosisEntity;
                } finally {
                    b2.close();
                }
            }

            @Override // java.lang.Object
            public void finalize() {
                d2.h();
            }
        });
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public u<Void> markSharedForId(final long j, final boolean z) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                f acquire = PositiveDiagnosisDao_Impl.this.__preparedStmtOfMarkSharedForId.acquire();
                ((e) acquire).f1754b.bindLong(1, z ? 1 : 0);
                ((e) acquire).f1754b.bindLong(2, j);
                PositiveDiagnosisDao_Impl.this.__db.beginTransaction();
                try {
                    ((b.u.a.g.f) acquire).b();
                    PositiveDiagnosisDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PositiveDiagnosisDao_Impl.this.__db.endTransaction();
                    PositiveDiagnosisDao_Impl.this.__preparedStmtOfMarkSharedForId.release(acquire);
                }
            }
        });
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public void upsert(PositiveDiagnosisEntity positiveDiagnosisEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPositiveDiagnosisEntity.insert(positiveDiagnosisEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao
    public u<Void> upsertAsync(final PositiveDiagnosisEntity positiveDiagnosisEntity) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.PositiveDiagnosisDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                PositiveDiagnosisDao_Impl.this.__db.beginTransaction();
                try {
                    PositiveDiagnosisDao_Impl.this.__insertionAdapterOfPositiveDiagnosisEntity.insert(positiveDiagnosisEntity);
                    PositiveDiagnosisDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PositiveDiagnosisDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }
}
