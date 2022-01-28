package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import java.util.ArrayList;

public final class b3 implements Parcelable.Creator<a3> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final a3 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        ArrayList arrayList = null;
        IBinder iBinder = null;
        ArrayList arrayList2 = null;
        ExposureConfiguration exposureConfiguration = null;
        String str = null;
        IBinder iBinder2 = null;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    arrayList = i.j.S(parcel, readInt, TemporaryExposureKey.CREATOR);
                    break;
                case 2:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 3:
                    arrayList2 = i.j.S(parcel, readInt, ParcelFileDescriptor.CREATOR);
                    break;
                case 4:
                    exposureConfiguration = (ExposureConfiguration) i.j.O(parcel, readInt, ExposureConfiguration.CREATOR);
                    break;
                case 5:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 6:
                    iBinder2 = i.j.Q0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new a3(arrayList, iBinder, arrayList2, exposureConfiguration, str, iBinder2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ a3[] newArray(int i) {
        return new a3[i];
    }
}
