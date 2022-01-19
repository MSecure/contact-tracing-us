package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zar;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zaj();
    public final int zaa;
    public final zar zab;

    public zak(int i, zar zar) {
        this.zaa = i;
        this.zab = zar;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zaa);
        ReactYogaConfigProvider.writeParcelable(parcel, 2, this.zab, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zak(zar zar) {
        this.zaa = 1;
        this.zab = zar;
    }
}
