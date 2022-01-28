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

public final class KeyScanDao_Impl extends KeyScanDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<KeyScanEntity> __insertionAdapterOfKeyScanEntity;
    private final SharedSQLiteStatement __preparedStmtOfDeleteRecentAsync;

    public KeyScanDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfKeyScanEntity = new EntityInsertionAdapter<KeyScanEntity>(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.KeyScanDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `KeyScanEntity` (`id`,`created_timestamp_ms`,`is_success`,`error_message`) VALUES (nullif(?, 0),?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, KeyScanEntity keyScanEntity) {
                supportSQLiteStatement.bindLong(1, keyScanEntity.getId());
                supportSQLiteStatement.bindLong(2, keyScanEntity.getCreatedTimestampMs());
                supportSQLiteStatement.bindLong(3, keyScanEntity.getSucceeded() ? 1 : 0);
                if (keyScanEntity.getErrorMessage() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, keyScanEntity.getErrorMessage());
                }
            }
        };
        this.__preparedStmtOfDeleteRecentAsync = new SharedSQLiteStatement(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.KeyScanDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM KeyScanEntity WHERE created_timestamp_ms < ?";
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.KeyScanDao
    public ListenableFuture<Void> upsertAsync(final KeyScanEntity keyScanEntity) {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.KeyScanDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                KeyScanDao_Impl.this.__db.beginTransaction();
                try {
                    KeyScanDao_Impl.this.__insertionAdapterOfKeyScanEntity.insert(keyScanEntity);
                    KeyScanDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    KeyScanDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.KeyScanDao
    public ListenableFuture<Void> deleteRecentAsync(final long j) {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.KeyScanDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                SupportSQLiteStatement acquire = KeyScanDao_Impl.this.__preparedStmtOfDeleteRecentAsync.acquire();
                acquire.bindLong(1, j);
                KeyScanDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.executeUpdateDelete();
                    KeyScanDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    KeyScanDao_Impl.this.__db.endTransaction();
                    KeyScanDao_Impl.this.__preparedStmtOfDeleteRecentAsync.release(acquire);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.KeyScanDao
    public ListenableFuture<List<KeyScanEntity>> getAllAsync() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM KeyScanEntity ORDER BY created_timestamp_ms DESC", 0);
        final CancellationSignal createCancellationSignal = DBUtil.createCancellationSignal();
        return GuavaRoom.createListenableFuture(this.__db, false, new Callable<List<KeyScanEntity>>() {
            /* class com.proudcrowd.exposure.storage.KeyScanDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public List<KeyScanEntity> call() throws Exception {
                Cursor query = DBUtil.query(KeyScanDao_Impl.this.__db, acquire, false, createCancellationSignal);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "is_success");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "error_message");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        KeyScanEntity keyScanEntity = new KeyScanEntity(query.getInt(columnIndexOrThrow3) != 0, query.getString(columnIndexOrThrow4));
                        keyScanEntity.id = query.getLong(columnIndexOrThrow);
                        keyScanEntity.setCreatedTimestampMs(query.getLong(columnIndexOrThrow2));
                        arrayList.add(keyScanEntity);
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, acquire, true, createCancellationSignal);
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.KeyScanDao
    public LiveData<List<KeyScanEntity>> getAllLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM KeyScanEntity ORDER BY created_timestamp_ms DESC", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"KeyScanEntity"}, false, new Callable<List<KeyScanEntity>>() {
            /* class com.proudcrowd.exposure.storage.KeyScanDao_Impl.AnonymousClass6 */

            @Override // java.util.concurrent.Callable
            public List<KeyScanEntity> call() throws Exception {
                Cursor query = DBUtil.query(KeyScanDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, "created_timestamp_ms");
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "is_success");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "error_message");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        KeyScanEntity keyScanEntity = new KeyScanEntity(query.getInt(columnIndexOrThrow3) != 0, query.getString(columnIndexOrThrow4));
                        keyScanEntity.id = query.getLong(columnIndexOrThrow);
                        keyScanEntity.setCreatedTimestampMs(query.getLong(columnIndexOrThrow2));
                        arrayList.add(keyScanEntity);
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
