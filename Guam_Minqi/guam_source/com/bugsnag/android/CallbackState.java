package com.bugsnag.android;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CallbackState.kt */
public final class CallbackState {
    public final Collection<OnBreadcrumbCallback> onBreadcrumbTasks;
    public final Collection<OnErrorCallback> onErrorTasks;
    public final Collection<OnSessionCallback> onSessionTasks;

    public CallbackState() {
        this(null, null, null, 7);
    }

    public CallbackState(Collection<OnErrorCallback> collection, Collection<OnBreadcrumbCallback> collection2, Collection<OnSessionCallback> collection3) {
        Intrinsics.checkParameterIsNotNull(collection, "onErrorTasks");
        Intrinsics.checkParameterIsNotNull(collection2, "onBreadcrumbTasks");
        Intrinsics.checkParameterIsNotNull(collection3, "onSessionTasks");
        this.onErrorTasks = collection;
        this.onBreadcrumbTasks = collection2;
        this.onSessionTasks = collection3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallbackState)) {
            return false;
        }
        CallbackState callbackState = (CallbackState) obj;
        return Intrinsics.areEqual(this.onErrorTasks, callbackState.onErrorTasks) && Intrinsics.areEqual(this.onBreadcrumbTasks, callbackState.onBreadcrumbTasks) && Intrinsics.areEqual(this.onSessionTasks, callbackState.onSessionTasks);
    }

    public int hashCode() {
        Collection<OnErrorCallback> collection = this.onErrorTasks;
        int i = 0;
        int hashCode = (collection != null ? collection.hashCode() : 0) * 31;
        Collection<OnBreadcrumbCallback> collection2 = this.onBreadcrumbTasks;
        int hashCode2 = (hashCode + (collection2 != null ? collection2.hashCode() : 0)) * 31;
        Collection<OnSessionCallback> collection3 = this.onSessionTasks;
        if (collection3 != null) {
            i = collection3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        StringBuilder outline15 = GeneratedOutlineSupport.outline15("CallbackState(onErrorTasks=");
        outline15.append(this.onErrorTasks);
        outline15.append(", onBreadcrumbTasks=");
        outline15.append(this.onBreadcrumbTasks);
        outline15.append(", onSessionTasks=");
        outline15.append(this.onSessionTasks);
        outline15.append(")");
        return outline15.toString();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallbackState(Collection collection, Collection collection2, Collection collection3, int i) {
        this((i & 1) != 0 ? new ConcurrentLinkedQueue() : null, (i & 2) != 0 ? new ConcurrentLinkedQueue() : null, (i & 4) != 0 ? new ConcurrentLinkedQueue() : null);
    }
}
