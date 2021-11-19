package com.google.android.gms.nearby.connection;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class ConnectionInfo {
    private final String zza;
    private final String zzb;
    private final byte[] zzc;
    private final boolean zzd;
    private final boolean zze;
    private final byte[] zzf;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class zza {
        private String zza;
        private String zzb;
        private byte[] zzc;
        private boolean zzd;
        private boolean zze;
        private byte[] zzf;

        public final zza zza(String str) {
            this.zza = str;
            return this;
        }

        public final zza zzb(String str) {
            this.zzb = str;
            return this;
        }

        public final zza zza(byte[] bArr) {
            this.zzc = bArr;
            return this;
        }

        public final zza zza(boolean z) {
            this.zzd = z;
            return this;
        }

        public final zza zzb(byte[] bArr) {
            this.zzf = bArr;
            return this;
        }

        public final zza zzb(boolean z) {
            this.zze = z;
            return this;
        }

        public final ConnectionInfo zza() {
            return new ConnectionInfo(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
        }
    }

    @Deprecated
    public ConnectionInfo(String str, String str2, boolean z) {
        this(str, str2, null, z, false, str.getBytes());
    }

    private ConnectionInfo(String str, String str2, byte[] bArr, boolean z, boolean z2, byte[] bArr2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bArr;
        this.zzd = z;
        this.zze = z2;
        this.zzf = bArr2;
    }

    public final String getEndpointName() {
        return this.zza;
    }

    public final String getAuthenticationToken() {
        return this.zzb;
    }

    public final boolean isIncomingConnection() {
        return this.zzd;
    }

    public final boolean isConnectionVerified() {
        return this.zze;
    }

    public final byte[] getEndpointInfo() {
        return this.zzf;
    }
}
