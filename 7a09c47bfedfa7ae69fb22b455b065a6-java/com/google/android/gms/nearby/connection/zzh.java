package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;

public final class zzh implements Parcelable.Creator<ConnectionOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ConnectionOptions createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        boolean z = false;
        boolean z2 = false;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        byte[] bArr = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = t.q2(parcel, readInt);
                    break;
                case 2:
                    z3 = t.q2(parcel, readInt);
                    break;
                case 3:
                    z4 = t.q2(parcel, readInt);
                    break;
                case 4:
                    z5 = t.q2(parcel, readInt);
                    break;
                case 5:
                    z6 = t.q2(parcel, readInt);
                    break;
                case 6:
                    z7 = t.q2(parcel, readInt);
                    break;
                case 7:
                    z8 = t.q2(parcel, readInt);
                    break;
                case 8:
                    z9 = t.q2(parcel, readInt);
                    break;
                case 9:
                    bArr = t.R(parcel, readInt);
                    break;
                case 10:
                    z2 = t.q2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new ConnectionOptions(z, z3, z4, z5, z6, z7, z8, z9, bArr, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionOptions[] newArray(int i) {
        return new ConnectionOptions[i];
    }
}
