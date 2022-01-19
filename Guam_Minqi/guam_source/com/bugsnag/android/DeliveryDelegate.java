package com.bugsnag.android;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class DeliveryDelegate extends BaseObservable {
    public final BreadcrumbState breadcrumbState;
    public final EventStore eventStore;
    public final ImmutableConfig immutableConfig;
    public final Logger logger;
    public final Notifier notifier;

    public DeliveryDelegate(Logger logger2, EventStore eventStore2, ImmutableConfig immutableConfig2, BreadcrumbState breadcrumbState2, Notifier notifier2) {
        this.logger = logger2;
        this.eventStore = eventStore2;
        this.immutableConfig = immutableConfig2;
        this.breadcrumbState = breadcrumbState2;
        this.notifier = notifier2;
    }

    public final void leaveErrorBreadcrumb(Event event) {
        List<Error> list = event.impl.errors;
        if (list.size() > 0) {
            String str = list.get(0).impl.errorClass;
            String str2 = list.get(0).impl.errorMessage;
            HashMap hashMap = new HashMap();
            hashMap.put("errorClass", str);
            hashMap.put("message", str2);
            hashMap.put("unhandled", String.valueOf(event.impl.isUnhandled));
            Severity severity = event.impl.handledState.currentSeverity;
            Intrinsics.checkExpressionValueIsNotNull(severity, "handledState.currentSeverity");
            hashMap.put("severity", severity.toString());
            this.breadcrumbState.add(new Breadcrumb(str, BreadcrumbType.ERROR, hashMap, new Date(), this.logger));
        }
    }
}
