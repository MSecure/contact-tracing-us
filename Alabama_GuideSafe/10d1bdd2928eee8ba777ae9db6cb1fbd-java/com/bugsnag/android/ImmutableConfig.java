package com.bugsnag.android;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImmutableConfig.kt */
public final class ImmutableConfig {
    public final String apiKey;
    public final String appType;
    public final String appVersion;
    public final boolean autoDetectErrors;
    public final boolean autoTrackSessions;
    public final String buildUuid;
    public final Delivery delivery;
    public final Collection<String> discardClasses;
    public final Set<BreadcrumbType> enabledBreadcrumbTypes;
    public final ErrorTypes enabledErrorTypes;
    public final Collection<String> enabledReleaseStages;
    public final EndpointConfiguration endpoints;
    public final long launchCrashThresholdMs;
    public final Logger logger;
    public final int maxBreadcrumbs;
    public final boolean persistUser;
    public final Collection<String> projectPackages;
    public final String releaseStage;
    public final ThreadSendPolicy sendThreads;
    public final Integer versionCode;

    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: java.util.Set<? extends com.bugsnag.android.BreadcrumbType> */
    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableConfig(String str, boolean z, ErrorTypes errorTypes, boolean z2, ThreadSendPolicy threadSendPolicy, Collection<String> collection, Collection<String> collection2, Collection<String> collection3, Set<? extends BreadcrumbType> set, String str2, String str3, String str4, Integer num, String str5, Delivery delivery2, EndpointConfiguration endpointConfiguration, boolean z3, long j, Logger logger2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "apiKey");
        Intrinsics.checkParameterIsNotNull(errorTypes, "enabledErrorTypes");
        Intrinsics.checkParameterIsNotNull(threadSendPolicy, "sendThreads");
        Intrinsics.checkParameterIsNotNull(collection, "discardClasses");
        Intrinsics.checkParameterIsNotNull(collection3, "projectPackages");
        Intrinsics.checkParameterIsNotNull(delivery2, "delivery");
        Intrinsics.checkParameterIsNotNull(endpointConfiguration, "endpoints");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.apiKey = str;
        this.autoDetectErrors = z;
        this.enabledErrorTypes = errorTypes;
        this.autoTrackSessions = z2;
        this.sendThreads = threadSendPolicy;
        this.discardClasses = collection;
        this.enabledReleaseStages = collection2;
        this.projectPackages = collection3;
        this.enabledBreadcrumbTypes = set;
        this.releaseStage = str2;
        this.buildUuid = str3;
        this.appVersion = str4;
        this.versionCode = num;
        this.appType = str5;
        this.delivery = delivery2;
        this.endpoints = endpointConfiguration;
        this.persistUser = z3;
        this.launchCrashThresholdMs = j;
        this.logger = logger2;
        this.maxBreadcrumbs = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImmutableConfig)) {
            return false;
        }
        ImmutableConfig immutableConfig = (ImmutableConfig) obj;
        return Intrinsics.areEqual(this.apiKey, immutableConfig.apiKey) && this.autoDetectErrors == immutableConfig.autoDetectErrors && Intrinsics.areEqual(this.enabledErrorTypes, immutableConfig.enabledErrorTypes) && this.autoTrackSessions == immutableConfig.autoTrackSessions && Intrinsics.areEqual(this.sendThreads, immutableConfig.sendThreads) && Intrinsics.areEqual(this.discardClasses, immutableConfig.discardClasses) && Intrinsics.areEqual(this.enabledReleaseStages, immutableConfig.enabledReleaseStages) && Intrinsics.areEqual(this.projectPackages, immutableConfig.projectPackages) && Intrinsics.areEqual(this.enabledBreadcrumbTypes, immutableConfig.enabledBreadcrumbTypes) && Intrinsics.areEqual(this.releaseStage, immutableConfig.releaseStage) && Intrinsics.areEqual(this.buildUuid, immutableConfig.buildUuid) && Intrinsics.areEqual(this.appVersion, immutableConfig.appVersion) && Intrinsics.areEqual(this.versionCode, immutableConfig.versionCode) && Intrinsics.areEqual(this.appType, immutableConfig.appType) && Intrinsics.areEqual(this.delivery, immutableConfig.delivery) && Intrinsics.areEqual(this.endpoints, immutableConfig.endpoints) && this.persistUser == immutableConfig.persistUser && this.launchCrashThresholdMs == immutableConfig.launchCrashThresholdMs && Intrinsics.areEqual(this.logger, immutableConfig.logger) && this.maxBreadcrumbs == immutableConfig.maxBreadcrumbs;
    }

    public final DeliveryParams getErrorApiDeliveryParams() {
        String str = this.endpoints.notify;
        HashMap hashMap = new HashMap();
        hashMap.put("Bugsnag-Payload-Version", "4.0");
        hashMap.put("Bugsnag-Api-Key", this.apiKey);
        String iso8601 = DateUtils.toIso8601(new Date());
        Intrinsics.checkExpressionValueIsNotNull(iso8601, "DateUtils.toIso8601(Date())");
        hashMap.put("Bugsnag-Sent-At", iso8601);
        return new DeliveryParams(str, hashMap);
    }

    public int hashCode() {
        String str = this.apiKey;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        boolean z = this.autoDetectErrors;
        int i2 = 1;
        if (z) {
            z = true;
        }
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = (hashCode + i3) * 31;
        ErrorTypes errorTypes = this.enabledErrorTypes;
        int hashCode2 = (i6 + (errorTypes != null ? errorTypes.hashCode() : 0)) * 31;
        boolean z2 = this.autoTrackSessions;
        if (z2) {
            z2 = true;
        }
        int i7 = z2 ? 1 : 0;
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = (hashCode2 + i7) * 31;
        ThreadSendPolicy threadSendPolicy = this.sendThreads;
        int hashCode3 = (i10 + (threadSendPolicy != null ? threadSendPolicy.hashCode() : 0)) * 31;
        Collection<String> collection = this.discardClasses;
        int hashCode4 = (hashCode3 + (collection != null ? collection.hashCode() : 0)) * 31;
        Collection<String> collection2 = this.enabledReleaseStages;
        int hashCode5 = (hashCode4 + (collection2 != null ? collection2.hashCode() : 0)) * 31;
        Collection<String> collection3 = this.projectPackages;
        int hashCode6 = (hashCode5 + (collection3 != null ? collection3.hashCode() : 0)) * 31;
        Set<BreadcrumbType> set = this.enabledBreadcrumbTypes;
        int hashCode7 = (hashCode6 + (set != null ? set.hashCode() : 0)) * 31;
        String str2 = this.releaseStage;
        int hashCode8 = (hashCode7 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.buildUuid;
        int hashCode9 = (hashCode8 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.appVersion;
        int hashCode10 = (hashCode9 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num = this.versionCode;
        int hashCode11 = (hashCode10 + (num != null ? num.hashCode() : 0)) * 31;
        String str5 = this.appType;
        int hashCode12 = (hashCode11 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Delivery delivery2 = this.delivery;
        int hashCode13 = (hashCode12 + (delivery2 != null ? delivery2.hashCode() : 0)) * 31;
        EndpointConfiguration endpointConfiguration = this.endpoints;
        int hashCode14 = (hashCode13 + (endpointConfiguration != null ? endpointConfiguration.hashCode() : 0)) * 31;
        boolean z3 = this.persistUser;
        if (!z3) {
            i2 = z3 ? 1 : 0;
        }
        long j = this.launchCrashThresholdMs;
        int i11 = (((hashCode14 + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
        Logger logger2 = this.logger;
        if (logger2 != null) {
            i = logger2.hashCode();
        }
        return ((i11 + i) * 31) + this.maxBreadcrumbs;
    }

    public final boolean shouldNotifyForReleaseStage() {
        Collection<String> collection = this.enabledReleaseStages;
        if (collection != null) {
            String str = this.releaseStage;
            Intrinsics.checkNotNullParameter(collection, "$this$contains");
            return collection.contains(str);
        }
    }

    public final boolean shouldRecordBreadcrumbType(BreadcrumbType breadcrumbType) {
        Intrinsics.checkParameterIsNotNull(breadcrumbType, "type");
        Set<BreadcrumbType> set = this.enabledBreadcrumbTypes;
        return set == null || set.contains(breadcrumbType);
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("ImmutableConfig(apiKey=");
        outline17.append(this.apiKey);
        outline17.append(", autoDetectErrors=");
        outline17.append(this.autoDetectErrors);
        outline17.append(", enabledErrorTypes=");
        outline17.append(this.enabledErrorTypes);
        outline17.append(", autoTrackSessions=");
        outline17.append(this.autoTrackSessions);
        outline17.append(", sendThreads=");
        outline17.append(this.sendThreads);
        outline17.append(", discardClasses=");
        outline17.append(this.discardClasses);
        outline17.append(", enabledReleaseStages=");
        outline17.append(this.enabledReleaseStages);
        outline17.append(", projectPackages=");
        outline17.append(this.projectPackages);
        outline17.append(", enabledBreadcrumbTypes=");
        outline17.append(this.enabledBreadcrumbTypes);
        outline17.append(", releaseStage=");
        outline17.append(this.releaseStage);
        outline17.append(", buildUuid=");
        outline17.append(this.buildUuid);
        outline17.append(", appVersion=");
        outline17.append(this.appVersion);
        outline17.append(", versionCode=");
        outline17.append(this.versionCode);
        outline17.append(", appType=");
        outline17.append(this.appType);
        outline17.append(", delivery=");
        outline17.append(this.delivery);
        outline17.append(", endpoints=");
        outline17.append(this.endpoints);
        outline17.append(", persistUser=");
        outline17.append(this.persistUser);
        outline17.append(", launchCrashThresholdMs=");
        outline17.append(this.launchCrashThresholdMs);
        outline17.append(", logger=");
        outline17.append(this.logger);
        outline17.append(", maxBreadcrumbs=");
        return GeneratedOutlineSupport.outline13(outline17, this.maxBreadcrumbs, ")");
    }
}
