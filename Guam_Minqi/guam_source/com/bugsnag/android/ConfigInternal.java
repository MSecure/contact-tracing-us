package com.bugsnag.android;

import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.horcrux.svg.PathParser;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConfigInternal.kt */
public final class ConfigInternal {
    public String apiKey;
    public String appType = "android";
    public String appVersion;
    public boolean autoDetectErrors = true;
    public boolean autoTrackSessions = true;
    public final CallbackState callbackState = new CallbackState(null, null, null, 7);
    public Delivery delivery;
    public Set<String> discardClasses = EmptySet.INSTANCE;
    public Set<? extends BreadcrumbType> enabledBreadcrumbTypes;
    public ErrorTypes enabledErrorTypes = new ErrorTypes(true, true, true, true);
    public Set<String> enabledReleaseStages;
    public EndpointConfiguration endpoints = new EndpointConfiguration(null, null, 3);
    public long launchCrashThresholdMs = WebsocketJavaScriptExecutor.CONNECT_TIMEOUT_MS;
    public Logger logger = DebugLogger.INSTANCE;
    public int maxBreadcrumbs = 25;
    public final MetadataState metadataState = new MetadataState(null, 1);
    public boolean persistUser;
    public final Set<Plugin> plugins;
    public Set<String> projectPackages;
    public Set<String> redactedKeys = this.metadataState.metadata.redactedKeys;
    public String releaseStage;
    public ThreadSendPolicy sendThreads = ThreadSendPolicy.ALWAYS;
    public User user = new User(null, null, null, 7);
    public Integer versionCode = 0;

    public ConfigInternal(String str) {
        Set<? extends BreadcrumbType> set;
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        this.apiKey = str;
        BreadcrumbType[] values = BreadcrumbType.values();
        Intrinsics.checkNotNullParameter(values, "$this$toSet");
        int length = values.length;
        if (length == 0) {
            set = EmptySet.INSTANCE;
        } else if (length != 1) {
            set = new LinkedHashSet<>(PathParser.mapCapacity(values.length));
            PathParser.toCollection(values, set);
        } else {
            set = PathParser.setOf(values[0]);
        }
        this.enabledBreadcrumbTypes = set;
        this.projectPackages = EmptySet.INSTANCE;
        this.plugins = new LinkedHashSet();
    }
}
