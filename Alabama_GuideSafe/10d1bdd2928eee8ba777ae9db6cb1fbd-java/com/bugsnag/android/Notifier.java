package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Notifier.kt */
public final class Notifier implements JsonStream.Streamable {
    public List<Notifier> dependencies;
    public String name;
    public String url;
    public String version;

    public Notifier() {
        this(null, null, null, 7);
    }

    public Notifier(String str, String str2, String str3, int i) {
        String str4 = null;
        String str5 = (i & 1) != 0 ? "Android Bugsnag Notifier" : null;
        String str6 = (i & 2) != 0 ? "5.1.0" : null;
        str4 = (i & 4) != 0 ? "https://bugsnag.com" : str4;
        Intrinsics.checkParameterIsNotNull(str5, "name");
        Intrinsics.checkParameterIsNotNull(str6, "version");
        Intrinsics.checkParameterIsNotNull(str4, "url");
        this.name = str5;
        this.version = str6;
        this.url = str4;
        this.dependencies = EmptyList.INSTANCE;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("name");
        jsonStream.value(this.name);
        jsonStream.name("version");
        jsonStream.value(this.version);
        jsonStream.name("url");
        jsonStream.value(this.url);
        if (!this.dependencies.isEmpty()) {
            jsonStream.name("dependencies");
            jsonStream.beginArray();
            Iterator<T> it = this.dependencies.iterator();
            while (it.hasNext()) {
                jsonStream.value((Object) it.next());
            }
            jsonStream.endArray();
        }
        jsonStream.endObject();
    }
}
