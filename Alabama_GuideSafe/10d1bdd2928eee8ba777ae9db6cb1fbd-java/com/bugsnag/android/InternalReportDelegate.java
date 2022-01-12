package com.bugsnag.android;

import android.content.Context;
import android.os.Build;
import android.os.storage.StorageManager;
import com.bugsnag.android.FileStore;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;

public class InternalReportDelegate implements FileStore.Delegate {
    public final Context appContext;
    public final AppDataCollector appDataCollector;
    public final DeviceDataCollector deviceDataCollector;
    public final ImmutableConfig immutableConfig;
    public final Logger logger;
    public final Notifier notifier;
    public final StorageManager storageManager;

    public InternalReportDelegate(Context context, Logger logger2, ImmutableConfig immutableConfig2, StorageManager storageManager2, AppDataCollector appDataCollector2, DeviceDataCollector deviceDataCollector2, SessionTracker sessionTracker, Notifier notifier2) {
        this.logger = logger2;
        this.immutableConfig = immutableConfig2;
        this.storageManager = storageManager2;
        this.appDataCollector = appDataCollector2;
        this.deviceDataCollector = deviceDataCollector2;
        this.appContext = context;
        this.notifier = notifier2;
    }

    public void onErrorIOFailure(Exception exc, File file, String str) {
        HandledState newInstance = HandledState.newInstance("unhandledException");
        Event event = new Event(exc, this.immutableConfig, newInstance, new Metadata(), this.logger);
        event.impl.context = str;
        event.addMetadata("BugsnagDiagnostics", "canRead", Boolean.valueOf(file.canRead()));
        event.addMetadata("BugsnagDiagnostics", "canWrite", Boolean.valueOf(file.canWrite()));
        event.addMetadata("BugsnagDiagnostics", "exists", Boolean.valueOf(file.exists()));
        event.addMetadata("BugsnagDiagnostics", "usableSpace", Long.valueOf(this.appContext.getCacheDir().getUsableSpace()));
        event.addMetadata("BugsnagDiagnostics", "filename", file.getName());
        event.addMetadata("BugsnagDiagnostics", "fileLength", Long.valueOf(file.length()));
        if (Build.VERSION.SDK_INT >= 26) {
            File file2 = new File(this.appContext.getCacheDir(), "bugsnag-errors");
            try {
                boolean isCacheBehaviorTombstone = this.storageManager.isCacheBehaviorTombstone(file2);
                boolean isCacheBehaviorGroup = this.storageManager.isCacheBehaviorGroup(file2);
                event.addMetadata("BugsnagDiagnostics", "cacheTombstone", Boolean.valueOf(isCacheBehaviorTombstone));
                event.addMetadata("BugsnagDiagnostics", "cacheGroup", Boolean.valueOf(isCacheBehaviorGroup));
            } catch (IOException e) {
                this.logger.w("Failed to record cache behaviour, skipping diagnostics", e);
            }
        }
        event.setApp(this.appDataCollector.generateAppWithState());
        event.setDevice(this.deviceDataCollector.generateDeviceWithState(new Date().getTime()));
        event.addMetadata("BugsnagDiagnostics", "notifierName", this.notifier.name);
        event.addMetadata("BugsnagDiagnostics", "notifierVersion", this.notifier.version);
        event.addMetadata("BugsnagDiagnostics", "apiKey", this.immutableConfig.apiKey);
        final EventPayload eventPayload = new EventPayload((String) null, event, this.notifier);
        try {
            Async.EXECUTOR.execute(new Runnable() {
                /* class com.bugsnag.android.InternalReportDelegate.AnonymousClass1 */

                public void run() {
                    try {
                        Delivery delivery = InternalReportDelegate.this.immutableConfig.delivery;
                        DeliveryParams errorApiDeliveryParams = InternalReportDelegate.this.immutableConfig.getErrorApiDeliveryParams();
                        if (delivery instanceof DefaultDelivery) {
                            Map<String, String> map = errorApiDeliveryParams.headers;
                            map.put("Bugsnag-Internal-Error", "true");
                            map.remove("Bugsnag-Api-Key");
                            ((DefaultDelivery) delivery).deliver(errorApiDeliveryParams.endpoint, eventPayload, map);
                        }
                    } catch (Exception e) {
                        InternalReportDelegate.this.logger.w("Failed to report internal event to Bugsnag", e);
                    }
                }
            });
        } catch (RejectedExecutionException unused) {
        }
    }
}
