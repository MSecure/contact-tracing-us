package com.bugsnag.android;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.storage.StorageManager;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.bugsnag.android.StateEvent;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

public class Client {
    public final ActivityBreadcrumbCollector activityBreadcrumbCollector;
    public final Context appContext;
    public final AppDataCollector appDataCollector;
    public final BreadcrumbState breadcrumbState;
    public final CallbackState callbackState;
    public final ClientObservable clientObservable = new ClientObservable();
    public final Connectivity connectivity;
    public final ContextState contextState;
    public final DeliveryDelegate deliveryDelegate;
    public final DeviceDataCollector deviceDataCollector;
    public final EventStore eventStore;
    public final ImmutableConfig immutableConfig;
    public final Logger logger;
    public final MetadataState metadataState;
    public final Notifier notifier = new Notifier(null, null, null, 7);
    public PluginClient pluginClient;
    public final SessionLifecycleCallback sessionLifecycleCallback;
    public final SessionStore sessionStore;
    public final SessionTracker sessionTracker;
    public final SharedPreferences sharedPrefs;
    public final StorageManager storageManager;
    public final SystemBroadcastReceiver systemBroadcastReceiver;
    public final UserState userState;

    public Client(Context context, Configuration configuration) {
        Object obj;
        Object obj2;
        ErrorTypes errorTypes;
        String str;
        Set set;
        Bundle bundle;
        String str2;
        Context applicationContext = context.getApplicationContext();
        this.appContext = applicationContext;
        ConnectivityCompat connectivityCompat = new ConnectivityCompat(applicationContext, new Function2<Boolean, String, Unit>() {
            /* class com.bugsnag.android.Client.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public Unit invoke(Boolean bool, String str) {
                Boolean bool2 = bool;
                HashMap hashMap = new HashMap();
                hashMap.put("hasConnection", bool2);
                hashMap.put("networkState", str);
                Client.this.leaveAutoBreadcrumb("Connectivity changed", BreadcrumbType.STATE, hashMap);
                if (!bool2.booleanValue()) {
                    return null;
                }
                Client.this.eventStore.flushAsync();
                return null;
            }
        });
        this.connectivity = connectivityCompat;
        Context context2 = this.appContext;
        Intrinsics.checkParameterIsNotNull(context2, "appContext");
        Intrinsics.checkParameterIsNotNull(configuration, "configuration");
        Intrinsics.checkParameterIsNotNull(connectivityCompat, "connectivity");
        String packageName = context2.getPackageName();
        PackageManager packageManager = context2.getPackageManager();
        try {
            obj = packageManager.getPackageInfo(packageName, 0);
        } catch (Throwable th) {
            obj = MoreExecutors.createFailure(th);
        }
        PackageInfo packageInfo = (PackageInfo) (obj instanceof Result.Failure ? null : obj);
        try {
            obj2 = packageManager.getApplicationInfo(packageName, 128);
        } catch (Throwable th2) {
            obj2 = MoreExecutors.createFailure(th2);
        }
        ApplicationInfo applicationInfo = (ApplicationInfo) (obj2 instanceof Result.Failure ? null : obj2);
        if (configuration.impl.releaseStage == null) {
            if (applicationInfo == null || (applicationInfo.flags & 2) == 0) {
                str2 = "production";
            } else {
                str2 = "development";
            }
            configuration.impl.releaseStage = str2;
        }
        Logger logger2 = configuration.impl.logger;
        if (logger2 == null || Intrinsics.areEqual(logger2, DebugLogger.INSTANCE)) {
            if (!Intrinsics.areEqual("production", configuration.impl.releaseStage)) {
                configuration.impl.logger = DebugLogger.INSTANCE;
            } else {
                configuration.impl.logger = NoopLogger.INSTANCE;
            }
        }
        Integer num = configuration.impl.versionCode;
        if (num == null || num.intValue() == 0) {
            configuration.impl.versionCode = packageInfo != null ? Integer.valueOf(packageInfo.versionCode) : null;
        }
        if (configuration.impl.projectPackages.isEmpty()) {
            Intrinsics.checkExpressionValueIsNotNull(packageName, "packageName");
            configuration.setProjectPackages(MoreExecutors.setOf(packageName));
        }
        String string = (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? null : bundle.getString("com.bugsnag.android.BUILD_UUID");
        ConfigInternal configInternal = configuration.impl;
        if (configInternal.delivery == null) {
            Logger logger3 = configInternal.logger;
            if (logger3 != null) {
                Intrinsics.checkExpressionValueIsNotNull(logger3, "configuration.logger!!");
                configuration.impl.delivery = new DefaultDelivery(connectivityCompat, logger3);
            } else {
                Intrinsics.throwNpe();
                throw null;
            }
        }
        Intrinsics.checkParameterIsNotNull(configuration, "config");
        ConfigInternal configInternal2 = configuration.impl;
        if (configInternal2.autoDetectErrors) {
            ErrorTypes errorTypes2 = configInternal2.enabledErrorTypes;
            errorTypes = new ErrorTypes(errorTypes2.anrs, errorTypes2.ndkCrashes, errorTypes2.unhandledExceptions, errorTypes2.unhandledRejections);
        } else {
            errorTypes = new ErrorTypes(false);
        }
        String str3 = configuration.impl.apiKey;
        Intrinsics.checkExpressionValueIsNotNull(str3, "config.apiKey");
        ConfigInternal configInternal3 = configuration.impl;
        boolean z = configInternal3.autoDetectErrors;
        boolean z2 = configInternal3.autoTrackSessions;
        ThreadSendPolicy threadSendPolicy = configInternal3.sendThreads;
        Intrinsics.checkExpressionValueIsNotNull(threadSendPolicy, "config.sendThreads");
        Set<String> set2 = configuration.impl.discardClasses;
        Intrinsics.checkExpressionValueIsNotNull(set2, "config.discardClasses");
        Set set3 = CollectionsKt___CollectionsKt.toSet(set2);
        Set<String> set4 = configuration.impl.enabledReleaseStages;
        Set set5 = set4 != null ? CollectionsKt___CollectionsKt.toSet(set4) : null;
        Set<String> set6 = configuration.impl.projectPackages;
        Intrinsics.checkExpressionValueIsNotNull(set6, "config.projectPackages");
        Set set7 = CollectionsKt___CollectionsKt.toSet(set6);
        ConfigInternal configInternal4 = configuration.impl;
        String str4 = configInternal4.releaseStage;
        String str5 = configInternal4.appVersion;
        Integer num2 = configInternal4.versionCode;
        String str6 = configInternal4.appType;
        Delivery delivery = configInternal4.delivery;
        Intrinsics.checkExpressionValueIsNotNull(delivery, "config.delivery");
        EndpointConfiguration endpointConfiguration = configuration.impl.endpoints;
        Intrinsics.checkExpressionValueIsNotNull(endpointConfiguration, "config.endpoints");
        ConfigInternal configInternal5 = configuration.impl;
        boolean z3 = configInternal5.persistUser;
        long j = configInternal5.launchCrashThresholdMs;
        Logger logger4 = configInternal5.logger;
        if (logger4 != null) {
            Intrinsics.checkExpressionValueIsNotNull(logger4, "config.logger!!");
            ConfigInternal configInternal6 = configuration.impl;
            int i = configInternal6.maxBreadcrumbs;
            Set<? extends BreadcrumbType> set8 = configInternal6.enabledBreadcrumbTypes;
            if (set8 != null) {
                set = CollectionsKt___CollectionsKt.toSet(set8);
                str = str6;
            } else {
                str = str6;
                set = null;
            }
            ImmutableConfig immutableConfig2 = new ImmutableConfig(str3, z, errorTypes, z2, threadSendPolicy, set3, set5, set7, set, str4, string, str5, num2, str, delivery, endpointConfiguration, z3, j, logger4, i);
            this.immutableConfig = immutableConfig2;
            Logger logger5 = immutableConfig2.logger;
            this.logger = logger5;
            if (!(context instanceof Application)) {
                logger5.w("Warning - Non-Application context detected! Please ensure that you are initializing Bugsnag from a custom Application class.");
            }
            CallbackState callbackState2 = configuration.impl.callbackState;
            Collection<OnErrorCallback> collection = callbackState2.onErrorTasks;
            Collection<OnBreadcrumbCallback> collection2 = callbackState2.onBreadcrumbTasks;
            Collection<OnSessionCallback> collection3 = callbackState2.onSessionTasks;
            Intrinsics.checkParameterIsNotNull(collection, "onErrorTasks");
            Intrinsics.checkParameterIsNotNull(collection2, "onBreadcrumbTasks");
            Intrinsics.checkParameterIsNotNull(collection3, "onSessionTasks");
            this.callbackState = new CallbackState(collection, collection2, collection3);
            this.breadcrumbState = new BreadcrumbState(this.immutableConfig.maxBreadcrumbs, this.callbackState, this.logger);
            this.storageManager = (StorageManager) this.appContext.getSystemService("storage");
            ContextState contextState2 = new ContextState();
            this.contextState = contextState2;
            if (configuration.impl != null) {
                contextState2.context = null;
                contextState2.notifyObservers(new StateEvent.UpdateContext(null));
                this.sessionStore = new SessionStore(this.appContext, this.logger, null);
                this.sessionTracker = new SessionTracker(this.immutableConfig, this.callbackState, this, this.sessionStore, this.logger);
                Metadata copy = configuration.impl.metadataState.metadata.copy();
                if (configuration.impl.metadataState != null) {
                    Intrinsics.checkParameterIsNotNull(copy, "metadata");
                    this.metadataState = new MetadataState(copy);
                    this.sharedPrefs = this.appContext.getSharedPreferences("com.bugsnag.android", 0);
                    Context context3 = this.appContext;
                    this.appDataCollector = new AppDataCollector(context3, context3.getPackageManager(), this.immutableConfig, this.sessionTracker, (ActivityManager) this.appContext.getSystemService("activity"), this.logger);
                    this.userState = new UserState(new UserRepository(this.sharedPrefs, this.immutableConfig.persistUser));
                    User user = configuration.impl.user;
                    if (!(user.id == null && user.email == null && user.name == null)) {
                        this.userState.setUser(user.id, user.email, user.name);
                    }
                    this.deviceDataCollector = new DeviceDataCollector(this.connectivity, this.appContext, this.appContext.getResources(), this.userState.user.id, new DeviceBuildInfo(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(Build.VERSION.SDK_INT), Build.DISPLAY, Build.FINGERPRINT, Build.TAGS, Build.BRAND, Build.SUPPORTED_ABIS), Environment.getDataDirectory(), this.logger);
                    Context context4 = this.appContext;
                    if (context4 instanceof Application) {
                        Application application = (Application) context4;
                        SessionLifecycleCallback sessionLifecycleCallback2 = new SessionLifecycleCallback(this.sessionTracker);
                        this.sessionLifecycleCallback = sessionLifecycleCallback2;
                        application.registerActivityLifecycleCallbacks(sessionLifecycleCallback2);
                        if (this.immutableConfig.shouldRecordBreadcrumbType(BreadcrumbType.STATE)) {
                            ActivityBreadcrumbCollector activityBreadcrumbCollector2 = new ActivityBreadcrumbCollector(new Function2<String, Map<String, ? extends Object>, Unit>() {
                                /* class com.bugsnag.android.Client.AnonymousClass2 */

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                                @Override // kotlin.jvm.functions.Function2
                                public Unit invoke(String str, Map<String, ? extends Object> map) {
                                    Client.this.leaveBreadcrumb(str, map, BreadcrumbType.STATE);
                                    return null;
                                }
                            });
                            this.activityBreadcrumbCollector = activityBreadcrumbCollector2;
                            application.registerActivityLifecycleCallbacks(activityBreadcrumbCollector2);
                        } else {
                            this.activityBreadcrumbCollector = null;
                        }
                    } else {
                        this.activityBreadcrumbCollector = null;
                        this.sessionLifecycleCallback = null;
                    }
                    this.eventStore = new EventStore(this.immutableConfig, this.appContext, this.logger, this.notifier, new InternalReportDelegate(this.appContext, this.logger, this.immutableConfig, this.storageManager, this.appDataCollector, this.deviceDataCollector, this.sessionTracker, this.notifier));
                    this.deliveryDelegate = new DeliveryDelegate(this.logger, this.eventStore, this.immutableConfig, this.breadcrumbState, this.notifier);
                    if (this.immutableConfig.enabledErrorTypes.unhandledExceptions) {
                        new ExceptionHandler(this, this.logger);
                    }
                    final SystemBroadcastReceiver systemBroadcastReceiver2 = new SystemBroadcastReceiver(this, this.logger);
                    if (systemBroadcastReceiver2.actions.size() > 0) {
                        try {
                            Async.EXECUTOR.execute(new Runnable() {
                                /* class com.bugsnag.android.Client.AnonymousClass3 */

                                public void run() {
                                    Context context = Client.this.appContext;
                                    SystemBroadcastReceiver systemBroadcastReceiver = systemBroadcastReceiver2;
                                    if (systemBroadcastReceiver != null) {
                                        IntentFilter intentFilter = new IntentFilter();
                                        for (String str : systemBroadcastReceiver.actions.keySet()) {
                                            intentFilter.addAction(str);
                                        }
                                        context.registerReceiver(systemBroadcastReceiver, intentFilter);
                                        return;
                                    }
                                    throw null;
                                }
                            });
                        } catch (RejectedExecutionException e) {
                            this.logger.w("Failed to register for automatic breadcrumb broadcasts", e);
                        }
                        this.systemBroadcastReceiver = systemBroadcastReceiver2;
                    } else {
                        this.systemBroadcastReceiver = null;
                    }
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.CONFIGURATION_CHANGED");
                    this.appContext.registerReceiver(new ConfigChangeReceiver(this.deviceDataCollector, new Function2<String, String, Unit>() {
                        /* class com.bugsnag.android.Client.AnonymousClass4 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function2
                        public Unit invoke(String str, String str2) {
                            String str3 = str2;
                            HashMap hashMap = new HashMap();
                            hashMap.put("from", str);
                            hashMap.put("to", str3);
                            Client.this.leaveAutoBreadcrumb("Orientation changed", BreadcrumbType.STATE, hashMap);
                            Client.this.clientObservable.notifyObservers(new StateEvent.UpdateOrientation(str3));
                            return null;
                        }
                    }), intentFilter);
                    NativeInterface.setClient(this);
                    PluginClient pluginClient2 = new PluginClient(configuration.impl.plugins, this.immutableConfig, this.logger);
                    this.pluginClient = pluginClient2;
                    Intrinsics.checkParameterIsNotNull(this, "client");
                    for (T t : pluginClient2.plugins) {
                        try {
                            t.load(this);
                        } catch (Throwable th3) {
                            Logger logger6 = pluginClient2.logger;
                            logger6.e("Failed to load plugin " + ((Object) t) + ", continuing with initialisation.", th3);
                        }
                    }
                    this.connectivity.registerForNetworkChanges();
                    EventStore eventStore2 = this.eventStore;
                    long j2 = 0;
                    if (eventStore2.config.launchCrashThresholdMs != 0) {
                        List<File> findStoredFiles = eventStore2.findStoredFiles();
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = (ArrayList) findStoredFiles;
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            File file = (File) it.next();
                            if (file.getName().endsWith("_startupcrash.json")) {
                                arrayList.add(file);
                            }
                        }
                        arrayList2.removeAll(arrayList);
                        eventStore2.cancelQueuedFiles(findStoredFiles);
                        if (!arrayList.isEmpty()) {
                            eventStore2.flushOnLaunchCompleted = false;
                            eventStore2.logger.i("Attempting to send launch crash reports");
                            try {
                                Async.EXECUTOR.execute(new Runnable(arrayList) {
                                    /* class com.bugsnag.android.EventStore.AnonymousClass2 */
                                    public final /* synthetic */ List val$crashReports;

                                    {
                                        this.val$crashReports = r2;
                                    }

                                    public void run() {
                                        EventStore.this.flushReports(this.val$crashReports);
                                        EventStore.this.flushOnLaunchCompleted = true;
                                    }
                                });
                            } catch (RejectedExecutionException e2) {
                                eventStore2.logger.w("Failed to flush launch crash reports", e2);
                                eventStore2.flushOnLaunchCompleted = true;
                            }
                            while (!eventStore2.flushOnLaunchCompleted && j2 < 2000) {
                                try {
                                    Thread.sleep(50);
                                    j2 += 50;
                                } catch (InterruptedException unused) {
                                    eventStore2.logger.w("Interrupted while waiting for launch crash report request");
                                }
                            }
                            eventStore2.logger.i("Continuing with Bugsnag initialisation");
                        }
                    }
                    eventStore2.flushAsync();
                    leaveAutoBreadcrumb("Bugsnag loaded", BreadcrumbType.STATE, Collections.emptyMap());
                    return;
                }
                throw null;
            }
            throw null;
        }
        Intrinsics.throwNpe();
        throw null;
    }

    public void clearMetadata(String str) {
        if (str != null) {
            MetadataState metadataState2 = this.metadataState;
            if (metadataState2 != null) {
                Intrinsics.checkParameterIsNotNull(str, "section");
                Metadata metadata = metadataState2.metadata;
                if (metadata != null) {
                    Intrinsics.checkParameterIsNotNull(str, "section");
                    metadata.store.remove(str);
                    metadataState2.notifyClear(str, null);
                    return;
                }
                throw null;
            }
            throw null;
        }
        logNull("clearMetadata");
    }

    public void finalize() throws Throwable {
        SystemBroadcastReceiver systemBroadcastReceiver2 = this.systemBroadcastReceiver;
        if (systemBroadcastReceiver2 != null) {
            try {
                this.appContext.unregisterReceiver(systemBroadcastReceiver2);
            } catch (IllegalArgumentException unused) {
                this.logger.w("Receiver not registered");
            }
        }
        super.finalize();
    }

    public void leaveAutoBreadcrumb(String str, BreadcrumbType breadcrumbType, Map<String, Object> map) {
        if (this.immutableConfig.shouldRecordBreadcrumbType(breadcrumbType)) {
            this.breadcrumbState.add(new Breadcrumb(str, breadcrumbType, map, new Date(), this.logger));
        }
    }

    public void leaveBreadcrumb(String str, Map<String, Object> map, BreadcrumbType breadcrumbType) {
        if (str == null || breadcrumbType == null || map == null) {
            logNull("leaveBreadcrumb");
        } else {
            this.breadcrumbState.add(new Breadcrumb(str, breadcrumbType, map, new Date(), this.logger));
        }
    }

    public final void logNull(String str) {
        Logger logger2 = this.logger;
        logger2.e("Invalid null value supplied to client." + str + ", ignoring");
    }

    public void notify(Throwable th, OnErrorCallback onErrorCallback) {
        populateAndNotifyAndroidEvent(new Event(th, this.immutableConfig, HandledState.newInstance("handledException"), this.metadataState.metadata, this.logger), onErrorCallback);
    }

    public void notifyInternal(Event event, OnErrorCallback onErrorCallback) {
        boolean z;
        boolean z2;
        EventInternal eventInternal = event.impl;
        boolean z3 = true;
        if (eventInternal.errors.isEmpty()) {
            z = true;
        } else {
            List<Error> list = eventInternal.errors;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (eventInternal.discardClasses.contains(it.next().impl.errorClass)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                z = true;
            }
            z = false;
        }
        if (!z && this.immutableConfig.shouldNotifyForReleaseStage()) {
            event.impl.metadata.setRedactedKeys(this.metadataState.metadata.redactedKeys);
            Session session = this.sessionTracker.currentSession.get();
            String str = null;
            if (session == null || session.isPaused.get()) {
                session = null;
            }
            if (session != null && (this.immutableConfig.autoTrackSessions || !session.isAutoCaptured())) {
                event.impl.session = session;
            }
            CallbackState callbackState2 = this.callbackState;
            Logger logger2 = this.logger;
            if (callbackState2 != null) {
                Intrinsics.checkParameterIsNotNull(event, "event");
                Intrinsics.checkParameterIsNotNull(logger2, "logger");
                Iterator<T> it2 = callbackState2.onErrorTasks.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z2 = true;
                        break;
                    }
                    try {
                        if (!it2.next().onError(event)) {
                            z2 = false;
                            break;
                        }
                    } catch (Throwable th) {
                        logger2.w("OnBreadcrumbCallback threw an Exception", th);
                    }
                }
                if (!z2 || (onErrorCallback != null && !onErrorCallback.onError(event))) {
                    this.logger.i("Skipping notification - onError task returned false");
                    return;
                }
                DeliveryDelegate deliveryDelegate2 = this.deliveryDelegate;
                EventPayload eventPayload = new EventPayload(deliveryDelegate2.immutableConfig.apiKey, event, deliveryDelegate2.notifier);
                EventInternal eventInternal2 = event.impl;
                Session session2 = eventInternal2.session;
                if (session2 != null) {
                    if (eventInternal2.isUnhandled) {
                        session2.unhandledCount.incrementAndGet();
                        event.impl.session = Session.copySession(session2);
                        deliveryDelegate2.notifyObservers(StateEvent.NotifyUnhandled.INSTANCE);
                    } else {
                        session2.handledCount.incrementAndGet();
                        event.impl.session = Session.copySession(session2);
                        deliveryDelegate2.notifyObservers(StateEvent.NotifyHandled.INSTANCE);
                    }
                }
                EventInternal eventInternal3 = event.impl;
                if (eventInternal3.isUnhandled) {
                    String str2 = eventInternal3.handledState.severityReasonType;
                    Intrinsics.checkExpressionValueIsNotNull(str2, "handledState.severityReasonType");
                    boolean equals = "unhandledPromiseRejection".equals(str2);
                    if (event.impl != null) {
                        Intrinsics.checkParameterIsNotNull(event, "event");
                        List<Error> list2 = event.impl.errors;
                        Intrinsics.checkExpressionValueIsNotNull(list2, "event.errors");
                        if (!list2.isEmpty()) {
                            Error error = list2.get(0);
                            Intrinsics.checkExpressionValueIsNotNull(error, "error");
                            str = error.impl.errorClass;
                        }
                        if (!Intrinsics.areEqual("ANR", str) && !equals) {
                            z3 = false;
                        }
                        deliveryDelegate2.eventStore.write(event);
                        if (z3) {
                            deliveryDelegate2.eventStore.flushAsync();
                            return;
                        }
                        return;
                    }
                    throw null;
                }
                try {
                    Async.EXECUTOR.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0151: INVOKE  
                          (wrap: java.util.concurrent.ThreadPoolExecutor : 0x014f: SGET  (r0v19 java.util.concurrent.ThreadPoolExecutor) =  com.bugsnag.android.Async.EXECUTOR java.util.concurrent.ThreadPoolExecutor)
                          (wrap: com.bugsnag.android.DeliveryDelegate$1 : 0x014c: CONSTRUCTOR  (r1v5 com.bugsnag.android.DeliveryDelegate$1) = 
                          (r10v2 'deliveryDelegate2' com.bugsnag.android.DeliveryDelegate)
                          (r0v17 'eventPayload' com.bugsnag.android.EventPayload)
                          (r9v0 'event' com.bugsnag.android.Event)
                         call: com.bugsnag.android.DeliveryDelegate.1.<init>(com.bugsnag.android.DeliveryDelegate, com.bugsnag.android.EventPayload, com.bugsnag.android.Event):void type: CONSTRUCTOR)
                         type: VIRTUAL call: java.util.concurrent.ThreadPoolExecutor.execute(java.lang.Runnable):void in method: com.bugsnag.android.Client.notifyInternal(com.bugsnag.android.Event, com.bugsnag.android.OnErrorCallback):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x014c: CONSTRUCTOR  (r1v5 com.bugsnag.android.DeliveryDelegate$1) = 
                          (r10v2 'deliveryDelegate2' com.bugsnag.android.DeliveryDelegate)
                          (r0v17 'eventPayload' com.bugsnag.android.EventPayload)
                          (r9v0 'event' com.bugsnag.android.Event)
                         call: com.bugsnag.android.DeliveryDelegate.1.<init>(com.bugsnag.android.DeliveryDelegate, com.bugsnag.android.EventPayload, com.bugsnag.android.Event):void type: CONSTRUCTOR in method: com.bugsnag.android.Client.notifyInternal(com.bugsnag.android.Event, com.bugsnag.android.OnErrorCallback):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 37 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.bugsnag.android.DeliveryDelegate, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 43 more
                        */
                    /*
                    // Method dump skipped, instructions count: 363
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.Client.notifyInternal(com.bugsnag.android.Event, com.bugsnag.android.OnErrorCallback):void");
                }

                public void notifyUnhandledException(Throwable th, Metadata metadata, String str, String str2) {
                    HandledState newInstance = HandledState.newInstance(str, Severity.ERROR, str2);
                    Metadata[] metadataArr = {this.metadataState.metadata, metadata};
                    Intrinsics.checkParameterIsNotNull(metadataArr, BugsnagReactNative.DATA_KEY);
                    ArrayList arrayList = new ArrayList(2);
                    for (int i = 0; i < 2; i++) {
                        arrayList.add(metadataArr[i].toMap());
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < 2; i2++) {
                        MoreExecutors.addAll(arrayList2, metadataArr[i2].jsonStreamer.redactedKeys);
                    }
                    Metadata metadata2 = new Metadata(Metadata.mergeMaps$bugsnag_android_core_release(arrayList), null, null, 6);
                    metadata2.setRedactedKeys(CollectionsKt___CollectionsKt.toSet(arrayList2));
                    populateAndNotifyAndroidEvent(new Event(th, this.immutableConfig, newInstance, metadata2, this.logger), null);
                }

                public void populateAndNotifyAndroidEvent(Event event, OnErrorCallback onErrorCallback) {
                    event.setDevice(this.deviceDataCollector.generateDeviceWithState(new Date().getTime()));
                    event.addMetadata("device", this.deviceDataCollector.getDeviceMetadata());
                    event.setApp(this.appDataCollector.generateAppWithState());
                    event.addMetadata("app", this.appDataCollector.getAppDataMetadata());
                    ArrayList arrayList = new ArrayList(this.breadcrumbState.getStore());
                    EventInternal eventInternal = event.impl;
                    if (eventInternal != null) {
                        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
                        eventInternal.breadcrumbs = arrayList;
                        User user = this.userState.user;
                        String str = user.id;
                        String str2 = user.email;
                        String str3 = user.name;
                        event.impl._user = new User(str, str2, str3);
                        if (AppCompatDelegateImpl.ConfigurationImplApi17.isEmpty(event.impl.context)) {
                            String str4 = this.contextState.context;
                            if (str4 == null) {
                                str4 = this.appDataCollector.sessionTracker.getContextActivity();
                            }
                            event.impl.context = str4;
                        }
                        notifyInternal(event, onErrorCallback);
                        return;
                    }
                    throw null;
                }

                public void registerObserver(Observer observer) {
                    this.metadataState.addObserver(observer);
                    this.breadcrumbState.addObserver(observer);
                    this.sessionTracker.addObserver(observer);
                    this.clientObservable.addObserver(observer);
                    this.userState.addObserver(observer);
                    this.contextState.addObserver(observer);
                    this.deliveryDelegate.addObserver(observer);
                }

                public void syncInitialState() {
                    Set<Map.Entry> entrySet;
                    MetadataState metadataState2 = this.metadataState;
                    for (String str : metadataState2.metadata.store.keySet()) {
                        Metadata metadata = metadataState2.metadata;
                        if (metadata != null) {
                            Intrinsics.checkParameterIsNotNull(str, "section");
                            Map map = (Map) metadata.store.get(str);
                            if (!(map == null || (entrySet = map.entrySet()) == null)) {
                                for (Map.Entry entry : entrySet) {
                                    metadataState2.notifyMetadataAdded(str, (String) entry.getKey(), entry.getValue());
                                }
                            }
                        } else {
                            throw null;
                        }
                    }
                    ContextState contextState2 = this.contextState;
                    contextState2.notifyObservers(new StateEvent.UpdateContext(contextState2.context));
                    UserState userState2 = this.userState;
                    userState2.notifyObservers(new StateEvent.UpdateUser(userState2.user));
                }

                public void clearMetadata(String str, String str2) {
                    if (str == null || str2 == null) {
                        logNull("clearMetadata");
                        return;
                    }
                    MetadataState metadataState2 = this.metadataState;
                    if (metadataState2 != null) {
                        Intrinsics.checkParameterIsNotNull(str, "section");
                        Intrinsics.checkParameterIsNotNull(str2, "key");
                        metadataState2.metadata.clearMetadata(str, str2);
                        metadataState2.notifyClear(str, str2);
                        return;
                    }
                    throw null;
                }
            }
