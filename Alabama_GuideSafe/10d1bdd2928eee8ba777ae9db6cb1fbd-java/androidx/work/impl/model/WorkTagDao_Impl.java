package androidx.work.impl.model;

import android.database.Cursor;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import java.util.ArrayList;
import java.util.List;

public final class WorkTagDao_Impl implements WorkTagDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<WorkTag> __insertionAdapterOfWorkTag;

    public WorkTagDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkTag = new EntityInsertionAdapter<WorkTag>(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkTagDao_Impl.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.framework.FrameworkSQLiteStatement, java.lang.Object] */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, WorkTag workTag) {
                WorkTag workTag2 = workTag;
                String str = workTag2.tag;
                if (str == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(1);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(1, str);
                }
                String str2 = workTag2.workSpecId;
                if (str2 == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(2);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(2, str2);
                }
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkTag` (`tag`,`work_spec_id`) VALUES (?,?)";
            }
        };
    }

    public List<String> getTagsForWorkSpecId(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                arrayList.add(query.getString(0));
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }
}
