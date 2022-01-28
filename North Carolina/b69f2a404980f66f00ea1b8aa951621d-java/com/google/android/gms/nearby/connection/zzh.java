package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;

public final class zzh implements Parcelable.Creator<ConnectionOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ConnectionOptions createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
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
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    z = i.j.N0(parcel, readInt);
                    break;
                case 2:
                    z3 = i.j.N0(parcel, readInt);
                    break;
                case 3:
                    z4 = i.j.N0(parcel, readInt);
                    break;
                case 4:
                    z5 = i.j.N0(parcel, readInt);
                    break;
                case 5:
                    z6 = i.j.N0(parcel, readInt);
                    break;
                case 6:
                    z7 = i.j.N0(parcel, readInt);
                    break;
                case 7:
                    z8 = i.j.N0(parcel, readInt);
                    break;
                case 8:
                    z9 = i.j.N0(parcel, readInt);
                    break;
                case 9:
                    bArr = i.j.F(parcel, readInt);
                    break;
                case 10:
                    z2 = i.j.N0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new ConnectionOptions(z, z3, z4, z5, z6, z7, z8, z9, bArr, z2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionOptions[] newArray(int i) {
        return new ConnectionOptions[i];
    }
}
