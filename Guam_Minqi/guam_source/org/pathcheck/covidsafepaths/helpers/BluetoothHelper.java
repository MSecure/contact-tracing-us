package org.pathcheck.covidsafepaths.helpers;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BluetoothHelper.kt */
public final class BluetoothHelper {
    public final BluetoothCallback callback;
    public final BluetoothHelper$receiver$1 receiver = new BluetoothHelper$receiver$1(this);

    /* compiled from: BluetoothHelper.kt */
    public interface BluetoothCallback {
    }

    public BluetoothHelper(BluetoothCallback bluetoothCallback) {
        Intrinsics.checkNotNullParameter(bluetoothCallback, "callback");
        this.callback = bluetoothCallback;
    }
}
