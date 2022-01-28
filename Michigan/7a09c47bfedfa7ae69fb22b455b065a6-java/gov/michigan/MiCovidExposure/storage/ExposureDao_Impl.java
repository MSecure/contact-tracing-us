package gov.michigan.MiCovidExposure.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
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
            /* class gov.michigan.MiCovidExposure.storage.ExposureDao_Impl.AnonymousClass1 */

            public void bind(f fVar, ExposureEntity exposureEntity) {
                ((e) fVar).f2630b.bindLong(1, exposureEntity.getId());
                e eVar = (e) fVar;
                eVar.f2630b.bindLong(2, exposureEntity.getDateMillisSinceEpoch());
                eVar.f2630b.bindLong(3, exposureEntity.getReceivedTimestampMs());
            }

            @Override // b.s.m
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ExposureEntity` (`id`,`date_millis_since_epoch`,`received_timestamp_ms`) VALUES (nullif(?, 0),?,?)";
            }
        };
        this.__preparedStmtOfDeleteAllAsync = new m(hVar) {
            /* class gov.michigan.MiCovidExposure.storage.ExposureDao_Impl.AnonymousClass2 */

            @Override // b.s.m
            public String createQuery() {
                return "DELETE FROM ExposureEntity";
            }
        };
    }

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
    public u<Void> deleteAllAsync() {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.ExposureDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() {
                b.w.a.g.f acquire = ExposureDao_Impl.this.__preparedStmtOfDeleteAllAsync.acquire();
                ExposureDao_Impl.this.__db.beginTransaction();
                acquire = (b.w.a.g.f) acquire;
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

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
    public List<ExposureEntity> getAll() {
        j c2 = j.c("SELECT * FROM ExposureEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = b.s.q.b.b(this.__db, c2, false, null);
        try {
            int y = i.j.y(b2, "id");
            int y2 = i.j.y(b2, "date_millis_since_epoch");
            int y3 = i.j.y(b2, "received_timestamp_ms");
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                ExposureEntity exposureEntity = new ExposureEntity(b2.getLong(y2), b2.getLong(y3));
                exposureEntity.setId(b2.getLong(y));
                arrayList.add(exposureEntity);
            }
            return arrayList;
        } finally {
            b2.close();
            c2.g();
        }
    }

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
    public u<List<ExposureEntity>> getAllAsync() {
        final j c2 = j.c("SELECT * FROM ExposureEntity ORDER BY date_millis_since_epoch DESC", 0);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        return d.b(this.__db, false, new Callable<List<ExposureEntity>>() {
            /* class gov.michigan.MiCovidExposure.storage.ExposureDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<ExposureEntity> call() {
                Cursor b2 = b.s.q.b.b(ExposureDao_Impl.this.__db, c2, false, cancellationSignal);
                try {
                    int y = i.j.y(b2, "id");
                    int y2 = i.j.y(b2, "date_millis_since_epoch");
                    int y3 = i.j.y(b2, "received_timestamp_ms");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        ExposureEntity exposureEntity = new ExposureEntity(b2.getLong(y2), b2.getLong(y3));
                        exposureEntity.setId(b2.getLong(y));
                        arrayList.add(exposureEntity);
                    }
                    return arrayList;
                } finally {
                    b2.close();
                }
            }
        }, c2, true, cancellationSignal);
    }

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
    public LiveData<List<ExposureEntity>> getAllLiveData() {
        final j c2 = j.c("SELECT * FROM ExposureEntity ORDER BY date_millis_since_epoch DESC", 0);
        return this.__db.getInvalidationTracker().b(new String[]{"ExposureEntity"}, false, new Callable<List<ExposureEntity>>() {
            /* class gov.michigan.MiCovidExposure.storage.ExposureDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<ExposureEntity> call() {
                Cursor b2 = b.s.q.b.b(ExposureDao_Impl.this.__db, c2, false, null);
                try {
                    int y = i.j.y(b2, "id");
                    int y2 = i.j.y(b2, "date_millis_since_epoch");
                    int y3 = i.j.y(b2, "received_timestamp_ms");
                    ArrayList arrayList = new ArrayList(b2.getCount());
                    while (b2.moveToNext()) {
                        ExposureEntity exposureEntity = new ExposureEntity(b2.getLong(y2), b2.getLong(y3));
                        exposureEntity.setId(b2.getLong(y));
                        arrayList.add(exposureEntity);
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

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
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

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
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

    @Override // gov.michigan.MiCovidExposure.storage.ExposureDao
    public u<Void> upsertAsync(final List<ExposureEntity> list) {
        return d.a(this.__db, true, new Callable<Void>() {
            /* class gov.michigan.MiCovidExposure.storage.ExposureDao_Impl.AnonymousClass3 */

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
