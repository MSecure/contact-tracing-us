package io.realm;

import android.content.Context;
import android.os.SystemClock;
import com.android.tools.r8.GeneratedOutlineSupport;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmException;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;
import io.realm.internal.ColumnIndices;
import io.realm.internal.ObjectServerFacade;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.internal.RealmCore;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import io.realm.log.RealmLog;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Realm extends BaseRealm {
    public static final Object defaultConfigurationLock = new Object();
    public final RealmSchema schema;

    public interface Transaction {
        void execute(Realm realm);
    }

    public Realm(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
        this.schema = new ImmutableRealmSchema(this, new ColumnIndices(this.configuration.schemaMediator, osSharedRealm.getSchemaInfo()));
    }

    public static Object getDefaultModule() {
        try {
            Constructor<?> constructor = Class.forName("io.realm.DefaultRealmModule").getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            return constructor.newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (InvocationTargetException e) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not create an instance of ", "io.realm.DefaultRealmModule"), e);
        } catch (InstantiationException e2) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not create an instance of ", "io.realm.DefaultRealmModule"), e2);
        } catch (IllegalAccessException e3) {
            throw new RealmException(GeneratedOutlineSupport.outline8("Could not create an instance of ", "io.realm.DefaultRealmModule"), e3);
        }
    }

    public static synchronized void init(Context context) {
        synchronized (Realm.class) {
            initializeRealm(context, "");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068 A[SYNTHETIC] */
    public static void initializeRealm(Context context, String str) {
        if (BaseRealm.applicationContext != null) {
            return;
        }
        if (context != null) {
            File filesDir = context.getFilesDir();
            if (filesDir != null) {
                if (!filesDir.exists()) {
                    try {
                        filesDir.mkdirs();
                    } catch (SecurityException unused) {
                    }
                }
                RealmCore.loadLibrary(context);
                new RealmConfiguration.Builder(context).build();
                synchronized (defaultConfigurationLock) {
                }
                if (ObjectServerFacade.getSyncFacadeIfPossible() != null) {
                    if (context.getApplicationContext() != null) {
                        BaseRealm.applicationContext = context.getApplicationContext();
                    } else {
                        BaseRealm.applicationContext = context;
                    }
                    OsSharedRealm.initialize(new File(context.getFilesDir(), ".realm.temp"));
                    return;
                }
                throw null;
            }
            if (filesDir == null || !filesDir.exists()) {
                long[] jArr = {1, 2, 5, 10, 16};
                long j = 0;
                int i = -1;
                do {
                    if (context.getFilesDir() != null && context.getFilesDir().exists()) {
                        break;
                    }
                    i++;
                    long j2 = jArr[Math.min(i, 4)];
                    SystemClock.sleep(j2);
                    j += j2;
                } while (j <= 200);
            }
            if (context.getFilesDir() == null || !context.getFilesDir().exists()) {
                StringBuilder outline15 = GeneratedOutlineSupport.outline15("Context.getFilesDir() returns ");
                outline15.append(context.getFilesDir());
                outline15.append(" which is not an existing directory. See https://issuetracker.google.com/issues/36918154");
                throw new IllegalStateException(outline15.toString());
            }
            RealmCore.loadLibrary(context);
            new RealmConfiguration.Builder(context).build();
            synchronized (defaultConfigurationLock) {
            }
        } else {
            throw new IllegalArgumentException("Non-null context required.");
        }
    }

    public <E extends RealmModel> List<E> copyFromRealm(Iterable<E> iterable) {
        ArrayList arrayList = new ArrayList(((Collection) iterable).size());
        HashMap hashMap = new HashMap();
        for (E e : iterable) {
            if (e == null) {
                throw new IllegalArgumentException("Null objects cannot be copied from Realm.");
            } else if (!(e instanceof RealmObjectProxy) || !RealmObject.isValid(e)) {
                throw new IllegalArgumentException("Only valid managed objects can be copied from Realm.");
            } else if (!(e instanceof DynamicRealmObject)) {
                checkIfValid();
                arrayList.add(this.configuration.schemaMediator.createDetachedCopy(e, Integer.MAX_VALUE, hashMap));
            } else {
                throw new IllegalArgumentException("DynamicRealmObject cannot be copied from Realm.");
            }
        }
        return arrayList;
    }

    public final <E extends RealmModel> E copyOrUpdate(E e, boolean z, Map<RealmModel, RealmObjectProxy> map, Set<ImportFlag> set) {
        checkIfValid();
        if (isInTransaction()) {
            try {
                return (E) this.configuration.schemaMediator.copyOrUpdate(this, e, z, map, set);
            } catch (IllegalStateException e2) {
                if (e2.getMessage().startsWith("Attempting to create an object of type")) {
                    throw new RealmPrimaryKeyConstraintException(e2.getMessage());
                }
                throw e2;
            }
        } else {
            throw new IllegalStateException("`copyOrUpdate` can only be called inside a write transaction.");
        }
    }

    public void delete(Class<? extends RealmModel> cls) {
        checkIfValid();
        if (!this.sharedRealm.isPartial()) {
            this.schema.getTable(cls).clear(this.sharedRealm.isPartial());
            return;
        }
        throw new IllegalStateException("This API is not supported by partially synchronized Realms. Either unsubscribe using 'Realm.unsubscribeAsync()' or delete the objects using a query and 'RealmResults.deleteAllFromRealm()'");
    }

    public void executeTransaction(Transaction transaction) {
        checkIfValid();
        this.sharedRealm.beginTransaction();
        try {
            transaction.execute(this);
            checkIfValid();
            this.sharedRealm.commitTransaction();
        } catch (Throwable th) {
            if (isInTransaction()) {
                checkIfValid();
                this.sharedRealm.cancelTransaction();
            } else {
                RealmLog.warn("Could not cancel transaction, not currently in a transaction.", new Object[0]);
            }
            throw th;
        }
    }

    @Override // io.realm.BaseRealm
    public RealmSchema getSchema() {
        return this.schema;
    }

    public void insert(RealmModel realmModel) {
        if (!isInTransaction()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
        } else if (realmModel != null) {
            this.configuration.schemaMediator.insert(this, realmModel, new HashMap());
        } else {
            throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
        }
    }

    public void insertOrUpdate(RealmModel realmModel) {
        if (!isInTransaction()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
        } else if (realmModel != null) {
            this.configuration.schemaMediator.insertOrUpdate(this, realmModel, new HashMap());
        } else {
            throw new IllegalArgumentException("Null object cannot be inserted into Realm.");
        }
    }

    public Realm(RealmCache realmCache, OsSharedRealm.VersionID versionID) {
        super(realmCache, new OsSchemaInfo(realmCache.configuration.schemaMediator.getExpectedObjectSchemaInfoMap().values()), versionID);
        this.schema = new ImmutableRealmSchema(this, new ColumnIndices(this.configuration.schemaMediator, this.sharedRealm.getSchemaInfo()));
        RealmConfiguration realmConfiguration = this.configuration;
        if (realmConfiguration.readOnly) {
            RealmProxyMediator realmProxyMediator = realmConfiguration.schemaMediator;
            for (Class<? extends RealmModel> cls : realmProxyMediator.getModelClasses()) {
                String tableNameForClass = Table.getTableNameForClass(realmProxyMediator.getSimpleClassName(cls));
                if (!this.sharedRealm.hasTable(tableNameForClass)) {
                    this.sharedRealm.close();
                    throw new RealmMigrationNeededException(this.configuration.canonicalPath, String.format(Locale.US, "Cannot open the read only Realm. '%s' is missing.", Table.getClassNameForTable(tableNameForClass)));
                }
            }
        }
    }
}
