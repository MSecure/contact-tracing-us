package androidx.work.impl.model;

import android.database.Cursor;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.framework.FrameworkSQLiteProgram;
import androidx.sqlite.db.framework.FrameworkSQLiteStatement;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.ContentUriTriggers;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.WorkInfo$State;
import androidx.work.impl.model.WorkSpec;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class WorkSpecDao_Impl implements WorkSpecDao {
    public final RoomDatabase __db;
    public final EntityInsertionAdapter<WorkSpec> __insertionAdapterOfWorkSpec;
    public final SharedSQLiteStatement __preparedStmtOfDelete;
    public final SharedSQLiteStatement __preparedStmtOfIncrementWorkSpecRunAttemptCount;
    public final SharedSQLiteStatement __preparedStmtOfMarkWorkSpecScheduled;
    public final SharedSQLiteStatement __preparedStmtOfResetScheduledState;
    public final SharedSQLiteStatement __preparedStmtOfResetWorkSpecRunAttemptCount;
    public final SharedSQLiteStatement __preparedStmtOfSetOutput;
    public final SharedSQLiteStatement __preparedStmtOfSetPeriodStartTime;

    public WorkSpecDao_Impl(RoomDatabase roomDatabase) {
        this.__db = roomDatabase;
        this.__insertionAdapterOfWorkSpec = new EntityInsertionAdapter<WorkSpec>(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.sqlite.db.framework.FrameworkSQLiteStatement, java.lang.Object] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x01b1  */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x01c9  */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x01d1  */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x01dd A[SYNTHETIC, Splitter:B:75:0x01dd] */
            @Override // androidx.room.EntityInsertionAdapter
            public void bind(FrameworkSQLiteStatement frameworkSQLiteStatement, WorkSpec workSpec) {
                int i;
                Throwable th;
                IOException e;
                WorkSpec workSpec2 = workSpec;
                String str = workSpec2.id;
                int i2 = 1;
                if (str == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(1);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(1, str);
                }
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(2, (long) AppCompatDelegateImpl.ConfigurationImplApi17.stateToInt(workSpec2.state));
                String str2 = workSpec2.workerClassName;
                if (str2 == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(3);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(3, str2);
                }
                String str3 = workSpec2.inputMergerClassName;
                int i3 = 4;
                if (str3 == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(4);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindString(4, str3);
                }
                byte[] byteArrayInternal = Data.toByteArrayInternal(workSpec2.input);
                if (byteArrayInternal == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(5);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindBlob(5, byteArrayInternal);
                }
                byte[] byteArrayInternal2 = Data.toByteArrayInternal(workSpec2.output);
                if (byteArrayInternal2 == null) {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(6);
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindBlob(6, byteArrayInternal2);
                }
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(7, workSpec2.initialDelay);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(8, workSpec2.intervalDuration);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(9, workSpec2.flexDuration);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(10, (long) workSpec2.runAttemptCount);
                BackoffPolicy backoffPolicy = workSpec2.backoffPolicy;
                int ordinal = backoffPolicy.ordinal();
                if (ordinal == 0) {
                    i = 0;
                } else if (ordinal == 1) {
                    i = 1;
                } else {
                    throw new IllegalArgumentException("Could not convert " + backoffPolicy + " to int");
                }
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(11, (long) i);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(12, workSpec2.backoffDelayDuration);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(13, workSpec2.periodStartTime);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(14, workSpec2.minimumRetentionDuration);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(15, workSpec2.scheduleRequestedAt);
                ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(16, workSpec2.runInForeground ? 1 : 0);
                Constraints constraints = workSpec2.constraints;
                if (constraints != null) {
                    NetworkType networkType = constraints.mRequiredNetworkType;
                    int ordinal2 = networkType.ordinal();
                    if (ordinal2 != 0) {
                        if (ordinal2 != 1) {
                            if (ordinal2 == 2) {
                                i2 = 2;
                            } else if (ordinal2 == 3) {
                                i2 = 3;
                            } else if (ordinal2 != 4) {
                                throw new IllegalArgumentException("Could not convert " + networkType + " to int");
                            }
                        }
                        i3 = i2;
                    } else {
                        i3 = 0;
                    }
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(17, (long) i3);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(18, constraints.mRequiresCharging ? 1 : 0);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(19, constraints.mRequiresDeviceIdle ? 1 : 0);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(20, constraints.mRequiresBatteryNotLow ? 1 : 0);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(21, constraints.mRequiresStorageNotLow ? 1 : 0);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(22, constraints.mTriggerContentUpdateDelay);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindLong(23, constraints.mTriggerMaxContentDelay);
                    ContentUriTriggers contentUriTriggers = constraints.mContentUriTriggers;
                    byte[] bArr = null;
                    ObjectOutputStream objectOutputStream = null;
                    if (contentUriTriggers.size() != 0) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                            try {
                                objectOutputStream2.writeInt(contentUriTriggers.size());
                                for (ContentUriTriggers.Trigger trigger : contentUriTriggers.mTriggers) {
                                    objectOutputStream2.writeUTF(trigger.mUri.toString());
                                    objectOutputStream2.writeBoolean(trigger.mTriggerForDescendants);
                                }
                                try {
                                    objectOutputStream2.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            } catch (IOException e3) {
                                e = e3;
                                objectOutputStream = objectOutputStream2;
                                try {
                                    e.printStackTrace();
                                    if (objectOutputStream != null) {
                                    }
                                    byteArrayOutputStream.close();
                                    bArr = byteArrayOutputStream.toByteArray();
                                    if (bArr == null) {
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    objectOutputStream2 = objectOutputStream;
                                    if (objectOutputStream2 != null) {
                                        try {
                                            objectOutputStream2.close();
                                        } catch (IOException e4) {
                                            e4.printStackTrace();
                                        }
                                    }
                                    try {
                                        byteArrayOutputStream.close();
                                    } catch (IOException e5) {
                                        e5.printStackTrace();
                                    }
                                    throw th;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (objectOutputStream2 != null) {
                                }
                                byteArrayOutputStream.close();
                                throw th;
                            }
                        } catch (IOException e6) {
                            e = e6;
                            e.printStackTrace();
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            byteArrayOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                            if (bArr == null) {
                            }
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e7) {
                            e7.printStackTrace();
                        }
                        bArr = byteArrayOutputStream.toByteArray();
                    }
                    if (bArr == null) {
                        ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(24);
                    } else {
                        ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindBlob(24, bArr);
                    }
                } else {
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(17);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(18);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(19);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(20);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(21);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(22);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(23);
                    ((FrameworkSQLiteProgram) frameworkSQLiteStatement).mDelegate.bindNull(24);
                }
            }

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "INSERT OR IGNORE INTO `WorkSpec` (`id`,`state`,`worker_class_name`,`input_merger_class_name`,`input`,`output`,`initial_delay`,`interval_duration`,`flex_duration`,`run_attempt_count`,`backoff_policy`,`backoff_delay_duration`,`period_start_time`,`minimum_retention_duration`,`schedule_requested_at`,`run_in_foreground`,`required_network_type`,`requires_charging`,`requires_device_idle`,`requires_battery_not_low`,`requires_storage_not_low`,`trigger_content_update_delay`,`trigger_max_content_delay`,`content_uri_triggers`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }
        };
        this.__preparedStmtOfDelete = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass2 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "DELETE FROM workspec WHERE id=?";
            }
        };
        this.__preparedStmtOfSetOutput = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass3 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET output=? WHERE id=?";
            }
        };
        this.__preparedStmtOfSetPeriodStartTime = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass4 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET period_start_time=? WHERE id=?";
            }
        };
        this.__preparedStmtOfIncrementWorkSpecRunAttemptCount = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass5 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=?";
            }
        };
        this.__preparedStmtOfResetWorkSpecRunAttemptCount = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass6 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET run_attempt_count=0 WHERE id=?";
            }
        };
        this.__preparedStmtOfMarkWorkSpecScheduled = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass7 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=? WHERE id=?";
            }
        };
        this.__preparedStmtOfResetScheduledState = new SharedSQLiteStatement(this, roomDatabase) {
            /* class androidx.work.impl.model.WorkSpecDao_Impl.AnonymousClass8 */

            @Override // androidx.room.SharedSQLiteStatement
            public String createQuery() {
                return "UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)";
            }
        };
        new AtomicBoolean(false);
    }

    public void delete(String str) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfDelete.acquire();
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(1);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfDelete;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfDelete.release(acquire);
            throw th;
        }
    }

    public List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 ORDER BY period_start_time LIMIT ?", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = AppCompatDelegateImpl.ConfigurationImplApi17.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = AppCompatDelegateImpl.ConfigurationImplApi17.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i2));
                    i2 = i2;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = AppCompatDelegateImpl.ConfigurationImplApi17.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<String> getAllUnfinishedWork() {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)", 0);
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

    public List<WorkSpec> getEligibleWorkForScheduling(int i) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY period_start_time LIMIT (SELECT MAX(?-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))", 1);
        acquire.bindLong(1, (long) i);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_in_foreground");
                int i2 = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = AppCompatDelegateImpl.ConfigurationImplApi17.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = AppCompatDelegateImpl.ConfigurationImplApi17.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i2));
                    i2 = i2;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = AppCompatDelegateImpl.ConfigurationImplApi17.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow12 = columnIndexOrThrow12;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getRunningWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_in_foreground");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = AppCompatDelegateImpl.ConfigurationImplApi17.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = AppCompatDelegateImpl.ConfigurationImplApi17.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i));
                    i = i;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = AppCompatDelegateImpl.ConfigurationImplApi17.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow13 = columnIndexOrThrow13;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec> getScheduledWork() {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE state=0 AND schedule_requested_at<>-1", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_in_foreground");
                int i = columnIndexOrThrow14;
                ArrayList arrayList = new ArrayList(query.getCount());
                while (query.moveToNext()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = AppCompatDelegateImpl.ConfigurationImplApi17.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = AppCompatDelegateImpl.ConfigurationImplApi17.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec = new WorkSpec(string, string2);
                    workSpec.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec.output = Data.fromByteArray(query.getBlob(i));
                    i = i;
                    workSpec.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec.backoffPolicy = AppCompatDelegateImpl.ConfigurationImplApi17.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    columnIndexOrThrow17 = columnIndexOrThrow17;
                    workSpec.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec.periodStartTime = query.getLong(columnIndexOrThrow21);
                    columnIndexOrThrow21 = columnIndexOrThrow21;
                    workSpec.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec.constraints = constraints;
                    arrayList.add(workSpec);
                    columnIndexOrThrow23 = columnIndexOrThrow23;
                    columnIndexOrThrow24 = columnIndexOrThrow24;
                    columnIndexOrThrow2 = columnIndexOrThrow2;
                    columnIndexOrThrow13 = columnIndexOrThrow13;
                    columnIndexOrThrow15 = columnIndexOrThrow15;
                    columnIndexOrThrow16 = columnIndexOrThrow16;
                    columnIndexOrThrow18 = columnIndexOrThrow18;
                    columnIndexOrThrow9 = columnIndexOrThrow9;
                    columnIndexOrThrow11 = columnIndexOrThrow11;
                    columnIndexOrThrow = columnIndexOrThrow;
                    columnIndexOrThrow22 = columnIndexOrThrow22;
                    columnIndexOrThrow3 = columnIndexOrThrow3;
                    columnIndexOrThrow20 = columnIndexOrThrow20;
                    columnIndexOrThrow4 = columnIndexOrThrow4;
                    columnIndexOrThrow19 = columnIndexOrThrow19;
                }
                query.close();
                roomSQLiteQuery.release();
                return arrayList;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public WorkInfo$State getState(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT state FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        WorkInfo$State workInfo$State = null;
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            if (query.moveToFirst()) {
                workInfo$State = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(0));
            }
            return workInfo$State;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public List<String> getUnfinishedWorkWithName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
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

    public WorkSpec getWorkSpec(String str) {
        RoomSQLiteQuery roomSQLiteQuery;
        Throwable th;
        WorkSpec workSpec;
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT `required_network_type`, `requires_charging`, `requires_device_idle`, `requires_battery_not_low`, `requires_storage_not_low`, `trigger_content_update_delay`, `trigger_max_content_delay`, `content_uri_triggers`, `WorkSpec`.`id` AS `id`, `WorkSpec`.`state` AS `state`, `WorkSpec`.`worker_class_name` AS `worker_class_name`, `WorkSpec`.`input_merger_class_name` AS `input_merger_class_name`, `WorkSpec`.`input` AS `input`, `WorkSpec`.`output` AS `output`, `WorkSpec`.`initial_delay` AS `initial_delay`, `WorkSpec`.`interval_duration` AS `interval_duration`, `WorkSpec`.`flex_duration` AS `flex_duration`, `WorkSpec`.`run_attempt_count` AS `run_attempt_count`, `WorkSpec`.`backoff_policy` AS `backoff_policy`, `WorkSpec`.`backoff_delay_duration` AS `backoff_delay_duration`, `WorkSpec`.`period_start_time` AS `period_start_time`, `WorkSpec`.`minimum_retention_duration` AS `minimum_retention_duration`, `WorkSpec`.`schedule_requested_at` AS `schedule_requested_at`, `WorkSpec`.`run_in_foreground` AS `run_in_foreground` FROM workspec WHERE id=?", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "required_network_type");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_charging");
            int columnIndexOrThrow3 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_device_idle");
            int columnIndexOrThrow4 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_battery_not_low");
            int columnIndexOrThrow5 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "requires_storage_not_low");
            int columnIndexOrThrow6 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_content_update_delay");
            int columnIndexOrThrow7 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "trigger_max_content_delay");
            int columnIndexOrThrow8 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "content_uri_triggers");
            int columnIndexOrThrow9 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow10 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
            int columnIndexOrThrow11 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "worker_class_name");
            int columnIndexOrThrow12 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input_merger_class_name");
            int columnIndexOrThrow13 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "input");
            int columnIndexOrThrow14 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "output");
            roomSQLiteQuery = acquire;
            try {
                int columnIndexOrThrow15 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "initial_delay");
                int columnIndexOrThrow16 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "interval_duration");
                int columnIndexOrThrow17 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "flex_duration");
                int columnIndexOrThrow18 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_attempt_count");
                int columnIndexOrThrow19 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_policy");
                int columnIndexOrThrow20 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "backoff_delay_duration");
                int columnIndexOrThrow21 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "period_start_time");
                int columnIndexOrThrow22 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "minimum_retention_duration");
                int columnIndexOrThrow23 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "schedule_requested_at");
                int columnIndexOrThrow24 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "run_in_foreground");
                if (query.moveToFirst()) {
                    String string = query.getString(columnIndexOrThrow9);
                    String string2 = query.getString(columnIndexOrThrow11);
                    Constraints constraints = new Constraints();
                    constraints.mRequiredNetworkType = AppCompatDelegateImpl.ConfigurationImplApi17.intToNetworkType(query.getInt(columnIndexOrThrow));
                    constraints.mRequiresCharging = query.getInt(columnIndexOrThrow2) != 0;
                    constraints.mRequiresDeviceIdle = query.getInt(columnIndexOrThrow3) != 0;
                    constraints.mRequiresBatteryNotLow = query.getInt(columnIndexOrThrow4) != 0;
                    constraints.mRequiresStorageNotLow = query.getInt(columnIndexOrThrow5) != 0;
                    constraints.mTriggerContentUpdateDelay = query.getLong(columnIndexOrThrow6);
                    constraints.mTriggerMaxContentDelay = query.getLong(columnIndexOrThrow7);
                    constraints.mContentUriTriggers = AppCompatDelegateImpl.ConfigurationImplApi17.byteArrayToContentUriTriggers(query.getBlob(columnIndexOrThrow8));
                    WorkSpec workSpec2 = new WorkSpec(string, string2);
                    workSpec2.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow10));
                    workSpec2.inputMergerClassName = query.getString(columnIndexOrThrow12);
                    workSpec2.input = Data.fromByteArray(query.getBlob(columnIndexOrThrow13));
                    workSpec2.output = Data.fromByteArray(query.getBlob(columnIndexOrThrow14));
                    workSpec2.initialDelay = query.getLong(columnIndexOrThrow15);
                    workSpec2.intervalDuration = query.getLong(columnIndexOrThrow16);
                    workSpec2.flexDuration = query.getLong(columnIndexOrThrow17);
                    workSpec2.runAttemptCount = query.getInt(columnIndexOrThrow18);
                    workSpec2.backoffPolicy = AppCompatDelegateImpl.ConfigurationImplApi17.intToBackoffPolicy(query.getInt(columnIndexOrThrow19));
                    workSpec2.backoffDelayDuration = query.getLong(columnIndexOrThrow20);
                    workSpec2.periodStartTime = query.getLong(columnIndexOrThrow21);
                    workSpec2.minimumRetentionDuration = query.getLong(columnIndexOrThrow22);
                    workSpec2.scheduleRequestedAt = query.getLong(columnIndexOrThrow23);
                    workSpec2.runInForeground = query.getInt(columnIndexOrThrow24) != 0;
                    workSpec2.constraints = constraints;
                    workSpec = workSpec2;
                } else {
                    workSpec = null;
                }
                query.close();
                roomSQLiteQuery.release();
                return workSpec;
            } catch (Throwable th2) {
                th = th2;
                query.close();
                roomSQLiteQuery.release();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            roomSQLiteQuery = acquire;
            query.close();
            roomSQLiteQuery.release();
            throw th;
        }
    }

    public List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String str) {
        RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=?)", 1);
        if (str == null) {
            acquire.bindNull(1);
        } else {
            acquire.bindString(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        Cursor query = DBUtil.query(this.__db, acquire, false, null);
        try {
            int columnIndexOrThrow = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "id");
            int columnIndexOrThrow2 = AppCompatDelegateImpl.ConfigurationImplApi17.getColumnIndexOrThrow(query, "state");
            ArrayList arrayList = new ArrayList(query.getCount());
            while (query.moveToNext()) {
                WorkSpec.IdAndState idAndState = new WorkSpec.IdAndState();
                idAndState.id = query.getString(columnIndexOrThrow);
                idAndState.state = AppCompatDelegateImpl.ConfigurationImplApi17.intToState(query.getInt(columnIndexOrThrow2));
                arrayList.add(idAndState);
            }
            return arrayList;
        } finally {
            query.close();
            acquire.release();
        }
    }

    public int incrementWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(1);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfIncrementWorkSpecRunAttemptCount;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
            return executeUpdateDelete;
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfIncrementWorkSpecRunAttemptCount.release(acquire);
            throw th;
        }
    }

    public int markWorkSpecScheduled(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfMarkWorkSpecScheduled.acquire();
        ((FrameworkSQLiteProgram) acquire).mDelegate.bindLong(1, j);
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(2);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfMarkWorkSpecScheduled;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        }
    }

    public int resetWorkSpecRunAttemptCount(String str) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfResetWorkSpecRunAttemptCount.acquire();
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(1);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(1, str);
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfResetWorkSpecRunAttemptCount;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
            return executeUpdateDelete;
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfResetWorkSpecRunAttemptCount.release(acquire);
            throw th;
        }
    }

    public void setOutput(String str, Data data) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfSetOutput.acquire();
        byte[] byteArrayInternal = Data.toByteArrayInternal(data);
        if (byteArrayInternal == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(1);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindBlob(1, byteArrayInternal);
        }
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(2);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfSetOutput;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        } catch (Throwable th) {
            this.__db.endTransaction();
            this.__preparedStmtOfSetOutput.release(acquire);
            throw th;
        }
    }

    public void setPeriodStartTime(String str, long j) {
        this.__db.assertNotSuspendingTransaction();
        FrameworkSQLiteStatement acquire = this.__preparedStmtOfSetPeriodStartTime.acquire();
        ((FrameworkSQLiteProgram) acquire).mDelegate.bindLong(1, j);
        if (str == null) {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindNull(2);
        } else {
            ((FrameworkSQLiteProgram) acquire).mDelegate.bindString(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            SharedSQLiteStatement sharedSQLiteStatement = this.__preparedStmtOfSetPeriodStartTime;
            if (acquire == sharedSQLiteStatement.mStmt) {
                sharedSQLiteStatement.mLock.set(false);
            }
        }
    }

    public int setState(WorkInfo$State workInfo$State, String... strArr) {
        this.__db.assertNotSuspendingTransaction();
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE workspec SET state=");
        sb.append(ColorPropConverter.PREFIX_ATTR);
        sb.append(" WHERE id IN (");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(ColorPropConverter.PREFIX_ATTR);
            if (i < length - 1) {
                sb.append(",");
            }
        }
        sb.append(")");
        FrameworkSQLiteStatement compileStatement = this.__db.compileStatement(sb.toString());
        ((FrameworkSQLiteProgram) compileStatement).mDelegate.bindLong(1, (long) AppCompatDelegateImpl.ConfigurationImplApi17.stateToInt(workInfo$State));
        int i2 = 2;
        for (String str : strArr) {
            if (str == null) {
                ((FrameworkSQLiteProgram) compileStatement).mDelegate.bindNull(i2);
            } else {
                ((FrameworkSQLiteProgram) compileStatement).mDelegate.bindString(i2, str);
            }
            i2++;
        }
        this.__db.beginTransaction();
        try {
            int executeUpdateDelete = compileStatement.executeUpdateDelete();
            this.__db.setTransactionSuccessful();
            return executeUpdateDelete;
        } finally {
            this.__db.endTransaction();
        }
    }
}
