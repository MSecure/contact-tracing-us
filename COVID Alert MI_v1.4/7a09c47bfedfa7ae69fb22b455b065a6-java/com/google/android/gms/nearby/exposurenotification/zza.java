package com.google.android.gms.nearby.exposurenotification;

import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import java.util.ArrayList;

public final class zza implements Parcelable.Creator<DailySummariesConfig> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DailySummariesConfig createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        ArrayList<Double> arrayList = null;
        ArrayList<Double> arrayList2 = null;
        ArrayList<Integer> arrayList3 = null;
        ArrayList<Double> arrayList4 = null;
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = t.V(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = t.V(parcel, readInt);
                    break;
                case 3:
                    arrayList3 = t.X(parcel, readInt);
                    break;
                case 4:
                    arrayList4 = t.V(parcel, readInt);
                    break;
                case 5:
                    i = t.t2(parcel, readInt);
                    break;
                case 6:
                    d2 = t.r2(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new DailySummariesConfig(arrayList, arrayList2, arrayList3, arrayList4, i, d2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DailySummariesConfig[] newArray(int i) {
        return new DailySummariesConfig[i];
    }
}
