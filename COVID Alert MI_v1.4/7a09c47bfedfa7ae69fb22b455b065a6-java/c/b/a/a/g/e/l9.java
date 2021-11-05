package c.b.a.a.g.e;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.x.t;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class l9 implements Parcelable.Creator<h9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h9 createFromParcel(Parcel parcel) {
        int f3 = t.f3(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        String str2 = null;
        AdvertisingOptions advertisingOptions = null;
        IBinder iBinder3 = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < f3) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = t.s2(parcel, readInt);
                    break;
                case 2:
                    iBinder2 = t.s2(parcel, readInt);
                    break;
                case 3:
                    str = t.b0(parcel, readInt);
                    break;
                case 4:
                    str2 = t.b0(parcel, readInt);
                    break;
                case 5:
                    j = t.u2(parcel, readInt);
                    break;
                case 6:
                    advertisingOptions = (AdvertisingOptions) t.a0(parcel, readInt, AdvertisingOptions.CREATOR);
                    break;
                case 7:
                    iBinder3 = t.s2(parcel, readInt);
                    break;
                case 8:
                    bArr = t.R(parcel, readInt);
                    break;
                default:
                    t.O2(parcel, readInt);
                    break;
            }
        }
        t.i1(parcel, f3);
        return new h9(iBinder, iBinder2, str, str2, j, advertisingOptions, iBinder3, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h9[] newArray(int i) {
        return new h9[i];
    }
}
