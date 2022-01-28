package com.bugsnag.android;

import android.content.SharedPreferences;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserRepository.kt */
public final class UserRepository {
    public final boolean persist;
    public final SharedPreferences prefs;

    public UserRepository(SharedPreferences sharedPreferences, boolean z) {
        Intrinsics.checkParameterIsNotNull(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.persist = z;
    }
}
