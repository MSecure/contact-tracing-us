package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzew implements Parcelable.Creator<zzev> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzev createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        IBinder iBinder = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzev(iBinder);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzev[] newArray(int i) {
        return new zzev[i];
    }
}
