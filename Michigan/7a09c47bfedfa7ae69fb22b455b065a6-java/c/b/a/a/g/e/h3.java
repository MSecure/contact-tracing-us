package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;

public final class h3 implements Parcelable.Creator<g3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final g3 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        ExposureConfiguration exposureConfiguration = null;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            int i = 65535 & readInt;
            if (i == 3) {
                iBinder = t.s2(parcel, readInt);
            } else if (i != 4) {
                t.O2(parcel, readInt);
            } else {
                exposureConfiguration = (ExposureConfiguration) t.a0(parcel, readInt, ExposureConfiguration.CREATOR);
            }
        }
        t.i1(parcel, f3);
        return new g3(iBinder, exposureConfiguration);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ g3[] newArray(int i) {
        return new g3[i];
    }
}
