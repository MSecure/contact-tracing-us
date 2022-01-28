package com.google.android.gms.nearby.messages;

import b.b.k.i;
import c.b.a.a.c.k.a;
import java.util.Arrays;

public class MessagesOptions implements a.d {
    public final String zza;
    public final boolean zzb;
    public final int zzc;
    public final String zzd;
    public final String zze;

    public static class Builder {
        public int zza = -1;

        public MessagesOptions build() {
            return new MessagesOptions(this);
        }

        public Builder setPermissions(int i) {
            this.zza = i;
            return this;
        }
    }

    public MessagesOptions(Builder builder) {
        this.zza = null;
        this.zzb = false;
        this.zzc = builder.zza;
        this.zzd = null;
        this.zze = null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MessagesOptions)) {
            return false;
        }
        return i.j.X(null, null) && i.j.X(null, null) && i.j.X(null, null) && this.zzc == ((MessagesOptions) obj).zzc;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{null, Boolean.FALSE, null, null, Integer.valueOf(this.zzc)});
    }
}
