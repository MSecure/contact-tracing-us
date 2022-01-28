package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;

public final class h3 implements Parcelable.Creator<g3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final g3 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        ExposureConfiguration exposureConfiguration = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 3) {
                iBinder = i.j.Q0(parcel, readInt);
            } else if (i != 4) {
                i.j.g1(parcel, readInt);
            } else {
                exposureConfiguration = (ExposureConfiguration) i.j.O(parcel, readInt, ExposureConfiguration.CREATOR);
            }
        }
        i.j.W(parcel, m1);
        return new g3(iBinder, exposureConfiguration);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g3[] newArray(int i) {
        return new g3[i];
    }
}
