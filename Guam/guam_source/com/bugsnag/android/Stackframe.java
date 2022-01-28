package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import com.facebook.react.bridge.PromiseImpl;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Stackframe.kt */
public final class Stackframe implements JsonStream.Streamable {
    public Map<String, String> code;
    public Number columnNumber;
    public String file;
    public Boolean inProject;
    public Number lineNumber;
    public String method;

    public Stackframe(String str, String str2, Number number, Boolean bool, Map<String, String> map, Number number2) {
        this.method = str;
        this.file = str2;
        this.lineNumber = number;
        this.inProject = bool;
        this.code = map;
        this.columnNumber = number2;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("method");
        jsonStream.value(this.method);
        jsonStream.name(PromiseImpl.STACK_FRAME_KEY_FILE);
        jsonStream.value(this.file);
        jsonStream.name("lineNumber");
        jsonStream.value(this.lineNumber);
        jsonStream.name("inProject");
        jsonStream.value(this.inProject);
        jsonStream.name("columnNumber");
        jsonStream.value(this.columnNumber);
        Map<String, String> map = this.code;
        if (map != null) {
            jsonStream.name(PromiseImpl.ERROR_MAP_KEY_CODE);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jsonStream.beginObject();
                jsonStream.name(entry.getKey());
                jsonStream.value(entry.getValue());
                jsonStream.endObject();
            }
        }
        jsonStream.endObject();
    }

    public Stackframe(String str, String str2, Number number, Boolean bool, Map map, Number number2, int i) {
        int i2 = i & 16;
        int i3 = i & 32;
        this.method = str;
        this.file = str2;
        this.lineNumber = number;
        this.inProject = bool;
        this.code = null;
        this.columnNumber = null;
    }
}
