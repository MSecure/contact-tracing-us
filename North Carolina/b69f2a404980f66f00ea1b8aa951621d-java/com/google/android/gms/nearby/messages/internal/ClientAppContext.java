package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b.b.k.i;
import c.b.a.a.c.l.s.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import java.util.Locale;

public final class ClientAppContext extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zze();
    @Deprecated
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final String zzf;

    public ClientAppContext(int i, String str, String str2, boolean z, int i2, String str3) {
        this.zzb = i;
        i.j.s(str);
        this.zzc = str;
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:");
            str2 = str2.length() != 0 ? "0p:".concat(str2) : new String("0p:");
        }
        this.zzd = str2;
        this.zze = z;
        this.zza = i2;
        this.zzf = str3;
    }

    public ClientAppContext(String str, String str2, boolean z, String str3, int i) {
        this(1, str, str2, z, i, str3);
    }

    public static final ClientAppContext zza(ClientAppContext clientAppContext, String str, String str2, boolean z) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(str, str2, z, null, 0);
    }

    public static boolean zza(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return zza(this.zzc, clientAppContext.zzc) && zza(this.zzd, clientAppContext.zzd) && this.zze == clientAppContext.zze && zza(this.zzf, clientAppContext.zzf) && this.zza == clientAppContext.zza;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzc, this.zzd, Boolean.valueOf(this.zze), this.zzf, Integer.valueOf(this.zza)});
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.zzc, this.zzd, Boolean.valueOf(this.zze), this.zzf, Integer.valueOf(this.zza));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int e2 = i.j.e(parcel);
        i.j.u1(parcel, 1, this.zzb);
        i.j.z1(parcel, 2, this.zzc, false);
        i.j.z1(parcel, 3, this.zzd, false);
        i.j.o1(parcel, 4, this.zze);
        i.j.u1(parcel, 5, this.zza);
        i.j.z1(parcel, 6, this.zzf, false);
        i.j.F1(parcel, e2);
    }
}
