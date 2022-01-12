package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stacktrace.kt */
public final class Stacktrace implements JsonStream.Streamable {
    public final Logger logger;
    public final List<Stackframe> trace;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.util.List] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public Stacktrace(StackTraceElement[] stackTraceElementArr, Collection<String> collection, Logger logger2) {
        Stackframe stackframe;
        Boolean bool;
        Intrinsics.checkParameterIsNotNull(stackTraceElementArr, "stacktrace");
        Intrinsics.checkParameterIsNotNull(collection, "projectPackages");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            try {
                String className = stackTraceElement.getClassName();
                Intrinsics.checkExpressionValueIsNotNull(className, "el.className");
                String methodName = className.length() > 0 ? stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() : stackTraceElement.getMethodName();
                String fileName = stackTraceElement.getFileName() == null ? "Unknown" : stackTraceElement.getFileName();
                Integer valueOf = Integer.valueOf(stackTraceElement.getLineNumber());
                String className2 = stackTraceElement.getClassName();
                Intrinsics.checkExpressionValueIsNotNull(className2, "el.className");
                Iterator<String> it = collection.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (MoreExecutors.startsWith$default(className2, it.next(), false, 2)) {
                            bool = Boolean.TRUE;
                            break;
                        }
                    } else {
                        bool = null;
                        break;
                    }
                }
                stackframe = new Stackframe(methodName, fileName, valueOf, bool, null, null, 48);
            } catch (Exception e) {
                this.logger.w("Failed to serialize stacktrace", e);
                stackframe = null;
            }
            if (stackframe != null) {
                arrayList.add(stackframe);
            }
        }
        this.trace = arrayList.size() >= 200 ? arrayList.subList(0, 200) : arrayList;
        this.logger = logger2;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginArray();
        Iterator<T> it = this.trace.iterator();
        while (it.hasNext()) {
            jsonStream.value((Object) it.next());
        }
        jsonStream.endArray();
    }

    public Stacktrace(List<Stackframe> list, Logger logger2) {
        Intrinsics.checkParameterIsNotNull(list, "frames");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.trace = list.size() >= 200 ? list.subList(0, 200) : list;
        this.logger = logger2;
    }
}
