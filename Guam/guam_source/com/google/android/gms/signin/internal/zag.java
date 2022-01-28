package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
public final class zag extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zai();
    public final List<String> zaa;
    public final String zab;

    public zag(List<String> list, String str) {
        this.zaa = list;
        this.zab = str;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        if (this.zab != null) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        List<String> list = this.zaa;
        if (list != null) {
            int zza = ReactYogaConfigProvider.zza(parcel, 1);
            parcel.writeStringList(list);
            ReactYogaConfigProvider.zzb(parcel, zza);
        }
        ReactYogaConfigProvider.writeString(parcel, 2, this.zab, false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }
}
