package com.bugsnag.android;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PluginClient.kt */
public final class PluginClient {
    public final Logger logger;
    public final Set<Plugin> plugins;

    public PluginClient(Set<? extends Plugin> set, ImmutableConfig immutableConfig, Logger logger2) {
        Plugin instantiatePlugin;
        Plugin instantiatePlugin2;
        Intrinsics.checkParameterIsNotNull(set, "userPlugins");
        Intrinsics.checkParameterIsNotNull(immutableConfig, "immutableConfig");
        Intrinsics.checkParameterIsNotNull(logger2, "logger");
        this.logger = logger2;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(set);
        if (immutableConfig.enabledErrorTypes.ndkCrashes && (instantiatePlugin2 = instantiatePlugin("com.bugsnag.android.NdkPlugin")) != null) {
            linkedHashSet.add(instantiatePlugin2);
        }
        if (immutableConfig.enabledErrorTypes.anrs && (instantiatePlugin = instantiatePlugin("com.bugsnag.android.AnrPlugin")) != null) {
            linkedHashSet.add(instantiatePlugin);
        }
        Plugin instantiatePlugin3 = instantiatePlugin("com.bugsnag.android.BugsnagReactNativePlugin");
        if (instantiatePlugin3 != null) {
            linkedHashSet.add(instantiatePlugin3);
        }
        this.plugins = CollectionsKt__CollectionsKt.toSet(linkedHashSet);
    }

    public final Plugin instantiatePlugin(String str) {
        try {
            Object newInstance = Class.forName(str).newInstance();
            if (newInstance != null) {
                return (Plugin) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.bugsnag.android.Plugin");
        } catch (ClassNotFoundException unused) {
            Logger logger2 = this.logger;
            logger2.d("Plugin '" + str + "' is not on the classpath - functionality will not be enabled.");
            return null;
        } catch (Throwable th) {
            Logger logger3 = this.logger;
            logger3.e("Failed to load plugin '" + str + '\'', th);
            return null;
        }
    }
}
