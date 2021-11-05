package com.google.android.gms.nearby.connection;

public final class ConnectionInfo {
    public final String zza;
    public final String zzb;
    public final byte[] zzc;
    public final boolean zzd;
    public final boolean zze;
    public final byte[] zzf;

    public static class zza {
        public String zza;
        public String zzb;
        public byte[] zzc;
        public boolean zzd;
        public boolean zze;
        public byte[] zzf;

        public final zza zza(String str) {
            this.zza = str;
            return this;
        }

        public final zza zza(boolean z) {
            this.zzd = z;
            return this;
        }

        public final zza zza(byte[] bArr) {
            this.zzc = bArr;
            return this;
        }

        public final ConnectionInfo zza() {
            return new ConnectionInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
        }

        public final zza zzb(String str) {
            this.zzb = str;
            return this;
        }

        public final zza zzb(boolean z) {
            this.zze = z;
            return this;
        }

        public final zza zzb(byte[] bArr) {
            this.zzf = bArr;
            return this;
        }
    }

    @Deprecated
    public ConnectionInfo(String str, String str2, boolean z) {
        this(str, str2, null, z, false, str.getBytes());
    }

    public ConnectionInfo(String str, String str2, byte[] bArr, boolean z, boolean z2, byte[] bArr2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = z2;
        this.zzf = bArr2;
    }

    public final String getAuthenticationToken() {
        return this.zzb;
    }

    public final byte[] getEndpointInfo() {
        return this.zzf;
    }

    public final String getEndpointName() {
        return this.zza;
    }

    public final byte[] getRawAuthenticationToken() {
        return this.zzc;
    }

    public final boolean isConnectionVerified() {
        return this.zze;
    }

    public final boolean isIncomingConnection() {
        return this.zzd;
    }
}
