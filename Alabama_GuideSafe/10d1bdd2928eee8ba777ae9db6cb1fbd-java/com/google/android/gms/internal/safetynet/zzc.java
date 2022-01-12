package com.google.android.gms.internal.safetynet;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public class zzc {
    static {
        zzc.class.getClassLoader();
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void zza(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }
}
