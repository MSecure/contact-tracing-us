package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zas;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zal();
    public final int zaa;
    public final ConnectionResult zab;
    public final zas zac;

    public zam(int i, ConnectionResult connectionResult, zas zas) {
        this.zaa = i;
        this.zab = connectionResult;
        this.zac = zas;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zaa);
        ReactYogaConfigProvider.writeParcelable(parcel, 2, this.zab, i, false);
        ReactYogaConfigProvider.writeParcelable(parcel, 3, this.zac, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zam() {
        ConnectionResult connectionResult = new ConnectionResult(8, null);
        this.zaa = 1;
        this.zab = connectionResult;
        this.zac = null;
    }
}
