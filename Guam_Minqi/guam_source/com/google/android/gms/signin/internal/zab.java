package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zab extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zab> CREATOR = new zaa();
    public final int zaa;
    public int zab;
    public Intent zac;

    public zab() {
        this.zaa = 2;
        this.zab = 0;
        this.zac = null;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.zab == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeInt(parcel, 1, this.zaa);
        ReactYogaConfigProvider.writeInt(parcel, 2, this.zab);
        ReactYogaConfigProvider.writeParcelable(parcel, 3, this.zac, i, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zab(int i, int i2, Intent intent) {
        this.zaa = i;
        this.zab = i2;
        this.zac = intent;
    }
}
