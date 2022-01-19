package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorInternal.kt */
public final class ErrorInternal implements JsonStream.Streamable {
    public String errorClass;
    public String errorMessage;
    public final List<Stackframe> stacktrace;
    public ErrorType type;

    public ErrorInternal(String str, String str2, Stacktrace stacktrace2, ErrorType errorType) {
        Intrinsics.checkParameterIsNotNull(str, "errorClass");
        Intrinsics.checkParameterIsNotNull(stacktrace2, "stacktrace");
        Intrinsics.checkParameterIsNotNull(errorType, "type");
        this.errorClass = str;
        this.errorMessage = str2;
        this.type = errorType;
        this.stacktrace = stacktrace2.trace;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("errorClass");
        jsonStream.value(this.errorClass);
        jsonStream.name("message");
        jsonStream.value(this.errorMessage);
        jsonStream.name("type");
        jsonStream.value(this.type.desc);
        jsonStream.name("stacktrace");
        jsonStream.value(this.stacktrace);
        jsonStream.endObject();
    }
}
