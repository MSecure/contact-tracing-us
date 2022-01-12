package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;

public class Thread implements JsonStream.Streamable {
    public final ThreadInternal impl;

    public Thread(long j, String str, ThreadType threadType, boolean z, Stacktrace stacktrace, Logger logger) {
        this.impl = new ThreadInternal(j, str, threadType, z, stacktrace);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }
}
