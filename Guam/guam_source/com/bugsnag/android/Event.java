package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public class Event implements JsonStream.Streamable {
    public final EventInternal impl;
    public final Logger logger;

    public Event(Throwable th, ImmutableConfig immutableConfig, HandledState handledState, Metadata metadata, Logger logger2) {
        this.impl = new EventInternal(th, immutableConfig, handledState, metadata);
        this.logger = logger2;
    }

    public void addMetadata(String str, Map<String, ?> map) {
        if (str != null) {
            EventInternal eventInternal = this.impl;
            if (eventInternal != null) {
                Intrinsics.checkParameterIsNotNull(str, "section");
                Intrinsics.checkParameterIsNotNull(map, "value");
                eventInternal.metadata.addMetadata(str, map);
                return;
            }
            throw null;
        }
        logNull("addMetadata");
    }

    public final void logNull(String str) {
        Logger logger2 = this.logger;
        logger2.e("Invalid null value supplied to config." + str + ", ignoring");
    }

    public void setApp(AppWithState appWithState) {
        EventInternal eventInternal = this.impl;
        if (eventInternal != null) {
            Intrinsics.checkParameterIsNotNull(appWithState, "<set-?>");
            eventInternal.app = appWithState;
            return;
        }
        throw null;
    }

    public void setDevice(DeviceWithState deviceWithState) {
        EventInternal eventInternal = this.impl;
        if (eventInternal != null) {
            Intrinsics.checkParameterIsNotNull(deviceWithState, "<set-?>");
            eventInternal.device = deviceWithState;
            return;
        }
        throw null;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }

    public void addMetadata(String str, String str2, Object obj) {
        EventInternal eventInternal = this.impl;
        if (eventInternal != null) {
            Intrinsics.checkParameterIsNotNull(str, "section");
            Intrinsics.checkParameterIsNotNull(str2, "key");
            eventInternal.metadata.addMetadata(str, str2, obj);
            return;
        }
        throw null;
    }
}
