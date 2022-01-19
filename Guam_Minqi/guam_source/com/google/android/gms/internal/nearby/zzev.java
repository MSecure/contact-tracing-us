package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzev extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzev> CREATOR = new zzew();
    public IStatusCallback zza;

    public zzev() {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzev) {
            return ReactYogaConfigProvider.equal(this.zza, ((zzev) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = ReactYogaConfigProvider.beginObjectHeader(parcel);
        ReactYogaConfigProvider.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        ReactYogaConfigProvider.zzb(parcel, beginObjectHeader);
    }

    public zzev(zzeu zzeu) {
    }

    public zzev(IBinder iBinder) {
        this.zza = IStatusCallback.Stub.asInterface(iBinder);
    }
}
