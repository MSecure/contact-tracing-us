package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;

public final class PreferenceDao_Impl implements PreferenceDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<Preference> __insertionAdapterOfPreference;

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfPreference = new EntityInsertionAdapter<Preference>(this, roomDatabase) {
            /* class androidx.work.impl.model.PreferenceDao_Impl.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.framework.FrameworkSQLiteStatement, java.lang.Object] */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, Preference preference) {
                Preference preference2 = preference;
                String str = preference2.mKey;
                if (str == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(1);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(1, str);
                }
                Long l = preference2.mValue;
                if (l == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(2);
                    return;
                }
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(2, l.longValue());
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
            }
        };
    }

    public Long getLongValue(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT long_value FROM Preference where `key`=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Long l = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                if (!query.isNull(0)) {
                    l = Long.valueOf(query.getLong(0));
                }
            }
            return l;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public void insertPreference(Preference preference) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPreference.insert(preference);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}
