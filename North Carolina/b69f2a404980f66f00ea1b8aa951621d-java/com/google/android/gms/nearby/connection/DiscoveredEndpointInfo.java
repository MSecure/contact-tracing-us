package com.google.android.gms.nearby.connection;

import android.bluetooth.BluetoothDevice;

public final class DiscoveredEndpointInfo {
    public final String zza;
    public final String zzb;
    public final BluetoothDevice zzc;
    public final byte[] zzd;

    public static class zza {
        public String zza;
        public String zzb;
        public BluetoothDevice zzc;
        public byte[] zzd;

        public final zza zza(BluetoothDevice bluetoothDevice) {
            this.zzc = bluetoothDevice;
            this.zzb = "__UNRECOGNIZED_BLUETOOTH_DEVICE__";
            this.zzd = "__UNRECOGNIZED_BLUETOOTH_DEVICE__".getBytes();
            return this;
        }

        public final zza zza(String str) {
            this.zza = str;
            return this;
        }

        public final zza zza(byte[] bArr) {
            this.zzd = bArr;
            return this;
        }

        public final DiscoveredEndpointInfo zza() {
            return new DiscoveredEndpointInfo(this.zza, this.zzb, this.zzc, this.zzd);
        }

        public final zza zzb(String str) {
            this.zzb = str;
            return this;
        }
    }

    @Deprecated
    public DiscoveredEndpointInfo(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
        this.zzd = str2.getBytes();
        this.zzc = null;
    }

    public DiscoveredEndpointInfo(String str, String str2, BluetoothDevice bluetoothDevice, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bluetoothDevice;
        this.zzd = bArr;
    }

    public final byte[] getEndpointInfo() {
        return this.zzd;
    }

    public final String getEndpointName() {
        return this.zzb;
    }

    public final String getServiceId() {
        return this.zza;
    }
}
