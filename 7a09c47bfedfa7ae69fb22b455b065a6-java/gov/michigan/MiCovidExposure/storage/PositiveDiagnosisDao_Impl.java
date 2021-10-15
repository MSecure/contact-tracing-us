package gov.michigan.MiCovidExposure.storage;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import b.b.k.i;
import b.s.b;
import b.s.h;
import b.s.j;
import b.s.m;
import b.s.o.d;
import b.w.a.f;
import b.w.a.g.e;
import c.b.b.e.a.u;
import g.b.a.s;
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
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass1 */

            public void bind(f fVar, PositiveDiagnosisEntity positiveDiagnosisEntity) {
                ((e) fVar).f2630b.bindLong(1, positiveDiagnosisEntity.getId());
                e eVar = (e) fVar;
                eVar.f2630b.bindLong(2, positiveDiagnosisEntity.getCreatedTimestampMs());
                String fromOffsetDateTime = ZonedDateTimeTypeConverter.fromOffsetDateTime(positiveDiagnosisEntity.getTestTimestamp());
                if (fromOffsetDateTime == null) {
                    eVar.f2630b.bindNull(3);
                } else {
                    eVar.f2630b.bindString(3, fromOffsetDateTime);
                }
                eVar.f2630b.bindLong(4, positiveDiagnosisEntity.isShared() ? 1 : 0);
            }

            @Override // b.s.m
            public String createQuery() {
                return "INSERT OR REPLACE INTO `PositiveDiagnosisEntity` (`id`,`created_timestamp_ms`,`test_timestamp`,`shared`) VALUES (nullif(?, 0),?,?,?)";
            }
        };
        this.__preparedStmtOfDeleteById = new m(hVar) {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass2 */

            @Override // b.s.m
            public String createQuery() {
                return "DELETE FROM PositiveDiagnosisEntity WHERE id = ?";
            }
        };
        this.__preparedStmtOfMarkSharedForId = new m(hVar) {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass3 */

            @Override // b.s.m
            public String createQuery() {
                return "UPDATE PositiveDiagnosisEntity SET shared = ? WHERE id = ?";
            }
        };
    }

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
    public u<Void> deleteById(final long j) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                f acquire = PositiveDiagnosisDao_Impl.this.__preparedStmtOfDeleteById.acquire();
                ((e) acquire).f2630b.bindLong(1, j);
                PositiveDiagnosisDao_Impl.this.__db.beginTransaction();
                try {
                    ((b.w.a.g.f) acquire).b();
                    PositiveDiagnosisDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PositiveDiagnosisDao_Impl.this.__db.endTransaction();
                    PositiveDiagnosisDao_Impl.this.__preparedStmtOfDeleteById.release(acquire);
                }
            }
        });
    }

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
    public List<PositiveDiagnosisEntity> getAll() {
        j c2 = j.c("SELECT * FROM PositiveDiagnosisEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.__db, c2, false, null);
        try {
            int y = i.j.y(b2, "id");
            int y2 = i.j.y(b2, "created_timestamp_ms");
            int y3 = i.j.y(b2, "test_timestamp");
            int y4 = i.j.y(b2, "shared");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                PositiveDiagnosisEntity positiveDiagnosisEntity = new PositiveDiagnosisEntity(ZonedDateTimeTypeConverter.toOffsetDateTime(b2.getString(y3)), b2.getInt(y4) != 0);
                positiveDiagnosisEntity.id = b2.getLong(y);
                positiveDiagnosisEntity.setCreatedTimestampMs(b2.getLong(y2));
                arrayList.add(positiveDiagnosisEntity);
            }
            return arrayList;
        } finally {
            b2.close();
            c2.g();
        }
    }

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
    public LiveData<List<PositiveDiagnosisEntity>> getAllLiveData() {
        final j c2 = j.c("SELECT * FROM PositiveDiagnosisEntity ORDER BY id DESC", 0);
        return this.__db.getInvalidationTracker().b(new String[]{"PositiveDiagnosisEntity"}, false, new Callable<List<PositiveDiagnosisEntity>>() {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass8 */

            @Override // java.util.concurrent.Callable
            public List<PositiveDiagnosisEntity> call() {
                Cursor b2 = b.s.q.b.b(PositiveDiagnosisDao_Impl.this.__db, c2, false, null);
                try {
                    int y = i.j.y(b2, "id");
                    int y2 = i.j.y(b2, "created_timestamp_ms");
                    int y3 = i.j.y(b2, "test_timestamp");
                    int y4 = i.j.y(b2, "shared");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        PositiveDiagnosisEntity positiveDiagnosisEntity = new PositiveDiagnosisEntity(ZonedDateTimeTypeConverter.toOffsetDateTime(b2.getString(y3)), b2.getInt(y4) != 0);
                        positiveDiagnosisEntity.id = b2.getLong(y);
                        positiveDiagnosisEntity.setCreatedTimestampMs(b2.getLong(y2));
                        arrayList.add(positiveDiagnosisEntity);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }

            @Override // java.lang.Object
            public void finalize() {
                c2.g();
            }
        });
    }

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
    public LiveData<PositiveDiagnosisEntity> getById(long j) {
        final j c2 = j.c("SELECT * FROM PositiveDiagnosisEntity WHERE id = ?", 1);
        c2.d(1, j);
        return this.__db.getInvalidationTracker().b(new String[]{"PositiveDiagnosisEntity"}, false, new Callable<PositiveDiagnosisEntity>() {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass7 */

            @Override // java.util.concurrent.Callable
            public PositiveDiagnosisEntity call() {
                boolean z = false;
                PositiveDiagnosisEntity positiveDiagnosisEntity = null;
                Cursor b2 = b.s.q.b.b(PositiveDiagnosisDao_Impl.this.__db, c2, false, null);
                try {
                    int y = i.j.y(b2, "id");
                    int y2 = i.j.y(b2, "created_timestamp_ms");
                    int y3 = i.j.y(b2, "test_timestamp");
                    int y4 = i.j.y(b2, "shared");
                    if (b2.moveToFirst()) {
                        s offsetDateTime = ZonedDateTimeTypeConverter.toOffsetDateTime(b2.getString(y3));
                        if (b2.getInt(y4) != 0) {
                            z = true;
                        }
                        PositiveDiagnosisEntity positiveDiagnosisEntity2 = new PositiveDiagnosisEntity(offsetDateTime, z);
                        positiveDiagnosisEntity2.id = b2.getLong(y);
                        positiveDiagnosisEntity2.setCreatedTimestampMs(b2.getLong(y2));
                        positiveDiagnosisEntity = positiveDiagnosisEntity2;
                    }
                    return positiveDiagnosisEntity;
                } finally {
                    b2.close();
                }
            }

            @Override // java.lang.Object
            public void finalize() {
                c2.g();
            }
        });
    }

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
    public u<Void> markSharedForId(final long j, final boolean z) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                f acquire = PositiveDiagnosisDao_Impl.this.__preparedStmtOfMarkSharedForId.acquire();
                ((e) acquire).f2630b.bindLong(1, z ? 1 : 0);
                ((e) acquire).f2630b.bindLong(2, j);
                PositiveDiagnosisDao_Impl.this.__db.beginTransaction();
                try {
                    ((b.w.a.g.f) acquire).b();
                    PositiveDiagnosisDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PositiveDiagnosisDao_Impl.this.__db.endTransaction();
                    PositiveDiagnosisDao_Impl.this.__preparedStmtOfMarkSharedForId.release(acquire);
                }
            }
        });
    }

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
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

    @Override // gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao
    public u<Void> upsertAsync(final PositiveDiagnosisEntity positiveDiagnosisEntity) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.PositiveDiagnosisDao_Impl.AnonymousClass4 */

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
