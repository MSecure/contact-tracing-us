package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventInternal.kt */
public final class EventInternal implements JsonStream.Streamable {
    public User _user;
    public AppWithState app;
    public List<Breadcrumb> breadcrumbs = new ArrayList();
    public String context;
    public DeviceWithState device;
    public final Set<String> discardClasses;
    public List<Error> errors;
    public String groupingHash;
    public HandledState handledState;
    public final boolean isUnhandled = this.handledState.unhandled;
    public final Metadata metadata;
    public final Throwable originalError;
    public Session session;
    public List<Thread> threads;

    public EventInternal(Throwable th, ImmutableConfig immutableConfig, HandledState handledState2, Metadata metadata2) {
        List<Error> list;
        List<Thread> list2;
        Iterable<Thread> iterable;
        Intrinsics.checkParameterIsNotNull(immutableConfig, "config");
        Intrinsics.checkParameterIsNotNull(handledState2, "handledState");
        Intrinsics.checkParameterIsNotNull(metadata2, BugsnagReactNative.DATA_KEY);
        this.originalError = th;
        this.handledState = handledState2;
        this.metadata = metadata2.copy();
        this.discardClasses = CollectionsKt___CollectionsKt.toSet(immutableConfig.discardClasses);
        Throwable th2 = this.originalError;
        if (th2 == null) {
            list = new ArrayList<>();
        } else {
            Collection<String> collection = immutableConfig.projectPackages;
            Logger logger = immutableConfig.logger;
            Intrinsics.checkParameterIsNotNull(th2, "exc");
            Intrinsics.checkParameterIsNotNull(collection, "projectPackages");
            Intrinsics.checkParameterIsNotNull(logger, "logger");
            ArrayList arrayList = new ArrayList();
            while (th2 != null) {
                StackTraceElement[] stackTrace = th2.getStackTrace();
                Intrinsics.checkExpressionValueIsNotNull(stackTrace, "currentEx.stackTrace");
                Stacktrace stacktrace = new Stacktrace(stackTrace, collection, logger);
                String name = th2.getClass().getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "currentEx.javaClass.name");
                arrayList.add(new ErrorInternal(name, th2.getLocalizedMessage(), stacktrace, ErrorType.ANDROID));
                th2 = th2.getCause();
            }
            ArrayList arrayList2 = new ArrayList(MoreExecutors.collectionSizeOrDefault(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new Error((ErrorInternal) it.next(), logger));
            }
            list = CollectionsKt___CollectionsKt.toMutableList(arrayList2);
            Intrinsics.checkExpressionValueIsNotNull(list, "Error.createError(origin…tPackages, config.logger)");
        }
        this.errors = list;
        Throwable th3 = this.originalError;
        boolean z = this.isUnhandled;
        Intrinsics.checkParameterIsNotNull(immutableConfig, "config");
        ThreadSendPolicy threadSendPolicy = immutableConfig.sendThreads;
        Collection<String> collection2 = immutableConfig.projectPackages;
        Logger logger2 = immutableConfig.logger;
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "java.lang.Thread.currentThread()");
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Intrinsics.checkExpressionValueIsNotNull(allStackTraces, "java.lang.Thread.getAllStackTraces()");
        Intrinsics.checkParameterIsNotNull(threadSendPolicy, "sendThreads");
        Intrinsics.checkParameterIsNotNull(collection2, "projectPackages");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        Intrinsics.checkParameterIsNotNull(currentThread, "currentThread");
        Intrinsics.checkParameterIsNotNull(allStackTraces, "stackTraces");
        boolean z2 = true;
        boolean z3 = false;
        if (threadSendPolicy == ThreadSendPolicy.ALWAYS || (threadSendPolicy == ThreadSendPolicy.UNHANDLED_ONLY && z)) {
            if (!allStackTraces.containsKey(currentThread)) {
                StackTraceElement[] stackTrace2 = currentThread.getStackTrace();
                Intrinsics.checkExpressionValueIsNotNull(stackTrace2, "currentThread.stackTrace");
                allStackTraces.put(currentThread, stackTrace2);
            }
            if (th3 != null && z) {
                StackTraceElement[] stackTrace3 = th3.getStackTrace();
                Intrinsics.checkExpressionValueIsNotNull(stackTrace3, "exc.stackTrace");
                allStackTraces.put(currentThread, stackTrace3);
            }
            long id = currentThread.getId();
            Set<Thread> keySet = allStackTraces.keySet();
            ThreadState$captureThreadTrace$$inlined$sortedBy$1 threadState$captureThreadTrace$$inlined$sortedBy$1 = new ThreadState$captureThreadTrace$$inlined$sortedBy$1();
            Intrinsics.checkNotNullParameter(keySet, "$this$sortedWith");
            Intrinsics.checkNotNullParameter(threadState$captureThreadTrace$$inlined$sortedBy$1, "comparator");
            if (keySet.size() <= 1) {
                Intrinsics.checkNotNullParameter(keySet, "$this$toList");
                int size = keySet.size();
                if (size == 0) {
                    iterable = EmptyList.INSTANCE;
                } else if (size != 1) {
                    iterable = CollectionsKt___CollectionsKt.toMutableList(keySet);
                } else {
                    iterable = MoreExecutors.listOf(keySet instanceof List ? ((List) keySet).get(0) : keySet.iterator().next());
                }
            } else {
                Object[] array = keySet.toArray(new Object[0]);
                if (array != null) {
                    Intrinsics.checkNotNullParameter(array, "$this$sortWith");
                    Intrinsics.checkNotNullParameter(threadState$captureThreadTrace$$inlined$sortedBy$1, "comparator");
                    if (array.length > 1) {
                        Arrays.sort(array, threadState$captureThreadTrace$$inlined$sortedBy$1);
                    }
                    iterable = MoreExecutors.asList(array);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            ArrayList arrayList3 = new ArrayList(MoreExecutors.collectionSizeOrDefault(iterable, 10));
            for (Thread thread : iterable) {
                StackTraceElement[] stackTraceElementArr = allStackTraces.get(thread);
                if (stackTraceElementArr != null) {
                    arrayList3.add(new Thread(thread.getId(), thread.getName(), ThreadType.ANDROID, thread.getId() == id ? z2 : z3, new Stacktrace(stackTraceElementArr, collection2, logger2), logger2));
                    arrayList3 = arrayList3;
                    z3 = z3;
                    allStackTraces = allStackTraces;
                    z2 = true;
                } else {
                    Intrinsics.throwNpe();
                    throw null;
                }
            }
            list2 = CollectionsKt___CollectionsKt.toMutableList(arrayList3);
        } else {
            list2 = new ArrayList<>();
        }
        this.threads = list2;
        this._user = new User(null, null, null);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("context");
        jsonStream.value(this.context);
        jsonStream.name("metaData");
        jsonStream.value(this.metadata);
        jsonStream.name("severity");
        Severity severity = this.handledState.currentSeverity;
        Intrinsics.checkExpressionValueIsNotNull(severity, "handledState.currentSeverity");
        jsonStream.value(severity);
        jsonStream.name("severityReason");
        jsonStream.value(this.handledState);
        jsonStream.name("unhandled");
        jsonStream.value(this.handledState.unhandled);
        jsonStream.name("exceptions");
        jsonStream.beginArray();
        Iterator<T> it = this.errors.iterator();
        while (it.hasNext()) {
            jsonStream.value((Object) it.next());
        }
        jsonStream.endArray();
        jsonStream.name("user");
        jsonStream.value(this._user);
        jsonStream.name("app");
        AppWithState appWithState = this.app;
        if (appWithState != null) {
            jsonStream.value(appWithState);
            jsonStream.name("device");
            DeviceWithState deviceWithState = this.device;
            if (deviceWithState != null) {
                jsonStream.value(deviceWithState);
                jsonStream.name("breadcrumbs");
                jsonStream.value(this.breadcrumbs);
                jsonStream.name("groupingHash");
                jsonStream.value(this.groupingHash);
                jsonStream.name("threads");
                jsonStream.beginArray();
                Iterator<T> it2 = this.threads.iterator();
                while (it2.hasNext()) {
                    jsonStream.value((Object) it2.next());
                }
                jsonStream.endArray();
                Session session2 = this.session;
                if (session2 != null) {
                    Session copySession = Session.copySession(session2);
                    jsonStream.name("session");
                    jsonStream.beginObject();
                    jsonStream.name("id");
                    Intrinsics.checkExpressionValueIsNotNull(copySession, "copy");
                    jsonStream.value(copySession.id);
                    jsonStream.name("startedAt");
                    jsonStream.value(DateUtils.toIso8601(copySession.startedAt));
                    jsonStream.name("events");
                    jsonStream.beginObject();
                    jsonStream.name("handled");
                    jsonStream.value((long) copySession.handledCount.intValue());
                    jsonStream.name("unhandled");
                    jsonStream.value((long) copySession.unhandledCount.intValue());
                    jsonStream.endObject();
                    jsonStream.endObject();
                }
                jsonStream.endObject();
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("device");
            throw null;
        }
        Intrinsics.throwUninitializedPropertyAccessException("app");
        throw null;
    }
}
