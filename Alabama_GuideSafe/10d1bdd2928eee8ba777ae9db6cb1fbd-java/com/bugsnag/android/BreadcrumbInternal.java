package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Breadcrumb.kt */
public final class BreadcrumbInternal implements JsonStream.Streamable {
    public String message;
    public Map<String, Object> metadata;
    public final Date timestamp;
    public BreadcrumbType type;

    public BreadcrumbInternal(String str, BreadcrumbType breadcrumbType, Map<String, Object> map, Date date) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(breadcrumbType, "type");
        Intrinsics.checkParameterIsNotNull(date, "timestamp");
        this.message = str;
        this.type = breadcrumbType;
        this.metadata = map;
        this.timestamp = date;
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        jsonStream.name("timestamp");
        jsonStream.value(DateUtils.toIso8601(this.timestamp));
        jsonStream.name("name");
        jsonStream.value(this.message);
        jsonStream.name("type");
        jsonStream.value(this.type.toString());
        jsonStream.name("metaData");
        jsonStream.value(this.metadata, true);
        jsonStream.endObject();
    }
}
