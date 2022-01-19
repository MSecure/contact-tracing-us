package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzeg implements Parcelable.Creator<zzef> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzef createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 1) {
                iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
            } else if (i != 2) {
                ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
            } else {
                iBinder2 = ReactYogaConfigProvider.readIBinder(parcel, readInt);
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzef(iBinder, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzef[] newArray(int i) {
        return new zzef[i];
    }
}
