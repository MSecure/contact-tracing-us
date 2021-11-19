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

public final class WatermarkUrlDao_Impl extends WatermarkUrlDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<WatermarkUrlEntity> __insertionAdapterOfWatermarkUrlEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteAllAsync;

    public WatermarkUrlDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWatermarkUrlEntity = new EntityInsertionAdapter<WatermarkUrlEntity>(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.WatermarkUrlDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `WatermarkUrlEntity` (`id`,`url_fragment`,`created_timestamp_ms`) VALUES (nullif(?, 0),?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, WatermarkUrlEntity watermarkUrlEntity) {
                supportSQLiteStatement.bindLong(1, watermarkUrlEntity.getId());
                if (watermarkUrlEntity.getUrlFragment() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, watermarkUrlEntity.getUrlFragment());
                }
                supportSQLiteStatement.bindLong(3, watermarkUrlEntity.getCreatedTimestampMs());
            }
        };
        this.__preparedStmtOfDeleteAllAsync = new SharedSQLiteStatement(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.WatermarkUrlDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM WatermarkUrlEntity";
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.WatermarkUrlDao
    public ListenableFuture<Void> upsertAsync(final List<WatermarkUrlEntity> list) {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.WatermarkUrlDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                WatermarkUrlDao_Impl.this.__db.beginTransaction();
                try {
                    WatermarkUrlDao_Impl.this.__insertionAdapterOfWatermarkUrlEntity.insert((Iterable) list);
                    WatermarkUrlDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    WatermarkUrlDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.WatermarkUrlDao
    public ListenableFuture<Void> deleteAllAsync() {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.WatermarkUrlDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                SupportSQLiteStatement acquire = WatermarkUrlDao_Impl.this.__preparedStmtOfDeleteAllAsync.acquire();
                WatermarkUrlDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    WatermarkUrlDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    WatermarkUrlDao_Impl.this.__db.endTransaction();
                    WatermarkUrlDao_Impl.this.__preparedStmtOfDeleteAllAsync.release(acquire);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.WatermarkUrlDao
    public ListenableFuture<List<WatermarkUrlEntity>> getAllAsync() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM WatermarkUrlEntity", 0);
        final CancellationSignal createCancellationSignal = DBUtil.createCancellationSignal();
        return GuavaRoom.createListenableFuture(this.__db, false, new Callable<List<WatermarkUrlEntity>>() {
            /* class com.proudcrowd.exposure.storage.WatermarkUrlDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<WatermarkUrlEntity> call() throws Exception {
                Cursor query = DBUtil.query(WatermarkUrlDao_Impl.this.__db, acquire, false, createCancellationSignal);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "url_fragment");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        WatermarkUrlEntity watermarkUrlEntity = new WatermarkUrlEntity(query.getString(columnIndexOrThrow2));
                        watermarkUrlEntity.setId(query.getLong(columnIndexOrThrow));
                        watermarkUrlEntity.setCreatedTimestampMs(query.getLong(columnIndexOrThrow3));
                        arrayList.add(watermarkUrlEntity);
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, acquire, true, createCancellationSignal);
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.WatermarkUrlDao
    public LiveData<List<WatermarkUrlEntity>> getAllLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM WatermarkUrlEntity ORDER BY created_timestamp_ms DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"WatermarkUrlEntity"}, false, new Callable<List<WatermarkUrlEntity>>() {
            /* class com.proudcrowd.exposure.storage.WatermarkUrlDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<WatermarkUrlEntity> call() throws Exception {
                Cursor query = DBUtil.query(WatermarkUrlDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "url_fragment");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        WatermarkUrlEntity watermarkUrlEntity = new WatermarkUrlEntity(query.getString(columnIndexOrThrow2));
                        watermarkUrlEntity.setId(query.getLong(columnIndexOrThrow));
                        watermarkUrlEntity.setCreatedTimestampMs(query.getLong(columnIndexOrThrow3));
                        arrayList.add(watermarkUrlEntity);
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
}
