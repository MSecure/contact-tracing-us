package com.bugsnag.android;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActivityBreadcrumbCollector.kt */
public final class ActivityBreadcrumbCollector implements Application.ActivityLifecycleCallbacks {
    public final Function2<String, Map<String, ? extends Object>, Unit> cb;
    public String prevState;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.util.Map<java.lang.String, ? extends java.lang.Object>, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public ActivityBreadcrumbCollector(Function2<? super String, ? super Map<String, ? extends Object>, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "cb");
        this.cb = function2;
    }

    public final String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }

    public final void leaveBreadcrumb(String str, String str2, Boolean bool) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (bool != null) {
            linkedHashMap.put("hasBundle", bool);
        }
        String str3 = this.prevState;
        if (str3 != null) {
            linkedHashMap.put("previous", str3);
        }
        Function2<String, Map<String, ? extends Object>, Unit> function2 = this.cb;
        function2.invoke(str + '#' + str2, linkedHashMap);
        this.prevState = str2;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onCreate()", Boolean.valueOf(bundle != null));
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onDestroy()", null);
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onPause()", null);
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onResume()", null);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onSaveInstanceState()", null);
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onStart()", null);
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        String activityName = getActivityName(activity);
        Intrinsics.checkExpressionValueIsNotNull(activityName, "getActivityName(activity)");
        leaveBreadcrumb(activityName, "onStop()", null);
    }
}
