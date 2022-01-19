package com.bugsnag.android;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.horcrux.svg.PathParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.sequences.SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1;
import kotlin.text.DelimitedRangesSequence;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4;

/* compiled from: ManifestConfigLoader.kt */
public final class ManifestConfigLoader {
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:23:0x00c0 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    public final Set<String> getStrArray(Bundle bundle, String str, Set<String> set) {
        ?? r3;
        String string = bundle.getString(str);
        if (string != null) {
            String[] strArr = {","};
            Intrinsics.checkNotNullParameter(string, "$this$split");
            Intrinsics.checkNotNullParameter(strArr, "delimiters");
            String str2 = strArr[0];
            if (!(str2.length() == 0)) {
                int indexOf = StringsKt__StringsKt.indexOf(string, str2, 0, false);
                if (indexOf != -1) {
                    r3 = new ArrayList(10);
                    int i = 0;
                    do {
                        r3.add(string.subSequence(i, indexOf).toString());
                        i = str2.length() + indexOf;
                        indexOf = StringsKt__StringsKt.indexOf(string, str2, i, false);
                    } while (indexOf != -1);
                    r3.add(string.subSequence(i, string.length()).toString());
                } else {
                    r3 = PathParser.listOf(string.toString());
                }
            } else {
                DelimitedRangesSequence delimitedRangesSequence = new DelimitedRangesSequence(string, 0, 0, new StringsKt__StringsKt$rangesDelimitedBy$4(PathParser.asList(strArr), false));
                Intrinsics.checkNotNullParameter(delimitedRangesSequence, "$this$asIterable");
                SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1 = new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(delimitedRangesSequence);
                r3 = new ArrayList(PathParser.collectionSizeOrDefault(sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1, 10));
                Iterator it = sequencesKt___SequencesKt$asIterable$$inlined$Iterable$1.iterator();
                while (it.hasNext()) {
                    IntRange intRange = (IntRange) it.next();
                    Intrinsics.checkNotNullParameter(string, "$this$substring");
                    Intrinsics.checkNotNullParameter(intRange, "range");
                    r3.add(string.subSequence(Integer.valueOf(intRange.first).intValue(), Integer.valueOf(intRange.last).intValue() + 1).toString());
                }
            }
        } else {
            r3 = 0;
        }
        return r3 == 0 ? set : CollectionsKt__CollectionsKt.toSet(r3);
    }

    public final Configuration load$bugsnag_android_core_release(Bundle bundle, String str) {
        ThreadSendPolicy threadSendPolicy;
        if (str == null) {
            str = bundle != null ? bundle.getString("com.bugsnag.android.API_KEY") : null;
        }
        if (str != null) {
            Configuration configuration = new Configuration(str);
            if (bundle != null) {
                boolean z = bundle.getBoolean("com.bugsnag.android.AUTO_TRACK_SESSIONS", configuration.impl.autoTrackSessions);
                ConfigInternal configInternal = configuration.impl;
                configInternal.autoTrackSessions = z;
                boolean z2 = bundle.getBoolean("com.bugsnag.android.AUTO_DETECT_ERRORS", configInternal.autoDetectErrors);
                ConfigInternal configInternal2 = configuration.impl;
                configInternal2.autoDetectErrors = z2;
                configuration.impl.persistUser = bundle.getBoolean("com.bugsnag.android.PERSIST_USER", configInternal2.persistUser);
                String string = bundle.getString("com.bugsnag.android.SEND_THREADS");
                if (string != null) {
                    Intrinsics.checkParameterIsNotNull(string, "str");
                    ThreadSendPolicy[] values = ThreadSendPolicy.values();
                    int length = values.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            threadSendPolicy = null;
                            break;
                        }
                        threadSendPolicy = values[i];
                        if (Intrinsics.areEqual(threadSendPolicy.name(), string)) {
                            break;
                        }
                        i++;
                    }
                    if (threadSendPolicy == null) {
                        threadSendPolicy = ThreadSendPolicy.ALWAYS;
                    }
                    ConfigInternal configInternal3 = configuration.impl;
                    if (configInternal3 != null) {
                        Intrinsics.checkParameterIsNotNull(threadSendPolicy, "<set-?>");
                        configInternal3.sendThreads = threadSendPolicy;
                    } else {
                        throw null;
                    }
                }
                if (bundle.containsKey("com.bugsnag.android.ENDPOINT_NOTIFY")) {
                    String string2 = bundle.getString("com.bugsnag.android.ENDPOINT_NOTIFY", configuration.impl.endpoints.notify);
                    String string3 = bundle.getString("com.bugsnag.android.ENDPOINT_SESSIONS", configuration.impl.endpoints.sessions);
                    Intrinsics.checkExpressionValueIsNotNull(string2, "endpoint");
                    Intrinsics.checkExpressionValueIsNotNull(string3, "sessionEndpoint");
                    EndpointConfiguration endpointConfiguration = new EndpointConfiguration(string2, string3);
                    ConfigInternal configInternal4 = configuration.impl;
                    if (configInternal4 != null) {
                        Intrinsics.checkParameterIsNotNull(endpointConfiguration, "<set-?>");
                        configInternal4.endpoints = endpointConfiguration;
                    } else {
                        throw null;
                    }
                }
                String string4 = bundle.getString("com.bugsnag.android.RELEASE_STAGE", configuration.impl.releaseStage);
                ConfigInternal configInternal5 = configuration.impl;
                configInternal5.releaseStage = string4;
                String string5 = bundle.getString("com.bugsnag.android.APP_VERSION", configInternal5.appVersion);
                ConfigInternal configInternal6 = configuration.impl;
                configInternal6.appVersion = string5;
                configuration.impl.appType = bundle.getString("com.bugsnag.android.APP_TYPE", configInternal6.appType);
                if (bundle.containsKey("com.bugsnag.android.VERSION_CODE")) {
                    configuration.impl.versionCode = Integer.valueOf(bundle.getInt("com.bugsnag.android.VERSION_CODE"));
                }
                if (bundle.containsKey("com.bugsnag.android.ENABLED_RELEASE_STAGES")) {
                    configuration.impl.enabledReleaseStages = getStrArray(bundle, "com.bugsnag.android.ENABLED_RELEASE_STAGES", configuration.impl.enabledReleaseStages);
                }
                Set<String> strArray = getStrArray(bundle, "com.bugsnag.android.DISCARD_CLASSES", configuration.impl.discardClasses);
                if (strArray == null) {
                    strArray = EmptySet.INSTANCE;
                }
                if (AppCompatDelegateImpl.ConfigurationImplApi17.containsNullElements(strArray)) {
                    configuration.logNull("discardClasses");
                } else {
                    ConfigInternal configInternal7 = configuration.impl;
                    if (configInternal7 != null) {
                        Intrinsics.checkParameterIsNotNull(strArray, "<set-?>");
                        configInternal7.discardClasses = strArray;
                    } else {
                        throw null;
                    }
                }
                Set<String> strArray2 = getStrArray(bundle, "com.bugsnag.android.PROJECT_PACKAGES", EmptySet.INSTANCE);
                if (strArray2 == null) {
                    strArray2 = EmptySet.INSTANCE;
                }
                configuration.setProjectPackages(strArray2);
                Set<String> strArray3 = getStrArray(bundle, "com.bugsnag.android.REDACTED_KEYS", configuration.impl.redactedKeys);
                if (strArray3 == null) {
                    strArray3 = EmptySet.INSTANCE;
                }
                if (AppCompatDelegateImpl.ConfigurationImplApi17.containsNullElements(strArray3)) {
                    configuration.logNull("redactedKeys");
                } else {
                    ConfigInternal configInternal8 = configuration.impl;
                    if (configInternal8 != null) {
                        Intrinsics.checkParameterIsNotNull(strArray3, "value");
                        configInternal8.metadataState.metadata.setRedactedKeys(strArray3);
                        configInternal8.redactedKeys = strArray3;
                    } else {
                        throw null;
                    }
                }
                int i2 = bundle.getInt("com.bugsnag.android.MAX_BREADCRUMBS", configuration.impl.maxBreadcrumbs);
                if (i2 < 0 || i2 > 100) {
                    configuration.impl.logger.e(String.format(Locale.US, "Invalid configuration value detected. Option maxBreadcrumbs should be an integer between 0-100. Supplied value is %d", Integer.valueOf(i2)));
                } else {
                    configuration.impl.maxBreadcrumbs = i2;
                }
                long j = (long) bundle.getInt("com.bugsnag.android.LAUNCH_CRASH_THRESHOLD_MS", (int) configuration.impl.launchCrashThresholdMs);
                if (j > 0) {
                    configuration.impl.launchCrashThresholdMs = j;
                } else {
                    configuration.impl.logger.e(String.format(Locale.US, "Invalid configuration value detected. Option launchCrashThresholdMs should be a positive long value.Supplied value is %d", Long.valueOf(j)));
                }
            }
            return configuration;
        }
        throw new IllegalArgumentException("No Bugsnag API key set");
    }
}
