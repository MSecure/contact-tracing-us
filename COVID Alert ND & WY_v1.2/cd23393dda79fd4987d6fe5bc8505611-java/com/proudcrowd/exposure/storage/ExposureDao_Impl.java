package com.proudcrowd.exposure.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.guava.GuavaRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class ExposureDao_Impl extends ExposureDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<ExposureEntity> __insertionAdapterOfExposureEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecentAsync;
    private final SharedSQLiteStatement __preparedStmtOfMarkExposureAsViewed;

    public ExposureDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfExposureEntity = new EntityInsertionAdapter<ExposureEntity>(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.ExposureDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `ExposureEntity` (`date_timestamp_ms`,`has_viewed`,`created_timestamp_ms`) VALUES (?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, ExposureEntity exposureEntity) {
                supportSQLiteStatement.bindLong(1, exposureEntity.getDateTimestampMs());
                supportSQLiteStatement.bindLong(2, exposureEntity.getHasViewed() ? 1 : 0);
                supportSQLiteStatement.bindLong(3, exposureEntity.getCreatedTimestampMs());
            }
        };
        this.__preparedStmtOfDeleteRecentAsync = new SharedSQLiteStatement(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.ExposureDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM ExposureEntity WHERE date_timestamp_ms < ?";
            }
        };
        this.__preparedStmtOfMarkExposureAsViewed = new SharedSQLiteStatement(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.ExposureDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE ExposureEntity SET has_viewed = 1 WHERE date_timestamp_ms = ?";
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public void insert(List<ExposureEntity> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfExposureEntity.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public boolean tryInsert(List<ExposureEntity> list) {
        this.__db.beginTransaction();
        try {
            boolean tryInsert = super.tryInsert(list);
            this.__db.setTransactionSuccessful();
            return tryInsert;
        } finally {
            this.__db.endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public ListenableFuture<Void> deleteRecentAsync(final long j) {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.ExposureDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                SupportSQLiteStatement acquire = ExposureDao_Impl.this.__preparedStmtOfDeleteRecentAsync.acquire();
                acquire.bindLong(1, j);
                ExposureDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    ExposureDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    ExposureDao_Impl.this.__db.endTransaction();
                    ExposureDao_Impl.this.__preparedStmtOfDeleteRecentAsync.release(acquire);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public void markExposureAsViewed(long j) {
        this.__db.assertNotSuspendingTransaction();
        SupportSQLiteStatement acquire = this.__preparedStmtOfMarkExposureAsViewed.acquire();
        acquire.bindLong(1, j);
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfMarkExposureAsViewed.release(acquire);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public List<ExposureEntity> getAll() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ExposureEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "date_timestamp_ms");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "has_viewed");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(new ExposureEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow2) != 0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public ListenableFuture<List<ExposureEntity>> getAllAsync() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ExposureEntity ORDER BY date_timestamp_ms DESC", 0);
        final CancellationSignal createCancellationSignal = DBUtil.createCancellationSignal();
        return GuavaRoom.createListenableFuture(this.__db, false, new Callable<List<ExposureEntity>>() {
            /* class com.proudcrowd.exposure.storage.ExposureDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<ExposureEntity> call() throws Exception {
                Cursor query = DBUtil.query(ExposureDao_Impl.this.__db, acquire, false, createCancellationSignal);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "date_timestamp_ms");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "has_viewed");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new ExposureEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow2) != 0));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, acquire, true, createCancellationSignal);
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public LiveData<List<ExposureEntity>> getAllLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM ExposureEntity ORDER BY date_timestamp_ms DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"ExposureEntity"}, false, new Callable<List<ExposureEntity>>() {
            /* class com.proudcrowd.exposure.storage.ExposureDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<ExposureEntity> call() throws Exception {
                Cursor query = DBUtil.query(ExposureDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "date_timestamp_ms");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "has_viewed");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new ExposureEntity(query.getLong(columnIndexOrThrow), query.getLong(columnIndexOrThrow3), query.getInt(columnIndexOrThrow2) != 0));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }

            /* access modifiers changed from: protected */
            @Override // java.lang.Object
            public void finalize() {
                acquire.release();
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.ExposureDao
    public int getCount() {
        int i = 0;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(date_timestamp_ms) FROM ExposureEntity", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                i = query.getInt(0);
            }
            return i;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
