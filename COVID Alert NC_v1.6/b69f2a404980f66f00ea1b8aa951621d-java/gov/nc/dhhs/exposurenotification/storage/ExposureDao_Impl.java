package gov.nc.dhhs.exposurenotification.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
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
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class ExposureDao_Impl extends ExposureDao {
    public final h __db;
    public final b<ExposureEntity> __insertionAdapterOfExposureEntity;
    public final m __preparedStmtOfDeleteAllAsync;

    public ExposureDao_Impl(h hVar) {
        this.__db = hVar;
        this.__insertionAdapterOfExposureEntity = new b<ExposureEntity>(hVar) {
            /* class gov.nc.dhhs.exposurenotification.storage.ExposureDao_Impl.AnonymousClass1 */

            public void bind(f fVar, ExposureEntity exposureEntity) {
                ((e) fVar).f1754b.bindLong(1, exposureEntity.getId());
                e eVar = (e) fVar;
                eVar.f1754b.bindLong(2, exposureEntity.getDateMillisSinceEpoch());
                eVar.f1754b.bindLong(3, exposureEntity.getReceivedTimestampMs());
            }

            @Override // b.r.m
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ExposureEntity` (`id`,`date_millis_since_epoch`,`received_timestamp_ms`) VALUES (nullif(?, 0),?,?)";
            }
        };
        this.__preparedStmtOfDeleteAllAsync = new m(hVar) {
            /* class gov.nc.dhhs.exposurenotification.storage.ExposureDao_Impl.AnonymousClass2 */

            @Override // b.r.m
            public String createQuery() {
                return "DELETE FROM ExposureEntity";
            }
        };
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public u<Void> deleteAllAsync() {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.ExposureDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                b.u.a.g.f acquire = ExposureDao_Impl.this.__preparedStmtOfDeleteAllAsync.acquire();
                ExposureDao_Impl.this.__db.beginTransaction();
                acquire = (b.u.a.g.f) acquire;
                try {
                    acquire.b();
                    ExposureDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    ExposureDao_Impl.this.__db.endTransaction();
                    ExposureDao_Impl.this.__preparedStmtOfDeleteAllAsync.release(acquire);
                }
            }
        });
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public List<ExposureEntity> getAll() {
        j d2 = j.d("SELECT * FROM ExposureEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = b.r.q.b.b(this.__db, d2, false, null);
        try {
            int a0 = i.j.a0(b2, "id");
            int a02 = i.j.a0(b2, "date_millis_since_epoch");
            int a03 = i.j.a0(b2, "received_timestamp_ms");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                ExposureEntity exposureEntity = new ExposureEntity(b2.getLong(a02), b2.getLong(a03));
                exposureEntity.setId(b2.getLong(a0));
                arrayList.add(exposureEntity);
            }
            return arrayList;
        } finally {
            b2.close();
            d2.h();
        }
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public u<List<ExposureEntity>> getAllAsync() {
        final j d2 = j.d("SELECT * FROM ExposureEntity ORDER BY date_millis_since_epoch DESC", 0);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(this.__db, false, new Callable<List<ExposureEntity>>() {
            /* class gov.nc.dhhs.exposurenotification.storage.ExposureDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<ExposureEntity> call() {
                Cursor b2 = b.r.q.b.b(ExposureDao_Impl.this.__db, d2, false, cancellationSignal);
                try {
                    int a0 = i.j.a0(b2, "id");
                    int a02 = i.j.a0(b2, "date_millis_since_epoch");
                    int a03 = i.j.a0(b2, "received_timestamp_ms");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        ExposureEntity exposureEntity = new ExposureEntity(b2.getLong(a02), b2.getLong(a03));
                        exposureEntity.setId(b2.getLong(a0));
                        arrayList.add(exposureEntity);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        }, d2, true, cancellationSignal);
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public LiveData<List<ExposureEntity>> getAllLiveData() {
        final j d2 = j.d("SELECT * FROM ExposureEntity ORDER BY date_millis_since_epoch DESC", 0);
        return this.__db.getInvalidationTracker().b(new String[]{"ExposureEntity"}, false, new Callable<List<ExposureEntity>>() {
            /* class gov.nc.dhhs.exposurenotification.storage.ExposureDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<ExposureEntity> call() {
                Cursor b2 = b.r.q.b.b(ExposureDao_Impl.this.__db, d2, false, null);
                try {
                    int a0 = i.j.a0(b2, "id");
                    int a02 = i.j.a0(b2, "date_millis_since_epoch");
                    int a03 = i.j.a0(b2, "received_timestamp_ms");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        ExposureEntity exposureEntity = new ExposureEntity(b2.getLong(a02), b2.getLong(a03));
                        exposureEntity.setId(b2.getLong(a0));
                        arrayList.add(exposureEntity);
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

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public boolean refreshWithExposureWindows(List<ExposureWindow> list) {
        this.__db.beginTransaction();
        try {
            boolean refreshWithExposureWindows = super.refreshWithExposureWindows(list);
            this.__db.setTransactionSuccessful();
            return refreshWithExposureWindows;
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public void upsert(ExposureEntity exposureEntity) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfExposureEntity.insert(exposureEntity);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // gov.nc.dhhs.exposurenotification.storage.ExposureDao
    public u<Void> upsertAsync(final List<ExposureEntity> list) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.nc.dhhs.exposurenotification.storage.ExposureDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                ExposureDao_Impl.this.__db.beginTransaction();
                try {
                    ExposureDao_Impl.this.__insertionAdapterOfExposureEntity.insert((Iterable) list);
                    ExposureDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    ExposureDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }
}
