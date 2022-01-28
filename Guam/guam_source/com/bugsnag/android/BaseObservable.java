package com.bugsnag.android;

import java.util.Observable;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseObservable.kt */
public class BaseObservable extends Observable {
    public final void notifyObservers(StateEvent stateEvent) {
        Intrinsics.checkParameterIsNotNull(stateEvent, "event");
        setChanged();
        super.notifyObservers((Object) stateEvent);
    }
}
