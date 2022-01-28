package com.proudcrowd.exposure.storage;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.guava.GuavaRoom;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class PartyDao_Impl extends PartyDao {
    private final RoomDatabase __db;
    private final EntityInsertionAdapter<PartyEntity> __insertionAdapterOfPartyEntity;

    public PartyDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPartyEntity = new EntityInsertionAdapter<PartyEntity>(roomDatabase) {
            /* class com.proudcrowd.exposure.storage.PartyDao_Impl.AnonymousClass1 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `PartyEntity` (`id`,`name`,`image_url`,`constituent_name`,`instructions`) VALUES (?,?,?,?,?)";
            }

            public void bind(SupportSQLiteStatement supportSQLiteStatement, PartyEntity partyEntity) {
                supportSQLiteStatement.bindLong(1, (long) partyEntity.getId());
                if (partyEntity.getName() == null) {
                    supportSQLiteStatement.bindNull(2);
                } else {
                    supportSQLiteStatement.bindString(2, partyEntity.getName());
                }
                if (partyEntity.getImageUrl() == null) {
                    supportSQLiteStatement.bindNull(3);
                } else {
                    supportSQLiteStatement.bindString(3, partyEntity.getImageUrl());
                }
                if (partyEntity.getConstituentName() == null) {
                    supportSQLiteStatement.bindNull(4);
                } else {
                    supportSQLiteStatement.bindString(4, partyEntity.getConstituentName());
                }
                String fromInstructions = ExposureDatabaseConverters.fromInstructions(partyEntity.getInstructions());
                if (fromInstructions == null) {
                    supportSQLiteStatement.bindNull(5);
                } else {
                    supportSQLiteStatement.bindString(5, fromInstructions);
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.PartyDao
    public ListenableFuture<Void> upsertAsync(final List<PartyEntity> list) {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.PartyDao_Impl.AnonymousClass2 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                PartyDao_Impl.this.__db.beginTransaction();
                try {
                    PartyDao_Impl.this.__insertionAdapterOfPartyEntity.insert((Iterable) list);
                    PartyDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PartyDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.PartyDao
    public ListenableFuture<List<PartyEntity>> getAllAsync() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM PartyEntity", 0);
        final CancellationSignal createCancellationSignal = DBUtil.createCancellationSignal();
        return GuavaRoom.createListenableFuture(this.__db, false, new Callable<List<PartyEntity>>() {
            /* class com.proudcrowd.exposure.storage.PartyDao_Impl.AnonymousClass3 */

            @Override // java.util.concurrent.Callable
            public List<PartyEntity> call() throws Exception {
                Cursor query = DBUtil.query(PartyDao_Impl.this.__db, acquire, false, createCancellationSignal);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AppMeasurementSdk.ConditionalUserProperty.NAME);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "image_url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "constituent_name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "instructions");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new PartyEntity(query.getInt(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow3), ExposureDatabaseConverters.toInstructions(query.getString(columnIndexOrThrow5))));
                    }
                    return arrayList;
                } finally {
                    query.close();
                }
            }
        }, acquire, true, createCancellationSignal);
    }

    /* access modifiers changed from: package-private */
    @Override // com.proudcrowd.exposure.storage.PartyDao
    public LiveData<List<PartyEntity>> getAllLiveData() {
        final RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT * FROM PartyEntity ORDER BY id", 0);
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"PartyEntity"}, false, new Callable<List<PartyEntity>>() {
            /* class com.proudcrowd.exposure.storage.PartyDao_Impl.AnonymousClass4 */

            @Override // java.util.concurrent.Callable
            public List<PartyEntity> call() throws Exception {
                Cursor query = DBUtil.query(PartyDao_Impl.this.__db, acquire, false, null);
                try {
                    int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(query, "id");
                    int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(query, AppMeasurementSdk.ConditionalUserProperty.NAME);
                    int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(query, "image_url");
                    int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(query, "constituent_name");
                    int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(query, "instructions");
                    ArrayList arrayList = new ArrayList(query.getCount());
                    while (query.moveToNext()) {
                        arrayList.add(new PartyEntity(query.getInt(columnIndexOrThrow), query.getString(columnIndexOrThrow2), query.getString(columnIndexOrThrow4), query.getString(columnIndexOrThrow3), ExposureDatabaseConverters.toInstructions(query.getString(columnIndexOrThrow5))));
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
    @Override // com.proudcrowd.exposure.storage.PartyDao
    public ListenableFuture<Void> deleteAllExceptAsync(final List<Integer> list) {
        return GuavaRoom.createListenableFuture(this.__db, true, (Callable) new Callable<Void>() {
            /* class com.proudcrowd.exposure.storage.PartyDao_Impl.AnonymousClass5 */

            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                StringBuilder newStringBuilder = StringUtil.newStringBuilder();
                newStringBuilder.append("DELETE FROM PartyEntity WHERE id NOT IN (");
                StringUtil.appendPlaceholders(newStringBuilder, list.size());
                newStringBuilder.append(")");
                SupportSQLiteStatement compileStatement = PartyDao_Impl.this.__db.compileStatement(newStringBuilder.toString());
                int i = 1;
                for (Integer num : list) {
                    if (num == null) {
                        compileStatement.bindNull(i);
                    } else {
                        compileStatement.bindLong(i, (long) num.intValue());
                    }
                    i++;
                }
                PartyDao_Impl.this.__db.beginTransaction();
                try {
                    compileStatement.executeUpdateDelete();
                    PartyDao_Impl.this.__db.setTransactionSuccessful();
                    return null;
                } finally {
                    PartyDao_Impl.this.__db.endTransaction();
                }
            }
        });
    }
}
