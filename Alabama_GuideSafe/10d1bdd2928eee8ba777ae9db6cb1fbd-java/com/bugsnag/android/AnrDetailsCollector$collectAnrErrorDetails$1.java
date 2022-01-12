package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Process;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: AnrDetailsCollector.kt */
public final class AnrDetailsCollector$collectAnrErrorDetails$1 implements Runnable {
    public final /* synthetic */ AtomicInteger $attempts;
    public final /* synthetic */ Client $client;
    public final /* synthetic */ Event $event;
    public final /* synthetic */ Handler $handler;
    public final /* synthetic */ AnrDetailsCollector this$0;

    public AnrDetailsCollector$collectAnrErrorDetails$1(AnrDetailsCollector anrDetailsCollector, Client client, AtomicInteger atomicInteger, Handler handler, Event event) {
        this.this$0 = anrDetailsCollector;
        this.$client = client;
        this.$attempts = atomicInteger;
        this.$handler = handler;
        this.$event = event;
    }

    public void run() {
        T t;
        T t2;
        boolean z;
        AnrDetailsCollector anrDetailsCollector = this.this$0;
        Context context = this.$client.appContext;
        Intrinsics.checkExpressionValueIsNotNull(context, "client.appContext");
        if (anrDetailsCollector != null) {
            Intrinsics.checkParameterIsNotNull(context, "ctx");
            Object systemService = context.getSystemService("activity");
            if (systemService != null) {
                ActivityManager activityManager = (ActivityManager) systemService;
                int myPid = Process.myPid();
                Intrinsics.checkParameterIsNotNull(activityManager, "am");
                try {
                    List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                    if (processesInErrorState == null) {
                        processesInErrorState = EmptyList.INSTANCE;
                    }
                    Iterator<T> it = processesInErrorState.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t2 = null;
                            break;
                        }
                        t2 = it.next();
                        if (((ActivityManager.ProcessErrorStateInfo) t2).pid == myPid) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (z) {
                            break;
                        }
                    }
                    t = t2;
                } catch (RuntimeException unused) {
                    t = null;
                }
                if (t != null) {
                    AnrDetailsCollector anrDetailsCollector2 = this.this$0;
                    Event event = this.$event;
                    if (anrDetailsCollector2 != null) {
                        Intrinsics.checkParameterIsNotNull(event, "event");
                        Intrinsics.checkParameterIsNotNull(t, "anrState");
                        String str = ((ActivityManager.ProcessErrorStateInfo) t).shortMsg;
                        List<Error> list = event.impl.errors;
                        Intrinsics.checkExpressionValueIsNotNull(list, "event.errors");
                        if (true ^ list.isEmpty()) {
                            Error error = event.impl.errors.get(0);
                            Intrinsics.checkExpressionValueIsNotNull(error, "event.errors[0]");
                            Error error2 = error;
                            Intrinsics.checkExpressionValueIsNotNull(str, "msg");
                            if (MoreExecutors.startsWith$default(str, "ANR", false, 2)) {
                                Intrinsics.checkNotNullParameter(str, "$this$replaceFirst");
                                Intrinsics.checkNotNullParameter("ANR", "oldValue");
                                Intrinsics.checkNotNullParameter("", "newValue");
                                int indexOf$default = StringsKt__StringNumberConversionsKt.indexOf$default((CharSequence) str, "ANR", 0, false, 2);
                                if (indexOf$default >= 0) {
                                    int i = indexOf$default + 3;
                                    Intrinsics.checkNotNullParameter(str, "$this$replaceRange");
                                    Intrinsics.checkNotNullParameter("", "replacement");
                                    if (i >= indexOf$default) {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append((CharSequence) str, 0, indexOf$default);
                                        Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                                        sb.append((CharSequence) "");
                                        sb.append((CharSequence) str, i, str.length());
                                        Intrinsics.checkNotNullExpressionValue(sb, "this.append(value, startIndex, endIndex)");
                                        str = sb.toString();
                                    } else {
                                        throw new IndexOutOfBoundsException("End index (" + i + ") is less than start index (" + indexOf$default + ").");
                                    }
                                }
                            }
                            error2.impl.errorMessage = str;
                        }
                        this.$client.populateAndNotifyAndroidEvent(this.$event, null);
                        return;
                    }
                    throw null;
                } else if (this.$attempts.getAndIncrement() < 300) {
                    this.$handler.postDelayed(this, 100);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
            }
        } else {
            throw null;
        }
    }
}
