package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.net.Uri;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public abstract class GmsClientSupervisor {
    public static final Object zzb = new Object();
    public static GmsClientSupervisor zzc;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    public static final class zza {
        public static final Uri zzf = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();
        public final String zza;
        public final String zzb;
        public final ComponentName zzc = null;
        public final int zzd;
        public final boolean zze;

        public zza(String str, String str2, int i, boolean z) {
            ReactYogaConfigProvider.checkNotEmpty(str);
            this.zza = str;
            ReactYogaConfigProvider.checkNotEmpty(str2);
            this.zzb = str2;
            this.zzd = i;
            this.zze = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza2 = (zza) obj;
            return ReactYogaConfigProvider.equal(this.zza, zza2.zza) && ReactYogaConfigProvider.equal(this.zzb, zza2.zzb) && ReactYogaConfigProvider.equal(this.zzc, zza2.zzc) && this.zzd == zza2.zzd && this.zze == zza2.zze;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, Integer.valueOf(this.zzd), Boolean.valueOf(this.zze)});
        }

        public final String toString() {
            String str = this.zza;
            if (str != null) {
                return str;
            }
            ReactYogaConfigProvider.checkNotNull(this.zzc);
            return this.zzc.flattenToString();
        }
    }

    @RecentlyNonNull
    public static int getDefaultBindFlags() {
        return 4225;
    }

    public final void zza(@RecentlyNonNull String str, @RecentlyNonNull String str2, @RecentlyNonNull int i, @RecentlyNonNull ServiceConnection serviceConnection, @RecentlyNonNull String str3, @RecentlyNonNull boolean z) {
        zza zza2 = new zza(str, str2, i, z);
        zzg zzg = (zzg) this;
        ReactYogaConfigProvider.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (zzg.zza) {
            zzi zzi = zzg.zza.get(zza2);
            if (zzi == null) {
                String valueOf = String.valueOf(zza2);
                StringBuilder sb = new StringBuilder(valueOf.length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (zzi.zza.containsKey(serviceConnection)) {
                zzi.zza.remove(serviceConnection);
                if (zzi.zza.isEmpty()) {
                    zzg.zzc.sendMessageDelayed(zzg.zzc.obtainMessage(0, zza2), zzg.zze);
                }
            } else {
                String valueOf2 = String.valueOf(zza2);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            }
        }
    }

    public abstract boolean zza(zza zza2, ServiceConnection serviceConnection, String str);
}
