package com.bugsnag.android;

import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public class Configuration {
    public final ConfigInternal impl;

    public Configuration(String str) {
        if (!AppCompatDelegateImpl.ConfigurationImplApi17.isEmpty(str)) {
            if (!str.matches("[A-Fa-f0-9]{32}")) {
                String format = String.format("Invalid configuration. apiKey should be a 32-character hexademical string, got \"%s\"", str);
                Intrinsics.checkParameterIsNotNull(format, "msg");
                Log.w("Bugsnag", format);
            }
            this.impl = new ConfigInternal(str);
            return;
        }
        throw new IllegalArgumentException("No Bugsnag API Key set");
    }

    public final void logNull(String str) {
        Logger logger = this.impl.logger;
        logger.e("Invalid null value supplied to config." + str + ", ignoring");
    }

    public void setProjectPackages(Set<String> set) {
        if (AppCompatDelegateImpl.ConfigurationImplApi17.containsNullElements(set)) {
            logNull("projectPackages");
            return;
        }
        ConfigInternal configInternal = this.impl;
        if (configInternal != null) {
            Intrinsics.checkParameterIsNotNull(set, "<set-?>");
            configInternal.projectPackages = set;
            return;
        }
        throw null;
    }
}
