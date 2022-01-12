package androidx.work.impl.model;

import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;

public final class WorkNameDao_Impl implements WorkNameDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<WorkName> __insertionAdapterOfWorkName;

    public WorkNameDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkName = new EntityInsertionAdapter<WorkName>(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkNameDao_Impl.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.framework.FrameworkSQLiteStatement, java.lang.Object] */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, WorkName workName) {
                WorkName workName2 = workName;
                String str = workName2.name;
                if (str == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(1);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(1, str);
                }
                String str2 = workName2.workSpecId;
                if (str2 == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(2);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(2, str2);
                }
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkName` (`name`,`work_spec_id`) VALUES (?,?)";
            }
        };
    }
}
