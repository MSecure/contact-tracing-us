package androidx.room;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {
    public DatabaseConfiguration mConfiguration;
    public final Delegate mDelegate;
    public final String mIdentityHash;
    public final String mLegacyHash;

    public static abstract class Delegate {
        public final int version;

        public Delegate(int i) {
            this.version = i;
        }

        public abstract void createAllTables(SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract ValidationResult onValidateSchema(SupportSQLiteDatabase supportSQLiteDatabase);
    }

    public static class ValidationResult {
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z, String str) {
            this.isValid = z;
            this.expectedFoundMsg = str;
        }
    }

    public RoomOpenHelper(DatabaseConfiguration databaseConfiguration, Delegate delegate, String str, String str2) {
        super(delegate.version);
        this.mConfiguration = databaseConfiguration;
        this.mDelegate = delegate;
        this.mIdentityHash = str;
        this.mLegacyHash = str2;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0076, code lost:
        r0 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010f  */
    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        List<Migration> list;
        Set<Integer> set;
        boolean z;
        boolean z2;
        DatabaseConfiguration databaseConfiguration = this.mConfiguration;
        boolean z3 = true;
        if (databaseConfiguration != null) {
            RoomDatabase.MigrationContainer migrationContainer = databaseConfiguration.migrationContainer;
            if (migrationContainer != null) {
                if (i == i2) {
                    list = Collections.emptyList();
                } else {
                    boolean z4 = i2 > i;
                    ArrayList arrayList = new ArrayList();
                    int i3 = i;
                    while (true) {
                        if (z4) {
                            if (i3 >= i2) {
                                break;
                            }
                        } else if (i3 <= i2) {
                            break;
                        }
                        TreeMap<Integer, Migration> treeMap = migrationContainer.mMigrations.get(Integer.valueOf(i3));
                        if (treeMap == null) {
                            break;
                        }
                        if (z4) {
                            set = treeMap.descendingKeySet();
                        } else {
                            set = treeMap.keySet();
                        }
                        Iterator<Integer> it = set.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                continue;
                                break;
                            }
                            int intValue = it.next().intValue();
                            if (!z4 ? intValue < i2 || intValue >= i3 : intValue > i2 || intValue <= i3) {
                                z2 = false;
                                continue;
                            } else {
                                z2 = true;
                                continue;
                            }
                            if (z2) {
                                arrayList.add(treeMap.get(Integer.valueOf(intValue)));
                                z = true;
                                i3 = intValue;
                                continue;
                                break;
                            }
                        }
                        if (!z) {
                            break;
                        }
                    }
                    list = null;
                }
                if (list != null) {
                    if (((WorkDatabase_Impl.AnonymousClass1) this.mDelegate) != null) {
                        ArrayList arrayList2 = new ArrayList();
                        FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
                        Cursor query = frameworkSQLiteDatabase.query(new SimpleSQLiteQuery("SELECT name FROM sqlite_master WHERE type = 'trigger'"));
                        while (query.moveToNext()) {
                            try {
                                arrayList2.add(query.getString(0));
                            } catch (Throwable th) {
                                query.close();
                                throw th;
                            }
                        }
                        query.close();
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            String str = (String) it2.next();
                            if (str.startsWith("room_fts_content_sync_")) {
                                frameworkSQLiteDatabase.mDelegate.execSQL(GeneratedOutlineSupport.outline10("DROP TRIGGER IF EXISTS ", str));
                            }
                        }
                        for (Migration migration : list) {
                            migration.migrate(supportSQLiteDatabase);
                        }
                        ValidationResult onValidateSchema = this.mDelegate.onValidateSchema(supportSQLiteDatabase);
                        if (!onValidateSchema.isValid) {
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Migration didn't properly handle: ");
                            outline17.append(onValidateSchema.expectedFoundMsg);
                            throw new IllegalStateException(outline17.toString());
                        } else if (((WorkDatabase_Impl.AnonymousClass1) this.mDelegate) != null) {
                            updateIdentity(supportSQLiteDatabase);
                            if (z3) {
                                DatabaseConfiguration databaseConfiguration2 = this.mConfiguration;
                                if (databaseConfiguration2 == null || databaseConfiguration2.isMigrationRequired(i, i2)) {
                                    throw new IllegalStateException("A migration from " + i + " to " + i2 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
                                }
                                WorkDatabase_Impl.AnonymousClass1 r13 = (WorkDatabase_Impl.AnonymousClass1) this.mDelegate;
                                if (r13 != null) {
                                    FrameworkSQLiteDatabase frameworkSQLiteDatabase2 = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `Dependency`");
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `WorkSpec`");
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `WorkTag`");
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `SystemIdInfo`");
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `WorkName`");
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `WorkProgress`");
                                    frameworkSQLiteDatabase2.mDelegate.execSQL("DROP TABLE IF EXISTS `Preference`");
                                    if (WorkDatabase_Impl.this.mCallbacks != null) {
                                        int size = WorkDatabase_Impl.this.mCallbacks.size();
                                        for (int i4 = 0; i4 < size; i4++) {
                                            if (WorkDatabase_Impl.this.mCallbacks.get(i4) == null) {
                                                throw null;
                                            }
                                        }
                                    }
                                    this.mDelegate.createAllTables(supportSQLiteDatabase);
                                    return;
                                }
                                throw null;
                            }
                            return;
                        } else {
                            throw null;
                        }
                    } else {
                        throw null;
                    }
                }
            } else {
                throw null;
            }
        }
        z3 = false;
        if (z3) {
        }
    }

    public final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
        frameworkSQLiteDatabase.mDelegate.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        frameworkSQLiteDatabase.mDelegate.execSQL(GeneratedOutlineSupport.outline11("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '", this.mIdentityHash, "')"));
    }
}
