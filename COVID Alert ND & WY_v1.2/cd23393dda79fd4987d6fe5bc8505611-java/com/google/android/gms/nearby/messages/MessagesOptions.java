package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public class MessagesOptions implements Api.ApiOptions.Optional {
    public final String zza;
    public final boolean zzb;
    public final int zzc;
    public final String zzd;
    public final String zze;

    private MessagesOptions(Builder builder) {
        this.zza = null;
        this.zzb = false;
        this.zzc = builder.zza;
        this.zzd = null;
        this.zze = null;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
    public static class Builder {
        private int zza = -1;

        public Builder setPermissions(int i) {
            this.zza = i;
            return this;
        }

        public MessagesOptions build() {
            return new MessagesOptions(this);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessagesOptions)) {
            return false;
        }
        return Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null) && this.zzc == ((MessagesOptions) obj).zzc;
    }

    public int hashCode() {
        return Objects.hashCode(null, false, null, null, Integer.valueOf(this.zzc));
    }
}
