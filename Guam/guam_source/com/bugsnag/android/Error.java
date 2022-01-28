package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

public class Error implements JsonStream.Streamable {
    public final ErrorInternal impl;
    public final Logger logger;

    public Error(ErrorInternal errorInternal, Logger logger2) {
        this.impl = errorInternal;
        this.logger = logger2;
    }

    public final void logNull(String str) {
        Logger logger2 = this.logger;
        logger2.e("Invalid null value supplied to error." + str + ", ignoring");
    }

    public void setErrorClass(String str) {
        if (str != null) {
            ErrorInternal errorInternal = this.impl;
            if (errorInternal != null) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                errorInternal.errorClass = str;
                return;
            }
            throw null;
        }
        logNull("errorClass");
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }
}
