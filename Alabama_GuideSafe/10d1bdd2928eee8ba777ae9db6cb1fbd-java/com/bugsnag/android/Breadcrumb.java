package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public class Breadcrumb implements JsonStream.Streamable {
    public final BreadcrumbInternal impl;
    public final Logger logger;

    public Breadcrumb(String str, Logger logger2) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.impl = new BreadcrumbInternal(str, BreadcrumbType.MANUAL, new LinkedHashMap(), new Date());
        this.logger = logger2;
    }

    private void logNull(String str) {
        Logger logger2 = this.logger;
        logger2.e("Invalid null value supplied to breadcrumb." + str + ", ignoring");
    }

    public String getMessage() {
        return this.impl.message;
    }

    public Map<String, Object> getMetadata() {
        return this.impl.metadata;
    }

    public Date getTimestamp() {
        return this.impl.timestamp;
    }

    public BreadcrumbType getType() {
        return this.impl.type;
    }

    public void setMessage(String str) {
        if (str != null) {
            BreadcrumbInternal breadcrumbInternal = this.impl;
            if (breadcrumbInternal != null) {
                Intrinsics.checkParameterIsNotNull(str, "<set-?>");
                breadcrumbInternal.message = str;
                return;
            }
            throw null;
        }
        logNull("message");
    }

    public void setMetadata(Map<String, Object> map) {
        this.impl.metadata = map;
    }

    public void setType(BreadcrumbType breadcrumbType) {
        if (breadcrumbType != null) {
            BreadcrumbInternal breadcrumbInternal = this.impl;
            if (breadcrumbInternal != null) {
                Intrinsics.checkParameterIsNotNull(breadcrumbType, "<set-?>");
                breadcrumbInternal.type = breadcrumbType;
                return;
            }
            throw null;
        }
        logNull("type");
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        this.impl.toStream(jsonStream);
    }

    public Breadcrumb(String str, BreadcrumbType breadcrumbType, Map<String, Object> map, Date date, Logger logger2) {
        this.impl = new BreadcrumbInternal(str, breadcrumbType, map, date);
        this.logger = logger2;
    }
}
