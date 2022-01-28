package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class DiscoveredEndpointInfo {
    private final String zza;
    private final String zzb;
    private final BluetoothDevice zzc;
    private final byte[] zzd;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class zza {
        private String zza;
        private String zzb;
        private BluetoothDevice zzc;
        private byte[] zzd;

        public final zza zza(String str) {
            this.zza = str;
            return this;
        }

        public final zza zzb(String str) {
            this.zzb = str;
            return this;
        }

        public final zza zza(BluetoothDevice bluetoothDevice) {
            this.zzc = bluetoothDevice;
            this.zzb = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
            this.zzd = "__UNRECOGNIZED_BLUETOOTH_DEVICE__".getBytes();
            return this;
        }

        public final zza zza(byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        public final DiscoveredEndpointInfo zza() {
            return new DiscoveredEndpointInfo(this.zza, this.zzb, this.zzc, this.zzd);
        }
    }

    @Deprecated
    public DiscoveredEndpointInfo(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = str2.getBytes();
        this.zzc = null;
    }

    private DiscoveredEndpointInfo(String str, String str2, BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bluetoothDevice;
        this.zzd = bArr;
    }

    public final String getServiceId() {
        return this.zza;
    }

    public final String getEndpointName() {
        return this.zzb;
    }
}
