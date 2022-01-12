package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Severity.kt */
public enum Severity implements JsonStream.Streamable {
    ERROR("error"),
    WARNING("warning"),
    INFO("info");
    
    public final String str;

    /* access modifiers changed from: public */
    Severity(String str2) {
        this.str = str2;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.value(this.str);
    }
}
