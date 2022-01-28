package com.bugsnag.android;

import android.content.Context;
import com.bugsnag.android.FileStore;
import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import kotlin.jvm.internal.Intrinsics;

public class EventStore extends FileStore {
    public static final Comparator<File> EVENT_COMPARATOR = new Comparator<File>() {
        /* class com.bugsnag.android.EventStore.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3 == null && file4 == null) {
                return 0;
            }
            if (file3 == null) {
                return 1;
            }
            if (file4 == null) {
                return -1;
            }
            return file3.getName().replaceAll("_startupcrash", "").compareTo(file4.getName().replaceAll("_startupcrash", ""));
        }
    };
    public final ImmutableConfig config;
    public final FileStore.Delegate delegate;
    public volatile boolean flushOnLaunchCompleted = false;
    public final Logger logger;
    public final Notifier notifier;
    public final Semaphore semaphore = new Semaphore(1);

    public EventStore(ImmutableConfig immutableConfig, Context context, Logger logger2, Notifier notifier2, FileStore.Delegate delegate2) {
        super(context, "/bugsnag-errors/", 32, EVENT_COMPARATOR, logger2, delegate2);
        this.config = immutableConfig;
        this.logger = logger2;
        this.delegate = delegate2;
        this.notifier = notifier2;
    }

    public void flushAsync() {
        if (this.storeDirectory != null) {
            try {
                Async.EXECUTOR.execute(new Runnable() {
                    /* class com.bugsnag.android.EventStore.AnonymousClass3 */

                    public void run() {
                        EventStore eventStore = EventStore.this;
                        eventStore.flushReports(eventStore.findStoredFiles());
                    }
                });
            } catch (RejectedExecutionException unused) {
                this.logger.w("Failed to flush all on-disk errors, retaining unsent errors for later.");
            }
        }
    }

    public final void flushEventFile(File file) {
        try {
            int ordinal = this.config.delivery.deliver(new EventPayload(this.config.apiKey, file, this.notifier), this.config.getErrorApiDeliveryParams()).ordinal();
            if (ordinal == 0) {
                deleteStoredFiles(Collections.singleton(file));
                Logger logger2 = this.logger;
                logger2.i("Deleting sent error file " + file.getName());
            } else if (ordinal == 1) {
                cancelQueuedFiles(Collections.singleton(file));
                this.logger.w("Could not send previously saved error(s) to Bugsnag, will try again later");
            } else if (ordinal == 2) {
                RuntimeException runtimeException = new RuntimeException("Failed to deliver event payload");
                FileStore.Delegate delegate2 = this.delegate;
                if (delegate2 != null) {
                    ((InternalReportDelegate) delegate2).onErrorIOFailure(runtimeException, file, "Crash Report Deserialization");
                }
                deleteStoredFiles(Collections.singleton(file));
            }
        } catch (Exception e) {
            FileStore.Delegate delegate3 = this.delegate;
            if (delegate3 != null) {
                ((InternalReportDelegate) delegate3).onErrorIOFailure(e, file, "Crash Report Deserialization");
            }
            deleteStoredFiles(Collections.singleton(file));
        }
    }

    public void flushReports(Collection<File> collection) {
        if (!collection.isEmpty() && this.semaphore.tryAcquire(1)) {
            try {
                this.logger.i(String.format(Locale.US, "Sending %d saved error(s) to Bugsnag", Integer.valueOf(collection.size())));
                for (File file : collection) {
                    flushEventFile(file);
                }
            } finally {
                this.semaphore.release(1);
            }
        }
    }

    @Override // com.bugsnag.android.FileStore
    public String getFilename(Object obj) {
        String str;
        if (obj instanceof Event) {
            AppWithState appWithState = ((Event) obj).impl.app;
            if (appWithState != null) {
                Number number = appWithState.duration;
                if (number != null) {
                    if (number.longValue() < this.config.launchCrashThresholdMs) {
                        str = "_startupcrash";
                        return String.format(Locale.US, "%s%d_%s%s.json", this.storeDirectory, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString(), str);
                    }
                }
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("app");
                throw null;
            }
        }
        str = "not-jvm";
        return String.format(Locale.US, "%s%d_%s%s.json", this.storeDirectory, Long.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString(), str);
    }
}
