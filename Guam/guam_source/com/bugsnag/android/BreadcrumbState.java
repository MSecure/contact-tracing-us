package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.bugsnag.android.StateEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BreadcrumbState.kt */
public final class BreadcrumbState extends BaseObservable implements JsonStream.Streamable {
    public final CallbackState callbackState;
    public final Logger logger;
    public final int maxBreadcrumbs;
    public final Queue<Breadcrumb> store = new ConcurrentLinkedQueue();

    public BreadcrumbState(int i, CallbackState callbackState2, Logger logger2) {
        Intrinsics.checkParameterIsNotNull(callbackState2, "callbackState");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.callbackState = callbackState2;
        this.logger = logger2;
        if (i > 0) {
            this.maxBreadcrumbs = i;
        } else {
            this.maxBreadcrumbs = 0;
        }
    }

    private final void pruneBreadcrumbs() {
        while (this.store.size() > this.maxBreadcrumbs) {
            this.store.poll();
        }
    }

    public final void add(Breadcrumb breadcrumb) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(breadcrumb, "breadcrumb");
        CallbackState callbackState2 = this.callbackState;
        Logger logger2 = this.logger;
        if (callbackState2 != null) {
            Intrinsics.checkParameterIsNotNull(breadcrumb, "breadcrumb");
            Intrinsics.checkParameterIsNotNull(logger2, "logger");
            Iterator<T> it = callbackState2.onBreadcrumbTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                try {
                    if (!it.next().onBreadcrumb(breadcrumb)) {
                        z = false;
                        break;
                    }
                } catch (Throwable th) {
                    logger2.w("OnBreadcrumbCallback threw an Exception", th);
                }
            }
            if (z) {
                this.store.add(breadcrumb);
                pruneBreadcrumbs();
                String message = breadcrumb.getMessage();
                Intrinsics.checkExpressionValueIsNotNull(message, "breadcrumb.message");
                BreadcrumbType type = breadcrumb.getType();
                Intrinsics.checkExpressionValueIsNotNull(type, "breadcrumb.type");
                String iso8601 = DateUtils.toIso8601(breadcrumb.getTimestamp());
                Intrinsics.checkExpressionValueIsNotNull(iso8601, "DateUtils.toIso8601(breadcrumb.timestamp)");
                Map<String, Object> metadata = breadcrumb.getMetadata();
                if (metadata == null) {
                    metadata = new LinkedHashMap<>();
                }
                notifyObservers(new StateEvent.AddBreadcrumb(message, type, iso8601, metadata));
                return;
            }
            return;
        }
        throw null;
    }

    public final CallbackState getCallbackState() {
        return this.callbackState;
    }

    public final Logger getLogger() {
        return this.logger;
    }

    public final Queue<Breadcrumb> getStore() {
        return this.store;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        pruneBreadcrumbs();
        jsonStream.beginArray();
        Iterator<T> it = this.store.iterator();
        while (it.hasNext()) {
            it.next().toStream(jsonStream);
        }
        jsonStream.endArray();
    }
}
