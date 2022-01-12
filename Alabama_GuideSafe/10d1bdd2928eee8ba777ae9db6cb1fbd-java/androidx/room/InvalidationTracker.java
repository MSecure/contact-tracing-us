package androidx.room;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InvalidationTracker {
    public static final String[] TRIGGERS = {"UPDATE", "DELETE", "INSERT"};
    public volatile FrameworkSQLiteStatement mCleanupStatement;
    public final RoomDatabase mDatabase;
    public volatile boolean mInitialized = false;
    public ObservedTableTracker mObservedTableTracker;
    @SuppressLint({"RestrictedApi"})
    public final SafeIterableMap<Observer, ObserverWrapper> mObserverMap = new SafeIterableMap<>();
    public AtomicBoolean mPendingRefresh = new AtomicBoolean(false);
    public Runnable mRefreshRunnable = new Runnable() {
        /* class androidx.room.InvalidationTracker.AnonymousClass1 */

        /* JADX INFO: finally extract failed */
        public final Set<Integer> checkUpdatedTable() {
            HashSet hashSet = new HashSet();
            Cursor query = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"), null);
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
            }
            return hashSet;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r5v6, resolved type: android.database.sqlite.SQLiteDatabase */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:74:? A[ADDED_TO_REGION, ORIG_RETURN, RETURN, SYNTHETIC] */
        public void run() {
            Set<Integer> set;
            Set<Integer> set2;
            Throwable e;
            Throwable th;
            ReentrantReadWriteLock.ReadLock readLock = InvalidationTracker.this.mDatabase.mCloseLock.readLock();
            try {
                readLock.lock();
                if (!InvalidationTracker.this.ensureInitialization()) {
                    readLock.unlock();
                } else if (!InvalidationTracker.this.mPendingRefresh.compareAndSet(true, false)) {
                    readLock.unlock();
                } else if (InvalidationTracker.this.mDatabase.inTransaction()) {
                    readLock.unlock();
                } else {
                    if (InvalidationTracker.this.mDatabase.mWriteAheadLoggingEnabled) {
                        SupportSQLiteDatabase writableDatabase = InvalidationTracker.this.mDatabase.mOpenHelper.getWritableDatabase();
                        SQLiteDatabase sQLiteDatabase = ((FrameworkSQLiteDatabase) writableDatabase).mDelegate;
                        sQLiteDatabase.beginTransaction();
                        try {
                            Set<Integer> checkUpdatedTable = checkUpdatedTable();
                            try {
                                ((FrameworkSQLiteDatabase) writableDatabase).mDelegate.setTransactionSuccessful();
                            } catch (Throwable th2) {
                                th = th2;
                                ((FrameworkSQLiteDatabase) writableDatabase).mDelegate.endTransaction();
                                throw th;
                            }
                            try {
                                ((FrameworkSQLiteDatabase) writableDatabase).mDelegate.endTransaction();
                                set = checkUpdatedTable;
                            } catch (SQLiteException | IllegalStateException e2) {
                                e = e2;
                                set2 = sQLiteDatabase;
                                try {
                                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                                    set = set2;
                                    readLock.unlock();
                                    if (set == null) {
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    readLock.unlock();
                                    throw th3;
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            ((FrameworkSQLiteDatabase) writableDatabase).mDelegate.endTransaction();
                            throw th;
                        }
                    } else {
                        set = checkUpdatedTable();
                    }
                    readLock.unlock();
                    if (set == null && !set.isEmpty()) {
                        synchronized (InvalidationTracker.this.mObserverMap) {
                            Iterator<Map.Entry<Observer, ObserverWrapper>> it = InvalidationTracker.this.mObserverMap.iterator();
                            while (true) {
                                SafeIterableMap.ListIterator listIterator = (SafeIterableMap.ListIterator) it;
                                if (listIterator.hasNext()) {
                                    ObserverWrapper observerWrapper = (ObserverWrapper) ((Map.Entry) listIterator.next()).getValue();
                                    int length = observerWrapper.mTableIds.length;
                                    Set<String> set3 = null;
                                    for (int i = 0; i < length; i++) {
                                        if (set.contains(Integer.valueOf(observerWrapper.mTableIds[i]))) {
                                            if (length == 1) {
                                                set3 = observerWrapper.mSingleTableSet;
                                            } else {
                                                if (set3 == null) {
                                                    set3 = new HashSet<>(length);
                                                }
                                                set3.add(observerWrapper.mTableNames[i]);
                                            }
                                        }
                                    }
                                    if (set3 != null) {
                                        observerWrapper.mObserver.onInvalidated(set3);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SQLiteException | IllegalStateException e3) {
                e = e3;
                set2 = null;
                Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                set = set2;
                readLock.unlock();
                if (set == null) {
                }
            }
        }
    };
    public final HashMap<String, Integer> mTableIdLookup;
    public final String[] mTableNames;
    public Map<String, Set<String>> mViewTables;

    public static class ObservedTableTracker {
        public boolean mNeedsSync;
        public boolean mPendingSync;
        public final long[] mTableObservers;
        public final int[] mTriggerStateChanges;
        public final boolean[] mTriggerStates;

        public ObservedTableTracker(int i) {
            long[] jArr = new long[i];
            this.mTableObservers = jArr;
            this.mTriggerStates = new boolean[i];
            this.mTriggerStateChanges = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(this.mTriggerStates, false);
        }

        public int[] getTablesToSync() {
            synchronized (this) {
                if (this.mNeedsSync) {
                    if (!this.mPendingSync) {
                        int length = this.mTableObservers.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.mTableObservers[i] > 0;
                                if (z != this.mTriggerStates[i]) {
                                    int[] iArr = this.mTriggerStateChanges;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.mTriggerStateChanges[i] = 0;
                                }
                                this.mTriggerStates[i] = z;
                                i++;
                            } else {
                                this.mPendingSync = true;
                                this.mNeedsSync = false;
                                return this.mTriggerStateChanges;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    public static abstract class Observer {
        public final String[] mTables;

        public Observer(String[] strArr) {
            this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract void onInvalidated(Set<String> set);
    }

    public static class ObserverWrapper {
        public final Observer mObserver;
        public final Set<String> mSingleTableSet;
        public final int[] mTableIds;
        public final String[] mTableNames;

        public ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            this.mObserver = observer;
            this.mTableIds = iArr;
            this.mTableNames = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(this.mTableNames[0]);
                this.mSingleTableSet = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.mSingleTableSet = null;
        }
    }

    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new ObservedTableTracker(strArr.length);
        this.mTableIdLookup = new HashMap<>();
        this.mViewTables = map2;
        Collections.newSetFromMap(new IdentityHashMap());
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i = 0; i < length; i++) {
            String lowerCase = strArr[i].toLowerCase(Locale.US);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i));
            String str = map.get(strArr[i]);
            if (str != null) {
                this.mTableNames[i] = str.toLowerCase(Locale.US);
            } else {
                this.mTableNames[i] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String lowerCase2 = entry.getValue().toLowerCase(Locale.US);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(Locale.US);
                HashMap<String, Integer> hashMap = this.mTableIdLookup;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void addObserver(Observer observer) {
        ObserverWrapper putIfAbsent;
        boolean z;
        String[] strArr = observer.mTables;
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        String[] strArr2 = (String[]) hashSet.toArray(new String[hashSet.size()]);
        int length = strArr2.length;
        int[] iArr = new int[length];
        int length2 = strArr2.length;
        for (int i = 0; i < length2; i++) {
            Integer num = this.mTableIdLookup.get(strArr2[i].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i] = num.intValue();
            } else {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("There is no table with name ");
                outline17.append(strArr2[i]);
                throw new IllegalArgumentException(outline17.toString());
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, strArr2);
        synchronized (this.mObserverMap) {
            putIfAbsent = this.mObserverMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null) {
            ObservedTableTracker observedTableTracker = this.mObservedTableTracker;
            synchronized (observedTableTracker) {
                z = false;
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = iArr[i2];
                    long j = observedTableTracker.mTableObservers[i3];
                    observedTableTracker.mTableObservers[i3] = 1 + j;
                    if (j == 0) {
                        observedTableTracker.mNeedsSync = true;
                        z = true;
                    }
                }
            }
            if (z) {
                syncTriggers();
            }
        }
    }

    public boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.mOpenHelper.getWritableDatabase();
        }
        if (this.mInitialized) {
            return true;
        }
        Log.e("ROOM", "database is not initialized even though it is open");
        return false;
    }

    @SuppressLint({"RestrictedApi"})
    public void removeObserver(Observer observer) {
        ObserverWrapper remove;
        boolean z;
        synchronized (this.mObserverMap) {
            remove = this.mObserverMap.remove(observer);
        }
        if (remove != null) {
            ObservedTableTracker observedTableTracker = this.mObservedTableTracker;
            int[] iArr = remove.mTableIds;
            synchronized (observedTableTracker) {
                z = false;
                for (int i : iArr) {
                    long j = observedTableTracker.mTableObservers[i];
                    observedTableTracker.mTableObservers[i] = j - 1;
                    if (j == 1) {
                        observedTableTracker.mNeedsSync = true;
                        z = true;
                    }
                }
            }
            if (z) {
                syncTriggers();
            }
        }
    }

    public final void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        FrameworkSQLiteDatabase frameworkSQLiteDatabase = (FrameworkSQLiteDatabase) supportSQLiteDatabase;
        frameworkSQLiteDatabase.mDelegate.execSQL(GeneratedOutlineSupport.outline6("INSERT OR IGNORE INTO room_table_modification_log VALUES(", i, ", 0)"));
        String str = this.mTableNames[i];
        StringBuilder sb = new StringBuilder();
        String[] strArr = TRIGGERS;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            sb.append(" AFTER ");
            sb.append(str2);
            sb.append(" ON `");
            sb.append(str);
            sb.append("` BEGIN UPDATE ");
            sb.append("room_table_modification_log");
            sb.append(" SET ");
            sb.append("invalidated");
            sb.append(" = 1");
            sb.append(" WHERE ");
            sb.append("table_id");
            sb.append(" = ");
            sb.append(i);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            frameworkSQLiteDatabase.mDelegate.execSQL(sb.toString());
        }
    }

    public final void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i) {
        String str = this.mTableNames[i];
        StringBuilder sb = new StringBuilder();
        String[] strArr = TRIGGERS;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append("`");
            ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.execSQL(sb.toString());
        }
    }

    public void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.inTransaction()) {
            while (true) {
                try {
                    ReentrantReadWriteLock.ReadLock readLock = this.mDatabase.mCloseLock.readLock();
                    readLock.lock();
                    try {
                        int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                        if (tablesToSync == null) {
                            readLock.unlock();
                            return;
                        }
                        int length = tablesToSync.length;
                        ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.beginTransaction();
                        for (int i = 0; i < length; i++) {
                            try {
                                int i2 = tablesToSync[i];
                                if (i2 == 1) {
                                    startTrackingTable(supportSQLiteDatabase, i);
                                } else if (i2 == 2) {
                                    stopTrackingTable(supportSQLiteDatabase, i);
                                }
                            } catch (Throwable th) {
                                ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.endTransaction();
                                throw th;
                            }
                        }
                        ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.setTransactionSuccessful();
                        ((FrameworkSQLiteDatabase) supportSQLiteDatabase).mDelegate.endTransaction();
                        ObservedTableTracker observedTableTracker = this.mObservedTableTracker;
                        synchronized (observedTableTracker) {
                            observedTableTracker.mPendingSync = false;
                        }
                    } finally {
                        readLock.unlock();
                    }
                } catch (SQLiteException | IllegalStateException e) {
                    Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e);
                    return;
                }
            }
        }
    }

    public void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.mOpenHelper.getWritableDatabase());
        }
    }
}
