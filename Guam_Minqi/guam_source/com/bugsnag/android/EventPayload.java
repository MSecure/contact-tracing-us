package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventPayload.kt */
public final class EventPayload implements JsonStream.Streamable {
    public String apiKey;
    public final Event event;
    public final File eventFile;
    public final Notifier notifier;

    public EventPayload(String str, File file, Notifier notifier2) {
        Intrinsics.checkParameterIsNotNull(file, "eventFile");
        Intrinsics.checkParameterIsNotNull(notifier2, "notifier");
        this.apiKey = str;
        this.eventFile = file;
        this.event = null;
        this.notifier = notifier2;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("apiKey");
        jsonStream.value(this.apiKey);
        jsonStream.name("payloadVersion");
        jsonStream.writeDeferredName();
        jsonStream.beforeValue();
        jsonStream.string("4.0");
        jsonStream.name("notifier");
        jsonStream.value(this.notifier);
        jsonStream.name("events");
        jsonStream.beginArray();
        Event event2 = this.event;
        if (event2 != null) {
            jsonStream.value(event2);
        } else {
            File file = this.eventFile;
            if (file != null) {
                jsonStream.value(file);
            }
        }
        jsonStream.endArray();
        jsonStream.endObject();
    }

    public EventPayload(String str, Event event2, Notifier notifier2) {
        Intrinsics.checkParameterIsNotNull(event2, "event");
        Intrinsics.checkParameterIsNotNull(notifier2, "notifier");
        this.apiKey = str;
        this.eventFile = null;
        this.event = event2;
        this.notifier = notifier2;
    }
}
