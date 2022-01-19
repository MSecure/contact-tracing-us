package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.Objects$ToStringHelper;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
public class Feature extends AbstractSafeParcelable {
    @RecentlyNonNull
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();
    public final String zza;
    @Deprecated
    public final int zzb;
    public final long zzc;

    public Feature(@RecentlyNonNull String str, @RecentlyNonNull long j) {
        this.zza = str;
        this.zzc = j;
        this.zzb = -1;
    }

    @RecentlyNonNull
    public boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.zza;
            if (((str == null || !str.equals(feature.zza)) && (this.zza != null || feature.zza != null)) || getVersion() != feature.getVersion()) {
                return false;
            }
            return true;
        }
        return false;
    }

    @RecentlyNonNull
    public long getVersion() {
        long j = this.zzc;
        return j == -1 ? (long) this.zzb : j;
    }

    @RecentlyNonNull
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(getVersion())});
    }

    @RecentlyNonNull
    public String toString() {
        Objects$ToStringHelper stringHelper = ReactYogaConfigProvider.toStringHelper(this);
        stringHelper.add("name", this.zza);
        stringHelper.add("version", Long.valueOf(getVersion()));
        return stringHelper.toString();
    }

    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeString(parcel, 1, this.zza, false);
        ReactYogaConfigProvider.writeInt(parcel, 2, this.zzb);
        ReactYogaConfigProvider.writeLong(parcel, 3, getVersion());
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public Feature(@RecentlyNonNull String str, @RecentlyNonNull int i, @RecentlyNonNull long j) {
        this.zza = str;
        this.zzb = i;
        this.zzc = j;
    }
}
