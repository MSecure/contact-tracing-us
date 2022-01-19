package com.bugsnag.android;

import com.bugsnag.android.JsonStream;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: App.kt */
public class App implements JsonStream.Streamable {
    public String binaryArch;
    public String buildUuid;
    public String codeBundleId;
    public String id;
    public String releaseStage;
    public String type;
    public String version;
    public Number versionCode;

    public App(String str, String str2, String str3, String str4, String str5, String str6, String str7, Number number) {
        this.binaryArch = str;
        this.id = str2;
        this.releaseStage = str3;
        this.version = str4;
        this.codeBundleId = str5;
        this.buildUuid = str6;
        this.type = str7;
        this.versionCode = number;
    }

    public void serialiseFields$bugsnag_android_core_release(JsonStream jsonStream) {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.name("binaryArch");
        jsonStream.value(this.binaryArch);
        jsonStream.name("buildUUID");
        jsonStream.value(this.buildUuid);
        jsonStream.name("codeBundleId");
        jsonStream.value(this.codeBundleId);
        jsonStream.name("id");
        jsonStream.value(this.id);
        jsonStream.name("releaseStage");
        jsonStream.value(this.releaseStage);
        jsonStream.name("type");
        jsonStream.value(this.type);
        jsonStream.name("version");
        jsonStream.value(this.version);
        jsonStream.name("versionCode");
        jsonStream.value(this.versionCode);
    }

    @Override // com.bugsnag.android.JsonStream.Streamable
    public void toStream(JsonStream jsonStream) throws IOException {
        Intrinsics.checkParameterIsNotNull(jsonStream, "writer");
        jsonStream.beginObject();
        serialiseFields$bugsnag_android_core_release(jsonStream);
        jsonStream.endObject();
    }

    public App(ImmutableConfig immutableConfig, String str, String str2, String str3, String str4, String str5) {
        Intrinsics.checkParameterIsNotNull(immutableConfig, "config");
        String str6 = immutableConfig.buildUuid;
        String str7 = immutableConfig.appType;
        Integer num = immutableConfig.versionCode;
        this.binaryArch = str;
        this.id = str2;
        this.releaseStage = str3;
        this.version = str4;
        this.codeBundleId = str5;
        this.buildUuid = str6;
        this.type = str7;
        this.versionCode = num;
    }
}
