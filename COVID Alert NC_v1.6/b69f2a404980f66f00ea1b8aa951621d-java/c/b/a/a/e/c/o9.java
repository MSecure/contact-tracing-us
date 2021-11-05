package c.b.a.a.e.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.b.k.i;
import com.google.android.gms.nearby.connection.DiscoveryOptions;

public final class o9 implements Parcelable.Creator<k9> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final k9 createFromParcel(Parcel parcel) {
        int m1 = i.j.m1(parcel);
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        String str = null;
        DiscoveryOptions discoveryOptions = null;
        IBinder iBinder3 = null;
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
                    j = i.j.S0(parcel, readInt);
                    break;
                case 5:
                    discoveryOptions = (DiscoveryOptions) i.j.O(parcel, readInt, DiscoveryOptions.CREATOR);
                    break;
                case 6:
                    iBinder3 = i.j.Q0(parcel, readInt);
                    break;
                default:
                    i.j.g1(parcel, readInt);
                    break;
            }
        }
        i.j.W(parcel, m1);
        return new k9(iBinder, iBinder2, str, j, discoveryOptions, iBinder3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ k9[] newArray(int i) {
        return new k9[i];
    }
}
