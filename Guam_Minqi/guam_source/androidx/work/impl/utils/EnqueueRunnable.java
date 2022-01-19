package androidx.work.impl.utils;

import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.WorkInfo$State;
import androidx.work.WorkRequest;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.DependencyDao_Impl;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkNameDao_Impl;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao_Impl;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTagDao_Impl;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EnqueueRunnable implements Runnable {
    public static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    public final OperationImpl mOperation = new OperationImpl();
    public final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this.mWorkContinuation = workContinuationImpl;
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v17, types: [boolean] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x021c  */
    /* JADX WARNING: Unknown variable types count: 3 */
    public static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        int i;
        int i2;
        int i3;
        boolean z;
        long j;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i4;
        int i5;
        long j2;
        List<WorkContinuationImpl> list = workContinuationImpl.mParents;
        if (list != null) {
            i = 0;
            for (WorkContinuationImpl workContinuationImpl2 : list) {
                if (!workContinuationImpl2.mEnqueued) {
                    i |= processContinuation(workContinuationImpl2);
                } else {
                    Logger.get().warning(TAG, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", workContinuationImpl2.mIds)), new Throwable[0]);
                }
            }
        } else {
            i = 0;
        }
        Set<String> prerequisitesFor = WorkContinuationImpl.prerequisitesFor(workContinuationImpl);
        WorkManagerImpl workManagerImpl = workContinuationImpl.mWorkManagerImpl;
        List<? extends WorkRequest> list2 = workContinuationImpl.mWork;
        String[] strArr = (String[]) ((AbstractCollection) prerequisitesFor).toArray(new String[0]);
        String str = workContinuationImpl.mName;
        ExistingWorkPolicy existingWorkPolicy = workContinuationImpl.mExistingWorkPolicy;
        WorkInfo$State workInfo$State = WorkInfo$State.ENQUEUED;
        ExistingWorkPolicy existingWorkPolicy2 = ExistingWorkPolicy.APPEND_OR_REPLACE;
        WorkInfo$State workInfo$State2 = WorkInfo$State.SUCCEEDED;
        WorkInfo$State workInfo$State3 = WorkInfo$State.CANCELLED;
        WorkInfo$State workInfo$State4 = WorkInfo$State.FAILED;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase workDatabase = workManagerImpl.mWorkDatabase;
        boolean z6 = strArr != null && strArr.length > 0;
        if (z6) {
            i2 = i;
            int length = strArr.length;
            int i6 = 0;
            z4 = false;
            z3 = false;
            z2 = true;
            while (i6 < length) {
                String str2 = strArr[i6];
                WorkSpec workSpec = ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpec(str2);
                if (workSpec == null) {
                    Logger.get().error(TAG, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    break;
                }
                WorkInfo$State workInfo$State5 = workSpec.state;
                z2 &= workInfo$State5 == workInfo$State2;
                if (workInfo$State5 == workInfo$State4) {
                    z3 = true;
                } else if (workInfo$State5 == workInfo$State3) {
                    z4 = true;
                }
                i6++;
                length = length;
                currentTimeMillis = currentTimeMillis;
            }
            j = currentTimeMillis;
        } else {
            i2 = i;
            j = currentTimeMillis;
            z4 = false;
            z3 = false;
            z2 = true;
        }
        boolean z7 = !TextUtils.isEmpty(str);
        if (z7 && !z6) {
            ArrayList arrayList = (ArrayList) ((WorkSpecDao_Impl) workDatabase.workSpecDao()).getWorkSpecIdAndStatesForName(str);
            if (!arrayList.isEmpty()) {
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND || existingWorkPolicy == existingWorkPolicy2) {
                    DependencyDao dependencyDao = workDatabase.dependencyDao();
                    ArrayList arrayList2 = new ArrayList();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        WorkSpec.IdAndState idAndState = (WorkSpec.IdAndState) it.next();
                        String str3 = idAndState.id;
                        DependencyDao_Impl dependencyDao_Impl = (DependencyDao_Impl) dependencyDao;
                        if (dependencyDao_Impl != null) {
                            RoomSQLiteQuery acquire = RoomSQLiteQuery.acquire("SELECT COUNT(*)>0 FROM dependency WHERE prerequisite_id=?", 1);
                            if (str3 == null) {
                                acquire.bindNull(1);
                            } else {
                                acquire.bindString(1, str3);
                            }
                            dependencyDao_Impl.__db.assertNotSuspendingTransaction();
                            Cursor query = DBUtil.query(dependencyDao_Impl.__db, acquire, false, null);
                            try {
                                if (!(query.moveToFirst() && query.getInt(0) != 0)) {
                                    boolean z8 = z2 & (idAndState.state == workInfo$State2);
                                    WorkInfo$State workInfo$State6 = idAndState.state;
                                    if (workInfo$State6 == workInfo$State4) {
                                        z3 = true;
                                    } else if (workInfo$State6 == workInfo$State3) {
                                        z4 = true;
                                    }
                                    arrayList2.add(idAndState.id);
                                    z2 = z8;
                                }
                                it = it;
                                dependencyDao = dependencyDao;
                                z7 = z7;
                            } finally {
                                query.close();
                                acquire.release();
                            }
                        } else {
                            throw null;
                        }
                    }
                    z5 = z7;
                    i4 = 0;
                    ArrayList arrayList3 = arrayList2;
                    arrayList3 = arrayList2;
                    if (existingWorkPolicy == existingWorkPolicy2 && (z4 || z3)) {
                        WorkSpecDao_Impl workSpecDao_Impl = (WorkSpecDao_Impl) workDatabase.workSpecDao();
                        Iterator it2 = ((ArrayList) workSpecDao_Impl.getWorkSpecIdAndStatesForName(str)).iterator();
                        while (it2.hasNext()) {
                            workSpecDao_Impl.delete(((WorkSpec.IdAndState) it2.next()).id);
                        }
                        z4 = false;
                        z3 = false;
                        arrayList3 = Collections.emptyList();
                    }
                    strArr = (String[]) arrayList3.toArray(strArr);
                    z6 = strArr.length > 0;
                    i5 = i4;
                    for (WorkRequest workRequest : list2) {
                        WorkSpec workSpec2 = workRequest.mWorkSpec;
                        if (z6 && !z2) {
                            if (z3) {
                                workSpec2.state = workInfo$State4;
                            } else if (z4) {
                                workSpec2.state = workInfo$State3;
                            } else {
                                workSpec2.state = WorkInfo$State.BLOCKED;
                            }
                            j2 = j;
                        } else if (!workSpec2.isPeriodic()) {
                            j2 = j;
                            workSpec2.periodStartTime = j2;
                        } else {
                            j2 = j;
                            workSpec2.periodStartTime = 0;
                        }
                        if (Build.VERSION.SDK_INT <= 25) {
                            tryDelegateConstrainedWorkSpec(workSpec2);
                        }
                        if (workSpec2.state == workInfo$State) {
                            i5 = 1;
                        }
                        WorkSpecDao_Impl workSpecDao_Impl2 = (WorkSpecDao_Impl) workDatabase.workSpecDao();
                        workSpecDao_Impl2.__db.assertNotSuspendingTransaction();
                        workSpecDao_Impl2.__db.beginTransaction();
                        try {
                            workSpecDao_Impl2.__insertionAdapterOfWorkSpec.insert(workSpec2);
                            workSpecDao_Impl2.__db.setTransactionSuccessful();
                            if (z6) {
                                int length2 = strArr.length;
                                int i7 = i4;
                                while (i7 < length2) {
                                    Dependency dependency = new Dependency(workRequest.getStringId(), strArr[i7]);
                                    DependencyDao_Impl dependencyDao_Impl2 = (DependencyDao_Impl) workDatabase.dependencyDao();
                                    dependencyDao_Impl2.__db.assertNotSuspendingTransaction();
                                    dependencyDao_Impl2.__db.beginTransaction();
                                    try {
                                        dependencyDao_Impl2.__insertionAdapterOfDependency.insert(dependency);
                                        dependencyDao_Impl2.__db.setTransactionSuccessful();
                                        dependencyDao_Impl2.__db.endTransaction();
                                        i7++;
                                        i5 = i5;
                                    } catch (Throwable th) {
                                        dependencyDao_Impl2.__db.endTransaction();
                                        throw th;
                                    }
                                }
                            }
                            for (String str4 : workRequest.mTags) {
                                WorkTagDao workTagDao = workDatabase.workTagDao();
                                WorkTag workTag = new WorkTag(str4, workRequest.getStringId());
                                WorkTagDao_Impl workTagDao_Impl = (WorkTagDao_Impl) workTagDao;
                                workTagDao_Impl.__db.assertNotSuspendingTransaction();
                                workTagDao_Impl.__db.beginTransaction();
                                try {
                                    workTagDao_Impl.__insertionAdapterOfWorkTag.insert(workTag);
                                    workTagDao_Impl.__db.setTransactionSuccessful();
                                } finally {
                                    workTagDao_Impl.__db.endTransaction();
                                }
                            }
                            if (z5) {
                                WorkNameDao workNameDao = workDatabase.workNameDao();
                                WorkName workName = new WorkName(str, workRequest.getStringId());
                                WorkNameDao_Impl workNameDao_Impl = (WorkNameDao_Impl) workNameDao;
                                workNameDao_Impl.__db.assertNotSuspendingTransaction();
                                workNameDao_Impl.__db.beginTransaction();
                                try {
                                    workNameDao_Impl.__insertionAdapterOfWorkName.insert(workName);
                                    workNameDao_Impl.__db.setTransactionSuccessful();
                                } finally {
                                    workNameDao_Impl.__db.endTransaction();
                                }
                            }
                            j = j2;
                            i5 = i5;
                            i4 = 0;
                        } finally {
                            workSpecDao_Impl2.__db.endTransaction();
                        }
                    }
                    z = true;
                    i3 = i5;
                    workContinuationImpl.mEnqueued = z;
                    return i2 | i3;
                }
                if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        WorkInfo$State workInfo$State7 = ((WorkSpec.IdAndState) it3.next()).state;
                        if (workInfo$State7 != workInfo$State) {
                            if (workInfo$State7 == WorkInfo$State.RUNNING) {
                            }
                        }
                        z = true;
                        i3 = 0;
                    }
                }
                
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0121: INVOKE  
                      (wrap: androidx.work.impl.utils.CancelWorkRunnable$3 : 0x011e: CONSTRUCTOR  (r8v7 androidx.work.impl.utils.CancelWorkRunnable$3) = (r5v0 'workManagerImpl' androidx.work.impl.WorkManagerImpl), (r7v1 'str' java.lang.String), false call: androidx.work.impl.utils.CancelWorkRunnable.3.<init>(androidx.work.impl.WorkManagerImpl, java.lang.String, boolean):void type: CONSTRUCTOR)
                     type: VIRTUAL call: androidx.work.impl.utils.CancelWorkRunnable.run():void in method: androidx.work.impl.utils.EnqueueRunnable.processContinuation(androidx.work.impl.WorkContinuationImpl):boolean, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x011e: CONSTRUCTOR  (r8v7 androidx.work.impl.utils.CancelWorkRunnable$3) = (r5v0 'workManagerImpl' androidx.work.impl.WorkManagerImpl), (r7v1 'str' java.lang.String), false call: androidx.work.impl.utils.CancelWorkRunnable.3.<init>(androidx.work.impl.WorkManagerImpl, java.lang.String, boolean):void type: CONSTRUCTOR in method: androidx.work.impl.utils.EnqueueRunnable.processContinuation(androidx.work.impl.WorkContinuationImpl):boolean, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.work.impl.utils.CancelWorkRunnable, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /* JADX WARNING: Removed duplicated region for block: B:113:0x021c  */
                /* JADX WARNING: Unknown variable types count: 3 */
                /*
                // Method dump skipped, instructions count: 837
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.processContinuation(androidx.work.impl.WorkContinuationImpl):boolean");
            }

            public static void tryDelegateConstrainedWorkSpec(WorkSpec workSpec) {
                Constraints constraints = workSpec.constraints;
                if (constraints.mRequiresBatteryNotLow || constraints.mRequiresStorageNotLow) {
                    String str = workSpec.workerClassName;
                    Data.Builder builder = new Data.Builder();
                    builder.putAll(workSpec.input.mValues);
                    builder.mValues.put("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
                    workSpec.workerClassName = ConstraintTrackingWorker.class.getName();
                    workSpec.input = builder.build();
                }
            }

            public void run() {
                try {
                    WorkContinuationImpl workContinuationImpl = this.mWorkContinuation;
                    if (workContinuationImpl == null) {
                        throw null;
                    } else if (!WorkContinuationImpl.hasCycles(workContinuationImpl, new HashSet())) {
                        WorkDatabase workDatabase = this.mWorkContinuation.mWorkManagerImpl.mWorkDatabase;
                        workDatabase.beginTransaction();
                        try {
                            boolean processContinuation = processContinuation(this.mWorkContinuation);
                            workDatabase.setTransactionSuccessful();
                            if (processContinuation) {
                                PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.mWorkManagerImpl.mContext, RescheduleReceiver.class, true);
                                WorkManagerImpl workManagerImpl = this.mWorkContinuation.mWorkManagerImpl;
                                Schedulers.schedule(workManagerImpl.mConfiguration, workManagerImpl.mWorkDatabase, workManagerImpl.mSchedulers);
                            }
                            this.mOperation.setState(Operation.SUCCESS);
                        } finally {
                            workDatabase.endTransaction();
                        }
                    } else {
                        throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.mWorkContinuation));
                    }
                } catch (Throwable th) {
                    this.mOperation.setState(new Operation.State.FAILURE(th));
                }
            }
        }
