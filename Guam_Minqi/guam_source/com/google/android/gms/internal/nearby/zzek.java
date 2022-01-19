package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-nearby@@18.0.3 */
public final class zzek implements Parcelable.Creator<zzej> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzej createFromParcel(Parcel parcel) {
        int validateObjectHeader = ReactYogaConfigProvider.validateObjectHeader(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        ExposureConfiguration exposureConfiguration = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = ReactYogaConfigProvider.createTypedList(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = ReactYogaConfigProvider.readIBinder(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = ReactYogaConfigProvider.createTypedList(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    exposureConfiguration = (ExposureConfiguration) ReactYogaConfigProvider.createParcelable(parcel, readInt, ExposureConfiguration.CREATOR);
                    break;
                case 5:
                    str = ReactYogaConfigProvider.createString(parcel, readInt);
                    break;
                case 6:
                    iBinder2 = ReactYogaConfigProvider.readIBinder(parcel, readInt);
                    break;
                default:
                    ReactYogaConfigProvider.skipUnknownField(parcel, readInt);
                    break;
            }
        }
        ReactYogaConfigProvider.ensureAtEnd(parcel, validateObjectHeader);
        return new zzej(arrayList, iBinder, arrayList2, exposureConfiguration, str, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzej[] newArray(int i) {
        return new zzej[i];
    }
}
