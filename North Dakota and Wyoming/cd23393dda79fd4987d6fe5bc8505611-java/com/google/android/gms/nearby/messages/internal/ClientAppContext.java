package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3-eap */
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zzd();
    @Deprecated
    public final int zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final String zzf;

    static final ClientAppContext zza(ClientAppContext clientAppContext, String str, String str2, boolean z) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(str, str2, z, null, 0);
    }

    ClientAppContext(int i, String str, String str2, boolean z, int i2, String str3) {
        this.zzb = i;
        this.zzc = (String) Preconditions.checkNotNull(str);
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:"));
            String valueOf = String.valueOf(str2);
            str2 = valueOf.length() != 0 ? "0p:".concat(valueOf) : new String("0p:");
        }
        this.zzd = str2;
        this.zze = z;
        this.zza = i2;
        this.zzf = str3;
    }

    public ClientAppContext(String str, String str2, boolean z, String str3, int i) {
        this(1, str, str2, z, i, str3);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zzd, Boolean.valueOf(this.zze), this.zzf, Integer.valueOf(this.zza));
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

    private static boolean zza(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return TextUtils.isEmpty(str2);
        }
        return str.equals(str2);
    }

    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.zzc, this.zzd, Boolean.valueOf(this.zze), this.zzf, Integer.valueOf(this.zza));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zze);
        SafeParcelWriter.writeInt(parcel, 5, this.zza);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
