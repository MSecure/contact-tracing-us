package org.pathcheck.covidsafepaths.helpers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.Intrinsics;
import org.pathcheck.covidsafepaths.MainActivity;

/* compiled from: BluetoothHelper.kt */
public final class BluetoothHelper$receiver$1 extends BroadcastReceiver {
    public final /* synthetic */ BluetoothHelper this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public BluetoothHelper$receiver$1(BluetoothHelper bluetoothHelper) {
        this.this$0 = bluetoothHelper;
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.bluetooth.adapter.action.STATE_CHANGED", intent.getAction())) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
            if (intExtra == 10) {
                ((MainActivity.AnonymousClass1) this.this$0.callback).onBluetoothUnavailable();
            } else if (intExtra == 12) {
                ((MainActivity.AnonymousClass1) this.this$0.callback).onBluetoothAvailable();
            }
        }
    }
}
