package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import java.util.ArrayList;

public final class zza implements Parcelable.Creator<DailySummariesConfig> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummariesConfig createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        ArrayList<Double> arrayList = null;
        ArrayList<Double> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        ArrayList<Double> arrayList4 = null;
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = i.j.G(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = i.j.G(parcel, readInt);
                    break;
                case 3:
                    arrayList3 = i.j.K(parcel, readInt);
                    break;
                case 4:
                    arrayList4 = i.j.G(parcel, readInt);
                    break;
                case 5:
                    i = i.j.R0(parcel, readInt);
                    break;
                case 6:
                    d2 = i.j.P0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new DailySummariesConfig(arrayList, arrayList2, arrayList3, arrayList4, i, d2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummariesConfig[] newArray(int i) {
        return new DailySummariesConfig[i];
    }
}
