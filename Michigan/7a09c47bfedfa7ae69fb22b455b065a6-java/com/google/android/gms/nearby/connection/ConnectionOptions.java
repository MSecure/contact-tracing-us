package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import c.b.a.a.d.m.o.a;
import com.google.android.gms.nearby.messages.internal.zzc;
import java.util.Arrays;
import java.util.Locale;

public final class ConnectionOptions extends a {
    public static final Parcelable.Creator<ConnectionOptions> CREATOR = new zzh();
    public boolean zza;
    public boolean zzb;
    public boolean zzc;
    public boolean zzd;
    public boolean zze;
    public boolean zzf;
    public boolean zzg;
    public boolean zzh;
    public byte[] zzi;
    public boolean zzj;

    public static final class Builder {
        public final ConnectionOptions zza;

        public Builder() {
            this.zza = new ConnectionOptions();
        }

        public Builder(ConnectionOptions connectionOptions) {
            ConnectionOptions connectionOptions2 = new ConnectionOptions();
            this.zza = connectionOptions2;
            connectionOptions2.zza = connectionOptions.zza;
            this.zza.zzb = connectionOptions.zzb;
            this.zza.zzc = connectionOptions.zzc;
            this.zza.zzd = connectionOptions.zzd;
            this.zza.zze = connectionOptions.zze;
            this.zza.zzf = connectionOptions.zzf;
            this.zza.zzg = connectionOptions.zzg;
            this.zza.zzh = connectionOptions.zzh;
            this.zza.zzi = connectionOptions.zzi;
            this.zza.zzj = connectionOptions.zzj;
        }

        public final ConnectionOptions build() {
            return this.zza;
        }

        public final Builder setLowPower(boolean z) {
            this.zza.zza = z;
            return this;
        }
    }

    public ConnectionOptions() {
        this.zza = false;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
        this.zzh = true;
        this.zzj = false;
    }

    public ConnectionOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, byte[] bArr, boolean z9) {
        this.zza = false;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
        this.zzh = true;
        this.zzj = false;
        this.zza = z;
        this.zzb = z2;
        this.zzc = z3;
        this.zzd = z4;
        this.zze = z5;
        this.zzf = z6;
        this.zzg = z7;
        this.zzh = z8;
        this.zzi = bArr;
        this.zzj = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConnectionOptions) {
            ConnectionOptions connectionOptions = (ConnectionOptions) obj;
            return t.j1(Boolean.valueOf(this.zza), Boolean.valueOf(connectionOptions.zza)) && t.j1(Boolean.valueOf(this.zzb), Boolean.valueOf(connectionOptions.zzb)) && t.j1(Boolean.valueOf(this.zzc), Boolean.valueOf(connectionOptions.zzc)) && t.j1(Boolean.valueOf(this.zzd), Boolean.valueOf(connectionOptions.zzd)) && t.j1(Boolean.valueOf(this.zze), Boolean.valueOf(connectionOptions.zze)) && t.j1(Boolean.valueOf(this.zzf), Boolean.valueOf(connectionOptions.zzf)) && t.j1(Boolean.valueOf(this.zzg), Boolean.valueOf(connectionOptions.zzg)) && t.j1(Boolean.valueOf(this.zzh), Boolean.valueOf(connectionOptions.zzh)) && Arrays.equals(this.zzi, connectionOptions.zzi) && t.j1(Boolean.valueOf(this.zzj), Boolean.valueOf(connectionOptions.zzj));
        }
    }

    public final boolean getLowPower() {
        return this.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf), Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)), Boolean.valueOf(this.zzj)});
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[10];
        objArr[0] = Boolean.valueOf(this.zza);
        objArr[1] = Boolean.valueOf(this.zzb);
        objArr[2] = Boolean.valueOf(this.zzc);
        objArr[3] = Boolean.valueOf(this.zzd);
        objArr[4] = Boolean.valueOf(this.zze);
        objArr[5] = Boolean.valueOf(this.zzf);
        objArr[6] = Boolean.valueOf(this.zzg);
        objArr[7] = Boolean.valueOf(this.zzh);
        byte[] bArr = this.zzi;
        objArr[8] = bArr == null ? null : zzc.zza(bArr);
        objArr[9] = Boolean.valueOf(this.zzj);
        return String.format(locale, "ConnectionOptions{lowPower: %s, enableBluetooth: %s, enableBle: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableWifiHotspot: %s, enableWifiDirect: %s, remoteBluetoothMacAddress: %s, enableWebRtc: %s}", objArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int m = t.m(parcel);
        t.j3(parcel, 1, getLowPower());
        t.j3(parcel, 2, this.zzb);
        t.j3(parcel, 3, this.zzc);
        t.j3(parcel, 4, this.zzd);
        t.j3(parcel, 5, this.zze);
        t.j3(parcel, 6, this.zzf);
        t.j3(parcel, 7, this.zzg);
        t.j3(parcel, 8, this.zzh);
        t.l3(parcel, 9, this.zzi, false);
        t.j3(parcel, 10, this.zzj);
        t.w4(parcel, m);
    }
}
