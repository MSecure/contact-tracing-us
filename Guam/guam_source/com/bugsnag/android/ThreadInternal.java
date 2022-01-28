package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ThreadInternal.kt */
public final class ThreadInternal implements JsonStream.Streamable {
    public long id;
    public final boolean isErrorReportingThread;
    public String name;
    public List<Stackframe> stacktrace;
    public ThreadType type;

    public ThreadInternal(long j, String str, ThreadType threadType, boolean z, Stacktrace stacktrace2) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        Intrinsics.checkParameterIsNotNull(threadType, "type");
        Intrinsics.checkParameterIsNotNull(stacktrace2, "stacktrace");
        this.id = j;
        this.name = str;
        this.type = threadType;
        this.isErrorReportingThread = z;
        this.stacktrace = CollectionsKt__CollectionsKt.toMutableList(stacktrace2.trace);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("id");
        jsonStream.value(this.id);
        jsonStream.name("name");
        jsonStream.value(this.name);
        jsonStream.name("type");
        jsonStream.value(this.type.desc);
        jsonStream.name("stacktrace");
        jsonStream.beginArray();
        Iterator<T> it = this.stacktrace.iterator();
        while (it.hasNext()) {
            jsonStream.value((Object) it.next());
        }
        jsonStream.endArray();
        if (this.isErrorReportingThread) {
            jsonStream.name("errorReportingThread");
            jsonStream.value(true);
        }
        jsonStream.endObject();
    }
}
