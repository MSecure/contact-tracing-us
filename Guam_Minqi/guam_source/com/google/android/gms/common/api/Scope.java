package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Scope> CREATOR = new zza();
    public final int zza;
    public final String zzb;

    public Scope(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.zza = i;
            this.zzb = str;
            return;
        }
        throw new IllegalArgumentException("scopeUri must not be null or empty");
    }

    @RecentlyNonNull
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.zzb.equals(((Scope) obj).zzb);
    }

    @RecentlyNonNull
    public final int hashCode() {
        return this.zzb.hashCode();
    }

    @RecentlyNonNull
    public final String toString() {
        return this.zzb;
    }

    public final void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zza);
        ReactYogaConfigProvider.writeString(parcel, 2, this.zzb, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
