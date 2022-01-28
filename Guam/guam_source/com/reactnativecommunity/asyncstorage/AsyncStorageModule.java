package com.reactnativecommunity.asyncstorage;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.AsyncTask;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.horcrux.svg.PathParser;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;

@ReactModule(name = AsyncStorageModule.NAME)
public final class AsyncStorageModule extends ReactContextBaseJavaModule {
    public static final int MAX_SQL_KEYS = 999;
    public static final String NAME = "RNC_AsyncSQLiteDBStorage";
    public final SerialExecutor executor;
    public ReactDatabaseSupplier mReactDatabaseSupplier;
    public boolean mShuttingDown;

    public class SerialExecutor implements Executor {
        public final Executor executor;
        public Runnable mActive;
        public final ArrayDeque<Runnable> mTasks = new ArrayDeque<>();

        public SerialExecutor(AsyncStorageModule asyncStorageModule, Executor executor2) {
            this.executor = executor2;
        }

        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() {
                /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.SerialExecutor.AnonymousClass1 */

                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        public synchronized void scheduleNext() {
            Runnable poll = this.mTasks.poll();
            this.mActive = poll;
            if (poll != null) {
                this.executor.execute(poll);
            }
        }
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext) {
        this(reactApplicationContext, AsyncTask.THREAD_POOL_EXECUTOR);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean ensureDatabase() {
        if (this.mShuttingDown) {
            return false;
        }
        this.mReactDatabaseSupplier.ensureDatabase();
        return true;
    }

    @ReactMethod
    public void clear(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass5 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void[] voidArr) {
                AsyncStorageModule.this.mReactDatabaseSupplier.ensureDatabase();
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.clear();
                    callback.invoke(new Object[0]);
                } catch (Exception e) {
                    FLog.w("ReactNative", e.getMessage(), e);
                    callback.invoke(PathParser.getError(null, e.getMessage()));
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        throw new java.lang.RuntimeException("Clearing and deleting database RKStorage failed");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r0.deleteDatabase() != false) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        com.facebook.common.logging.FLog.d("ReactNative", "Deleted Local Database RKStorage");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0014 */
    public void clearSensitiveData() {
        ReactDatabaseSupplier reactDatabaseSupplier = this.mReactDatabaseSupplier;
        synchronized (reactDatabaseSupplier) {
            reactDatabaseSupplier.clear();
            reactDatabaseSupplier.closeDatabase();
            FLog.d("ReactNative", "Cleaned RKStorage");
        }
    }

    @ReactMethod
    public void getAllKeys(final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass6 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void[] voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(PathParser.getDBError(null), null);
                    return;
                }
                WritableArray createArray = Arguments.createArray();
                Cursor query = AsyncStorageModule.this.mReactDatabaseSupplier.get().query("catalystLocalStorage", new String[]{"key"}, null, null, null, null, null);
                try {
                    if (query.moveToFirst()) {
                        do {
                            createArray.pushString(query.getString(0));
                        } while (query.moveToNext());
                    }
                    query.close();
                    callback.invoke(null, createArray);
                } catch (Exception e) {
                    FLog.w("ReactNative", e.getMessage(), e);
                    callback.invoke(PathParser.getError(null, e.getMessage()), null);
                    query.close();
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        this.mShuttingDown = false;
    }

    @ReactMethod
    public void multiGet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray == null) {
            callback.invoke(PathParser.getInvalidKeyError(null), null);
            return;
        }
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void[] voidArr) {
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(PathParser.getDBError(null), null);
                    return;
                }
                String[] strArr = {"key", "value"};
                HashSet hashSet = new HashSet();
                WritableArray createArray = Arguments.createArray();
                for (int i = 0; i < readableArray.size(); i += 999) {
                    int min = Math.min(readableArray.size() - i, 999);
                    SQLiteDatabase sQLiteDatabase = AsyncStorageModule.this.mReactDatabaseSupplier.get();
                    String buildKeySelection = PathParser.buildKeySelection(min);
                    ReadableArray readableArray = readableArray;
                    String[] strArr2 = new String[min];
                    for (int i2 = 0; i2 < min; i2++) {
                        strArr2[i2] = readableArray.getString(i + i2);
                    }
                    Cursor query = sQLiteDatabase.query("catalystLocalStorage", strArr, buildKeySelection, strArr2, null, null, null);
                    hashSet.clear();
                    try {
                        if (query.getCount() != readableArray.size()) {
                            for (int i3 = i; i3 < i + min; i3++) {
                                hashSet.add(readableArray.getString(i3));
                            }
                        }
                        if (query.moveToFirst()) {
                            do {
                                WritableArray createArray2 = Arguments.createArray();
                                createArray2.pushString(query.getString(0));
                                createArray2.pushString(query.getString(1));
                                createArray.pushArray(createArray2);
                                hashSet.remove(query.getString(0));
                            } while (query.moveToNext());
                        }
                        query.close();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            WritableArray createArray3 = Arguments.createArray();
                            createArray3.pushString((String) it.next());
                            createArray3.pushNull();
                            createArray.pushArray(createArray3);
                        }
                        hashSet.clear();
                    } catch (Exception e) {
                        FLog.w("ReactNative", e.getMessage(), e);
                        callback.invoke(PathParser.getError(null, e.getMessage()), null);
                        query.close();
                        return;
                    } catch (Throwable th) {
                        query.close();
                        throw th;
                    }
                }
                callback.invoke(null, createArray);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiMerge(final ReadableArray readableArray, final Callback callback) {
        new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
            @Override // com.facebook.react.bridge.GuardedAsyncTask
            public void doInBackgroundGuarded(Void[] voidArr) {
                WritableMap writableMap = null;
                if (!AsyncStorageModule.this.ensureDatabase()) {
                    callback.invoke(PathParser.getDBError(null));
                    return;
                }
                try {
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                    for (int i = 0; i < readableArray.size(); i++) {
                        if (readableArray.getArray(i).size() != 2) {
                            PathParser.getInvalidValueError(null);
                            try {
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } catch (Exception e) {
                                FLog.w("ReactNative", e.getMessage(), e);
                                return;
                            }
                        } else if (readableArray.getArray(i).getString(0) == null) {
                            PathParser.getInvalidKeyError(null);
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            return;
                        } else if (readableArray.getArray(i).getString(1) == null) {
                            PathParser.getInvalidValueError(null);
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            return;
                        } else if (!PathParser.mergeImpl(AsyncStorageModule.this.mReactDatabaseSupplier.get(), readableArray.getArray(i).getString(0), readableArray.getArray(i).getString(1))) {
                            PathParser.getDBError(null);
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                            return;
                        }
                    }
                    AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e2) {
                        FLog.w("ReactNative", e2.getMessage(), e2);
                        writableMap = PathParser.getError(null, e2.getMessage());
                    }
                } catch (Exception e3) {
                    FLog.w("ReactNative", e3.getMessage(), e3);
                    writableMap = PathParser.getError(null, e3.getMessage());
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e4) {
                        FLog.w("ReactNative", e4.getMessage(), e4);
                    }
                } catch (Throwable th) {
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                    } catch (Exception e5) {
                        FLog.w("ReactNative", e5.getMessage(), e5);
                        PathParser.getError(null, e5.getMessage());
                    }
                    throw th;
                }
                if (writableMap != null) {
                    callback.invoke(writableMap);
                    return;
                }
                callback.invoke(new Object[0]);
            }
        }.executeOnExecutor(this.executor, new Void[0]);
    }

    @ReactMethod
    public void multiRemove(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass3 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void[] voidArr) {
                    WritableMap writableMap = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(PathParser.getDBError(null));
                        return;
                    }
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        for (int i = 0; i < readableArray.size(); i += 999) {
                            int min = Math.min(readableArray.size() - i, 999);
                            SQLiteDatabase sQLiteDatabase = AsyncStorageModule.this.mReactDatabaseSupplier.get();
                            String buildKeySelection = PathParser.buildKeySelection(min);
                            ReadableArray readableArray = readableArray;
                            String[] strArr = new String[min];
                            for (int i2 = 0; i2 < min; i2++) {
                                strArr[i2] = readableArray.getString(i + i2);
                            }
                            sQLiteDatabase.delete("catalystLocalStorage", buildKeySelection, strArr);
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e) {
                            FLog.w("ReactNative", e.getMessage(), e);
                            writableMap = PathParser.getError(null, e.getMessage());
                        }
                    } catch (Exception e2) {
                        FLog.w("ReactNative", e2.getMessage(), e2);
                        writableMap = PathParser.getError(null, e2.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e3) {
                            FLog.w("ReactNative", e3.getMessage(), e3);
                        }
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e4) {
                            FLog.w("ReactNative", e4.getMessage(), e4);
                            PathParser.getError(null, e4.getMessage());
                        }
                        throw th;
                    }
                    if (writableMap != null) {
                        callback.invoke(writableMap);
                        return;
                    }
                    callback.invoke(new Object[0]);
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @ReactMethod
    public void multiSet(final ReadableArray readableArray, final Callback callback) {
        if (readableArray.size() == 0) {
            callback.invoke(new Object[0]);
        } else {
            new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
                /* class com.reactnativecommunity.asyncstorage.AsyncStorageModule.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
                @Override // com.facebook.react.bridge.GuardedAsyncTask
                public void doInBackgroundGuarded(Void[] voidArr) {
                    WritableMap writableMap = null;
                    if (!AsyncStorageModule.this.ensureDatabase()) {
                        callback.invoke(PathParser.getDBError(null));
                        return;
                    }
                    SQLiteStatement compileStatement = AsyncStorageModule.this.mReactDatabaseSupplier.get().compileStatement("INSERT OR REPLACE INTO catalystLocalStorage VALUES (?, ?);");
                    try {
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().beginTransaction();
                        for (int i = 0; i < readableArray.size(); i++) {
                            if (readableArray.getArray(i).size() != 2) {
                                PathParser.getInvalidValueError(null);
                                try {
                                    AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                    return;
                                } catch (Exception e) {
                                    FLog.w("ReactNative", e.getMessage(), e);
                                    return;
                                }
                            } else if (readableArray.getArray(i).getString(0) == null) {
                                PathParser.getInvalidKeyError(null);
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } else if (readableArray.getArray(i).getString(1) == null) {
                                PathParser.getInvalidValueError(null);
                                AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                                return;
                            } else {
                                compileStatement.clearBindings();
                                compileStatement.bindString(1, readableArray.getArray(i).getString(0));
                                compileStatement.bindString(2, readableArray.getArray(i).getString(1));
                                compileStatement.execute();
                            }
                        }
                        AsyncStorageModule.this.mReactDatabaseSupplier.get().setTransactionSuccessful();
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e2) {
                            FLog.w("ReactNative", e2.getMessage(), e2);
                            writableMap = PathParser.getError(null, e2.getMessage());
                        }
                    } catch (Exception e3) {
                        FLog.w("ReactNative", e3.getMessage(), e3);
                        writableMap = PathParser.getError(null, e3.getMessage());
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e4) {
                            FLog.w("ReactNative", e4.getMessage(), e4);
                        }
                    } catch (Throwable th) {
                        try {
                            AsyncStorageModule.this.mReactDatabaseSupplier.get().endTransaction();
                        } catch (Exception e5) {
                            FLog.w("ReactNative", e5.getMessage(), e5);
                            PathParser.getError(null, e5.getMessage());
                        }
                        throw th;
                    }
                    if (writableMap != null) {
                        callback.invoke(writableMap);
                        return;
                    }
                    callback.invoke(new Object[0]);
                }
            }.executeOnExecutor(this.executor, new Void[0]);
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        this.mShuttingDown = true;
    }

    public AsyncStorageModule(ReactApplicationContext reactApplicationContext, Executor executor2) {
        super(reactApplicationContext);
        this.mShuttingDown = false;
        this.executor = new SerialExecutor(this, executor2);
        if (ReactDatabaseSupplier.sReactDatabaseSupplierInstance == null) {
            ReactDatabaseSupplier.sReactDatabaseSupplierInstance = new ReactDatabaseSupplier(reactApplicationContext.getApplicationContext());
        }
        this.mReactDatabaseSupplier = ReactDatabaseSupplier.sReactDatabaseSupplierInstance;
    }
}
