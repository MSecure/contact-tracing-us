package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.connection.AdvertisingOptions;

public final class l9 implements Parcelable.Creator<h9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final h9 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        String str2 = null;
        AdvertisingOptions advertisingOptions = null;
        IBinder iBinder3 = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < m1) {
            int readInt = parcel.readInt();
            switch (65535 & readInt) {
                case 1:
                    iBinder = i.j.Q0(parcel, readInt);
                    break;
                case 2:
                    iBinder2 = i.j.Q0(parcel, readInt);
                    break;
                case 3:
                    str = i.j.Q(parcel, readInt);
                    break;
                case 4:
                    str2 = i.j.Q(parcel, readInt);
                    break;
                case 5:
                    j = i.j.S0(parcel, readInt);
                    break;
                case 6:
                    advertisingOptions = (AdvertisingOptions) i.j.O(parcel, readInt, AdvertisingOptions.CREATOR);
                    break;
                case 7:
                    iBinder3 = i.j.Q0(parcel, readInt);
                    break;
                case 8:
                    bArr = i.j.F(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new h9(iBinder, iBinder2, str, str2, j, advertisingOptions, iBinder3, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ h9[] newArray(int i) {
        return new h9[i];
    }
}
